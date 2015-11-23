<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style type="text/css">

body {
	font-family: arial, 宋体, serif;
	font-size:12px;
	background-image:url("../../Pictures/newbackground.png");
}

.fun_list {
	FONT-WEIGHT: bold;
	background-image: url('../../Pictures/newnavagate.JPG');
	background-repeat: no-repeat;
	padding-left: 29px;
	padding-top: 4px;
}

.fun_list label {
	color: white;
	font-size: 15px;
	font-style:normal;
	padding-left: 20px;
}

*{margin:0;padding:0;border:0;}

#nav {
	width:180px;
    line-height: 24px; 
	list-style-type: none;
	text-align:left;
    /*定义整个ul菜单的行高和背景色*/
}
#nav a {
	width: 165px; 
	display: block;
	padding-left:20px;
	/*Width(一定要)，否则下面的Li会变形*/
}

#nav li {
background:white; 
background-image:url("../../Pictures/new_login_bg.gif");
border-bottom:#FFF 1px solid; /*下面的一条白边*/
float:left;
	/*float：left,本不应该设置，但由于在Firefox不能正常显示
	继承Nav的width,限制宽度，li自动向下延伸*/
}

#nav li a:hover{
	background:#c4e1ff;	/*一级目录onMouseOver显示的背景色*/
	text-decoration:none;font-weight:bold;
}
#nav li a:link  {
	color:#666; text-decoration:none;
}
#nav li a:visited  {
	color:#666;text-decoration:none;
}

#PARENT{
	width:180px;
	left:20px;
	
	border: 1px solid gray;
	
}
</style>
</head>
<body>

				<!--start of function_Part  -->
				<div>
					    <!--  div style="height: 30px; width: 218px;" class="NewsTitle3 title1">
						<div style="float: left; padding-top: 5px">
							&nbsp;内&nbsp;部&nbsp;邮&nbsp;件
						</div>-->
				       
					<!--start of PI_main  -->
					
					<!--end of PI_main  -->
					<div class="PI_main" style="height: 500px">
						<div style="position: relative;top: 5%;">
						    <div class="fun_list" id="fun_list1" >
								<label> 权 限 管 理  </label>
							</div>
							<div id="PARENT">
								<ul id="nav">
									<li><a href="RolelistAction.action" target="right"> 角色管理</a></li>
									<li><a href="FunctionAction!showfunctionlist.action" target="right">功能列表</a></li>	
									<li><a href="ModuleAction!showpagelist.action" target="right">模块管理</a></li>	
									<li><a href="UserlistAction!showuserlist.action" target="right">账号管理</a></li>	
									<li><a href="UserRoleAction!showlist.action" target="right">用户角色对应表</a></li>	
									<li><a href="ModuleUserAction!showpagelist.action" target="right">用户模块对应表</a></li>	
									<li><a href="RoleFunctionAction!showpagelist.action" target="right">角色功能对应表</a></li>	
									<li><a href="UserFunctionAction!showlist.action" target="right">用户功能对应表</a></li>	
									<li><a href="RoleModuleAction!showlist.action" target="right">角色模块对应表</a></li>	
									<li><a href="AddUserRoleAction.action" target="right">用户角色配置</a></li>	
									<li><a href="AddUserRoleAction.action" target="right">用户模块配置</a></li>	
									<li><a href="RoleFunctionAction!getrolelist.action" target="right">角色功能配置</a></li>	
									<li><a href="../ManagerManagement/UserFunctionConfig.jsp" target="right">用户功能配置</a></li>	
									<li><a href="../ManagerManagement/RoleModuleConfig.jsp" target="right">角色模块配置</a></li>	

								</ul>
							</div>
						   <!--  
							<div class="fun_list" id="fun_list1" >
								<label> 门 户 管 理  </label>
							</div>
							<div id="PARENT">
								<ul id="nav">
									<li><a href="NewsManagement.jsp" target="right"> 新闻管理</a></li>
									<li><a href="BulletinManagement.jsp" target="right">公告管理</a></li>	
									<li><a href="NoticeManagement.jsp" target="right">通知管理</a></li>	
									<li><a href="LinkManagement.jsp" target="right">友情链接管理</a></li>	
									<li><a href="NavigationManagement.jsp" target="right">导航管理</a></li>	
								</ul>
							</div>
							<div style="
								width:160px;
								height: 3px;
								background: white;
							"></div>
							-->
							
							<div class="fun_list" id="fun_list2" onclick="javasrcipt:showfun(2)" >
								<label > 学 生 管 理 </label>
							</div>
							<div id="PARENT">
								<ul id="nav">
									<li><a href="../SutdentManagement/StudentinfoManagement.jsp" target="right">学生信息管理</a></li>
									<li><a href="../SutdentManagement/ActivityManagement.jsp" target="right">学生活动记录</a></li>
									<li><a href="../SutdentManagement/PrincipleManagement.jsp" target="right">规章制度管理</a></li>
									<li><a href="../SutdentManagement/PartyinfoManagement.jsp" target="right">党建工作信息管理</a></li>
									<li><a href="../SutdentManagement/ShowstudentManagement.jsp" target="right">学生风采</a></li>
									<li><a href="../SutdentManagement/StudenttrackManagement.jsp" target="right">校友追踪</a></li>
								</ul>
							</div>
							<div style="
								width:160px;
								height: 5px;
								background: white;
							"></div>
							<div class="fun_list" id="fun_list3" onclick="javasrcipt:showfun(3)">
								<label > 答 辩 管 理</label>
							</div>
							<div id="PARENT">
								<ul id="nav">
									<li><a href="ChecklistImport.jsp" target="right">答辩导入</a></li>
									<li><a href="ChecklistManagement.jsp" target="right">答辩安排</a></li>
								</ul>
							</div>
							<div style="
								width:160px;
								height: 5px;
								background: white;
							"></div>
							<div class="fun_list" id="fun_list3" onclick="javasrcipt:showfun(3)">
								<label > 本科生实习管理</label>
							</div>
							<div id="PARENT">
								<ul id="nav">
									<li><a href="ResultImport.jsp" target="right"> 成绩导入</a></li>
									<li><a href="ResultImport.jsp" target="right"> 成绩导入</a></li>
									<li><a href="ResultImport.jsp" target="right"> 成绩导入</a></li>
									<li><a href="ResultManagement.jsp"  target="right"> 成绩管理</a></li>
								</ul>
							</div>
							<div style="
								width:160px;
								height: 5px;
								background: white;
							"></div>
							<div class="fun_list" id="fun_list3" onclick="javasrcipt:showfun(3)">
								<label > 成 员 管 理</label>
							</div>
							<div id="PARENT">
								<ul id="nav">
									<li><a href="TeacherManagment.jsp"  target="right"> 教师管理</a></li>
									<li><a href="StudentManagment.jsp"  target="right"> 学生管理</a></li>
								</ul>
							</div>
						</div>
					</div>
				</div>
				<!--end of function_Part  -->
</body>
</html>