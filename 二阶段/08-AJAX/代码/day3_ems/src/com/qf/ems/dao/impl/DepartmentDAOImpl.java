package com.qf.ems.dao.impl;

import com.qf.ems.dao.DepartmentDAO;
import com.qf.ems.entity.Department;
import com.qf.ems.util.DBConnection;
import com.qf.ems.util.SQLConstants;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class DepartmentDAOImpl implements DepartmentDAO {
    private QueryRunner runner = new QueryRunner(DBConnection.getDataSource());

    @Override
    public List<Department> findAll() throws SQLException {
        return runner.query(SQLConstants.DEPARTMENT_FIND_ALL, new BeanListHandler<>(Department.class));
    }
}
