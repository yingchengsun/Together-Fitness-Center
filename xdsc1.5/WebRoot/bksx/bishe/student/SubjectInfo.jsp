<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" errorPage="/errorPage.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>个人选题信息</title>
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
			<img src="<%=request.getContextPath()%>/bksx/pictures/MBA.png"
				width="50" height="50" align="middle" />
			选题信息
		</h3>
		<hr>
		<div>
			<c:choose>
				<c:when test="${not empty substugui }">
					<br>
					<table border="1" cellspacing="0" align="center" width="98%"
						id="mytable">
						<tr>
							<th colspan="4"
								background="<%=request.getContextPath()%>/bksx/pictures/bluebar.gif"
								height="30">
								毕设题目信息
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
								课题性质
							</th>
							<th>
								课题来源
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
								<c:if test="${substugui.FIsSoftware=='Y' }">软件项目</c:if>
								<c:if test="${substugui.FIsHardware=='Y' }">硬件项目</c:if>
								<c:if test="${substugui.FIsSoftHard=='Y' }">软硬结合</c:if>
								<c:if test="${substugui.FIsDocument=='Y' }">文献综述</c:if>
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
								难度等级
							</td>
							<td>
								${substugui.FLevel }级
							</td>
							<td>
								工作地点
							</td>
							<td>
								${substugui.FWorkPlace }
							</td>
						</tr>
						<tr>
							<td>
								指导教师
							</td>
							<td colspan="3">
								${substugui.FTeacherName }&nbsp;${substugui.FTeacherDegreen }
							</td>
						</tr>
						<tr>
							<td>
								帮助链接
							</td>
							<td colspan="5">
								<a href="http://www.baidu.com" target="_blank">百度</a>&nbsp;&nbsp;&nbsp;
								&nbsp;&nbsp;&nbsp;
								<a href="http://www.google.com" target="_blank">谷歌</a>
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
									抱歉，目前没有您的选题信息!
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
