package com.classadm.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.classadm.demo.entity.SysRolesPermissions;
import com.classadm.demo.entity.SysUsersRoles;

public interface SysRolesPermissionsMapper extends BaseMapper<SysRolesPermissions> {

    public int updateRolesPermission(SysRolesPermissions sysRolesPermissions);

    public int addRolesPermissions(SysRolesPermissions sysRolesPermissions);

    public int deletedRolesPermissions(SysRolesPermissions sysRolesPermissions);
}
