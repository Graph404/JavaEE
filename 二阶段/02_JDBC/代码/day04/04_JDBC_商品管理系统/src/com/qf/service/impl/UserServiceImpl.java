package com.qf.service.impl;

import com.qf.dao.UserDao;
import com.qf.dao.impl.UserDaoImpl;
import com.qf.pojo.User;
import com.qf.service.UserService;
import com.qf.utils.JDBCUtils;

import java.sql.SQLException;

/**
 * 作者：威哥
 * 描述：永无Bug
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();
    @Override
    public User login(String username, String password) {
        try {
            //1、根据用户名查询数据库，返回一个User对象
            User user = userDao.selectUser(username);
            //2、如果User对象不为null，进一步判断用户名和密码，如果为null则表示用户名不存在
            if(user != null){
                //3、如果用户名密码正确，则表示登录成功
                if(username.equals(user.getUsername())&& password.equals(user.getPassword())){
                    return user;
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        //3、登录失败
        return null;
    }

    @Override
    public boolean register(User user){
        try {
            //1、判断用户名是否存在
            User u = userDao.selectUser(user.getUsername());
            //2、如果用户名存在，则注册失败
            if(u != null && user.getUsername().equals(u.getUsername())){//表示用户名已经存在
                return false;
            }
            JDBCUtils.begin();
            //3、如果用户名不存在，则将用户信息添加到数据中
            int count = userDao.insertUser(user);
            if(count > 0){
                JDBCUtils.commit();
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            JDBCUtils.rollback();
        }
        return false;
    }
}
