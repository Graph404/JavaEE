package com.qf.dao;

import java.util.List;

/**
 * 作者：威哥
 * 描述：永无Bug
 */
public interface EmpDao {
    //增
    int insertEmp(Emp emp);
    //删
    int deleteEmp(int empno);
    //改
    int updateEmp(Emp emp);
    //查询所有
    List<Emp> selectAll();
    //查询单个
    Emp selectOne(int empno);
}
