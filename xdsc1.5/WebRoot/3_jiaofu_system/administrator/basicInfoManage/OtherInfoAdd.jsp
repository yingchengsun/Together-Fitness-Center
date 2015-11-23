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
			院外助教信息添加
		</h3>
		<hr>
		<br>
		<s:form action="administrator/BasicInfo!addOtherInfo.action" method="post" theme="simple">
			<table width="40%" border="0" id="mytable" align="center">
			    <tr>
	                <th align="center" colspan="2" background="<%=basePath%>3_jiaofu_system/pictures/jft.gif" height="30">
			           <font color="#FFFFFF">信息添加</font>
	                </th>
	            </tr>
				<tr>
					<td align="center">
						请输入助教编号:
					</td>
					<td align="center">
					    <s:textfield name="FAssistantId"/>
					</td>
				</tr>
				<tr>
					<td align="center">
						请输入助教姓名:
					</td>
					<td align="center">
						<input name="FName">
					</td>
				</tr>
				<tr>
					<td align="center">
						请选择性别:
					</td>
					<td align="center">
						<INPUT TYPE="RADIO" NAME="FSex" VALUE="男">男
						&nbsp; 
						<INPUT TYPE="RADIO" NAME="FSex" VALUE="女">女
					</td>
				</tr>
				<tr>
				   <td colspan="2" align="center">
				       <s:submit value="添加"/>&nbsp;<s:reset value="取消"/>&nbsp;
                       <input type="button" value="返回" onClick="javascript:window.history.go(-1)"/>
				   </td>
				</tr>
			</table>
		</s:form>
	</body>
</html>