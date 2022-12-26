package com.qf.ems.service;

import com.qf.ems.service.impl.DepartmentServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DepartmentServiceTest {
    private DepartmentService departmentService;

    @Before
    public void setUp() throws Exception {
        departmentService = new DepartmentServiceImpl();
    }

    @Test
    public void findAll() {
        Assert.assertTrue(departmentService.findAll().size() == 6);
    }
}