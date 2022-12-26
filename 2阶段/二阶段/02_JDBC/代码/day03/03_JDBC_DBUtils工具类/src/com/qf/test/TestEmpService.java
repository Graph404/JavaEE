package com.qf.test;

import com.qf.pojo.Emp;
import com.qf.service.EmpService;
import com.qf.service.impl.EmpServiceImpl;

import java.util.Date;
import java.util.List;

/**
 * 作者：威哥
 * 描述：永无Bug
 */
public class TestEmpService {
    public static void main(String[] args) {
        EmpService empService = new EmpServiceImpl();

        //测试增加
        //Emp emp = new Emp(10101,"鲁班","修东西",7777,new Date(),3000d,200d,20);
        //System.out.println(empService.insertEmp(emp));

        //测试查询所有
        //List<Emp> empList = empService.selectAll();
        //empList.forEach(System.out::println);

        //测试查询单个
        Emp emp = empService.selectOne(10101);
        System.out.println(emp);
    }
}
