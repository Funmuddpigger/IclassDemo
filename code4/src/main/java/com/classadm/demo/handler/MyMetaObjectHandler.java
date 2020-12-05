package com.classadm.demo.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;


@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        this.strictInsertFill(metaObject,"classGotime", Timestamp.class, new Timestamp(System.currentTimeMillis()));
        System.out.println(LocalDateTime.now()+"go");


    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.strictUpdateFill(metaObject, "classBacktime", Timestamp.class, new Timestamp(System.currentTimeMillis()));
        System.out.println(LocalDateTime.now()+"back");

    }

}
