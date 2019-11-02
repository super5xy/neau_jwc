<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- 页面头部 -->
<header class="main-header">
<!-- Logo -->
<a href="${pageContext.request.contextPath}/jwc" class="logo"> <!-- mini logo for sidebar mini 50x50 pixels -->
    <span class="logo-mini"><b>教务</b></span> <!-- logo for regular state and mobile devices -->
    <span class="logo-lg"><b>东农教务</b>系统</span>
</a>
<!-- Header Navbar: style can be found in header.less -->
<nav class="navbar navbar-static-top">
<!-- Sidebar toggle button-->
<a href="#" class="sidebar-toggle" data-toggle="offcanvas"
   role="button"> <span class="sr-only">Toggle navigation</span>
</a>

<div class="navbar-custom-menu">
<ul class="nav navbar-nav">

<li class="dropdown user user-menu"><a href="#"
class="dropdown-toggle" data-toggle="dropdown"> <c:if
        test="${empty face}"><img
        src="${pageContext.request.contextPath}/images/yukino.jpg"
        class="user-image" alt="User Image"></c:if><c:if test="${not empty face}"><img
        src="${pageContext.request.contextPath}/faces/${face}"
        class="user-image" alt="User Image"></c:if> <span class="hidden-xs">
    ${name}
</span>

</a>
<ul class="dropdown-menu">
<!-- User image -->
<li class="user-header"><c:if test="${empty face}"><img id="img"
                                                        src="${pageContext.request.contextPath}/images/yukino.jpg"
                                                        class="img-circle"
                                                        alt="User Image"></c:if>
<c:if test="${not empty face}"><img id="img"
									src="${pageContext.request.contextPath}/faces/${face}"
									class="img-circle"
									alt="User Image"></c:if>
    </li>

    <!-- Menu Footer-->
    <li class="user-footer">
    <div class="pull-left">
    <a href="${pageContext.request.contextPath}/jwc/editPassword"
    class="btn btn-default btn-flat">修改密码</a>
    </div>
    <div class="pull-right">
    <a href="${pageContext.request.contextPath}/logout"
    class="btn btn-default btn-flat">注销</a>
    </div>
    </li>
    </ul>
    </li>

    </ul>
    </div>
    </nav>
    </header>
    <!-- 页面头部 /-->