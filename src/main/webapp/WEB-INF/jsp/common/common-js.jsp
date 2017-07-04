<%
	String path2 = request.getContextPath();
	String basePath2 = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path2 + "/";
	//System.out.println(basePath);
%>
<!-- 公共JS文件 -->
<!-- basic scripts -->

		<!--[if !IE]> -->

		<script src="http://apps.bdimg.com/libs/jquery/2.0.3/jquery.min.js"></script>

		<!-- <![endif]-->

		<!--[if IE]>
<script src="http://apps.bdimg.com/libs/jquery/1.10.2/jquery.min.js"></script>
<![endif]-->

		<!--[if !IE]> -->
		<script type="text/javascript">
			window.jQuery || document.write("<script src='<%=basePath2 %>resources/js/jquery-2.0.3.min.js'>"+"<"+"script>");
		</script>
		<!-- <![endif]-->

		<!--[if IE]>
<script type="text/javascript">
 window.jQuery || document.write("<script src='<%=basePath2 %>resources/js/jquery-1.10.2.min.js'>"+"<"+"script>");
</script>
<![endif]-->

		<script type="text/javascript">
			if("ontouchend" in document) document.write("<script src='<%=basePath2 %>resources/js/jquery.mobile.custom.min.js'>"+"<"+"script>");
		</script>
		<script src="<%=basePath2 %>resources/js/bootstrap.min.js"></script>

		<!-- page specific plugin scripts -->

		<!--[if lte IE 8]>
		  <script src="<%=basePath2 %>resources/js/excanvas.min.js"></script>
		<![endif]-->

		<script src="<%=basePath2 %>resources/js/jquery-ui-1.10.3.custom.min.js"></script>

		<!-- ace scripts -->
		<script src="<%=basePath2 %>resources/js/ace-elements.min.js"></script>
		<script src="<%=basePath2 %>resources/js/ace.min.js"></script>
		<script src="<%=basePath2 %>resources/js/back/list.js"></script>
		<!-- inline scripts related to this page -->