package com.dlhjw.website.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dlhjw.website.bean.Contact;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author dlhjw
 * @version 1.0
 * @date 2021/6/3 20:11
 */
public interface ContactService extends IService<Contact> {

    boolean upload(Long uid, MultipartFile maskImg);

    String getMaskName();

    void urlHandle(Contact contact);




}
