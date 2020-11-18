package com.classadm.demo.service.impl;

import com.classadm.demo.entity.ClassInout;
import com.classadm.demo.mapper.ClassInoutMapper;
import com.classadm.demo.service.ClassInoutService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author mine
 * @since 2020-08-07
 */
@Service
public class ClassInoutServiceImpl extends ServiceImpl<ClassInoutMapper, ClassInout> implements ClassInoutService {

    @Autowired
    ClassInoutMapper classInoutMapper;

    //查询全部借出借入记录
    @Override
    public List<ClassInout> classInoutMemory(String master) {
        return  classInoutMapper.classInoutMemory(master);
    }
    //按教室查询记录

    //按申请人查询
}
