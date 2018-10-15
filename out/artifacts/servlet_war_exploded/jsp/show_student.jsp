<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>班级学生</title>
<link href="../css/bootstrap.min.css" rel="stylesheet">
<link href="../css/datepicker3.css" rel="stylesheet">
<link href="../css/styles.css" rel="stylesheet">
	<style type="text/css">
		#a{
			margin-left: 480px;
			margin-top: 30px;
		}
	</style>
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
					<li class="active"><a href="delete_course.jsp"><span class="glyphicon glyphicon-eye-open"></span>查询已选课程</a></li>
					<li><a href="course_information.jsp"><span class="glyphicon glyphicon-globe"></span>课程信息</a></li>
					<li><a href="change_password.jsp"><span class="glyphicon glyphicon-edit"></span>修改密码</a></li>
					<li role="presentation" class="divider"></li>
				</ul>
			</li>
		</ul>
	</div><!--/.sidebar-->
		
	<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">			
		<div class="row">
			<ol class="breadcrumb">
				<li class="active">/班级同学</li>
			</ol>
		</div><!--/.row-->
		
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">班级同学</h1>
			</div>
		</div><!--/.row-->

		<c:choose>
			<c:when test="${sessionScope.studentList.size() == 0}">
				<p style="text-align: center">班级暂无同学</p>
			</c:when>
			<c:otherwise>
				<table border="1" class="table-striped table-hover table table-bordered">
					<tr>
						<td>学号</td>
						<td>姓名</td>
						<td>性别</td>
						<td>生日</td>
						<td>班级</td>
					</tr>
					<c:forEach var="student" items="${sessionScope.studentList}">
						<tr>
							<td>${student.stuid}</td>
							<td>${student.stunam}</td>
							<td>${student.stusex}</td>
							<td>${student.stubir}</td>
							<td>${student.stugra}</td>
						</tr>
					</c:forEach>
				</table>
				<span class="center-block" ><a href="delete_course.jsp" id="a">返回</a></span>
			</c:otherwise>
		</c:choose>
	</div><!--/.main-->

	<script src="../js/jquery-3.2.1.min.js"></script>
	<script src="../js/bootstrap.min.js"></script>
	<script src="../js/chart.min.js"></script>
	<script src="../js/chart-data.js"></script>
</body>

</html>
