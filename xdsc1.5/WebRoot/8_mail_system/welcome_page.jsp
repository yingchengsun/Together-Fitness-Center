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
<script language="javascript" src="<%=request.getContextPath() %>/8_mail_system/js/dialog.js"></script>

<style type="text/css">
body.iframe.content{padding:0;}
body {
	background-image: url("<%=request.getContextPath() %>/8_mail_system/pictures/newbackground.png");
}
</style>
</head>

<body>
	<div style="position: absolute;
		        top: 13%;
		        left: 21%;
		        width: 380px;
		        height: auto;
		        border: 1px;
	">
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span><img src="<%=request.getContextPath() %>/8_mail_system/images/mailtitle.png"><font size="6" face="华文新魏"><strong>欢迎使用邮件系统</strong></font></span>
	</div>
	<div style="position: absolute;
		        top: 25%;
		        left: 20%;
		        width: 380px;
		        height: auto;
		        
	">
	<fieldset >
		<legend style="font-size: 13px;">个人中心</legend>
		<table>
			<tr>
			<td rowspan="6"><img src="<%=request.getContextPath() %>/8_mail_system/images/person.png" width="120" height="130"></td>
			</tr>
			<tr>
			<td>&nbsp;&nbsp;&nbsp;您好，${username }！</td>
			</tr>
			<tr>
			<td>&nbsp;&nbsp;&nbsp;今天是 <%=new java.sql.Date(new Date().getTime()) %></td>
			</tr>
			<tr>
			<td>&nbsp;&nbsp;&nbsp;您有&nbsp;<a href="<%=request.getContextPath() %>/8_mail_system/emailshow.action" class="LINK21">${countOfNew }&nbsp;封未读邮件</a></td>
			</tr>
			<tr>
			<td>&nbsp;&nbsp;&nbsp;您的私人提醒：
			<a href="<%=request.getContextPath() %>/8_mail_system/queryremind.action" class="LINK21">点击查看</a>
			&nbsp;|&nbsp;
			<a class="LINK21" href="#" onclick='dialog("设置提醒","iframe:newRemind.jsp","500px","350px","iframe");'>新提醒</a>
			</tr>
			<tr>
			
		</table>
		
	</fieldset>
	</div>
	
</body>
</html>