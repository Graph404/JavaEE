package com.qf.view;

import com.qf.pojo.Product;
import com.qf.service.ProductService;
import com.qf.service.impl.ProductServiceImpl;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * 作者：威哥
 * 描述：永无Bug
 */
public class ProductView {
    Scanner sc = new Scanner(System.in);
    public void menu(){
        System.out.println("**********商品管理页面**********");
        while(true){
            System.out.println("1、上架\t2、下架\t3、修改\t4、查询\t5、搜索\t6、排序\t7、回到首页");
            int option = sc.nextInt();
            switch (option){
                case 1:
                    add();
                    break;
                case 2:
                    del();
                    break;
                case 3:
                    update();
                    break;
                case 4:
                    select();
                    break;
                case 5:
                    search();
                    break;
                case 6:
                    order();
                    break;
                case 7:
                    return;
            }
        }
    }
    ProductService productService = new ProductServiceImpl();
    private void order() {
        List<Product> productList = productService.selectAll();
        System.out.println("1、价格排序(降序)2、销量(降序)");
        int option = sc.nextInt();
        if(option == 1){
            productList.stream().sorted((o1, o2) -> (int)(o2.getPrice() - o1.getPrice())).forEach(System.out::println);
        }else{
            productList.stream().sorted((o1, o2) -> (int)(o2.getSalesNum() - o1.getSalesNum())).forEach(System.out::println);
        }
    }
    private void search() {
        System.out.println("请输入要搜索的内容");
        String searchName = sc.next();
        List<Product> productList = productService.selectByCondition(searchName);
        productList.forEach(System.out::println);
    }
    private void select() {
        List<Product> productList = productService.selectAll();
        productList.forEach(System.out::println);
    }
    private void update() {
        System.out.println("输入要修改的商品id");
        int id = sc.nextInt();
        Product product = productService.selectOne(id);
        System.out.println(product);
        if(product == null){
            System.out.println("商品不存在");
        }else{
            System.out.println("请输入修改商品的名称");
            String name = sc.next();
            System.out.println("请输入修改商品的价格");
            double price = sc.nextDouble();
            System.out.println("请输入修改商品的库存");
            int stock = sc.nextInt();
            System.out.println("请输入修改商品的销量");
            int salesNum = sc.nextInt();
            //重新设置product的值
            product.setName(name);
            product.setPrice(price);
            product.setSalesNum(salesNum);
            product.setStock(stock);
            //调用后端的接口
            int count = productService.updateProduct(product);
            if(count>0){
                System.out.println("修改成功");
            }else{
                System.out.println("修改失败");
            }
        }
    }
    private void del() {
        System.out.println("请输入要删除商品id");
        int id = sc.nextInt();
        //调用后端的方法
        int count = productService.deleteProduct(id);
        if(count > 0 ){
            System.out.println("删除成功");
        }else{
            System.out.println("删除失败");
        }
    }
    private void add() {
        System.out.println("请输入商品名称");
        String name = sc.next();
        System.out.println("请输入商品价格");
        double price = sc.nextDouble();
        System.out.println("请输入商品库存");
        int stock = sc.nextInt();
        //调用后端的接口
        Product product = new Product(null,name,price,new Date(),stock,0);
        int count = productService.insertProduct(product);
        if(count > 0){
            System.out.println("添加成功");
        }else{
            System.out.println("添加失败");
        }
    }
}
