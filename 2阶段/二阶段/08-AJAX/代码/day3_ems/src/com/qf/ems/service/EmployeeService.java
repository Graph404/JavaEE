package com.qf.ems.service;

import com.qf.ems.entity.Employee;
import com.qf.ems.entity.PageBean;

public interface EmployeeService {
    boolean save(Employee employee) ;
    boolean update(Employee employee) ;
    boolean delete(Integer id) ;
    PageBean findAll(int page) ;
    Employee findById(Integer id) ;
}
