<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" errorPage="/errorPage.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>


		<title>导入出错</title>
		<link rel="stylesheet" type="text/css"
			href="<%=request.getContextPath()%>/bksx/css/css.css">
		<link rel="stylesheet" type="text/css"
			href="<%=request.getContextPath()%>/bksx/css/mycss.css">
	</head>

	<body>
		<script language=javascript>
    		 setTimeout("window.location.href='showSubstugui.action'",10000)
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
			</font>导入失败！ <br> 原因可能是<font color="red">系统中无此选题学生记录！ </font> <br>
			</font>
			<br>
			<br>

		</div>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
	</body>
</html>
