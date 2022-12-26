<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改员工</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css"
          href="css/style.css" />
</head>

<body>
<div id="wrap">
    <div id="top_content">
        <div id="header">
            <div id="rightheader">
                <p>
                    2009/11/20
                    <br />
                </p>
            </div>
            <div id="topheader">
                <h1 id="title">
                    <a href="#">Main</a>
                </h1>
            </div>
            <div id="navigation">
            </div>
        </div>
        <div id="content">
            <p id="whereami">
            </p>
            <h1>
                员工信息修改:
            </h1>

            <form action="employee.do" method="post" enctype="multipart/form-data">
                <table cellpadding="0" cellspacing="0" border="0"
                       class="form_table">
                    <tr>
                        <td valign="middle" align="right">
                            编号:
                        </td>
                        <td valign="middle" align="left">
                            ${employee.id}
                                <input type="hidden" name="m" value="update">
                            <input type="hidden" class="inputgri" name="id" value="${employee.id}"/>
                        </td>
                    </tr>
                    <tr>
                        <td valign="middle" align="right">
                            姓名:
                        </td>
                        <td valign="middle" align="left">
                            <input type="text" class="inputgri" name="name" value="${employee.name}"/>
                        </td>
                    </tr>
                    <tr>
                        <td valign="middle" align="right">
                            性别:
                        </td>
                        <td valign="middle" align="left">
                            <input type="radio"
                                   <c:if test="${employee.sex == 1}">
                                       checked="checked"
                                   </c:if>
                                   name="sex" value="1"/>男
                            <input type="radio"
                                    <c:if test="${employee.sex == 0}">
                                        checked="checked"
                                    </c:if>
                                   name="sex" value="0"/>女<br />
                        </td>
                    </tr>
                    <tr>
                        <td valign="middle" align="right">
                            薪资:
                        </td>
                        <td valign="middle" align="left">
                            <input type="text" class="inputgri" name="salary" value="${employee.salary}"/>
                        </td>
                    </tr>
                    <tr>
                        <td valign="middle" align="right">
                            年龄:
                        </td>
                        <td valign="middle" align="left">
                            <input type="text" class="inputgri" name="age" value="${employee.age}"/>
                        </td>
                    </tr>
                    <tr>
                        <td valign="middle" align="right">
                            图片:
                        </td>
                        <td valign="middle" align="left">
                            <input type="hidden" name="photo" value="${employee.photo}">
                            <input type="file" class="inputgri" name="file" onchange="selImage(this)"/>
                            <img alt="" id="img" src="show.do?file=${employee.photo}" width="200px"> <br/>
                        </td>
                    </tr>
                    <tr>
                        <td valign="middle" align="right">
                            部门:
                        </td>
                        <td valign="middle" align="left">
                            <select name="deptId">
                                <c:forEach items="${list}" var="dept">
                                    <option
                                            <c:if test="${employee.deptId == dept.id}">
                                                selected
                                            </c:if>
                                            value="${dept.id}">${dept.name}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td valign="middle" align="right">
                            爱好:
                        </td>
                        <td valign="middle" align="left">
                            <input type="checkbox"
                                    <c:if test="${employee.hobby.indexOf('看书') != -1}">
                                        checked
                                    </c:if>
                                   name="hobby" value="看书"/>看书
                            <input type="checkbox"
                                    <c:if test="${employee.hobby.indexOf('踢足球') != -1}">
                                        checked
                                    </c:if>
                                   name="hobby" value="踢足球"/>踢足球
                            <input type="checkbox"
                                    <c:if test="${employee.hobby.indexOf('打篮球') != -1}">
                                        checked
                                    </c:if>
                                   name="hobby" value="打篮球"/>打篮球
                        </td>
                    </tr>
                </table>
                <p>
                    <input type="submit" class="button" value="提交" />
                </p>
            </form>
        </div>
    </div>
    <div id="footer">
        <div id="footer_bg">
            ABC@126.com
        </div>
    </div>
</div>
</body>
</html>
<script type="text/javascript">
    function selImage(o) {
        document.getElementById("img").src = getFullPath(o);
    }

    function getFullPath(node){
        var imgURL = "";
        try{
            var file = null;
            if(node.files && node.files[0] ){
                file = node.files[0];
            }else if(node.files && node.files.item(0)) {
                file = node.files.item(0);
            }
            //Firefox 因安全性问题已无法直接通过input[file].value 获取完整的文件路径
            try{
                //Firefox7.0
                imgURL =  file.getAsDataURL();
                //alert("//Firefox7.0"+imgRUL);
            }catch(e){
                //Firefox8.0以上
                imgURL = window.URL.createObjectURL(file);
                //alert("//Firefox8.0以上"+imgRUL);
            }
        }catch(e){
            //支持html5的浏览器,比如高版本的firefox、chrome、ie10
            if (node.files && node.files[0]) {
                var reader = new FileReader();
                reader.onload = function (e) {
                    imgURL = e.target.result;
                };
                reader.readAsDataURL(node.files[0]);
            }
        }
        return imgURL;
    }
</script>