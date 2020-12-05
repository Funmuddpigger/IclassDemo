package com.classadm.demo.service;

import com.classadm.demo.entity.Message;

import java.util.List;

public interface MessageService {

    void setMessage (int user_id,String user_name,String message_content);
    //获取信息
    List<Message> gainMessage(int user_id);
    //删除信息
    void updateMessage(int message_id);

}
