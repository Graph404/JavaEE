package com.qf.service.impl;

import com.qf.dao.EmpDao;
import com.qf.dao.impl.EmpDaoImpl;
import com.qf.pojo.Emp;
import com.qf.service.EmpService;
import com.qf.utils.JDBCUtils;

import java.sql.SQLException;
import java.util.List;

/**
 * 作者：威哥
 * 描述：永无Bug
 */
public class EmpServiceImpl implements EmpService {
    private EmpDao empDao = new EmpDaoImpl();
    @Override
    public int insertEmp(Emp emp) {
        try {
            //开始事务
            JDBCUtils.begin();
            int count = empDao.insertEmp(emp);
            JDBCUtils.commit();
            return count;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            JDBCUtils.rollback();
        }
        return 0;
    }

    @Override
    public int deleteEmp(int empno) {
        try {
            //开始事务
            JDBCUtils.begin();
            int count = empDao.deleteEmp(empno);
            JDBCUtils.commit();
            return count;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            JDBCUtils.rollback();
        }
        return 0;
    }

    @Override
    public int updateEmp(Emp emp) {
        try {
            //开始事务
            JDBCUtils.begin();
            int count = empDao.updateEmp(emp);
            JDBCUtils.commit();
            return count;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            JDBCUtils.rollback();
        }
        return 0;
    }

    @Override
    public List<Emp> selectAll() {
        try {
            List<Emp> empList = empDao.selectAll();
            return empList;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public Emp selectOne(int empno) {
        try {
            Emp emp = empDao.selectOne(empno);
            return emp;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
