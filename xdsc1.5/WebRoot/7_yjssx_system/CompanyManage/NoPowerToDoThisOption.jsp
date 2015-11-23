<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <link href="<%=basePath %>css.css" rel="stylesheet" type="text/css" />
    <title>My JSP 'noNoticeRightNow.jsp' starting page</title>

  </head>
  
  <body background="<%=basePath %>7_yjssx_system/SubSystemImage/Background.png">
  	<div align="center">
  	<table width="50%" style="margin-top: 100px;">
  		<tr style="background-image: url('<%=basePath %>7_yjssx_system/SubSystemImage/titlebg.gif')">
  			<td></td>
  			<td height="15" width="60%" align="left"><strong>操作失败!</strong></td>
  		</tr>
  		<tr>
  			<td>
  			<img src="<%=basePath %>7_yjssx_system/SubSystemImage/404.gif" />
  			</td>
  			<td>您目前无权限执行此操作！</td>
  		</tr>
  		<tr style="background-image: url('<%=basePath %>7_yjssx_system/SubSystemImage/titlebg.gif')">
  			<td height="15"></td>
  			<td></td>
  		</tr>
  	</table>
  </div>
  </body>
</html>
