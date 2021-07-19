package com.dlhjw.website.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dlhjw.website.bean.Honour;
import com.dlhjw.website.mapper.HonourMapper;
import com.dlhjw.website.service.HonourService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author dlhjw
 * @version 1.0
 * @date 2021/6/3 20:54
 */
@Slf4j
@Service
public class HonourServiceImpl extends ServiceImpl<HonourMapper, Honour> implements HonourService {

    @Value("${my-config.honour.file-url-upload}")
    public String fileUrlUpload;

    @Value("${my-config.honour.file-name-pre}")
    public String fileNamePre;

    public String fileName;

    @Override
    public boolean upload(Long uid, MultipartFile fileImg, int fileCount) {
        //3.判断上传的文件是否为空
        boolean isUpload = false;
        if (!fileImg.isEmpty()) {
            //获取文件的后缀名
            String originalFilename = fileImg.getOriginalFilename();
            log.info("originalFilename：" + originalFilename);
            //根据URL路径创建文件
            File newFile = null;
            if( originalFilename != null){
                this.fileName = fileNamePre+ uid + fileCount + originalFilename.substring(originalFilename.length()-4);
                newFile = new File( fileUrlUpload+ fileName);
                //将新创建的文件与用户上传的文件绑定
                try {
                    fileImg.transferTo(newFile);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                isUpload = true;
            }
        }
        return isUpload;
    }

    @Override
    public String getFileName() {
        return fileName;
    }
}
