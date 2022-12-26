package com.qf.test;

import com.qf.dao.DeptDao;
import com.qf.dao.EmpDao;
import com.qf.dao.impl.DeptDaoImpl;
import com.qf.dao.impl.EmpDaoImpl;
import com.qf.pojo.Dept;
import com.qf.pojo.Emp;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * 作者：威哥
 * 描述：永无Bug
 */
public class TestDeptDao {
    public static void main(String[] args) throws SQLException {
        DeptDao deptDao = new DeptDaoImpl();
        //测试查询所有
        //List<Dept> deptList = deptDao.selectAll();
        //deptList.forEach(System.out::println);


        //测试查询单个
        //Dept dept = deptDao.selectOne(30);
        //System.out.println(dept);

        //测试EmpDao
        EmpDao empDao = new EmpDaoImpl();
        //List<Emp> empList = empDao.selectAll2();
        //empList.forEach(System.out::println);

        List<Map<String, Object>> mapList = empDao.selectAll3();
        mapList.forEach(System.out::println);
    }
}
