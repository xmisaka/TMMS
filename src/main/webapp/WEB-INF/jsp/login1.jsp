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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>教材管理系统</title>
</head>
<script src="<%=basePath4 %>resources/js/jquery-2.0.3.min.js"></script>
<script src="<%=basePath4 %>resources/js/bootstrap.min.js"></script>
<link href="<%=basePath4 %>resources/css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" href="<%=basePath4 %>resources/css/login.css" />
<body>
<form action="login" method="post">
<!--使用模态框的方式模拟一个登陆框-->
<div class="modal show" id="loginModal">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close">&times;</button>
                <h1 class="text-center text-primary">登录</h1>
            </div>
            <div class="modal-body">
                <form class="form col-md-12 center-block" id="loginForm" action="/login" method="post">
                    <div class="form-group-lg"  id="accountDiv">
                        <label class="sr-only" for="inputAccount">账号</label>
                        <div class="input-group">
                            <div class="input-group-addon"><span class="glyphicon glyphicon-user" aria-hidden="true"></span></div>
                            <input class="form-control" id="inputAccount" name="userName" type="text" placeholder="账号" required autofocus value="${tmmsUser.username }">
                        </div>
                        <div class="hidden text-center" id="accountMsg"><span class="glyphicon glyphicon-exclamation-sign"></span>${errorMsg }</div>
                    </div>
                    <br>
                    <div class="form-group-lg" id="pwdDiv">
                        <label class="sr-only" for="inputPassword">密码</label>
                        <div class="input-group">
                            <div class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></div>
                            <input class="form-control" id="inputPassword" name="password" type="password" placeholder="密码" required value="${tmmsUser.password }">
                            <div class="input-group-addon"><span class="glyphicon glyphicon-eye-open"></span></div>
                        </div>
                        <div class="hidden text-center" id="pwdMsg"><span class="glyphicon glyphicon-exclamation-sign"></span>${errorMsg }</div>
                    </div>
                    <div class="checkbox">
                        <label> <input type="checkbox" value="remember-me">记住我</label>
                    </div>
                    <div class="form-group">
                        <button class="btn btn-primary btn-lg col-md-6" id="btn_login" type="submit" >登录</button>
                    </div>
                </form>
            </div>
            <div class="modal-footer">

            </div>
        </div>
    </div>
</div>
</form>
</body>
</html>