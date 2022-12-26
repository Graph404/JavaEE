package com.qf.demo;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

/**
 * 作者：威哥
 * 描述：永无Bug
 */
public class JDBCUtils {
    /**
     * JDBC工具类： 简化封装JDBC的开发步骤
     *      1、注册驱动
     *            注册驱动在整个程序中只需要注册一次。可以将其写在静态代码中
     *      2、获取数据库的连接
     *            将获取数据库连接的代码写到一个方法之中
     *      3、释放资源
     *            将关闭资源封装成一个方法
     *
     *
     *      现在的工具类，存在大量的硬编码，不够灵活。所以我们需要将驱动类、url、用户名、密码等信息写到配置文件中
     */
    private static String driver;
    private static String url;
    private static String username;
    private static String password;

    static{
        try {
            Properties properties = new Properties();
            //将配置文件中的信息以key-value的形式存储到Properties集合中
            //properties.load(new FileInputStream("01_JDBC入门\\src\\db.properties"));
            properties.load(JDBCUtils.class.getClassLoader().getResourceAsStream("db.properties"));


            driver = properties.getProperty("driver");
            url = properties.getProperty("url");
            username = properties.getProperty("username");
            password = properties.getProperty("password");


            Class.forName(driver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //获取数据库的连接
    public static Connection getConnection(){
        try {
            return DriverManager.getConnection(url,username,password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    //释放资源
    public static void closeAll(Connection conn, Statement statement, ResultSet rs){
        try {
            if(rs != null){
                rs.close();
            }
            if(statement != null){
                statement.close();
            }
            if(conn != null){
                conn.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }



}
