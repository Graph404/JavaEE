package com.qf.ems.controller;

import com.qf.ems.entity.Admin;
import com.qf.ems.service.AdminService;
import com.qf.ems.service.impl.AdminServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final String username = request.getParameter("username");
        final String password = request.getParameter("password");
        // 用户输入的验证码
        final String code = request.getParameter("code");
        // 取出session中的验证码
        final String code1 = (String)request.getSession().getAttribute("code");
        if (code == null || code1 == null){
            request.setAttribute("msg", "验证码不能为空");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }else if(!code.equalsIgnoreCase(code1)){
            request.setAttribute("msg", "验证码输入有误");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }else{
            AdminService adminService = new AdminServiceImpl();
            final Admin admin = adminService.login(username, password);
            if (admin != null){
                // 获取session对象
                final HttpSession session = request.getSession();
                // 设置值
                session.setAttribute("user", admin);
                response.sendRedirect("employee.do");
            }else {
                request.setAttribute("msg", "用户名或密码错误");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        }
    }
}
