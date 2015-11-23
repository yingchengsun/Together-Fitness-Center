<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" errorPage="/errorPage.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>项目阶段报告</title>

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
			<img
				src="<%=request.getContextPath()%>/bksx/pictures/Aluminum_001.png"
				width="50" height="50" align="middle" />
			进度报告
		</h3>

		<hr>
		<br>
		<c:choose>
			<c:when test="${subject=='project' }">
				<div align="center">
					<form
						action="<%=request.getContextPath()%>/showReportByStage.action"
						method="post">
						<table>
							<tr>
								<td>
									查看阶段进度报告：
								</td>
								<td>
									<select name="stage">
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
									<input type="submit" value="搜索">
								</td>
							</tr>
						</table>
					</form>
				</div>

				<hr>
				<div align="center">

					<c:if test="${not empty reportlist }">
						<table align="center" width="98%">
							<tr>
								<th align="right">
									<a href="<%=request.getContextPath()%>/preAddReport.action"><img
											src="<%=request.getContextPath()%>/bksx/pictures/add.gif"
											align="top" border="0">写报告</a>
								</th>
							</tr>
						</table>
						<table border="1" cellspacing="0" width="98%" id="mytable">
							<tr>
								<th
									background="<%=request.getContextPath()%>/bksx/pictures/bluebar.gif"
									colspan="5" height="30">
									进度报告列表
								</th>
							</tr>
							<tr>
								<th>
									报告编号
								</th>
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
									操作
								</th>
							</tr>
							<c:forEach items="${reportlist }" var="report">
								<tr>
									<td>
										${report.FSid }
									</td>
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
											align="top" border="0"></a>
									</td>
								</tr>
							</c:forEach>
						</table>
					</c:if>
					<c:if test="${empty reportlist }">
						<div align="center">
							<table border="1" cellspacing="0" width="98%">
								<tr>
									<td>
										<br>
										<br>
										<img
											src="<%=request.getContextPath()%>/bksx/pictures/MinIcons_001.png" />
										<br>
										你还没有写过（该阶段）《阶段总结报告》
										<br>
										<br>
										<a href="<%=request.getContextPath()%>/preAddReport.action"><img
												src="<%=request.getContextPath()%>/bksx/pictures/edit.gif"
												align="top" border="0" /><font color="green">点击此处创建</font>
										</a>
										<br>
										<br>
									</td>
								</tr>
							</table>
						</div>
					</c:if>
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
