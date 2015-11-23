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
	padding-left: 2px;
	padding-top: 3px;
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
					<div class="PI_main" style="height: 550px">
						<div style="position: relative;top: 1%;">
						
							<div class="fun_list" id="fun_list1" >
								<label> 首 页 信 息 管 理 </label>
							</div>
							<div id="PARENT">
								<ul id="nav">
									<li><a href="<%=basePath %>yjssxAdmin/AdminReleaseFirstPageInfo!showInfo.action?type=1" target="right"><img src="<%=basePath %>7_yjssx_system/SubSystemImage/thesis.png" height="20" />&nbsp;&nbsp;新闻公告管理</a></li>
									<li><a href="<%=basePath %>yjssxAdmin/AdminReleaseFirstPageInfo!showInfo.action?type=2" target="right"><img src="<%=basePath %>7_yjssx_system/SubSystemImage/thesis.png" height="20" />&nbsp;&nbsp;首页通知管理</a></li>	
									<li><a href="<%=basePath %>yjssxAdmin/AdminReleaseFirstPageInfo!showInfo.action?type=3" target="right"><img src="<%=basePath %>7_yjssx_system/SubSystemImage/thesis.png" height="20" />&nbsp;&nbsp;相关资料管理</a></li>	
									<li><a href="<%=basePath %>yjssxAdmin/AdminManageZhaoPinInfo!showInfo.action" target="right"><img src="<%=basePath %>7_yjssx_system/SubSystemImage/thesis.png" height="20" />&nbsp;&nbsp;招聘信息管理</a></li>
									<li><a href="<%=basePath %>yjssxAdmin/AdminReleaseFirstPageInfo!showInfo.action?type=5" target="right"><img src="<%=basePath %>7_yjssx_system/SubSystemImage/thesis.png" height="20" />&nbsp;&nbsp;合作基地管理</a></li>	
									<li><a href="<%=basePath %>yjssxAdmin/AdminReleaseFirstPageInfo!showInfo.action?type=6" target="right"><img src="<%=basePath %>7_yjssx_system/SubSystemImage/thesis.png" height="20" />&nbsp;&nbsp;实习政策管理</a></li>
									<li><a href="<%=basePath %>yjssxAdmin/AdminReleaseFirstPageInfo!showInfo.action?type=7" target="right"><img src="<%=basePath %>7_yjssx_system/SubSystemImage/thesis.png" height="20" />&nbsp;&nbsp;管理制度管理</a></li>
								</ul>
							</div>
							<div style="
								width:160px;
								height: 3px;
								background: white;
							"></div>
							<div class="fun_list" id="fun_list2" onclick="javasrcipt:showfun(2)" >
								<label >学 院 内 部 通 知</label>
							</div>
							<div id="PARENT">
								<ul id="nav">
									<li><a href="<%=basePath %>yjssxAdmin/AdminNoticeOperation!showAllNotice.action" target="right"><img src="<%=basePath %>7_yjssx_system/SubSystemImage/sucaiwcom0566000jty.gif" height="20" />&nbsp;&nbsp;查 看 通 知</a></li>
									<li><a href="<%=basePath %>yjssxAdmin/AdminReleaseNotice!releaseNotice.action" target="right"><img src="<%=basePath %>7_yjssx_system/SubSystemImage/sucaiwcom0566000jty.gif" height="20" />&nbsp;&nbsp;发 送 通 知</a></li>
								</ul>
							</div>
							<div style="
								width:160px;
								height: 3px;
								background: white;
							"></div>
							<div class="fun_list" id="fun_list2" onclick="javasrcipt:showfun(2)" >
								<label >系 统 功 能 配 置</label>
							</div>
							<div id="PARENT">
								<ul id="nav">
									<li><a href="<%=basePath %>yjssxAdmin/AdminSystemFunctionDeploy!preTutorSelectDeploy.action" target="right"><img src="<%=basePath %>7_yjssx_system/SubSystemImage/selectTutor.png" height="20"/>&nbsp;&nbsp;导 师 选 择 配 置</a></li>
									<li><a href="<%=basePath %>yjssxAdmin/AdminSystemFunctionDeploy!preThesisSubmitDeploy.action" target="right"><img src="<%=basePath %>7_yjssx_system/SubSystemImage/selectTutor.png" height="20"/>&nbsp;&nbsp;论 文 检 查 配 置</a></li>
									<li><a href="<%=basePath %>yjssxAdmin/AdminSystemFunctionDeploy!preCompanyReleaseInfoDeploy.action" target="right"><img src="<%=basePath %>7_yjssx_system/SubSystemImage/selectTutor.png" height="20"/>&nbsp;&nbsp;企 业 招 聘 配 置</a></li>
								</ul>
							</div>
							<div style="
								width:160px;
								height: 5px;
								background: white;
							"></div>
							<div class="fun_list" id="fun_list3" onclick="javasrcipt:showfun(3)">
								<label > 导 师 选 择 管 理</label>
							</div>
							<div id="PARENT">
								<ul id="nav">
									<li><a href="<%=basePath %>yjssxAdmin/AdminTutorSelectManage!preManage.action" target="right"><img src="<%=basePath %>7_yjssx_system/SubSystemImage/manage1.png" height="20" />&nbsp;&nbsp;导师选择信息</a></li>
									<li><a href="<%=basePath %>yjssxAdmin/AdminTutorSelectDispach!preDispachStudent.action" target="right"><img src="<%=basePath %>7_yjssx_system/SubSystemImage/manage1.png" height="20" />&nbsp;&nbsp;研究生分配</a></li>
									<li><a href="<%=basePath %>yjssxAdmin/AdminTutorSelectDispach!preConfirmAddStuToTutor.action" target="right"><img src="<%=basePath %>7_yjssx_system/SubSystemImage/manage1.png" height="20" />&nbsp;&nbsp;研究生调剂</a></li>
								</ul>
							</div>
							<div style="
								width:160px;
								height: auto;
								background: white;
							"></div>
							<div class="fun_list" id="fun_list3" onclick="javasrcipt:showfun(3)">
								<label > 实 习 招 聘 管 理</label>
							</div>
							<div id="PARENT">
								<ul id="nav">
								    <li><a href="<%=basePath %>yjssxAdmin/AdminPractingZhaoPinManage!preShowManage.action"  target="right"><img src="<%=basePath %>7_yjssx_system/SubSystemImage/manage3.png" height="20" />&nbsp;&nbsp;实 习 查 看</a></li>
									<li><a href="<%=basePath %>yjssxAdmin/AdminPractingZhaoPinManage!preSearchForManage.action"  target="right"><img src="<%=basePath %>7_yjssx_system/SubSystemImage/manage3.png" height="20" />&nbsp;&nbsp;实 习 管 理</a></li>
								</ul>
							</div>
							<div style="
								width:160px;
								height: 5px;
								background: white;
							"></div>
							<div class="fun_list" id="fun_list3" onclick="javasrcipt:showfun(3)">
								<label > 学 生 论 文 管 理</label>
							</div>
							<div id="PARENT">
								<ul id="nav">
									<li><a href="<%=basePath %>yjssxAdmin/AdminThesisManage!ThesisPreManage.action?ThesisType=1" target="right"><img src="<%=basePath %>7_yjssx_system/SubSystemImage/manage2.png" height="20" />&nbsp;&nbsp;开 题 报 告</a></li>
									<li><a href="<%=basePath %>yjssxAdmin/AdminThesisManage!ThesisPreManage.action?ThesisType=2" target="right"><img src="<%=basePath %>7_yjssx_system/SubSystemImage/manage2.png" height="20" />&nbsp;&nbsp;中 期 检 查</a></li>
									<li><a href="<%=basePath %>yjssxAdmin/AdminThesisManage!ThesisPreManage.action?ThesisType=3"  target="right"><img src="<%=basePath %>7_yjssx_system/SubSystemImage/manage2.png" height="20" />&nbsp;&nbsp;终 审 论 文</a></li>
								</ul>
							</div>
							<div style="
								width:160px;
								height: 5px;
								background: white;
							"></div>
							<div class="fun_list" id="fun_list3" onclick="javasrcipt:showfun(3)">
								<label > 导 师 信 息 管 理</label>
							</div>
							<div id="PARENT">
								<ul id="nav">
									<li><a href="<%=basePath %>yjssxAdmin/AdminTutorInfoManage!preAddNewTutorInfo.action" target="right"><img src="<%=basePath %>7_yjssx_system/SubSystemImage/manage4.png" height="20" />&nbsp;&nbsp;添加导师信息</a></li>
									<li><a href="<%=basePath %>yjssxAdmin/AdminTutorInfoManage!preAddNewTutor.action" target="right"><img src="<%=basePath %>7_yjssx_system/SubSystemImage/manage4.png" height="20" />&nbsp;&nbsp;分配新导师</a></li>
									<li><a href="<%=basePath %>yjssxAdmin/AdminTutorInfoManage!findAllTutor.action"  target="right"><img src="<%=basePath %>7_yjssx_system/SubSystemImage/manage4.png" height="20" />&nbsp;&nbsp;导师信息管理</a></li>
								</ul>
							</div>
							<div style="
								width:160px;
								height: 5px;
								background: white;
							"></div>
							<div class="fun_list" id="fun_list3" onclick="javasrcipt:showfun(3)">
								<label > 学 生 信 息 管 理</label>
							</div>
							<div id="PARENT">
								<ul id="nav">
									<li><a href="<%=basePath %>yjssxAdmin/AdminStudentInfoManage!preAddNewStudent.action"  target="right"><img src="<%=basePath %>7_yjssx_system/SubSystemImage/info3.png" height="20" />&nbsp;&nbsp;添加研究生信息</a></li>
									<li><a href="<%=basePath %>yjssxAdmin/AdminStudentInfoManage!showAllPostgraudte.action"  target="right"><img src="<%=basePath %>7_yjssx_system/SubSystemImage/info3.png" height="20" />&nbsp;&nbsp;研究生信息管理</a></li>
									<li><a href="<%=basePath %>yjssxAdmin/AdminStudentInfoManage!studentAddTutor.action"  target="right"><img src="<%=basePath %>7_yjssx_system/SubSystemImage/info3.png" height="20" />&nbsp;&nbsp;研究生添加导师</a></li>
									<li><a href="<%=basePath %>yjssxAdmin/AdminStudentInfoManage!studentAddCompany.action"  target="right"><img src="<%=basePath %>7_yjssx_system/SubSystemImage/info3.png" height="20" />&nbsp;&nbsp;研究生添加企业</a></li>
								</ul>
							</div>
							<div style="
								width:160px;
								height: 10px;
								background: white;
							"></div>
							<div class="fun_list" id="fun_list3" onclick="javasrcipt:showfun(3)">
								<label > 企 业 信 息 管 理</label>
							</div>
							<div id="PARENT">
								<ul id="nav">
									<li><a href="<%=basePath %>yjssxAdmin/AdminCompanyInfoManage!preAddCompanyInfo.action" target="right"><img src="<%=basePath %>7_yjssx_system/SubSystemImage/manage6.png" height="20" />&nbsp;&nbsp;添加企业信息</a></li>
									<li><a href="<%=basePath %>yjssxAdmin/AdminCompanyInfoManage!findAllCompany.action"  target="right">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;企业信息管理</a></li>
								</ul>
							</div>
						</div>
					</div>
				</div>
				<!--end of function_Part  -->
</body>
</html>