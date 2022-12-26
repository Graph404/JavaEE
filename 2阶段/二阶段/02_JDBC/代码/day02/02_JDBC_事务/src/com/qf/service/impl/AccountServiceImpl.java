package com.qf.service.impl;

import com.qf.dao.AccountDao;
import com.qf.dao.impl.AccountDaoImpl;
import com.qf.pojo.Account;
import com.qf.service.AccountService;
import com.qf.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 作者：威哥
 * 描述：永无Bug
 */
public class AccountServiceImpl implements AccountService {
    AccountDao accountDao = new AccountDaoImpl();
    @Override
    public String transferMoney(String fromName, String toName, double money) {
        Connection conn = JDBCUtils.getConnection();
        System.out.println("service中的conn---->"+conn);
        try {
            //开启事务
            conn.setAutoCommit(false);//设置事务为手动提交

            //1、验证我方账户
            Account fromAccount = accountDao.selectAccount(fromName);
            if(fromAccount == null){ // 账户不存在
                return "账户不存在";
            }
            //2、验证余额
            if(fromAccount.getMoney() < money){
                return "余额不足";
            }
            //3、验证敌方账户
            Account toAccount = accountDao.selectAccount(toName);
            if(toAccount == null){ //敌方卡号有误
                return "敌方卡号有误";
            }
            //4、我方账户扣钱
            accountDao.updateAccount(fromName,-money);
            System.out.println(10/0);
            //5、敌方账户加钱
            accountDao.updateAccount(toName,money);

            //提交事务
            conn.commit();
            return "转账成功";
        }catch (Exception e){
            e.printStackTrace();
            //回滚事务
            try {
                conn.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return "转账失败";
    }
}
