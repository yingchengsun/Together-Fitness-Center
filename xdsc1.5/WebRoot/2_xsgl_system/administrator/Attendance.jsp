<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<link rel="stylesheet" type="text/css"
			href="<%=request.getContextPath()%>/css.css">
		<script language="javascript"
			src="<%=request.getContextPath()%>/2_xsgl_system/JS/TableColor.js"></script>
		<link rel="stylesheet" type="text/css"
			href="<%=request.getContextPath()%>/2_xsgl_system/mycss.css">
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
			<form action="selectTotalAttendByDCC.action">
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
							班级：
						</td>
						<td>
							<select name="classid">
								<c:forEach items="${classList }" var="class">
									<option value="${class.FClassNumber }">
										${class.FClassNumber }
									</option>
								</c:forEach>
							</select>
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

		</div>
		<hr>
		<table align="center" width="700">
			<tr>
				<th align="right">
					<a
						href="<%=request.getContextPath()%>/2_xsgl_system/administrator/AddAttendance.jsp">
						<img
							src="<%=request.getContextPath()%>/2_xsgl_system/Pictures/return.gif"
							align="top" border="0" />添加</a>
				</th>
			</tr>
		</table>
		<div align="center">
			<form action="getTotalAttendanceList.action">
				<table border="0" width="700" id="mytable">
					<tr>
						<th colspan="10"
							background="<%=request.getContextPath()%>/2_xsgl_system/Pictures/newmenubg.gif"
							height="30">
							<font color="#FFFFFF">软件学院学生考勤统计信息</font>
						</th>
					</tr>
					<tr>
						<th>
							日期
						</th>
						<th>
							班级
						</th>
						<th>
							课程编号
						</th>

						<th>
							课程名称
						</th>
						<th>
							应到人数
						</th>
						<th>
							实到人数
						</th>
						<th>
							备注
						</th>
						<th>
							详细信息
						</th>
						<th>
							修改
						</th>
						<th>
							删除
						</th>
					</tr>
					<c:forEach items="${attendanceList }" var="toAttend">
						<tr>
							<td>
								<fmt:formatDate value="${toAttend.FData }" type="date" pattern="yyyy-MM-dd"/>
							</td>
							<td>
								${toAttend.tabClasses.FClassNumber }
							</td>
							<td>
								${toAttend.tabCourse.FCourseNumber }
							</td>
							<td>
								${toAttend.tabCourse.FCourseName }
							</td>
							<td>
								${toAttend.FTnumber }
							</td>
							<td>
								${toAttend.FRnumber }
							</td>
							<td>
								${toAttend.FRemark }
							</td>
							<td>
								<a
									href="<%=request.getContextPath()%>/getAttendanceByDCC.action?id=${toAttend.FId }">浏览</a>
							</td>
							<td>
								<a
									href="<%=request.getContextPath()%>/preUpdateTotalAttend.action?fid=${toAttend.FId }">更新</a>
							</td>
							<td>
								<a
									href="<%=request.getContextPath()%>/deleteTotalAttend?fid=${toAttend.FId }">删除</a>
							</td>
						</tr>
					</c:forEach>
				</table>
			</form>
		
		<table width="40%">
				<tr>
					<td>
						<div align="center">
							<a href="totalAttPrevious.action">上一页</a>
						</div>
					</td>
					<td>
						<div align="center">
							<a href="totalAttNext.action">下一页</a>
						</div>
					</td>
					<td>
						共${attendanceAll.pageCount }页，当前第${attendanceAll.page+1 }页
					</td>
				</tr>
			</table>
			</div>
			<br>
			<br>
		<div align="center">
			<form action="excelInAttend.action" enctype="multipart/form-data" method="post">
				<table border="1" width="700">
					<tr>
						<th height="30" colspan="2" align="center"
							background="<%=request.getContextPath()%>/2_xsgl_system/Pictures/newmenubg.gif">
							<img
								src="<%=request.getContextPath()%>/2_xsgl_system/Pictures/excel.bmp"
								border="0" align="top" />
							<font color="#FFFFFF">导入年级考勤Excel文件</font>
						</th>
					</tr>
					<tr>
						<td>
							选择文件:
						</td>
						<td>
							<input type="file" name="file" size="40">
						</td>
					</tr>
					<tr>
						<td>
							&nbsp;
						</td>
						<td>
							<input type="submit" value="提交" />
							<input type="reset" value="重置" />
						</td>
					</tr>
				</table>
			</form>
		</div>
	</body>
</html>