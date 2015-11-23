<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>辅导员菜单</title>
<base href="<%=basePath%>">
<style type="text/css">

body {
	font-family: arial, 宋体, serif;
	font-size:12px;
	background-image:url("<%=basePath%>Pictures/newbackground.png");
}

.fun_list {
	FONT-WEIGHT: bold;
	background-image: url('<%=basePath%>Pictures/newnavagate.JPG');
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
					  
				       
					<!--start of PI_main  -->
					
					<!--end of PI_main  -->
					<div class="PI_main" style="height: 500px">
						<div style="position: relative;top: 5%;">
						

							<div class="fun_list" id="fun_list2" onclick="javasrcipt:showfun(2)" >
								<label > 就 业 信 息 </label>
							</div>
							<div id="PARENT">
								<ul id="nav">
									<li><a href="<%=basePath%>tutor/ClassInfo!findAllClassInfo.action" target="right"> 班级统计</a></li>
									<li><a href="<%=basePath%>tutor/WorkInfo!findAllWorkInfo.action" target="right"> 就业学生 </a></li>
									<li><a href="<%=basePath%>tutor/KaoyanInfo!findAllKaoyanInfo.action" target="right"> 深造学生 </a></li>
									<li><a href="<%=basePath%>tutor/OtherInfo!findAllOtherInfo.action" target="right"> 其他学生 </a></li>
							  </ul>
							</div>
							
							<div style="
								width:160px;
								height: 5px;
								background: white;
							"></div>
							<div class="fun_list" id="fun_list2" onclick="javasrcipt:showfun(2)" >
								<label > 毕 业 生 去 向 </label>
							</div>
							<div id="PARENT">
								<ul id="nav">
									<li><a href="<%=basePath%>tutor/CompanyInfo!findAllCompanyInfo.action" target="right"> 用人单位 </a></li>
									<li><a href="<%=basePath%>tutor/UniInfo!findAllUniInfo.action" target="right"> 升学学校 </a></li>
									</ul>
							</div>
							<div style="
								width:160px;
								height: 5px;
								background: white;
							"></div>
						
						</div>
					</div>
				</div>
				<!--end of function_Part  -->
</body>
</html>