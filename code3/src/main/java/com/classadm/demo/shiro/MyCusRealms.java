package com.classadm.demo.shiro;

import com.classadm.demo.entity.SysPermissions;
import com.classadm.demo.entity.SysRoles;
import com.classadm.demo.entity.SysUsers;
import com.classadm.demo.jwt.JwtToken;
import com.classadm.demo.service.SysUsersService;
import com.classadm.demo.util.ApplicationContextUtils;
import com.classadm.demo.util.JwtUtils;
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
    public boolean supports(AuthenticationToken token) {
        return null != token && token instanceof JwtToken;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("=============shiro===========");
        //获取身份信息
        //String primaryPrincipal = (String) principalCollection.getPrimaryPrincipal();
        String token = principalCollection.toString();
        //根据token获取权限授权
        String userName = JwtUtils.getUserName(token);
        SysUsersService sysUsersService = (SysUsersService) ApplicationContextUtils.getBean("sysUsersServiceImpl");
        SysUsers users = sysUsersService.selectrolesByName(userName);
        System.out.println(users);
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
            System.out.println(simpleAuthorizationInfo);
            return simpleAuthorizationInfo;
        }
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //获取用户信息
        //getCredentials getPrincipal getToken 都是返回jwt生成的token串
        String token = (String) authenticationToken.getCredentials();
        SysUsersService sysUsersService = (SysUsersService) ApplicationContextUtils.getBean("sysUsersServiceImpl");

        String username = JwtUtils.getUserName(token);
        if (username == null) {
            throw new AccountException("token invalid");
        }
        //如果需要可以根据业务实现db操作,这里根据service写死
        SysUsers sysUsers = sysUsersService.selectByName(username);

        if (!JwtUtils.verify(username, sysUsers.getUserPassword(), token)) {
            throw new UnknownAccountException("Username or password error");
        }

        return new SimpleAuthenticationInfo(token, token,getName());
    }
}
