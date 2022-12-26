package com.qf.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 作者：威哥
 * 描述：永无Bug
 */
public class EmpDaoImpl implements EmpDao{
    @Override
    public int insertEmp(Emp emp) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            //2、获取数据库连接
            conn = JDBCUtils.getConnection();
            //3、获取数据库操作对象
            String sql = "insert into emp values (?,?,?,?,?,?,?,?)";
            ps = conn.prepareStatement(sql);
            //3.1、设置占位符的值
            ps.setInt(1,emp.getEmpno());
            ps.setString(2,emp.getEname());
            ps.setString(3,emp.getJob());
            ps.setInt(4,emp.getMgr());
            ps.setDate(5,new Date(emp.getHiredate().getTime()));
            ps.setDouble(6,emp.getSal());
            ps.setDouble(7,emp.getComm());
            ps.setInt(8,emp.getDeptno());

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

    @Override
    public int deleteEmp(int empno) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            //2、获取数据库连接对象
            conn = JDBCUtils.getConnection();
            //3、获取数据库操作对象
            String sql = "delete from emp where empno = ?";
            ps = conn.prepareStatement(sql);
            //3.1 设置占位符的值
            ps.setInt(1,empno);
            //4、执行sql语句
            int count = ps.executeUpdate();
            //5、处理结果
            return count;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.closeAll(conn,ps,null);
        }
        return 0;
    }

    @Override
    public int updateEmp(Emp emp) {
        return 0;
    }

    @Override
    public List<Emp> selectAll() {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            //2、获取数据库连接对象
            conn = JDBCUtils.getConnection();
            //3、获取数据库操作对象
            ps = conn.prepareStatement("select * from emp");
            //4、执行sql语句
            ResultSet rs = ps.executeQuery();

            //5、处理结果
            List<Emp> empList = new ArrayList<>();
            while(rs.next()){
                int empno = rs.getInt("empno");
                String ename = rs.getString("ename");
                String job = rs.getString("job");
                int mgr = rs.getInt("mgr");
                Date hiredate = rs.getDate("hiredate");
                double sal = rs.getDouble("sal");
                double comm = rs.getDouble("comm");
                int deptno = rs.getInt("deptno");
                Emp emp = new Emp(empno,ename,job,mgr,hiredate,sal,comm,deptno);
                empList.add(emp);
            }
            return empList;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public Emp selectOne(int empno) {
        return null;
    }
}
