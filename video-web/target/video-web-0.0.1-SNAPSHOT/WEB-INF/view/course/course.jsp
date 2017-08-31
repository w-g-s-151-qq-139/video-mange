<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>课程管理</title>
		<link href="${pageContext.request.contextPath }/css/bootstrap.min.css" rel="stylesheet">
		<script src="${pageContext.request.contextPath }/js/jquery-1.12.4.min.js"></script>
		<script src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
	</head>

	<body>
		<nav class="navbar navbar-inverse">
			<div class="container">
				<div class="row">
					<div class="navbar-header">
						<a  class="navbar-brand" href="#">视频管理系统</a>
					</div>
					<div class="navbar-header">
						<a  class="navbar-brand" href="#">视频管理</a>
					</div>
					<div class="navbar-header">
						<a  class="navbar-brand" href="#">主讲人管理</a>
					</div>
					<div class="navbar-header">
						<a  class="navbar-brand" href="#">课程管理</a>
					</div>
					<div class="navbar-header">
						<a  class="navbar-brand" href="#">统计分析</a>
					</div>
					<div class="navbar-header" style="float: right;">
						<a class="navbar-brand" href="#">${user.name}<span class="glyphicon glyphicon-log-out"></span></a>
					</div>
				</div>
			</div>
		</nav>
		<div class="container">

			<div style="background-color: lightgray; margin-bottom: 5px;" class="container">
				<h1><b>课程列表-课程管理</b></h1>
			</div>
			<div>
				<ul class="nav nav-pills">
					<li role="presentation" class="active">
						<a href="#">添加课程</a>
					</li>
				</ul>
			</div>
			<table class="table table-hover table-condensed">
				<tr>
					<td>序号</td>
					<td>标题</td>
					<td>学科</td>
					<td>简介</td>
					<td>编辑</td>
					<td>删除</td>
				</tr>
				<tr>
					<td>1</td>
					<td>发送到</td>
					<td>发发</td>
					<td>三打哈软件哈多人很骄傲的软件是否合适的粉红色的任何事都很舒服还是</td>
					<td>
						<a class="glyphicon glyphicon-edit"></a>
					</td>
					<td>
						<a class="glyphicon glyphicon-trash"></a>
					</td>
				</tr>
			</table>
		</div>
	</body>

</html>