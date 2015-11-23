<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" errorPage="/errorPage.jsp"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>My JSP 'error.jsp' starting page</title>

		<link rel="stylesheet" type="text/css"
			href="<%=request.getContextPath()%>/bksx/css/css.css">
		<link rel="stylesheet" type="text/css"
			href="<%=request.getContextPath()%>/bksx/css/mycss.css">
	</head>

	<body>
		<br>
		<br>
		<br>
		<h3 align="center">
			<font color="red">未选择任何文件！</font>
		</h3>
		<hr>
		<table align="center">
			<tr>
				<td>
					<a
						href="<%=request.getContextPath()%>/bksx/bishe/Student/fileUpload.jsp"><img
							src="<%=request.getContextPath()%>/bksx/pictures/return.gif"
							align="top" border="0" />返回</a>

				</td>
			</tr>
		</table>
	</body>
</html>
