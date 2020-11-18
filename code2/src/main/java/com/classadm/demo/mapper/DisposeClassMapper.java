package com.classadm.demo.mapper;


import com.classadm.demo.entity.Audit;
import com.classadm.demo.entity.ClassAll;
import com.classadm.demo.entity.Matching;
import com.classadm.demo.vo.ClassInout;
import com.classadm.demo.vo.CourseAll;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;

@Mapper
@Repository
public interface DisposeClassMapper {
    List<ClassAll> judgeClass(String class_id);

    List<Matching> gainMatching();

    List<CourseAll> gainCourse_all();

    List<Audit> gainAudit();

    List<ClassInout> gainClass_inout();

    List<ClassAll> lookClass(String class_status,int capacityFloor,int capacityUpper,String classProperty);

    void addAudit(String class_id, int user_id, String user_name, Timestamp class_goTime, Timestamp class_backTime, int audit_number, String class_note, String class_property);

    List<CourseAll> judgeCourse_All(String class_id, Time course_StartTime, Time course_EndTime, String course_OddEven,int howWeek,String severalWeeks);

    List<Audit> judgeAudit(String class_id, Timestamp class_goTime, Timestamp class_backTime);

    List<ClassInout> judgeClass_Inout(String class_id, Timestamp class_goTime, Timestamp class_backTime);

}











