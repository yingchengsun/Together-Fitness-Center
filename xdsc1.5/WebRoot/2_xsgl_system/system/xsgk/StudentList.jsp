<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css.css">
		<script language="javascript" src="<%=request.getContextPath() %>/2_xsgl_system/JS/TableColor.js"></script>
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/2_xsgl_system/mycss.css">
	</head>

	<body>
	
		<br>
		<h3 align="center"> 
			学生信息 
		</h3>
		<hr>
		
		<div align="center">
		<form action="showStudentList.action">
			<table border="0" width="700" id="mytable">
				<tr>
					<th colspan="4" background="<%=request.getContextPath() %>/2_xsgl_system/Pictures/newmenubg.gif" height="30">
						<font color="#FFFFFF">学生名单</font>
					</th>
				</tr>
				<tr>
				<th>
						学号
					</th>
					<th>
						姓名
					</th>
					<th>班级 
					</th>
					
					<th>
						学生详细信息
					</th>
				</tr>
				<c:forEach items="${studentsList }" var="student">
				<tr>
					<td>
						${student.FStudentNumber }
					</td>
					<td>
						${student.FStudentName }
					</td>
					<td>
						${student.tabClasses.FClassNumber }
					</td>
					
					<td>
						<a href="<%=request.getContextPath() %>/showStudent.action?id=${student.FStudentNumber }">浏览</a>
					</td>
				</tr>
			</c:forEach>
			</table>
			</form>
		</div>
		
	</body>
</html>
