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
		 <form action="<%=request.getContextPath()%>/updateClass.action"
			method="post">
				<table border="1" width="700">
					<tr>
						<th height="30" colspan="2" align="center" background="<%=request.getContextPath() %>/2_xsgl_system/Pictures/newmenubg.gif">
							<font color="#FFFFFF">编辑信息</font>
						</th>
					</tr>
					<tr>
						<td>
							班级：
						</td>
						<td>
							<input type="text" name="FClassNumber"
							value="${tabClass.FClassNumber }">
						</td>
					</tr>
					<tr>
						<td>
							班级名称：
						</td>
						<td>
							<input type="text" name="FClassName"
							value="${tabClass.FClassName }">
						</td>
					</tr>
					<tr>
						<td>
							年级：
						</td>
						<td>
							<input type="text" name="FGradeName"
							value="${tabClass.tabGrade.FGradeName }">
						</td>
					</tr>
					<tr>
						<td>
							总人数：
						</td>
						<td>
							<input type="text" name="FClassTotalNum"
							value="${tabClass.FClassTotalNum }">
						</td>
					</tr>
					<tr>
						<td>
							男生人数：
						</td>
						<td>
							<input type="text" name="FClassMaleNum"
							value="${tabClass.FClassMaleNum }">
						</td>
					</tr>
					<tr>
						<td>
							女生人数：
						</td>
						<td>
							<input type="text" name="FClassFemaleNum"
							value="${tabClass.FClassFemaleNum }">
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
