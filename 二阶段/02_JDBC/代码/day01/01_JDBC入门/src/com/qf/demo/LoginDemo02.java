package com.qf.demo;

import java.sql.*;
import java.util.Scanner;

/**
 * 作者：威哥
 * 描述：永无Bug
 */
public class LoginDemo02 {
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
        PreparedStatement ps = conn.prepareStatement("select * from user where username = ? and password = ?");
        //3.1 设置占位符的值
        /**
         * ps.setXXX(占位符的下标,占位符的值)      XXX取决于字段的数据类型
         */
        ps.setString(1,uName);
        ps.setString(2,uPass);
        System.out.println(ps);
        //4、执行sql语句
        ResultSet rs = ps.executeQuery();
        //5、处理结果
        if(rs.next()){
            System.out.println("登录成功");
        }else{
            System.out.println("登录失败");
        }
        //6、释放资源
        rs.close();
        ps.close();
        conn.close();

    }
}
