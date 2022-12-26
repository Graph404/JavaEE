package com.qf.ems.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class BaseServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 转码
        request.setCharacterEncoding("utf-8");

        String m = request.getParameter("m");
        if (null == m || "".equals(m)){
            m = "list";
        }
        // 将m的值作为方法名称去调用子类中对应的方法
        try {
            this.getClass().getMethod(m, HttpServletRequest.class, HttpServletResponse.class)
                    .invoke(this, request, response);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
