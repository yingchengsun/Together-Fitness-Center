<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" errorPage="/errorPage.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>指导项目型</title>

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
			项目课题
		</h3>
		<hr>
		<br>
		<div align="center">
			<c:choose>
				<c:when test="${not empty projectList }">
					<table border="1" cellspacing="0" id="mytable" width="98%">
						<tr>
							<th colspan="10"
								background="<%=request.getContextPath()%>/bksx/pictures/bluebar.gif"
								height="30">
								毕业设计选题信息
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
							<th>
								项目描述
							</th>
							<th>
								查看项目
							</th>
						</tr>
						<c:forEach items="${projectList }" var="project">
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
								<td>
									${project.FProjectDescription }&nbsp;
								</td>
								<td>
									<a
										href="<%=request.getContextPath()%>/showProjectDetail.action?id=${project.FProjId }"><img
											src="<%=request.getContextPath()%>/bksx/pictures/lookdetail.gif"
											border="0" align="top" /> </a>
								</td>
							</tr>
						</c:forEach>
					</table>
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
									目前没有此类课题信息！
									<br>
									<br>
									<br>
								</td>
							</tr>
						</table>
					</div>
				</c:otherwise>
			</c:choose>

		</div>
		<br>
		<br>

	</body>
</html>
