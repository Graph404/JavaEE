package com.qf.demo;

import java.sql.*;

/**
 * 作者：威哥
 * 描述：永无Bug
 */
public class JDBCDemo02 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1、注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2、获取数据库连接对象
        Connection conn = DriverManager.getConnection("jdbc:mysql:///java2210", "root", "123456");
        //3、获取数据库操作对象
        Statement statement = conn.createStatement();
        //4、执行SQL语句
        ResultSet rs = statement.executeQuery("select * from emp");
        //5、处理结果
        /**
         * rs.next();   next方法判断下一行是否有数据，如果有返回true，并将游标向下移动，如果没有返回false
         */
        while(rs.next()){
            /**
             *  rs.getXXX(“字段名”)    getXXX方法是用于获取这一行数据的。XXX表示这个数据在Java中的类型、
             *  rs.getXXX(下标)        下标从1
             */
            //int empno = rs.getInt("empno");
            int empno = rs.getInt(1);
            String ename = rs.getString("ename");
            String job = rs.getString("job");
            int mgr = rs.getInt("mgr");
            Date hiredate = rs.getDate("hiredate");
            double sal = rs.getDouble("sal");
            double comm = rs.getDouble("comm");
            int deptno = rs.getInt("deptno");

            System.out.println(empno+"\t"+ename+"\t"+job+"\t"+mgr+"\t"+hiredate+"\t"+sal+"\t"+comm+"\t"+deptno);
        }
        //6、释放资源
        rs.close();
        statement.close();
        conn.close();
    }

}
