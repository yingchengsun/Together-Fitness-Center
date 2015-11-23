<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" errorPage="/errorPage.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>反馈信息</title>

		<link rel="stylesheet" type="text/css"
			href="<%=request.getContextPath()%>/bksx/css/css.css">
		<link rel="stylesheet" type="text/css"
			href="<%=request.getContextPath()%>/bksx/css/mycss.css">
	</head>

	<body>
		<br>
		<br>
		<h3 align="center">
			<img src="<%=request.getContextPath()%>/bksx/pictures/Glass_Folder_001.png"
				width="50" height="50" align="middle" />
			成功申请
		</h3>

		<hr>
		<br>
		<br>
		<br>
		<div align="center">
			<table border="1" cellspacing="0" width="98%">
				<tr>
					<td>
						<br>
						<br>
						已成功向你的导师
						<font color="red">${myteacher.FTeacherName
							}&nbsp;${myteacher.FTeacherZhiCheng } </font>提出立项申请
						<br>
						请等待审批结果！
						<br>
						<br>
					</td>
				</tr>
			</table>

		</div>
		<br>
		<br>
		<br>
	</body>
</html>
