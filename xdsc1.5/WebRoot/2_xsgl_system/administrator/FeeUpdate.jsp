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
		<table align="center" width="700">
			<tr>
				<th align="left"><a href="<%=request.getContextPath()%>/getMStudentList.action"><img src="2_xsgl_system/Pictures/return.gif" align="top" border="0"/>返回</a></th>
			</tr>
		</table> 
		<hr>
		<div align="center">
		 <form action="<%=request.getContextPath()%>/updateFee.action"
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
						</td>
						<td>
							<input type="text" name="FStudentNumber"
							value="${jstudent.FStudentNumber }">
						</td>
					</tr>
					
					<tr>
						<td>
							收费区间：
						</td>
						<td>
							<input type="text" name="FYear"
							value="${jstudent.FYear }">
						</td>
					</tr>
					<tr>
						<td>
							学费（元）：
						</td>
						<td>
							<input type="text" name="FTuition"
							value="${jstudent.FTuition }">
						</td>
					</tr>
					<tr>
						<td>
							住宿费（元）：
						</td>
						<td>
							<input type="text" name="FAccommodation"
							value="${jstudent.FAccommodation }">
						</td>
					</tr>
					<tr>
						<td>
							欠费合计（元）：
						</td>
						<td>
							<input type="text" name="FTotal"
							value="${jstudent.FTotal }">
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
