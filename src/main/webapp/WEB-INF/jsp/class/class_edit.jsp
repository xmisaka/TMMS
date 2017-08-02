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
<title>班级管理系统后台</title>
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
							<li class="active">班级书目</li>
						</ul>
						<!-- .breadcrumb -->
					</div>
					<!-- PAGE CONTENT BEGINS -->
					<!-- 要展示的开始 -->
					<div class="page-content">
						<div class="row">
							<div class="col-xs-12">

								<sf:form action="/tmms/class/classedit" method="post" id="Paramform"
									class="form-horizontal" commandName="classInfo">
									<div class=" col-xs-12 table-header">班级信息添加<a href="/tmms/class/classs" style="float:right;color:#fff;">返回班级列表</a></div>
                                    <table id="dynamic-table">
                                    <sf:hidden path="classId"/>
							     <tr>
								        <td>班级名:</td>
								        <td><sf:input path="className"/><sf:errors path="className" cssClass="errors" style="color:red;"></sf:errors> </td>
								      </tr>
								      <tr>
								        <td>学院:</td>
								        <td>
								           <select name="collegeId" id="collegeId">
								            <select>
								             <sf:errors path="collegeId" cssClass="errors" style="color:red;"></sf:errors>
								        </td>
								      </tr>
								      <tr>
								        <td>专业:</td>
								        <td>
								           <select name="specialtyId" id="specialtyId">
								            <select>
								            <sf:errors path="specialtyId" cssClass="errors" style="color:red;"></sf:errors>
								        </td>
								      </tr>
								      <tr>
								        <td>年级:</td>
								        <td>
								           <sf:select path="grade" items="${grades}" itemLabel="itemname" itemValue="itemno">
								            </sf:select>
								            <sf:errors path="grade" cssClass="errors" style="color:red;"></sf:errors>
								        </td>
								      </tr>
								      <tr>
								        <td>班长学号:</td>
								        <td><sf:input path="monitorNo"/><sf:errors path="monitorNo" cssClass="errors" style="color:red;"></sf:errors> </td>
								      </tr>
								       <tr>
								        <td>班长名字:</td>
								        <td><sf:input path="monitorName"/><sf:errors path="monitorName" cssClass="errors" style="color:red;"></sf:errors> </td>
								      </tr>
								       <tr>
								        <td>班长联系方式:</td>
								        <td><sf:input path="monitorLinkinfo"/><sf:errors path="monitorLinkinfo" cssClass="errors" style="color:red;"></sf:errors> </td>
								      </tr>
								       <tr>
								        <td>学生数量:</td>
								        <td><sf:input path="studentNum"/><sf:errors path="studentNum" cssClass="errors" style="color:red;"></sf:errors> </td>
								      </tr>
								       <tr>
								        <td>已缴费学生数量:</td>
								        <td><sf:input path="paidStudentNum"/><sf:errors path="paidStudentNum" cssClass="errors" style="color:red;"></sf:errors> </td>
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
	<script type="text/javascript">
var collegeId="${classInfo.collegeId}";
var specialtyId="${classInfo.specialtyId}";
</script>
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

