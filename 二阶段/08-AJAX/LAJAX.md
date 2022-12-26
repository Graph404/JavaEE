### AJAX

#### 一、JSON的概念

> Javascript Object Notation JS对象标记。就是指js中对象。

```javascript
{"name":"mary", "sex":"女", "age":20}
[{"id":1,"name":"mary", "sex":"女", "age":20,"hobby":[{"id":1,"name":"打游戏"}, {"id":2,"name":"看小说"}]},{"id":2,"name":"lily", "sex":"女", "age":20,"hobby":[{"id":1,"name":"打游戏"}, {"id":2,"name":"看小说"}]}]
```

> 特点：
>
> 1、是一种轻量级的[数据传输]()格式。
>
> 2、在网络中能够[有效率]()的传输。

> [注意：]()
>
> 了解：xml格式：

```xml
<?xml version="1.0" encoding="UTF-8"?>
<student>
	<name>mary</name>
    <sex>女</sex>
    <age>20</age>
</student>
```

```xml
<?xml version="1.0" encoding="UTF-8"?>
<students>
	<student>
        <id>1</id>
    	<name>mary</name>
        <sex>女</sex>
        <age>20</age>
        <hobbies>
        	<hobby>
            	<id>1</id>
                <name>打游戏</name>
            </hobby>
            <hobby>
            	<id>2</id>
                <name>看小说</name>
            </hobby>
        </hobbies>
    </student>
    <student>
        <id>2</id>
    	<name>lily</name>
        <sex>女</sex>
        <age>20</age>
        <hobbies>
        	<hobby>
            	<id>1</id>
                <name>打游戏</name>
            </hobby>
            <hobby>
            	<id>2</id>
                <name>看小说</name>
            </hobby>
        </hobbies>
    </student>
</students>
```

> 历史原因：
>
> 在网络发展早期，使用的是xml格式传输数据，后来，移动互联网的兴起，导致需要体积较小的数据传输格式，JSON应运而生。

#### 二、JSON解析

> 指在Java服务器上，将json字符串与Java对象之间相互转换的过程。
>
> 即将JSON字符串转换成Java对象，或者将Java对象转换成JSON字符串。

##### 2.1 原始的方式

> 手动拼接、切割解析字符串，然后使用反射处理。比较麻烦

```java
public class MyTest {
    public static void main(String[] args) {
        Student student = new Student(1, "张三", "男", 20);
        // {"id":1, "name":"mary", "sex":"女", "age":20}
        String str = "{\"id\":"+student.getId()+", \"name\":\""+student.getName()+"\"}";
        System.out.println(str);
        // 先解析切割字符串，然后创建对象，并设置到对象的属性中
    }
}
```

##### 2.2 第三方库的处理方式

###### 2.2.1 FastJson

> FastJson是阿里出品的第三方库。
>
> 核心是两个静态方法：
>
> JSON.toJSONString()：将对象转换成JSON字符串。
>
> JSON.parseObject()：将字符串转换成Java对象。
>
> 导入依赖：fastjson-1.2.68.jar

```java
public static void main(String[] args) {
    // 使用fastjson
    Student student = new Student(1, "张三", "男", 20);
    // 将对象转换成JSON字符串
    final String s = JSON.toJSONString(student);
    System.out.println(s);
    // 将上面的字符串重新转成对象
    final Student student1 = JSON.parseObject(s, Student.class);
    System.out.println(student1);

    // 集合的处理
    List<Student> list = new ArrayList<>();
    list.add(new Student(1, "张三", "男", 21));
    list.add(new Student(2, "李四", "男", 22));
    list.add(new Student(3, "王五", "男", 23));
    // 将集合对象转换成JSON字符串
    final String s1 = JSON.toJSONString(list);
    System.out.println(s1);
    // 将json字符串转换成集合对象
    final List<Student> list1 = JSON.parseObject(s1, new TypeReference<List<Student>>() {});
    System.out.println(list1);
    
    // 基本数组和集合的处理
    Integer [] arr = {1,3,5,7,9};
    final String s2 = JSON.toJSONString(arr);
    System.out.println(s2);
    Integer [] arr1 = JSON.parseObject(s2, Integer[].class);
    System.out.println(Arrays.toString(arr1));

    List<String> list2 = new ArrayList<>();
    list2.add("a");
    list2.add("b");
    list2.add("c");
    list2.add("d");
    final String s3 = JSON.toJSONString(list2);
    System.out.println(s3);
    List<String> list3 = JSON.parseObject(s3, new TypeReference<List<String>>(){});
    System.out.println(list3);
}
```

```java
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private Integer id;
    // name属性不进行json的转换
    @JSONField(serialize = false)
    private String name;
    private String sex;
    private Integer age;
}
```

###### 2.2.2 Jackson

> Jackson主要使用ObjectMapper对象来处理json。
>
> 使用readValue和writeValue方法进行JSON的处理。
>
> 导入依赖：
>
> jackson-annotations-2.9.10.jar
>
> jackson-core-2.9.10.jar
>
> jackson-databind-2.9.10.jar

```java
public static void main(String[] args) throws Exception{
    // 使用jackson
    Student student = new Student(1, "张三", "男", 20);
    // 创建一个ObjectMapper对象
    ObjectMapper mapper = new ObjectMapper();
    // 当对象的属性值为空时，也可以转换成json，而不会抛异常
    mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
    // 将对象转换成JSON字符串
    final String s = mapper.writeValueAsString(student);
    System.out.println(s);
    // 将上面的字符串重新转成对象
    final Student student1 = mapper.readValue(s, Student.class);
    System.out.println(student1);

    // 集合的处理
    List<Student> list = new ArrayList<>();
    list.add(new Student(1, "张三", "男", 21));
    list.add(new Student(2, "李四", "男", 22));
    list.add(new Student(3, "王五", "男", 23));
    // 将集合对象转换成JSON字符串
    final String s1 = mapper.writeValueAsString(list);
    System.out.println(s1);
    // 将json字符串转换成集合对象
    List<Student> list1 = mapper.readValue(s1, new TypeReference<List<Student>>() {});
    System.out.println(list1);
}
```

```java
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private Integer id;
    // fastjson中对应name属性不进行json的转换
//    @JSONField(serialize = false)
    private String name;
    // jackson中对应sex属性不进行json的转换
    @JsonIgnore
    private String sex;
    // jackson中将age属性对应js的int属性
    @JsonProperty("int")
    private Integer age;
}
```

###### 2.2.3 gson

> google的json处理库。
>
> 使用gson对象。
>
> 核心方法：
>
> gson.toJson() ：将对象转成json字符串。
>
> gson.fromJson()：将字符串转换成Java对象。

```java
public static void main(String[] args) throws Exception{
    // 使用gson
    Student student = new Student(1, "张三", "男", 20);
    // 创建一个gson对象
    Gson gson = new Gson();

    // 将对象转换成JSON字符串
    final String s = gson.toJson(student);
    System.out.println(s);
    // 将上面的字符串重新转成对象
    final Student student1 = gson.fromJson(s, Student.class);
    System.out.println(student1);

    // 集合的处理
    List<Student> list = new ArrayList<>();
    list.add(new Student(1, "张三", "男", 21));
    list.add(new Student(2, "李四", "男", 22));
    list.add(new Student(3, "王五", "男", 23));
    // 将集合对象转换成JSON字符串
    final String s1 = gson.toJson(list);
    System.out.println(s1);
    // 将json字符串转换成集合对象
    List<Student> list1 = gson.fromJson(s1, new TypeToken<List<Student>>() {}.getType());
    System.out.println(list1);
}
```

#### 三、浏览器中使用JS处理JSON解析

> 在浏览器中，使用JS的过程中，也会遇到将json转成字符串，或者将字符串转成JSON过程。
>
> 核心方法：
>
> JSON.stringfy() ：将JSON转成字符串
>
> JSON.parse()：将字符串转成JSON

```html
<script>
	// 创建json对象
	var stu = {"id":1,"name":"张三","sex":"男","age":20};
	console.log(stu);
	console.log(typeof(stu));
	// 将JSON对象转成成字符串
	var str = JSON.stringify(stu);
	console.log(str);
	console.log(typeof(str));
	// 将字符串转成json对象
	var stu1 = JSON.parse(str);
	console.log(stu1);
	console.log(typeof(stu1));
</script>
```

#### 四、AJAX

##### 4.1 概念

> Asynchronized JavaScript And XML，异步的JS和XML。
>
> AJAX技术是一种页面局部刷新技术。

##### 4.2 基本步骤

> 1、创建Ajax对应的XMLHTTPRequest对象。
>
> 2、设置响应（回调）函数
>
> 3、设置请求的方法和请求的URL
>
> 4、发送请求

```html
<script>
  //1、创建Ajax对应的XMLHTTPRequest对象。
  var request;
  if(window.XMLHttpRequest){
    // IE7+以及其他的浏览器
    request = new XMLHttpRequest();
  }else{
    // IE6
    request = new ActiveXObject("Microsoft.XMLHTTP");
  }
  //2、设置响应（回调）函数
  // 当每次状态改变时会调用后面的函数
  // 有5个状态0~4，之后最后一个完成就绪状态时，才需要去调用后面的处理函数
  request.onreadystatechange = function (resp) {
      // 当请求处理完毕，且状态码为200（成功）
      if (request.readyState == 4 && request.status == 200){
          // 局部刷新页面要改变的内容

      }
  };
  //3、设置请求的方法(GET或POST)和请求的URL，打开连接
  // true表示异步发送请求，是默认值，可以省略，如果写false，表示发送同步请求
  request.open("GET", "服务器url", true);

  //4、发送请求
  // send方法中可以传递参数，但是get是通过url传参，post也可以通过url传参
  // 但是post也可以通过send来传参
  request.send();
</script>
```

##### 4.3 AJAX发送请求的三种方式：

> - 发送普通的get请求，参数格式：name=mary&sex=m&age=20
> - 发送普通的post请求，参数格式：name=mary&sex=m&age=20
> - 发送json数据的post请求，参数格式：{"name":"mary", "sex":"m", "age":20}

###### 4.3.1 发送get请求

> 

```java
@WebServlet("/my.do")
public class MyGetServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getParameter("name"));
        System.out.println(req.getParameter("sex"));
        System.out.println(req.getParameter("age"));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("不接收post请求");
    }
}
```

```jsp
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>发送GET请求</title>
    <base href="${pageContext.request.contextPath}/">
  </head>
  <body>
    <input type="button" value="发送GET请求" onclick="fn1()">
  </body>
</html>
<script>
  function fn1() {
    //1、创建Ajax对应的XMLHTTPRequest对象。
    var request;
    if(window.XMLHttpRequest){
      // IE7+以及其他的浏览器
      request = new XMLHttpRequest();
    }else{
      // IE6
      request = new ActiveXObject("Microsoft.XMLHTTP");
    }
    //2、设置响应（回调）函数
    // 当每次状态改变时会调用后面的函数
    // 有5个状态0~4，之后最后一个完成就绪状态时，才需要去调用后面的处理函数
    request.onreadystatechange = function (resp) {
      // 当请求处理完毕，且状态码为200（成功）
      if (request.readyState == 4 && request.status == 200){
        // 局部刷新页面要改变的内容

      }
    };
    //3、设置请求的方法(GET或POST)和请求的URL，打开连接
    // true表示异步发送请求，是默认值，可以省略，如果写false，表示发送同步请求
    request.open("GET", "my.do?name=mary&sex=m&age=20", true);

    //4、发送请求
    // send方法中可以传递参数，但是get是通过url传参，post也可以通过url传参
    // 但是post也可以通过send来传参
    request.send();
  }
</script>
```

###### 4.3.2 发送post请求

> post请求参数是可以象get一样放到url中传递的。
>
> 也可以放到send中发送，但是如果放到send中发送，需要设置请求的头。

```java
@WebServlet("/my1.do")
public class MyPostServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("不接收get请求");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getParameter("name"));
        System.out.println(req.getParameter("sex"));
        System.out.println(req.getParameter("age"));
    }
}
```

```jsp
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>发送POST请求</title>
    <base href="${pageContext.request.contextPath}/">
  </head>
  <body>
    <input type="button" value="发送POST请求" onclick="fn1()">
  </body>
</html>
<script>
  function fn1() {
    //1、创建Ajax对应的XMLHTTPRequest对象。
    var request;
    if(window.XMLHttpRequest){
      // IE7+以及其他的浏览器
      request = new XMLHttpRequest();
    }else{
      // IE6
      request = new ActiveXObject("Microsoft.XMLHTTP");
    }
    //2、设置响应（回调）函数
    // 当每次状态改变时会调用后面的函数
    // 有5个状态0~4，之后最后一个完成就绪状态时，才需要去调用后面的处理函数
    request.onreadystatechange = function (resp) {
      // 当请求处理完毕，且状态码为200（成功）
      if (request.readyState == 4 && request.status == 200){
        // 局部刷新页面要改变的内容

      }
    };

    //3、设置请求的方法(GET或POST)和请求的URL，打开连接
    // true表示异步发送请求，是默认值，可以省略，如果写false，表示发送同步请求
    request.open("POST", "my1.do", true);

    // 如果要在send方法中传参，需要设置此行代码，而且需要在open方法之后，send方法之前执行。
    request.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    //4、发送请求
    // send方法中可以传递参数，但是get是通过url传参，post也可以通过url传参
    // 但是post也可以通过send来传参
    request.send("name=mary&sex=m&age=21");
  }
</script>
```

###### 4.3.3 使用post请求发送json数据

> - 要想发送json数据，只能使用post方式
> - 不能使用url来发送数据
> - 不能直接传递json，需要将json转换成字符串
> - 服务器端不能使用request.getParameter接收数据，需要使用request.getInputStream接收。

```java
@WebServlet("/my2.do")
public class MyJSONPostServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("不接收get请求");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final ServletInputStream inputStream = req.getInputStream();
        byte [] buffer = new byte[1024];
        int len;
        while ((len = inputStream.read(buffer)) != -1){
            String str = new String(buffer, 0, len);
            System.out.println(str);
        }
        inputStream.close();
    }
}
```

```jsp
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>发送POST请求</title>
    <base href="${pageContext.request.contextPath}/">
  </head>
  <body>
    <input type="button" value="发送POST请求JSON格式" onclick="fn1()">
  </body>
</html>
<script>
  function fn1() {
    //1、创建Ajax对应的XMLHTTPRequest对象。
    var request;
    if(window.XMLHttpRequest){
      // IE7+以及其他的浏览器
      request = new XMLHttpRequest();
    }else{
      // IE6
      request = new ActiveXObject("Microsoft.XMLHTTP");
    }
    //2、设置响应（回调）函数
    // 当每次状态改变时会调用后面的函数
    // 有5个状态0~4，之后最后一个完成就绪状态时，才需要去调用后面的处理函数
    request.onreadystatechange = function (resp) {
      // 当请求处理完毕，且状态码为200（成功）
      if (request.readyState == 4 && request.status == 200){
        // 局部刷新页面要改变的内容

      }
    };

    //3、设置请求的方法(GET或POST)和请求的URL，打开连接
    // true表示异步发送请求，是默认值，可以省略，如果写false，表示发送同步请求
    request.open("POST", "my2.do", true);

    // 如果要在send方法中传参，需要设置此行代码，而且需要在open方法之后，send方法之前执行。
    request.setRequestHeader("Content-type", "application/json;charset=utf-8");
    //4、发送请求
    // send方法中可以传递参数，但是get是通过url传参，post也可以通过url传参
    // 但是post也可以通过send来传参
    var u = {"name":"jack", "sex":"f", "age":20};
    request.send(JSON.stringify(u));
  }
</script>
```

##### 4.4 AJAX接收响应

> 服务器处理AJAX请求，只能使用print的方式响应。
>
> [注意：]()AJAX请求对应的服务器响应一定不能直接使用重定向和请求转发。

```java
@WebServlet("/my.do")
public class MyGetServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getParameter("name"));
        System.out.println(req.getParameter("sex"));
        System.out.println(req.getParameter("age"));
//        resp.setContentType("text/html;charset=utf-8");
        resp.setContentType("application/json;charset=utf-8");
        final PrintWriter out = resp.getWriter();
        Student student = new Student(1, "张三", "男", 20);
        final String s = JSON.toJSONString(student);
        out.print(s);
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("不接收post请求");
    }
}
```

```javascript
request.onreadystatechange = function () {
    // 当请求处理完毕，且状态码为200（成功）
    if (request.readyState == 4 && request.status == 200){
        // 局部刷新页面要改变的内容
        var obj = JSON.parse(request.responseText);
        console.log(obj);
    }
};
```

#### 五、AJAX案例

##### 5.1 检查用户名是否存在

> 当用户注册时，需要检查该用户名的唯一性，检查后，将结果直接在页面上使用文字的方式提示。

```java
@WebServlet("/check.do")
public class CheckUsernameServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String username = req.getParameter("username");
        resp.setContentType("application/json;charset=utf-8");
        final PrintWriter out = resp.getWriter();
        if (username.equals("zhangsan")){
            out.print("{\"isExist\":true}");
        }else{
            out.print("{\"isExist\":false}");
        }
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
```

```jsp
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>注册</title>
    <base href="${pageContext.request.contextPath}/">
  </head>
  <body>
    <form action="" method="post">
      年龄：<input type="text" name="age"><br/>
      用户名：<input type="text" name="username" id="username" onblur="fnCheck()">
      <span id="usernameSpan"></span>
      <br/>
      密码：<input type="text" name="pwd"><br/>
      <input type="submit" value="注册">
    </form>
  </body>
</html>
<script>
  function fnCheck() {
    // 得到用户名
    var u = document.getElementById("username").value;
    // 发送ajax请求
    //1、创建Ajax对应的XMLHTTPRequest对象。
    var request;
    if(window.XMLHttpRequest){
      // IE7+以及其他的浏览器
      request = new XMLHttpRequest();
    }else{
      // IE6
      request = new ActiveXObject("Microsoft.XMLHTTP");
    }
    //2、设置响应（回调）函数
    // 当每次状态改变时会调用后面的函数
    // 有5个状态0~4，之后最后一个完成就绪状态时，才需要去调用后面的处理函数
    request.onreadystatechange = function () {
      // 当请求处理完毕，且状态码为200（成功）
      if (request.readyState == 4 && request.status == 200){
        // 局部刷新页面要改变的内容
        var obj = JSON.parse(request.responseText);
        console.log(obj);
        var s = document.getElementById("usernameSpan");
        if (obj.isExist){
          s.innerText = "该用户名已存在！";
          s.style.color = "red";
        }else{
          s.innerText = "该用户名可以使用";
          s.style.color = "green";
        }
      }
    };
    //3、设置请求的方法(GET或POST)和请求的URL，打开连接
    // true表示异步发送请求，是默认值，可以省略，如果写false，表示发送同步请求
    request.open("GET", "check.do?username="+u, true);

    //4、发送请求
    // send方法中可以传递参数，但是get是通过url传参，post也可以通过url传参
    // 但是post也可以通过send来传参
    request.send();
  }
</script>
```

##### 5.2 省市联动

> 两个下拉框，第一个下拉框显示省份，当选择某一个省份后，另一个下拉框显示该省份对应的城市。

> 涉及到业务：
>
> 1、查询所有的省份。
>
> 2、根据某一个省份的id，来查询相应的城市。

```java
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Province {
    private Integer id;
    private String name;
}
```

```java
@Data
@AllArgsConstructor
@NoArgsConstructor
public class City {
    private Integer id;
    private String name;
    private Integer provinceId;
}
```

```java
public class ProvinceService {
    public List<Province> findAll(){
        return Arrays.asList(
                new Province(1, "湖北"),
                new Province(2, "湖南"),
                new Province(3, "河南")
        );
    }
}
```

```java
public class CityService {
    public List<City> findAllByProvinceId(Integer provinceId){
        if (provinceId == 1){
            return Arrays.asList(
                    new City(1, "武汉",1),
                    new City(2, "黄石",1),
                    new City(3, "鄂州",1)
            );
        }else if (provinceId == 2){
            return Arrays.asList(
                    new City(4, "长沙",2),
                    new City(5, "岳阳",2),
                    new City(6, "湘潭",2)
            );
        }else{
            return Arrays.asList(
                    new City(7, "郑州",3),
                    new City(8, "洛阳",3),
                    new City(9, "南阳",3)
            );
        }
    }
}
```

```java
@WebServlet("/province.do")
public class ProvinceServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProvinceService provinceService = new ProvinceService();
        resp.setContentType("application/json;charset=utf-8");
        final PrintWriter out = resp.getWriter();
        final List<Province> list = provinceService.findAll();
        final String s = JSON.toJSONString(list);
        out.print(s);
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
```

```java
@WebServlet("/city.do")
public class CityServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String id = req.getParameter("provinceId");
        int nid = 0;
        try {
            nid = Integer.parseInt(id);
        }catch (Exception e){
            e.printStackTrace();
        }
        CityService cityService = new CityService();
        resp.setContentType("application/json;charset=utf-8");
        final PrintWriter out = resp.getWriter();
        final List<City> list = cityService.findAllByProvinceId(nid);
        final String s = JSON.toJSONString(list);
        out.print(s);
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
```

```jsp
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>省市联动</title>
    <base href="${pageContext.request.contextPath}/">
</head>
<body onload="fnLoad()">
    <select name="province" id="province" onchange="fnChange()">
        <option value="">请选择</option>
    </select>
    <select name="city" id="city">
        <option value="">请选择</option>
    </select>
</body>
</html>
<script>
    function fnLoad() {
        // 发送ajax请求
        //1、创建Ajax对应的XMLHTTPRequest对象。
        var request;
        if(window.XMLHttpRequest){
            // IE7+以及其他的浏览器
            request = new XMLHttpRequest();
        }else{
            // IE6
            request = new ActiveXObject("Microsoft.XMLHTTP");
        }
        //2、设置响应（回调）函数
        // 当每次状态改变时会调用后面的函数
        // 有5个状态0~4，之后最后一个完成就绪状态时，才需要去调用后面的处理函数
        request.onreadystatechange = function () {
            // 当请求处理完毕，且状态码为200（成功）
            if (request.readyState == 4 && request.status == 200){
                // 局部刷新页面要改变的内容
                var arr = JSON.parse(request.responseText);
                console.log(arr);
                var province = document.getElementById("province");
                for(var i in arr){
                    // 创建一个option
                    var option = new Option(arr[i].name, arr[i].id);
                    // 给province添加一个option
                    province.options.add(option);
                }
            }
        };
        //3、设置请求的方法(GET或POST)和请求的URL，打开连接
        // true表示异步发送请求，是默认值，可以省略，如果写false，表示发送同步请求
        request.open("GET", "province.do", true);

        //4、发送请求
        // send方法中可以传递参数，但是get是通过url传参，post也可以通过url传参
        // 但是post也可以通过send来传参
        request.send();
    }

    function fnChange() {
        // 得到省份下拉框的值
        var p = document.getElementById("province").value;
        console.log(p);
        // 发送ajax请求
        //1、创建Ajax对应的XMLHTTPRequest对象。
        var request;
        if(window.XMLHttpRequest){
            // IE7+以及其他的浏览器
            request = new XMLHttpRequest();
        }else{
            // IE6
            request = new ActiveXObject("Microsoft.XMLHTTP");
        }
        //2、设置响应（回调）函数
        // 当每次状态改变时会调用后面的函数
        // 有5个状态0~4，之后最后一个完成就绪状态时，才需要去调用后面的处理函数
        request.onreadystatechange = function () {
            // 当请求处理完毕，且状态码为200（成功）
            if (request.readyState == 4 && request.status == 200){
                // 局部刷新页面要改变的内容
                var arr = JSON.parse(request.responseText);
                console.log(arr);
                var city = document.getElementById("city");
                city.options.length = 1;
                for(var i in arr){
                    // 创建一个option
                    var option = new Option(arr[i].name, arr[i].id);
                    // 给province添加一个option
                    city.options.add(option);
                }
            }
        };
        //3、设置请求的方法(GET或POST)和请求的URL，打开连接
        // true表示异步发送请求，是默认值，可以省略，如果写false，表示发送同步请求
        request.open("GET", "city.do?provinceId=" + p, true);

        //4、发送请求
        // send方法中可以传递参数，但是get是通过url传参，post也可以通过url传参
        // 但是post也可以通过send来传参
        request.send();
    }
</script>
```

#### 六、AJAX跨域问题的解决

> 案例：文件上传案例

##### 6.1 后台代码

`MyFilter`

```java
@WebFilter("/*")
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, WG-App-Version, WG-Device-Id, WG-Network-Type, WG-Vendor, WG-OS-Type, WG-OS-Version, WG-Device-Model, WG-CPU, WG-Sid, WG-App-Id, WG-Token, x-csrf-token");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
```

`UploadServlet`

```java
@WebServlet("/upload.do")
@MultipartConfig
public class UploadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final Part photo = request.getPart("photo");
        System.out.println(photo.getSize());
        final String s = UUID.randomUUID().toString().replace("-", "");
        System.out.println("提交成功");
        final ResultData data = ResultData.createSuccessJsonResult(s);
        response.setContentType("application/json;charset=utf-8");
        final PrintWriter out = response.getWriter();
        out.print(JSON.toJSONString(data));
    }
}
```

##### 6.2 前端代码

```html
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
	</head>
	<body>
		<input type="file" id="photo"/><br/>
		<input type="button" value="上传"/>
	</body>
</html>
<script type="text/javascript" src="js/jquery-1.11.0.js" ></script>
<script>
	$(function(){
		$(":button").click(function(){
			var formData = new FormData();
			var file = $("#photo")[0].files;
			formData.append('photo', file[0]);
			$.ajax({
				type:"post",
				url:"http://localhost:8080/cross/upload.do",
				dataType: 'json',
			    contentType: false,
			    processData: false,
			    data: formData,
				success:function(res){
					if(res.code=="10000"){
						alert(res.data);
					}else{
						alert(res.desc);
					}
				}
			});
		});
		
	});
</script>
```

