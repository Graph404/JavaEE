### JSP

#### 一、概述

> Java Server Pages（Java服务器页面），
>
> 简化Servlet开发，在HTML标签中加入Java代码，用以高效的开发动态网页。

#### 二、创建JSP

> 在web目录中新建一个JSP文件，命令为index.jsp

```jsp
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <base href="${pageContext.request.contextPath}/">
</head>
<body>
    <%
        Date now = new Date();
        out.print("当前时间为：" + now.toLocaleString());
    %>
</body>
</html>
```

#### 三、JSP的原理

> - JSP必须先转换成Servlet才能编译执行
> - JSP本质是对Servlet的基于输出HTML标签的封装。
> - 本质还是一个Servlet
>
> 优点：可以直接编写HTML标签。

> xxx.jsp--> 转译成  --> xxx_jsp.java  --> 编译成 --> xxx_jsp.class --> 运行
>
> 将JSP转换成Java源代码，然后再编译成字节码，再运行。由tomcat容器进行。

#### 四、JSP语法

> 在页面上可以直接写Java代码：
>
> - 脚本，语法：`<%  Java代码 %>`
>
> - 声明，语法：`<%!  Java定义变量和方法的代码 %>`，声明的变量是该类的属性。
>
> - 表达式，语法：`<%= 变量或表达式 %>`例如：`<% out.print(j); %>`可以简写为：`<%= j %>`
>
>   [注意：]()表达式后面一定不要加分号
>
> - JSP注释：只会显示在服务器，不会发送到客户端，而HTML注释会发送到客户端。

```jsp
<!-- 这是HTML注释 -->
<%--这是JSP注释--%>
```

> 问题：在声明的方法中，能不能使用out.print(""); ？
>
> - 不能。因为out是service方法中定义的临时变量。

```jsp
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <base href="${pageContext.request.contextPath}/">
</head>
<body>
    <%
        // 脚本
        Date now = new Date();
        out.print("当前时间为：" + now.toLocaleString());

        int i = 1;
        out.print("i次数为：" + i++);

    %>

    <%! int j = 1;%>

    <%!
        public String hello(){

            return "hello, world";
        }
    %>
    <% out.print(j++); %>
    <%= j++ %>

    <!-- 这是HTML注释 -->
    <%--这是JSP注释--%>
</body>
</html>
```

#### 五、JSP指令

> 用来对页面进行设置。
>
> 常用有三种：
>
> - page：对页面设置
> - include：将另一个页面包含到当前页面
> - taglib：导入第三方标签库

##### 5.1 page指令

> contentType：指定内容类型和字符集
>
> language：指定页面脚本语言，默认为java
>
> pageEncoding：指定字符集
>
> import：导入页面脚本中需要的包
>
> errorPage：当前页面如果出错跳转到哪个页面
>
> isErrorPage：当前页面是否错误页面

```jsp
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" import="java.util.Date"
%>
```

##### 5.2 include指令

>  include指令属于静态包含。在转换成java源代码时就将两个文件合并一个文件，再编译运行。
>
> include动作属于动态包含。在转换成java源代码时以及编译时都是独立完成，直到运行时再将包含的页面的内容加载到一起。
>
> ```
> <jsp:include page="b.jsp"></jsp:include>
> ```

```jsp
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" import="java.util.Date"
%>
<html>
<head>
    <title>Title</title>
    <base href="${pageContext.request.contextPath}/">
</head>
<body>
    <h1>AAAABBBBB</h1>
    <%
        int b = 5;
    %>
    <%@include file="b.jsp"%>
</body>
</html>
```

`b.jsp`

```jsp
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <base href="${pageContext.request.contextPath}/">
</head>
<body>
    <h1>BBB</h1>
    <%
        out.print(b);
    %>
</body>
</html>
```

##### 5.3 taglib指令

> 导入第三方的标签库。

```jsp
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
```

#### 六、内置对象

> 又称为隐式对象。表示在jsp页面上不需要定义就可以直接使用的对象。
>
> 原因：在jsp页面上写的java代码，会自动在转译时放入到service方法中，而该方法默认会定义一些变量以及对应的方法参数可以直接在方法中使用，统称为内置对象。

> 输入输出对象：
>
> - request
> - response
> - out
>
> 作用域对象：
>
> - request（与上面重复）
> - session
> - application
> - pageContext：页面作用域，仅在当前页面有效
>
> servlet相关对象：
>
> - config：servlet配置
> - page：就是this
>
> 异常对象：
>
> - exception，只有isErrorPage=true时才能使用。

> 如果要保障系统正常运行，一般使用在web.xml中配置错误页面。

```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd"
         version="4.0">
    <error-page>
        <error-code>500</error-code>
        <location>/error.jsp</location>
    </error-page>
    <error-page>
        <error-code>404</error-code>
        <location>/404.jsp</location>
    </error-page>
</web-app>
```

#### 七、EL表达式

> 表达式语言。主要用来获取某个作用域的数据。
>
> 语法：`${某个作用域的对象}`
>
> EL表达式如果不写作用域，会从小到大每个作用域逐一寻找，找到后停止，如果所有的都没有找到，就不显示。如果只需要在某个作用域中寻找，可以指定作用域。

```jsp
<%@ page import="com.qf.day38.entity.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <base href="${pageContext.request.contextPath}/">
</head>
<body>
    <%
        request.setAttribute("username", "zhangsan");
    %>
    <h1>欢迎您，<%= request.getAttribute("username")%></h1>
    <h1>欢迎您，${requestScope.username}</h1>

    <%
        User user = new User("张三", "男", 20, 1);
        request.setAttribute("user", user);
    %>

    <%
        User user1 = (User) request.getAttribute("user");
    %>
    <h1>欢迎您，<%= user1.getName()%></h1>
    <h1>欢迎您，${user.name}</h1>
</body>
</html>
```

> 与JSP脚本的区别：
>
> - 脚本会出现null，而EL或忽略null

> [注意：]()如果使用EL引用一个对象，例如：`{user.name}`会自动拼接get，然后取调用getName方法，如果没有提供getName方法，则不显示，并非调用属性。

```jsp
<%
    String [] arr = {"hello", "world"};
    Map map = new HashMap();
    map.put("a", "AAA");
    map.put("b", "BBB");
    request.setAttribute("arr", arr);
    request.setAttribute("map", map);
%>
<h1>${arr[0]}</h1>
<h1>${map.a}</h1>
<h1>${map["b"]}</h1>
<h1>${map['b']}</h1>
```

> [注意：]()map的key可以使用.a也可以使用["a"]，中括号中的引号使用双引号和单引号都可以。

> EL中的运算符：
>
> +、-、*、/、%、==（eq）、> (gt)、< (lt)、>= （ge）、<= (le)、&&(and)、||(or)、 !(not)
>
> empty判断是否为空
>
> [注意：]() + 只能做数字运算，不能拼接字符串，`${"1" + "2"}`得到3，+两边如果有字符串会自动先转换为数字，再计算，如果无法完成转换，就报错。`${5/2}`结果为2.5

#### 八、JSTL

> 全称Java Server Pages Standard Tag Library，JSP标准标签库。
>
> 用来在JSP页面上处理常见逻辑。

> 使用步骤：
>
> 0、导入jar包。
>
> 1、导入标签库。

> [注意：]()页面上的JSTL一定要与EL结合使用。

```jsp
<%@ page import="java.util.Date" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <base href="${pageContext.request.contextPath}/">
</head>
<body>
    <c:if test="${5 > 3}">
        <h1>Hello</h1>
    </c:if>
<%--
    相当于代码
    if(5 > 3){
    }else if(5 > 2){
    }else{
    }
--%>
    <c:choose>
        <c:when test="${5 > 3}">

        </c:when>
        <c:when test="${5 > 2}">

        </c:when>
        <c:otherwise>

        </c:otherwise>
    </c:choose>

    <%
        String [] arr = {"hello", "world", "aaa", "bbb"};
        request.setAttribute("arr", arr);
        Date now = new Date();
        request.setAttribute("now", now);
    %>
    <c:forEach items="${arr}" var="s">
        <li>${s}</li>
    </c:forEach>

<%--    格式化时间，切记中间不能加空格或者回车，可以直接结束--%>
    <fmt:formatDate value="${now}" pattern="yyyy-MM-dd"></fmt:formatDate>

</body>
</html>
```

#### 九、MVC模式

> 是一种编程思路，设计模式。
>
> M：Model，模型层，实体类，也包含DAO（数据模型）、Service（业务模型）
>
> V：View，视图层，用来展示页面。
>
> C：Controller，控制层，Servlet，用来处理请求，和返回响应。
>
> 将项目设计分为MVC三层，称为MVC设计模式。
>
> [核心思想：]()将视图和模型分离，以提高项目的可扩展性和可维护性。
>
> - 为什么要将视图和模型分离？
>   - 在早期，项目的开发都是使用JSP页面上直接调用模型层代码，称为`模式1`，即由视图（JSP）和模型（Model）组成，并且在视图上大量的调用模型代码。
>   - 后来，项目的要求越来越复杂，功能越来越多，需求经常变更。导致页面的代码非常多，而且很杂乱。导致基本无法维护，维护成本高，业内就探索出另一种方案，该方案要求`不能在页面上写代码`。使用Servlet和JSP，JSP侧重于写页面标签，Servlet侧重于写代码。将这种模式称为`模式2`，即将视图和模型分离，使用Controller（Servlet）层来建立视图和模型的关系。后来发展为MVC模式。
> - 如何将视图和模型分离？
>   - 使用Servlet（Controller）层。

#### 十、Servlet的简单封装

> 

```java
public class BaseServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String m = request.getParameter("m");
        if (m == null || m.trim().equals("")){
            m = "list";
        }
        try {
            this.getClass().getMethod(m, HttpServletRequest.class, HttpServletResponse.class)
                    .invoke(this, request, response);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
```

#### 十一、分页

> 界面实现：页数、条数、当前页、上一页，下一页，首页，尾页，通过数字来点击第几页

> 数据库实现：通过limit来实现
>
> limit (page-1)*size , size

> 后台实现：主要是需要一个PageBean对象来处理分页效果

#### 十二、文件上传和下载

##### 12.1 文件上传

> 前端页面编写：
>
> 1、必须使用post方式
>
> 2、必须添加enctype属性，并设置为文件上传

```jsp
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <base href="${pageContext.request.contextPath}/">
  </head>
  <body>
    <form action="upload.do" method="post" enctype="multipart/form-data">
      <input type="text" name="username" placeholder="用户名"/><br/>
      <input type="text" name="age" placeholder="年龄"/><br/>
      照片：<input type="file" name="photo"/><br/>
      <input type="submit" value="注册"/><br/>
    </form>
  </body>
</html>
```

> 后台编写：
>
> 1、添加@MultipartConfig注解

```java
@WebServlet("/upload.do")
@MultipartConfig
public class UploadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final String username = request.getParameter("username");
        final String age = request.getParameter("age");

        System.out.println("username=" + username);
        System.out.println("age=" + age);

        final Part photo = request.getPart("photo");
        // 存入服务器路径
        // 服务器路径应该使用唯一路径，避免重复
        final String name = UUID.randomUUID().toString().replace("-", "");
        photo.write(Constants.BASE_PATH + name);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
```

##### 12.2 在线查看

> 

```java
@WebServlet("/show.do")
public class ShowServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final String name = request.getParameter("name");
        FileInputStream inputStream = new FileInputStream(Constants.BASE_PATH + name);
        byte [] buffer = new byte[1024 * 8];
        int len;
        final ServletOutputStream outputStream = response.getOutputStream();
        while ((len = inputStream.read(buffer)) != -1){
            outputStream.write(buffer, 0, len);
            outputStream.flush();
        }
        outputStream.close();
        inputStream.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
```

`show.jsp`

```jsp
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <base href="${pageContext.request.contextPath}/">
</head>
<body>
    <img src="show.do?name=2e3a89c257784d5d9c0e8ea3e923cd2a"/><br/>
    <video src="show.do?name=a0d44add77604eddaaf82c374b8e4006" width="500px" controls></video>
</body>
</html>
```

##### 12.3 下载

> 将前面在线查看的代码中加一句响应流头信息设置即可。

```java
@WebServlet("/show.do")
public class ShowServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置为下载
        response.setHeader("Content-Disposition", "attachment;filename=1.jpg");
        final String name = request.getParameter("name");
        FileInputStream inputStream = new FileInputStream(Constants.BASE_PATH + name);
        byte [] buffer = new byte[1024 * 8];
        int len;
        final ServletOutputStream outputStream = response.getOutputStream();
        while ((len = inputStream.read(buffer)) != -1){
            outputStream.write(buffer, 0, len);
            outputStream.flush();
        }
        outputStream.close();
        inputStream.close();
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
    <title>Title</title>
    <base href="${pageContext.request.contextPath}/">
</head>
<body>
    <a href="show.do?name=2e3a89c257784d5d9c0e8ea3e923cd2a">下载图片</a><br/>
    <a href="show.do?name=a0d44add77604eddaaf82c374b8e4006">下载视频</a><br/>
</body>
</html>
```

#### 十三、base标签使用

> 当页面被不同的方式跳转时，路径会不一样，转发时，是转发前的路径，重定向是页面本身的路径，此时，在页面引用的样式、图片、js等静态资源可能会无法加载，此时应该使用base标签来处理该问题。

```jsp
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>emplist</title>
    <base href="${pageContext.request.contextPath}/"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="css/style.css" />
</head>
<body>
</body>
</html>
```

