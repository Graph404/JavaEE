package com.qf.test;

import com.qf.service.AccountService;
import com.qf.service.impl.AccountServiceImpl;
import com.qf.service.impl.AccountServiceImpl2;
import com.qf.service.impl.AccountServiceImpl3;

/**
 * 作者：威哥
 * 描述：永无Bug
 */
public class TestAccountService {
    public static void main(String[] args) {
        //测试转账业务
        //AccountService accountService = new AccountServiceImpl();
        //AccountService accountService = new AccountServiceImpl2();
        AccountService accountService = new AccountServiceImpl3();
        System.out.println(accountService.transferMoney("jackson", "rose", 100));
    }
}
