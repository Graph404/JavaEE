package com.qf.day6.servlet;

import com.qf.day6.entity.City;
import com.qf.day6.entity.Province;
import com.qf.day6.service.CityService;
import com.qf.day6.service.ProvinceService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
        req.setAttribute("cityList", cityList);
        req.setAttribute("provinceId", provinceId);
        final List<Province> list = new ProvinceService().findAll();
        req.setAttribute("list", list);
        req.getRequestDispatcher("city.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
