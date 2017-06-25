<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form:form action="add" modelAttribute="user">
userName:<form:input path="userName"/><form:errors path="userName" style="color:red;"></form:errors><br>
password:<form:password path="password"/><form:errors path="password" style="color:red;"></form:errors><br>
<input type="submit" value="add">
</form:form>
</body>
</html>