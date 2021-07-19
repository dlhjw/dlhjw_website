package com.dlhjw.website.controller;

import com.dlhjw.website.bean.Result;
import com.dlhjw.website.bean.Specialty;
import com.dlhjw.website.service.SpecialtyService;
import com.qq.tars.spring.annotation.TarsHttpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dlhjw
 * @version 1.0
 * @date 2021/6/3 20:47
 */
@Slf4j
@TarsHttpService("HttpObj")
@RestController
public class SpecialtyController {

    @Autowired
    SpecialtyService specialtyService;

    @PostMapping("/specialty")
    public Result addEducation(Specialty specialty) {
        log.info("添加的特长：" + specialty.toString());

        ///1.先判断bean是否为无效的
        boolean isEmpty = specialty.isEmpty(specialty);
        log.info("判断特长是否为空：" + isEmpty);
        if( isEmpty ){
            return new Result(204, "空的特长");
        }
        //2.执行保存操作
        boolean isSave = specialtyService.save(specialty);
        //将获取成果封装返回给前端
        Result result = null;
        if( isSave ){
            result = new Result(201, "特长添加成功");
        } else {
            result = new Result(400, "特长添加失败");
        }
        return result;
    }
}
