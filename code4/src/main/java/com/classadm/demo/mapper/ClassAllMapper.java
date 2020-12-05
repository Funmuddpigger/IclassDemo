package com.classadm.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.classadm.demo.entity.ClassAll;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 * @author mine
 * @since 2020-08-14
 */
public interface ClassAllMapper extends BaseMapper<ClassAll> {
    //获取所有教室
    public List<ClassAll> getAll(Page page);
    //获取所有一次教室
    public List<ClassAll> getOneMethod(Page page);
    //获取所有二次教室
    public List<ClassAll> getTwoMethod(Page page);
    //获取自己选择的教室
    public ClassAll getByClassId(@Param("class_id") String classid);
    //模糊查询教室
    public List<ClassAll> getByClassFirstName(@Param("class_id") String classfirst, Page page);
    //获取教室和所属课程信息
    public ClassAll getClassCourseByNam(@Param("class_id") String classid);
    //excel导入教室
    public int excelclassinsert(ClassAll classAll);
}
