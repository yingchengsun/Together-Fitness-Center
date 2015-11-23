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
			考勤信息
		</h3>
		<hr>
		<div align="center">
		
			<form action="">
				<table>
					<tr>
						<th>
							快速查找：
						</th>
						<td>
							日期：
						</td>
							<td>
							<input readonly="readonly" type="text" name="date"
								onClick="WdatePicker()" size="12" />
						</td>
					<td>
							课程：
						</td>
						<td>
							<select name="courseNum">
								<c:forEach items="${courseList }" var="course">
									<option value="${course.FCourseNumber }">
										${course.FCourseName }
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
					<form action="">
						<table>
						<tr>
						<th>查找学生：
						</th>
						<td>
							<select name="way">
							<option>
								--选择方式--
							</option>
							<option value="number">
								学号
							</option>
							<option value="name">
							     姓名
							</option>
						</select>
						</td>
						<td>
						<input type="text" name="attribute" />
						<input type="submit" value="查询">
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
						<font color="#FFFFFF">考勤信息列表</font>
					</th>
				</tr>
				<tr>
				 <th>
						日期
					</th>
					<th>
						课程编号
					</th>
					<th>
						课程名称
					</th>
					<th>
						学生学号
					</th>
					<th>
						学生姓名
					</th>
					<th>
						是否到课
					</th>
					<th>
						备注
					</th>
				</tr>
				<c:forEach items="${attendanceList }" var="attend">
				<tr>
					<td>
						${attend.FData }
					</td>
					<td>
						${attend.tabCourse.FCourseNumber }
					</td>
					<td> 
						${attend.tabCourse.FCourseName }
					</td>
					<td> 
						${attend.tabStudents.FStudentNumber }
						</td>				
					<td> 
						${attend.tabStudents.FStudentName }
						</td>
					<td> 
						${attend.FAbsence }
						</td>
					<td>
						${attend.FRemark }
					</td>
				</tr>
				</c:forEach>
			</table>
			</form>
			<table width="40%">
				<tr>
					<td>
						<div align="center">
							<a href="classAttPrevious.action">上一页</a>
						</div>
					</td>
					<td>
						<div align="center">
							<a href="classAttNext.action">下一页</a>
						</div>
					</td>
					<td>
						共${attendanceAll.pageCount }页，当前第${attendanceAll.page+1 }页
					</td>
				</tr>
			</table>
		</div>
		
	</body>
</html>
