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
            <option
                    <c:if test="${provinceId == pro.id}">selected</c:if>
                    value="${pro.id}">${pro.name}</option>
        </c:forEach>
    </select>

    城市：<select>
        <option value="">请选择</option>
        <c:forEach items="${cityList}" var="city">
            <option

                    value="${city.id}">${city.name}</option>
        </c:forEach>
    </select>
</body>
</html>
<script>
    function fnProChange() {
        var p = document.getElementById("proSelect").value;
        location.href = "city.do?provinceId=" + p;
    }
</script>
