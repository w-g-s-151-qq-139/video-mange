<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>添加视频</title>
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
				<h1><b>编辑视频信息-视频管理</b></h1>
			</div>
			<form class="form-horizontal">
				<div class="form-group">
					<label for="inputname" class="col-sm-2 control-label">视频标题</label>
					<div class="col-sm-10">
						<input type="email" class="form-control" id="inputname" placeholder="视频标题">
					</div>
				</div>
				<div class="form-group">
					<label for="inputoccupation" class="col-sm-2 control-label">主讲人</label>
					<div class="col-sm-10">
						<select class="form-control">
							<option>请选择主讲人</option>
						</select>
					</div>
				</div>
				<div class="form-group">
					<label for="inputPassword3" class="col-sm-2 control-label">所属课程</label>
					<div class="col-sm-10">
						<select class="form-control">
							<option>请选择课程</option>
						</select>
					</div>
				</div>
				<div class="form-group">
					<label for="inputPassword3" class="col-sm-2 control-label">视频时长</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="inputPassword3" placeholder="视频时长(秒)">
					</div>
				</div>
				<div class="form-group">
					<label for="inputPassword3" class="col-sm-2 control-label">封面图片</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="inputPassword3" placeholder="视频封面图片地址,网络图片">
					</div>
				</div>
				<div class="form-group">
					<label for="inputPassword3" class="col-sm-2 control-label">视频播放地址</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="inputPassword3" placeholder="视频播放地址,网络地址">
					</div>
				</div>
				<div class="form-group">
					<label for="inputPassword3" class="col-sm-2 control-label">视频简介</label>
					<div class="col-sm-10">
						<textarea  class="form-control"></textarea>
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