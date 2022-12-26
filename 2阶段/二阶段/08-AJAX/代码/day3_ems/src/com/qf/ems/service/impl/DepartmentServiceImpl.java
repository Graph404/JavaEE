package com.qf.ems.service.impl;

import com.qf.ems.dao.DepartmentDAO;
import com.qf.ems.dao.impl.DepartmentDAOImpl;
import com.qf.ems.entity.Department;
import com.qf.ems.service.DepartmentService;

import java.util.List;

public class DepartmentServiceImpl implements DepartmentService {
    private DepartmentDAO departmentDAO = new DepartmentDAOImpl();

    @Override
    public List<Department> findAll() {
        try {
            return departmentDAO.findAll();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
