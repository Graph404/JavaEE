package com.qf.dao.impl;

import com.qf.dao.EmpDao;
import com.qf.pojo.Dept;
import com.qf.pojo.Emp;
import com.qf.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 作者：威哥
 * 描述：永无Bug
 */
public class EmpDaoImpl implements EmpDao {
    @Override
    public int insertEmp(Emp emp) throws SQLException {
        //1、创建QueryRunner对象
        QueryRunner qr = new QueryRunner();
        String sql = "insert into emp values (?,?,?,?,?,?,?,?)";
        Object[] args = {emp.getEmpno(),emp.getEname(),emp.getJob(),emp.getMgr(),emp.getHiredate(),emp.getSal(),emp.getComm(),emp.getDeptno()};
        return qr.update(JDBCUtils.getConnection(),sql,args);
    }

    @Override
    public int deleteEmp(int empno) throws SQLException {
        //1、创建QueryRunner对象
        QueryRunner qr = new QueryRunner();
        String sql = "delete from emp where empno = ?";
        Object[] args = {empno};
        return qr.update(JDBCUtils.getConnection(),sql,args);
    }

    @Override
    public int updateEmp(Emp emp) throws SQLException {
        //1、创建QueryRunner对象
        QueryRunner qr = new QueryRunner();
        String sql = "update emp set ename = ?,job = ?,mgr = ?,hiredate = ?,sal = ?,comm = ?,deptno = ? where empno = ?";
        Object[] args = {emp.getEname(),emp.getJob(),emp.getMgr(),emp.getHiredate(),emp.getSal(),emp.getComm(),emp.getDeptno(),emp.getEmpno()};
        return qr.update(JDBCUtils.getConnection(),sql,args);
    }

    @Override
    public List<Emp> selectAll() throws SQLException {
        //1、创建QueryRunner对象
        //查询无需考虑事务问题，所以直接在创建QueryRunner的时候传递一个连接池对象即可。DBUtils会帮你释放连接
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "select * from emp";
        return qr.query(sql,new BeanListHandler<Emp>(Emp.class));  //BeanListHandler用于映射多行结果
    }

    @Override
    public Emp selectOne(int empno) throws SQLException {
        //1、创建QueryRunner对象
        //查询无需考虑事务问题，所以直接在创建QueryRunner的时候传递一个连接池对象即可。DBUtils会帮你释放连接
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "select * from emp where empno = ?";
        Object[] args = {empno};
        return qr.query(sql,new BeanHandler<Emp>(Emp.class),args);  //BeanHandler用于映射单行结果
    }

    @Override
    public List<Emp> selectAll2() throws SQLException {
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "select e.*,dname,location from emp e left join dept d on e.deptno = d.deptno";
        return qr.query(sql, new ResultSetHandler<List<Emp>>() {
            @Override
            public List<Emp> handle(ResultSet rs) throws SQLException {
                List<Emp> empList = new ArrayList<>();
                while(rs.next()){
                    //属于Emp对象的属性
                    int empno = rs.getInt("empno");
                    String ename = rs.getString("ename");
                    String job = rs.getString("job");
                    int mgr = rs.getInt("mgr");
                    double sal = rs.getDouble("sal");
                    double comm = rs.getDouble("comm");
                    int deptno = rs.getInt("deptno");
                    Date hiredate = rs.getDate("hiredate");

                    Emp emp = new Emp(empno,ename,job,mgr,hiredate,sal,comm,deptno);

                    //属于Dept对象的属性
                    String dname = rs.getString("dname");
                    String location = rs.getString("location");
                    Dept dept = new Dept(deptno,dname,location);

                    //将Dept作为属性添加到Emp对象
                    emp.setDept(dept);
                    empList.add(emp);
                }
                return empList;
            }
        });
    }

    @Override
    public List<Map<String, Object>> selectAll3() throws SQLException {
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "select e.*,dname,location from emp e left join dept d on e.deptno = d.deptno";
        return qr.query(sql,new MapListHandler());
    }
}
