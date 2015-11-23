<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" errorPage="/errorPage.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>题目详细信息</title>

		<link rel="stylesheet" type="text/css"
			href="<%=request.getContextPath()%>/bksx/css/css.css">
		<link rel="stylesheet" type="text/css"
			href="<%=request.getContextPath()%>/bksx/css/mycss.css">
	</head>

	<body>
		<br>
		<br>
		<h3 align="center">
			<img src="<%=request.getContextPath()%>/bksx/pictures/MBA.png"  width="50" height="50" align="middle"/>
			详细信息
		</h3>
		<table align="center" width="98%">
			<tr>
				<th align="left">
					<a href="<%=request.getContextPath()%>/getMySubjects.action"><img
							src="<%=request.getContextPath()%>/bksx/pictures/return.gif"
							align="top" border="0" />返回</a>
				</th>
			</tr>
		</table>
		<hr>
		<div align="center">
			<table border="1" cellspacing="0" width="98%">
				<tr>
					<th height="30" colspan="2" align="center"
						background="<%=request.getContextPath()%>/bksx/pictures/bluebar.gif">
						课题信息
					</th>
				</tr>
				<tr>
					<td width="25%">
						选题序号：
					</td>
					<td>
						${substugui.FSubStuGuiId }
					</td>
				</tr>
				<tr>
					<td>
						课题名称：
					</td>
					<td>
						${substugui.FSubjectName }
					</td>
				</tr>
				<tr>
					<td>
						课题性质：
					</td>
					<td>
						<c:if test="${substugui.FIsSoftware=='Y' }">软件项目</c:if>
						<c:if test="${substugui.FIsHardware=='Y' }">硬件项目</c:if>
						<c:if test="${substugui.FIsSoftHard=='Y' }">软硬结合</c:if>
						<c:if test="${substugui.FIsDocument=='Y' }">文献综述</c:if>
					</td>
				</tr>
				<tr>
					<td>
						课题来源：
					</td>
					<td>
						<c:if test="${substugui.FIsResearch=='Y' }">科研项目</c:if>
						<c:if test="${substugui.FIsSimulation=='Y' }">模拟项目</c:if>
						<c:if test="${substugui.FIsLab=='Y' }">实验室建设</c:if>
						<c:if test="${substugui.FIsOthers=='Y' }">其他类别</c:if>
					</td>
				</tr>
				<tr>
					<td>
						难度等级：
					</td>
					<td>
						${substugui.FLevel }
					</td>
				</tr>
				<tr>
					<td>
						导师姓名：
					</td>
					<td>
						${substugui.FTeacherName }
					</td>
				</tr>
				<tr>
					<td>
						导师职称：
					</td>
					<td>
						${substugui.FTeacherDegreen }
					</td>
				</tr>
				<tr>
					<td>
						工作地点：
					</td>
					<td>
						${substugui.FWorkPlace }
					</td>
				</tr>
				<tr>
					<td>
						选题学生：
					</td>
					<td>
						${substugui.FStudentName }
					</td>
				</tr>
				<tr>
					<td>
						学生学号：
					</td>
					<td>
						${substugui.tabStudents.FStudentNumber }
					</td>
				</tr>
				<tr height="200">
					<td>
					详细描述：
					</td>
					<td>
						<c:choose>
							<c:when test="${not empty substugui.FSubjectDescription }">
								${substugui.FSubjectDescription }
							</c:when>
							<c:otherwise>
								暂无详细信息
							</c:otherwise>
						</c:choose>
					</td>
				</tr>
			</table>
		</div>

		<br>
	</body>
</html>
