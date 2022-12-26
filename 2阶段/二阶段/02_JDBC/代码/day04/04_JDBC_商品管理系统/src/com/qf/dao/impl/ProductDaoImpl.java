package com.qf.dao.impl;

import com.qf.dao.ProductDao;
import com.qf.pojo.Product;
import com.qf.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import javax.management.Query;
import java.sql.SQLException;
import java.util.List;

/**
 * 作者：威哥
 * 描述：永无Bug
 */
public class ProductDaoImpl implements ProductDao {
    @Override
    public int insertProduct(Product product) throws SQLException {
        QueryRunner qr = new QueryRunner();
        String sql = "insert into tb_product values(null,?,?,?,?,?)";
        Object[] args = {product.getName(),product.getPrice(),
                product.getCreateTime(),product.getStock(),product.getSalesNum()};
        return qr.update(JDBCUtils.getConnection(),sql,args);
    }

    @Override
    public int updateProduct(Product product) throws SQLException {
        QueryRunner qr = new QueryRunner();
        String sql = "update tb_product set name=?,price=?,createTime=?,stock=?,salesNum=? where id = ?";
        Object[] args = {product.getName(),product.getPrice(),
                product.getCreateTime(),product.getStock(),product.getSalesNum(),product.getId()};
        return qr.update(JDBCUtils.getConnection(),sql,args);
    }

    @Override
    public int deleteProduct(int id) throws SQLException {
        QueryRunner qr = new QueryRunner();
        String sql = "delete from tb_product where id = ?";
        Object[] args = {id};
        return qr.update(JDBCUtils.getConnection(),sql,args);
    }

    @Override
    public List<Product> selectAll() throws SQLException {
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "select * from tb_product";
        return qr.query(sql,new BeanListHandler<Product>(Product.class));
    }

    @Override
    public Product selectOne(int id) throws SQLException {
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "select * from tb_product where id = ?";
        Object[] args = {id};
        return qr.query(sql,new BeanHandler<Product>(Product.class),args);
    }

    @Override
    public List<Product> selectByCondition(String searchName) throws SQLException {
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "select * from tb_product where name like ?";
        Object[] args = {"%"+searchName+"%"};
        return qr.query(sql,new BeanListHandler<Product>(Product.class),args);
    }
}
