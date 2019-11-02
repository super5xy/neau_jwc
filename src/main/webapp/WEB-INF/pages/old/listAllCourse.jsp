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
    <title>欢迎选课</title>
</head>
<body>
<h3>选课界面</h3>
<form action="saveCourse" method="post">
<table border="1" cellspacing="0">
    <p>${loginMsg}</p>
    <c:forEach items="${courses}" var="a">
        <tr>
            <td> ${a.id}</td>

            <td>${a.name}</td>
            <td> <input type="radio" name="cid" value="${a.id}"></td>
        </tr>






    </c:forEach>
</table>

    <button type="submit">选课提交</button>
</form>
<br><a href="javascript:history.go(-1)">返回上一页</a>
<br><a href="../">返回教务处主页</a>
</body>
</html>
