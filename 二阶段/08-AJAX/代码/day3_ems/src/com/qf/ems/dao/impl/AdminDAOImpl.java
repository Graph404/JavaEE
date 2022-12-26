package com.qf.ems.dao.impl;

import com.qf.ems.dao.AdminDAO;
import com.qf.ems.entity.Admin;
import com.qf.ems.util.DBConnection;
import com.qf.ems.util.SQLConstants;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class AdminDAOImpl implements AdminDAO {
    private QueryRunner runner = new QueryRunner(DBConnection.getDataSource());

//    @Override
//    public Admin findByUsernameAndPwd(String username, String pwd) throws SQLException {
//        return runner.query(SQLConstants.ADMIN_FIND_BY_USERNAME_AND_PWD, new BeanHandler<>(Admin.class), username, pwd);
//    }

    @Override
    public Admin findByUsername(String username) throws SQLException {
        return runner.query(SQLConstants.ADMIN_FIND_BY_USERNAME, new BeanHandler<>(Admin.class), username);
    }
}
