<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" errorPage="/errorPage.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>更新选题信息</title>
		<link rel="stylesheet" type="text/css"
			href="<%=request.getContextPath()%>/bksx/css/css.css">
		<link rel="stylesheet" type="text/css"
			href="<%=request.getContextPath()%>/bksx/css/mycss.css">
		<script language="javascript"
			src="<%=request.getContextPath()%>/bksx/js/FormValid.js"></script>

	</head>

	<body>
		<br>
		<br>
		<h3 align="center">
			<img
				src="<%=request.getContextPath()%>/bksx/pictures/Vista_Glass_Folders_001.png"
				width="50" height="50" align="middle" />
			选题编辑
		</h3>
		<table align="center" width="98%">
			<tr>
				<th align="left">
					<a href="<%=request.getContextPath()%>/showSubstugui.action"><img
							src="<%=request.getContextPath()%>/bksx/pictures/return.gif"
							align="top" border="0" />返回</a>
				</th>
			</tr>
		</table>
		<hr>
		<div align="center">
			<form action="updateSubstugui.action" method="post"
				onsubmit="return validator(this)">
				<table border="1" width="98%" cellspacing="0">
					<tr>
						<th height="30" colspan="2" align="center"
							background="<%=request.getContextPath()%>/bksx/pictures/bluebar.gif">
							更新信息
						</th>
					</tr>
					<tr>
						<td>
							课题名称：
							<input type="hidden" name="FSubStuGuiId"
								value="${substugui.FSubStuGuiId }" id="Limit"
								valid="required|limit" min="1" max="25"
								errmsg="请填写课题名称！|课题名称长度必须在5-25之间">
						</td>
						<td>
							<input type="text" name="FSubjectName"
								value="${substugui.FSubjectName } " size="60" />
						</td>
					</tr>
					<tr>
						<td>
							课题类型：
						</td>
						<td>
							<input type="radio" name="type" value='0'
								<c:if test="${substugui.FIsSoftware=='Y' }"> checked="checked" </c:if>>
							软件
							<input type="radio" name="type" value='1'
								<c:if test="${substugui.FIsHardware=='Y' }"> checked="checked" </c:if>>
							硬件
							<input type="radio" name="type" value='2'
								<c:if test="${substugui.FIsSoftHard=='Y' }"> checked="checked" </c:if>>
							软硬结合
							<input type="radio" name="type" value='3'
								<c:if test="${substugui.FIsDocument=='Y' }"> checked="checked" </c:if>>
							文献综述
						</td>
					</tr>
					<tr>
						<td>
							课题来源：
						</td>
						<td>
							<input type="radio" name="category" value='0'
								<c:if test="${substugui.FIsResearch=='Y' }"> checked="checked" </c:if>>
							科研
							<input type="radio" name="category" value='1'
								<c:if test="${substugui.FIsSimulation=='Y' }"> checked="checked" </c:if>>
							模拟
							<input type="radio" name="category" value='2'
								<c:if test="${substugui.FIsLab=='Y' }"> checked="checked" </c:if>>
							实验室建设
							<input type="radio" name="category" value='3'
								<c:if test="${substugui.FIsOthers=='Y' }"> checked="checked" </c:if>>
							其他
						</td>
					</tr>
					<tr>
						<td>
							难易等级：
						</td>
						<td>
							<input type="radio" name="FLevel" value="A"
								<c:if test="${substugui.FLevel=='A' }"> checked="checked" </c:if>>
							A-难
							<input type="radio" name="FLevel" value="B"
								<c:if test="${substugui.FLevel=='B' }"> checked="checked" </c:if>>
							B-中
							<input type="radio" name="FLevel" value="C"
								<c:if test="${substugui.FLevel=='C' }"> checked="checked" </c:if>>
							C-易
						</td>
					</tr>
					<tr>
						<td>
							指导教师：
						</td>
						<td>
							<input type="text" name="FTeacherName" size="60"
								value="${substugui.FTeacherName }" valid="required|limit"
								errmsg="请填写导师姓名！">${teacherError }
							<!--  
							<select name="FTeacherNumber">
								<c:forEach items="${teacherList }" var="teacher">
									<option value="${teacher.FTeacherNumber }"
										<c:if test="${substugui.FTeacherName==teacher.FTeacherName }">selected="selected"</c:if>>
										${teacher.FTeacherName }--${teacher.FTeacherZhiCheng }
									</option>
								</c:forEach>
								<option disabled="disabled">
									---------------------------请选择指导教师--------------------------
								</option>
							</select>-->
						</td>
					</tr>
					<tr>
						<td>
							工作地点：
						</td>
						<td>
							<input type="text" name="FWorkPlace" size="60"
								value="${substugui.FWorkPlace }" id="Limit"
								valid="required|limit" min="2" max="5"
								errmsg="请填写工作地点！|工作地点长度必须在2-5之间">
						</td>
					</tr>
					<tr>
						<td>
							选题学生：
						</td>
						<td>
							${substugui.tabStudents.FStudentNumber}--${substugui.tabStudents.FStudentName}
							<!--  为防止内存溢出，注释此处
							<select name="FStudentNumber">
								<c:forEach items="${studentList }" var="student">
									<option value="${student.FStudentNumber }"
										<c:if test="${substugui.tabStudents.FStudentNumber==student.FStudentNumber }">selected="selected"</c:if>>
										${student.FStudentNumber }--${student.FStudentName }
									</option>
								</c:forEach>
								<option disabled="disabled">
									---------------------------请选择选题学生--------------------------
								</option>
							</select>
							-->
						</td>
					</tr>
					<tr>
						<td>
							&nbsp;
						</td>
						<td>
							<input type="submit" value="更新" />
							<input type="reset" value="重置" />
						</td>
					</tr>
				</table>
			</form>
		</div>
		<br>
		<br>
	</body>
</html>
