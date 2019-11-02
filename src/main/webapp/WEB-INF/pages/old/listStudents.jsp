<%--
  Created by IntelliJ IDEA.
  User: super5xy
  Date: 2019/10/25
  Time: 18:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>学生列表</title>
</head>
<body>
<h3>已注册的学生列表</h3>
<table border="1" cellspacing="0">
    <c:forEach items="${students}" var="a">
        <tr>
            <td> ${a.id}</td>

            <td>${a.stuid}</td>
            <td>${a.name}</td>
            <td><a href="othersAccount?id=${a.id}">查看ta的资料</a> </td>
        </tr>




    </c:forEach>
</table>
<br><a href="javascript:history.go(-1)">返回上一页</a>
<br><a href="../">返回教务处主页</a>
</body>
</html>
