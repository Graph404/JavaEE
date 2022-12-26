package com.qf.day6.servlet;

import com.alibaba.fastjson.JSON;
import com.qf.day6.entity.City;
import com.qf.day6.service.CityService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/city.do")
public class CityServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String provinceId = req.getParameter("provinceId");
        int nid = 0;
        try {
            nid = Integer.parseInt(provinceId);
        }catch (Exception e){}
        final List<City> cityList = new CityService().findAllByProvinceId(nid);
        // 转成json数据，并发送到客户端
        final String s = JSON.toJSONString(cityList);
        resp.setContentType("application/json;charset=utf-8");
        final PrintWriter out = resp.getWriter();
        out.write(s);
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
