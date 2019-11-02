<%--
  Created by IntelliJ IDEA.
  User: super5xy
  Date: 2019/10/25
  Time: 18:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>我的资料</title>
    <style>
        .loginMsg {
            color: red;
        }
    </style>
</head>
<body>
<h3>我的账户信息</h3>
<table border="1" cellspacing="0">
    <p class="loginMsg">${loginMsg}</p>
    <tr>
        <td>id</td>
        <td> ${student.id}</td>
    </tr>
    <tr>
        <td>学号</td>
        <td> ${student.stuid}</td>
    </tr>
    <tr>
        <td>姓名</td>
        <td> ${student.name}</td>
    </tr>
    <tr>
        <td>性别</td>
        <td> ${student.gender}</td>
    </tr>
    <tr>
        <td>生日</td>
        <td> <fmt:formatDate value="${student.birthday}" pattern="yyyy年MM月dd日"/></td>
    </tr>
    <tr>
        <td>个性签名</td>
        <td> ${student.sign}</td>
    </tr>




</table>
<br>

<a href="editAccount">修改资料</a>
<br><a href="javascript:history.go(-1)">返回上一页</a>
<br><a href="../">返回教务处主页</a>
</body>
</html>
