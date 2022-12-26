<%--
  Created by IntelliJ IDEA.
  User: wangliang
  Date: 2022/11/16
  Time: 14:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>首页</title>
    <base href="${pageContext.request.contextPath}/">
  </head>
  <body>
  <html>
  <head>
    <title>login</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="css/style.css" />
  </head>

  <body>
  <div id="wrap">
    <div id="top_content">
      <div id="header">
        <div id="rightheader">
          <p>
            2009/11/20 <br />
          </p>
        </div>
        <div id="topheader">
          <h1 id="title">
            <a href="#">main</a>
          </h1>
        </div>
        <div id="navigation"></div>
      </div>
      <div id="content">
        <p id="whereami"></p>
        <h1>登录</h1>
        <p style="color:red;">${msg}</p>
        <form action="login.do" method="post">
          <table cellpadding="0" cellspacing="0" border="0"
                 class="form_table">
            <tr>
              <td valign="middle" align="right">用户名:</td>
              <td valign="middle" align="left"><input type="text"
                                                      class="inputgri" name="username" /></td>
            </tr>
            <tr>
              <td valign="middle" align="right">密码:</td>
              <td valign="middle" align="left"><input type="password"
                                                      class="inputgri" name="password" /></td>
            </tr>
            <tr>
              <td valign="middle" align="right">验证码:</td>
              <td valign="middle" align="left"><input type="text"
                                                      class="inputgri" name="code" />
              <img id="img1" src="code.do">
                <a href="javascript:fnChange()">看不清楚，换一张</a>
              </td>
            </tr>
          </table>
          <p>
            <input type="submit" class="button" value="登录 &raquo;" />
          </p>
        </form>
      </div>
    </div>
    <div id="footer">
      <div id="footer_bg">ABC@126.com</div>
    </div>
  </div>
  </body>
  </html>
  </body>
</html>
<script>
  function fnChange() {
    var d = new Date().getTime();
    document.getElementById("img1").src = "code.do?" + d;
  }
</script>