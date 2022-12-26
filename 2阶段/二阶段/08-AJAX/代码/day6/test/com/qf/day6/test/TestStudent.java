package com.qf.day6.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.qf.day6.entity.Student;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestStudent {
    @Test
    public void test1(){
        // 得到一个对象
        Student student = Student.builder()
                .id(1)
                .name("张三")
                .sex("男")
                .age(20)
                .build();
        // 转换成json格式
        // {"id":1,"name":"张三","sex":"男","age":20}
        String jsonString = "{\"id\":"+student.getId()+",\"name\":\""+student.getName()
                +"\",\"sex\":\""+student.getSex()+"\",\"age\":"+student.getAge()+"}";
        System.out.println(jsonString);
    }

    @Test
    public void test2(){
        // 得到一个对象
        Student student = Student.builder()
                .id(1)
                .name("张三")
                .sex("男")
                .age(20)
                .build();
        // 得到一个集合
        List<Student> list = new ArrayList<>();
        list.add(new Student(1, "张三", "男", 21));
        list.add(new Student(2, "李四", "男", 22));
        list.add(new Student(3, "王五", "男", 23));
        // 转换成json格式
        final String jsonString = JSON.toJSONString(student);
        System.out.println(jsonString);
        final String jsonString1 = JSON.toJSONString(list);
        System.out.println(jsonString1);

        // 转换成java对象
        final Student student1 = JSON.parseObject(jsonString, Student.class);
        System.out.println(student1);
        // 转成java集合
        final List<Student> list1 = JSON.parseObject(jsonString1, new TypeReference<List<Student>>(){});
        System.out.println(list1);
    }

    @Test
    public void test3() throws IOException {
        // 得到一个对象
        Student student = Student.builder()
                .id(1)
                .name("张三")
                .sex("男")
                .age(20)
                .build();
        // 得到一个集合
        List<Student> list = new ArrayList<>();
        list.add(new Student(1, "张三", "男", 21));
        list.add(new Student(2, "李四", "男", 22));
        list.add(new Student(3, "王五", "男", 23));

        // 转换成json格式
        ObjectMapper mapper = new ObjectMapper();
        final String jsonString = mapper.writeValueAsString(student);
        System.out.println(jsonString);
        final String jsonString1 = mapper.writeValueAsString(list);
        System.out.println(jsonString1);

        // 转换成java对象
        final Student student1 = mapper.readValue(jsonString, Student.class);
        System.out.println(student1);
        // 转成java集合
        final List<Student> list1 = mapper.readValue(jsonString1, new com.fasterxml.jackson.core.type.TypeReference<List<Student>>(){});
        System.out.println(list1);
    }

    @Test
    public void test4(){
        // 得到一个对象
        Student student = Student.builder()
                .id(1)
                .name("张三")
                .sex("男")
                .age(20)
                .build();
        // 得到一个集合
        List<Student> list = new ArrayList<>();
        list.add(new Student(1, "张三", "男", 21));
        list.add(new Student(2, "李四", "男", 22));
        list.add(new Student(3, "王五", "男", 23));

        // 转换成json格式
        Gson gson = new Gson();
        final String jsonString = gson.toJson(student);
        System.out.println(jsonString);
        final String jsonString1 = gson.toJson(list);
        System.out.println(jsonString1);

        // 转换成java对象
        final Student student1 = gson.fromJson(jsonString, Student.class);
        System.out.println(student1);
        // 转成java集合
        final List<Student> list1 = gson.fromJson(jsonString1, new TypeToken<List<Student>>(){}.getType());
        System.out.println(list1);
    }
}
