<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="util.*" %>
<!DOCTYPE html>

<html>
<head>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<meta charset="utf-8" />
<title>教材管理系统后台</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
</head>
<link rel="stylesheet" type="text/css" href="<%=basePath %>resources/easyui/js/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=basePath %>resources/easyui/js/themes/icon.css">
<link rel="stylesheet" type="text/css" href="<%=basePath %>resources/easyui/js/demo/demo.css">
<script type="text/javascript" src="<%=basePath %>resources/easyui/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="<%=basePath %>resources/easyui/js/jquery.easyui.min.js"></script>
<script type="text/javascript">
function convert(rows){
	function exists(rows, parentId){
		for(var i=0; i<rows.length; i++){
			if (rows[i].id == parentId) return true;
		}
		return false;
	}
	
	var nodes = [];
	// get the top level nodes
	for(var i=0; i<rows.length; i++){
		var row = rows[i];
		if (!exists(rows, row.parentId)){
			nodes.push({
				id:row.id,
				text:row.name
			});
		}
	}
	
	var toDo = [];
	for(var i=0; i<nodes.length; i++){
		toDo.push(nodes[i]);
	}
	while(toDo.length){
		var node = toDo.shift();	// the parent node
		// get the children nodes
		for(var i=0; i<rows.length; i++){
			var row = rows[i];
			if (row.parentId == node.id){
				var child = {id:row.id,text:row.name};
				if (node.children){
					node.children.push(child);
				} else {
					node.children = [child];
				}
				toDo.push(child);
			}
		}
	}
	return nodes;
}

$(function(){
	$('#tt').tree({
		url: '/tmms/treedate/tree6_data.json',
		loadFilter: function(rows){
			return convert(rows);
		}
	});
});

</script>
<body>
<ul id="tt"></ul>
<% out.println(request.getPathInfo());
  out.println(request.getPathTranslated());
    out.println(request.getServletPath());
    %>
</body>