package com.classadm.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.classadm.demo.entity.ClassInout;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author mine
 * @since 2020-08-07
 */
public interface ClassInoutMapper extends BaseMapper<ClassInout> {
    //插入
    public void classinsert(ClassInout classInout);
    //update
    public void classupdate(ClassInout classInout);
    //查询记录
    public List<ClassInout> classInoutMemory(@Param("class_master") String master);
}
