<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: wangliang
  Date: 2022/11/21
  Time: 16:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <base href="${pageContext.request.contextPath}/">
</head>
<body>
    姓名：<input type="text" name="username"><br/>
    电话：<input type="text" name="phone"><br/>
    省份：<select id="proSelect" onchange="fnProChange()">
        <option value="">请选择</option>
        <c:forEach items="${list}" var="pro">
            <option value="${pro.id}">${pro.name}</option>
        </c:forEach>
    </select>

    城市：<select id="citySelect">
        <option value="">请选择</option>

    </select>
</body>
</html>
<script>
    function fnProChange() {
        var p = document.getElementById("proSelect").value;
        // 1、创建XMLHttpRequest对象
        var request;
        if(window.XMLHttpRequest){
            // IE7+以及其他的浏览器
            request = new XMLHttpRequest();
        }else{
            // IE6
            request = new ActiveXObject("Microsoft.XMLHTTP");
        }
        // 2、设置回调函数
        // 当每次状态改变时会调用后面的函数
        // 有5个状态0~4，之后最后一个完成就绪状态时，才需要去调用后面的处理函数
        request.onreadystatechange = function (resp) {
            // 当请求处理完毕，且状态码为200（成功）
            if (request.readyState == 4 && request.status == 200){
                // 局部刷新页面要改变的内容
                var arr = JSON.parse(request.responseText);
                var citySelect = document.getElementById("citySelect");
                // i是下标
                // for (i = 0; i < arr.length; i++) {
                //
                // }
                citySelect.options.length = 1;
                // n还是下标
                for (n in arr) {
                    citySelect.options.add(new Option(arr[n].name, arr[n].id));
                }

            }
        };
        // 3、设置请求方式和url，打开连接
        // true表示异步发送请求，是默认值，可以省略，如果写false，表示发送同步请求
        request.open("GET", "city.do?provinceId=" + p, true);
        // 4、发送请求
        // send方法中可以传递参数，但是get是通过url传参，post也可以通过url传参
        // 但是post也可以通过send来传参
        request.send(null);
    }
</script>
