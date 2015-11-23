<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" errorPage="/errorPage.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>编辑研究计划</title>

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
				src="<%=request.getContextPath()%>/bksx/pictures/moblie_icon_001.png"
				width="50" height="50" align="middle" />
			编辑计划
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
			<form action="updateResearchPlan.action" method="post">
				<table width="98%" border="1" cellspacing="0">
					<tr>
						<th colspan="3"
							background="<%=request.getContextPath()%>/bksx/pictures/bluebar.gif"
							height="30">
							编辑课题研究计划
						</th>
					</tr>
					<tr>
						<th colspan="2">
							课题名称
							<input type="hidden" name="id" value="${plan.id }">
						</th>
						<td>
							${plan.bksxTabSubstugui.FSubjectName }
						</td>
					</tr>
					<tr>
						<th colspan="2">
							课题类型
						</th>
						<td>
							<c:if test="${plan.bksxTabSubstugui.FIsSoftware=='Y' }">软件项目</c:if>
							<c:if test="${plan.bksxTabSubstugui.FIsHardware=='Y' }">硬件项目</c:if>
							<c:if test="${plan.bksxTabSubstugui.FIsSoftHard=='Y' }">软硬结合</c:if>
							<c:if test="${plan.bksxTabSubstugui.FIsDocument=='Y' }">文献综述</c:if>
						</td>
					</tr>
					<tr>
						<th colspan="2">
							课题来源
						</th>
						<td>
							<c:if test="${plan.bksxTabSubstugui.FIsResearch=='Y' }">科研项目</c:if>
							<c:if test="${plan.bksxTabSubstugui.FIsSimulation=='Y' }">模拟项目</c:if>
							<c:if test="${plan.bksxTabSubstugui.FIsLab=='Y' }">实验室建设</c:if>
							<c:if test="${plan.bksxTabSubstugui.FIsOthers=='Y' }">其他类别</c:if>
						</td>
					</tr>
					<tr>
						<th colspan="2">
							选题学生
						</th>
						<td>
							${plan.bksxTabSubstugui.tabStudents.FStudentName}
						</td>
					</tr>
					<tr>
						<th colspan="2">
							指导教师
						</th>
						<td>
							${plan.bksxTabSubstugui.FTeacherName }
						</td>
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
								onClick="WdatePicker()" value="${plan.FFstartDate }" size="12" />
							结束时间：
							<input readonly="readonly" type="text" name="FFfinishDate"
								onClick="WdatePicker()" value="${plan.FFfinishDate }" size="12" />
						</td>

					</tr>
					<tr>
						<th>
							工作内容
						</th>
						<td>
							<FCK:editor instanceName="FFcontent" value="${plan.FFcontent }"
								basePath="/fckeditor" width="100%" height="200"
								toolbarSet="mytools"></FCK:editor>
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
								onClick="WdatePicker()" value="${plan.FMstartDate }" size="12" />
							结束时间：
							<input readonly="readonly" type="text" name="FMfinishDate"
								onClick="WdatePicker()" value="${plan.FMfinishDate }" size="12" />
						</td>

					</tr>
					<tr>
						<th>
							工作内容
						</th>
						<td>
							&quot;
							<FCK:editor instanceName="FMcontent" value="${plan.FMcontent }"
								basePath="/fckeditor" width="100%" height="200"
								toolbarSet="mytools"></FCK:editor>
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
								onClick="WdatePicker()" value="${plan.FEstartDate }" size="12" />
							结束时间：
							<input readonly="readonly" type="text" name="FEfinishDate"
								onClick="WdatePicker()" value="${plan.FEfinishDate }" size="12" />
						</td>

					</tr>
					<tr>
						<th>
							工作内容
						</th>
						<td>
							<FCK:editor instanceName="FEcontent" value="${plan.FEcontent }"
								basePath="/fckeditor" width="100%" height="200"
								toolbarSet="mytools"></FCK:editor>

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
