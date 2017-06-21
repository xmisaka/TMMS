<!-- 中心管理员左侧导航栏 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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

		<li><a href="#" class="dropdown-toggle"> <i class="icon-book"></i>
				<span class="menu-text"> 书库信息 </span> <b
				class="arrow icon-angle-down"></b>
		</a>

			<ul class="submenu">
				<li><a href="elements.html"> <i
						class="icon-double-angle-right"></i> 教材书目
				</a></li>

				<li><a href="<%=request.getContextPath()%>/book/add" target="mainiframe"> <i
						class="icon-double-angle-right"></i> 批量添加
				</a></li>

				<li><a href="treeview.html"> <i
						class="icon-double-angle-right"></i> 院系订单
				</a></li>

				<li><a href="#" class="dropdown-toggle"> <i
						class="icon-double-angle-right"></i> 三级菜单 <b
						class="arrow icon-angle-down"></b>
				</a>

					<ul class="submenu">
						<li><a href="#"> <i class="icon-leaf"></i> 第一级
						</a></li>

						<li><a href="#" class="dropdown-toggle"> <i
								class="icon-pencil"></i> 第四级 <b class="arrow icon-angle-down"></b>
						</a>

							<ul class="submenu">
								<li><a href="#"> <i class="icon-plus"></i> 添加产品
								</a></li>

								<li><a href="#"> <i class="icon-eye-open"></i> 查看商品
								</a></li>
							</ul></li>
					</ul></li>
			</ul></li>

		<li><a href="#" class="dropdown-toggle"> <i
				class="icon-lemon"></i> <span class="menu-text"> 院系信息 </span> <b
				class="arrow icon-angle-down"></b>
		</a>

			<ul class="submenu">
				<li><a href="#"> <i class="icon-double-angle-right"></i>
						院系管理
				</a></li>

				<li><a href="#"> <i class="icon-double-angle-right"></i>
						添加院系
				</a></li>

				<li><a href="#"> <i class="icon-double-angle-right"></i>
						专业管理
				</a></li>
				<li><a href="#"> <i class="icon-double-angle-right"></i>
						添加专业
				</a></li>
			</ul></li>

		<li><a href="#" class="dropdown-toggle"> <i class="icon-bold"></i>
				<span class="menu-text"> 班级信息 </span> <b
				class="arrow icon-angle-down"></b>
		</a>

			<ul class="submenu">
				<li><a href="#"> <i class="icon-double-angle-right"></i>
						班级管理
				</a></li>

				<li><a href="#"> <i class="icon-double-angle-right"></i>
						添加班级
				</a></li>

				<li><a href="#"> <i class="icon-double-angle-right"></i>
						无用班级
				</a></li>
				<li><a href="#"> <i class="icon-double-angle-right"></i>
						设置班级
				</a></li>
			</ul></li>

		<li><a href="#" class="dropdown-toggle"> <i class="icon-male"></i>
				<span class="menu-text"> 学生信息 </span> <b
				class="arrow icon-angle-down"></b>
		</a>

			<ul class="submenu">
				<li><a href="#"> <i class="icon-double-angle-right"></i>
						学生管理
				</a></li>

				<li><a href="#"> <i class="icon-double-angle-right"></i>
						批量添加
				</a></li>

				<li><a href="#"> <i class="icon-double-angle-right"></i>
						学生信息校验
				</a></li>
				<li><a href="#"> <i class="icon-double-angle-right"></i>
						账户管理
				</a></li>
				<li><a href="#"> <i class="icon-double-angle-right"></i>
						打印学生用书
				</a></li>
				<li><a href="#"> <i class="icon-double-angle-right"></i>
						费用总余额监控
				</a></li>
			</ul></li>

		<li><a href="#" class="dropdown-toggle"> <i class="icon-user"></i>
				<span class="menu-text"> 教师信息 </span> <b
				class="arrow icon-angle-down"></b>
		</a>

			<ul class="submenu">
				<li><a href="#"> <i class="icon-double-angle-right"></i>
						教师管理
				</a></li>

				<li><a href="#"> <i class="icon-double-angle-right"></i>
						添加教师
				</a></li>

				<li><a href="#"> <i class="icon-double-angle-right"></i>
						打印教师用书
				</a></li>

			</ul></li>

		<li><a href="#" class="dropdown-toggle"> <i
				class="icon-table"></i> <span class="menu-text"> 课程信息 </span> <b
				class="arrow icon-angle-down"></b>
		</a>

			<ul class="submenu">
				<li><a href="#"> <i class="icon-double-angle-right"></i>
						课程管理
				</a></li>

				<li><a href="#"> <i class="icon-double-angle-right"></i>
						添加课程
				</a></li>

				<li><a href="#"> <i class="icon-double-angle-right"></i>
						替换教材
				</a></li>

			</ul></li>

		<li><a href="#" class="dropdown-toggle"> <i class="icon-file"></i>
				<span class="menu-text"> 查看订单 </span> <b
				class="arrow icon-angle-down"></b>
		</a>

			<ul class="submenu">

				<li><a href="#" class="dropdown-toggle"> <i
						class="icon-double-angle-right"></i> 学生部分 <b
						class="arrow icon-angle-down"></b>
				</a>

					<ul class="submenu">
						<li><a href="#"> <i class="icon-double-angle-right"></i>
								按书号统计
						</a></li>
						<li><a href="#"> <i class="icon-double-angle-right"></i>
								按院系统计
						</a></li>
						<li><a href="#"> <i class="icon-double-angle-right"></i>
								按年级统计
						</a></li>
						<li><a href="#"> <i class="icon-double-angle-right"></i>
								按专业统计
						</a></li>
						<li><a href="#"> <i class="icon-double-angle-right"></i>
								按校区统计
						</a></li>
						<li><a href="#"> <i class="icon-double-angle-right"></i>
								按校区加院系统计
						</a></li>

					</ul></li>
				<li><a href="#" class="dropdown-toggle"> <i
						class="icon-double-angle-right"></i> 教师部分 <b
						class="arrow icon-angle-down"></b>
				</a>

					<ul class="submenu">
						<li><a href="#"> <i class="icon-double-angle-right"></i>
								按书号统计
						</a></li>
						<li><a href="#"> <i class="icon-double-angle-right"></i>
								按院系统计
						</a></li>
					</ul></li>

				<li><a href="#" class="dropdown-toggle"> <i
						class="icon-double-angle-right"></i> 综合部分 <b
						class="arrow icon-angle-down"></b>
				</a>

					<ul class="submenu">
						<li><a href="#"> <i class="icon-double-angle-right"></i>
								按书号统计
						</a></li>
						<li><a href="#"> <i class="icon-double-angle-right"></i>
								按院系统计
						</a></li>
						<li><a href="#"> <i class="icon-double-angle-right"></i>
								按出版社统计
						</a></li>
					</ul></li>
			</ul></li>

		<li><a href="#" class="dropdown-toggle"> <i class="icon-yen"></i>
				<span class="menu-text"> 费用管理 </span> <b
				class="arrow icon-angle-down"></b>
		</a>

			<ul class="submenu">
				<li><a href="#"> <i class="icon-double-angle-right"></i>
						初始费用批量导入
				</a></li>

				<li><a href="#"> <i class="icon-double-angle-right"></i>
						设置各年级专业应缴费
				</a></li>

				<li><a href="#"> <i class="icon-double-angle-right"></i>
						按单位统计应缴费
				</a></li>

				<li><a href="#"> <i class="icon-double-angle-right"></i>
						余额结算
				</a></li>

			</ul></li>

		<li><a href="#" class="dropdown-toggle"> <i class="icon-th"></i>
				<span class="menu-text"> 分类管理 </span> <b
				class="arrow icon-angle-down"></b>
		</a>

			<ul class="submenu">
				<li><a href="#"> <i class="icon-double-angle-right"></i>
						出版社管理
				</a></li>

				<li><a href="#"> <i class="icon-double-angle-right"></i>
						院系专业学生总数统计
				</a></li>

				<li><a href="#"> <i class="icon-double-angle-right"></i>
						选书统计信息
				</a></li>

				<li><a href="#"> <i class="icon-double-angle-right"></i>
						历史订单统计
				</a></li>

			</ul></li>

		<li><a href="#" class="dropdown-toggle"> <i
				class="icon-dashboard"></i> <span class="menu-text"> 高级管理 </span> <b
				class="arrow icon-angle-down"></b>
		</a>

			<ul class="submenu">
				<li><a href="#"> <i class="icon-double-angle-right"></i>
						用户管理
				</a></li>

				<li><a href="#"> <i class="icon-double-angle-right"></i>
						执行写入
				</a></li>

				<li><a href="#"> <i class="icon-double-angle-right"></i>
						清除历史记录
				</a></li>

				<li><a href="#"> <i class="icon-double-angle-right"></i>
						时间折扣设置
				</a></li>
				<li><a href="#"> <i class="icon-double-angle-right"></i>
						刷新统计信息
				</a></li>

				<li><a href="#"> <i class="icon-double-angle-right"></i>
						清除学生选书
				</a></li>

				<li><a href="#"> <i class="icon-double-angle-right"></i>
						学生升级
				</a></li>
			</ul></li>

		<li><a href="#" class="dropdown-toggle"> <i class="icon-cog"></i>
				<span class="menu-text"> 系统设置 </span> <b
				class="arrow icon-angle-down"></b>
		</a>

			<ul class="submenu">
				<li><a href="#"> <i class="icon-double-angle-right"></i>
						数据备份
				</a></li>

				<li><a href="#"> <i class="icon-double-angle-right"></i>
						数据还原
				</a></li>

				<li><a href="#"> <i class="icon-double-angle-right"></i>
						数据监控
				</a></li>

				<li><a href="#"> <i class="icon-double-angle-right"></i>
						数据还原
				</a></li>

				<li><a href="#"> <i class="icon-double-angle-right"></i>
						远程维护
				</a></li>

			</ul></li>



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