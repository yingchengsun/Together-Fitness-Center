<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@taglib uri="http://java.fckeditor.net" prefix="FCK"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
	    <base href="<%=basePath%>">
		<link rel="stylesheet" type="text/css" href="css.css">
		<link rel="stylesheet" type="text/css" href="5_sjjx_system/mycss.css">
		<script language="javascript" src="5_sjjx_system/JS/PopupCalendar.js"></script>

	</head>

	<body>
    <script>
    </script>
		<br>
		<br>
		<h3 align="center">发布新通知公告</h3>
		<table align="center" width="700">
			<tr>
				<th align="left"><a href="showTZGGInfoList.action"><img src="5_sjjx_system/Pictures/return.gif" align="top" border="0"/>返回</a></th>
			</tr>
		</table> 
		<hr>
		<div align="center">
			<form action="addTZGGInfo1.action" method="post" enctype="multipart/form-data">
				 <table border="1" width="700">
					<tr>
						<th height="30" colspan="2" align="center" background="5_sjjx_system/Pictures/newmenubg.gif">
							<font color="#FFFFFF">编写信息</font>
						</th>
					</tr>
					<tr>
						<td>
							标题：
						</td>
						<td>
							<input type="text" name="FInfoTitle"  size="60"/>
						</td>
					</tr>
					<tr>
						<td colspan="3">
							<FCK:editor instanceName="FInfoContet" 
									basePath="/fckeditor" width="100%" height="500"
									toolbarSet="mytools"></FCK:editor>
									<br>
						</td>
					</tr>
					<tr>
						<td>
							上传附件
						</td>
						<td>
							<span id="files"> <input type='file' size="60"
										name='uploadFile' /> </span>
						</td>
						</tr>
					<tr>
					    <td>
				           <input type="reset" value="重置" />
						</td>
						<td>
							<input type="submit" value="提交" />
						</td>
					</tr>
			</table>
			</form>
		</div>
		
		<br>
	</body>
</html>
