package com.classadm.demo.service.impl;


import com.classadm.demo.entity.Audit;
import com.classadm.demo.mapper.AuditMapper;
import com.classadm.demo.mapper.DisposeClassMapper;
import com.classadm.demo.service.AuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
public class AuditServiceImpl implements AuditService {
    @Autowired
    private MessageServiceImpl messageServiceImpl;
    @Autowired
    private AuditMapper auditMapper;
    @Autowired
    private DisposeClassMapper disposeClassMapper;
    @Autowired
    private JavaMailSenderImpl mailSender;


    public List<Audit> gainAudit(int audit_number){
        List<Audit> auditList = auditMapper.gainAudit(audit_number);
        for(Audit audit: auditList){
            System.out.println(true);
        }
        return auditList;
    }

    public void proceedAudit(String class_id, int user_id, String user_name, Date class_stackTime,Date class_endTime, String class_note, boolean pass,String class_property,int audit_number){
        Timestamp apply_stackTime = new Timestamp(class_stackTime.getTime());
        Timestamp apply_endTime = new Timestamp(class_endTime.getTime());
        if(pass) {
            if (disposeClassMapper.judgeClass(class_id).get(0).getClassProperty().equals(class_property)) {
                auditMapper.addRecord(class_id, user_id, user_name,apply_stackTime,apply_endTime, class_note,"借出");
                auditMapper.deleteAudit(class_id,apply_stackTime,apply_endTime);
                String msg="n同学，你好，你申请的教室已经通过审核"+"时间："+apply_stackTime+"到"+apply_endTime+"教室："+class_id;
                messageServiceImpl.setMessage(user_id,user_name,msg);
                send(msg,"3091023130@qq.com");
            } else {
                auditMapper.updateAudit(class_id, apply_stackTime, apply_endTime, audit_number);
            }
        }else{
            auditMapper.deleteAudit(class_id,apply_stackTime,apply_endTime);
            String msg="n同学，你好，你申请的教室没有通过"+"时间："+apply_stackTime+"到"+apply_endTime+"教室："+class_id;
            messageServiceImpl.setMessage(user_id,user_name,msg);
            send(msg,"3091023130@qq.com");
        }

    }

    @Async
    public void send (String Text,String ToMail){

        SimpleMailMessage mailMessage =new SimpleMailMessage();
        mailMessage.setSubject("教室申请回复");
        mailMessage.setText(Text);
        mailMessage.setTo(ToMail);
        mailMessage.setFrom("2422143120@qq.com");
        mailSender.send(mailMessage);

    }
}
