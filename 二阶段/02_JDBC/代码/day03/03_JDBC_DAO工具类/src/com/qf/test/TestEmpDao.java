package com.qf.test;

import com.qf.dao.EmpDao;
import com.qf.dao.impl.EmpDaoImpl;
import com.qf.pojo.Emp;

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
        //Emp emp = new Emp(8888,"哼哈","保安",9999,new Date(),3500d,200d,30);
        //System.out.println(empDao.insertEmp(emp));

        //测试修改
        //Emp emp = new Emp(8888,"二将","保安123",9999,new Date(),3200d,100d,30);
        //System.out.println(empDao.updateEmp(emp));

        //测试删除
        //System.out.println(empDao.deleteEmp(8888));

        //测试查询所有
        //List<Emp> empList = empDao.selectAll();
        //empList.forEach(System.out::println);

        //测试查询单个
        Emp emp = empDao.selectOne(9999);
        System.out.println(emp);
    }
}
