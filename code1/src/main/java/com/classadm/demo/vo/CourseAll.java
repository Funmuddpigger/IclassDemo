package com.classadm.demo.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.sql.Time;
import java.sql.Timestamp;

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

    @TableId(value = "course_id", type = IdType.AUTO)
    private String courseId;
    private String courseName;
    private String courseTea;
    private Time courseStarttime;
    private Time courseEndtime;
    private String courseWeek;
    private String classId;
    private String courseOddEven;
    private int courseStartWeek;
    private int courseEndWeek;
}
