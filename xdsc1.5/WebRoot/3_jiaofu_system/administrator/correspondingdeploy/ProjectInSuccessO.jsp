<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>

		<base href="<%=basePath%>">
		<title>成功导入</title>

		<style type="text/css">
<!--
body {
	background-image: url(images/Background.png)
}
-->
</style>
		<link rel="stylesheet" type="text/css"
			href="<%=request.getContextPath()%>/css.css">
	</head>

	<body>
		<script language=javascript>
	setTimeout(
			"window.location.href='administrator/corresponding!findOtherDeployInfo.action'",
			2000)
</script>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>

		<div align="center">
			<font size="2" color="green">文件<font color="red"> <%=(String) request.getAttribute("fileName")%>
			</font>导入成功！ <br> 成功导入了 <font color="red"> <%=(String) request.getAttribute("rows")%>
			</font>条数据!<br> </font>
			<br>
			<br>
			<img src="<%=request.getContextPath()%>/3_jiaofu_system/pictures/process.gif">

		</div>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
	</body>
</html>
