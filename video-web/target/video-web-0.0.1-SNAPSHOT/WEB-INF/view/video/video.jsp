<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>视频管理</title>
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
				<h1><b>视频列表-视频管理</b></h1>
			</div>
			<div class="row">
				<div style="float: left;">
					<ul class="nav nav-pills">
						<li role="presentation" class="active">
							<button class="btn btn-primary" type="button">添加视频</button>
						</li>
					</ul>
				</div>
				<div style="float: left;">
					<ul class="nav nav-pills">
						<li role="presentation" class="active">
							<button class="btn btn-primary" type="button">Messages<span class="badge">4</span>
					</button>
						</li>
					</ul>
				</div>
				<div style="float: right;">
					<form class="form-inline">
						<div class="form-group">
							<input type="text" class="form-control" placeholder="视频标题">
						</div>
						<div class="form-group">
							<input type="text" class="form-control" placeholder="请选择主讲人">
						</div>
						<div class="form-group">
							<input type="email" class="form-control" placeholder="请选择课程">
						</div>
						<button class="btn btn-primary" type="button">查询</button>
					</form>
				</div>
			</div>

			<table class="table table-hover table-condensed">
				<tr>
					<td><input type="checkbox"></td>
					<td>序号</td>
					<td>名称</td>
					<td>介绍</td>
					<td>讲师</td>
					<td>课程</td>
					<td>时长(秒)</td>
					<td>播放次数</td>
					<td>编辑</td>
					<td>删除</td>
				</tr>
				<tr>
					<td><input type="checkbox"></td>
					<td>1</td>
					<td>发送到</td>
					<td>三打哈软件哈多人很骄傲的软件是否合适的粉红色的任何事都很舒服还是</td>
					<td>发发</td>
					<td>发发</td>
					<td>发发</td>
					<td>发发</td>
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