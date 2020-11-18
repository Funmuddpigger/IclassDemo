package com.classadm.demo.controller;



import com.alibaba.fastjson.JSONException;
import com.classadm.demo.service.AuditService;
import com.classadm.demo.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping(value = "/audit",produces = "application/json;charset=UTF-8")
public class AuditController {
    @Autowired
    AuditService auditService;


    //......或许未审核数据......

    //一次获取
    @RequestMapping(value = "/gainOne",method = {RequestMethod.GET,RequestMethod.POST})
    public Result gainOne() throws JSONException {
        return Result.success("获取成功", auditService.gainAudit(0));
    }

    //二次次获取
    @GetMapping("/gainTwo")
    @ResponseBody
    public Result gainTwo() throws JSONException {
        return Result.success("获取成功", auditService.gainAudit(1));
    }

    //三次获取
    @GetMapping("/gainThree")
    @ResponseBody
    public Result gainThree() throws JSONException {
        return Result.success("获取成功", auditService.gainAudit(2));
    }


    //......审核数据......

    //第一次审核
    @PostMapping("/first")
    @ResponseBody
    public Result first(String class_id, int user_id, String user_name, Date class_stackTime, Date class_endTime, String class_note, boolean pass) throws JSONException {
        auditService.proceedAudit(class_id, user_id, user_name, class_stackTime, class_endTime,class_note, pass, "一次", 1);
        return Result.audit("s审核成功");

    }
    //第二次审核
    @PostMapping("/second")
    @ResponseBody
    public Result second(String class_id, int user_id, String user_name,Date class_stackTime, Date class_endTime, String class_note, boolean pass) throws JSONException {
        auditService.proceedAudit(class_id, user_id, user_name,  class_stackTime, class_endTime, class_note, pass, "二次", 2);
        return Result.audit("s审核成功");
    }
    //第三次审核
    @PostMapping("/third")
    @ResponseBody
    public Result third(String class_id, int user_id, String user_name,Date class_stackTime, Date class_endTime, String class_note, boolean pass) throws JSONException {

        auditService.proceedAudit(class_id, user_id, user_name, class_stackTime, class_endTime, class_note, pass, "三次", 3);
        return Result.audit("s审核成功");
    }
}

