<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<html lang="zh-CN">

	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>视频管理系统</title>
		<link href="${pageContext.request.contextPath }/css/bootstrap.min.css" rel="stylesheet">
		<script src="${pageContext.request.contextPath }/js/jquery-1.12.4.min.js"></script>
		<script src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
	</head>

	<body>
		<div style="width: 20%; margin: auto; margin-top: 250px;">
			<img src="${pageContext.request.contextPath }/img/logo.png" width="100%" />
			<form style="margin-top: 5px;" action="${pageContext.request.contextPath }/login.action">
				<div class="form-group">
					<input type="text" class="form-control" placeholder="用户名" name="loginName">
				</div>
				<div class="form-group">
					<input type="password" class="form-control" placeholder="密码" name="loginPwd">
				</div>
				<div style="text-align: center"><span style="color: red">${error}</span></div>
				<button type="submit" class="btn btn-success form-control">登录</button>
			</form>
		</div>
	</body>

</html>