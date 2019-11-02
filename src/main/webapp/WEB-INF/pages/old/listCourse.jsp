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
    <title>所有课程</title>
</head>
<body>
<h3>查询你的选课结果</h3>
<form action="deleteCourse" method="post">
<table border="1" cellspacing="0">
    <c:forEach items="${courses}" var="a">
        <tr>
            <td> ${a.id}</td>

            <td>${a.name}</td>
            <td> <input type="radio" name="cid" value="${a.id}"></td>
        </tr>




    </c:forEach>
</table>
    <button type="submit">删除选课</button>
</form>
<br><a href="javascript:history.go(-1)">返回上一页</a>
<br><a href="../">返回教务处主页</a>
</body>
</html>
