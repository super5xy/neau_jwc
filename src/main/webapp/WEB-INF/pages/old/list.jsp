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
    <title>哈喽</title>
</head>
<body>
<h3>查询所有账户</h3>
<table border="1" cellspacing="0">
    <c:forEach items="${account}" var="a">
        <tr>
            <td> ${a.id}</td>
            <td>${a.money}</td>
            <td>${a.name}</td>
        </tr>




    </c:forEach>
</table>
<br><a href="javascript:history.go(-1)">返回上一页</a>
<br><a href="../">返回教务处主页</a>
</body>
</html>
