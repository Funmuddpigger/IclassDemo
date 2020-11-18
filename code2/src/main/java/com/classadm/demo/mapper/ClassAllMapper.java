package com.classadm.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
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
    public List<ClassAll> getAll();
    //获取所有普通教室
    public List<ClassAll> getOrdinary();
    //获取所有特殊教室
    public List<ClassAll> getSpecial();
    //获取自己选择的教室
    public ClassAll getByClassId(@Param("class_id") String classid);
    //模糊查询教室
    public List<ClassAll> getByClassFirstName(@Param("class_id") String classfirst);
    //获取教室和所属课程信息
    public ClassAll getClassCourseByNam(@Param("class_id") String classid);
    //excel导入教室
    public int excelclassinsert(ClassAll classAll);
}
