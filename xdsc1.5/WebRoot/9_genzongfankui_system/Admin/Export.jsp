<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>导出</title>

		<link rel="stylesheet" type="text/css" href="../../css.css">
		<link rel="stylesheet" type="text/css" href="../../mycss.css">
		<script language="javascript" src="../../js/TableColor.js"></script>
	</head>

	<body>
		<br>
		<h3 align="center">
			导出文件
		</h3>
		<hr>
		<tr>
				<th align="right"><a href=""  target="right">
				<img src="<%=basePath%>Pictures/excel.bmp" align="top" border="0"/>下载2010级</a></th>
			</tr>
					
	</body>
</html>
