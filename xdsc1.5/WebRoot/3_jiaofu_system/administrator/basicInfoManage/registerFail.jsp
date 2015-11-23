<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'registerFail.jsp' starting page</title>
    <style type="text/css">
<!--
body {
	background-image: url(images/Background.png)
}
-->
</style>

  </head>
  
  <body>
    Fail. <br>
  </body>
</html>
