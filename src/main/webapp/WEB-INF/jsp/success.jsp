<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

${info } 欢迎你!
	<shiro:hasRole name="admin">
    欢迎有admin角色的用户！<shiro:principal />
	</shiro:hasRole>
	<shiro:hasPermission name="student:add">
    欢迎有student:add权限的用户！<shiro:principal />
	</shiro:hasPermission>
</body>

</html>
