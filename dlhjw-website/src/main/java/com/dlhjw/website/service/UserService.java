package com.dlhjw.website.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dlhjw.website.bean.User;

/**
 * @author dlhjw
 * @version 1.0
 * @date 2021/5/30 21:57
 */
public interface UserService extends IService<User> {

    boolean saveUser(User user);
}
