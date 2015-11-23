
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
		<br>
		<h3 align="center">
			学生信息
		</h3>
		<hr>
		<br>
		<div align="center">
			<form action="showUndergraduate.action?id=13061012">
			<table border="1" width="700" id="mytable">
				<tr>
					<th align="center" colspan="4" background="<%=request.getContextPath() %>/2_xsgl_system/Pictures/newmenubg.gif" height="30">
						<font color="#FFFFFF">在校信息</font>
					</th>
				</tr>
				<tr >
					<th>姓名 
					</th>
					<th>学号 
					</th>
					<th>班级 
					</th>
					<th>专业方向 
					</th>
					</tr>
					<tr>
					<td>
						${undergraduate.tabStudents.FStudentName }
					</td>
					<td>${undergraduate.FStudentNumber } 
					</td>
					<td>${undergraduate.tabStudents.tabClasses.FClassNumber }
					</td>
					<td>${undergraduate.tabStudents.FStudentMajor }  
					</td>
					<tr>
					<th>入校时间 
					</th>
					<th>班主任  
					</th>
					<th>辅导员  
					</th>
					<th>宿舍地址 
					</th>
				</tr>
				   <tr>
					<td>${undergraduate.tabStudents.FStudentRegData }
					</td>
					<td> 
						赵昭</td>
					
					<td>钱倩
					</td>
					<td>95#楼
					</td>
				</tr>
				<tr>
					<th>联系电话 
					</th>
					<th>E-mail地址 
					</th>
					<th>奖励  
					</th>
					<th>处分  
					</th>
				</tr>
				   <tr>
					<td>********  
					</td>
					<td>********</td>
					
					<td>无 
					</td>
					<td>无
					</td>
				</tr>
			</table>
			</form>
		</div>
		
	</body>
</html>
