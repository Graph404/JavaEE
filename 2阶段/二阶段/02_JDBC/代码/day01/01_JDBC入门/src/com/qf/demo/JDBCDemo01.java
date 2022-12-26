package com.qf.demo;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 作者：威哥
 * 描述：永无Bug
 */
public class JDBCDemo01 {
    /**
     * JDBC开发步骤：
     *     0.准备工作(导入第三方jar包)
     *          a、在当前工程中创建一个lib文件夹，将jar放到文件夹
     *          b、右击jar包-->add as library（将jar的class文件解压到当前模块中）
     *     1、注册驱动
     *         Class.forName("com.mysql.jdbc.Driver");
     *     2、获取数据库连接
     *          DriverManager.getConnection(url,username,password);
     *     3、获取数据库操作对象
     *          conn.createStatement();
     *     4、通过Statement执行SQL
     *          statement.executeUpdate(sql) ---> 增删改(更新操作)   返回int：表示受影响的行数
     *          statement.executeQuery(sql)  ---> 查询
     *     5、处理结果
     *
     *     6、释放资源
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        //1、注册驱动
        //DriverManager.registerDriver(new Driver());
        //通过源码分析,Driver类中有一个静态代码块已经注册驱动了。所以我们无需自己注册驱动，只需要触发类加载
        //注意：如果是8.x的数据库，那么这里驱动类：com.mysql.cj.jdbc.Driver
        Class.forName("com.mysql.jdbc.Driver");

        //2、获取数据库连接
        //数据库连接地址  网络编程三要素：协议+IP地址+端口号  jdbc:mysql://ip地址:端口号/数据库名称
        //注意1：如果连接的是本地数据库，且端口号是3306,那么可以省略为  jdbc:mysql:///数据库名称
        //注意2：如果是8.x的数据库，那么在url中必须要加上时区  jdbc:mysql://ip地址:端口号/数据库名称?serverTimezone=Asia/shanghai
        //String url = "jdbc:mysql://localhost:3306/java2210";
        String url = "jdbc:mysql:///java2210";
        //数据库用户名
        String username = "root";
        //数据库密码
        String password = "123456";
        Connection conn = DriverManager.getConnection(url, username, password);


        //3、获取数据库操作对象
        Statement statement = conn.createStatement();

        //4、通过statement对象执行sql语句
        String sql = "insert into emp values(9999,'rose','java开发',7777,'2022-11-02',20000,2000,30)";
        int count = statement.executeUpdate(sql);

        //5、处理结果
        if(count > 0){
            System.out.println("添加成功");
        }else{
            System.out.println("添加失败");
        }

        //6、释放资源
        statement.close();
        conn.close();
    }
}
