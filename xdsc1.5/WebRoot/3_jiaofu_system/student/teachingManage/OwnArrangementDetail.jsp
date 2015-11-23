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
		<title>个人安排详情</title>
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
			您的个人记事本
		</h3>
		<hr>
		<div align="center">
			<table width="80%" border="0">
				<tr>
					<td align="right">时间：<s:date name="jfptTabZiwoanpai.FDataTime" format="yyyy年MM月dd日HH时mm分ss秒" /></td>
				</tr>
			</table>
			<br>
			<table width="80%" border="0" id="mytable">
			     <tr>
	                <th align="center" colspan="1" background="<%=basePath%>3_jiaofu_system/pictures/jft.gif" height="30">
			           <font color="#FFFFFF">详细内容</font>
	                </th>
	            </tr>
				<tr>
				  <td align="left" >记事标题:
				  <input name="textfield" type="text" id="textfield" disabled="disabled" value="<s:property value="jfptTabZiwoanpai.FTitle"/>"/>
				  </td>
				</tr>
				<tr>
				  <td align="center">
				  <TEXTAREA NAME="TALK" COLS="100%" ROWS="5"><s:property value="jfptTabZiwoanpai.FBeiZhu"/></TEXTAREA>
				  </td>
				</tr>
				<tr>
				  <td align="center">
				  <input type="button" value="返回" onClick="javascript:window.history.go(-1)"/>
				  </td>
				</tr>
			</table>
		</div>
	</body>
</html>
