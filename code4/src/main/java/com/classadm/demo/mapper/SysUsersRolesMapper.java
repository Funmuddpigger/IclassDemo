package com.classadm.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.classadm.demo.entity.SysUsersRoles;

public interface SysUsersRolesMapper extends BaseMapper<SysUsersRoles> {

    //更新
    public int updateUsersRoles(SysUsersRoles sysUsersRoles);

    //增加
    public int addUsersRoles(SysUsersRoles sysUsersRoles);
    //删除
    public int deletedUsersRoles(SysUsersRoles sysUsersRoles);
}
