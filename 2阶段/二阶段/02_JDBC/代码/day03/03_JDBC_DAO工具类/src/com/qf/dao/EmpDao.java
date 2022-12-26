package com.qf.dao;

import com.qf.pojo.Emp;

import java.util.List;

/**
 * 作者：威哥
 * 描述：永无Bug
 */
public interface EmpDao {
    int insertEmp(Emp emp);
    int deleteEmp(int empno);
    int updateEmp(Emp emp);
    List<Emp> selectAll();
    Emp selectOne(int empno);
}
