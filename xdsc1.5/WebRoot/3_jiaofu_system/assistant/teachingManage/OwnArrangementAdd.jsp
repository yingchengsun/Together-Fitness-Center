<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<link href="<%=basePath%>css.css" rel="stylesheet" type="text/css" />
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
			您的个人记事本
		</h3>
		<hr>
			<br>
			<s:form method="post" action="assist/Teachingmanage!addInfo.action" theme="simple">
			    <table width="80%" border="0" align="center">
			        <tr>
	                <th align="center" colspan="1" background="<%=basePath%>3_jiaofu_system/pictures/jft.gif" height="30">
			           <font color="#FFFFFF">添加事件</font>
	                </th>
	            </tr>
			        <tr>
						<td align="left" bgcolor="#CCCCCC">
							记事标题：
							<s:textfield name="FTitle" />
						</td>
					</tr>
			    </table>
				<table width="80%" border="0" align="center">
					
					<tr>
						<td align="center" colspan="2">
							<s:textarea cols="100%" rows="10" name="FBeiZhu" />
						</td>
					</tr>
					<tr>
						<td align="center" bgcolor="#CCCCCC" colspan="2">
							<s:submit value="保存" />
							<s:reset value="重置" />
							<input type="button" value="返回" onClick=javascript:window.history.go(-1);
>
						</td>
					</tr>
				</table>
			</s:form>
	</body>
</html>
