package com.classadm.demo.service;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

public interface DisposeClassService {
    //随机分配
    String randomClass(String class_id, int user_id, String user_name, Timestamp apply_goTime, Timestamp apply_backTime, String class_type, String class_note, String class_property,int howWeek,String severalWeeks);
    //判断是否有存在相交记录
    boolean judgeTime(String class_id,Timestamp time_goOne,Timestamp time_backOne,int howWeek,String severalWeeks);
    //分配
    String  distributionClass(String class_id, int user_id, String user_name, Date class_goTime, Date class_backTime,String class_note, int number_people,int howWeek,String severalWeeks);


    //判断与课表是否有相交记录
    boolean judgeRecord(String class_id, Timestamp course_StartTime, Timestamp course_EndTime,int howWeek,String severalWeeks);

}
