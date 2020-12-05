package com.classadm.demo.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.classadm.demo.entity.SysUsersRoles;
import com.classadm.demo.service.SysUsersRolesService;
import com.classadm.demo.util.Result;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class SysUsersRolesController {

    @Autowired
    SysUsersRolesService sysUsersRolesService;

    //添加用户并分配角色

    @RequestMapping(value = "/addUsersRoles", method = {RequestMethod.POST})
    public Result addUsersRoles(@RequestBody JSONObject jsonParams) {
        SysUsersRoles sysUsersRoles = new SysUsersRoles();

        String json = jsonParams.toJSONString();
        JSONObject jsonObject = jsonParams.parseObject(json);
        JSONArray jsonArray = jsonObject.getJSONArray("data");
        for(int i=0;i<jsonArray.size();i++){

            JSONObject object = jsonArray.getJSONObject(i);

            Integer userId = object.getInteger("userId");
            Integer roleId=  object.getInteger("roleId");
            //Integer userRole = object.getInteger("userRoleId");

            sysUsersRoles.setUserId(userId);
            sysUsersRoles.setRoleId(roleId);
          //  sysUsersRoles.setUserRoleId(userRole);

            System.out.println(sysUsersRoles);
            sysUsersRolesService.addUsersRoles(sysUsersRoles);
        }
     return Result.success("添加用户[[ "+sysUsersRoles.getUserId()+" ]]成功！");
    }

    //更新字段
    @RequestMapping(value = "/updateUsersRoles",method = {RequestMethod.POST,RequestMethod.GET})
    public Result updateSysUsersRoles(@RequestBody JSONObject jsonParams){
        SysUsersRoles sysUsersRoles = new SysUsersRoles();

        String json = jsonParams.toJSONString();
        JSONObject jsonObject = jsonParams.parseObject(json);
        JSONArray jsonArray = jsonObject.getJSONArray("data");
        for(int i=0;i<jsonArray.size();i++){

            JSONObject object = jsonArray.getJSONObject(i);

            Integer userRoleId =object.getInteger("userRoleId");
            Integer userId = object.getInteger("userId");
            Integer roleId=  object.getInteger("roleId");

            sysUsersRoles.setUserRoleId(userRoleId);
            sysUsersRoles.setUserId(userId);
            sysUsersRoles.setRoleId(roleId);
            System.out.println(sysUsersRoles);
            sysUsersRolesService.updateUsersRoles(sysUsersRoles);

        }
        return Result.success("更新userRoleId:[["+sysUsersRoles.getUserRoleId()+"]]成功!");
    }

    @RequestMapping("/deleteUsersRoles")
    public Result deleteUsersRoles(@RequestBody JSONObject jsonParams){
        SysUsersRoles sysUsersRoles = new SysUsersRoles();
        String json = jsonParams.toString();
        JSONObject jsonObject = jsonParams.parseObject(json);
        JSONArray jsonArray = jsonObject.getJSONArray("data");
        for(int i=0;i<jsonArray.size();i++){
            JSONObject object= jsonArray.getJSONObject(i);
            Integer userRoleId = object.getInteger("userRoleId");
            sysUsersRoles.setUserRoleId(userRoleId);
            sysUsersRolesService.deletedUsersRoles(sysUsersRoles);
        }
     return Result.success("删除[[ "+sysUsersRoles.getUserRoleId()+" ]]成功!");
    }


}
