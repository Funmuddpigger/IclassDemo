package com.classadm.demo.controller;


import com.classadm.demo.entity.ClassInout;
import com.classadm.demo.service.ClassInoutService;
import com.classadm.demo.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/class-inout")
public class ClassInoutController {

    @Autowired
    ClassInoutService classInoutService;

    @RequestMapping(value = "/getmemory/mine",method = {RequestMethod.GET,RequestMethod.POST},produces = "application/json;charset=UTF-8")
    public Result classInoutMemory(@RequestParam(value = "master",required = true) String username){
        List<ClassInout> classInouts = classInoutService.classInoutMemory(username);
        Result memorysuccess = Result.success(classInouts);
        return memorysuccess;
    }
}
