package com.qf.test;

import com.qf.pojo.Emp;
import com.qf.service.EmpService;
import com.qf.service.impl.EmpServiceImpl;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

import java.util.Date;
import java.util.Scanner;

/**
 * 作者：威哥
 * 描述：永无Bug
 */
public class TestEmp {
    EmpService empService = new EmpServiceImpl();
    @Test
    public void test01(){
        //System.out.println("...");
        Emp emp = new Emp(10102,"鲁班","修东西",7777,new Date(),3000d,200d,20);
        int count = empService.insertEmp(emp);
        System.out.println(count);
    }

    @Test
    public void test02(){
        System.out.println(empService.deleteEmp(10102));
    }

    @Test
    public void test03(/*int a*/){
        System.out.println("单元测试方法不能有参数");
    }
    @Test
    public void /*int*/  test04(){
        System.out.println("单元测试方法不能有返回值");
        //return 100;
    }
    @Test
    public void test05(){
        System.out.println("单元测试方法不能使用Scanner键盘录入");
        Scanner sc = new Scanner(System.in);
        String next = sc.next();
        System.out.println(next);
    }
}
