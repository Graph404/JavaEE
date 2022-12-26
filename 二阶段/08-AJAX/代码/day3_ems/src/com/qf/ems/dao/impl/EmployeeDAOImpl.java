package com.qf.ems.dao.impl;

import com.qf.ems.dao.EmployeeDAO;
import com.qf.ems.entity.Department;
import com.qf.ems.entity.Employee;
import com.qf.ems.util.DBConnection;
import com.qf.ems.util.SQLConstants;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
    private QueryRunner runner = new QueryRunner(DBConnection.getDataSource());

    @Override
    public int save(Employee employee) throws SQLException {
        return runner.update(SQLConstants.EMPLOYEE_SAVE, employee.getName(), employee.getSex(), employee.getAge(),
                employee.getSalary(), employee.getPhoto(), employee.getDeptId(),
                employee.getHobby(), employee.getCreatetime(), employee.getUpdatetime(), employee.getPhotoname());
    }

    @Override
    public int update(Employee employee) throws SQLException {
        return runner.update(SQLConstants.EMPLOYEE_UPDATE, employee.getName(), employee.getSex(), employee.getAge(),
                employee.getSalary(), employee.getPhoto(), employee.getDeptId(),
                employee.getHobby(),  employee.getUpdatetime(), employee.getPhotoname(), employee.getId());
    }

    @Override
    public int delete(Integer id) throws SQLException {
        return runner.update(SQLConstants.EMPLOYEE_DELETE, id);
    }

    @Override
    public List<Employee> findAll(int skip, int size) throws SQLException {
        return runner.query(SQLConstants.EMPLOYEE_FIND_ALL, new ResultSetHandler<List<Employee>>() {
            @Override
            public List<Employee> handle(ResultSet resultSet) throws SQLException {
                List<Employee> list = new ArrayList<>();
                while (resultSet.next()){
                    list.add(
                        Employee.builder()
                                .id(resultSet.getInt("id"))
                                .name(resultSet.getString("name"))
                                .sex(resultSet.getInt("sex"))
                                .age(resultSet.getInt("age"))
                                .salary(resultSet.getInt("salary"))
                                .photo(resultSet.getString("photo"))
                                .photoname(resultSet.getString("photoname"))
                                .hobby(resultSet.getString("hobby"))
                                .deptId(resultSet.getInt("deptId"))
                                .department(
                                        Department.builder()
                                                .id(resultSet.getInt("deptId"))
                                                .name(resultSet.getString("deptName"))
                                                .build()
                                )
                                .build()
                    );
                }
                return list;
            }
        }, skip, size);
    }

    @Override
    public Employee findById(Integer id) throws SQLException {
        return runner.query(SQLConstants.EMPLOYEE_FIND_BY_ID, new BeanHandler<>(Employee.class), id);
    }

    @Override
    public long count() throws SQLException {
        // 返回单行单列数据使用ScalarHandler
        return runner.query(SQLConstants.EMPLOYEE_COUNT, new ScalarHandler<>());
    }
}
