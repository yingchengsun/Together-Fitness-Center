
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>校友信息</title>

		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css.css">
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/2_xsgl_system/mycss.css">
		<script language="javascript" src="<%=request.getContextPath() %>/2_xsgl_system/JS/TableColor.js"></script>
	</head>

	<body>
		<br>
		<br>
		<h3 align="center">
			校友信息
		</h3>
		<hr>
		<div align="center">
		<form action="showXStudentDetails.action?xid=${xstudent.FXiaoYouId }"> 
			<table border="0" width="700" id="mytable">
				<tr>
					<th align="center" colspan="6" background="<%=request.getContextPath() %>/2_xsgl_system/Pictures/newmenubg.gif" height="30">
						<font color="#FFFFFF">个人信息</font>
					</th>
				</tr>
				<tr >
					<th>姓名 
					</th>
					<th>性别 
					</th>
					<th>工作地区
					</th>
					<th>工作单位 
					</th>
					<th>工作职位 
					</th>
					<th>工作历史
					</th>
				</tr>
				<tr>
					<td>${xstudent.FXiaoYouName }
					</td>
					<td>${xstudent.FXiaoYouSex } 
					</td>
					<td>${xstudent.FRegion } 
					</td>
					<td>${xstudent.FWorkPlace } 
					</td>
					<td> 
						${xstudent.FPosition }
						</td>
					
					<td>${xstudent.FHistory }
					</td>
				</tr>
			</table>
		</form>
		</div>
	</body>
</html>
