<%@ page language="java" contentType="text/html;" pageEncoding="UTF-8" errorPage="/errorPage.jsp"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.fckeditor.net" prefix="FCK"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
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
	color: gray;
}

A.LINK21:link {
	font-size: 13px;
	COLOR: #1C86EE;
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
	<body onselectstart="" bgcolor="">
	<div style="font-size:12px;color:red">
	<c:forEach items="${errorlist}" var="error">
		<option >
		错误:${error}
		</option>
	</c:forEach>
	<% session.removeAttribute("errorlist"); 
	%>

	</div>
		<form action="EditInfo${roletype}Action.action" method="post">
			<table cellspacing="0" cellpadding="0" width="400" align="center"
				 border="0">	
				${PersonalEditInfo}	
				<tr>
					<td colspan=3>
						<input type="submit" value="确认提交" style="float: right"
							onfocus="true" />
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>