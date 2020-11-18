package com.classadm.demo.shiro;

import com.classadm.demo.entity.SysPermissions;
import com.classadm.demo.entity.SysUsers;
import com.classadm.demo.service.SysUsersService;
import com.classadm.demo.util.ApplicationContextUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.apache.shiro.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;


import java.util.List;



public class MyCusRealms extends AuthorizingRealm {

    @Autowired
    SysUsersService sysUsersService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("=============shiro===========");
        //获取身份信息
        String primaryPrincipal = (String) principalCollection.getPrimaryPrincipal();
        SysUsersService sysUsersService = (SysUsersService) ApplicationContextUtils.getBean("sysUsersServiceImpl");
        SysUsers users = sysUsersService.selectrolesByName(primaryPrincipal);

        //添加角色信息
        if(!CollectionUtils.isEmpty(users.getRoles())){
            SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
            users.getRoles().forEach(sysRoles -> {

                simpleAuthorizationInfo.addRole(sysRoles.getRoleName());

                //权限信息
                List<SysPermissions> permissions = sysUsersService.selectPersByRoleId(sysRoles.getRoleId());
                if(!CollectionUtils.isEmpty(permissions)){
                    permissions.forEach(sysPermissions -> {
                        simpleAuthorizationInfo.addStringPermission(sysPermissions.getName());
                    });
                }

            });
            return simpleAuthorizationInfo;
        }
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //获取用户信息
        String principal = (String) authenticationToken.getPrincipal();
        //从数据库中查询用户
        SysUsersService sysUsersService=(SysUsersService)ApplicationContextUtils.getBean("sysUsersServiceImpl");
        //System.out.println(sysUsersService);
        SysUsers user = sysUsersService.selectByName(principal);
        if (!ObjectUtils.isEmpty(user)) {
            return new SimpleAuthenticationInfo(user.getUserUsername(),user.getUserPassword(),ByteSource.Util.bytes(user.getSalt()),this.getName());
        }
        throw new UnknownAccountException();
    }
}
