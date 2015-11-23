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
		<div align="center">
					<table border="1" cellspacing="0" width="98%">
						<tr>
							<td>
								<br>
								<br>
								<img
									src="<%=request.getContextPath()%>/bksx/pictures/MinIcons_001.png" />
								<br>
								<font color="red">系统中没有你的信息，请联系管理员！</font>
								<br>
								<br>
								<br>
							</td>
						</tr>
					</table>
				</div>
	</body>
</html>
