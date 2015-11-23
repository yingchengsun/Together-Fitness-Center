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
		 <form action="<%=request.getContextPath()%>/updateGrade.action"
			method="post">
				<table border="1" width="700">
					<tr>
						<th height="30" colspan="2" align="center" background="2_xsgl_system/Pictures/newmenubg.gif">
							<font color="#FFFFFF">编辑信息</font>
						</th>
					</tr>
					<tr>
						<td>
							年级：
							<input type="hidden" name="gradeID" value="${grade.FGradeId }">
						</td>
						<td>
							<input type="text" name="FGradeName"
							value="${grade.FGradeName }">
						</td>
					</tr>
					<tr>
						<td>
							总人数：
						</td>
						<td>
							<input type="text" name="FGradeTotalNum"
							value="${grade.FGradeTotalNum }">
						</td>
					</tr>
					<tr>
						<td>
							男生人数：
						</td>
						<td>
							<input type="text" name="FGradeMaleNum"
							value="${grade.FGradeMaleNum }">
						</td>
					</tr>
					<tr>
						<td>
							女生人数：
						</td>
						<td>
							<input type="text" name="FGradeFemaleNum"
							value="${grade.FGradeFemaleNum }">
						</td>
					</tr>
					<tr>
						<td>
							指导教师：
						</td>
						<td>
						<c:forEach items="${grade.tabTeacherses }" var="teacher">
							<input type="text" name="FTeacherName" value="${teacher.FTeacherName }">
								</c:forEach>
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
