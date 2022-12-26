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