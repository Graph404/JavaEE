package com.qf.dao;

import com.qf.pojo.Dept;

import java.sql.SQLException;
import java.util.List;

/**
 * 作者：威哥
 * 描述：永无Bug
 */
public interface DeptDao {
    List<Dept> selectAll() throws SQLException;
    Dept selectOne(int deptno) throws SQLException;
}
