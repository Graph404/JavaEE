package com.qf.test;

import com.qf.pojo.User;
import com.qf.service.UserService;
import com.qf.service.impl.UserServiceImpl;
import org.junit.Test;

/**
 * 作者：威哥
 * 描述：永无Bug
 */
public class TestUserService {
    UserService userService = new UserServiceImpl();
    @Test
    public void testLogin(){
        String username = "admin";
        String password = "123";
        System.out.println(userService.login(username, password));
    }
    @Test
    public void testRegister(){
        User user = new User(null,"admin","123","13522226666");
        System.out.println(userService.register(user));
    }
}
