<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="util.DateUtil" %>
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
<!-- basic styles -->
<%@ include file="../common/common-css.jsp"%>
</head>

<body>
	<%@ include file="../common/nav-top.jsp"%>
	<div class="main-container" id="main-container">
		<script type="text/javascript">
			try {
				ace.settings.check('main-container', 'fixed')
			} catch (e) {
			}
		</script>

		<div class="main-container" id="main-container">
			<a class="menu-toggler" id="menu-toggler" href="#"> <span
				class="menu-text"></span>
			</a>

			<%@ include file="../common/nav-left.jsp"%>

			<div class="main-content">
				<div class="main-content-inner">
					<div class="breadcrumbs" id="breadcrumbs">
						<script type="text/javascript">
							try {
								ace.settings.check('breadcrumbs', 'fixed')
							} catch (e) {
							}
						</script>

						<ul class="breadcrumb">
							<li><i class="icon-home home-icon"></i> <a href="#">首页</a></li>
							<li class="active">用户信息</li>
						</ul>
						<!-- .breadcrumb -->
					</div>
					<!-- PAGE CONTENT BEGINS -->
					<!-- 要展示的开始 -->
					<div class="page-content">
						<div class="row">
							<div class="col-xs-12">

								<sf:form action="/tmms/tmmsuser/tmmsuseredit" method="post" id="Paramform"
									class="form-horizontal" commandName="tmmsUser">
									<div class=" col-xs-12 table-header">用户信息添加<a href="/tmms/tmmsuser/tmmsusers" style="float:right;color:#fff;">返回用户列表</a></div>
                                    <table id="dynamic-table">
                                    <sf:hidden path="id"/>
								      <tr>
								        <td>用户名:</td>
								        <td><sf:input path="username"/><sf:errors path="username" cssClass="errors" style="color:red;"></sf:errors> </td>
								      </tr>
								      <tr>
								        <td>密码:</td>
								        <td><sf:password path="password"/> <sf:errors path="password" cssClass="errors" style="color:red;"></sf:errors> </td>
								      </tr>
								      <tr>
								        <td>角色:</td>
								        <td>
								            <sf:select path="roleId" items="${userroles}" itemLabel="roleName" itemValue="id">
								            </sf:select>
								        </td>
								      </tr>
								      <tr>
								        <td></td>
								        <td><input type="submit" value="提交"></td>
								      </tr>
									</table>
								</sf:form>
							</div>
						</div>

					</div>
					<!-- 展示内容结束 -->
					<!-- PAGE CONTENT ENDS -->
				</div>
				<!-- /.main-content -->

			</div>
		</div>
		<!-- /.main-container-inner -->

		<a href="#" id="btn-scroll-up"
			class="btn-scroll-up btn btn-sm btn-inverse"> <i
			class="icon-double-angle-up icon-only bigger-110"></i>
		</a>
	</div>
	<!-- /.main-container -->
<%@ include file="../common/common-js.jsp"%>
<script src="<%=basePath2 %>resources/js/common/common_edit.js"></script>
<script type="text/javascript">
$(function(){
	$("#ECalendar_date").ECalendar({
		 type:"time",   //模式，time: 带时间选择; date: 不带时间选择;
		 stamp : false,   //是否转成时间戳，默认true;
		 offset:[0,0],   //弹框手动偏移量;
		 format:"yyyy-mm-dd",   //时间格式 默认 yyyy-mm-dd hh:ii;
		 skin:2,   //皮肤颜色，默认随机，可选值：0-8,或者直接标注颜色值;
		 step:10,   //选择时间分钟的精确度;
		 callback:function(v,e){} //回调函数
	});
})
</script>
</body>
</html>

