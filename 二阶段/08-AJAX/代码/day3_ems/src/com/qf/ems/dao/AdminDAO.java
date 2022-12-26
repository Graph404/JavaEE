package com.qf.ems.dao;

import com.qf.ems.entity.Admin;

import java.sql.SQLException;

public interface AdminDAO {
//    Admin findByUsernameAndPwd(String username, String pwd) throws SQLException;
    Admin findByUsername(String username) throws SQLException;
}
