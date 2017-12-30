<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
	String path4 = request.getContextPath();
	String basePath4 = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path4 + "/";
	//System.out.println(basePath);
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1.0" />
<title>教材管理系统</title>
</head>
<script src="<%=basePath4 %>resources/js/jquery-2.0.3.min.js"></script>
<script src="<%=basePath4 %>resources/js/bootstrap.min.js"></script>
<link href="<%=basePath4 %>resources/css/bootstrap.min.css" rel="stylesheet" />
<link href="<%=basePath4 %>resources/css/font-awesome.min.css" rel="stylesheet"/>
<link href="<%=basePath4 %>resources/css/login.css" rel="stylesheet"/>
<body>
<div class="box">
		<div class="login-box">
			<div class="login-title text-center">
				<h1><small>登录</small></h1>
			</div>
			<div class="login-content ">
			<div class="form">
			<form action="login" method="post">
				<div class="form-group">
					<div class="col-xs-12  ">
						<div class="input-group">
							<span class="input-group-addon"><span class="icon-user"></span></span>
							<input type="text" id="inputAccount" name="userName" class="form-control" placeholder="用户名">
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="col-xs-12  ">
						<div class="input-group">
							<span class="input-group-addon"><span class="icon-lock"></span></span>
							<input type="text" id="inputPassword" name="password" class="form-control" placeholder="密码">
						</div>
					</div>
				</div>
				
				<div class="form-group form-actions">
					<div class="col-xs-4 col-xs-offset-4" style="color:red;">
						${errorMsg }
					</div>
				</div>
				
				<div class="form-group form-actions">
					<div class="col-xs-4 col-xs-offset-4 ">
						<button type="submit" class="btn btn-sm btn-info"><span class="icon-off"></span> 登录</button>
					</div>
				</div>
				<!--<div class="form-group">
					<div class="col-xs-6 link">
						<p class="text-center remove-margin"><small>忘记密码？</small> <a href="javascript:void(0)" ><small>找回</small></a>
						</p>
					</div>
					<div class="col-xs-6 link">
						<p class="text-center remove-margin"><small>还没注册?</small> <a href="javascript:void(0)" ><small>注册</small></a>
						</p>
					</div>
				</div> -->
			</form>
			</div>
		</div>
	</div>
</div>
</body>
</html>