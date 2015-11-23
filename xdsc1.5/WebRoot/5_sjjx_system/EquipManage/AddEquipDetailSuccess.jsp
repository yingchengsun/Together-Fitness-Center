<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
	    <base href="<%=basePath%>">
		<title>My JSP 'AddEquipDetailSuccess.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">

		<link rel="stylesheet" type="text/css" href="css.css">
		<link rel="stylesheet" type="text/css" href="5_sjjx_system/mycss.css">


	</head>

	<body>
		<br>
		<h3 align="center">
			成功添加设备调拨信息
		</h3>
		<table align="center" width="700">
			<tr>
				<th align="center">
					<a href="showallEquip.action"><img
								src="5_sjjx_system/Pictures/return.gif" align="top" border="0" />返回
					</a>
				</th>
			</tr>
		</table>
	</body>
</html>
