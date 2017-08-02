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
							<li class="active">角色权限设置</li>
						</ul>
						<!-- .breadcrumb -->
					</div>
					<!-- PAGE CONTENT BEGINS -->
					<!-- 要展示的开始 -->
					<div class="page-content">
						<div class="row">
							<div class="col-xs-12">

								<form action="/tmms/userrole/menuset" method="post" id="Paramform"
									class="form-horizontal">
									<div class=" col-xs-12 table-header">角色菜单设置<a href="/tmms/userrole/userroles" style="float:right;color:#fff;">返回角色列表</a></div>
                                    <table id="dynamic-table" style="width:20%;">
                                    <th colspan=2>选择菜单</th>
                                    <tr><th><input type="checkbox" name="checkall" id="checkall">全选/取消全选</th></tr>
                                    <input type="hidden" name="id" id="id" value="${id }"/>
                                    <menu:rolemenu parentId="0" roleid="${id}">
                                       <c:forEach items="${childrenmenus}" var="childrenmenu1" varStatus="status1">
                                         <tr>
                                           <c:choose>
                                             <c:when test="${childrenmenu1.extend2==1}">
                                               <td><input type="checkbox" name="menuId" id="menuId1" node="${status1.index }" value="${childrenmenu1.id }" checked="true"/>${childrenmenu1.menuName }</td>
                                             </c:when>
                                             <c:otherwise>
                                               <td><input type="checkbox" name="menuId" id="menuId1" node="${status1.index }" value="${childrenmenu1.id }"/>${childrenmenu1.menuName }</td>
                                             </c:otherwise>
                                           </c:choose>
                                         </tr>
                                         <menu:rolemenu parentId="${childrenmenu1.id }" roleid="${id}">
                                            <c:forEach items="${childrenmenus}" var="childrenmenu2" varStatus="status2">
                                              <tr>
	                                           <c:choose>
	                                             <c:when test="${childrenmenu2.extend2==1}">
	                                               <td>|________<input type="checkbox" name="menuId" id="menuId2" node="${status1.index }${status2.index }" value="${childrenmenu2.id }" checked="true"/>${childrenmenu2.menuName }</td>
	                                             </c:when>
	                                             <c:otherwise>
	                                               <td>|________<input type="checkbox" name="menuId" id="menuId2" node="${status1.index }${status2.index }" value="${childrenmenu2.id }"/>${childrenmenu2.menuName }</td>
	                                             </c:otherwise>
	                                           </c:choose>
	                                         </tr>
	                                         <menu:rolemenu parentId="${childrenmenu2.id }" roleid="${id}">
                                                <c:forEach items="${childrenmenus}" var="childrenmenu3" varStatus="status3">
	                                              <tr>
		                                           <c:choose>
		                                             <c:when test="${childrenmenu3.extend2==1}">
		                                               <td>|_________________<input type="checkbox" name="menuId" id="menuId3" node="${status1.index }${status2.index }${status3.index }" value="${childrenmenu3.id }" checked="true"/>${childrenmenu3.menuName }</td>
		                                             </c:when>
		                                             <c:otherwise>
		                                               <td>|_________________<input type="checkbox" name="menuId" id="menuId3" node="${status1.index }${status2.index }${status3.index }" value="${childrenmenu3.id }"/>${childrenmenu3.menuName }</td>
		                                             </c:otherwise>
		                                           </c:choose>
		                                         </tr>
	                                            </c:forEach>
	                                         </menu:rolemenu>
                                            </c:forEach>
                                         </menu:rolemenu>
                                       </c:forEach>
                                    </menu:rolemenu>
								    <tr>
								        <td></td>
								        <td><input type="submit" value="提交"></td>
								    </tr>
									</table>
									 <c:forEach items="${rolePermissions}" var="rolePermission" varStatus="status">
                                            <input type="hidden" name="permissionIdown" id="permissionIdown" value="${rolePermission.permissionId }" />
                                            <input type="hidden" name="rolepermissionid" id="rolepermissionid" value="${rolePermission.id }" />
                                    </c:forEach>
								</form>
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
	<script src="<%=basePath2 %>resources/js/common/common_add.js"></script>
	<script src="<%=basePath2 %>resources/js/common/checkbox.js"></script>
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

