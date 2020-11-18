package com.classadm.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.classadm.demo.entity.ClassInout;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author mine
 * @since 2020-08-07
 */
public interface ClassInoutService extends IService<ClassInout> {
    //查询记录
    List<ClassInout> classInoutMemory(String master);
}
