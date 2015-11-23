<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" errorPage="/errorPage.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>项目审查</title>
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
			<img src="<%=request.getContextPath()%>/bksx/pictures/3dicon_001.png"
				width="50" height="50" align="middle" />
			课题审查
		</h3>
		<table align="center" width="98%">
			<tr>
				<th align="left">
					<a href="<%=request.getContextPath()%>/getMyResearchList.action"><img
							src="<%=request.getContextPath()%>/bksx/pictures/return.gif"
							align="top" border="0" />返回 </a>
				</th>
			</tr>
		</table>
		<hr>
		<div align="center">
			<table border="1" cellspacing="0" width="98%" id="mytable">
				<tr>
					<th colspan="5"
						background="<%=request.getContextPath()%>/bksx/pictures/bluebar.gif"
						height="30">
						毕业设计课题信息
					</th>
				</tr>
				<tr>
					<th>
						选题序号
					</th>
					<th>
						课题名称
					</th>
					<th>
						选题学生
					</th>
					<th>
						课题来源
					</th>
					<th>
						指导教师
					</th>
				</tr>
				<tr>
					<td>
						${substugui.FSubStuGuiId }
					</td>
					<td>
						${substugui.FSubjectName }
					</td>
					<td>
						${substugui.tabStudents.FStudentName }
					</td>
					<td>
						<c:if test="${substugui.FIsResearch=='Y' }">科研项目</c:if>
						<c:if test="${substugui.FIsSimulation=='Y' }">模拟项目</c:if>
						<c:if test="${substugui.FIsLab=='Y' }">实验室建设</c:if>
						<c:if test="${substugui.FIsOthers=='Y' }">其他类别</c:if>
					</td>
					<td>
						${substugui.FTeacherName }
					</td>
				</tr>
				<tr>
					<td colspan="5">
						<a
							href="<%=request.getContextPath()%>/showStudentDiary.action?id=${substugui.tabStudents.FStudentNumber }">查看历史工作记录
						</a>
					</td>
				</tr>
			</table>
			<br>
			<br>

		</div>

		<div align="center">
			<h4>
				课题进展
			</h4>
			<form
				action="<%=request.getContextPath()%>/showSummaryByStage.action?id=${substugui.FSubStuGuiId }"
				method="post">
				<table>
					<tr>
						<td>
							查看阶段工作报告：
						</td>
						<td>
							<select name="FSummaryStage">
								<option value="开题阶段" selected="selected">
									开题阶段
								</option>
								<option value="中期阶段">
									中期阶段
								</option>
								<option value="结题阶段">
									结题阶段
								</option>
							</select>
						</td>
						<td>
							<input type="submit" value="查询">
						</td>
					</tr>
				</table>
			</form>
			<hr>
			<div align="center">
				<c:choose>
					<c:when test="${not empty searchplan }">
						<table width="98%" border="1" cellspacing="0">
							<tr>
								<th colspan="3"
									background="<%=request.getContextPath()%>/bksx/pictures/bluebar.gif"
									height="30">
									课题研究计划概览
								</th>
							</tr>
							<tr>
								<td colspan="2" width="15%">
									课题名称
								</td>
								<td>
									${searchplan.bksxTabSubstugui.FSubjectName }
								</td>
							</tr>
							<tr>
								<td colspan="2">
									课题类型
								</td>
								<td>
									<c:if test="${searchplan.bksxTabSubstugui.FIsSoftware=='Y' }">软件项目</c:if>
									<c:if test="${searchplan.bksxTabSubstugui.FIsHardware=='Y' }">硬件项目</c:if>
									<c:if test="${searchplan.bksxTabSubstugui.FIsSoftHard=='Y' }">软硬结合</c:if>
									<c:if test="${searchplan.bksxTabSubstugui.FIsDocument=='Y' }">文献综述</c:if>
								</td>
							</tr>
							<tr>
								<td colspan="2">
									课题来源
								</td>
								<td>
									<c:if test="${searchplan.bksxTabSubstugui.FIsResearch=='Y' }">科研项目</c:if>
									<c:if test="${searchplan.bksxTabSubstugui.FIsSimulation=='Y' }">模拟项目</c:if>
									<c:if test="${searchplan.bksxTabSubstugui.FIsLab=='Y' }">实验室建设</c:if>
									<c:if test="${searchplan.bksxTabSubstugui.FIsOthers=='Y' }">其他类别</c:if>
								</td>
							</tr>
							<tr>
								<td colspan="2">
									选题学生
								</td>
								<td>
									${searchplan.bksxTabSubstugui.tabStudents.FStudentName }
								</td>
							</tr>
							<tr>
								<td colspan="2">
									指导教师
								</td>
								<td>
									${searchplan.bksxTabSubstugui.FTeacherName }
								</td>
							</tr>
							<tr>
								<td rowspan="2">
									开题阶段
								</td>
								<td>
									起止时间
								</td>
								<td>
									${searchplan.FFstartDate }至${searchplan.FFfinishDate }
								</td>

							</tr>
							<tr>
								<td>
									工作内容
								</td>
								<td>
									${searchplan.FFcontent }
								</td>
							</tr>
							<tr>
								<td rowspan="2">
									中期阶段
								</td>
								<td>
									起止时间
								</td>
								<td>
									${searchplan.FMstartDate }至${searchplan.FMfinishDate }
								</td>

							</tr>
							<tr>
								<td>
									工作内容
								</td>
								<td>
									${searchplan.FMcontent }
								</td>
							</tr>
							<tr>
								<td rowspan="2">
									结题阶段
								</td>
								<td>
									起止时间
								</td>
								<td>
									${searchplan.FEstartDate }至${searchplan.FEfinishDate }
								</td>

							</tr>
							<tr>
								<td>
									工作内容
								</td>
								<td>
									${searchplan.FEcontent }
								</td>
							</tr>
						</table>
					</c:when>
					<c:otherwise>
						<div align="center">
							<table border="1" cellspacing="0" width="98%">
								<tr>
									<td>
										<br>
										<br>
										<img
											src="<%=request.getContextPath()%>/bksx/pictures/MinIcons_001.png" />
										<br>
										该生还没有写过 《课题研究计划书》
										<br>
										<br>
										<br>
									</td>
								</tr>
							</table>
						</div>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
		<br>
		<br>
		<br>
	</body>
</html>
