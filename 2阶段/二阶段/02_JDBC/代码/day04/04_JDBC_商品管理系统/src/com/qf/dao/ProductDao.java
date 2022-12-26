package com.qf.dao;

import com.qf.pojo.Product;

import java.sql.SQLException;
import java.util.List;

/**
 * 作者：威哥
 * 描述：永无Bug
 */
public interface ProductDao {
    int insertProduct(Product product) throws SQLException;
    int updateProduct(Product product) throws SQLException;
    int deleteProduct(int id) throws SQLException;
    List<Product> selectAll() throws SQLException;
    Product selectOne(int id) throws SQLException;
    List<Product> selectByCondition(String searchName) throws SQLException;
}
