package com.qf.dao;

import java.util.Date;
import java.util.List;

/**
 * 作者：威哥
 * 描述：永无Bug
 */
public class TestEmpDao {
    public static void main(String[] args) {
        EmpDao empDao = new EmpDaoImpl();
        //测试增加
        //Emp emp = new Emp(99999,"cxk","php开发",9999,new Date(),10000.0,100d,20);
        //System.out.println(empDao.insertEmp(emp));

        //测试删除
        //System.out.println(empDao.deleteEmp(99999));

        //测试查询所有
        List<Emp> empList = empDao.selectAll();
        empList.forEach(System.out::println);
    }

}
