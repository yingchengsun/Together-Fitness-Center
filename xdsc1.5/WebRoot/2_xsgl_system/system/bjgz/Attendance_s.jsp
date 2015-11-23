<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css.css">
		<script language="javascript" src="<%=request.getContextPath() %>/2_xsgl_system/JS/TableColor.js"></script>
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/2_xsgl_system/mycss.css">
		<script language="javascript"
			src="<%=request.getContextPath()%>/2_xsgl_system/JS/My97DatePicker/WdatePicker.js"></script>
	</head>

	<body>
	
		<br>
		<h3 align="center">
			学生考勤信息
		</h3>
		<hr>
		<div align="center">
		<form action="selectAttendBySDC.action?id=13061012">
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
							课程名称：
						</td>
						<td>
						<select name="courseNum">
								<c:forEach items="${attendanceList }" var="attend">
									<option value="${attend.tabCourse.FCourseNumber }">
										${attend.tabCourse.FCourseName }
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
					
		</div>
		<br>
		<div align="center">
		<form action="getAttendanceByStuNum.action?id=${parent.tabStudents.FStudentNumber }">
			<table border="0" width="700" id="mytable">
				<tr>
					<th colspan="5" background="<%=request.getContextPath() %>/2_xsgl_system/Pictures/newmenubg.gif" height="30">
						<font color="#FFFFFF">学生考勤信息</font>
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
						是否到课
					</th>
					<th>
						备注
					</th>
				</tr>
				<c:forEach items="${attendanceList }" var="attend">
				<tr>
					<td>
						<fmt:formatDate value="${attend.FData }" type="date" pattern="yyyy-MM-dd"/>
					</td>
					<td>
						${attend.tabCourse.FCourseNumber }
					</td>
					<td> 
						${attend.tabCourse.FCourseName }
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
							<a href="stuAttPrevious.action">上一页</a>
						</div>
					</td>
					<td>
						<div align="center">
							<a href="stuAttNext.action">下一页</a>
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
