<%--
  Created by IntelliJ IDEA.
  User: wangliang
  Date: 2022/11/21
  Time: 14:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <base href="${pageContext.request.contextPath}/">
  </head>
  <body>$END$

  </body>
</html>
<script>
  var s = {"age":20,"id":1,"name":"张三","sex":"男"};
  var arr = [{"age":21,"id":1,"name":"张三","sex":"男"},
    {"age":22,"id":2,"name":"李四","sex":"男"},
    {"age":23,"id":3,"name":"王五","sex":"男"}]

  // 将json转换成字符串
  s = JSON.stringify(s);
  arr = JSON.stringify(arr);

  console.log(s);
  console.log(arr);

  // 将字符串转成json
  s = JSON.parse(s);
  arr = JSON.parse(arr);

  console.log(s);
  console.log(arr);



</script>
