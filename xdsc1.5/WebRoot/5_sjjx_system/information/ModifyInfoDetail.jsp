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
 
		<br>
		<br>
		<h3 align="center">编辑通知公告</h3>
		<table align="center" width="700">
			<tr>
				<th align="left"><a href="showInfoList.action"><img src="5_sjjx_system/Pictures/return.gif" align="top" border="0"/>返回</a></th>
			</tr>
		</table> 
		<hr>
		<div align="center">
			<form action="updateTZGGInfo.action" method="post">
				 <table border="1" width="700">
					<tr>
						<th height="30" colspan="2" align="center" background="5_sjjx_system/Pictures/newmenubg.gif">
							<font color="#FFFFFF">编辑信息</font>
						</th>
					</tr>
					<tr>
						<td>
							标题：
						</td>
						<td>
							<input type="text" name="FInfoTitle" value="${info.FInfoTitle }" size="60"/>
						    <input type="hidden" name="FInfoId" value="${info.FInfoId }"/>
						</td>
					</tr>
					<tr>
						<td>
							审核状态：
						</td>
						<td>
							<input type="radio" name="read" value="0" checked="checked">
							未阅
							<input type="radio" name="read" value="1">
							已阅
						</td>
					</tr>
					<tr>
						<td colspan="3">
							<FCK:editor instanceName="FInfoContet" value="${info.FInfoContet }"
									basePath="/fckeditor" width="100%" height="500"
									toolbarSet="mytools"></FCK:editor>
									<br>
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
