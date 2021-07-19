package com.dlhjw.website.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dlhjw.website.bean.Message;
import com.dlhjw.website.bean.User;
import com.dlhjw.website.mapper.UserMapper;
import com.dlhjw.website.service.MessageService;
import com.dlhjw.website.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

/**
 * @author dlhjw
 * @version 1.0
 * @date 2021/5/30 21:58
 */
@Service
@PropertySource("classpath:myConfig.properties")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    MessageService messageService;

    @Value("${my-config.message.dev-name}")
    public String devName;

    @Value("${my-config.message.dev-message}")
    public String devMessage;


    /**
     * 储存用户，并赋予开发者的留言信息
     * @param user 用户
     * @return 是否成功
     */
    @Override
    public boolean saveUser(User user) {

        boolean isSaveUser = save(user);
        boolean isSaveMess = false;

        if( isSaveUser ){
            isSaveMess = messageService.save(new Message(user.getUid(), devName, devMessage));
        }
        return isSaveMess;
    }
}
