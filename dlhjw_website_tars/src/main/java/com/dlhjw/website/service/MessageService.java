package com.dlhjw.website.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dlhjw.website.bean.Message;

/**
 * @author dlhjw
 * @version 1.0
 * @date 2021/6/4 19:50
 */
public interface MessageService extends IService<Message> {

    boolean saveMess(Long uid, String name, String message);
}
