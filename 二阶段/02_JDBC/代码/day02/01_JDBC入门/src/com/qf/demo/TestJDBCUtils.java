package com.qf.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 作者：威哥
 * 描述：永无Bug
 */
public class TestJDBCUtils {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            //2、获取数据库连接
            conn = JDBCUtils.getConnection();
            //3、获取数据库操作对象
            ps = conn.prepareStatement("update user set username = ? where id = 2");
            //3.1设置占位符的值
            ps.setString(1,"尼古拉斯·cxk3");
            //4、执行sql
            int count = ps.executeUpdate();
            //5、处理数据
            System.out.println(count);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            //6、释放资源
            JDBCUtils.closeAll(conn,ps,null);
        }

    }
}
