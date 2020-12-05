package com.classadm.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
public class SysRolesPermissions implements Serializable {

    @TableId(value = "rolePermissionId",type = IdType.AUTO)
    private int rolePermissionId;

    private int roleId;

    private int permissionId;

}
