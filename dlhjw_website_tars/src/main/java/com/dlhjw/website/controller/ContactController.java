package com.dlhjw.website.controller;

import com.dlhjw.website.bean.Contact;
import com.dlhjw.website.bean.Result;
import com.dlhjw.website.service.ContactService;
import com.qq.tars.spring.annotation.TarsHttpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;

/**
 * @author dlhjw
 * @version 1.0
 * @date 2021/6/3 20:08
 */
@Slf4j
@TarsHttpService("HttpObj")
@RestController
public class ContactController {

    @Autowired
    ContactService contactService;

    @PostMapping("/contact")
    public Result addContact(Contact contact, HttpSession session) {
        log.info("获取的用户联系方式：" + contact.toString());

        //1.先从session域中获取maskName并赋值
        String maskName = (String)session.getAttribute("maskName");
        log.info("获取到的maskName：" + maskName);
        if(maskName != null){
            contact.setMask(maskName);
            session.removeAttribute("maskName");
        }
        //2.判断bean是否为空
        boolean isEmpty = contact.isEmpty(contact);
        log.info("判断联系方式是否为空：" + isEmpty);
        if( isEmpty ){
            return new Result(204, "空的联系方式");
        }
        //3.对连接地址做http判别
        contactService.urlHandle(contact);

        //4.执行保存操作
        boolean isSave = contactService.save(contact);
        //5.将获取成果封装返回给前端
        Result result = null;
        if( isSave ){
            result = new Result(201, "用户联系添加成功");
        } else {
            result = new Result(400, "用户联系添加失败");
        }
        return result;
    }

    @PostMapping("/upload/mask")
    public Result uplodeMask(@RequestParam("input-b1") MultipartFile maskImg,
                             HttpSession session) {
        log.info("图片上传请求:maskImg=" + maskImg);

        //1.判断session里是否有uid，无则退出
        Long uid = (Long)session.getAttribute("uid");
        if( uid == 0){
            return new Result(500,"用户基础信息存储失败，请刷新");
        }
        //2.文件上传
        boolean isUpload = contactService.upload(uid, maskImg);
        //3.将用户头像路径存入session域中，在提交联系方式表时一并进入数据库
        Result result = null;
        if( isUpload ){
            session.setAttribute("maskName", contactService.getMaskName());
            result = new Result(201, "文件上传成功");
        } else {
            result = new Result(400, "文件上传失败");
        }
        return result;
    }



}
