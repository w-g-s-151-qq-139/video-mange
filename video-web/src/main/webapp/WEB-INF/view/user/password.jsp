<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
<base href="${BaseContext}">
<meta name="viewport"
	content="initial-scale=1, maximum-scale=1, user-scalable=no">
<meta charset="utf-8">
<meta name="renderer" content="webkit">
<meta name="keywords"
	content="Web前端视频教程,大数据视频教程,HTML5视频教程,UI视频教程,PHP视频教程,java视频教程,python基础教程">
<meta name="description"
	content="智游教育在线课程视频,为您提供java,python,HTML5,UI,PHP,大数据等学科经典视频教程在线浏览学习,精细化知识点解析,深入浅出,想学不会都难,智游教育,学习成就梦想！">
<meta name="author" content="尚忠祥">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/base.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/profile.css">
<link rel="icon" href="favicon.png"
	type="${pageContext.request.contextPath }/image/png">
<title>在线公开课-智游教育|java|大数据|HTML5|python|UI|PHP视频教程</title>

</head>

<body class="w100">
	<jsp:include page="uheader.jsp"></jsp:include>
	<main>
	<div class="container">
		<h2>我的资料</h2>
		<div id="profile_tab">
			<ul class="profile_tab_header f_left clearfix">
				<li><a
					href="${pageContext.request.contextPath }/user/profile.action">更改资料</a></li>
				<li class="profile_tab_line">|</li>
				<li><a
					href="${pageContext.request.contextPath }/user/altavatar.action">更改头像</a></li>
				<li class="profile_tab_line">|</li>
				<li><a
					href="${pageContext.request.contextPath }/user/password.action">密码安全</a></li>
			</ul>
			<div class="proflle_tab_body">
				<div class="proflle_tab_workplace clearfix">
					<div class="profile_avatar_area">

						<c:if test="${empty _front_user.headUrl}">
							<img id="avatar"
								src="${pageContext.request.contextPath }/img/avatar_lg.png"
								alt="这是什么">
						</c:if>

						<c:if test="${not empty _front_user.headUrl}">
							<img id="avatar" width="200px" height="200px"
								src="/pic/${_front_user.headUrl}" alt="">
						</c:if>

					</div>

					<div class="profile_ifo_area">
						<form action="" id="pwdform" method="post">
							<div class="form_group" style="text-align: center;">
								<strong style="color: red;">${message}</strong>
							</div>
							<div class="form_group">
								<span class="dd">旧&#x3000;密&#x3000;码：</span> <input
									type="password" id="oldPassword" name="oldPassword">
							</div>
							<div class="form_group">
								<span class="dd">新&#x3000;密&#x3000;码：</span> <input
									type="password" id="newpwd" name="newPassword">
							</div>
							<div class="form_group">
								<span class="dd">确认新密码：</span> <input type="password"
									id="newPassword02" name="newPasswordAgain">
							</div>
							<div class="form_submit dd">
								<input type="submit" value="保&#x3000;存">
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	</main>
	<jsp:include page="ufooter.jsp"></jsp:include>
	<%@include file="../include/script.html"%>
	<script type="text/javascript">
		$(function() {
			$('#pwdform').validate(
					{
						submitHandler : function(form) {
							//ajax提交注册信息，并且返回注册结果
							//使用ajax的post方法提交注册信息
							$.post('/video-web/user/altpassword.action', $(
									'#pwdform').serialize(), function(result) {
								if (result == "true") {
									alert("密码更改成功!");
									location.href="/video-web/user/userdata.action";
								} else {
									$("strong").text("密码错误!无法更改密码");
								}
							}, 'text');

						},
						rules : {//写校验规则的
							oldPassword : {
								required : true,
								minlength : 3
							},
							newPassword : {
								required : true,
								minlength : 3
							},
							newPasswordAgain : {
								required : true,
								equalTo : '#newpwd'
							}
						},
						messages : {//写提示信息的
							oldPassword : "旧密码是必须填写的",
							newPassword : '密码是必须填写的，3-30个字符',
							newPasswordAgain : '两次密码必须输入一致'
						}
					});
		});
	</script>
</body>
</html>