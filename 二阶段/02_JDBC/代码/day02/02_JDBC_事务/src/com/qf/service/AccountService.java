package com.qf.service;

/**
 * 作者：威哥
 * 描述：永无Bug
 */
public interface AccountService {
    //转账业务方法
    String transferMoney(String fromName,String toName,double money);
}
