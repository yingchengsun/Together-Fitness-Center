<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" errorPage="/errorPage.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<title>项目计划与进度</title>
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/bksx/css/css.css">
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/bksx/css/mycss.css">
	</head>

	<body>
		<br>
		<br>
		<h3 align="center">
			<img
				src="<%=request.getContextPath()%>/bksx/pictures/moblie_icon_001.png"
				width="50" height="50" align="middle" />
			计划进度
		</h3>
		<hr>
		<br>
		<c:choose>
			<c:when test="${subject=='project' }">
				<div align="center">
					<img src="<%=request.getContextPath()%>/drawGanttChart.action">
					<hr>
					<a href="<%=request.getContextPath()%>/showGanttplan.action"><img
							src="<%=request.getContextPath()%>/bksx/pictures/edit.gif" border="0">查看详细任务信息</a>
				</div>
			</c:when>
			<c:otherwise>
				<div align="center">
					<table border="1" cellspacing="0" width="98%">
						<tr>
							<td>
								<br>
								<br>
								<img
									src="<%=request.getContextPath()%>/bksx/pictures/MinIcons_001.png" />
								<br>
								你还未立项或未加入某项目团队，请使用【科研课题】进行毕业设计管理工作
								<br>
								如需使用，请首先使用【毕设立项】做好准备工作
								<br>
								<br>
								<br>
								<br>
							</td>
						</tr>
					</table>
				</div>
			</c:otherwise>
		</c:choose>
		<br>
		<br>
		<br>
	</body>
</html>
