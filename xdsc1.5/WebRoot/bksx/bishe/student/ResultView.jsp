<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" errorPage="/errorPage.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>我的成绩单</title>

		<link rel="stylesheet" type="text/css"
			href="<%=request.getContextPath()%>/bksx/css/css.css">
		<link rel="stylesheet" type="text/css"
			href="<%=request.getContextPath()%>/bksx/css/mycss.css">

	</head>

	<body>
		<br>
		<br>
		<h3 align="center">
			<img src="<%=request.getContextPath()%>/bksx/pictures/551.png"
				width="50" height="50" align="middle" />
			成绩查询
		</h3>
		<hr>
		<c:choose>
			<c:when test="${not empty achieve }">
				<div align="center">
					<table border="1" cellspacing="0" width="98%">
						<tr>
							<th align="center" colspan="7"
								background="<%=request.getContextPath()%>/bksx/pictures/bluebar.gif"
								height="30">
								软件学院毕业设计成绩单
							</th>
						</tr>
						<tr>
							<th>
								学生学号
							</th>
							<th>
								学生姓名
							</th>
							<th>
								前期成绩
							</th>
							<th>
								中期成绩
							</th>
							<th>
								后期成绩
							</th>
							<th>
								最终成绩
							</th>
						</tr>
						<tr>
							<td>
								${achieve.bksxTabSubstugui.tabStudents.FStudentNumber }
							</td>
							<td>
								${achieve.bksxTabSubstugui.FStudentName }
							</td>
							<td>
								${achieve.FFirstScore }&nbsp;
							</td>
							<td>
								${achieve.FSecondScore }&nbsp;
							</td>
							<td>
								${achieve.FThirdScore }&nbsp;
							</td>
							<td>
								${achieve.FFinalScore }&nbsp;
							</td>
						</tr>
					</table>
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
								抱歉，目前没有您的成绩信息!
								<br>
								<br>
								<br>
							</td>
						</tr>
					</table>
				</div>
			</c:otherwise>
		</c:choose>

	</body>
</html>
