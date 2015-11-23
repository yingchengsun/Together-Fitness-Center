<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
	<head>
		<base href="<%=basePath%>">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>welcome</title>
		<style type="text/css">
<!--
body {
	background-image: url(images/Background.png);
}

.STYLE1 {
	color: #0d2c4d;
	font-size: 36px;
}
-->
</style>
	</head>
	<body>
		<p>
			&nbsp;
		</p>
		<p>
			&nbsp;
		</p>
		<table width="691" border="0">
			<tr>
				<td>
					<div align="center">
					<br>
						<table width="100%" border="0" align="center">
						  <tr>
						     <td align="right">
						                    <h2>欢迎进入&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</h2>
						                     <h2>课程教辅支撑平台</h2>
						     </td>
						     <td align="justify">
						         <img border="0" src="3_jiaofu_system/pictures/jfwelcome.png"> 
						     </td>
						  </tr>
						</table>
					</div>
				</td>
			</tr>
		</table>
		<p>
			&nbsp;
		</p>
	</body>
</html>