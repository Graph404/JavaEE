package com.qf.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * 作者：威哥
 * 描述：永无Bug
 * 最终版
 */
public class JDBCUtils {
    /**
     * JDBC工具类： 简化封装JDBC的开发步骤
     *      1、注册驱动
     *            注册驱动在整个程序中只需要注册一次。可以将其写在静态代码中
     *      2、获取数据库的连接（使用ThreadLocal保证同线程使用相同的Connection）
     *            将获取数据库连接的代码写到一个方法之中
     *      3、释放资源
     *            将关闭资源封装成一个方法
     *      现在的工具类，存在大量的硬编码，不够灵活。所以我们需要将驱动类、url、用户名、密码等信息写到配置文件中
     *      4、封装了事务处理方法
     */

    //数据源--->连接池
    private static DataSource dataSource;

    static{
        try {
            Properties properties = new Properties();
            //读取配置文件
            properties.load(JDBCUtils.class.getClassLoader().getResourceAsStream("db.properties"));
            //创建Druid连接池对象
            //properties表示数据库的连接信息
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //获取连接池
    public static DataSource getDataSource(){
        return dataSource;
    }

    private static ThreadLocal<Connection> tl = new ThreadLocal<>();
    //获取数据库连接
    public static Connection getConnection(){
        Connection conn = tl.get();
        if(conn == null){ // 表示ThreadLocal中没有Connection对象
            try {
                //如果ThreadLocal中没有Connection，那么就从连接池中获取一个Connection对象
                conn = dataSource.getConnection();
                //将获取的Connection添加到ThreadLocal中
                tl.set(conn);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return conn;
    }

    //关闭资源
    public static void closeAll(Statement statement, ResultSet rs){
        try {
            if(rs != null){
                rs.close();
            }
            if(statement != null){
                statement.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    //封装事务操作
    public static void begin(){
        Connection conn = getConnection();
        //开启事务
        try {
            conn.setAutoCommit(false);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void commit(){
        Connection conn = getConnection();
        try {
            conn.commit();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                conn.close(); //此方法调用的close，并不是将Connection对象关闭，而是将其归还到连接池中
                tl.remove(); //从ThreadLocal中，将其移除掉
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public static void rollback(){
        Connection conn = getConnection();
        try {
            conn.rollback();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                conn.close(); //此方法调用的close，并不是将Connection对象关闭，而是将其归还到连接池中
                tl.remove(); //从ThreadLocal中，将其移除掉
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

}
