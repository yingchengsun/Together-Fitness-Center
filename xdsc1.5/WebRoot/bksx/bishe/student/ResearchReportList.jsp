<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" errorPage="/errorPage.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>阶段总结</title>
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
			总结报告
		</h3>
		<hr>
		<br>
		<c:choose>
			<c:when test="${subject=='reaserch' }">
				<div align="center">
					<form
						action="<%=request.getContextPath()%>/getSummaryByStage.action"
						method="post">
						<table>
							<tr>
								<td>
									查看阶段总结报告：
								</td>
								<td>
									<select name="FSummaryStage">
										<option value="开题阶段">
											开题阶段
										</option>
										<option value="中期阶段">
											中期阶段
										</option>
										<option value="结题阶段">
											结题阶段
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
					<c:if test="${not empty summaryList }">
						<table align="center" width="98%">
							<tr>
								<th align="right">
									<a
										href="<%=request.getContextPath()%>/bksx/bishe/student/ResearchReportEdit.jsp"><img
											src="<%=request.getContextPath()%>/bksx/pictures/edit.gif"
											border="0">撰写报告</a>
								</th>
							</tr>
						</table>
						<table border="1" cellspacing="0" width="98%" id="mytable">
							<tr>
								<th
									background="<%=request.getContextPath()%>/bksx/pictures/bluebar.gif"
									colspan="5" height="30">
									阶段总结列表
								</th>
							</tr>
							<tr>
								<th>
									报告编号
								</th>
								<th>
									课题名称
								</th>
								<th>
									总结阶段
								</th>
								<th>
									报告人
								</th>
								<th>
									操作
								</th>
							</tr>
							<c:forEach items="${summaryList }" var="summary">
								<tr>
									<td>
										${summary.FWid }
									</td>
									<td>
										${summary.bksxTabSubstugui.FSubjectName }
									</td>
									<td>
										${summary.FSummaryStage }
									</td>
									<td>
										${summary.bksxTabSubstugui.tabStudents.FStudentName }
									</td>
									<td>
										<a
											href="<%=request.getContextPath()%>/showSummaryDetail.action?id=${summary.FWid }">详细信息</a>
									</td>
								</tr>
							</c:forEach>
						</table>
					</c:if>
					<c:if test="${empty summaryList }">
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
										<a
											href="<%=request.getContextPath()%>/bksx/bishe/student/ResearchReportEdit.jsp"><img
												src="<%=request.getContextPath()%>/bksx/pictures/edit.gif"
												align="top" border="0" /><font color="green">点击此处创建</font>
										</a>
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
								你还未选题或已经加入某项目团队
								<br>
								请【在线选择课题】或者使用【项目课题】进行毕业设计管理工作
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
