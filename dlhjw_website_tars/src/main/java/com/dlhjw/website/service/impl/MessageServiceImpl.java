package com.dlhjw.website.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dlhjw.website.bean.Message;
import com.dlhjw.website.mapper.MessageMapper;
import com.dlhjw.website.service.MessageService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author dlhjw
 * @version 1.0
 * @date 2021/6/4 19:51
 */
@Service
public class MessageServiceImpl extends ServiceImpl<MessageMapper, Message> implements MessageService {

    @Value("${my-config.message.un-name}")
    public String unName;

    /**
     * 保存message判断是否为unName
     * @param uid 留言对象
     * @param name 留言者
     * @param message 留言信息
     * @return 是否成功
     */
    @Override
    public boolean saveMess(Long uid, String name, String message) {

        boolean isSave = false;

        if(name == null || "".equals(name)){
            name = unName;
        }
        isSave = save(new Message(uid, name, message));

        return isSave;
    }
}
