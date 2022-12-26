package com.qf.service.impl;

import com.qf.dao.ProductDao;
import com.qf.dao.impl.ProductDaoImpl;
import com.qf.pojo.Product;
import com.qf.service.ProductService;
import com.qf.utils.JDBCUtils;

import java.sql.SQLException;
import java.util.List;

/**
 * 作者：威哥
 * 描述：永无Bug
 */
public class ProductServiceImpl implements ProductService {
    private ProductDao productDao = new ProductDaoImpl();
    @Override
    public int insertProduct(Product product) {
        try {
            //开始事务
            JDBCUtils.begin();
            int count = productDao.insertProduct(product);
            JDBCUtils.commit();
            return count;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            JDBCUtils.rollback();
        }
        return 0;
    }

    @Override
    public int updateProduct(Product product) {
        try {
            JDBCUtils.begin();
            int count = productDao.updateProduct(product);
            JDBCUtils.commit();
            return count;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            JDBCUtils.rollback();
        }
        return 0;
    }

    @Override
    public int deleteProduct(int id) {
        try {
            JDBCUtils.begin();
            int count = productDao.deleteProduct(id);
            JDBCUtils.commit();
            return count;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            JDBCUtils.rollback();
        }
        return 0;
    }

    @Override
    public List<Product> selectAll() {
        try {
            List<Product> productList = productDao.selectAll();
            return productList;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public Product selectOne(int id) {
        try {
            Product product = productDao.selectOne(id);
            return product;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Product> selectByCondition(String searchName) {
        try {
            List<Product> productList = productDao.selectByCondition(searchName);
            return productList;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
