package com.classadm.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.sql.Timestamp;
import java.time.LocalTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 *
 * </p>
 *
 * @author mine
 * @since 2020-09-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class CourseAll implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 课程id,primary key

     */
    @TableId(value = "course_id", type = IdType.AUTO)
    private String courseId;

    /**
     * 课程名称
     */
    private String courseName;

    private String courseTea;

    /**
     * 课程上课时间
     */
    private Timestamp courseStarttime;

    /**
     * 课程下课时间
     */
    private Timestamp courseEndtime;

    /**
     * 周几,英文,Monday.etc

     */
    private String courseWeek;

    /**
     * 占用的课室编号
     */
    private String classId;

}
