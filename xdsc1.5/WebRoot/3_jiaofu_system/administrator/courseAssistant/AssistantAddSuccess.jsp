<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<link href="<%=basePath%>css.css" rel="stylesheet" type="text/css" />
<script language="javascript" src="<%=basePath%>js/TableColor.js"></script>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<title></title>
		<style type="text/css">
<!--
body {
	background-image: url(images/Background.png)
}
-->
</style>
	</head>

	<body>
		<br>
		<br>
		<br>
		<table width="80%" border="0" align="center" id="mytable">
			<tr>
				<td align="left">
					成功添加助教配置信息！
				</td>
			</tr>
			<tr>
			    <td><a href="3_jiaofu_system/administrator/courseAssistant/AssistantAdd.jsp">点击返回</a></td>
			</tr>
		</table>
	</body>
</html>