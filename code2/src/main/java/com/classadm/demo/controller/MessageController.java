package com.classadm.demo.controller;

import com.classadm.demo.service.MessageService;
import com.classadm.demo.service.impl.MessageServiceImpl;
import com.classadm.demo.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/message",produces = "application/json;charset=UTF-8")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @ResponseBody
    @PostMapping("/gain")
    public Result gainMessage(int user_id){
      return   Result.success("获取成功", messageService.gainMessage(user_id));
    }
//更改信息状态
    @ResponseBody
    @PostMapping("/update")
    public Result updateMessage( int message_id){
        messageService.updateMessage(message_id);
        return   Result.success("更改成功",null);
    }



}
