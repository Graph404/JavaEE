package com.qf.service;

import com.qf.pojo.User;

/**
 * 作者：威哥
 * 描述：永无Bug
 */
public interface UserService {
    //登录
    User login(String username,String password);
    //注册
    boolean register(User user);
}
