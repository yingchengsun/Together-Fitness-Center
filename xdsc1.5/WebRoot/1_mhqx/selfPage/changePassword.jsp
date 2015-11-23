<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="/errorPage.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>个人信息</title>
		<base href="<%=basePath%>">
	</head>
	<link rel="stylesheet" type="text/css" href="css.css">
	<style type="text/css">
	
<!--
body {
	background-image: url(images/Background.png)
}
-->

#alabel {
	font-size: 12px;
	color: #1C86EE;
}

#alabel2 {
	font-size: 12px;
	color: #BA55D3;
}

A.LINK21:link {
	font-size: 13px;
	COLOR: #1C86EE;
	text-decoration: none
}

A.LINK21:visited {
	font-size: 13px;
	COLOR: #1C86EE;
}

A.LINK21:active {
	font-size: 13px;
	COLOR: #1C86EE;
}

A.LINK21:hover {
	font-size: 13px;
	COLOR: red;
}

#tittle {
	font-size: 13px;
	color: royblue;
}

.blank {
	height: 1px;
	background-color: blue;
}
</style>
	<body>
		<div align="center">
			<div style="font-size: 12px; color: red">
				<c:forEach items="${errorlist}" var="error">
					<option>
						${error}
					</option>
				</c:forEach>
				<%
					session.removeAttribute("errorlist");
				%>
			</div>
			<form name="Form" action="ChangePassword!changePassword.action">
				<table width="300" border="0" cellspacing="0" cellpadding="0"
					id="mytable">

					<tr width=100% >
						<td width=70% colspan=1 align=left>
							<label id="tittle">
								修改密码
							</label>
						</td>
						<td colspan=1>

						</td>
						<td colspan=1>
							<a class="LINK21" href="showPIAction!showPersonalInfo.action"
								style="font-color: #ffffff">返回</a>
						</td>
					</tr>
					<tr id="blank" bgcolor="blue" height="1px">
						<td colspan=3></td>
					</tr>
					<tr>
						<td colspan=3 align=left height=40px>
							<label id="alabel">
								旧的密码：
							</label>
							<input size="10" type="password" name="oldpassword" />
						</td>
					</tr>
					<tr>
						<td colspan=3 align=left height=40px>
							<label id="alabel">
								新的密码：
							</label>
							<input size="10" type="password" name="password" />
						</td>
					</tr>
					<tr>
						<td colspan=3 align=left height=40px>
							<label id="alabel">
								确认密码：
							</label>
							<input size="10" type="password" name="confirm" />
						</td>
					</tr>
					<tr>
						<td colspan=3 align=center>
							<input type="submit" name="" value="确认修改"
								onclick="return CheckForm()" />
						</td>
					</tr>
				</table>
			</form>
		</div>
	</body>

	<SCRIPT language=javascript>
	function CheckForm(){
	var oldpassword=document.Form.oldpassword.value;
	var password=document.Form.password.value;
	var confirm=document.Form.confirm.value;
	if(oldpassword==""||oldpassword==null)
	{
	alert("请输入旧密码");
	return false;
	}
	if(password!=confirm)
	{
	alert("两次密码不一致");
	return false;
	}
	}
</SCRIPT>
</html>