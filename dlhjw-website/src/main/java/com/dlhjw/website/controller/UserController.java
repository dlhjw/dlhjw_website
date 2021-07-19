package com.dlhjw.website.controller;

import com.dlhjw.website.bean.Result;
import com.dlhjw.website.bean.User;
import com.dlhjw.website.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

/**
 * @author dlhjw
 * @version 1.0
 * @date 2021/6/3 19:57
 */
@Slf4j
@RestController //默认返回json（@ResponseBody和@Controller的组合注解）
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/user")
    public Result addUser(User user, HttpSession session) {
        log.info("获取的用户信息为：" + user.toString());
        boolean isSave = userService.saveUser(user);
        //将获取成果封装返回给前端
        Result result = null;
        if( isSave ){
            result = new Result(201, "用户创建成功", user.getUid());
            log.info("将uid放入session域中：" + user.getUid());
            session.setAttribute("uid", user.getUid());
        } else {
            result = new Result(400, "用户创建失败");
        }
        return result;
    }

    @PutMapping("/user")
    public Result updateUser(User user) {
        log.info("更新用户信息");
        boolean isUpdate = userService.updateById(user);
        log.info("更新后的用户信息为：" + user.toString());
        //将获取成果封装返回给前端
        Result result = null;
        if( isUpdate ){
            result = new Result(202, "信息更新成功", user.getUid());
        } else {
            result = new Result(400, "信息更新失败");
        }
        return result;
    }
}
