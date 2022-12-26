package com.qf.ems.service.impl;

import com.qf.ems.dao.AdminDAO;
import com.qf.ems.dao.impl.AdminDAOImpl;
import com.qf.ems.entity.Admin;
import com.qf.ems.service.AdminService;
import com.qf.ems.util.MD5Utils;

public class AdminServiceImpl implements AdminService {
//    private AdminDAO adminDAO = new AdminDAOImpl();
    private AdminDAO adminDAO = new AdminDAOImpl();

    @Override
    public Admin login(String username, String pwd) {
        try {
            // 根据用户名查询用户信息
            final Admin admin = adminDAO.findByUsername(username);
            if (admin != null){
                // 使用原文密码与盐组合，并md5后等到密文
                final String md5 = MD5Utils.md5(pwd + admin.getSalt());
                // 将得到的md5值与数据库的密码进行对比
                if (md5.equals(admin.getPwd())){
                    return admin;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
