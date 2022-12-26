package com.qf.ems.service;

import com.qf.ems.entity.Admin;

public interface AdminService {
    Admin login(String username, String pwd);
}
