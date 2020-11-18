package com.classadm.demo.controller;



import com.alibaba.fastjson.JSONException;
import com.classadm.demo.service.DisposeClassService;
import com.classadm.demo.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
@RequestMapping(value = "/class",produces = "application/json;charset=UTF-8")
public class DisposeClassController {


    @Autowired
    private DisposeClassService disposeClassService;
    //.............分配教室.....................
    @PostMapping("/distribution")
    @ResponseBody
    public Result distributionClass
    (String class_id, int user_id, String user_name, Date class_goTime, Date class_backTime,
     String class_note, int number_people,int howWeek,String severalWeeks) throws JSONException {
        String result = disposeClassService.distributionClass(class_id,user_id,user_name,class_goTime,class_backTime,
                class_note,number_people,howWeek,severalWeeks);
        if(result.equals("406")) {
            return Result.authorizationfail("分配失败");
        }
        else {
            return Result.success("分配成功", result);
        }

    }

}


