<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
		<title>管理登录</title>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
		<style type="text/css">
<!--
@import url("css/OSX.css");
-->
</style>
	</head>

	<body bgcolor="#88c1dc" topmargin="190">
		<div align="center">
			<div style="font-size: 12px; color: red">
				<c:forEach items="${errorlist}" var="error">
					<option>
						错误:${error}
					</option>
				</c:forEach>
				<% session.removeAttribute("errorlist"); 
	%>
			</div>
			<form name="loginForm" method="post"
				action="CheckLoginAction!checklogin.action">
				<table width="480" border="0" cellspacing="1" cellpadding="1"
					class="tableBorder">
					<tr>
						<td height="28" colspan="2" align="center"
							background="<%=basePath%>images/admin_bg_1.gif"
							class="whitenormal">
							软件学院信息化平台登陆
						</td>
					</tr>
					<tr>
						<td height="78" colspan="2"
							background="<%=basePath%>images/dvbbs.jpg">
							&nbsp;

						</td>
					</tr>
					<tr bgcolor="F2F3F5">
						<td width="30%" align="right" class="normalText">
							用户名:
						</td>
						<td width="70%">
							<input type="text" name="usernumber" class="textBox">
						</td>
					</tr>
					<tr bgcolor="F2F3F5">
						<td align="right" class="normalText">
							密&nbsp;&nbsp;码:
						</td>
						<td>
							<input type="password" name="password" class="textBox">
						</td>
					</tr>
					<tr align="center">
						<td colspan="2" bgcolor="E4EEFA">
							<input type="submit" name="submit" value="提交"
								onClick="return CheckForm()">
						</td>
					</tr>
				</table>
			</form>
		</div>
	</body>
	<SCRIPT language=javascript>
	function CheckForm(){
		if(document.loginForm.username.value==""||document.loginForm.username.value==null){
			alert("请输入用户名！");
			document.loginForm.username.focus();
			return false;
		}
		if(document.loginForm.password.value == ""||document.loginForm.password.value==null){
			alert("请输入密码！");
			document.loginForm.password.focus();
			return false;
		}
		document.loginForm.submit();
	}
</SCRIPT>
</html>
