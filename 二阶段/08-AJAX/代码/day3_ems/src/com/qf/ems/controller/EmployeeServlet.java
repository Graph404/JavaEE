package com.qf.ems.controller;

import com.qf.ems.entity.Department;
import com.qf.ems.entity.Employee;
import com.qf.ems.entity.PageBean;
import com.qf.ems.service.DepartmentService;
import com.qf.ems.service.EmployeeService;
import com.qf.ems.service.impl.DepartmentServiceImpl;
import com.qf.ems.service.impl.EmployeeServiceImpl;
import com.qf.ems.util.CommonConstants;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@MultipartConfig
@WebServlet("/employee.do")
public class EmployeeServlet extends BaseServlet {
    public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        final String id = request.getParameter("id");
        int nid = 0;
        try {
            nid = Integer.parseInt(id);
        }catch (Exception e){
            e.printStackTrace();
        }
        EmployeeService employeeService = new EmployeeServiceImpl();
        employeeService.delete(nid);

        response.sendRedirect("employee.do");
    }

    public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        final Part file = request.getPart("file");

        final String id = request.getParameter("id");
        int nid = 0;
        try {
            nid = Integer.parseInt(id);
        }catch (Exception e){
            e.printStackTrace();
        }

        final String name = request.getParameter("name");
        final String sex = request.getParameter("sex");
        int nSex = 0;
        try {
            nSex = Integer.parseInt(sex);
        }catch (Exception e){
            e.printStackTrace();
        }
        final String age = request.getParameter("age");
        int nAge = 0;
        try {
            nAge = Integer.parseInt(age);
        }catch (Exception e){
            e.printStackTrace();
        }
        final String salary = request.getParameter("salary");
        int nsalary = 0;
        try {
            nsalary = Integer.parseInt(salary);
        }catch (Exception e){
            e.printStackTrace();
        }

        final String []hobbyArr = request.getParameterValues("hobby");
        String hobby = null;
        if (hobbyArr != null && hobbyArr.length > 0) {
            hobby = String.join(",", hobbyArr);
        }

        final String deptId = request.getParameter("deptId");
        int ndeptId = 0;
        try {
            ndeptId = Integer.parseInt(deptId);
        }catch (Exception e){
            e.printStackTrace();
        }

        final Employee employee = Employee.builder()
                .id(nid)
                .name(name)
                .sex(nSex)
                .age(nAge)
                .salary(nsalary)
                .hobby(hobby)
                .deptId(ndeptId)
                .build();

        // 上传了图片
        if (file.getSize() > 0){
            String s = UUID.randomUUID().toString().replace("-", "");
            file.write(CommonConstants.BASE_PATH + s);
            employee.setPhoto(s);
            employee.setPhotoname(file.getSubmittedFileName());
        }else{
            final String photo = request.getParameter("photo");
            employee.setPhoto(photo);
        }

        EmployeeService employeeService = new EmployeeServiceImpl();
        employeeService.update(employee);

        response.sendRedirect("employee.do");
    }

    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        final Part file = request.getPart("file");

        final String name = request.getParameter("name");
        final String sex = request.getParameter("sex");
        int nSex = 0;
        try {
            nSex = Integer.parseInt(sex);
        }catch (Exception e){
            e.printStackTrace();
        }
        final String age = request.getParameter("age");
        int nAge = 0;
        try {
            nAge = Integer.parseInt(age);
        }catch (Exception e){
            e.printStackTrace();
        }
        final String salary = request.getParameter("salary");
        int nsalary = 0;
        try {
            nsalary = Integer.parseInt(salary);
        }catch (Exception e){
            e.printStackTrace();
        }

        final String []hobbyArr = request.getParameterValues("hobby");
        String hobby = null;
        if (hobbyArr != null && hobbyArr.length > 0) {
            hobby = String.join(",", hobbyArr);
        }

        final String deptId = request.getParameter("deptId");
        int ndeptId = 0;
        try {
            ndeptId = Integer.parseInt(deptId);
        }catch (Exception e){
            e.printStackTrace();
        }

        final Employee employee = Employee.builder()
                .name(name)
                .sex(nSex)
                .age(nAge)
                .salary(nsalary)
                .hobby(hobby)
                .deptId(ndeptId)
                .build();

        // 上传了图片
        if (file.getSize() > 0){
            String s = UUID.randomUUID().toString().replace("-", "");
            file.write(CommonConstants.BASE_PATH + s);
            employee.setPhoto(s);
            employee.setPhotoname(file.getSubmittedFileName());
        }

        EmployeeService employeeService = new EmployeeServiceImpl();
        employeeService.save(employee);

        response.sendRedirect("employee.do");
    }

    public void preUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        final String id = request.getParameter("id");
        int nid = 0;
        try {
            nid = Integer.parseInt(id);
        }catch (Exception e){
            e.printStackTrace();
        }
        EmployeeService employeeService = new EmployeeServiceImpl();
        final Employee employee = employeeService.findById(nid);

        DepartmentService departmentService = new DepartmentServiceImpl();
        List<Department> list = departmentService.findAll();
        request.setAttribute("list", list);
        request.setAttribute("employee", employee);
        request.getRequestDispatcher("update.jsp").forward(request, response);
    }

    public void preAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        DepartmentService departmentService = new DepartmentServiceImpl();
        List<Department> list = departmentService.findAll();
        request.setAttribute("list", list);
        request.getRequestDispatcher("add.jsp").forward(request, response);
    }

    public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = request.getParameter("page");
        int nPage = 1;
        try {
            nPage = Integer.parseInt(page);
        }catch (Exception e){
        }
        EmployeeService employeeService = new EmployeeServiceImpl();
        final PageBean bean = employeeService.findAll(nPage);
        request.setAttribute("bean", bean);
        request.getRequestDispatcher("list.jsp").forward(request, response);
    }


}
