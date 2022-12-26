package com.qf.dao.impl;

import com.qf.dao.EmpDao;
import com.qf.pojo.Emp;
import com.qf.utils.DaoUtils;
import com.qf.utils.JDBCUtils;

import java.util.List;

/**
 * 作者：威哥
 * 描述：永无Bug
 */
public class EmpDaoImpl implements EmpDao {
    @Override
    public int insertEmp(Emp emp) {
        //一句话！！！！！
        String sql = "insert into emp values (?,?,?,?,?,?,?,?)";
        Object[] args = {emp.getEmpno(),emp.getEname(),emp.getJob(),emp.getMgr(),emp.getHiredate(),emp.getSal(),emp.getComm(),emp.getDeptno()};
        return DaoUtils.commonsUpdate(sql,args);
    }

    @Override
    public int deleteEmp(int empno) {
        return DaoUtils.commonsUpdate("delete from emp where empno = ?",empno);
    }

    @Override
    public int updateEmp(Emp emp) {
        String sql = "update emp set ename = ?,job = ?,mgr = ?,hiredate = ?,sal = ?,comm = ?,deptno = ? where empno = ?";
        Object[] args = {emp.getEname(),emp.getJob(),emp.getMgr(),emp.getHiredate(),emp.getSal(),emp.getComm(),emp.getDeptno(),emp.getEmpno()};
        return DaoUtils.commonsUpdate(sql,args);
    }

    @Override
    public List<Emp> selectAll() {
        String sql = "select * from emp";
        return DaoUtils.commonsQuery("select * from emp",Emp.class);
    }

    @Override
    public Emp selectOne(int empno) {
        String sql = "select * from emp where empno = ?";
        Object[] args = {empno};
        return DaoUtils.commonsQuery1(sql,Emp.class,args);
    }
}
