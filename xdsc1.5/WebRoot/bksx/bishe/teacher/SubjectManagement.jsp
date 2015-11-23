<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" errorPage="/errorPage.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>题目查询</title>
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
			指导题目
		</h3>
		<hr>
		<br>
		<div align="center">
			<c:choose>
				<c:when test="${not empty subjectList }">
					<table border="1" cellspacing="0" width="98%" id="mytable">
						<tr>
							<th height="30" colspan="8"
								background="<%=request.getContextPath()%>/bksx/pictures/bluebar.gif">
								题目信息
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
							<th>
								难度等级
							</th>
							<th>
								选题学生
							</th>
							<th>
								工作地点
							</th>
							<th>
								编辑
							</th>
						</tr>
						<c:forEach items="${subjectList }" var="substugui">
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
								<td>
									${substugui.FLevel }
								</td>
								<td>
									${substugui.FStudentName }
								</td>
								<td>
									${substugui.FWorkPlace }
								</td>
								<td>
									<a
										href="<%=request.getContextPath()%>/showSubjectDetail.action?id=${substugui.FSubStuGuiId }">
										<img
											src="<%=request.getContextPath()%>/bksx/pictures/lookdetail.gif"
											border="0" align="top" /> </a>
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
									目前没有您指导的题目信息！
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
		<br>
		<br>
	</body>
</html>
