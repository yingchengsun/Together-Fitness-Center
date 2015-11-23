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
    <h3 align="center">
			更新信息失败
		</h3>
		<table align="center" width="700">
			<tr>
				<th align="center">
					<a href="showInfoList.action">返回</a> 
				</th>
			</tr>
		</table><br>
  </body>
</html>
