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
	font-size:12px;
	background-image:url('pictures/newbackground.png');
}

.fun_list {
	FONT-WEIGHT: bold;
	background-image: url('pictures/newnavagate.JPG');
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
background-image:url("pictures/new_login_bg.gif");
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
	width:185px;
	left:20px;
	
	border: 1px solid gray;
	
}
</style>
</head>

<body>

				<!--start of function_Part  -->
				<div>
					<div class="PI_main" style="height: 500px">
						<div style="position: relative;top: 1%;">
						
							<div class="fun_list">
								<label> 企 业 管 理 </label>
							</div>
							<div id="PARENT">
								<ul id="nav">
									<li><a href="<%=basePath %>yjssxCompany/CompanySelfInfo!findCompanyInfo.action" target="right"><img src="<%=basePath %>7_yjssx_system/SubSystemImage/selfInfo.png" height="20"/>&nbsp;&nbsp;企 业 信 息</a></li>
									<li><a href="<%=basePath %>yjssxCompany/CompanySelfInfo!preModifyCompanyInfo.action" target="right"><img src="<%=basePath %>7_yjssx_system/SubSystemImage/selfInfo.png" height="20"/>&nbsp;&nbsp;修 改 信 息</a></li>	
								</ul>
							</div>
							<div style="
								width:160px;
								height: 3px;
								background: white;
							"></div>
							<div class="fun_list">
								<label > 招 聘 管 理</label>
							</div>
							<div id="PARENT">
								<ul id="nav">
									<li><a href="<%=basePath %>yjssxCompany/CompanyReleaseZhaoPin!preRelease.action" target="right"><img src="<%=basePath %>7_yjssx_system/SubSystemImage/info2.png" height="20"/>&nbsp;&nbsp;查 看 招 生 计 划</a></li>
									<li><a href="<%=basePath %>yjssxCompany/CompanyReleaseZhaoPin!releaseInfomation.action" target="right"><img src="<%=basePath %>7_yjssx_system/SubSystemImage/info2.png" height="20"/>&nbsp;&nbsp;发 布 招 生 计 划</a></li>
								</ul>
							</div>
							<div style="
								width:160px;
								height: 5px;
								background: white;
							"></div>
							<div class="fun_list">
								<label > 应 聘 管 理</label>
							</div>
							<div id="PARENT">
								<ul id="nav">
									<li><a href="<%=basePath %>yjssxCompany/CompanyCheckResume!receiveResume.action" target="right"><img src="<%=basePath %>7_yjssx_system/SubSystemImage/manage2.png" height="20"/>&nbsp;&nbsp;应 聘 研 究 生</a></li>
									<li><a href="<%=basePath %>yjssxCompany/CompanyAcceptStu!acceptStudent.action"  target="right"><img src="<%=basePath %>7_yjssx_system/SubSystemImage/manage2.png" height="20"/>&nbsp;&nbsp;确 认 接 收</a></li>
								</ul>
							</div>
							<div style="
								width:160px;
								height: 5px;
								background: white;
							"></div>
							<div class="fun_list">
								<label > 学 生 管 理</label>
							</div>
							<div id="PARENT">
								<ul id="nav">
									<li><a href="<%=basePath %>yjssxCompany/CompanyAcceptStu!StudentAccepted.action"  target="right"><img src="<%=basePath %>7_yjssx_system/SubSystemImage/info3.png" height="20" />&nbsp;&nbsp;研 究 生 信 息</a></li>
									<li><a href="<%=basePath %>yjssxCompany/CompanySelectedStudent!showSelectedStu.action"  target="right"><img src="<%=basePath %>7_yjssx_system/SubSystemImage/info3.png" height="20" />&nbsp;&nbsp;发 送 通 知</a></li>
								</ul>
							</div>
							<div style="
								width:160px;
								height: 5px;
								background: white;
							"></div>
							<div class="fun_list" id="fun_list3" onclick="javasrcipt:showfun(3)">
								<label > 学 院 通 知</label>
							</div>
							<div id="PARENT">
								<ul id="nav">
									<li><a href="<%=basePath %>yjssxCompany/CompanyReceiveNotice!findAllNotice.action"  target="right"><img src="<%=basePath %>7_yjssx_system/SubSystemImage/sucaiwcom0566000jty.gif" height="20" />&nbsp;&nbsp;查 看 通 知</a></li>
								</ul>
							</div>
						</div>
					</div>
				</div>
				<!--end of function_Part  -->
</body>
</html>