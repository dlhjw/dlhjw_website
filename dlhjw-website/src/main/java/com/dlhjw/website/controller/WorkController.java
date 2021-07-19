package com.dlhjw.website.controller;

import com.dlhjw.website.bean.Result;
import com.dlhjw.website.bean.Work;
import com.dlhjw.website.service.WorkService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dlhjw
 * @version 1.0
 * @date 2021/6/3 20:33
 */
@Slf4j
@RestController
public class WorkController {

    @Autowired
    WorkService workService;

    @PostMapping("/work")
    public Result addWork(Work work) {
        log.info("添加的工作经历：" + work.toString());

        //1.先判断bean是否为无效的
        boolean isEmpty = work.isEmpty(work);
        log.info("判断工作经历是否为空：" + isEmpty);
        if( isEmpty ){
            return new Result(204, "空的工作经历");
        }
        //2.执行保存操作
        boolean isSave = workService.save(work);
        //3.将获取成果封装返回给前端
        Result result = null;
        if( isSave ){
            result = new Result(201, "工作经历添加成功");
        } else {
            result = new Result(400, "工作经历添加失败");
        }
        return result;
    }


}
