package com.qf.dao.impl;

import com.qf.dao.UserDao;
import com.qf.pojo.User;
import com.qf.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import javax.management.Query;
import java.sql.SQLException;

/**
 * 作者：威哥
 * 描述：永无Bug
 */
public class UserDaoImpl implements UserDao {
    @Override
    public User selectUser(String username) throws SQLException {
        //1、创建QueryRunner对象
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "select * from tb_user where username = ?";
        Object[] args= {username};
        return qr.query(sql,new BeanHandler<>(User.class),args);
    }

    @Override
    public int insertUser(User user) throws SQLException {
        //1、创建QueryRunner对象
        QueryRunner qr = new QueryRunner();
        String sql = "insert into tb_user values(null,?,?,?)";
        Object[] args = {user.getUsername(),user.getPassword(),user.getPhone()};
        return qr.update(JDBCUtils.getConnection(),sql,args);
    }
}
