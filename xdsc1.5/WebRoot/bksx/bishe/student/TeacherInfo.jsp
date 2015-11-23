<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" errorPage="/errorPage.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>指导教师信息</title>
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
				src="<%=request.getContextPath()%>/bksx/pictures/OFFICE_MEN_001.png"
				width="50" height="50" align="middle" />
			导师信息
		</h3>
		<hr>
		<c:choose>
			<c:when test="${not empty teacher }">
				<table align="center" width="98%" border="1" cellspacing="0"
					id="mytable">
					<tr>
						<th colspan="7"
							background="<%=request.getContextPath()%>/bksx/pictures/bluebar.gif"
							height="30">
							指导教师信息
						</th>
					</tr>
					<tr>
						<th>
							工号
						</th>
						<th>
							姓名
						</th>
						<th>
							性别
						</th>
						<th>
							电话
						</th>
						<th>
							邮件
						</th>
						<th>
							学院
						</th>
						<th>
							办公地点
						</th>
					</tr>
					<tr>
						<td>
							${teacher.FTeacherNumber }&nbsp;
						</td>
						<td>
							${teacher.FTeacherName }&nbsp;
						</td>
						<td>
							${teacher.FTeacherSex }&nbsp;
						</td>
						<td>
							${teacher.FTeacherTel }&nbsp;
						</td>
						<td>
							${teacher.FTeacherEmail }&nbsp;
						</td>
						<td>
							${teacher.FTeacherXueYuan }&nbsp;
						</td>
						<td>
							${teacher.FTeacherWorkPlace }&nbsp;
						</td>
					</tr>
					<tr>
						<td colspan="7">
							<a href="TeacherInfo.jsp"><img
									src="<%=request.getContextPath()%>/bksx/pictures/mail2.gif"
									border="0" align="middle"/>发送电子邮件</a>
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
								抱歉，目前没有您的导师信息!
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
	</body>
</html>
