package com.classadm.demo.mapper;

import com.classadm.demo.entity.SysPermissions;
import com.classadm.demo.entity.SysUsers;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author mine
 * @since 2020-09-19
 */
public interface SysUsersMapper extends BaseMapper<SysUsers> {
    //账号查询
    public SysUsers selectByName(String username);
    //获取角色信息
    public SysUsers selectrolesByName(String username);
    //获取角色权限
    public List<SysPermissions> selectPersByRoleId(Integer id);

}
