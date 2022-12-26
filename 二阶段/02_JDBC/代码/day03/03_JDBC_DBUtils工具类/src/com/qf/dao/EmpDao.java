package com.qf.dao;

import com.qf.pojo.Emp;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * 作者：威哥
 * 描述：永无Bug
 */
public interface EmpDao {
    int insertEmp(Emp emp) throws SQLException;
    int deleteEmp(int empno) throws SQLException;
    int updateEmp(Emp emp) throws SQLException;
    List<Emp> selectAll() throws SQLException;
    Emp selectOne(int empno) throws SQLException;

    //查询所有的员工及其部门信息
    List<Emp> selectAll2() throws SQLException;

    //查询所有的员工及其部门信息（不推荐）
    List<Map<String,Object>> selectAll3() throws SQLException;
}
