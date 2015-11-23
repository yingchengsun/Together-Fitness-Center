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
			本科生名单 
		</h3>
		<hr>
		<div align="center">
			<form action="showClassStudent.action">
				<table>
					<tr>
						<th>
							查找班级：
						</th>
						<td>
							<select name="cid">
								<c:forEach items="${classList }" var="class">
									<option value="${class.FClassNumber }">
										${class.FClassNumber }
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
			<!-- 精确查询 -->
			
			<form action="selectStudent.action" method="post">
				<table>
					<tr>
						<th>
							查找学生：
						</th>
						<td>
						<select name="way">
							<option>
								----选择查询方式----
							</option>
							<option value="number">
								学生学号
							</option>
							<option value="name">
								学生姓名
							</option>
						</select>
						</td>
						<td>
						<input type="text" name="attribute" />
						<input type="submit" value="搜索">	
						</td>
					</tr>
				</table>
			</form>	
			</div>
		<hr>
		<div align="center">
		<form action="">
			<table border="0" width="700" id="mytable">
				<tr>
					<th colspan="7" background="<%=request.getContextPath() %>/2_xsgl_system/Pictures/newmenubg.gif" height="30">
						<font color="#FFFFFF">本科生信息列表</font>
					</th>
				</tr>
				<tr>
				<th>
					学号
					</th>
					<th>
						姓名
					</th>
					<th>班级 
					</th>
					
					<th>
						学生详细信息
					</th>
					
				</tr>
				<c:forEach items="${undergraduateList }" var="undergraduate">
				<tr>
				<td> ${undergraduate.FStudentNumber } 
						</td>
					<td>
					${undergraduate.tabStudents.FStudentName }
					</td>
					<td> ${undergraduate.tabStudents.tabClasses.FClassNumber }
						</td>				
					
					<td>
						<a href="<%=request.getContextPath() %>/showStudent.action?id=${undergraduate.FStudentNumber }">浏览</a>
					</td>
				</tr>
				</c:forEach>
			</table>
			</form>
			<table width="40%">
				<tr>
					<td>
						<div align="center">
							<a href="ungraGradePrevious.action">上一页</a>
						</div>
					</td>
					<td>
						<div align="center">
							<a href="ungraGradeNext.action">下一页</a>
						</div>
					</td>
					<td>
						共${undergraduateAll.pageCount }页，当前第${undergraduateAll.page+1 }页
					</td>
				</tr>
			</table>
		</div>
		<br>
		<br>
		<br>
	</body>
</html>
