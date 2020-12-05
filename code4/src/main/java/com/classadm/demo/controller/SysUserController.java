package com.classadm.demo.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.classadm.demo.entity.SysUsers;
import com.classadm.demo.mapper.SysUsersMapper;
import com.classadm.demo.service.SysUsersService;
import com.classadm.demo.util.Result;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/user")
public class SysUserController {

    @Autowired
    SysUsersService sysUsersService;


    /**
     * 导入用户
     * @param jsonparam
     * @return
     */
    @RequestMapping(value = "/insertUser", method = {RequestMethod.GET, RequestMethod.POST},produces = "application/json;charset=UTF-8")
    public Result insert(@RequestBody JSONObject jsonparam) {
        SysUsers user = new SysUsers();
        String json = jsonparam.toJSONString();
        //String字符串转化为Json数组
        JSONObject jsonObject = JSONObject.parseObject(json);
        JSONArray jsonArray = jsonObject.getJSONArray("data");
        System.out.println(jsonArray);
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject object = jsonArray.getJSONObject(i);

           // String userId = object.getString("id");
            String userName = object.getString("userUsername");
            String userPassword = object.getString("userPassword");
            String salt = object.getString("salt");
            String deleted =object.getString("deleted");
            String counsellor = object.getString("counsellor");


            user.setUserUsername(userName);
            user.setUserPassword(userPassword);
            user.setSalt(salt);
            user.setDeleted(Integer.valueOf(deleted));
            user.setCounsellor(counsellor);

            sysUsersService.insertUser(user);
            System.out.println(user);
        }
        return Result.success("插入成功");
    }

    /**
     *  更新用户信息
     * @param jsonparam
     * @return
     */
    @RequestMapping(value = "/updateUser", method = {RequestMethod.GET, RequestMethod.POST})
    public Result update(@RequestBody JSONObject jsonparam) {
        SysUsers user = new SysUsers();
        String json = jsonparam.toJSONString();
        //String字符串转化为Json数组
        JSONObject jsonObject = JSONObject.parseObject(json);
        JSONArray jsonArray = jsonObject.getJSONArray("data");

        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject object = jsonArray.getJSONObject(i);

         //   String userId = object.getString("id");
            String userName = object.getString("userUsername");
            String userPassword = object.getString("userPassword");
            String salt = object.getString("salt");
            String deleted=object.getString("deleted");
            String counsellor=object.getString("counsellor");
          //  user.setId(Integer.valueOf(userId));
            user.setUserUsername(userName);
            user.setUserPassword(userPassword);
            user.setSalt(salt);
            user.setDeleted(Integer.valueOf(deleted));
            user.setCounsellor(counsellor);

             sysUsersService.updateByUsername(user);
            System.out.println(user);
        }
        return Result.success("更新id值: [[" + user.getUserUsername() + "]]成功!");
    }


    /**
     *根据id删除用户
     * @param jsonParams
     * @return
     */
    @RequestMapping(value = "deleteUser",method = {RequestMethod.POST,RequestMethod.GET})
    public Result delete(@RequestBody JSONObject jsonParams){
        SysUsers user = new SysUsers();
        String json = jsonParams.toJSONString();
        JSONObject jsonObject = jsonParams.parseObject(json);
        JSONArray jsonArray = jsonObject.getJSONArray("data");
        for (int i=0;i<jsonArray.size();i++) {
            JSONObject object = jsonArray.getJSONObject(i);
            String username = object.getString("userUsername");
             user.setUserUsername(username);
            sysUsersService.deleteUser(user);
            System.out.println("删除用户[[:  "+user.getUserUsername()+"  ]]成功!");
        }
        return Result.success("删除记录成功!");
    }


  //查询所有用户
    @RequiresRoles("普通用户")
    @RequestMapping(value = "findAllUser",method = {RequestMethod.GET})
    public Result findUserAll(){
        List<SysUsers> userAll = sysUsersService.findAllUser();
        System.out.println(userAll);
        return Result.success("用户列表",userAll);
    }

    @RequestMapping(value = "/401", method = RequestMethod.GET)
    public Result error_401(){
        return Result.authorizationfail("认证失败");
    }



}