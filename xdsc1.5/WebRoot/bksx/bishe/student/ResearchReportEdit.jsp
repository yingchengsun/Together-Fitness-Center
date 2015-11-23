<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" errorPage="/errorPage.jsp"%>
<%@taglib uri="http://java.fckeditor.net" prefix="FCK"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>填写阶段工作报告</title>

		<link rel="stylesheet" type="text/css"
			href="<%=request.getContextPath()%>/bksx/css/css.css">
		<link rel="stylesheet" type="text/css"
			href="<%=request.getContextPath()%>/bksx/css/mycss.css">
		<script language="javascript"
			src="<%=request.getContextPath()%>/bksx/js/My97DatePicker/WdatePicker.js"></script>
	</head>

	<body>

		<br>
		<br>
		<h3 align="center">
			<img
				src="<%=request.getContextPath()%>/bksx/pictures/Aluminum_001.png"
				width="50" height="50" align="middle" />
			新建报告
		</h3>
		<table align="center" width="98%">
			<tr>
				<th align="left">
					<a href="<%=request.getContextPath()%>/getSummaryByStuNum.action"><img
							src="<%=request.getContextPath()%>/bksx/pictures/return.gif"
							align="top" border="0" />返回 </a>
				</th>
			</tr>
		</table>
		<hr>
		<div align="center">
			<form action="<%=request.getContextPath()%>/addWorkSummary.action"
				method="post">
				<table width="98%" border="1" cellspacing="0">
					<tr>
						<th colspan="3"
							background="<%=request.getContextPath()%>/bksx/pictures/bluebar.gif"
							height="30">
							课题研究阶段工作报告
						</th>
					</tr>
					<tr>
						<td colspan="3" scope="col">
							注意：新的报告将覆盖原有同阶段报告
						</td>
					</tr>
					<tr>
						<td colspan="2">
							工作阶段
						</td>
						<td width="428">
							<input type="radio" name="FSummaryStage" value="开题阶段"
								checked="checked">
							开题阶段
							<input type="radio" name="FSummaryStage" value="中期阶段">
							中期阶段
							<input type="radio" name="FSummaryStage" value="结题阶段">
							结题阶段
						</td>
					</tr>

					<tr>
						<td colspan="2">
							起止时间
						</td>
						<td>
							开始时间：
							<input readonly="readonly" type="text" name="FStartTime"
								onClick="WdatePicker()" size="12" />
							结束时间：
							<input readonly="readonly" type="text" name="FFinishTime"
								onClick="WdatePicker()" size="12" />
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
							实际工作/工作目标：
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
								<option disabled="disabled">
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
						<td colspan="2" width="15%">
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
