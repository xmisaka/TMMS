<html>
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="entity.TmmsUser" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
TmmsUser user =(TmmsUser)session.getAttribute("tmmsUser");
  if(user!=null){
	  String url=basePath+"welcome";
	  response.sendRedirect(url);
  }else{
	  String url=basePath+"login";
	  response.sendRedirect(url);
  }
%>
<body>
</body>
</html>
