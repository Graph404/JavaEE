package com.qf.utils;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 作者：威哥
 * 描述：永无Bug
 */
public class DaoUtils {//对DAO的增删改查进行封装
    //增删改   delete from emp where empno = ? insert into emp values (?,?,?,?,?,?,?,?)
    public static int commonsUpdate(String sql,Object... args){
        PreparedStatement ps = null;
        try {
            //1、获取数据库连接对象
            Connection conn = JDBCUtils.getConnection();
            //2、获取数据库操作对象
            ps = conn.prepareStatement(sql);
            if(args != null){  //证明sql中包含了占位符
                //3、设置占位符的值   设置几个取决于可变参数的个数
                for (int i = 0; i < args.length; i++) {
                    ps.setObject(i+1,args[i]);
                }
            }
            //4、执行sql语句
            int count = ps.executeUpdate();

            //5、处理结果
            return count;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            //6、释放资源
            JDBCUtils.closeAll(ps,null);
        }
        return 0;
    }
    //查询多个   select * from emp    List<Emp>   反射！！！
    public static <T> List<T> commonsQuery(String sql, Class c, Object... args){
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            //2、获取数据库连接
            Connection conn = JDBCUtils.getConnection();
            //3、获取数据库操作对象
            ps = conn.prepareStatement(sql);
            if(args != null){
                //3.1 设置占位符的值
                for (int i = 0; i < args.length; i++) {
                    ps.setObject(i+1,args[i]);
                }
            }
            //4、执行sql语句
            rs = ps.executeQuery();
            //5、处理结果(ORM映射)
            List<T> list = new ArrayList<>();
            while(rs.next()){
                //通过反射获取类所有属性
                Field[] fields = c.getDeclaredFields();
                //通过反射获取类的对象
                T obj = (T) c.newInstance();
                for (Field field : fields) {
                    //获取属性名，因为要根据属性名去数据查询结果
                    String fieldName = field.getName();
                    Object o = rs.getObject(fieldName);
                    //因为属性是私有的，所以不能直接访问需要暴力反射
                    field.setAccessible(true); //ename  setEname()
                    //将从数据库中取到数据保存到该属性中
                    field.set(obj,o);
                }
                //将对象保存到list集合中
                list.add(obj);
            }
            return list;
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.closeAll(ps,rs);
        }

        return null;
    }
    public static <T> T commonsQuery1(String sql, Class c, Object... args){
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            //2、获取数据库连接
            Connection conn = JDBCUtils.getConnection();
            //3、获取数据库操作对象
            ps = conn.prepareStatement(sql);
            if(args != null){
                //3.1 设置占位符的值
                for (int i = 0; i < args.length; i++) {
                    ps.setObject(i+1,args[i]);
                }
            }
            //4、执行sql语句
            rs = ps.executeQuery();
            //5、处理结果(ORM映射)

            while(rs.next()){
                //通过反射获取类所有属性
                Field[] fields = c.getDeclaredFields();
                //通过反射获取类的对象
                T obj = (T) c.newInstance();
                for (Field field : fields) {
                    //获取属性名，因为要根据属性名去数据查询结果
                    String fieldName = field.getName();
                    Object o = rs.getObject(fieldName);
                    //因为属性是私有的，所以不能直接访问需要暴力反射
                    field.setAccessible(true); //ename  setEname()
                    //将从数据库中取到数据保存到该属性中
                    field.set(obj,o);
                }
                //将对象保存到list集合中
                return obj;
            }
            return null;
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.closeAll(ps,rs);
        }

        return null;
    }
}
