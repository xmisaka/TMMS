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

								<sf:form action="bookaddbatch" method="post" id="Paramform"
									class="form-horizontal" enctype="multipart/form-data">
									<div class=" col-xs-12 table-header">书籍批量添加<a href="books" style="float:right;color:#fff;">返回书籍列表</a></div>
                                    <table id="dynamic-table">
								      <tr>
								        <td><input type="file" name="file" id="uploadfile"> </td>
								      </tr>
								      <tr>
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
</body>
</html>

