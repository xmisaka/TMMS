<!-- 中心管理员左侧导航栏 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="menu" uri="/menu-tags"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@page import="entity.TmmsUser" %>
	<%@page import="java.math.BigInteger" %>
	<%
	String path3 = request.getContextPath();
	String basePath3 = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path3 + "/";
	//System.out.println(basePath);
	TmmsUser user1 =(TmmsUser)session.getAttribute("tmmsUser");
	BigInteger roleId=BigInteger.valueOf(0);	
	if(user1!=null){
		roleId=BigInteger.valueOf(user1.getRoleId());
	}
%>
<div class="sidebar" id="sidebar">
	<script type="text/javascript">
		try {
			ace.settings.check('sidebar', 'fixed')
		} catch (e) {
		}
	</script>

	<div class="sidebar-shortcuts" id="sidebar-shortcuts">
		<div class="sidebar-shortcuts-large" id="sidebar-shortcuts-large">
			<button class="btn btn-success">
				<i class="icon-signal"></i>
			</button>

			<button class="btn btn-info">
				<i class="icon-pencil"></i>
			</button>

			<button class="btn btn-warning">
				<i class="icon-group"></i>
			</button>

			<button class="btn btn-danger">
				<i class="icon-cogs"></i>
			</button>
		</div>

		<div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
			<span class="btn btn-success"></span> <span class="btn btn-info"></span>

			<span class="btn btn-warning"></span> <span class="btn btn-danger"></span>
		</div>
	</div>
	<!-- #sidebar-shortcuts -->


	<ul class="nav nav-list">
        <menu:rolemenu parentId="0" roleid="<%=roleId%>">
          <c:forEach items="${rolemenus}" var="rolemenu1" varStatus="status">
            <li>
              <a href="<%=basePath3 %>${rolemenu1.uri}" class="dropdown-toggle"> <i class="${rolemenu1.icon}"></i>
				<span class="menu-text">${rolemenu1.menuName }</span> <b class="arrow icon-angle-down"></b>
		      </a>
		      <ul class="submenu">
			      <menu:rolemenu parentId="${rolemenu1.id }" roleid="<%=roleId%>">
			         <c:forEach items="${rolemenus}" var="rolemenu2" varStatus="status">
			           <li>
			             <c:choose>
			               <c:when test="${rolemenu2.extend1==1 }">
				               <a href="<%=basePath3 %>${rolemenu2.uri}" class="dropdown-toggle">
					              <i class="${rolemenu2.icon }"></i> ${rolemenu2.menuName } 
						       </a>
						       <ul class="submenu">
						         <menu:rolemenu parentId="${rolemenu2.id }" roleid="<%=roleId%>">
			                       <c:forEach items="${rolemenus}" var="rolemenu3" varStatus="status">
			                         <li>
			                           <a href="<%=basePath3 %>${rolemenu3.uri}"> <i class="${rolemenu3.icon }"></i>${rolemenu3.menuName }</a>
			                         </li>
			                       </c:forEach>
			                     </menu:rolemenu>
						       </ul>
			               </c:when>
			               <c:otherwise>
			                   <a href="<%=basePath3 %>${rolemenu2.uri}">
				                 <i class="${rolemenu2.icon }"></i> ${rolemenu2.menuName } 
					           </a>
			               </c:otherwise>
			             </c:choose>
			           </li>
			         </c:forEach>
			      </menu:rolemenu>
		      </ul>
            </li>
          </c:forEach>
        </menu:rolemenu>
	</ul>
	<!-- /.nav-list -->

	<div class="sidebar-collapse" id="sidebar-collapse">
		<i class="icon-double-angle-left" data-icon1="icon-double-angle-left"
			data-icon2="icon-double-angle-right"></i>
	</div>

	<script type="text/javascript">
		try {
			ace.settings.check('sidebar', 'collapsed')
		} catch (e) {
		}
	</script>
</div>