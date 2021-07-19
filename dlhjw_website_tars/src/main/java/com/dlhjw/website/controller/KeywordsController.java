package com.dlhjw.website.controller;

import com.dlhjw.website.bean.Keywords;
import com.dlhjw.website.bean.Result;
import com.dlhjw.website.service.KeywordsService;
import com.qq.tars.spring.annotation.TarsHttpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dlhjw
 * @version 1.0
 * @date 2021/6/3 20:39
 */
@Slf4j
@TarsHttpService("HttpObj")
@RestController
public class KeywordsController {

    @Autowired
    KeywordsService keywordsService;

    @PostMapping("/keywords")
    public Result addEducation(Keywords keywords) {
        log.info("提交的关键词：" + keywords.toString());

        //1.先判断bean是否为无效的
        boolean isEmpty = keywords.isEmpty(keywords);
        log.info("判断关键词是否为空：" + isEmpty);
        if( isEmpty ){
            return new Result(204, "空的关键词");
        }
        //2.执行保存操作
        boolean isSave = keywordsService.save(keywords);
        //3.将获取成果封装返回给前端
        Result result = null;
        if( isSave ){
            result = new Result(201, "提交关键词成功");
        } else {
            result = new Result(400, "提交关键词失败");
        }
        return result;
    }

}
