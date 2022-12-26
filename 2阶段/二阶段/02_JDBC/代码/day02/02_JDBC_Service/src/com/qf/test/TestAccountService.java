package com.qf.test;

import com.qf.service.AccountService;
import com.qf.service.impl.AccountServiceImpl;

/**
 * 作者：威哥
 * 描述：永无Bug
 */
public class TestAccountService {
    public static void main(String[] args) {
        //测试转账业务
        AccountService accountService = new AccountServiceImpl();
        System.out.println(accountService.transferMoney("jackson", "rose", 100));
    }
}
