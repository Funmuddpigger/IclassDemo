package com.classadm.demo.service.impl;



import com.classadm.demo.entity.Audit;
import com.classadm.demo.entity.ClassAll;
import com.classadm.demo.entity.Matching;
import com.classadm.demo.mapper.DisposeClassMapper;
import com.classadm.demo.service.DisposeClassService;
import com.classadm.demo.vo.ClassInout;
import com.classadm.demo.vo.CourseAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
public class DisposeClassServiceImpl implements DisposeClassService {
    @Autowired
    private DisposeClassMapper disposeClassMapper;
    private ClassAll classAll;

    //随机分配
    public String randomClass(String class_id, int user_id, String user_name, Timestamp apply_goTime,
                              Timestamp apply_backTime, int number_people, String class_note,
                              String class_property,int howWeek,String severalWeeks){
        List<ClassAll> classMessageList = disposeClassMapper.judgeClass(class_id);
        for(int j=number_people+10;j<=number_people+90;j+=20){
            List<ClassAll> lookClassList = disposeClassMapper.lookClass("可用",j,j+20,class_property);
            for(int i=0;i<lookClassList.size();i++){
                if (judgeTime(lookClassList.get(i).getClassId(),apply_goTime,apply_backTime,howWeek,severalWeeks)) {
                    disposeClassMapper.addAudit(lookClassList.get(i).getClassId(), user_id, user_name, apply_goTime,apply_backTime,0, class_note, class_property);
                    class_id=lookClassList.get(i).getClassId();
                    break;
                }
            }
        }
        return class_id;

    }
    //判断是否有存在相交记录
    public  boolean judgeTime(String class_id,Timestamp time_goOne,Timestamp time_backOne,int howWeek,String severalWeeks){
        //true:可以用

        List<ClassInout>   recordList = disposeClassMapper.gainClass_inout();
        List<Audit>   auditList = disposeClassMapper.gainAudit();
        List<CourseAll>   curriculumList = disposeClassMapper.gainCourse_all();
        boolean record_boolean=true;//true:没有时间相交
        boolean audit_boolean=true;
        boolean curriculum_boolean=true;
        for(int i=0;i<recordList.size();i++){
            if(recordList.get(i).getClassId().equals(class_id))
               if( judgeTime(time_goOne,time_backOne,recordList.get(i).getClassGoTime(),recordList.get(i).getClassBackTime())){
                  record_boolean=false;
                   break;
           }
        }
        for(int i=0;i<auditList.size();i++){
            if(auditList.get(i).getClassId().equals(class_id))
            if( judgeTime(time_goOne,time_backOne,auditList.get(i).getClassGoTime(),auditList.get(i).getClassBackTime())){
                audit_boolean=false;
                break;
            }
        }


       if(judgeRecord(class_id,time_goOne,time_backOne,howWeek,severalWeeks)){
           curriculum_boolean=true;
       }else {
           curriculum_boolean=false;
       }


        if((record_boolean&&audit_boolean&&curriculum_boolean)){
            return true;
        }else {
            return false;
        }
    }
    //分配
     public  String  distributionClass(String class_id, int user_id, String user_name, Date class_goTime, Date class_backTime,String class_note, int number_people,int howWeek,String severalWeeks){
         Timestamp apply_goTime = new Timestamp(class_goTime.getTime());
         Timestamp apply_backTime = new Timestamp(class_backTime.getTime());
         List<ClassAll> classMessageList = disposeClassMapper.judgeClass(class_id);
         classAll = classMessageList.get(0);
         String class_property = classAll.getClassProperty();
         if (classAll.getClassStatus().equals("可用")) {
             if (judgeTime(class_id,apply_goTime,apply_backTime,howWeek,severalWeeks)) {
                 disposeClassMapper.addAudit(class_id, user_id, user_name,apply_goTime,apply_backTime,0, class_note, class_property);
                 return class_id;
             } else {
                 String result=randomClass(class_id,user_id,user_name,apply_goTime,apply_backTime,number_people,class_note,class_property,howWeek,severalWeeks);
                 if(result.equals(class_id)) {
                     return "406";
                 }
                 else {
                     return result;
                 }
             }
         } else {
             String result=randomClass(class_id,user_id,user_name,apply_goTime,apply_backTime,number_people,class_note,class_property,howWeek,severalWeeks);
             if(result.equals(class_id)) {
                 return "406";
             }
             else {
                 return result;
             }
         }
     }
     //判断两段时间是否相交
    public boolean judgeTime(Timestamp time_goOne,Timestamp time_backOne,Timestamp time_goOneTwo,Timestamp time_backTwo){
        if((time_goOne.getTime()<time_backTwo.getTime()&&time_backOne.getTime()>time_goOneTwo.getTime())) {
            return true;
        }else {
            return false;
        }
    }

     //判断是否与课程有相交记录

    public boolean judgeRecord(String class_id, Timestamp course_StartTime, Timestamp course_EndTime,int howWeek,String severalWeeks) {
        int h1=course_StartTime.getHours();
        int m1=course_StartTime.getMinutes();
        int s1=course_StartTime.getSeconds();
        int h2=course_EndTime.getHours();
        int m2=course_EndTime.getMinutes();
        int s2=course_EndTime.getSeconds();
        Time time1 = new Time(h1,m1,s1);
        Time time2 = new Time(h2,m2,s2);
        String oddEvenWeek;
        if(howWeek%2!=0){
            oddEvenWeek="单";
        }else {
            oddEvenWeek="双";
        }
        List<CourseAll> courseAllList = disposeClassMapper.judgeCourse_All(class_id,time1,time2,oddEvenWeek,howWeek,severalWeeks);

        if(courseAllList.size()==0){
            return  true;
        }
        else {
            return false;
        }
    }

}
