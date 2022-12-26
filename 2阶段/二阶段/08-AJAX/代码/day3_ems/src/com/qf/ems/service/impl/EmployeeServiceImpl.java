package com.qf.ems.service.impl;

import com.qf.ems.dao.EmployeeDAO;
import com.qf.ems.dao.impl.EmployeeDAOImpl;
import com.qf.ems.entity.Employee;
import com.qf.ems.entity.PageBean;
import com.qf.ems.service.EmployeeService;

import java.util.Date;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeDAO employeeDAO = new EmployeeDAOImpl();

    @Override
    public boolean save(Employee employee) {
        try {
            employee.setCreatetime(new Date());
            employee.setUpdatetime(new Date());
           return employeeDAO.save(employee) > 0;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Employee employee) {
        try {
            employee.setUpdatetime(new Date());
            return employeeDAO.update(employee) > 0;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        try {
            return employeeDAO.delete(id) > 0;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public PageBean findAll(int page) {
        try {
            // 查询条数
            final long count = employeeDAO.count();
            int skip = (page - 1) * PageBean.PAGE_SIZE;
            if (skip >= count){
                return null;
            }else {
                final List<Employee> list = employeeDAO.findAll(skip, PageBean.PAGE_SIZE);
                return new PageBean(count, page, list);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Employee findById(Integer id) {
        try {
            return employeeDAO.findById(id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
