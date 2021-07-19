package com.dlhjw.website.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dlhjw.website.bean.Honour;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author dlhjw
 * @version 1.0
 * @date 2021/6/3 20:53
 */
public interface HonourService extends IService<Honour> {

    boolean upload(Long uid, MultipartFile fileImg, int fileCount);

    String getFileName();

}
