<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" errorPage="/errorPage.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>


		<title>成功导入</title>
		<link rel="stylesheet" type="text/css"
			href="<%=request.getContextPath()%>/bksx/css/css.css">
		<link rel="stylesheet" type="text/css"
			href="<%=request.getContextPath()%>/bksx/css/mycss.css">
	</head>

	<body>
		<script language=javascript>
    		 setTimeout("window.location.href='showSubstugui.action'",3000)
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
			<img src="<%=request.getContextPath()%>/bksx/pictures/process.gif">

		</div>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
	</body>
</html>
