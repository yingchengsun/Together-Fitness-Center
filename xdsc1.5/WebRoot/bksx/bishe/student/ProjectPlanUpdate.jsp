<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" errorPage="/errorPage.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>

		<title>更新项目计划</title>
		<link rel="stylesheet" type="text/css"
			href="<%=request.getContextPath()%>/bksx/css/css.css">
		<link rel="stylesheet" type="text/css"
			href="<%=request.getContextPath()%>/bksx/css/mycss.css">
		<script language="javascript"
			src="<%=request.getContextPath()%>/bksx/js/My97DatePicker/WdatePicker.js"></script>
		<script language="javascript"
			src="<%=request.getContextPath()%>/bksx/js/TableColor.js"></script>
		<script language="javascript"
			src="<%=request.getContextPath()%>/bksx/js/FormValid.js"></script>

	</head>

	<body>
		<br>
		<br>
		<h3 align="center">
			<img
				src="<%=request.getContextPath()%>/bksx/pictures/moblie_icon_001.png"
				width="50" height="50" align="middle" />
			更新计划
		</h3>
		<table align="center" width="98%">
			<tr>
				<th align="left">
					<a href="<%=request.getContextPath()%>/showGanttplan.action"><img
							src="<%=request.getContextPath()%>/bksx/pictures/return.gif"
							align="top" border="0" />返回 </a>
				</th>
			</tr>
		</table>
		<hr>
		<div align="center">
			<form action="<%=request.getContextPath()%>/updateGanttplan.action"
				method="post" onsubmit="return validator(this)">
				<table width="98%" border="1" cellspacing="0" id="mytable">
					<tr>
						<th colspan="2"
							background="<%=request.getContextPath()%>/bksx/pictures/bluebar.gif"
							height="30">
							任务信息更新
						</th>
					</tr>
					<tr>
						<th>
							任务编号
						</th>
						<td>
							<input type="hidden" name="FTaskId" value="${ganttTask.FTaskId }">
						</td>
					</tr>
					<tr>
						<th>
							任务名称
						</th>
						<td>
							<input type="text" name="FTaskName"
								value="${ganttTask.FTaskName }" id="Limit"
								valid="required|limit" min="2" max="12"
								errmsg="请填写任务名称！|任务名称长度必须在2-12之间">
						</td>
					</tr>
					<tr>
						<th>
							开始时间
						</th>
						<td>
							<input readonly="readonly" type="text" name="FStartDate"
								onClick="WdatePicker()" value="${ganttTask.FStartDate }"
								valid="required" errmsg="请选择开始日期!" />
						</td>
					</tr>
					<tr>
						<th>
							结束时间
						</th>
						<td>
							<input readonly="readonly" type="text" name="FFinishDate"
								onClick="WdatePicker()" value="${ganttTask.FFinishDate }"
								valid="required" errmsg="请选择结束日期!" />
						</td>
					</tr>
					<tr>
						<th>
							完成比率
						</th>
						<td>
							<select name="FCompletePercent">
								<option value="0.1"
									<c:if test="${ganttTask.FCompletePercent==0.1 }">selected="selected"</c:if>>
									10%
								</option>
								<option value="0.2"
									<c:if test="${ganttTask.FCompletePercent==0.2 }">selected="selected"</c:if>>
									20%
								</option>
								<option value="0.3"
									<c:if test="${ganttTask.FCompletePercent==0.3 }">selected="selected"</c:if>>
									30%
								</option>
								<option value="0.4"
									<c:if test="${ganttTask.FCompletePercent==0.4 }">selected="selected"</c:if>>
									40%
								</option>
								<option value="0.5"
									<c:if test="${ganttTask.FCompletePercent==0.5 }">selected="selected"</c:if>>
									50%
								</option>
								<option value="0.6"
									<c:if test="${ganttTask.FCompletePercent==0.6 }">selected="selected"</c:if>>
									60%
								</option>
								<option value="0.7"
									<c:if test="${ganttTask.FCompletePercent==0.7 }">selected="selected"</c:if>>
									70%
								</option>
								<option value="0.8"
									<c:if test="${ganttTask.FCompletePercent==0.8 }">selected="selected"</c:if>>
									80%
								</option>
								<option value="0.9"
									<c:if test="${ganttTask.FCompletePercent==0.9 }">selected="selected"</c:if>>
									90%
								</option>
								<option value="1"
									<c:if test="${ganttTask.FCompletePercent==1 }">selected="selected"</c:if>>
									100%
								</option>
								<option value="1" disabled="disabled">
									--请选择完成百分比-
								</option>
							</select>
						</td>
					</tr>
					<tr>
						<th>
							负责人
						</th>
						<td>
							<select name="FStudentNumber">
								<c:forEach items="${memberList }" var="member">
									<option value="${member.tabStudents.FStudentNumber }"
										<c:if test="${ganttTask.tabStudents.FStudentNumber==member.tabStudents.FStudentNumber }">selected="selected"</c:if>>
										${member.tabStudents.FStudentNumber }
										${member.tabStudents.FStudentName }
									</option>
								</c:forEach>
								<option disabled="disabled">
									--请选择任务负责人-
								</option>
							</select>
						</td>
					</tr>
					<tr>
						<th colspan="2">
							<input type="submit" value="更新">
							&nbsp;&nbsp;&nbsp;
							<input type="reset" value="取消">
						</th>
					</tr>
				</table>
			</form>
		</div>
	</body>
</html>
