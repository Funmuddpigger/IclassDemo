package com.classadm.demo.service;

import com.classadm.demo.entity.SysPermissions;
import com.classadm.demo.entity.SysUsers;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author mine
 * @since 2020-09-19
 */
public interface SysUsersService extends IService<SysUsers> {
    //根据用户名查询
    SysUsers selectByName(String name);
    //用户名查询角色
    SysUsers selectrolesByName(String username);
    //角色查权限
    List<SysPermissions> selectPersByRoleId(Integer id);

    // int insert(SysUsers sysUsers);
    int insertUser(SysUsers sysUsers);

    public int deleteUser(SysUsers sysUsers);

    public SysUsers getUserName(String username);

    public int updateByUsername(SysUsers sysUsers);

    public List<SysUsers> findAllUser();
}
