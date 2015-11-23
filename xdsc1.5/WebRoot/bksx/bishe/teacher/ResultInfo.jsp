<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" errorPage="/errorPage.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>学生成绩单</title>
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
			<img src="<%=request.getContextPath()%>/bksx/pictures/551.png"
				width="50" height="50" align="middle" />
			成绩查询
		</h3>
		<hr>
		<br>
		<div align="center">
			<c:choose>
				<c:when test="${not empty achieveList }">
					<table border="1" cellspacing="0" width="98%" id="mytable">
						<tr>
							<th align="center" colspan="8"
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
								初期成绩
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
							<th>
								操 作
							</th>
						</tr>
						<c:forEach items="${achieveList }" var="achieve">
							<tr>
								<td>
									${achieve.bksxTabSubstugui.tabStudents.FStudentNumber }&nbsp;
								</td>
								<td>
									${achieve.bksxTabSubstugui.tabStudents.FStudentName }&nbsp;
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
								<td>
									<a
										href="<%=request.getContextPath()%>/preUpdateStudentAchieve.action?id=${achieve.FSubStuGuiId }"><img
											src="<%=request.getContextPath()%>/bksx/pictures/edit.gif"
											border="0" align="middle" /> </a>
								</td>
							</tr>
						</c:forEach>
					</table>
					<table width="40%">
						<tr>
							<td>
								<div align="center">
									<a
										href="<%=request.getContextPath()%>/getMyStudentAchievement.action?p=1">首页</a>
								</div>
							</td>
							<td>
								<div align="center">
									<a
										href="<%=request.getContextPath()%>/getMyStudentAchievement.action?p=${p-1}">上一页</a>
								</div>
							</td>
							<td>
								<div align="center">
									<a
										href="<%=request.getContextPath()%>/getMyStudentAchievement.action?p=${p+1}">下一页</a>
								</div>
							</td>
							<td>
								<div align="center">
									<a
										href="<%=request.getContextPath()%>/getMyStudentAchievement.action?p=${lastPage}">末页</a>
								</div>
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
									目前没有您指导的学生成绩信息！
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
