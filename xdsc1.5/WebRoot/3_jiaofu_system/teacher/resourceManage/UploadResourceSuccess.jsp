<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<link href="<%=basePath%>css.css" rel="stylesheet" type="text/css" />
<script language="javascript" src="<%=basePath%>js/TableColor.js"></script>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<title></title>
		<style type="text/css">
<!--
body {
	background-image: url(images/Background.png)
}
-->
</style>
	</head>

	<body>
		<br>
		<table width="80%" border="0" align="center">
			<tr>
				<td align="left">
					上传成功！
				</td>
			</tr>
		</table>
		<hr>
		<br>
		<table width="80%" border="0" align="center" id="mytable">
			<tr>
			    <td align="center">
			    <a href="teacher/ResourceManage!addInfoBeforeUpload.action" >
									点击继续上传资源</a>
			    </td>
			</tr>
		</table>
	</body>
</html>