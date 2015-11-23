
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'AddCourseLabFail.jsp' starting page</title>
    <link rel="stylesheet" type="text/css" href="css.css">
	<link rel="stylesheet" type="text/css" href="5_sjjx_system/mycss.css">
	</head>
  <body>
    <br>
    <h3 align="center">
			预定失败，请仔细填写好信息
		</h3>
		<table align="center" width="700">
			<tr>
				<th align="center"><a href="showLab3.action">返回重新预定</a></th>
			</tr>
		</table> 
  </body>
</html>
