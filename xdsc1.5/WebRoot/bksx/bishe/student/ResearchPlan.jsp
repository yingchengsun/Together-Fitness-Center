<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" errorPage="/errorPage.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>研究型课题计划</title>

		<link rel="stylesheet" type="text/css"
			href="<%=request.getContextPath()%>/bksx/css/css.css">
		<link rel="stylesheet" type="text/css"
			href="<%=request.getContextPath()%>/bksx/css/mycss.css">

	</head>

	<body>
		<br>
		<br>
		<h3 align="center">
			<img
				src="<%=request.getContextPath()%>/bksx/pictures/moblie_icon_001.png"
				width="50" height="50" align="middle" />
			研究计划
		</h3>

		<hr>

		<br>
		<c:choose>
			<c:when test="${subject=='reaserch' }">
				<div align="center">
					<c:if test="${not empty plan }">
						<table width="98%">
							<tr>
								<th align="right">
									<a
										href="<%=request.getContextPath()%>/preUpdateResearchPlan.action"><img
											src="<%=request.getContextPath()%>/bksx/pictures/edit.gif"
											align="top" border="0" />编辑计划书</a>
								</th>
							</tr>
						</table>
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
									${plan.bksxTabSubstugui.FSubjectName }
								</td>
							</tr>
							<tr>
								<td colspan="2">
									课题类型
								</td>
								<td>
									<c:if test="${plan.bksxTabSubstugui.FIsSoftware=='Y' }">软件项目</c:if>
									<c:if test="${plan.bksxTabSubstugui.FIsHardware=='Y' }">硬件项目</c:if>
									<c:if test="${plan.bksxTabSubstugui.FIsSoftHard=='Y' }">软硬结合</c:if>
									<c:if test="${plan.bksxTabSubstugui.FIsDocument=='Y' }">文献综述</c:if>
								</td>
							</tr>
							<tr>
								<td colspan="2">
									课题来源
								</td>
								<td>
									<c:if test="${plan.bksxTabSubstugui.FIsResearch=='Y' }">科研项目</c:if>
									<c:if test="${plan.bksxTabSubstugui.FIsSimulation=='Y' }">模拟项目</c:if>
									<c:if test="${plan.bksxTabSubstugui.FIsLab=='Y' }">实验室建设</c:if>
									<c:if test="${plan.bksxTabSubstugui.FIsOthers=='Y' }">其他类别</c:if>
								</td>
							</tr>
							<tr>
								<td colspan="2">
									选题学生
								</td>
								<td>
									${plan.bksxTabSubstugui.tabStudents.FStudentName }
								</td>
							</tr>
							<tr>
								<td colspan="2">
									指导教师
								</td>
								<td>
									${plan.bksxTabSubstugui.FTeacherName }
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
									<fmt:formatDate value="${plan.FFstartDate }" type="date"
										dateStyle="medium" />
									至
									<fmt:formatDate value="${plan.FFfinishDate }" type="date"
										dateStyle="medium" />
								</td>

							</tr>
							<tr>
								<td>
									工作内容
								</td>
								<td>
									${plan.FFcontent }
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
									<fmt:formatDate value="${plan.FMstartDate }" type="date"
										dateStyle="medium" />
									至
									<fmt:formatDate value="${plan.FMfinishDate }" type="date"
										dateStyle="medium" />
								</td>

							</tr>
							<tr>
								<td>
									工作内容
								</td>
								<td>
									${plan.FMcontent }
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
									<fmt:formatDate value="${plan.FEstartDate }" type="date"
										dateStyle="medium" />
									至
									<fmt:formatDate value="${plan.FEfinishDate }" type="date"
										dateStyle="medium" />
								</td>

							</tr>
							<tr>
								<td>
									工作内容
								</td>
								<td>
									${plan.FEcontent }
								</td>
							</tr>
						</table>
					</c:if>
					<c:if test="${empty plan }">
						<div align="center">
							<table border="1" cellspacing="0" width="98%">
								<tr>
									<td>
										<br>
										<br>
										<img
											src="<%=request.getContextPath()%>/bksx/pictures/MinIcons_001.png" />
										<br>
										你还没有写过《项目计划书》
										<br>
										<br>
										<a
											href="<%=request.getContextPath()%>/bksx/bishe/student/ResearchPlanNew.jsp"><img
												src="<%=request.getContextPath()%>/bksx/pictures/edit.gif"
												align="top" border="0" /><font color="green">点击此处创建</font>
										</a>
										<br>
										<br>
									</td>
								</tr>
							</table>
						</div>
						<br>
						<br>
					</c:if>
				</div>
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
								你还未选题或已经加入某项目团队
								<br>
								请【在线选择课题】或者使用【项目课题】进行毕业设计管理工作
								<br>
								<br>
								<br>
								<br>
							</td>
						</tr>
					</table>
				</div>
			</c:otherwise>
		</c:choose>

		<br>
		<br>
		<br>
	</body>
</html>
