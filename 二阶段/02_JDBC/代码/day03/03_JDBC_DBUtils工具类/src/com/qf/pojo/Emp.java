package com.qf.pojo;

/**
 * 作者：威哥
 * 描述：永无Bug
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 实体类设计开发规范
 *  1、私有化属性对外提供set、get方法
 *  2、提供有参、无参构造
 *  3、类名与表名一致，属性名与字段名一致
 *  4、基本类型必须要使用包装类(包装类的默认值是null)
 *  5、如果有需要，可以实现序列化接口
 *
 *
 */
@Data //表示添加了set、get、toString方法
@AllArgsConstructor //提供满参构造
@NoArgsConstructor  //提供无参构造
public class Emp {
    private Integer empno;
    private String ename;
    private String job;
    private Integer mgr;
    private Date hiredate;
    private Double sal;
    private Double comm;
    private Integer deptno;
    //Emp类中有一个属性是Dept表示一个Emp对应一个Dept      一对一关联关系
    private Dept dept;

    public Emp(Integer empno, String ename, String job, Integer mgr, Date hiredate, Double sal, Double comm, Integer deptno) {
        this.empno = empno;
        this.ename = ename;
        this.job = job;
        this.mgr = mgr;
        this.hiredate = hiredate;
        this.sal = sal;
        this.comm = comm;
        this.deptno = deptno;
    }
}
