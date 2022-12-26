package com.qf.ems.controller;

import cn.dsna.util.images.ValidateCode;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/code.do")
public class CodeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final ServletContext application = request.getServletContext();
        // 获取是否存在对象count，如果不存在，则表示第一次访问，则创建count并保存
        Long count = (Long)application.getAttribute("count");
        if (count == null){
            count = 0L;
        }
        count++;
        application.setAttribute("count", count);
        System.out.println("一共被访问了"+count+"次");

        ValidateCode validateCode = new ValidateCode(120,30,4,10);
        final String code = validateCode.getCode();
        System.out.println(code);
        request.getSession().setAttribute("code", code);
        validateCode.write(response.getOutputStream());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
