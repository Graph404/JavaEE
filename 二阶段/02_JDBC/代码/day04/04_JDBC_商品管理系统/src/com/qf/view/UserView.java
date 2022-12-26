package com.qf.view;

import com.qf.pojo.User;
import com.qf.service.UserService;
import com.qf.service.impl.UserServiceImpl;

import java.util.Random;
import java.util.Scanner;

/**
 * 作者：威哥
 * 描述：永无Bug
 */
public class UserView {
    Scanner sc = new Scanner(System.in);

    public void menu(){
        System.out.println("*********欢迎进入用户界面*********");
        while(true){
            System.out.println("1、注册\t2、登录\t3、退出");
            int option= sc.nextInt();
            switch (option){
                case 1:
                    register();
                    break;
                case 2:
                    login();
                    break;
                case 3:
                    System.out.println("欢迎再次使用");
                    System.exit(0);
                    break;
            }
        }
    }

    //创建验证码
    public String createCode(){
        String words = "0123456789abcdefghijklmnopqrstuvwxyz";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 4; i++) {
            int index = random.nextInt(words.length());
            sb.append(words.charAt(index));
        }
        return sb.toString();
    }

    UserService userService = new UserServiceImpl();

    private void login() {
        System.out.println("请输入用户名");
        String username = sc.next();
        System.out.println("请输入用户密码");
        String password = sc.next();
        while (true){
            String code = createCode();
            System.out.println("请输入验证码:"+code);
            String myCode = sc.next();
            if(!code.equalsIgnoreCase(myCode)){//验证码不正确
                System.out.println("验证码不正确");
            }else{
                break;
            }
        }
        //调用后端登录数据接口
        User user = userService.login(username, password);
        if(user == null){
            System.out.println("登录失败");
        }else{
            System.out.println("登录成功");
            new ProductView().menu();
        }
    }

    private void register() {
        System.out.println("请输入用户名");
        String username = sc.next();
        System.out.println("请输入用户密码");
        String password = sc.next();
        String phone;
        while(true){
            System.out.println("请输入手机号");
            phone = sc.next();
            if(phone.matches("[1][35678][0-9]{9}")){
                break;
            }else{
                System.out.println("手机号不合法");
            }
        }
        //调用后端的注册接口
        User user = new User(null,username,password,phone);
        boolean register = userService.register(user);
        if(register){
            System.out.println("注册成功，请登录");
            login();
        }else{
            System.out.println("注册失败");
        }

    }
}
