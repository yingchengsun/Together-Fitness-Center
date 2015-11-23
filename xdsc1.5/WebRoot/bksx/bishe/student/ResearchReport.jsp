<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" errorPage="/errorPage.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>阶段报告</title>
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
					<a href="<%=request.getContextPath()%>/getSummaryByStuNum.action"><img
							src="<%=request.getContextPath()%>/bksx/pictures/return.gif"
							border="0">返回</a>
				</th>
			</tr>
		</table>

		<hr>
		<div align="center">
			<table border="1" width="98%" cellspacing="0">
				<tr>
					<th
						background="<%=request.getContextPath()%>/bksx/pictures/bluebar.gif"
						colspan="2" height="30">
						阶段总结报告详细内容
					</th>
				</tr>
				<tr>
					<th width="100">
						项目
					</th>
					<th>
						状态
					</th>
				</tr>
				<tr>
					<td align="center">
						课题名称
					</td>
					<td>
						${summary.bksxTabSubstugui.FSubjectName }
					</td>
				</tr>
				<tr>
					<td align="center">
						报告作者
					</td>
					<td>
						${summary.bksxTabSubstugui.tabStudents.FStudentName }
					</td>
				</tr>

				<tr>
					<td align="center">
						报告阶段
					</td>
					<td>
						${summary.FSummaryStage }
					</td>
				</tr>
				<tr>
					<td align="center">
						起止时间
					</td>
					<td>

						<fmt:formatDate value="${summary.FStartTime }" type="date"
							dateStyle="medium" />
						至
						<fmt:formatDate value="${summary.FFinishTime }" type="date"
							dateStyle="medium" />

					</td>
				</tr>
				<tr>
					<td align="center">
						工作目标
					</td>
					<td>
						${summary.FStageGoal }
					</td>
				</tr>
				<tr>
					<td align="center">
						实际工作
					</td>
					<td>
						${summary.FCompletedWork }
					</td>
				</tr>
				<tr>
					<td align="center">
						百分比率
					</td>
					<td>
						${summary.FPercentage }
					</td>
				</tr>
				<tr>
					<td align="center">
						存在问题
					</td>
					<td>
						${summary.FProblem }
					</td>
				</tr>
				<tr>
					<td align="center">
						解决方案
					</td>
					<td>
						${summary.FSolution }
					</td>
				</tr>
				<tr>
					<td align="center">
						心得体会
					</td>
					<td>
						${summary.FAcquisition }
					</td>
				</tr>
				<tr bgcolor="#FFF4C1">
					<td align="center">
						教师评价
					</td>
					<td>
						${summary.FTeacherAdvice }&nbsp;
					</td>
				</tr>
				<tr bgcolor="#FFF4C1">
					<td align="center">
						督导建议
					</td>
					<td>
						${summary.FManagerAdvice }&nbsp;
					</td>
				</tr>
			</table>
		</div>

		<br>
		<br>
		<br>
	</body>
</html>
