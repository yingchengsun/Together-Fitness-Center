<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css.css">
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/2_xsgl_system/mycss.css">
		<script language="javascript" src="<%=request.getContextPath() %>/2_xsgl_system/JS/TableColor.js"></script>
	</head>

	<body>
	
		<br>
		<h3 align="center">  
			学生党建信息  
		</h3>
		
		<hr>
		<br>
		<br>
		<div align="center">
		<form action="getGradeStudentByPartyList.action?regdate=2006">
			<table border="0" width="700" id="mytable">
				<tr>
					<th colspan="7" background="<%=request.getContextPath() %>/2_xsgl_system/Pictures/newmenubg.gif" height="30">
						<font color="#FFFFFF">学生党建信息列表</font>
					</th>
				</tr>
				<tr>
				<th>
						年份
					</th>
					<th>
						班级
					</th>
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
						类别
					</th>
				</tr>
				<c:forEach items="${studentsList }" var="student">
				<tr>
				<td>
						${student.FYear }
					</td>
					<td>
						${student.tabStudents.tabClasses.FClassNumber }
					</td>
					<td>
						${student.tabStudents.FStudentNumber }
					</td>
					<td>
						${student.tabStudents.FStudentName }
					</td>
					<td>
						${student.tabStudents.FStudentSex }
					</td>
					<td>
						${student.FName }
					</td>
				</tr>
				</c:forEach>
			</table>
			<table width="40%">
				<tr>
					<td>
						<div align="center">
							<a href="parStuSPrevious.action">上一页</a>
						</div>
					</td>
					<td>
						<div align="center">
							<a href="parStuSNext.action">下一页</a>
						</div>
					</td>
					<td>
						共${partyStuAll.pageCount }页，当前第${partyStuAll.page+1 }页
					</td>
				</tr>
			</table>
			</form>
			</div>
		<br>
	</body>
</html>
