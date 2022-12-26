package com.qf.service;

import com.qf.pojo.Product;

import java.util.List;

/**
 * 作者：威哥
 * 描述：永无Bug
 */
public interface ProductService {
    int insertProduct(Product product);

    int updateProduct(Product product);

    int deleteProduct(int id);

    List<Product> selectAll();

    Product selectOne(int id);

    List<Product> selectByCondition(String searchName);
}
