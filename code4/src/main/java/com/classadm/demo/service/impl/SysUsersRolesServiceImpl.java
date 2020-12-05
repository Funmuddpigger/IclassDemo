package com.classadm.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.classadm.demo.entity.SysUsersRoles;
import com.classadm.demo.mapper.SysUsersRolesMapper;
import com.classadm.demo.service.SysUsersRolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysUsersRolesServiceImpl extends ServiceImpl<SysUsersRolesMapper, SysUsersRoles> implements SysUsersRolesService {

    @Autowired
    SysUsersRolesMapper sysUsersRolesMapper;

    @Override
    public int updateUsersRoles(SysUsersRoles sysUsersRoles) {
        return sysUsersRolesMapper.updateUsersRoles(sysUsersRoles);
    }

    @Override
    public int addUsersRoles(SysUsersRoles sysUsersRoles) {
        return sysUsersRolesMapper.addUsersRoles(sysUsersRoles);
    }

    @Override
    public int deletedUsersRoles(SysUsersRoles sysUsersRoles) {
        return sysUsersRolesMapper.deletedUsersRoles(sysUsersRoles);
    }
}
