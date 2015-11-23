<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" errorPage="/errorPage.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>校外毕设学生名单</title>

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
			校外毕设指派导师
		</h3>
		<hr>


		<div align="center">
			<table border="0" width="98%" id="mytable">
				<tr>
					<th align="center" colspan="8"
						background="<%=request.getContextPath()%>/bksx/pictures/bluebar.gif"
						height="30">
						软件学院校外毕业设计学生名单
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
						题目来源
					</th>
					<th>
						指派导师
					</th>
				</tr>
				<c:forEach items="${subList }" var="substugui">
					<tr>
						<td>
							${substugui.tabStudents.FStudentNumber }
						</td>
						<td>
							${substugui.tabStudents.FStudentName }
						</td>
						<td>
							${substugui.tabStudents.FStudentSex }
						</td>
						<td>
							${substugui.tabStudents.FStudentEmail }
						</td>
						<td>
							${substugui.tabStudents.FStudentTel }
						</td>
						<td>
							${substugui.FSubjectName }
						</td>
						<td>
							<c:if test="${substugui.FIsResearch=='Y' }">科研项目</c:if>
							<c:if test="${substugui.FIsSimulation=='Y' }">模拟项目</c:if>
							<c:if test="${substugui.FIsLab=='Y' }">实验室建设</c:if>
							<c:if test="${substugui.FIsOthers=='Y' }">其他类别</c:if>
						</td>
						<td>
							<a
								href="<%=request.getContextPath()%>/guiderArrangement.action?id=${substugui.FSubStuGuiId }"><img
									src="<%=request.getContextPath()%>/bksx/pictures/teacher.gif"
									align="middle" border="0" /> </a>
						</td>
					</tr>
				</c:forEach>
			</table>
			<table width="40%">
				<tr>
					<td>
						<div align="center">
							<a
								href="<%=request.getContextPath()%>/getSubstuguiByCategory.action?p=1">首页</a>
						</div>
					</td>
					<td>
						<div align="center">
							<a
								href="<%=request.getContextPath()%>/getSubstuguiByCategory.action?p=${p-1}">上一页</a>
						</div>
					</td>
					<td>
						<div align="center">
							<a
								href="<%=request.getContextPath()%>/getSubstuguiByCategory.action?p=${p+1}">下一页</a>
						</div>
					</td>
					<td>
						<div align="center">
							<a
								href="<%=request.getContextPath()%>/getSubstuguiByCategory.action?p=${lastPage}">末页</a>
						</div>
					</td>
				</tr>
			</table>
		</div>
		<br>
		<br>

	</body>
</html>
