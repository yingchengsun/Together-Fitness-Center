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
		 <form action="<%=request.getContextPath()%>/updateAttend.action"
			method="post">
				<table border="1" width="700">
					<tr>
						<th height="30" colspan="2" align="center" background="<%=request.getContextPath() %>/2_xsgl_system/Pictures/newmenubg.gif">
							<font color="#FFFFFF">编辑信息</font>
						</th>
					</tr>
					<tr>
						<td>
							日期：
							<input type="hidden" name="fid" value="${attend.FId }">
						</td>
						<td>
							<input type="text" name="FData"
							value="${attend.FData }">
						</td>
					</tr>
					<tr>
						<td>
							课程编号：
						</td>
						<td>
							<input type="text" name="FCourseNumber"
							value="${attend.tabCourse.FCourseNumber }">
						</td>
					</tr>
					
					<tr>
						<td>
							学生学号：
						</td>
						<td>
							<input type="text" name="FStudentNumber"
							value="${attend.tabStudents.FStudentNumber }">
						</td>
					</tr>
					<tr>
						<td>
							是否到课：
						</td>
						<td>
							<input type="text" name="FAbsence"
							value="${attend.FAbsence }">
						</td>
					</tr>
					<tr>
						<td>
							备注：
						</td>
						<td>
							<input type="text" name="FRemark"
							value="${attend.FRemark }">
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
