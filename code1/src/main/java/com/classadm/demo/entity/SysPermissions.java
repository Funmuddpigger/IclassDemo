package com.classadm.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
public class SysPermissions implements Serializable {

    @TableId(value = "permission_id", type = IdType.AUTO)
    private Integer permissionId;

    private String name;

    private String url;

    private String type;

    private Integer pid;

    private String available;

    private List<SysRoles> roles;// 一个权限对应一个角色
}
