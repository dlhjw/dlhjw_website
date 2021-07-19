package com.dlhjw.website.controller;


import com.dlhjw.website.bean.Message;
import com.dlhjw.website.service.MessageService;
import com.qq.tars.spring.annotation.TarsHttpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author dlhjw
 * @version 1.0
 * @date 2021/7/2 22:00
 */
@Slf4j
@TarsHttpService("HttpObj")
@Controller
public class MessageController {

    @Autowired
    MessageService messageService;


    @PostMapping("/message")
    public String addMessage(@RequestParam("name") String name,
                             @RequestParam("message") String message,
                             @RequestParam("uid") Long uid,
                             Message me){
        boolean isSave = messageService.saveMess(uid, name, message);
        return "redirect:/info/"+uid+"#message";
    }
}
