<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    
    <title>My JSP 'sentStatus.jsp' starting page</title>
    
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
		        top: 13%;
		        left: 21%;
		        width: 380px;
		        height: auto;
		        border: 1px;
	">
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span><img src="images/mailtitle.png"><font size="6" face="华文新魏"><strong>欢迎使用邮件系统</strong></font></span>
	</div>
	<div style="position: absolute;
		        top: 30%;
		        left: 20%;
		        width: 380px;
		        height: auto;
		        border: 1px dashed ;
	">
		<c:choose>
			<c:when test="${alertMessage=='success'}">
				<img src="<%=request.getContextPath() %>/8_mail_system/pictures/sentMailSuccess.jpg"/>
			</c:when>
			<c:otherwise>
				<h3>发送邮件失败</h3>
			</c:otherwise>
		</c:choose>
	</div>
	<br>
	<br>
	<div style="position: absolute;
		        top: 45%;
		        left: 20%;
		        width: 380px;
		        height: auto;
		        
	">
	<table><tr><td width="400" align="right"><a href="<%=request.getContextPath() %>/8_mail_system/welcome_page.jsp" class="LINK21">>>返回首页</a></td></tr></table>
	
	<table><tr><td width="400" align="right"><a href="<%=request.getContextPath() %>/8_mail_system/writeMail.jsp" class="LINK21">>>继续写信</a></td></tr></table>
	</div>
  </body>
</html>
