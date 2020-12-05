package com.classadm.demo.controller;

import com.classadm.demo.entity.SysUsers;
import com.classadm.demo.service.SysUsersService;
import com.classadm.demo.util.JwtUtils;
import com.classadm.demo.util.Result;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;


@RestController
@RequestMapping("/user")
public class LoginController {

    @Autowired
    SysUsersService sysUsersService;



    @RequestMapping(value = "/login" ,method = {RequestMethod.GET,RequestMethod.POST})
    public Result login(String username, String password, HttpServletResponse response) {

        SysUsers user = sysUsersService.selectByName(username);

        if(user.getUserPassword().equals(password)){
            String token = JwtUtils.createToken(username,password);
            response.setHeader("token",token);

            return Result.success("登录成功!",sysUsersService.selectrolesByName(username),token);
        }else{
            return Result.certificationfail("认证失败");
        }
    }
    @RequestMapping(path = "/401")
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public Result unauthorized() {
        return Result.certificationfail("认证失败,未授权");

    }

}
