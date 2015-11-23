<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>main bodypart</title>
<link href="<%=request.getContextPath() %>/8_mail_system/css/css.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath() %>/8_mail_system/css/dialog.css" rel="stylesheet" type="text/css" />

<script language="javascript" src="<%=request.getContextPath() %>/8_mail_system/js/jquery-latest.pack.js"></script>


<style type="text/css">
body.iframe.content{padding:0;}
body {
	background-image: url("<%=request.getContextPath() %>/8_mail_system/pictures/newbackground.png");
}
</style>
</head>

<body>
	<div style="position: absolute;
		        top: 15%;
		        left: 20%;
		        width: auto;
		        height: auto;
		        
	">
	<form action="<%=request.getContextPath() %>/8_mail_system/updatecontact.action">
	<table><tr style="height: 30px;"><td bgcolor="orange" width="100" align="center">更改信息</td></tr></table>
	<div style="position: relative;
		        top: 4%;
		        left: 0%;
		        width: auto;
		        height: auto;
		        border: 1px dashed;
	">
		<table width="300">
			<tr><td><input type="hidden" name="CId" value="${contact.CId}"></td></tr>
			<tr><td>用户名</td><td><input style="width: 200px" type="text" name="CUsername" value="${contact.CUsername }"></td></tr>
			<tr><td>密码</td><td><input style="width: 200px" type="text" name="CPassword" value="${contact.CPassword }"></td></tr>
			<tr><td>真实姓名</td><td><input style="width: 200px" type="text" name="CName" value="${contact.CName }"></td></tr>
			<tr><td></td><td align="left"><input type="submit" value="提交">&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" value="重置"></td></tr>
		</table>
	</div>
	</form>
	</div>
</body>
</html>