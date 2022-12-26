> 王亮
>
> 397979853
>
> 18672383921



### Servlet

#### 一、软件架构

> 在软件发展过程中，有两种基本的软件架构。CS和BS。

##### 1.1 CS架构

> Client/Server，客户端/服务器程序。
>
> 优点：
>
> - 图形化的效果较好（3D等）
>
> 缺点：
>
> - 需要下载客户端
> - 升级不仅需要升级服务器，而且需要重新下载客户端

##### 1.2 BS架构

> Browser/Server，浏览器/服务器程序
>
> 优点：
>
> - 无需下载客户端，任意系统只要有浏览器即可使用
> - 更新比较方便，只需要升级服务器即可
>
> 缺点：
>
> - 图形化效果显示不好

#### 二、服务器

> 静态资源：HTML 、CSS、JS
>
> 动态资源：Servlet、JSP
>
> 在Java中，动态资源的开发技术统称为Java Web。

> Web服务器：用来运行和发布web应用的容器。
>
> web项目必须放到web容器（Web服务器）中才能运行，才能使网络中的用户使用浏览器访问。

> 常用的web服务器：
>
> - 开源免费
>   - Tomcat
>   - Jetty
>   - Resin
> - 收费
>   - WebLogic（BEA，后被Oracle收购）
>   - WebSphere（IBM）
>   - 功能强大，耗资源

#### 三、Tomcat服务器

> Tomcat是Apache的一个核心项目。目录结构如下：
>
> bin：可执行文件
>
> conf：配置文件
>
> lib：第三方库，jar包
>
> logs：日志文件
>
> temp：临时文件
>
> webapps：开发的代码打包后放的位置
>
> - ROOT：默认项目
>
> work：JSP转译成servlet时，源代码和字节码的位置

> 启动：
>
> - 打开bin目录，双击startup.bat文件
>
> 访问：
>
> - 打开浏览器，输入：http://localhost:8080，就可以访问首页（ROOT项目）
>
> 停止：
>
> - 强制关闭
> - 在bin目录，双击shutdown.bat
>
> 修改端口号：
>
> - 打开conf文件夹，打开server.xml，修改以下内容
>
>   ```xml
>   <Connector port="8080" protocol="HTTP/1.1"
>                  connectionTimeout="20000"
>                  redirectPort="8443" />
>   ```
>
>   将port修改成想要的端口号，注意不要与已使用的端口号冲突。修改后需要重启才有效。

> 404：报错信息，找不到页面。

#### 四、Servlet概述

> 是指运行在服务器端的一段程序。
>
> - 动态网页技术
> - 是JavaWeb的基础。
> - 用来处理客户端的请求，并完成响应
>
> 作用：
>
> - 处理客户端的请求
> - 在服务端动态生成网页，并返回给客户端
> - 直接跳转到已经存在的网页

#### 五、开发步骤

> 1、导入包servlet-api.jar。（创建Java Enterprise 工程时，会自动导入tomcat的包）
>
> 2、编写Servlet
>
> 3、在web.xml中配置Servlet的访问路径
>
> 4、将程序部署到tomcat中，并运行

> 客户端如何发送请求：
>
> - 表单提交（action属性设置服务器的路径）
> - 链接
> - 使用js中的location.href
>
> 服务端响应：
>
> - 服务端处理：使用Java代码进行相应的处理（业务逻辑、数据库操作）
>
> - 服务器返回信息：
>   - 动态生成网页，并显示
>   - 跳转到已经存在的网页

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <form method="post" action="ls.do">
        <input type="text" name="username" placeholder="请输入用户名"/><br/>
        <input type="text" name="pwd" placeholder="请输入密码"/><br/>
        <input type="submit" value="登录">
    </form>
</body>
</html>
```

`LoginServlet`

```java
public class LoginServlet implements Servlet {
    /**
     * 初始化
     * @param servletConfig
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    /**
     * 获取servlet配置信息
     * @return
     */
    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * 服务
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        // 接收请求
        final String username = request.getParameter("username");
        final String pwd = request.getParameter("pwd");
        // 处理请求
        if (username.equals("zhangsan") && pwd.equals("123456")){
            // 返回成功信息
            // 跳转页面(相当于a链接)
            ((HttpServletResponse)response).sendRedirect("success.html");
        }else{
            // 返回失败信息
            // 设置响应的格式为html页面
            response.setContentType("text/html;charset=utf-8");
            // 动态生成页面并显示
            final PrintWriter writer = response.getWriter();
            writer.write("<!DOCTYPE html>");
            writer.write("<html lang=\"en\">");
            writer.write("<head>");
            writer.write("<meta charset=\"UTF-8\">");
            writer.write("<title>Title</title>");
            writer.write("</head>");
            writer.write("<body>");
            for (int i = 0; i < 10; i++) {
                writer.write("<h1>登录失败</h1>");
            }
            writer.write("</body>");
            writer.write("</html>");
        }
    }

    /**
     * 获取servlet信息
     * @return
     */
    @Override
    public String getServletInfo() {
        return null;
    }

    /**
     * 销毁
     */
    @Override
    public void destroy() {

    }
}
```

`success.html`

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <h1>登录成功</h1>
</body>
</html>
```

#### 六、HTTP协议

> 超文本传输协议。运行于TCP的协议之上。
>
> - 基于请求响应模式
> - 无状态协议
> - HTTP1.1

> 请求报文。（发送请求时的格式）
>
> - 请求头
>   - 方法：GET或者POST
>   - 请求url（包含GET提交的表单信息）
>   - 协议的版本HTTP1.1
>   - IP地址和端口号
> - 请求正文
>   - POST提交的表单信息

> 响应报文。
>
> - 响应头
>   - 协议版本
>   - 状态行，例如：200（状态码） OK（描述）
>   - 返回类型。（text/html;charset=utf-8）
>   - 内容长度
> - 响应正文
>   - 内容

> 常见的状态码：
>
> - 200 OK，成功
> - 400 ，参数类型格式转换错误（在springMVC框架中比较常见）
> - 403, Forbidden，接收到请求，但是不提供服务
> - 404，Not Found，页面未找到
> - 500，服务器代码出错

#### 七、Servlet核心接口和类

> Servlet接口：
>
> - init：初始化数据
> - getServletConfig
> - getServletInfo
> - service：核心方法，作用是用来处理请求和返回响应
> - destroy：销毁前执行
>
> GenericServlet抽象类：
>
> - 实现了Servlet接口
> - 将除了service方法以外的其他方法进行近乎空的实现。作用是可以更容易的编写Servlet
>
> HttpServlet抽象类：
>
> - 继承了GenericServlet类，并实现了service方法，该方法将HTTP协议加入了
> - 并在service方法中，将请求的不同种类进行了分发，get请求执行doGet方法，post请求执行doPost方法等。
> - 提供了doGet、doPost等方法，并在这些方法中写了发送错误的代码，在子类中如果不发送相应的请求，可以不重写该方法，但是如果发送了请求而没有重写该方法，会报错。
>
> 综上所述，一般情况下，编写Servlet应该继承HttpServlet，并重写doGet、doPost等方法。
>
> [经典面试题：]()
>
> 如果在继承自HttpServlet的类中，重写了doGet和doPost以及service方法，那么发送一个get请求，会调用哪个方法？
>
> - service方法。

#### 八、Servlet的配置

> 1、使用web.xml进行配置
>
> - 在配置文件中配置，可以兼容旧的版本
> - 可以在生产环境下修改。
> - 可以对第三方写的Servlet进行配置

```xml
<!--    给servlet起个名字-->
<servlet>
    <servlet-name>loginServlet</servlet-name>
    <servlet-class>com.qf.day37.servlet.LoginServlet</servlet-class>
</servlet>
<!--    给对应的名字一个访问路径-->
<servlet-mapping>
    <servlet-name>loginServlet</servlet-name>
    <url-pattern>/ls.do</url-pattern>
</servlet-mapping>
```

> 2、使用注解配置
>
> - 简单
> - 只有Servlet3.0以上的版本才可以使用

```java
@WebServlet("/login.do")
public class LoginServlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
    }
}
```

> [注意：]()  1、Servlet配置路径时，在配置的地方一定要加`/`。否则会出现`Invalid <url-pattern> ls.do in servlet mapping`。导致项目无法启动。
>
> 2、两个Servlet配置的路径不能相同。否则会出现`The servlets named [com.qf.day37.servlet.LoginServlet2] and [com.qf.day37.servlet.LoginServlet3] are both mapped to the url-pattern [/login.do] which is not permitted`，导致项目无法启动。
>
> 3、如果在控制中没有报错信息，应该点击旁边的两个Tomcat相关的Log窗口查看错误信息。
>
> 4、在页面发送该路径请求时一定不要加`/`，否则会出现无法访问或404.

> Servlet默认是在第一次访问时才由容器创建对象。仅创建一个对象。但是一直持续提供服务。

> load-on-startup默认为-1，表示第一次访问时才创建对象，可以设置为0或者正整数，以便容器启动时就创建对象。数字越小，优先级越高（先创建）

```xml
<!--    给servlet起个名字-->
    <servlet>
        <servlet-name>loginServlet</servlet-name>
        <servlet-class>com.qf.day37.servlet.LoginServlet</servlet-class>
        <load-on-startup>2</load-on-startup>
    </servlet>
<!--    给对应的名字一个访问路径-->
    <servlet-mapping>
        <servlet-name>loginServlet</servlet-name>
        <url-pattern>/ls.do</url-pattern>
    </servlet-mapping>
```

```java
@WebServlet(value = "/login.do", loadOnStartup = 3)
public class LoginServlet2 extends HttpServlet {}
```

#### 九、GET和POST的区别

> GET：
>
> - 将表单数据放到url上，使用?后面拼接参数，以键值对的方式，多个参数使用&连接。
> - 数据不安全
> - url长度有限制，所以get不能提交大量的数据信息
> - 不能用来上传文件
> - 效率相对高
> - 链接分享时，作为邮件发送时，一般用get方式
>
> POST：
>
> - 将表单数据放到请求正文里
> - 数据相对安全
> - post数据长度理论来说没有限制
> - 可以用来上传文件
> - 效率相对低

> 疑问：为什么Javaweb中没有main方法？
>
> main方法在Tomcat中，当启动Tomcat，就相当于启动了main方法。

#### 十、request对象和response对象

##### 10.1 request对象

> 封装用户的请求。
>
> 常用方法：
>
> - getParameter("key"); 获取请求参数
> - getParameterValues("key"); 获取一组相同name的请求参数，返回一个数组
> - setCharacterEncoding("utf-8"); 设置POST请求字符集

```html
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
	</head>
	<body>
		<form action="reg.do" method="post">
			<input type="text" name="username" placeholder="请输入用户名"/><br />
			<!--密码框-->
			<input type="password" name="password" value="" placeholder="请输入密码"/><br />
			<!--数字框-->
			<input type="number" name="age" value="" placeholder="请输入年龄"/><br />
			性别：<input type="radio" checked="checked" name="sex" value="男"/>男
			<input type="radio" name="sex" value="女"/>女<br />
			<!--复选框-->
			爱好：<input type="checkbox" name="hobby" value="睡觉"/>睡觉
			<input type="checkbox" name="hobby" value="打游戏"/>打游戏
			<input type="checkbox" name="hobby" value="看小说"/>看小说<br />
			<!--下拉框，默认为单选，可以通过设置multiple="multiple"来实现多选-->
			职业：<select name="position">
				<option value="1">法师</option>
				<option value="2">射手</option>
				<option value="3">肉</option>
			</select><br />
			<!--文本域，rows表示行，cols表示列-->
			自我介绍：<textarea name="introduce" cols="100" rows="10"></textarea><br />
			<!--提交按钮，点击后会提交表单到action对应的地址-->
			<input type="submit" value="提交"/>
		</form>
	</body>
</html>
```

```java
@WebServlet("/reg.do")
public class RegServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 针对Post的转码
        request.setCharacterEncoding("utf-8");
        final String username = request.getParameter("username");
        final String password = request.getParameter("password");
        final String age = request.getParameter("age");
        final String sex = request.getParameter("sex");
        final String [] hobbies = request.getParameterValues("hobby");
        final String position = request.getParameter("position");
        final String introduce = request.getParameter("introduce");
    }
}
```

##### 10.2 response对象

> 用来封装响应对象：
>
> - setHeader(""); 设置响应头信息，一般情况下不用设置，主要是下载时需要设置。
> - setContentType(""); 设置响应的格式。
> - setCharacterEncoding("");设置响应编码。在响应格式中可以设置编码，不需要通过此代码设置。
> - getWriter(); 获取页面输出流
>
> 响应输出乱码问题解决：`response.setContentType("text/html;charset=utf-8");`

```java
public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
    // 接收请求
    final String username = request.getParameter("username");
    final String pwd = request.getParameter("pwd");
    // 处理请求
    if (username.equals("zhangsan") && pwd.equals("123456")){
        // 返回成功信息
        // 跳转页面(相当于a链接)
        ((HttpServletResponse)response).sendRedirect("success.html");
    }else{
        // 返回失败信息
        // 设置响应的格式为html页面
        response.setContentType("text/html;charset=utf-8");
        // 动态生成页面并显示
        final PrintWriter writer = response.getWriter();
        writer.write("<!DOCTYPE html>");
        writer.write("<html lang=\"en\">");
        writer.write("<head>");
        writer.write("<meta charset=\"UTF-8\">");
        writer.write("<title>Title</title>");
        writer.write("</head>");
        writer.write("<body>");
        for (int i = 0; i < 10; i++) {
            writer.write("<h1>登录失败</h1>");
        }
        writer.write("</body>");
        writer.write("</html>");
    }
}
```

#### 十一、转发和重定向

> 跳转页面。

##### 11.1 请求转发

> - 使用请求对象。
> - 会将请求对象传到下一个路径，不会丢失。
> - 请求路径不会发生变化。
> - 只能站内转发
> - 当需要将数据放入到请求中，并且在下一个路径将数据取出，可以使用：
>   - request.setAttribute("key", value); 设置数据，键值对方式，key只能是string，值可以是任意类型。
>   - request.getAttribute("key"); 获取数据，通过key获取。返回Object类型，需要强转。
>   - request.removeAttribute("key"); 删除request中的数据。
>
> 语法：

```java
request.getRequestDispatcher("路径").forward(request, response);
```

##### 11.2 重定向

> - 使用响应对象。
> - 相当于a链接。
> - 丢失请求的所有信息。
> - 会显示新的路径。
> - 可以重定向到其他网站。
> - 如果要实现数据传递，可以使用get方式，将参数放到url中，但是只能是基本类型和string，然后新的路径通过request.getParameter()获取。不推荐使用此方式。
>
> 语法：

```java
response.sendRedirect("路径");
```

#### 十二、Servlet生命周期

> 是指Servlet从创建到销毁过程中的状态。
>
> - 创建：对象的创建过程，只会执行一次，默认为在第一次访问时执行
> - 初始化：init方法，只会执行一次
> - 服务：service方法，用来处理用户的请求和返回响应。核心方法，会执行多次
> - 销毁：destroy方法，只会执行一次，在对象被销毁前执行。

#### 十三、Servlet特性

> [经典面试题：]()简述Servlet的单实例多线程
>
> - servlet对象是由容器创建，只会创建一个，默认在第一次访问时创建，可以通过设置load-on-startup的值来让servlet在容器启动时就创建。
> - 只有一个对象，却提供了多个请求同时访问的效果，说明它是多线程访问的。
> - 如果在servlet中设置属性，则该属性是多线程共享，可能会出现线程安全问题。
> - 应该尽量避免上述情况的发生，如果有，可以通过线程同步的方式来解决该问题，但是可能因此而降低性能。

#### 十四、状态管理

> HTTP协议是无状态的，服务器不记录客户端的信息。
>
> 状态管理是指服务器能够记录客户端的信息。将一个客户端的多次操作关联起来。
>
> 有两种方式来解决此问题：
>
> - 客户端技术：在客户端记录用户信息，每次给服务器发送请求时，将客户端记录的信息一起发送。cookie技术，在客户端以文本明文的方式记录信息，不安全，大小有限制（4kb），类型只能是字符串。
> - 服务器技术：session技术。在服务器记录用户信息，但是将用户身份编码发送到客户端，客户端将该id记录在cookie中，每次给服务器发送请求时，将客户端记录的id一起发送，服务器接收id后，查找该id对应的信息，相对安全，大小理论没有限制，类型没有限制。

##### 14.1 cookie的使用

```java
@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final String username = request.getParameter("username");
        final String password = request.getParameter("password");
        if (username.equals("zhangsan") && password.equals("123456")){
            // 将信息保存到cookie中
            // 创建cookie
//            Cookie cookie = new Cookie("username", "zhangsan");
            // 如果要保存中文的值，需要编码
            String name = URLEncoder.encode("张三", "utf-8");
            System.out.println(name);
            Cookie cookie = new Cookie("username", name);
            // 设置path
            cookie.setPath("/");
            // 设置生命周期
            // 单位为秒，表示该cookie保存的时长
            // 如果设置为0，表示立即失效，即删除
            // 如果设置为负数。-1，表示浏览器关闭后失效。
            cookie.setMaxAge(2*60);
            // 响应到客户端
            response.addCookie(cookie);
            response.sendRedirect("home.do");
        }else{
            response.sendRedirect("login.html");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
```

```java
@WebServlet("/home.do")
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = null;
        // 在cookie中获取key为username对应的value值
        final Cookie[] cookies = request.getCookies();
        if (cookies != null){
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("username")){
                    // 默认取值为英文
                    username = cookie.getValue();
                    // 如果是中文，需要反编码
                    username = URLDecoder.decode(username, "utf-8");
                }
            }
        }
        if(username == null){
            response.sendRedirect("login.html");
        }else{
            response.setContentType("text/html;charset=utf-8");
            final PrintWriter out = response.getWriter();
            out.print("<h1>欢迎您，"+username+"</h1>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
```

> 优点：
>
> - 可配置到期时间
> - 简单，使用键值对操作
> - 数据持久，即使关机后，再开机还保存
>
> 缺点：
>
> - 大小受限制，根据浏览器不同，有4k和8k的限制
> - 可能会被用户禁用
> - 存在风险，可能会被篡改

##### 14.2 session的使用

> session称为会话，一次会话表示使用同一个浏览器发送多次请求，浏览器关闭，则结束会话。
>
> 创建session对象：

```java
HttpSession session = request.getSession();
// 类似于request存数据
// 存数据
session.setAttribute("key", value);
// 获取数据
session.getAttribute("key");
// 删除数据
session.removeAttribute("key");
```

> 作用域：
>
> - request作用域：作用在同一个请求之内，（可以是使用请求转发的多个路径）
> - session作用域：在同一个浏览器多次发送请求时，所有路径均有效，除非浏览器关闭，或者主动销毁session。
>   - 失效方式：
>     - 1、关闭浏览器
>     - 2、超时：session默认有效时间为30分钟，可以通过session.setMaxInactiveInterval(second)来设置。当一直没有向服务器发送请求，时间超过了超时时间，会失效。
>     - 3、注销：session.invalidate()

```java
@WebServlet("/home.do")
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 在session中获取登录后存入的用户信息
        String username = (String) request.getSession().getAttribute("username");
        if(username == null){
            response.sendRedirect("login.html");
        }else{
            response.setContentType("text/html;charset=utf-8");
            final PrintWriter out = response.getWriter();
            out.print("<h1>欢迎您，"+username+"</h1>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
```

```java
@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final String username = request.getParameter("username");
        final String password = request.getParameter("password");
        if (username.equals("zhangsan") && password.equals("123456")){
            request.getSession().setAttribute("username", "张三");
            response.sendRedirect("home.do");
        }else{
            response.sendRedirect("login.html");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
```

> [注意：]()session中保存的数据会较为长久的驻留在服务器内存中，不应该将大量数据保存在session中，所以如果有大量数据需要传递，应该使用request对象。session一般用来保存用户身份信息、权限信息等。

##### 14.3 ServletContext对象

> ServletContext接口的对象，一般会被命名为application对象。该对象也可以存储数据。

```java
final ServletContext application = request.getServletContext();
// 类似于request存数据
// 存数据
application.setAttribute("key", value);
// 获取数据
application.getAttribute("key");
// 删除数据
application.removeAttribute("key");
```

> 在整个服务器上有效，意味着常驻内存。而且对所用用户有效。除非重启服务器或者通过removeAttribute删除，否则一直存在。所以一般用来保存服务器的设置信息等。

```java
@WebServlet("/count.do")
public class CountServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final ServletContext application = request.getServletContext();
        Long count = (Long) application.getAttribute("count");
        if (count == null){
            count = 0L;
        }
        count++;
        application.setAttribute("count", count);
        response.setContentType("text/html;charset=utf-8");
        final PrintWriter out = response.getWriter();
        out.print("<h1>该网页被访问了"+count+"次</h1>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
```

#### 十五、Filter

> 在Javaweb中，用来拦截用户请求，并根据用户的请求信息判定是否合法，如果不合法，可以停止该请求过程，将其跳转到其他路径。

> 步骤：
>
> 1、实现Filter接口，并重写doFilter方法。
>
> 2、对其拦截路径进行配置。（类似Servlet）

> 常用场景：
>
> 1、转码
>
> 2、权限拦截

> 两种配置方式：
>
> 1、web.xml

```xml
<filter>
    <filter-name>encodingFilter</filter-name>
    <filter-class>com.qf.ems.util.EncodingFilter</filter-class>
</filter>
<filter-mapping>
    <filter-name>encodingFilter</filter-name>
    <url-pattern>/*</url-pattern>
</filter-mapping>
```

> 2、使用注解

```java
@WebFilter("/*")
public class AuthFilter implements Filter{
}
```

> 过滤器链：
>
> 多个过滤器在项目中形成一个过滤器链，应该依次拦截请求进行过滤，通过以下代码执行。

```java
// 让过滤器链上的其他过滤器执行，（放行）注意：此代码必须写在最后一行
filterChain.doFilter(servletRequest, servletResponse);
```

> 编码过滤器：

```java
@WebFilter("/*")
public class EncodingFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding("utf-8");

        // 让过滤器链上的其他过滤器执行，（放行）注意：此代码必须写在最后一行
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
```

> 权限过滤器：

```java
@WebFilter("/*")
public class AuthFilter implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        // 得到用户的访问路径
//        System.out.println(request.getRequestURI());
//        System.out.println(request.getRequestURL());
        String uri = request.getRequestURI();
        String contextPath = request.getContextPath() + "/";
        if (uri.equals(contextPath) || uri.endsWith("/code.do") || uri.endsWith("/index.jsp") ||
            uri.endsWith("/login.do") || uri.endsWith(".css") || uri.endsWith(".js") || uri.endsWith(".gif")
        ){}else {
            if(request.getSession().getAttribute("user") == null){
                response.sendRedirect(contextPath);
                // 一定记得加return
                return;
            }
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
```

