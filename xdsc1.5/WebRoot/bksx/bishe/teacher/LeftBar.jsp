<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="/errorPage.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>

		<style type="text/css">
body {
	font-family: arial, 宋体, serif;
	font-size: 12px;
	background-image: url("../../pictures/background.png");
}

.fun_list {
	FONT-WEIGHT: bold;
	background-image: url('../../pictures/navigation.jpg');
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
	background-image: url("../../pictures/loginbg.gif");
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

			<!--start of PI_main  -->

			<!--end of PI_main  -->
			<div class="PI_main" style="height: 500px">
				<div style="position: relative; top: 5%;">

					<div class="fun_list" id="fun_list1">
						<label>
							信 息 管 理
						</label>
					</div>
					<div id="PARENT">
						<ul id="nav">
							<li>
								<a href="<%=request.getContextPath()%>/getMyNewSubjects.action"
									target="right"> 新建毕设课题</a>
							</li>
							<li>
								<a
									href="<%=request.getContextPath()%>/getMyApplySubjects.action"
									target="right"> 审批学生选题</a>
							</li>
							<li>
								<a href="<%=request.getContextPath()%>/getMySubjects.action"
									target="right"> 查询指导题目</a>
							</li>
							<li>
								<a href="<%=request.getContextPath()%>/getMyStudents.action"
									target="right"> 查询指导学生</a>
							</li>
						</ul>
					</div>
					<div style="width: 160px; height: 3px; background: white;"></div>
					<div class="fun_list" id="fun_list2"
						onclick="javasrcipt:showfun(2)">
						<label>
							项 目 管 理
						</label>
					</div>
					<div id="PARENT">
						<ul id="nav">
							<li>
								<a
									href="<%=request.getContextPath()%>/getMyProjectApplyList.action"
									target="right"> 审批立项申请</a>
							</li>
							<li>
								<a href="<%=request.getContextPath()%>/getMyProjectList.action"
									target="right"> 管理团队项目</a>
							</li>
							<li>
								<a
									href="<%=request.getContextPath()%>/getMyResearchList.action"
									target="right"> 管理个人项目</a>
							</li>
						</ul>
					</div>
					<div style="width: 160px; height: 5px; background: white;"></div>
					<div class="fun_list" id="fun_list3"
						onclick="javasrcipt:showfun(3)">
						<label>
							文 档 管 理
						</label>
					</div>
					<div id="PARENT">
						<ul id="nav">
							<li>
								<a
									href="<%=request.getContextPath()%>/filePreDownload.action"
									target="right"> 查收阶段文档</a>
							</li>
						</ul>
					</div>
					<div style="width: 160px; height: 5px; background: white;"></div>
					<div class="fun_list" id="fun_list3"
						onclick="javasrcipt:showfun(3)">
						<label>
							答 辩 安 排
						</label>
					</div>
					<div id="PARENT">
						<ul id="nav">
							<li>
								<a
									href="<%=request.getContextPath()%>/showChecklistNotice.action"
									target="right"> 查看答辩安排</a>
							</li>
						</ul>
					</div>
					<div style="width: 160px; height: 5px; background: white;"></div>
					<div class="fun_list" id="fun_list3"
						onclick="javasrcipt:showfun(3)">
						<label>
							成 绩 查 询
						</label>
					</div>
					<div id="PARENT">
						<ul id="nav">
							<li>
								<a
									href="<%=request.getContextPath()%>/getMyStudentAchievement.action"
									target="right"> 查看学生成绩</a>
							</li>
						</ul>
					</div>

				</div>
			</div>
		</div>
		<!--end of function_Part  -->
	</body>
</html>