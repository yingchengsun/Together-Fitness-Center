<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" errorPage="/errorPage.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>阶段报告详细信息</title>
		<link rel="stylesheet" type="text/css"
			href="<%=request.getContextPath()%>/bksx/css/css.css">
		<link rel="stylesheet" type="text/css"
			href="<%=request.getContextPath()%>/bksx/css/mycss.css">

	</head>

	<body>
		<br>
		<br>
		<h3 align="center">
			<img
				src="<%=request.getContextPath()%>/bksx/pictures/Aluminum_001.png"
				width="50" height="50" align="middle" />
			报告详情
		</h3>
		<table align="center" width="98%">
			<tr>
				<th align="left">
					<a href="<%=request.getContextPath()%>/showReportList.action"><img
							src="<%=request.getContextPath()%>/bksx/pictures/return.gif"
							align="top" border="0" />返回 </a>
				</th>
			</tr>
		</table>
		<hr>
		<div align="center">
			<table border="1" cellspacing="0" width="98%">
				<tr>
					<th
						background="<%=request.getContextPath()%>/bksx/pictures/bluebar.gif"
						colspan="2" height="30">
						进度报告
					</th>
				</tr>
				<tr>
					<th>
						项目
					</th>
					<th width="500">
						状态
					</th>
				</tr>
				<tr>
					<td align="center">
						报告作者
					</td>
					<td>
						${report.FReportAuthor }
					</td>
				</tr>
				<tr>
					<td align="center">
						参与人员
					</td>
					<td>
						${report.FReportMembers }
					</td>
				</tr>
				<tr>
					<td align="center">
						报告阶段
					</td>
					<td>
						${report.FReportStage }&nbsp;
					</td>
				</tr>
				<tr>
					<td align="center">
						起止时间
					</td>
					<td>
						<fmt:formatDate value="${report.FStartTime }" type="date"
							dateStyle="medium" />
						&nbsp; 至
						<fmt:formatDate value="${report.FFinishTime }" type="date"
							dateStyle="medium" />
						&nbsp;
					</td>
				</tr>
				<tr>
					<td align="center">
						工作目标
					</td>
					<td>
						${report.FStageGoal }&nbsp;
					</td>
				</tr>
				<tr>
					<td align="center">
						实际完成
					</td>
					<td>
						${report.FCompletedWork }&nbsp;
					</td>
				</tr>
				<tr>
					<td align="center">
						百分比率
					</td>
					<td>
						${report.FPercentage }&nbsp;
					</td>
				</tr>
				<tr>
					<td align="center">
						存在问题
					</td>
					<td>
						${report.FProblem }&nbsp;
					</td>
				</tr>
				<tr>
					<td align="center">
						解决方案
					</td>
					<td>
						${report.FSolution }&nbsp;
					</td>
				</tr>
				<tr>
					<td align="center">
						心得体会
					</td>
					<td>
						${report.FAcquisition }&nbsp;
					</td>
				</tr>
				<tr height="100">
					<th align="center">
						教师评价
					</th>
					<th>
						${report.FTeacherAdvice }&nbsp;
					</th>
				</tr>
				<tr height="100">
					<th align="center">
						督导建议
					</th>
					<th>
						${report.FManagerAdvice }&nbsp;
					</th>
				</tr>
			</table>
		</div>

		<br>
		<br>
		<br>
	</body>
</html>
