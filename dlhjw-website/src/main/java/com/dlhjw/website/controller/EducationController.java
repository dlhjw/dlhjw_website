package com.dlhjw.website.controller;

import com.dlhjw.website.bean.Contact;
import com.dlhjw.website.bean.Education;
import com.dlhjw.website.bean.Result;
import com.dlhjw.website.service.EducationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dlhjw
 * @version 1.0
 * @date 2021/6/3 20:32
 */
@Slf4j
@RestController //默认返回json（@ResponseBody和@Controller的组合注解）
public class EducationController {

    @Autowired
    EducationService educationService;

    @PostMapping("/education")
    public Result addEducation(Education education) {
        log.info("添加的教育经历：" + education.toString());

        //1.先判断bean是否为无效的
        boolean isEmpty = education.isEmpty(education);
        log.info("判断教育经历是否为空：" + isEmpty);
        if( isEmpty ){
            return new Result(204, "空的教育经历");
        }
        //2.执行保存操作
        boolean isSave = educationService.save(education);
        //3.将获取成果封装返回给前端
        Result result = null;
        if( isSave ){
            result = new Result(201, "教育经历添加成功");
        } else {
            result = new Result(400, "教育经历添加失败");
        }
        return result;
    }
}
