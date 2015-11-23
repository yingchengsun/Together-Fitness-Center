<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" errorPage="/errorPage.jsp"%>
<%@taglib uri="http://java.fckeditor.net" prefix="FCK"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>选题信息</title>


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
				src="<%=request.getContextPath()%>/bksx/pictures/submittutorial_001.png"
				width="50" height="50" align="middle" />
			选题导入
		</h3>

		<hr>

		<div align="center">
			<form action="<%=request.getContextPath()%>/substuguiImport.action"
				enctype="multipart/form-data" method="post"
				onsubmit="return validator(this)">
				<table border="1" width="98%" cellspacing="0">
					<tr>

						<th height="30" colspan="2" align="center"
							background="<%=request.getContextPath()%>/bksx/pictures/bluebar.gif">
							<img src="<%=request.getContextPath()%>/bksx/pictures/excel.bmp"
								border="0" align="top" />
							导入Excel文件
						</th>

					</tr>
					<tr>
						<td>
							选择文件:
						</td>
						<td>
							<input type="file" name="file" size="40" valid="required"
								errmsg="请首先选择文件!">
							<input type="submit" value=" 导入 " />
						</td>
					</tr>
					<tr>
						<td>
							&nbsp;
						</td>
						<td>
							<a
								href="<%=request.getContextPath()%>/exportEmptySubstugui.action"><img
									src="<%=request.getContextPath()%>/bksx/pictures/download.gif"
									border="0" align="bottom">点此下载模板</a>
						</td>
					</tr>
				</table>
			</form>
		</div>
		<hr>
		<br>
		<br>
		<div align="center">
			<form action="addSubstugui.action" method="post"
				onsubmit="return validator(this)">
				<table border="1" width="98%" cellspacing="0">
					<tr>
						<th height="30" colspan="2" align="center"
							background="<%=request.getContextPath()%>/bksx/pictures/bluebar.gif">
							<img src="<%=request.getContextPath()%>/bksx/pictures/hand.gif"
								border="0" align="top" />
							手工添加
						</th>
					</tr>
					<tr>
						<td>
							课题名称：
						</td>
						<td>
							<input type="text" name="FSubjectName" size="60" id="Limit"
								valid="required|limit" min="5" max="25"
								errmsg="请填写课题名称！|课题名称长度必须在5-25之间" />
						</td>
					</tr>
					<tr>
						<td>
							课题类型：
						</td>
						<td>
							<input type="radio" name="type" value='0' checked="checked">
							软件
							<input type="radio" name="type" value='1'>
							硬件
							<input type="radio" name="type" value='2'>
							软硬结合
							<input type="radio" name="type" value='3'>
							文献综述
						</td>
					</tr>
					<tr>
						<td>
							课题来源：
						</td>
						<td>
							<input type="radio" name="category" value='0' checked="checked">
							科研
							<input type="radio" name="category" value='1'>
							模拟
							<input type="radio" name="category" value='2'>
							实验室建设
							<input type="radio" name="category" value='3'>
							其他
						</td>
					</tr>
					<tr>
						<td>
							难易等级：
						</td>
						<td>
							<input type="radio" name="FLevel" value="A" checked="checked">
							A-难
							<input type="radio" name="FLevel" value="B">
							B-中
							<input type="radio" name="FLevel" value="C">
							C-易
						</td>
					</tr>
					<tr>
						<td>
							指导教师：
						</td>
						<td>
							<input type="text" name="FTeacherName" size="60" valid="required"
								errmsg="请填写导师姓名！">
							${teacherError }
							<!-- 
							<select name="FTeacherNumber">
								<c:forEach items="${teacherList }" var="teacher">
									<option value="${teacher.FTeacherNumber }">
										${teacher.FTeacherName }--${teacher.FTeacherZhiCheng }
									</option>
								</c:forEach>
								<option disabled="disabled">
									---------------------------请选择指导教师--------------------------
								</option>
							</select> -->
						</td>
					</tr>
					<tr>
						<td>
							工作地点：
						</td>
						<td>
							<input type="text" name="FWorkPlace" size="60" id="Limit"
								valid="required|limit" min="2" max="5"
								errmsg="请填写工作地点！|工作地点长度必须在2-5之间">
						</td>
					</tr>
					<tr>
						<td>
							学生学号：
						</td>
						<td>
							<input type="text" name="FStudentNumber" size="60" id="Limit"
								valid="required|limit" min="8" max="8"
								errmsg="请填写学生学号！|学生学号长度必须是8位数字！">
							${studentError }
							<!--  
							<select name="FStudentNumber">
								<c:forEach items="${studentList }" var="student">
									<option value="${student.FStudentNumber }">
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
						<td colspan="2">
							<FCK:editor instanceName="FSubjectDescription" value="此处添加课题描述信息"
								basePath="/fckeditor" width="100%" height="200"
								toolbarSet="mytools"></FCK:editor>
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="submit" value="添加" />
							<input type="reset" value="重置" />
						</td>
					</tr>
				</table>
			</form>
		</div>
		<br>
	</body>
</html>
