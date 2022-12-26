package com.qf.ems.dao;

import com.qf.ems.entity.Employee;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDAO {
    int save(Employee employee) throws SQLException;
    int update(Employee employee) throws SQLException;
    int delete(Integer id) throws SQLException;
    List<Employee> findAll(int skip, int size) throws SQLException;
    Employee findById(Integer id) throws SQLException;
    long count() throws SQLException;
}
