package com.dlhjw.website.controller;


import com.dlhjw.website.bean.Honour;
import com.dlhjw.website.bean.Result;
import com.dlhjw.website.service.HonourService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @author dlhjw
 * @version 1.0
 * @date 2021/6/3 20:56
 */
@Slf4j
@RestController
public class HonourController {

    @Autowired
    HonourService honourService;

    @PostMapping("/honour")
    public Result addEducation(Honour honour, HttpSession session) {
        log.info("添加荣誉证书：" + honour.toString());

        //1.先判断bean是否为无效的
        boolean isEmpty = honour.isEmpty(honour);
        log.info("判断荣誉证书是否为空：" + isEmpty);
        if( isEmpty ){
            return new Result(204, "空的荣誉证书");
        }
        //2.判断是否有文件，如果有，如果有就给honour.file赋值
        String file = null;
        if( honour.getHaveFile() == 1){
            //从session中取值，并做非空判断
            List fileList = (List)session.getAttribute("fileList");

            if(!(fileList==null || fileList.size() == 0)){
                //根据fileCode获取对应下标的fileUrl
                file = (String)fileList.get(honour.getFileCode());
                if(fileList!=null){
                    log.info("fileList：" + fileList.toString());
                }else {
                    log.info("fileList：" + "[]");
                }
                log.info("获取到的fileUrl：" + file);
                honour.setFile(file);
            }
        }

        //2.执行保存操作
        boolean isSave = honourService.save(honour);
        //将获取成果封装返回给前端
        Result result = null;
        if( isSave ){
            result = new Result(201, "荣誉证书添加成功");
        } else {
            result = new Result(400, "荣誉证书添加失败");
        }
        return result;
    }

    @PostMapping("/upload/pdfFile")
    public Result uplodeFile(@RequestParam("input-b2") MultipartFile fileImg,
                             HttpSession session){
        log.info("文件上传请求:fileImg=" + fileImg);
        //1.判断session里是否有uid，无则退出
        Long uid = (Long)session.getAttribute("uid");
        if( uid == 0){
            return new Result(500,"用户基础信息存储失败，请刷新");
        }
        //2.判断session里是否有键"fileList"，有则获取数量，无则创建
        List fileList = (List)session.getAttribute("fileList");
        int fileCount = 0;
        if(fileList==null || fileList.size() == 0){
            fileList = new ArrayList<String>();
        } else {
            fileCount = fileList.size();
        }
        //3.文件上传，成功就将文件名存入session域的list中，在提交联系方式表时一并进入数据库
        Result result = null;
        boolean isUpload = honourService.upload(uid, fileImg, fileCount);
        if( isUpload ){
            fileList.add(honourService.getFileName());
            session.setAttribute("fileList", fileList);
            result = new Result(200, "上传成功");
        } else {
            result = new Result(400, "上传失败");
        }
        return result;
    }

}
