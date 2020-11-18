package com.classadm.demo.entity;

import java.io.Serializable;
import java.util.List;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 *
 * </p>
 *
 * @author mine
 * @since 2020-08-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ClassAll implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "class_id")
    private String classId;

    private String classType;

    private String classStatus;

    private Integer classCapacity;

    private String classProperty;

    private String classNote;

    private List<CourseAll> courseAlls;

}
