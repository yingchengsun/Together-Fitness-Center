<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 <head>
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css.css">
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/2_xsgl_system/mycss.css">
		<script language="javascript" src="<%=request.getContextPath() %>/2_xsgl_system/JS/TableColor.js"></script>
	</head>
  
  <body>
		<br>
		<br>
		<h3 align="center">详细信息</h3>
		 
		<hr>
		<div align="center">
		 <form action="<%=request.getContextPath()%>/updateFundStudent.action"
			method="post">
				<table border="1" width="700">
					<tr>
						<th height="30" colspan="2" align="center" background="2_xsgl_system/Pictures/newmenubg.gif">
							<font color="#FFFFFF">详细信息</font>
						</th>
					</tr>
					
					<tr>
						<td>
							学号：
							<input type="hidden" name="fid" value=${fstudent.FId }>
						</td>
						<td>
							<input type="text" name="FStudentNumber"
							value="${fstudent.tabStudents.FStudentNumber }">
						</td>
					</tr>
					<tr>
						<td>
							类别：
						</td>
						<td>
							<input type="text" name="FName"
							value="${fstudent.FName }">
						</td>
					</tr>
					<tr>
						<td>
							金额（元）：
						</td>
						<td>
							<input type="text" name="FAmount"
							value="${fstudent.FAmount }">
						</td>
					</tr>
					<tr>
						<td>
							年份：
						</td>
						<td>
							<input type="text" name="FYear"
							value="${fstudent.FYear }">
						</td>
					</tr>
				    <tr>
					<td>
						&nbsp;
					</td>
					<td>
						<input type="submit" value="更新">&nbsp;&nbsp;<input type="reset" value="重置">
					</td>
				</tr>
				</table>
				</form>
		   </div>
		<br>
  </body>
</html>
