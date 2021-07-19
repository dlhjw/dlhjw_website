package com.dlhjw.website.controller;

import com.dlhjw.website.bean.Info;
import com.dlhjw.website.bean.Result;
import com.dlhjw.website.service.InfoService;
import com.qq.tars.spring.annotation.TarsHttpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


/**
 * @author dlhjw
 * @version 1.0
 * @date 2021/5/30 22:54
 */
@Slf4j
@TarsHttpService("HttpObj") //将spring-boot中嵌入的容器的端口绑定到对应Servant的端口上
@Controller //页面跳转
public class IndexController {

    @Autowired
    InfoService infoService;

    @Value("${my-config.honour.file-url-download}")
    private String fileUrlDownload;

    @Value("${my-config.user.dev-uid}")
    private String devUidStr;

    @GetMapping(value = {"/","/index"})
    public String indexPage(){
        log.info("index：访问项目index页面");
        return "index";
    }

    //请求路径：info/1
    @GetMapping("/info/{uid}")
    public String uPage(@PathVariable("uid") Long uid, Model model){
        log.info("u：访问项目生成页面");
        log.info("查找用户的uid:" + uid);

        //1.根据uid查找用户，并封装到result里
        Info info = infoService.getInfoByUid(uid);
        Result result = null;
        //获取开发者devUid
        //4.5 将devUid强转为Long
        long devUid = Long.parseLong(devUidStr);
        if(info!=null){
            result = new Result(200,"查询成功",info,devUid);
        }else{
            result = new Result(204,"查询失败，用户不存在",null,devUid);
        }
        //2.将result存入model
        model.addAttribute("result",result);
        log.info("result的值为:" + result);
        return "u";
    }


    @GetMapping("/info/pdf/{fileName}")
    public void pdfStreamHandler(HttpServletRequest request,
                                 HttpServletResponse response,
                                 @PathVariable("fileName") String fileName) {
        //PDF文件地址
        File file = new File(fileUrlDownload + fileName);
        if (file.exists()) {
            byte[] data = null;
            FileInputStream input=null;
            try {
                input= new FileInputStream(file);
                data = new byte[input.available()];
                input.read(data);
                response.getOutputStream().write(data);
            } catch (Exception e) {
                System.out.println("pdf文件处理异常：" + e);
            }finally{
                try {
                    if(input!=null){
                        input.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
