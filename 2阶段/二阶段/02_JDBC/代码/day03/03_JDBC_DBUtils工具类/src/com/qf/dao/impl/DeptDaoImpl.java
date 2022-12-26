package com.qf.dao.impl;

import com.mysql.jdbc.JDBC42CallableStatement;
import com.qf.dao.DeptDao;
import com.qf.pojo.Dept;
import com.qf.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import javax.management.Query;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * 作者：威哥
 * 描述：永无Bug
 */
public class DeptDaoImpl implements DeptDao {
    //数据库字段名与实体类属性名不一致   解决方案1：给列名取别名  解决方案2：自定义映射
    @Override
    public List<Dept> selectAll() throws SQLException {
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "select deptno dno,dname name,location address from dept";
        return qr.query(sql,new BeanListHandler<Dept>(Dept.class));
    }

    @Override
    public Dept selectOne(int deptno) throws SQLException {
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "select * from dept where deptno = ?";
        Object[] args = {deptno};
        return qr.query(sql, new ResultSetHandler<Dept>() {
            @Override
            public Dept handle(ResultSet rs) throws SQLException {
                while(rs.next()){
                    //int deptno1 = rs.getInt("deptno");
                    String dname = rs.getString("dname");
                    String location = rs.getString("location");
                    Dept dept = new Dept(deptno,dname,location);
                    return dept;
                }
                return null;
            }
        }, args);
    }
}
