<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'newContactSuccess.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
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
		        left: 27%;
		        width: 200px;
		        height: auto;
		        border: 1px;
	">
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span><font size="6" face="华文新魏"><strong>操作成功</strong></font></span>
	</div>
	<div style="position: absolute;
		        top: 30%;
		        left: 25%;
		        width: 200px;
		        height: auto;
		       
	">
  <table align="center">
  <tr><td><img width="150px" height="150px" src="<%=request.getContextPath() %>/8_mail_system/pictures/success.png">
  </td></tr>
  </table>
  </div>
    
  </body>
</html>
