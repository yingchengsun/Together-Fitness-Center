<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
	

  </head>
  
  <body>
    <br>
    <h3 align="center">
			修改失败，请返回重新修改
		</h3>
		<table align="center" width="700">
			<tr>
				<th align="center"><a href="showAllCourseLab.action">返回</a></th>
			</tr>
		</table> 
  </body>
</html>