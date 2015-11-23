<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
	    <base href="<%=basePath%>">
		<title>My JSP 'AddCourseLabSuccess.jsp' starting page</title>
		<link rel="stylesheet" type="text/css" href="css.css">
		<link rel="stylesheet" type="text/css" href="5_sjjx_system/mycss.css">


	</head>

	<body>
		<br>
		<h3 align="center">
			成功添加课程安排信息
		</h3>
		<!-- table align="center" width="700">
			<tr>
				<th align="center"><a href="<%=request.getContextPath() %>/unique.action?labId=${labId }">查看</a></th>
			</tr>
		</table --> 
		<table align="center" width="700">
			<tr>
				<th align="center"><a href="<%=request.getContextPath() %>/search.action">返回继续预定</a></th>
			</tr>
		</table>
	</body>
</html>
