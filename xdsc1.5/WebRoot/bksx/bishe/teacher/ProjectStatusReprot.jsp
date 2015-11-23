<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" errorPage="/errorPage.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.fckeditor.net" prefix="FCK"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>项目阶段总结报告</title>

		<link rel="stylesheet" type="text/css"
			href="<%=request.getContextPath()%>/bksx/css/css.css">
		<link rel="stylesheet" type="text/css"
			href="<%=request.getContextPath()%>/bksx/css/mycss.css">

	</head>

	<body>
		<br>
		<h3 align="center">
			<img
				src="<%=request.getContextPath()%>/bksx/pictures/ontained.png"
				width="50" height="50" align="middle" />
			进度报告
		</h3>

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
						<th width="10%">
							项目
						</th>
						<th>
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
							${report.FReportStage }
						</td>
					</tr>
					<tr>
						<td align="center">
							起止时间
						</td>
						<td>
							${report.FStartTime } 至 ${report.FFinishTime }
						</td>
					</tr>
					<tr>
						<td align="center">
							工作目标
						</td>
						<td>
							${report.FStageGoal }
						</td>
					</tr>
					<tr>
						<td align="center">
							实际完成
						</td>
						<td>
							${report.FCompletedWork }
						</td>
					</tr>
					<tr>
						<td align="center">
							百分比率
						</td>
						<td>
							${report.FPercentage }
						</td>
					</tr>
					<tr>
						<td align="center">
							存在问题
						</td>
						<td>
							${report.FProblem }
						</td>
					</tr>
					<tr>
						<td align="center">
							解决方案
						</td>
						<td>
							${report.FSolution }
						</td>
					</tr>
					<tr>
						<td align="center">
							心得体会
						</td>
						<td>
							${report.FAcquisition }
						</td>
					</tr>
					<tr>
						<td align="center">
							教师评价
						</td>
						<td>
							${report.FTeacherAdvice }&nbsp;
						</td>
					</tr>
					<tr>
						<td align="center">
							督导评价
						</td>
						<td>
							${report.FManagerAdvice }&nbsp;
						</td>
					</tr>
					<tr>
						<td align="center">
							添加建议
						</td>
						<td>
							<form
								action="<%=request.getContextPath()%>/addTeacherAdvice.action?id=${report.FSid }"
								method="post">
								<FCK:editor instanceName="FTeacherAdvice"
									basePath="/fckeditor" width="100%" height="200"
									toolbarSet="mytools"></FCK:editor>
								<br>
								<input type="submit" value="添加" />
								<input type="reset" value="重填">
							</form>
						</td>
					</tr>
				</table>
		</div>
		<br>
		<br>
	</body>
</html>
