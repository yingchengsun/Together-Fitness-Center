<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
 
    
    <title>My JSP 'userInfo.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/8_mail_system/css/css.css">
	
	<style type="text/css">
		body {
	background-image: url("<%=request.getContextPath() %>/8_mail_system/pictures/newbackground.png");
}
	</style>

  </head>
  
  <body>
    <div style="position: absolute;
		        top: 5%;
		        left: 21%;
		        width: 380px;
		        height: auto;
		        border: 1px;
	">
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span><img src="<%=request.getContextPath() %>/8_mail_system/images/mailtitle.png"><font size="6" face="华文新魏"><strong>邮件系统个人主页</strong></font></span>
	</div>
	<div
		style="position: absolute; top: 15%; left: 70%; width: 380px; height: auto; border: 1px;">
					<span style="color: yellow"><a
					href="<%=request.getContextPath() %>/8_mail_system/showselfinfo.action?username=${username }" class="LINK21">退出修改</a>
					</span>
				</div>
	<div style="position: absolute;
		        top: 20%;
		        left: 20%;
		        width: 380px;
		        height: auto;
		        border: 1px dashed ;
	">	
	<form action="updateinfo.action" method="post">
		<table>
			<tr>
			<td rowspan="6"><img src="<%=request.getContextPath() %>/8_mail_system/pictures/${userInfo.infoPhoto }">
				<input type="hidden" name="userinfo.infoPhoto" value="${userInfo.infoPhoto }">
				<input type="hidden" name="userinfo.infoId" value="${userInfo.infoId }">
			</td>
			</tr>
			<tr>
			<td><input type="text" value="${userInfo.infoRealname }" name="userinfo.infoRealname"></td>
			<td><input type="text" value="${userInfo.infoUsername }" name="userinfo.infoUsername">   
			</tr>
			<tr>
			<td><input type="text" value="${userInfo.infoSex }" name="userinfo.infoSex"></td>
			
			<td><input type="text" value="${userInfo.infoAge }" name="userinfo.infoAge"></td>
			</tr>
			<tr>
			<td><input type="text" value="${userInfo.infoClass }" name="userinfo.infoClass"></td>
			</tr>
			<tr>
			<td><input type="text" value="${userInfo.infoNumber }" name="userinfo.infoNumber"></td>
			</tr>
			<tr>
			<td><input type="text" value="${userInfo.infoProperty }" name="userinfo.infoProperty"></td>
			</tr>
			<tr>
			<td colspan="3">--------------------------------------------------------------------------</td>
			</tr>
			<tr>
			<td colspan="3" bgcolor="gray">&nbsp;&nbsp;&nbsp;备注</td>
			</tr>
			<tr>
			<td colspan="3" style="height: 100"><textarea rows="7" cols="60" name="userinfo.infoNotes">&nbsp;&nbsp;&nbsp;${userInfo.infoNotes }</textarea></td>
			</tr>
			<tr>
			<td colspan="3">--------------------------------------------------------------------------</td>
			</tr>
			<tr>
			<td colspan="3" bgcolor="gray">&nbsp;&nbsp;&nbsp;最近动态</td>
			</tr>
			<tr>
			<td colspan="3" style="height: 100"><textarea rows="7" cols="60" name="userinfo.infoPresent">&nbsp;&nbsp;&nbsp;${userInfo.infoPresent }</textarea></td>
			</tr>
			<tr><td><input type="submit" value="提交"></td><td><input type="reset" value="重填"></td></tr>
		</table>
	</form>
	</div>
	
  </body>
</html>
