package com.qf.dao;

import com.qf.pojo.User;

import java.sql.SQLException;

/**
 * 作者：威哥
 * 描述：永无Bug
 */
public interface UserDao {
    User selectUser(String username) throws SQLException;

    int insertUser(User user) throws SQLException;
}
