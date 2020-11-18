package com.classadm.demo;

import com.classadm.demo.entity.ClassInout;
import com.classadm.demo.mapper.ClassInoutMapper;
import com.classadm.demo.mapper.SysUsersMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {
    @Autowired
    ClassInoutMapper classInoutMapper;
    @Autowired
    SysUsersMapper sysUsersMapper;

    @Test
    void contextLoads() {
    }
    @Test
    void insertclass(){

        ClassInout classInout = new ClassInout();
        classInout.setClassId("T103");
        classInout.setClassType("大");
        classInout.setClassProperty("特殊");
        classInout.setClassStatue("借出");
        classInoutMapper.classinsert(classInout);
    }

    @Test
    void updateclass(){

        ClassInout classInout = new ClassInout();
        classInout.setClassId("T103");
        classInout.setClassStatue("归还");
        classInoutMapper.classupdate(classInout);
    }
    @Test
    void selectuser(){
        System.out.println(sysUsersMapper.selectByName("admin"));
    }
}
