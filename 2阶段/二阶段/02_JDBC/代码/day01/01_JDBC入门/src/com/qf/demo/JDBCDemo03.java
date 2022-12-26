package com.qf.demo;

import java.lang.invoke.SerializedLambda;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 作者：威哥
 * 描述：永无Bug
 */
public class JDBCDemo03 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");

        Connection conn = DriverManager.getConnection("jdbc:mysql:///java2210","root","123456");

        Statement statement = conn.createStatement();

        ResultSet rs = statement.executeQuery("select * from emp");

        List<Emp> empList = new ArrayList<>();
        while(rs.next()){
            int empno = rs.getInt(1);
            String ename = rs.getString("ename");
            String job = rs.getString("job");
            int mgr = rs.getInt("mgr");
            Date hiredate = rs.getDate("hiredate");
            Double sal = rs.getDouble("sal");
            Double comm = rs.getDouble("comm");
            int deptno = rs.getInt("deptno");

            Emp emp = new Emp(empno,ename,job,mgr,hiredate, sal,comm,deptno);
            empList.add(emp);
        }

        empList.forEach(System.out::println);

        rs.close();
        statement.close();
        conn.close();


    }
}
