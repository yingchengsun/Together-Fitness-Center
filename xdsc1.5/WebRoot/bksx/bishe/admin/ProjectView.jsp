<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" errorPage="/errorPage.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>项目审查</title>
		<link rel="stylesheet" type="text/css"
			href="<%=request.getContextPath()%>/bksx/css/css.css">
		<link rel="stylesheet" type="text/css"
			href="<%=request.getContextPath()%>/bksx/css/mycss.css">
		<script language="javascript"
			src="<%=request.getContextPath()%>/bksx/js/TableColor.js"></script>

	</head>

	<body>
		<br>
		<br>
		<h3 align="center">
			<img src="<%=request.getContextPath()%>/bksx/pictures/ontained.png"
				width="50" height="50" align="middle" />
			项目审查
		</h3>
		<table align="center" width="98%">
			<tr>
				<th align="left">
					<a href="<%=request.getContextPath()%>/showAllProject.action"><img
							src="<%=request.getContextPath()%>/bksx/pictures/return.gif"
							align="top" border="0" />返回 </a>
				</th>
			</tr>
		</table>
		<hr width="98%">
		<div align="center">
			<table border="1" width="98%" cellspacing="0" id="mytable">
				<tr>
					<th colspan="4"
						background="<%=request.getContextPath()%>/bksx/pictures/bluebar.gif"
						height="30">
						毕业设计项目信息
					</th>
				</tr>
				<tr>
					<th>
						项目序号
					</th>
					<th>
						项目名称
					</th>
					<th>
						项目团队
					</th>
					<th>
						项目来源
					</th>
				</tr>
				<tr>
					<td>
						${project.FProjId }&nbsp;
					</td>
					<td>
						${project.FProjectName }&nbsp;
					</td>
					<td>
						${project.bksxTabTeam.FTeamName }&nbsp;
					</td>
					<td>
						${project.FProjectCategory }&nbsp;
					</td>
				</tr>
				<tr>
					<td>
						项目成员
					</td>
					<td colspan="4">
						<c:forEach items="${memberList }" var="member">
							<a
								href="<%=request.getContextPath()%>/showStudentDiary.action?id=${member.tabStudents.FStudentNumber }">
								<img src="<%=request.getContextPath()%>/bksx/pictures/male.png"
									border="0" align="top" /> <font size="2">${member.tabStudents.FStudentName
									}</font> </a>
							&nbsp;&nbsp;&nbsp;&nbsp;
						</c:forEach>
					</td>
				</tr>
				<tr>
					<td>
						详细描述
					</td>
					<td colspan="4">
						${project.FProjectDescription }&nbsp;
					</td>
				</tr>
			</table>
			<br>
			<br>

		</div>
		<div align="center">
			<h4>
				项目进度
			</h4>
			<form
				action="<%=request.getContextPath()%>/getStudentReportByStage.action?id=${project.FProjId }"
				method="post">
				<table>
					<tr>
						<td>
							查看阶段进度报告：
						</td>
						<td>
							<select name="FReportStage">
								<option value="需求阶段" selected="selected">
									需求阶段
								</option>
								<option value="设计阶段">
									设计阶段
								</option>
								<option value="实现阶段">
									实现阶段
								</option>
							</select>
						</td>
						<td>
							<input type="submit" value="查询">
						</td>
					</tr>
				</table>
			</form>
			<hr>
			<img
				src="<%=request.getContextPath()%>/drawThisGanttChart.action?id=${project.FProjId }">
		</div>
		<hr>

		<br>
		<br>
		<br>
	</body>
</html>
