<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" errorPage="/errorPage.jsp"%>
<%@taglib uri="http://java.fckeditor.net" prefix="FCK"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>课题研究阶段总结</title>
		<link rel="stylesheet" type="text/css"
			href="<%=request.getContextPath()%>/bksx/css/css.css">
		<link rel="stylesheet" type="text/css"
			href="<%=request.getContextPath()%>/bksx/css/mycss.css">
	</head>

	<body>

		<br>
		<h3 align="center">
			<img
				src="<%=request.getContextPath()%>/bksx/pictures/Aluminum_001.png"
				width="50" height="50" align="middle" />
			总结报告
		</h3>
		<hr>

		<div align="center">
			<c:if test="${not empty summary }">
				<table border="1" cellspacing="0" width="98%">
					<tr>
						<th
							background="<%=request.getContextPath()%>/bksx/pictures/bluebar.gif"
							colspan="2" height="30">
							进度报告
						</th>
					</tr>
					<tr>
						<th width="10%">
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
							${summary.FStartTime } 至 ${summary.FFinishTime }
						</td>
					</tr>
					<tr>
						<td align="center">
							阶段目标
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
					<tr>
						<td align="center">
							教师评价
						</td>
						<td>
							${summary.FTeacherAdvice }&nbsp;
						</td>
					</tr>
					<tr>
						<td align="center">
							督导评价
						</td>
						<td>
							${summary.FManagerAdvice }&nbsp;
						</td>
					</tr>
					<tr>
						<td align="center">
							点评
						</td>
						<td>
							<form
								action="<%=request.getContextPath()%>/addTeacherAdvice2Summary.action?id=${summary.FWid }"
								method="post">
								<FCK:editor instanceName="FTeacherAdvice"
									basePath="/fckeditor" width="100%" height="200"
									toolbarSet="mytools"></FCK:editor>
								<br>
								<input type="submit" value="提交">
								<input type="reset" value="重置">
							</form>

						</td>
					</tr>
				</table>
			</c:if>
			<c:if test="${empty summary }">
				<div align="center">
					<table border="1" cellspacing="0" width="98%">
						<tr>
							<td>
								<br>
								<br>
								<img
									src="<%=request.getContextPath()%>/bksx/pictures/MinIcons_001.png" />
								<br>
								该生还没有写过（该阶段）
								<font color="red">《阶段总结报告》</font>
								<br>
								<br>
								<br>
							</td>
						</tr>
					</table>
				</div>
			</c:if>
		</div>

		<br>
		<br>
		<br>
	</body>
</html>
