<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>   
    <link href="<%=basePath %>css.css" rel="stylesheet" type="text/css" />
    <title>My JSP 'wake.jsp' starting page</title>
</head>
  
<body>
  <font size="3">
  	${StatusReason }
  </font>
</body>
</html>
