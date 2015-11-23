<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
	    <base href="<%=basePath%>">
		<link rel="stylesheet" type="text/css" href="css.css">
		<link rel="stylesheet" type="text/css" href="5_sjjx_system/mycss.css">
		<script language="javascript" src="5_sjjx_system/JS/TableColor.js"></script>
	</head>

	<body>
	
		<br>
		<c:choose>
		<c:when test="${isempty=='3'}">
			<h3 align="center">
			目前还无实验安排信息
		    </h3>
		    <table align="center" width="700">
			   <tr>
				  <th align="center">
					<a href="5_sjjx_system/CourseLab/SchedularImport.jsp"><img
								src="5_sjjx_system/Pictures/foward.png" align="top" border="0" />导入课表 
					</a>
				  </th>
			   </tr>
		    </table>
			<br/>
		</c:when>
		<c:otherwise>
		<h3 align="center">
			实验安排
		</h3>
		<table align="center" width="700">
			<tr>
				<th align="right">
					<a href="5_sjjx_system/CourseLab/SchedularImport.jsp"><img
								src="5_sjjx_system/Pictures/foward.png" align="top" border="0" />导入课表 
					</a>
				</th>
			</tr>
		</table>
		<hr>
		<div align="center">
					<form action="showCourseLab.action">
						<font size="4">按教师查找</font>
						<select name="search_item">
						<c:forEach items="${list_teacher}" var="teacher">
						<option value="${teacher.FTeacherNumber}">${teacher.FTeacherName }</option>
							</c:forEach>
						</select>
						<input type="submit" value="查询">
					</form>		
		</div>
		<div align="center">
					<form action="showCourseLab1.action">
						<font size="4">按实验室查找</font>
						<select name="search_item1">
						<c:forEach items="${list_lab}" var="lab">
						<option value="${lab.FLabId}">${lab.FLabName }</option>
							</c:forEach>
						</select>
						<input type="submit" value="查询">
					</form>		
		</div>
		<hr>
		<c:choose>
		<c:when test="${isempty=='1'}">
			<h3 align="center">
			无此教师的实验安排记录
		    </h3>
			<br/>
		</c:when>
		<c:when test="${isempty=='2'}">
			<h3 align="center">
			无该实验室的实验安排记录
		    </h3>
			<br/>
		</c:when>
		<c:otherwise>
			<table align="center" width="700">
				<tr>
				   <th align="right">
						<a href="<%=request.getContextPath()%>/deleteCourseLabAll.action"><img
								src="<%=request.getContextPath()%>/5_sjjx_system/Pictures/delete.gif"
								align="top" border="0" />全部删除 </a>
					</th>
					<th align="right">
						<a href="<%=request.getContextPath()%>/exportCourseLab.action"><img
								src="<%=request.getContextPath()%>/5_sjjx_system/Pictures/excel.bmp"
								align="top" border="0" />导出为Excel文件 </a>
					</th>
				</tr>
			</table>
			<div align="center">
				<table border="0" width="700" id="mytable">
					<tr>
						<th colspan="10" background="5_sjjx_system/Pictures/newmenubg.gif" height="30">
							<font color="#FFFFFF">实验安排信息</font>
						</th>
					</tr>
					<tr>
						<th>
							日期
						</th>
						<th>
							课程名称
						</th>
						<th>
							任课教师
						</th>
						<th>
							班级
						</th>
						<th>
							实验室名称
						</th>
						<th>
							具体时间
						</th>
						<th>
							修改
						</th>
						<th>
							删除
						</th>
					</tr>
					<c:forEach items="${courselablist }" var="courselab">
					<tr>
						<td>
							<fmt:formatDate value="${courselab.FDate}" type="date" pattern="yyyy-MM-dd"/>
						</td>				
						<td>
							${courselab.tabCourse.FCourseName }
						</td>
						<td>
							${courselab.tabTeachers.FTeacherName }
						</td>
						<td>
							${courselab.tabClasses.FClassNumber }
						</td>
						<td>
							${courselab.sjjxTabLab.FLabName }
						</td>
						<td>
							 ${courselab.FExactTime }
						</td>
						<td>
						  <a href="preUpdateCourseLab.action?cid=${courselab.FNumber }">修改</a>
						</td>
						<td>
							<a href="deleteCourseLab.action?cid=${courselab.FNumber }">删除</a>
						</td>
					</tr>
					</c:forEach>
				</table>
				<table width="40%">
					<tr>
						<td>
							<div align="center">
								<a href="previousC.action">上一页</a>
							</div>
						</td>
						<td>
							<div align="center">
								<a href="nextC.action">下一页</a>
							</div>
						</td>
						<td>
							当前第${courseLabAll.page+1 }页,共${courseLabAll.pageCount }页
						</td>
					</tr>
				</table>
		   </div>
		</c:otherwise>
	   </c:choose>
	  </c:otherwise>
	</c:choose>
		
		<br>
		<br>
		<br>
	</body>
</html>
