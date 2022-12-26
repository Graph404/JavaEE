package com.qf.ems.controller;

import com.qf.ems.util.CommonConstants;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;


@WebServlet("/show.do")
public class DownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置为下载
        response.setHeader("Content-Disposition", "attachment;filename=photo.jpg");

        final String file = request.getParameter("file");
        File f = new File(CommonConstants.BASE_PATH + file);
        InputStream is = new FileInputStream(f);
        final ServletOutputStream os = response.getOutputStream();
        byte [] buffer = new byte[8 * 1024];
        int len;
        while ((len = is.read(buffer)) != -1){
            os.write(buffer, 0, len);
        }
        os.flush();
        os.close();
        is.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
