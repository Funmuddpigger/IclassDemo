package com.classadm.demo.mapper;


import com.classadm.demo.entity.Message;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MessageMapper {
   void setMessage(int message_id, int user_id, String user_name, String message_content, boolean message_status);

    List<Message>gainMessage(int user_id, boolean message_status);

    int  numMessage();

    void updateMessage(int message_id, boolean message_status);
}
