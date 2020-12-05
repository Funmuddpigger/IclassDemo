package com.classadm.demo.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.classadm.demo.entity.SysRolesPermissions;
import com.classadm.demo.entity.SysUsersRoles;
import com.classadm.demo.service.SysRolesPermissionsService;
import com.classadm.demo.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *更新角色和权限
 */
@RestController
@RequestMapping("/user")
public class SysRolesPermissionsController {

    @Autowired
    SysRolesPermissionsService sysRolesPermissionsService;


    @RequestMapping(value = "/addRolesPermissions", method = {RequestMethod.POST})
    public Result addRolesPermissions(@RequestBody JSONObject jsonParams) {
        SysRolesPermissions sysRolesPermissions = new SysRolesPermissions();

        String json = jsonParams.toJSONString();
        JSONObject jsonObject = jsonParams.parseObject(json);
        JSONArray jsonArray = jsonObject.getJSONArray("data");
        for(int i=0;i<jsonArray.size();i++){

            JSONObject object = jsonArray.getJSONObject(i);

            Integer roleId=  object.getInteger("roleId");
            Integer permissionId = object.getInteger("permissionId");

            sysRolesPermissions.setRoleId(roleId);
            sysRolesPermissions.setPermissionId(permissionId);

            sysRolesPermissionsService.addRolesPermissions(sysRolesPermissions);
        }
        return Result.success("添加[[ "+sysRolesPermissions.getRoleId()+" ]]成功！");
    }

    @RequestMapping(value = "/updateRolesPermissions", method = {RequestMethod.POST, RequestMethod.GET})
    public Result UpdateRolesPermissions(@RequestBody JSONObject jsonParams) {
        SysRolesPermissions sysRolesPermissions = new SysRolesPermissions();

        String json = jsonParams.toJSONString();
        JSONObject jsonObject = jsonParams.parseObject(json);
        JSONArray jsonArray = jsonObject.getJSONArray("data");
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject object = jsonArray.getJSONObject(i);
            Integer rolePermissionId = object.getInteger("rolePermissionId");
            Integer roleId       = object.getInteger("roleId");
            Integer permissionId    = object.getInteger("permissionId");
            sysRolesPermissions.setRolePermissionId(rolePermissionId);
            sysRolesPermissions.setRoleId(roleId);
            sysRolesPermissions.setPermissionId(permissionId);
            System.out.println(sysRolesPermissions);

            sysRolesPermissionsService.updateRolesPermission(sysRolesPermissions);
        }
        return Result.success("更新rolePermissionId: [[" + sysRolesPermissions.getRolePermissionId() + "]]成功!", jsonParams);
    }


    @RequestMapping("/deleteRolesPermissions")
    public Result deleteRolesPermissions(@RequestBody JSONObject jsonParams){
        SysRolesPermissions sysRolesPermissions = new SysRolesPermissions();
        String json = jsonParams.toString();
        JSONObject jsonObject = jsonParams.parseObject(json);
        JSONArray jsonArray = jsonObject.getJSONArray("data");
        for(int i=0;i<jsonArray.size();i++){
            JSONObject object= jsonArray.getJSONObject(i);
            Integer userRoleId = object.getInteger("rolePermissionId");
            sysRolesPermissions.setRolePermissionId(userRoleId);
            sysRolesPermissionsService.deletedRolesPermissions(sysRolesPermissions);
        }
        return Result.success("删除[[ "+sysRolesPermissions.getRolePermissionId()+" ]]成功!");
    }

}