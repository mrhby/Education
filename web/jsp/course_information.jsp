<%@ page import="com.dao.UserDao" %>
<%@ page import="com.dao.Impl.UserDaoImpl" %>
<%@ page import="java.util.List" %>
<%@ page import="com.entity.Course" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>课程信息</title>
<link href="../css/bootstrap.min.css" rel="stylesheet"/>
<link href="../css/datepicker3.css" rel="stylesheet"/>
<link href="../css/styles.css" rel="stylesheet"/>
<link rel="stylesheet" href="../css/table.css">
	<style type="text/css">
		@font-face {
			font-family: 'Glyphicons Halflings';
			src: url('../font/glyphicons-halflings-regular.eot');
			src: url('../font/glyphicons-halflings-regular.eot?#iefix')
			format('embedded-opentype'), url('../font/glyphicons-halflings-regular.woff')
			format('woff'), url('../font/glyphicons-halflings-regular.ttf')
			format('truetype'), url('../font/glyphicons-halflings-regular.svg#glyphicons_halflingsregular') format('svg');
		}
	</style>
</head>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#sidebar-collapse">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#"><span>学生</span>选课系统</a>
				<ul class="user-menu">
					<li class="dropdown pull-right">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown"><span class="glyphicon glyphicon-user"></span>用户:${sessionScope.stunam}<span class="caret"></span></a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="#"> Profile</a></li>
							<li><a href="#"> Settings</a></li>
							<li><a href="#" onclick="window.location.href='../ExitServlet'"> Logout</a></li>
						</ul>
					</li>
				</ul>
			</div>
		</div><!-- /.container-fluid -->
	</nav>
		
	<div id="sidebar-collapse" class="col-sm-3 col-lg-2 sidebar">
		<form role="search">
			<div class="form-group">
				<input type="text" class="form-control" placeholder="Search">
			</div>
		</form>
		<ul id="main-nav" class="nav nav-tabs nav-stacked" style="">
			<li class="active">
				<a href="#">
					<i class="glyphicon glyphicon-th-large"></i>
					首页
				</a>
			</li>
			<li>
				<a href="#systemSetting" class="nav-header collapsed" data-toggle="collapse">
					<i class="glyphicon glyphicon-cog"></i>
					用户管理
					<span class="pull-right glyphicon glyphicon-chevron-down"></span>
				</a>
				<ul id="systemSetting" class="nav nav-list collapse secondmenu in" style="height: 0;">
					<li><a href="mainPage.jsp"><span class="glyphicon glyphicon-user"></span>用户基本信息</a></li>
					<li><a href="delete_course.jsp"><span class="glyphicon glyphicon-eye-open"></span>查询已选课程</a></li>
					<li class="active"><a href="course_information.jsp"><span class="glyphicon glyphicon-globe"></span>课程信息</a></li>
					<li><a href="change_password.jsp"><span class="glyphicon glyphicon-edit"></span>修改密码</a></li>
					<li role="presentation" class="divider"></li>
				</ul>
			</li>
		</ul>
	</div><!--/.sidebar-->
		
	<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">			
		<div class="row">
			<ol class="breadcrumb">
				<li class="active">/课程信息</li>
			</ol>
		</div><!--/.row-->
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">课程信息</h1>
			</div>
		</div><!--/.row-->
		<%
			UserDao userDao = new UserDaoImpl();
		    List<Course> courseList = userDao.selectAllCourse();
		    request.setAttribute("courseList",courseList);
		%>
		<table border="1" class="table-hover table-striped">
			<tr>
				<td>课程ID</td>
				<td>课程名称</td>
				<td>课程时间</td>
				<td>教室号</td>
				<td>老师名</td>
				<td>选课</td>
			</tr>
			<c:forEach var="course" items="${courseList}">
				<tr>
					<td id="couid">${course.couid}</td>
					<td>${course.counam}</td>
					<td>${course.coutimes}</td>
					<td>${course.couroom}</td>
					<td>${course.courtea}</td>
					<td><input type="button" id="addCourse" class="btn btn-primary" onclick="window.location.href='../AddServlet?couid=${course.couid}'" value="增加课程"></td>
				</tr>
			</c:forEach>
		</table>
	</div>	<!--/.main-->

	<script src="../js/jquery-3.2.1.min.js"></script>
	<script src="../js/bootstrap.min.js"></script>
	<script src="../js/chart.min.js"></script>
	<script src="../js/chart-data.js"></script>
</body>

</html>
