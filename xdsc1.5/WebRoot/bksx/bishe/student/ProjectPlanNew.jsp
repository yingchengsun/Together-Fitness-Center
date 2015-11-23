<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" errorPage="/errorPage.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>

		<title>添加任务</title>
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
			添加任务
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
			<form action="<%=request.getContextPath()%>/addGanttplan.action"
				method="post" onsubmit="return validator(this)">
				<table width="98%" border="1" cellspacing="0" id="mytable">
					<tr>
						<th colspan="2"
							background="<%=request.getContextPath()%>/bksx/pictures/bluebar.gif"
							height="30">
							添加新的任务
						</th>
					</tr>
					<tr>
						<th>
							任务名称
						</th>
						<td>
							<input type="text" name="FTaskName" id="Limit"
								valid="required|limit" min="2" max="12"
								errmsg="请填写任务名称！|任务名称长度必须在2-12之间" />
						</td>
					</tr>
					<tr>
						<th>
							开始时间
						</th>
						<td>
							<input readonly="readonly" type="text" name="FStartDate"
								onClick="WdatePicker()" valid="required" errmsg="请选择开始日期!" />
						</td>
					</tr>
					<tr>
						<th>
							结束时间
						</th>
						<td>
							<input readonly="readonly" type="text" name="FFinishDate"
								onClick="WdatePicker()" valid="required" errmsg="请选择结束日期!" />
						</td>
					</tr>
					<tr>
						<th>
							负责人
						</th>
						<td>
							<select name="FStudentNumber">
								<c:forEach items="${memberList }" var="member">
									<option value="${member.tabStudents.FStudentNumber }">
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
						<th>
							完成百分比
						</th>
						<td>
							<input readonly="readonly" type="text" value="0.0%">
						</td>
					</tr>
					<tr>
						<th colspan="2">
							<input type="submit" value="添加">
							&nbsp;&nbsp;&nbsp;
							<input type="reset" value="重置">
						</th>
					</tr>
				</table>
			</form>
		</div>
	</body>
</html>
