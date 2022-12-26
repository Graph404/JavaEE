package com.qf.dao.impl;

import com.qf.dao.AccountDao;
import com.qf.pojo.Account;
import com.qf.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 作者：威哥
 * 描述：永无Bug
 */
public class AccountDaoImpl implements AccountDao {
    @Override
    public Account selectAccount(String name) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            //2、获取数据库连接对象
            conn = JDBCUtils.getConnection();
            //3、获取数据库操作对象
            ps = conn.prepareStatement("select * from tb_account where username =?");
            //3.1 设置占位符的值
            ps.setString(1,name);
            //4、执行SQL语句
            rs = ps.executeQuery();
            //5、处理结果集
            while(rs.next()){
                int id = rs.getInt("id");
                String username = rs.getString("username");
                double money = rs.getDouble("money");
                Account account = new Account(id,username,money);
                return  account;
            }
            return null;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            //6、释放资源
            JDBCUtils.closeAll(conn,ps,rs);
        }
        return null;
    }

    @Override
    public int updateAccount(String name, double money) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            //2、获取数据库连接对象
            conn = JDBCUtils.getConnection();
            System.out.println("Dao中的conn---->"+conn);
            //3、获取数据库操作对象
            ps = conn.prepareStatement("update tb_account set money = money + ? where username = ?");

            //3.1、设置占位符的值
            ps.setDouble(1,money);
            ps.setString(2,name);

            //4、执行SQL语句
            int count = ps.executeUpdate();

            //5、处理结果
            return count;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            //6、释放资源
            JDBCUtils.closeAll(conn,ps,null);
        }
        return 0;
    }
}
