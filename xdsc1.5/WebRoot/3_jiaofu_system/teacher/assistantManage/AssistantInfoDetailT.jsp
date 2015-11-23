<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
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
		<h3 align="center">
			助教信息
		</h3>
		<hr>
		<br>
		<table width="40%" border="0" id="mytable" align="center">
		    <tr>
	                <th align="center" colspan="2" background="<%=basePath%>3_jiaofu_system/pictures/jft.gif" height="30">
			           <font color="#FFFFFF">助教信息(教师)</font>
	                </th>
	            </tr>
			<tr>
				<td align="center">教师职工号</td>
				<td align="center"><input type="text" value="<s:property value="tabTeachers.FTeacherNumber"/>"disabled="disabled"></td>
			</tr>
			<tr>
				<td align="center">姓名</td>
				<td align="center"><input type="text" value="<s:property value="tabTeachers.FTeacherName"/>"disabled="disabled"></td>
			</tr>
			<tr>
				<td align="center">性别</td>
				<td align="center"><input type="text" value="<s:property value="tabTeachers.FTeacherSex"/>"disabled="disabled"></td>
			</tr>
			<tr>
				<td align="center">办公电话</td>
				<td align="center"><input type="text" value="<s:property value="tabTeachers.FTeacherTel"/>"disabled="disabled"></td>
			</tr>
			<tr>
				<td align="center">手机号码</td>
				<td align="center"><input type="text" value="<s:property value="tabTeachers.FTeacherPhone"/>"disabled="disabled"></td>
			</tr>
			<tr>
				<td align="center">电子邮箱</td>
				<td align="center"><input type="text" value="<s:property value="tabTeachers.FTeacherEmail"/>"disabled="disabled"></td>
			</tr>
			<tr>
				<td align="center">办公地址</td>
				<td align="center"><input type="text" value="<s:property value="tabTeachers.FTeacherWorkPlace"/>"disabled="disabled"></td>
			</tr>
			<tr>
               <td colspan="2" align="center">
                 <input type="button" value="返回" onClick="javascript:window.history.go(-1)"/>
               </td>
             </tr>
		</table>
	</body>
</html>