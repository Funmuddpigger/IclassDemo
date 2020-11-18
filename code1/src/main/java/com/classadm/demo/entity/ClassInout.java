package com.classadm.demo.entity;


import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;


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

    @TableField(fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="Asia/Shanghai")
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Timestamp classGotime;

    @TableField(fill = FieldFill.UPDATE)
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
   @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="Asia/Shanghai")
    private Timestamp classBacktime;

    private String classStatue;

    @TableField(fill = FieldFill.INSERT)
    private String classMaster;

    private Integer userId;
}
