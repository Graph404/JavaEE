package com.qf.dao;

import com.qf.pojo.Account;

/**
 * 作者：威哥
 * 描述：永无Bug
 */
public interface AccountDao3 {
    //查询用户
    Account selectAccount(String name);
    //修改用户余额
    int updateAccount(String name,double money);
}
