package com.classadm.demo.service.impl;


import com.classadm.demo.entity.Message;
import com.classadm.demo.mapper.MessageMapper;
import com.classadm.demo.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageMapper messageMapper;

    @Async
    //输入信息
    public void setMessage (int user_id,String user_name,String message_content){
        int message_id =messageMapper.numMessage()+1;
        messageMapper.setMessage(message_id,user_id,user_name,message_content,false);
    }
    //获取信息
    public List<Message> gainMessage(int user_id){
        return messageMapper.gainMessage(user_id,false);
    }
    //删除信息
    public void updateMessage(int message_id){
        messageMapper.updateMessage(message_id,true);
    }
}
