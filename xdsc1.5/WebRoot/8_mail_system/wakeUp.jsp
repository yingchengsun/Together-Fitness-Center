<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    
    <title>wake up page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/8_mail_system/css/css.css">
	
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
  	<span><table><tr><td><a href="<%=request.getContextPath() %>/8_mail_system/newmail.action" class="LINK21">>>回首页</a></td></tr></table></span>
  		<div style="position: absolute;
		        top: 13%;
		        left: 21%;
		        width: 380px;
		        height: auto;
		        border: 1px;
	">
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span><img src="images/mailtitle.png"><font size="6" face="华文新魏"><strong>欢迎使用私人提醒</strong></font></span>
	</div>
	
  		<c:choose>
  			<c:when test="${isempty=='1'}">
  				<div style="position: absolute;
		        top: 35%;
		        left: 35%;
		        width: 380px;
		        height: auto;
					">
  				<h4>最近没有事务提醒</h4>
  				</div>
  			</c:when>
  			<c:otherwise>
  				<div style="position: absolute;
		        top: 30%;
		        left: 20%;
		        width: 380px;
		        height: auto;
					">
					<%int i=0; %>
  				<c:forEach items="${remindList}" var="remind">
  				<table><tr><td bgcolor="yellow">私人提醒<%=++i %></td></tr></table>
		    		<div style="
		        width: 380px;
		        height: auto;
		        border: 1px solid ;
					">
					
		    		<table border="0" background="<%=request.getContextPath() %>/8_mail_system/pictures/new_login_bg.gif">
		    			<tr>
		    				<td colspan="2"></td>
		    				<td align="right" width="50"><a href="<%=request.getContextPath() %>/8_mail_system/deleteremind.action?r_id=${remind.RId }" class="LINK21">删除</a></td>
		    			</tr>
		    			<tr>
		    			<td width="60">时间：</td><td>${remind.RTime }</td>
		    			</tr>
		    			<tr>
		    			<td width="60">内容：</td><td>${remind.RTask }</td>
		    			</tr>
		    			<tr>
		    			<td width="60">备注：</td><td>${remind.RNotes }</td>
		    			</tr>
		    			<tr>
		    			<td>
		    			</td>
		    			</tr>
		    		</table>
		    		</div>
		    		<div style=" height: 20px;"></div>
    			</c:forEach>
    			
  			</c:otherwise>
  		</c:choose>
  		
  </body>
</html>
