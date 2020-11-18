package com.classadm.demo.controller;



import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.classadm.demo.entity.ClassAll;
import com.classadm.demo.service.ClassAllService;
import com.classadm.demo.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author mine
 * @since 2020-08-14
 */

@RestController
@RequestMapping("/class-all")
public class ClassAllController {
    @Autowired
    ClassAllService classAllService;

    @RequestMapping(value = "/select/getall" ,method = {RequestMethod.GET,RequestMethod.POST},produces = "application/json;charset=UTF-8")
    public Result selectall(@RequestParam(value = "page",required = true,defaultValue = "0") Integer page,
                            @RequestParam(value = "pagesize",required = true,defaultValue = "20") Integer pagesize){
        Page<ClassAll> classAllPage = new Page<>(page,pagesize);
        Result getallresult = Result.success(classAllService.getAll(classAllPage));
        return getallresult;
    }

    @RequestMapping(value = "/select/getordinary" , method = {RequestMethod.GET,RequestMethod.POST})
    public Result selectordinary(){
        List<ClassAll> classOrdinarys = classAllService.getOrdinary();
        Result getordinaryresult = Result.success(classOrdinarys);
        return getordinaryresult;
    }

    @RequestMapping(value = "/select/getspecial" , method = {RequestMethod.GET,RequestMethod.POST})
    public Result selectspecial(){
        List<ClassAll> classSpecials = classAllService.getSpecial();
        Result getordinaryresult = Result.success(classSpecials);
        return getordinaryresult;
    }
    //根据教室ID进行查找
    @RequestMapping(value = "/select/getbyclassid" , method = {RequestMethod.GET,RequestMethod.POST})
    public Result selectbyclassid(ClassAll myclass,HttpServletRequest request){
        String id = request.getParameter("class_id");
        ClassAll myidclass = classAllService.getByClassId(id);
        if(myidclass != null ){
            Result getordinaryresult = Result.success(myidclass);
            return getordinaryresult;
        }else{
            Result getordinaryresult = Result.serverfail("no this class");
            return getordinaryresult;
        }
    }

    @RequestMapping(value = "/select/getbyclassinname" , method = {RequestMethod.GET,RequestMethod.POST})
    public Result selectbyclassfirst(HttpServletRequest request){
        String id = request.getParameter("class_id");
        List<ClassAll> myclass = classAllService.getByClassFirstName(id);
        Result getordinaryresult = Result.success(myclass);
        return getordinaryresult;
    }

    @RequestMapping(value = "/select/getClassCourseByNam" , method = {RequestMethod.GET,RequestMethod.POST})
    public Result getClassCourseByNam(HttpServletRequest request){
        String id = request.getParameter("class_id");
        ClassAll classCourseByNam = classAllService.getClassCourseByNam(id);
        Result getClassCourseByNamRe = Result.success(classCourseByNam);
        return getClassCourseByNamRe;
    }

    @RequestMapping(value = "/getclass/fromexcelin" , method = {RequestMethod.GET,RequestMethod.POST},produces = "application/json;utf-8")
    public Result insertfromexcel(@RequestBody JSONObject jsonparam) throws Exception {
        Result excelin = Result.successjson(206,"insert success",null);

        //数据读取
        String json = jsonparam.toJSONString();
        //String字符串转换为Json数组
        JSONObject jsonObject = JSONObject.parseObject(json);

        JSONArray jsonArray = jsonObject.getJSONArray("classRm");
        //遍历每一个json对象，将内容存放到Product对象中
        for (int i = 0; i < jsonArray.size(); i++) {

            JSONObject object = jsonArray.getJSONObject(i);

            ClassAll classAll = new ClassAll();

            String classId = object.getString("classId");
            String classType = object.getString("classType");
            String classState = object.getString("classState");
            Integer classCapacity = Integer.valueOf(object.getString("classCapacity"));
            String classProperty = object.getString("classPorperty");

            classAll.setClassId(classId);
            classAll.setClassType(classType);
            classAll.setClassStatus(classState);
            classAll.setClassCapacity(classCapacity);
            classAll.setClassProperty(classProperty);

            System.out.println(classAll);
            classAllService.excelclassinsert(classAll);
        }

        return excelin;
    }
}
