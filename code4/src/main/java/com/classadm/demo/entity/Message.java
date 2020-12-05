package com.classadm.demo.entity;

import lombok.Data;

@Data
public class Message {
    private int MessageId;
    private int UserId;
    private String UserName;
    private String MessageContent;
    private  boolean MessageStatus;
}
