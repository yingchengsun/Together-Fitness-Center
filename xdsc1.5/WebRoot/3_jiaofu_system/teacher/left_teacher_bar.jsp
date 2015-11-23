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
		<base href="<%=basePath%>">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
		<style type="text/css">
body {
	font-family: arial, 宋体, serif;
	font-size: 12px;
	background-image: url("pictures/newbackground.png");
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
	font-style: normal;
	padding-left: 20px;
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
	background-image: url("pictures/new_login_bg.gif");
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
			<!--  div style="height: 30px; width: 218px;" class="NewsTitle3 title1">
						<div style="float: left; padding-top: 5px">
							&nbsp;内&nbsp;部&nbsp;邮&nbsp;件
						</div>-->

			<!--start of PI_main  -->

			<!--end of PI_main  -->
			<div class="PI_main" style="height: auto">
				<div style="height: 30px">
				</div>
				<div style="position: relative;">

					<div class="fun_list" id="fun_list1">
						<label>
							课 程 管 理
						</label>
					</div>
					<div id="PARENT">
						<ul id="nav">
							<li>
								<a href="teacher/CourseManage!findCourseInfo.action" target="right">查看课程</a>
							</li>
							<li>
								<a href="teacher/CourseManage!findCourseNoticeInfo.action" target="right">发布通知</a>
							</li>
							<li>
								<a href="teacher/CourseManage!questionReplyInfo.action" target="right">课程答疑</a>
							</li>
						</ul>
					</div>
					<div style="width: 160px; height: 3px; background: white;"></div>
					<div class="fun_list" id="fun_javasrcipt:showfun(2)">
						<label>
							教 学 管 理
						</label>
					</div>
					<div id="PARENT">
						<ul id="nav">
							<li>
								<a href="teacher/OwnArrangeInfo!findAllInfo.action" target="right">自我安排</a>
							</li>
						</ul>
					</div>
					<div style="width: 160px; height: 5px; background: white;"></div>
					<div class="fun_list" id="fun_list3" onclick=javasrcipt:showfun(3);>
						<label>
							作 业 管 理
						</label>
					</div>
					<div id="PARENT">
						<ul id="nav">
							<li>
								<a href="teacher/HomeworkManage!findHomeNoticeInfo.action" target="right">布置作业</a>
							</li>
							<li>
								<a href="teacher/HomeworkManage!findHomeUploadInfo.action" target="right">批改作业</a>
							</li>
							<li>
								<a href="teacher/HomeworkManage!findBeforeScoreInfo.action" target="right">平时考核</a>
							</li>
						</ul>
					</div>
					<div style="width: 160px; height: 5px; background: white;"></div>
					<div class="fun_list" id="fun_list3" onclick=javasrcipt:showfun(3);>
						<label>
							资 源 管 理
						</label>
					</div>
					<div id="PARENT">
						<ul id="nav">
							<li>
								<a href="teacher/ResourceManage!findResourceInfo.action" target="right">
									查看资源</a>
							</li>
							<li>
								<a href="teacher/ResourceManage!addInfoBeforeUpload.action" target="right">
									上传资源</a>
							</li>
						</ul>
					</div>
					<div style="width: 160px; height: 5px; background: white;"></div>
					<div class="fun_list" id="fun_list3" onclick=javasrcipt:showfun(3);>
						<label>
							课 程 助 教
						</label>
					</div>
					<div id="PARENT">
						<ul id="nav">
							<li>
								<a href="<%=basePath%>teacher/AssistantInfo!findAssistantInfo.action" target="right">
									查看助教</a>
							</li>
						</ul>
					</div>
				</div>
			</div>
			<!--end of function_Part  -->
	</body>
</html>