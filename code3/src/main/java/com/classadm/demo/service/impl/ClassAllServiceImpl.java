package com.classadm.demo.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.classadm.demo.entity.ClassAll;
import com.classadm.demo.mapper.ClassAllMapper;
import com.classadm.demo.service.ClassAllService;
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
 * @since 2020-08-14
 */
@Service
public class ClassAllServiceImpl extends ServiceImpl<ClassAllMapper, ClassAll> implements ClassAllService {
    @Autowired
    private ClassAllMapper classAllMapper;


    @Override
    public Page<List<ClassAll>> getAll(Page page) {
        List<ClassAll> classAllslist = classAllMapper.getAll(page);
        return page.setRecords(classAllslist);
    }

    @Override
    public  Page<List<ClassAll>> getOneMethod(Page page) {
        List<ClassAll> classOneslist = classAllMapper.getOneMethod(page);
        return page.setRecords(classOneslist);
    }

    @Override
    public  Page<List<ClassAll>> getTwoMethod(Page page) {
        List<ClassAll> classTwoslist = classAllMapper.getTwoMethod(page);
        return page.setRecords(classTwoslist);
    }

    @Override
    public ClassAll getByClassId(String classid) {
        ClassAll myclass = new ClassAll();
            if(classid != null && classid != "") {
            myclass = this.classAllMapper.getByClassId(classid);
            if(myclass != null ){
                System.out.println(myclass);
                return myclass;
            }else{
                return null;
            }

        }else{
            return null;
        }
    }

    @Override
    public Page<List<ClassAll>> getByClassFirstName(String classfirst,Page page) {
        List<ClassAll> classFirstNamelist = classAllMapper.getByClassFirstName(classfirst,page);
        return page.setRecords(classFirstNamelist);
    }

    @Override
    public ClassAll getClassCourseByNam(String classid) {
        return classAllMapper.getClassCourseByNam(classid);
    }
    @Override
    public int excelclassinsert(ClassAll classAll) {
        return classAllMapper.excelclassinsert(classAll);
    }
}
