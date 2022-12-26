package com.qf.day6.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/my2.do")
public class MyJSONPostServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("不接收get请求");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final ServletInputStream inputStream = req.getInputStream();
        byte [] buffer = new byte[1024];
        int len;
        while ((len = inputStream.read(buffer)) != -1){
            String str = new String(buffer, 0, len);
            System.out.println(str);
        }
        inputStream.close();
    }
}