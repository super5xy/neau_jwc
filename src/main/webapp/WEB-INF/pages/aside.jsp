<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
    window.onload = function () {
        document.getElementById("img").onclick = function () {
            location.href = "${pageContext.request.contextPath}/jwc/setFace"
        }
        document.getElementById("img2").onclick = function () {
            location.href = "${pageContext.request.contextPath}/jwc/setFace"
        }

    }


</script>
<aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
        <!-- Sidebar user panel -->
        <div class="user-panel">
            <div class="pull-left image" style="height: 50px ; width : 50px">
                <c:if test="${empty face}"><img id="img2" src="${pageContext.request.contextPath}/images/yukino.jpg"
                                                class="img-circle" alt="User Image"></c:if>
                <c:if test="${not empty face}"><img id="img2" src="${pageContext.request.contextPath}/faces/${face}"
                                                class="img-circle" alt="User Image"></c:if>

            </div>
            <div class="pull-left info">
                <p>${name}</p>
                <a href="#"><i class="fa fa-circle text-success"></i> 在线</a>
            </div>
        </div>

        <!-- sidebar menu: : style can be found in sidebar.less -->
        <ul class="sidebar-menu">
            <li class="header">菜单</li>
            <li id="admin-index"><a
                    href="${pageContext.request.contextPath}/index.jsp"><i
                    class="fa fa-dashboard"></i> <span>首页</span></a></li>

            <li class="treeview"><a href="#"> <i class="fa fa-cogs"></i>
                <span>选课管理</span> <span class="pull-right-container"> <i
                        class="fa fa-angle-left pull-right"></i>
				</span>


            </a>
                <ul class="treeview-menu">

                    <li id="system-setting"><a
                            href="${pageContext.request.contextPath}/jwc/listCourse"> <i
                            class="fa fa-circle-o"></i> 查询我的选课
                    </a></li>
                    <li id="system-setting"><a
                            href="${pageContext.request.contextPath}/jwc/listAllCourse"> <i
                            class="fa fa-circle-o"></i> 查询我可以选的课
                    </a></li>
                </ul>
            </li>
            <li class="treeview"><a href="#"> <i class="fa fa-cube"></i>
                <span>查询资料</span> <span class="pull-right-container"> <i
                        class="fa fa-angle-left pull-right"></i>
				</span>
            </a>
                <ul class="treeview-menu">

                    <li id="system-setting"><a
                            href="${pageContext.request.contextPath}/jwc/findAllStudent">
                        <i class="fa fa-circle-o"></i> 查询注册的学生信息
                    </a></li>
                    <li id="system-setting"><a
                            href="${pageContext.request.contextPath}/jwc/myAccount"> <i
                            class="fa fa-circle-o"></i> 查询个人资料
                    </a></li>

                </ul>
            </li>

            <li class="treeview"><a href="${pageContext.request.contextPath}/jwc/courseDetail"> <i
                    class="fa fa-bars"></i>
                <span>所有学生选课结果</span> <span class="pull-right-container"> <i
                        class="fa fa-angle-left pull-right"></i>
				</span>
            </a>
            </li>

        </ul>
    </section>
    <!-- /.sidebar -->
</aside>