<%@ page language="java" contentType="text/html;" pageEncoding="UTF-8" errorPage="/errorPage.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>个人信息</title>
		<base href="<%=basePath%>">
	</head>
	<link rel="stylesheet" type="text/css" href="css.css">
	<style type="text/css">

<!--
body {
	background-image: url(images/Background.png)
}
-->

	
#alabel {
	font-size: 12px;
	color: #1C86EE;
}

#alabel2 {
	font-size: 12px;
	color: #696969;
}

A.LINK21:link {
	font-size: 13px;
	COLOR:#1C86EE;
	text-decoration: none
}

A.LINK21:visited {
	font-size: 13px;
	COLOR: #1C86EE;
}

A.LINK21:active {
	font-size: 13px;
	COLOR: #1C86EE;
}

A.LINK21:hover {
	font-size: 13px;
	COLOR: red;
}

#tittle {
	font-size: 13px;
	color:royblue;
}

.blank {
	height: 1px;
	background-color: blue;
}
</style>
	<body onselectstart="return false" bgcolor="">
	
		<table cellspacing="0" cellpadding="0" width="100%" align="center"
			border="0" >
			<td valign=top>
				<form>
					<table cellspacing="0" cellpadding="0" width="400" align="center"
					 id="mytable"  border="0">
						${PersonalInfo}
					</table>
				</form>
			</td>
			
		</table>
	</body>
</html>