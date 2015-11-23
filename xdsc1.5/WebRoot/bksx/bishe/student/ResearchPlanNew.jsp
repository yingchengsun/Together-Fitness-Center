<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" errorPage="/errorPage.jsp"%>
<%@taglib uri="http://java.fckeditor.net" prefix="FCK"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>新建工作计划</title>

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
			<img src="<%=request.getContextPath()%>/bksx/pictures/moblie_icon_001.png"
				width="50" height="50" align="middle" />
			新建计划
		</h3>
		<table align="center" width="98%">
			<tr>
				<th align="left">
					<a href="<%=request.getContextPath()%>/getPlanByStu.action"><img
							src="<%=request.getContextPath()%>/bksx/pictures/return.gif"
							align="top" border="0" />返回</a>
				</th>
			</tr>
		</table>
		<hr>
		<br>
		<div align="center">
			<form action="addResearchPlan.action" method="post">
				<table width="98%" border="1" cellspacing="0">
					<tr>
						<th colspan="3"
							background="<%=request.getContextPath()%>/bksx/pictures/bluebar.gif"
							height="30">
							新建研究计划
						</th>
					</tr>
					<tr>
						<th rowspan="2">
							开题阶段
						</th>
						<th>
							起止时间
						</th>
						<td>
							开始时间：
							<input readonly="readonly" type="text" name="FFstartDate"
								onClick="WdatePicker()" size="12" />
							结束时间：
							<input readonly="readonly" type="text" name="FFfinishDate"
								onClick="WdatePicker()" size="12" />
						</td>

					</tr>
					<tr>
						<th>
							工作内容
						</th>
						<td>
							<FCK:editor instanceName="FFcontent" basePath="/fckeditor"
								width="100%" height="200" toolbarSet="mytools"></FCK:editor>
						</td>
					</tr>
					<tr>
						<th rowspan="2">
							中期阶段
						</th>
						<th>
							起止时间
						</th>
						<td>
							开始时间：
							<input readonly="readonly" type="text" name="FMstartDate"
								onClick="WdatePicker()" size="12" />
							结束时间：
							<input readonly="readonly" type="text" name="FMfinishDate"
								onClick="WdatePicker()" size="12" />
						</td>

					</tr>
					<tr>
						<th>
							工作内容
						</th>
						<td>
							<FCK:editor instanceName="FMcontent" basePath="/fckeditor"
								width="100%" height="200" toolbarSet="mytools"></FCK:editor>
						</td>
					</tr>
					<tr>
						<th rowspan="2">
							结题阶段
						</th>
						<th>
							起止时间
						</th>
						<td>
							开始时间:
							<input readonly="readonly" type="text" name="FEstartDate"
								onClick="WdatePicker()" size="12" />
							结束时间：
							<input readonly="readonly" type="text" name="FEfinishDate"
								onClick="WdatePicker()" size="12" />
						</td>

					</tr>
					<tr>
						<th>
							工作内容
						</th>
						<td>
							<FCK:editor instanceName="FEcontent" basePath="/fckeditor"
								width="100%" height="200" toolbarSet="mytools"></FCK:editor>
						</td>
					</tr>
					<tr>
						<td colspan="3">
							<input type="submit" value="保存">
							<input type="reset" value="重置">
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
