package com.qf.ems.dao;

import com.qf.ems.entity.Department;

import java.sql.SQLException;
import java.util.List;

public interface DepartmentDAO {
    List<Department> findAll() throws SQLException;
}
