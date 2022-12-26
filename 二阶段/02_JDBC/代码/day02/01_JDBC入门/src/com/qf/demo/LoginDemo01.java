package com.qf.demo;

import java.sql.*;
import java.util.Scanner;

/**
 * 作者：威哥
 * 描述：永无Bug
 */
public class LoginDemo01 {
    /**
     * 登录案例：
     *      1、准备知识点 nextLine用法
     *      2、准备一张用户表
     *      3、完成登录功能
     *           a、用户通过键盘录入用户名和密码
     *           b、通过JDBC验证密码的正确性
     *              select * from user where username = 你输的用户名 and password = 你输的密码;
     *
     *              rs.next()如果返回true表示登录成功，否则登录失败
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名");
        String uName = sc.nextLine();
        System.out.println("请输入用户密码");
        String uPass = sc.nextLine();


        //1、注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2、获取数据库连接对象
        Connection conn = DriverManager.getConnection("jdbc:mysql:///java2210", "root", "123456");
        //3、获取数据库操作对象
        Statement statement = conn.createStatement();
        //4、执行sql语句
        //SQL注入：利用特殊的操作让你的SQL失效   select * from user where username = '的挥洒接电话萨克' or 1=1   #' and password = '123'
        String sql = "select * from user where username = '" + uName + "' and password = '" + uPass + "'";
        System.out.println(sql);
        ResultSet rs = statement.executeQuery(sql);

        //5、处理结果
        if(rs.next()){
            System.out.println("登录成功");
        }else{
            System.out.println("登录失败");
        }
        //6、释放资源
        rs.close();
        statement.close();
        conn.close();

    }
}
