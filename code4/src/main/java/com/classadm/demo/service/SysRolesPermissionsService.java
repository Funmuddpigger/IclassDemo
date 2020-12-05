package com.classadm.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.classadm.demo.entity.SysRolesPermissions;
import com.classadm.demo.entity.SysUsersRoles;

public interface SysRolesPermissionsService extends IService<SysRolesPermissions> {


    public int addRolesPermissions(SysRolesPermissions sysRolesPermissions);

    public int updateRolesPermission(SysRolesPermissions sysRolesPermissions);


    public int deletedRolesPermissions(SysRolesPermissions sysRolesPermissions);
}
