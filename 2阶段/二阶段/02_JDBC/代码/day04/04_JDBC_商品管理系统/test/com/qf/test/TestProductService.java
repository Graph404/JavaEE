package com.qf.test;

import com.qf.pojo.Product;
import com.qf.service.ProductService;
import com.qf.service.impl.ProductServiceImpl;
import org.junit.Test;

import java.util.Date;
import java.util.List;

/**
 * 作者：威哥
 * 描述：永无Bug
 */
public class TestProductService {
    ProductService productService = new ProductServiceImpl();
    @Test
    public void testInsert(){
        Product product = new Product(null,"小米手机",2999d,new Date(),100,0);
        int count = productService.insertProduct(product);
        System.out.println(count);
    }

    @Test
    public void testUpdate(){
        Product product = new Product(1,"华为手机",1999d,new Date(),200,0);
        int count = productService.updateProduct(product);
        System.out.println(count);
    }
    @Test
    public void testSelectAll(){
        List<Product> productList = productService.selectAll();
        productList.forEach(System.out::println);
    }

    @Test
    public void testSelectOne(){
        Product product = productService.selectOne(1);
        System.out.println(product);
    }

    @Test
    public void testDelete(){
        int count = productService.deleteProduct(1);
        System.out.println(count);
    }
}
