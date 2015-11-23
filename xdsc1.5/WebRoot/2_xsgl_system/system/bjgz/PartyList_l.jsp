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
		 学生党建
		</h3>

		<hr>
		<br>
		<div align="center">
		<form action="getGradeStudentByPartyList.action?regdate=2006">
			<table border="0" width="700" id="mytable">
				<tr>
					<th colspan="9" background="<%=request.getContextPath() %>/2_xsgl_system/Pictures/newmenubg.gif"
						height="30">
						<font color="#FFFFFF">学生党建信息列表</font>
					</th>
				</tr>
				<tr>
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
					<th>
						联系电话
					</th>
					<th>
						详细信息
					</th>
				</tr>
				<c:forEach items="${partyStuList }" var="pstudent">
				<tr>
					<td>
						${pstudent.tabStudents.tabClasses.FClassNumber }
					</td>
					<td>
						${pstudent.tabStudents.FStudentNumber }
					</td>
					<td>
						${pstudent.tabStudents.FStudentName }
					</td>
					<td>
						${pstudent.tabStudents.FStudentSex }
					</td>
					<td>
						${pstudent.FName }
					</td>
					<td>
						${pstudent.tabStudents.FStudentTel }
					</td>
					<td>
						<a href="<%=request.getContextPath() %>/showStudent.action?id=${pstudent.tabStudents.FStudentNumber }">浏览</a>
					</td>
				</tr>
				</c:forEach>
			</table>
			</form>
			<table width="40%">
				<tr>
					<td>
						<div align="center">
							<a href="partyStuPrevious.action">上一页</a>
						</div>
					</td>
					<td>
						<div align="center">
							<a href="partyStuNext.action">下一页</a>
						</div>
					</td>
					<td>
						共${partyStuAll.pageCount }页，当前第${partyStuAll.page+1 }页
					</td>
				</tr>
			</table>
			</div>
	</body>
</html>
