package com.classadm.demo.vo;


import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.sql.Timestamp;


/**
 * <p>
 *
 * </p>
 *
 * @author mine
 * @since 2020-08-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ClassInout implements Serializable {

    private static final long serialVersionUID = 1L;


    private String classId;

    /**
     * 特殊:音乐室,实验室,图书馆etc..  普通:大中小
     */
    private String classType;

    /**
     * 特殊/普通
     */
    private String classProperty;

    private Timestamp classGotime;

    private Timestamp classBacktime;

    private String classStatue;

    @TableField(fill = FieldFill.INSERT)
    private String classMaster;

    private Integer userId;
/*
    public String getClassId() {
        return classId;
    }

    public Timestamp getClassBackTime() {
        return classBackTime;
    }

    public Timestamp getClassGoTime() {
        return classGoTime;
    }*/

}
