package com.classadm.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.classadm.demo.entity.SysUsersRoles;

public interface SysUsersRolesService extends IService<SysUsersRoles> {

    //更新操作
    public int updateUsersRoles(SysUsersRoles sysUsersRoles);
    //添加用户
    public int addUsersRoles(SysUsersRoles sysUsersRoles);
    //删除
    public int deletedUsersRoles(SysUsersRoles sysUsersRoles);
}
