﻿<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
	<head>
		<title>企业用户主页</title>
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	</head>
	<script>
function reinitIframe(){
var iframe = document.getElementById("left");
var mainframe = document.getElementById("right");
try{
var bHeight = iframe.contentWindow.document.body.scrollHeight;
var dHeight = iframe.contentWindow.document.documentElement.scrollHeight;
var height = Math.max(bHeight, dHeight);

var aHeight = mainframe.contentWindow.document.body.scrollHeight;
var cHeight = mainframe.contentWindow.document.documentElement.scrollHeight;
var height2 = Math.max(aHeight, cHeight);
height =Math.max(height, height2);

height =Math.max(height,620);
iframe.height = height;
mainframe.height = height;
}catch (ex){}
}
window.setInterval('reinitIframe()', 200);
</script>

	<body>
	<div align="center">
		<iframe id="top" name="top" width="100%" height="165px" src="<%=basePath%>7_yjssx_system/top.jsp"
			scrolling="NO" frameborder="0" style="border-style: none;"></iframe>
		<table width="100%" border="0" align="center" cellpadding="0"
			cellspacing="0">
			<tr>
				<td>
					<iframe id="left" name="left" width="195px" height="620"
						src="<%=basePath%>7_yjssx_system/left_function_bar_forCompany.jsp" scrolling="NO" frameborder="0"
						style="border-style: none; display: block"></iframe>
				</td>
				<td width="2%" valign="top">
					<iframe id="middleFrame" name="middleFrame" width="100%"
						height="620" src="<%=basePath%>7_yjssx_system/middleFrame.jsp" scrolling="NO" frameborder="0"
						style="border-style: none;"></iframe>
				</td>
				<td width="80%" valign="top">
					<iframe id="right" name="right" width="100%" height="620"
						src="<%=basePath%>7_yjssx_system/welcome_page_company.jsp" scrolling="NO" frameborder="0"
						style="border-style: none;"></iframe>
				</td>
			</tr>
		</table>
		</div>
	</body>
</html>