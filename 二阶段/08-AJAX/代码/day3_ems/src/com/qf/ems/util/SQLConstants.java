package com.qf.ems.util;

public interface SQLConstants {
    String EMPLOYEE_SAVE = "insert into employee(name, sex, age, salary, photo, dept_id, hobby, createtime, updatetime, photoname)values (?,?,?,?,?,?,?,?,?,?)";
    String EMPLOYEE_UPDATE = "update employee set name=?, sex=?, age=?, salary=?, photo=?, dept_id=?, hobby=?, updatetime=?, photoname=? where id = ?";
    String EMPLOYEE_DELETE = "delete from employee where id = ?";
    String EMPLOYEE_FIND_ALL = "SELECT e.id, e.`name`, e.sex, e.age, e.salary, e.photo, e.hobby, e.createtime, e.updatetime, e.photoname, d.id deptId, d.`name` deptName FROM employee AS e INNER JOIN department AS d ON e.dept_id = d.id limit ?,?";
    String EMPLOYEE_FIND_BY_ID = "select id, name, sex, age, salary, photo, dept_id as deptId, hobby, createtime, updatetime, photoname from employee where id = ?";
    String EMPLOYEE_COUNT = "select count(1) from employee";

    String DEPARTMENT_FIND_ALL = "select id, name from department";

//    String ADMIN_FIND_BY_USERNAME_AND_PWD = "SELECT * FROM admin WHERE username = ? AND pwd = ?";
    String ADMIN_FIND_BY_USERNAME = "SELECT * FROM admin WHERE username = ?";
}
