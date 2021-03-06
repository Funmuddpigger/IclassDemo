package com.classadm.demo.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.classadm.demo.entity.ClassAll;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author mine
 * @since 2020-08-14
 */
public interface ClassAllService extends IService<ClassAll> {
    //获取所有教室
    Page<List<ClassAll>> getAll(Page page);
    //获取所有一次教室
    Page<List<ClassAll>> getOneMethod(Page page);
    //获取所有二次教室
    Page<List<ClassAll>> getTwoMethod(Page page);
    //获取自己选择的教室
    ClassAll getByClassId(@Param("class_id") String classid);
    //获取自己选择的教室
    Page<List<ClassAll>> getByClassFirstName(@Param("class_id") String classfirst,Page page);
    //获取教室和所属课程信息
    ClassAll getClassCourseByNam(@Param("class_id") String classid);
    //导入
    int excelclassinsert(ClassAll classAll);
}
