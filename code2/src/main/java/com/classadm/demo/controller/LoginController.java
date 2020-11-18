package com.classadm.demo.controller;

import com.classadm.demo.service.SysUsersService;
import com.classadm.demo.util.Result;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user")
public class LoginController {

    @Autowired
    SysUsersService sysUsersService;

    @RequestMapping(value = "/login" ,method = {RequestMethod.GET,RequestMethod.POST})
    public Result login(String username,String password) {
        //service逻辑
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(new UsernamePasswordToken(username,password));//登陆成功保存token
            Result loginresult = Result.success("登陆成功", sysUsersService.selectrolesByName(username));
            return loginresult;
        }catch (UnknownAccountException e){
            return Result.authorizationfail("用户不存在");
        }catch (IncorrectCredentialsException e){
            return Result.authorizationfail("密码错误");
        }
    }

}
