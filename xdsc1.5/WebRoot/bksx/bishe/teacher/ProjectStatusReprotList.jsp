<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" errorPage="/errorPage.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>报告列表</title>
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
			项目报告
		</h3>
		<table align="center" width="98%">
			<tr>
				<th align="left">
					<a
						href="<%=request.getContextPath()%>/showProjectDetail.action?id=${project.FProjId }"><img
							src="<%=request.getContextPath()%>/bksx/pictures/return.gif"
							align="top" border="0" />返回 </a>
				</th>
			</tr>
		</table>
		<hr>
		<div align="center">
			<c:choose>
				<c:when test="${not empty stageReport }">
					<table border="1" width="98%" cellspacing="0" id="mytable">
						<tr>
							<th colspan="4"
								background="<%=request.getContextPath()%>/bksx/pictures/bluebar.gif"
								height="30">
								项目阶段报告列表
							</th>
						</tr>
						<tr>
							<th>
								项目名称
							</th>
							<th>
								报告阶段
							</th>
							<th>
								报告人
							</th>
							<th>
								了解详情
							</th>
						</tr>
						<c:forEach items="${stageReport }" var="report">
							<tr>
								<td>
									${report.bksxTabProject.FProjectName }
								</td>
								<td>
									${report.FReportStage }
								</td>
								<td>
									${report.FReportAuthor }
								</td>
								<td>
									<a
										href="<%=request.getContextPath()%>/showDetail.action?id=${report.FSid }"><img
											src="<%=request.getContextPath()%>/bksx/pictures/lookdetail.gif"
											border="0" align="top" />
									</a>
								</td>
							</tr>
						</c:forEach>
					</table>
				</c:when>
				<c:otherwise>
					<table border="1" cellspacing="0" width="98%">
						<tr>
							<td>
								<br>
								<br>
								<img
									src="<%=request.getContextPath()%>/bksx/pictures/MinIcons_001.png" />
								<br>
								该生还没有写过该阶段 《阶段总结报告》
								<br>
								<br>
								<br>
							</td>
						</tr>
					</table>
				</c:otherwise>
			</c:choose>
		</div>
		<br>
		<br>
		<br>
	</body>
</html>
