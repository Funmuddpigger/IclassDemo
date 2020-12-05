package com.classadm.demo.service.impl;

import com.classadm.demo.entity.SysPermissions;
import com.classadm.demo.entity.SysUsers;
import com.classadm.demo.mapper.SysUsersMapper;
import com.classadm.demo.service.SysUsersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author mine
 * @since 2020-09-19
 */
@Service
public class SysUsersServiceImpl extends ServiceImpl<SysUsersMapper, SysUsers> implements SysUsersService {

    @Autowired
    SysUsersMapper sysUsersMapper;

    @Override
    public SysUsers selectByName(String name) {
        return sysUsersMapper.selectByName(name);
    }

    @Override
    public SysUsers selectrolesByName(String username) {
        return sysUsersMapper.selectrolesByName(username);
    }

    @Override
    public List<SysPermissions> selectPersByRoleId(Integer id) {
        return sysUsersMapper.selectPersByRoleId(id);
    }

    @Override
    public int insertUser(SysUsers sysUsers) {
        return sysUsersMapper.insertUser(sysUsers);
    }

    @Override
    public int deleteUser(SysUsers sysUsers) {
        return sysUsersMapper.deleteUser(sysUsers);
    }

    @Override
    public SysUsers getUserName(String username) {
        return sysUsersMapper.getUserName(username);
    }

    @Override
    public int updateByUsername(SysUsers sysUsers) {
        return sysUsersMapper.updateByUsername(sysUsers);
    }

    @Override
    public List<SysUsers> findAllUser() {
        return sysUsersMapper.findAllUser();
    }
}
