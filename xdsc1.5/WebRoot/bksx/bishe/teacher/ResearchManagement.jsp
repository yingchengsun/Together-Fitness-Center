<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" errorPage="/errorPage.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>选题查询</title>
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
			科研课题
		</h3>
		<hr>
		<br>
		<c:if test="${not empty researchList }">
			<div align="center">
				<table border="1" cellspacing="0" id="mytable" width="98%">
					<tr>
						<th colspan="10"
							background="<%=request.getContextPath()%>/bksx/pictures/bluebar.gif"
							height="30">
							毕业设计选题信息
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
							详细进展
						</th>
					</tr>
					<c:forEach items="${researchList }" var="research">
						<tr>
							<td>
								${research.FSubStuGuiId }
							</td>
							<td>
								${research.FSubjectName }
							</td>
							<td>
								<c:if test="${research.FIsSoftware=='Y' }">软件项目</c:if>
								<c:if test="${research.FIsHardware=='Y' }">硬件项目</c:if>
								<c:if test="${research.FIsSoftHard=='Y' }">软硬结合</c:if>
								<c:if test="${research.FIsDocument=='Y' }">文献综述</c:if>
							</td>
							<td>
								<c:if test="${research.FIsResearch=='Y' }">科研项目</c:if>
								<c:if test="${research.FIsSimulation=='Y' }">模拟项目</c:if>
								<c:if test="${research.FIsLab=='Y' }">实验室建设</c:if>
								<c:if test="${research.FIsOthers=='Y' }">其他类别</c:if>
							</td>
							<td>
								${research.FLevel }
							</td>
							<td>
								${research.FStudentName }
							</td>
							<td>
								${research.FWorkPlace }
							</td>
							<td>
								<a
									href="<%=request.getContextPath()%>/researchView.action?id=${research.FSubStuGuiId }"><img
									src="<%=request.getContextPath()%>/bksx/pictures/lookdetail.gif"
									border="0" align="top"/> </a>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</c:if>
		<c:if test="${empty researchList }">
			<div align="center">
				<table border="1" cellspacing="0" width="98%">
					<tr>
						<td>
							<br>
							<br>
							<img
								src="<%=request.getContextPath()%>/bksx/pictures/MinIcons_001.png" />
							<br>
							目前没有此类课题信息！
							<br>
							<br>
							<br>
						</td>
					</tr>
				</table>
			</div>
		</c:if>
		<br>
		<br>

	</body>
</html>
