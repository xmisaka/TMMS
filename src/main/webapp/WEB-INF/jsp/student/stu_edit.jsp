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
							<li class="active">教材书目</li>
						</ul>
						<!-- .breadcrumb -->
					</div>
					<!-- PAGE CONTENT BEGINS -->
					<!-- 要展示的开始 -->
					<div class="page-content">
						<div class="row">
							<div class="col-xs-12">

								<sf:form action="/tmms/student/studentedit" method="post" id="Paramform"
									class="form-horizontal" commandName="studentInfo">
									<div class=" col-xs-12 table-header">学生信息添加<a href="/tmms/student/students" style="float:right;color:#fff;">返回学生列表</a></div>
                                    <table id="dynamic-table">
                                    <sf:hidden path="id"/>
								      <tr>
								        <td>学号:</td>
								        <td><sf:input path="studentNo"/><sf:errors path="studentNo" cssClass="errors" style="color:red;"></sf:errors> </td>
								      </tr>
								      <tr>
								        <td>姓名:</td>
								        <td><sf:input path="studentName"/><sf:errors path="studentName" cssClass="errors" style="color:red;"></sf:errors> </td>
								      </tr>
								      <tr>
								        <td>性别:</td>
								        <td>
								            <sf:select path="studentSex" items="${sexs}" itemLabel="itemname" itemValue="itemno">
								            </sf:select>
								        </td>
								      </tr>
								      <tr>
								        <td>手机号:</td>
								        <td><sf:input path="mobile"/><sf:errors path="mobile" cssClass="errors" style="color:red;"></sf:errors> </td>
								      </tr>
								      <tr>
								        <td>年级:</td>
								        <td>
								           <sf:select path="studentGrade" items="${grades}" itemLabel="itemname" itemValue="itemno">
								            </sf:select>
								        </td>
								      </tr>
								      <tr>
								        <td>学院:</td>
								        <td>
								           <select name="collegeId" id="collegeId">
								            <select>
								        </td>
								      </tr>
								      <tr>
								        <td>专业:</td>
								        <td>
								           <select name="specialtyId" id="specialtyId">
								           </select>
								        </td>
								      </tr>
								      <tr>
								        <td>班级:</td>
								        <td>
								           <select name="classId" id="classId">
								           </select>
								        </td>
								      </tr>
								      <tr>
								        <td>入学时间:</td>
								        <td><sf:input path="enterTime" class="ECalendar" id="ECalendar_date" value="<%=DateUtil.getCurrentDateStr() %>" readonly="true"/><sf:errors path="enterTime" cssClass="errors" style="color:red;"></sf:errors> </td>
								      </tr>
								      <tr>
								        <td>初始缴费金额:</td>
								        <td><sf:input path="initialAmount"/><sf:errors path="initialAmount" cssClass="errors" style="color:red;"></sf:errors> </td>
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
var collegeId="${studentInfo.collegeId}";
var specialtyId="${studentInfo.specialtyId}";
var classId="${studentInfo.classId}";
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

