<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>添加主讲人</title>
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
				<h1><b>编辑主讲人-主讲人管理</b></h1>
			</div>
			<form class="form-horizontal">
				<div class="form-group">
					<label for="inputname" class="col-sm-2 control-label">名字</label>
					<div class="col-sm-10">
						<input type="email" class="form-control" id="inputname" placeholder="主讲人姓名">
					</div>
				</div>
				<div class="form-group">
					<label for="inputoccupation" class="col-sm-2 control-label">职业</label>
					<div class="col-sm-10">
						<input type="password" class="form-control" id="inputoccupation" placeholder="主讲人职业">
					</div>
				</div>
				<div class="form-group">
					<label for="inputPassword3" class="col-sm-2 control-label">头像图片</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="inputPassword3" placeholder="主讲人头像地址,网络图片">
					</div>
				</div>
				<div class="form-group">
					<label for="inputPassword3" class="col-sm-2 control-label">简介</label>
					<div class="col-sm-10">
						<textarea style="width: 100%; height: 100px;"></textarea>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="submit" class="btn btn-primary">保存</button>
						<button>返回列表</button>
					</div>
				</div>
			</form>
		</div>
	</body>

</html>