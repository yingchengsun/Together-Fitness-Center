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
			助学贷款名单
		</h3>
		<hr>
		
		<div align="center">
		<form action="getFStudentListByLoan.action">
			<table border="0" width="800" id="mytable">
				<tr>
					<th colspan="7" background="<%=request.getContextPath() %>/2_xsgl_system/Pictures/newmenubg.gif" height="30">
						<font color="#FFFFFF">助学贷款信息列表</font>
					</th>
				</tr>
				<tr>
				    <th>
						姓名
					</th>
					<th>
						学号
					</th>
					<th>
						班级
					</th>
					<th>
						类别
					</th>
					
					<th>
						金额（元）
					</th>
				</tr>
				<c:forEach items="${fstudentList }" var="fstudent">
				<tr>
					<td>
						${fstudent.tabStudents.FStudentName }
					</td>
					<td>${fstudent.tabStudents.FStudentNumber }
					</td>				
					<td> 
						${fstudent.tabStudents.tabClasses.FClassNumber } 
					</td>
					<td>
						${fstudent.FName }
					</td>
					<td>
						${fstudent.FAmount }
					</td>
				</tr>
				</c:forEach>
			</table>
			</form>
		</div>
		
	</body>
</html>
