<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>main bodypart</title>
		<link href="<%=request.getContextPath()%>/8_mail_system/css/css.css"
			rel="stylesheet" type="text/css" />
		<link
			href="<%=request.getContextPath()%>/8_mail_system/css/dialog.css"
			rel="stylesheet" type="text/css" />

		<script language="javascript"
			src="<%=request.getContextPath()%>/8_mail_system/js/jquery-latest.pack.js"></script>
		<script language="javascript"
			src="<%=request.getContextPath()%>/8_mail_system/js/dialog.js"></script>

		<style type="text/css">
body.iframe.content {
	padding: 0;
}

body {
	background-image:
		url("<%=request.getContextPath()%>/8_mail_system/pictures/newbackground.png")
		;
}
</style>
<script type="text/javascript">

	function selectLeader(){
		window.alert('您选择收件人的角色为领导');
		window.location.href='<%=request.getContextPath()%>/8_mail_system/writeMail.jsp?roleId=1';
	}
	
	function selectTeacher(){
		window.alert('您选择的收件人角色为教师！');
		window.location.href='<%=request.getContextPath()%>/8_mail_system/writeMail.jsp?roleId=2';
	}
	
	function selectStudent(){
		window.alert('您选择的收件人角色为学生！');
		window.location.href='<%=request.getContextPath()%>/8_mail_system/writeMail.jsp?roleId=3';
	}
	function selectAdmin(){
		window.alert('您选择的收件人角色为管理员！');
		window.location.href='<%=request.getContextPath()%>/8_mail_system/writeMail.jsp?roleId=4';
	}
</script>
	</head>

	<body>
		<div
			style="position: absolute; top: 13%; left: 21%; width: 380px; height: auto; border: 1px;">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<span><img
					src="<%=request.getContextPath()%>/8_mail_system/images/mailtitle.png"><font
				size="6" face="华文新魏"><strong>选择收件人角色</strong>
			</font>
			</span>
		</div>
		<div
			style="position: absolute; top: 25%; left: 22%; width: 150px; height: auto;">
			<img
				src="<%=request.getContextPath()%>/8_mail_system/pictures/role.png"
				width="150px;" height="150px;">

		</div>
		<div
			style="position: absolute; top: 25%; left: 45%; width: 150px; height: 150px;;border: 1px solid;">
			<table width="150px;">
			<tr><td style="background-color: red">选择角色</td></tr>
				<tr>
					<td>
						领导
					</td>
					<td align="right">
						<input type="button" value="选择"
							onclick="
									selectLeader()
			">
					</td>
				</tr>
				<tr>
					<td>
						教师
					</td>
					<td align="right">
						<input type="button" value="选择"
							onclick="
					selectTeacher()
			">
					</td>
				</tr>
				<tr>
					<td>
						学生
					</td>
					<td align="right">
						<input type="button" value="选择"
							onclick="
					selectStudent()
			">
					</td>
				</tr>
				<tr>
					<td>
						管理员
					</td>
					<td align="right">
						<input type="button" value="选择"
							onclick="
					selectAdmin()
			">
					</td>
				</tr>
			</table>

		</div>
	</body>
</html>