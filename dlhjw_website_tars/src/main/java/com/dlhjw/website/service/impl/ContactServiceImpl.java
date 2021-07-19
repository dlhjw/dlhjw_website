package com.dlhjw.website.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dlhjw.website.bean.Contact;
import com.dlhjw.website.mapper.ContactMapper;
import com.dlhjw.website.service.ContactService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author dlhjw
 * @version 1.0
 * @date 2021/6/3 20:11
 */
@Slf4j
@Service
public class ContactServiceImpl extends ServiceImpl<ContactMapper, Contact> implements ContactService{

    @Value("${my-config.contact.mask-url-upload}")
    public String maskUrlUpload;


    @Value("${my-config.contact.mask-name-pre}")
    public String maskNamePre;

    public String maskName;

    @Override
    public boolean upload(Long uid, MultipartFile maskImg) {

        boolean isUpload = false;
        if(!maskImg.isEmpty()) {
            //获取文件的后缀名
            String originalFilename = maskImg.getOriginalFilename();
            log.info("originalFilename：" + originalFilename);
            //根据URL路径创建文件
            File newMask = null;
            if( originalFilename != null){
                this.maskName = maskNamePre + uid + originalFilename.substring(originalFilename.length()-4);
                newMask = new File( maskUrlUpload + maskName);
                //将新创建的文件与用户上传的图片绑定
                try {
                    maskImg.transferTo(newMask);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                isUpload = true;
            }
        }
        return isUpload;
    }

    @Override
    public String getMaskName() {
        return maskName;
    }

    @Override
    public void urlHandle(Contact contact){
        String weibo = contact.getWeibo();
        if( weibo != null && !"".equals(weibo) && weibo.length() > 4 ){
            if( !"http".equals(weibo.substring(0, 4) )){
                contact.setWeibo("http://" + weibo);
            }
        }
        String github = contact.getGithub();
        if( weibo != null && !"".equals(github) && github.length() > 4 ){
            if( !"http".equals(github.substring(0, 4) )){
                contact.setGithub("http://" + github);
            }
        }
        String blog = contact.getBlog();
        if( blog != null && !"".equals(blog) && blog.length() > 4 ){
            if( !"http".equals(blog.substring(0, 4) )){
                contact.setBlog("http://" + blog);
            }
        }

    }
}
