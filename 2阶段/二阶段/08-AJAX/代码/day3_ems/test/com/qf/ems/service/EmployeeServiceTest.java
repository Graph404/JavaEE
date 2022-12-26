package com.qf.ems.service;

import com.qf.ems.entity.Employee;
import com.qf.ems.service.impl.EmployeeServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EmployeeServiceTest {
    private EmployeeService employeeService;

    @Before
    public void setUp() throws Exception {
        employeeService = new EmployeeServiceImpl();
    }

    @Test
    public void save() {
        final Employee employee = Employee.builder()
                .name("张三")
                .sex(1)
                .age(20)
                .salary(5000)
                .photo("111")
                .photoname("222")
                .hobby("看书,踢足球")
                .deptId(1)
                .build();
        // 断言
        Assert.assertTrue(employeeService.save(employee));
    }

    @Test
    public void update() {
        final Employee employee = Employee.builder()
                .id(1)
                .name("李亮")
                .sex(1)
                .age(20)
                .salary(5000)
                .photo("111")
                .photoname("222")
                .hobby("看书,踢足球")
                .deptId(1)
                .build();
        // 断言
        Assert.assertTrue(employeeService.update(employee));
    }

    @Test
    public void delete() {
        Assert.assertTrue(employeeService.delete(84));
    }

    @Test
    public void findAll() {
        Assert.assertNotNull(employeeService.findAll(1));
    }

    @Test
    public void findById() {
        Assert.assertNotNull(employeeService.findById(1));
    }
}