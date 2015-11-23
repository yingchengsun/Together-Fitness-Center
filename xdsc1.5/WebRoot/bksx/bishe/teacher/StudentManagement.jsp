<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" errorPage="/errorPage.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>指导学生</title>

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
				src="<%=request.getContextPath()%>/bksx/pictures/Scrap_Icons_001.png"
				width="50" height="50" align="middle" />
			指导学生
		</h3>
		<hr>
		<br>
		<div align="center">
			<c:choose>
				<c:when test="${not empty studentList }">
					<table border="1" cellspacing="0" width="98%" id="mytable">
						<tr>
							<th align="center" colspan="8"
								background="<%=request.getContextPath()%>/bksx/pictures/bluebar.gif"
								height="30">
								毕业设计选题学生信息
							</th>
						</tr>
						<tr>
							<th>
								学号
							</th>
							<th>
								姓名
							</th>
							<th>
								性别
							</th>
							<th>
								Email
							</th>
							<th>
								电话
							</th>
							<th>
								毕设题目
							</th>
							<th>
								指导教师
							</th>
							<th>
								发送邮件
							</th>
						</tr>
						<c:forEach items="${studentList }" var="substugui">
							<tr>
								<td>
									${substugui.tabStudents.FStudentNumber }&nbsp;
								</td>
								<td>
									${substugui.tabStudents.FStudentName }&nbsp;
								</td>
								<td>
									${substugui.tabStudents.FStudentSex }&nbsp;
								</td>
								<td>
									${substugui.tabStudents.FStudentEmail }&nbsp;
								</td>
								<td>
									${substugui.tabStudents.FStudentTel }&nbsp;
								</td>
								<td>
									${substugui.FSubjectName }&nbsp;
								</td>
								<td>
									${substugui.FTeacherName }&nbsp;
								</td>
								<td>
									<a href="StudentManagement.jsp"><img
											src="<%=request.getContextPath()%>/bksx/pictures/mail2.gif"
											border="0" align="top"> </a>
								</td>
							</tr>
						</c:forEach>
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
									目前没有您指导的学生信息！
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
	</body>
</html>
