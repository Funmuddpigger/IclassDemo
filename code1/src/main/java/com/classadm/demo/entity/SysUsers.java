package com.classadm.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author mine
 * @since 2020-09-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SysUsers implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String userUsername;

    private String userPassword;

    /**
     * 加密
     */
    private String salt;

    private String icon;

    private String address;

    /**
     * 地址
     */
    private String locaed;

    private List<SysRoles> roles;

}
