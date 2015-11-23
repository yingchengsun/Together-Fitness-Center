<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<link href="<%=basePath%>css.css" rel="stylesheet" type="text/css" />
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
		<table>
			<tr>
				<td align="left">
					助教添加成功
				</td>
			</tr>
			<tr>
				<td align="center"><a href="3_jiaofu_system/teacher/assistantManage/AssistantInfoAdd.jsp">返回课程助教申请页面</a></td>
			</tr>
		</table>

	</body>
</html>
