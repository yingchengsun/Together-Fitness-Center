<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
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
	<c:choose>
	<c:when test="${notenough=='1'}">
		<script language="javascript">
			window.alert("没有符合条件的实验室");
			window.location.href="<%=request.getContextPath()%>/search.action";
		</script>
	</c:when>
	<c:otherwise>
	<br>
	   <h3 align="center">
		          符合条件的实验室列表如下，请根据需要选择实验室！
		</h3>
		
		<br>
		<hr>
		<div align="center">
		<form action="addCourseLabInfo.action" method="post">
			<table>
				<tr><td><input type="hidden" name="FTeacherNumber" value="${userNumber }"></td></tr>
				<tr><td></td><td><input type="hidden" name="FDate" value="${FDate }"></td></tr>
				<tr><td></td><td><input type="hidden" name="FExactTime" value="${FExactTime }"></td></tr>
				<tr><td></td><td><input type="hidden" name="FClassNumber" value="${FClassNumber }"></td></tr>
				<tr><td></td><td><input type="hidden" name="FCourseName" value="${FCourseName }"></td></tr>
			</table>
			<table border="0" width="400" id="mytable">
				<tr>
					<th colspan="7" background="5_sjjx_system/Pictures/newmenubg.gif" height="30">
						<font color="#FFFFFF">实验室信息</font>
					</th>
				</tr>
				<tr>
					<th>
						实验室名称
					</th>
					<th>
						实验室机位
					</th>
					<th>
						校区
					</th>
					<th>
						勾选
					</th>
				</tr>
				<c:forEach items="${lab_List }" var="lab">
				<tr>
					<td>
						${lab.FLabName }
					</td>
					<td>
						${lab.FSeatNumber }
					</td>
					<td>
						${lab.FLabLocation }
					</td>
					<td>
					<input type="checkbox" name="select" value="${lab.FLabId }">
					</td>
					
				</tr>
				</c:forEach>
			</table>
			<input type="submit" value="提交">
			</form>
		</div>
		</c:otherwise>
		</c:choose>
		<br>
		<br>
	</body>
</html>
