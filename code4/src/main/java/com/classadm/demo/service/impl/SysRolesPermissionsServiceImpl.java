package com.classadm.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.classadm.demo.entity.SysRolesPermissions;
import com.classadm.demo.entity.SysUsersRoles;
import com.classadm.demo.mapper.SysRolesPermissionsMapper;
import com.classadm.demo.service.SysRolesPermissionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysRolesPermissionsServiceImpl extends ServiceImpl<SysRolesPermissionsMapper, SysRolesPermissions> implements SysRolesPermissionsService {
   @Autowired
   SysRolesPermissionsMapper sysRolesPermissionsMapper;

    @Override
    public int addRolesPermissions(SysRolesPermissions sysRolesPermissions) {
        return sysRolesPermissionsMapper.addRolesPermissions(sysRolesPermissions);
    }

    @Override
    public int updateRolesPermission(SysRolesPermissions sysRolesPermissions) {
        return sysRolesPermissionsMapper.updateRolesPermission(sysRolesPermissions);
    }

    @Override
    public int deletedRolesPermissions(SysRolesPermissions sysRolesPermissions) {
        return sysRolesPermissionsMapper.deletedRolesPermissions(sysRolesPermissions);
    }
}
