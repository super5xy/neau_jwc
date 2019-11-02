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
    <title>修改资料</title>
    <style>
        .loginMsg {
            color: red;
        }
    </style>
</head>
<body>
<h3>我的账户信息</h3>
<form action="editSubmit" method="post">
    <table border="1" cellspacing="0">
        <tr>
            <td class="loginMsg">学号是用户名，如改动请牢记</td>
        </tr>
        <tr>
            <td>学号</td>
            <td><input type="text" name="stuid" value="${student.stuid}"></td>
        </tr>
        <tr>
            <td>姓名</td>
            <td><input type="text" name="name" value="${student.name}"></td>
        </tr>
        <tr>
            <td>性别</td>
            <td>
                <input type="radio" name="gender" value="男"> 男
                <input type="radio" name="gender" value="女"> 女
            </td>
        </tr>
        <tr>
            <td>生日</td>
            <td><input type="date" name="birthday"></td>
        </tr>
        <tr>
            <td>个性签名</td>
            <td><input type="text" name="sign" value=" ${student.sign}"></td>
        </tr>


    </table>
    <button type="submit">提交修改</button>
</form>
<br><a href="javascript:history.go(-1)">返回上一页</a>
<br><a href="../">返回教务处主页</a>
</body>
</html>
