<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" errorPage="/errorPage.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@taglib uri="http://java.fckeditor.net" prefix="FCK"%>
<html>
	<head>
		<title>撰写工作报告</title>
		<link rel="stylesheet" type="text/css"
			href="<%=request.getContextPath()%>/bksx/css/css.css">
		<link rel="stylesheet" type="text/css"
			href="<%=request.getContextPath()%>/bksx/css/mycss.css">
		<script language="javascript"
			src="<%=request.getContextPath()%>/bksx/js/My97DatePicker/WdatePicker.js"></script>
		<script language="javascript"
			src="<%=request.getContextPath()%>/bksx/js/FormValid.js"></script>
	</head>

	<body>

		<br>
		<br>
		<h3 align="center">
			<img
				src="<%=request.getContextPath()%>/bksx/pictures/Aluminum_001.png"
				width="50" height="50" align="middle" />
			撰写报告
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
			<form action="<%=request.getContextPath()%>/addReport.action"
				method="post" onsubmit="return validator(this)">
				<table width="98%" border="1" cellspacing="0">
					<tr>
						<th colspan="3"
							background="<%=request.getContextPath()%>/bksx/pictures/bluebar.gif"
							height="30">
							精简RUP模式项目开发工作阶段报告
						</th>
					</tr>
					<tr>
						<th colspan="2" scope="col" width="10%">
							项目
						</th>
						<th scope="col">
							状态
						</th>
					</tr>
					<tr>
						<td colspan="2">
							报告作者
						</td>
						<td>
							${myself.FStudentNumber } &nbsp;${myself.FStudentName }
						</td>
					</tr>
					<tr>
						<td colspan="2">
							参与人员
						</td>
						<td>
							<c:forEach items="${memberList }" var="member">
								<input type="checkbox" name="FReportMembers"
									value="${member.tabStudents.FStudentNumber }-${member.tabStudents.FStudentName }" />${member.tabStudents.FStudentNumber }-${member.tabStudents.FStudentName }
							</c:forEach>
							&nbsp;
						</td>
					</tr>
					<tr>
						<td colspan="2">
							项目阶段
						</td>
						<td width="550">
							<input type="radio" name="FReportStage" value="需求阶段"
								checked="checked">
							需求阶段
							<input type="radio" name="FReportStage" value="设计阶段">
							设计阶段
							<input type="radio" name="FReportStage" value="实现阶段">
							实现阶段
						</td>
					</tr>

					<tr>
						<td colspan="2">
							起止时间
						</td>
						<td>
							开始时间：
							<input readonly="readonly" type="text" name="FStartTime"
								onClick="WdatePicker()" size="12" valid="required"
								errmsg="请选择开始日期!" />

							结束时间：
							<input readonly="readonly" type="text" name="FFinishTime"
								onClick="WdatePicker()" size="12" valid="required"
								errmsg="请选择结束日期!" />
						</td>
					</tr>
					<tr>
						<td rowspan="3">
							工作内容
						</td>
						<td>
							工作目标
						</td>
						<td>
							<FCK:editor instanceName="FStageGoal" basePath="/fckeditor"
								width="100%" height="200" toolbarSet="mytools"></FCK:editor>
						</td>
					</tr>
					<tr>
						<td>
							实际工作
						</td>
						<td>
							<FCK:editor instanceName="FCompletedWork" basePath="/fckeditor"
								width="100%" height="200" toolbarSet="mytools"></FCK:editor>
						</td>
					</tr>
					<tr>
						<td>
							百分比率
						</td>
						<td>
							实际工作/目标工作：
							<select name="FPercentage">
								<option value="10%">
									10%
								</option>
								<option value="20%">
									20%
								</option>
								<option value="30">
									30%
								</option>
								<option value="40%">
									40%
								</option>
								<option value="50%">
									50%
								</option>
								<option value="60%">
									60%
								</option>
								<option value="70%">
									70%
								</option>
								<option value="80%">
									80%
								</option>
								<option value="90%">
									90%
								</option>
								<option value="100%">
									100%
								</option>
								<option value="0%" disabled="disabled">
									--请选择完成百分比-
								</option>
							</select>
						</td>
					</tr>
					<tr>
						<td rowspan="2">
							问题解决
						</td>
						<td>
							存在问题
						</td>
						<td>
							<FCK:editor instanceName="FProblem" basePath="/fckeditor"
								width="100%" height="200" toolbarSet="mytools"></FCK:editor>
						</td>
					</tr>
					<tr>
						<td>
							解决方案
						</td>
						<td>
							<FCK:editor instanceName="FSolution" basePath="/fckeditor"
								width="100%" height="200" toolbarSet="mytools"></FCK:editor>
						</td>
					</tr>
					<tr>
						<td colspan="2">
							心得体会
						</td>
						<td>
							<FCK:editor instanceName="FAcquisition" basePath="/fckeditor"
								width="100%" height="200" toolbarSet="mytools"></FCK:editor>
						</td>
					</tr>
					<tr>
						<td colspan="2">
							&nbsp;
						</td>
						<td>
							<input type="submit" value="提交" />
							<input type="reset" value="重置" />
						</td>
					</tr>
				</table>

			</form>
		</div>
		<br>
		<br>
		<br>

	</body>
</html>
