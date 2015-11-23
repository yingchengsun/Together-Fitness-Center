<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
	<head>
		<title>导出</title>
<base href="<%=basePath%>"> 
		<link rel="stylesheet" type="text/css" href="../../css.css">
		<link rel="stylesheet" type="text/css" href="../../mycss.css">
		<script language="javascript" src="../../js/TableColor.js"></script>
	</head>

	<body>
	<table align="center" width="700">
			<tr>
				<th align="left"><a href="<%=basePath%>tutor/ClassInfo!findAllClassInfo.action"  target="right"><img src="<%=basePath%>Pictures/return.gif" align="top" border="0"/>返回</a></th>
			</tr>
		</table> 
		<br>
		<h3 align="center">
			正在导出文件...
		</h3>
		<hr>
		<table align="center" width="700">
		ING...
		</table>

	</body>
</html>
