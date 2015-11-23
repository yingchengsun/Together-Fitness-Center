<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>

		<title>欢迎页面</title>


		<link rel="stylesheet" type="text/css" href="../../css.css">
		<link rel="stylesheet" type="text/css" href="../../mycss.css">
		<style type="text/css">
			body {
				font-family: arial, 宋体, serif;
				font-size: 12px;
				background-image: url("<%=basePath%>images/4_Pictures/newbackground.png");
			}
		.STYLE5 {
			font-family: "华文行楷";
			font-size: 14mm;
			color: #000000;
		}

		.STYLE6 {
			font-family: "隶书";
			font-size: 12mm;
			color: #000000;
			font-style: italic;
		}
		.STYLE7 {
			font-family: "隶书";
			font-size: 7mm;
			color: #000000;
		}
</style>
	</head>

	<body>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
	<div align="center">
			<p class="STYLE6">
				欢迎访问
			</p>
			<br>
			<p class="STYLE5">
				工程硕士网上报名系统
			</p>
			<br>
		<font class="STYLE7">注册考生主页</font>	  </div>

	</body>
</html>
