<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" errorPage="/errorPage.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>

		<title>项目任务信息</title>
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
				src="<%=request.getContextPath()%>/bksx/pictures/moblie_icon_001.png"
				width="50" height="50" align="middle" />
			任务详情
		</h3>
		<table align="center" width="98%">
			<tr>
				<th align="left">
					<a
						href="<%=request.getContextPath()%>/bksx/bishe/student/ProjectProgress.jsp"><img
							src="<%=request.getContextPath()%>/bksx/pictures/return.gif"
							align="top" border="0" />返回 </a>
				</th>
			</tr>
		</table>
		<hr>
		<div align="center">
			<table width="98%" border="1" cellspacing="0" id="mytable">
				<tr>
					<th colspan="8"
						background="<%=request.getContextPath()%>/bksx/pictures/bluebar.gif"
						height="30">
						项目开发计划
					</th>
				</tr>
				<tr>
					<th>
						任务编号
					</th>
					<th>
						任务名称
					</th>
					<th>
						开始时间
					</th>
					<th>
						结束时间
					</th>
					<th>
						完成比率
					</th>
					<th>
						负责人
					</th>
					<th>
						更新
					</th>
					<th>
						删除
					</th>
				</tr>
				<c:forEach items="${ganttlist}" var="task">
					<tr>
						<td>
							${task.FTaskId }
						</td>
						<td>
							${task.FTaskName }
						</td>
						<td>
							<fmt:formatDate value="${task.FStartDate }" type="date"
								dateStyle="medium" />
						</td>
						<td>
							<fmt:formatDate value="${task.FFinishDate }" type="date"
								dateStyle="medium" />
						</td>
						<td>
							${task.FCompletePercent*100 }%
						</td>
						<td>
							${task.tabStudents.FStudentName }
						</td>
						<td>
							<a
								href="<%=request.getContextPath()%>/preUpdateGanttplan.action?id=${task.FTaskId }">
								<img
									src="<%=request.getContextPath()%>/bksx/pictures/update.gif"
									border="0" /> </a>
						</td>
						<td>
							<a
								onclick="javascript: if(window.confirm('数据不可恢复，确定要删除么？')) window.location.href='<%=request.getContextPath()%>/deleteGanttplan.action?id=${task.FTaskId }'; "><img
									src="<%=request.getContextPath()%>/bksx/pictures/delete.gif"
									border="0" /> </a>
						</td>
					</tr>
				</c:forEach>
			</table>
			<hr>
			<a href="<%=request.getContextPath()%>/preAddTask.action"> <img
					src="<%=request.getContextPath()%>/bksx/pictures/add.gif"
					border="0" align="bottom">&nbsp;添加新的任务</a>
		</div>
	</body>
</html>
