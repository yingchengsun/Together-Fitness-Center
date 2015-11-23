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
		<h3 align="center">
			软件学院团委信息
		</h3>
		<hr>
		<div align="center">
		<form action="getStudentByTWDepartment.action">
				<table>
					<tr>
						<th>
							快速查找：
						</th>
						<td>
							部门名称：
						</td>
						<td>
							<select name="dname">
								<c:forEach items="${departmentList }" var="department">
									<option value="${department.FDid }">
										${department.FDname }
									</option>
								</c:forEach>
							</select>
						</td>
						<td>
							<input type="submit" value="查询">
						</td>
					</tr>
				</table>
			</form>
		<hr>
		<div align="center">
		<form action="getStudentByTuanWei.action">
			<table border="0" width="700" id="mytable">
				<tr>
					<th colspan="7" background="<%=request.getContextPath() %>/2_xsgl_system/Pictures/newmenubg.gif" height="30">
						<font color="#FFFFFF">软件学院团委成员名单</font>
					</th>
				</tr>
				<tr>
					<th>
						姓名
					</th>
					<th>
						性别
					</th>
					<th>
						班级
					</th>
					<th>
						组织部门
					</th>
					<th>
						职务
					</th>
					<th> 
						联系电话 
					</th>
				</tr>
				<c:forEach items="${studentList }" var="student">
				<tr>
					<td>
						${student.tabStudents.FStudentName }
					</td>
					<td>${student.tabStudents.FStudentSex }
					</td>				
					<td>${student.tabStudents.tabClasses.FClassNumber }
					</td>
					<td>${student.xsglTabDepartment.FDname }
					</td>
					<td>${student.FPosition }
					</td>
					<td>${student.tabStudents.FStudentTel } 
					</td>
				</tr>
				</c:forEach>
			</table>
			</form>
			<table width="40%">
				<tr>
					<td>
						<div align="center">
							<a href="tuanweiPrevious.action">上一页</a>
						</div>
					</td>
					<td>
						<div align="center">
							<a href="tuanweiNext.action">下一页</a>
						</div>
					</td>
					<td>
						共${studentAll.pageCount }页，当前第${studentAll.page+1 }页
					</td>
				</tr>
			</table>
		</div>
	</body>
</html>
