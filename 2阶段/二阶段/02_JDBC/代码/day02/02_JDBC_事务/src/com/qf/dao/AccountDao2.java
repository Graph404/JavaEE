package com.qf.dao;

import com.qf.pojo.Account;

import java.sql.Connection;

/**
 * 作者：威哥
 * 描述：永无Bug
 */
public interface AccountDao2 {  //接口污染
    //查询用户
    Account selectAccount(String name,Connection conn);
    //修改用户余额
    int updateAccount(String name, double money,Connection conn);
}
