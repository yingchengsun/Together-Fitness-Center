<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>

		<style type="text/css">
body {
	font-family: arial, 宋体, serif;
	font-size: 12px;
	background-image: url("../pictures/newbackground.png");
}

.fun_list {
	FONT-WEIGHT: bold;
	background-image: url('../pictures/newnavagate.JPG');
	background-repeat: no-repeat;
	padding-left: 29px;
	padding-top: 4px;
}

.fun_list label {
	color: white;
	font-size: 15px;
	font-style: normal;
	padding-left: 20px;
	background-image: url('../pictures/newnavagate.JPG');
}

* {
	margin: 0;
	padding: 0;
	border: 0;
}

#nav {
	width: 180px;
	line-height: 24px;
	list-style-type: none;
	text-align: left;
	/*定义整个ul菜单的行高和背景色*/
}

#nav a {
	width: 165px;
	display: block;
	padding-left: 20px;
	/*Width(一定要)，否则下面的Li会变形*/
}

#nav li {
	background: white;
	background-image: url("../pictures/new_login_bg.gif");
	border-bottom: #FFF 1px solid; /*下面的一条白边*/
	float: left;
	/*float：left,本不应该设置，但由于在Firefox不能正常显示
	继承Nav的width,限制宽度，li自动向下延伸*/
}

#nav li a:hover {
	background: #c4e1ff; /*一级目录onMouseOver显示的背景色*/
	text-decoration: none;
	font-weight: bold;
}

#nav li a:link {
	color: #666;
	text-decoration: none;
}

#nav li a:visited {
	color: #666;
	text-decoration: none;
}

#PARENT {
	width: 180px;
	left: 20px;
	border: 1px solid gray;
}
</style>
	</head>
	<body>

		<!--start of function_Part  -->
		<div>
			<div style="height: auto;">
				<div style="height: 30px">
				</div>
				<div style="position: relative;">
					<div class="fun_list" id="fun_list1">
						<label>
							权 限 配 置
						</label>
					</div>
					<div id="PARENT">
						<ul id="nav">
	
					        <li>
								<a href="<%=basePath %>11_BackGroundSystem/ManagerManagement/AddUser.jsp" target="right"> 添加用户</a>
							</li>
							<li>
								<a href="UserRoleAction!showroleanduser2.action" target="right">用户角色配置</a>
							</li>
							<li>
								<a href="UserlistAction!showuserlist.action" target="right">用户账号及权限管理</a>
							</li>
							<li>
								<a href="<%=basePath %>11_BackGroundSystem/ManagerManagement/FunctionList.jsp" target="right">功能管理</a>
							</li>		
						</ul>
					</div>
					
					<div style="height: 40px">
				</div>
					<div class="fun_list" id="fun_list1">
						<label>
							初 始 化 配 置
						</label>
					</div>
					<div id="PARENT">
						<ul id="nav">
						    <li>
								<a href="RolelistAction.action" target="right"> 角色管理</a>
							</li>
							<li>
								<a href="FunctionAction!insertfunction.action" target="right">导入功能表</a>
							</li>
							<li>
								<a href="ModuleAction!showpagelist.action" target="right">子系统管理</a>
							</li>
							<li>
								<a href="<%=basePath %>11_BackGroundSystem/ManagerManagement/RoleFunctionConfig.jsp" target="right">角色功能配置</a>
							</li>
							<li>
								<a href="RoleModuleAction!RoleModuleConfig.action" target="right">角色子系统配置</a>								
							</li>
						</ul>
					</div>  
				</div> 
			</div>
			</div>
			<!--end of function_Part  -->
	</body>
</html>