<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'mailMessage.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="8_mail_system/css/css.css">
	
	
  </head>
  
 <frameset rows="40%,*" frameborder="no">
 	<frame src="/xdsc1.5/DisplayHead?msgnum=<%=request.getParameter("msgnum") %>">
 	<frame src="<%=request.getContextPath() %>/mailmanage.action?msgnum=<%=request.getParameter("msgnum") %>">

 </frameset>
</html>
