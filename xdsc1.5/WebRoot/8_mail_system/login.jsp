<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    
    <title>Mail_System</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		body{
			background-color:;
			background-image: url("images/login_bg2.gif");
		}
		
		#login_bar{
			position:absolute;
			left: 35%;
			top: 20%;
			height: 260px;
			width: 375px;
		}
		
		#login_bar1{
			position:relative;
			left:24%;
			top: 34%;
		}
		.button{
			background-image: url("images/login_btn.gif");
		}
	</style>
	
	<SCRIPT type="text/javascript">
	</SCRIPT>
	
  </head>
  
  <body>
  	
  		<div id="login_bar" style="background-image: url('images/login_bga.gif')">
   	 		<c:if test="${loginnull=='null'}">
   	 			<SCRIPT type="text/javascript">
   	 				window.alert("用户名或者密码不能为空");
   	 				window.location.href="/xdsc1.0/8_mail_system/login.jsp";
   	 			</SCRIPT>
   	 			
   	 		</c:if>
   	 		<c:if test="${loginerror=='error'}">
   	 			<SCRIPT type="text/javascript">
   	 				window.alert("用户名或者密码错误");
   	 				window.location.href="/xdsc1.0/8_mail_system/login.jsp";
   	 			</SCRIPT>
   	 		</c:if>
   	 		
   	 		<div id="login_bar1">
   	 		<s:form action="manager" method="post">
    			<s:textfield name="name"></s:textfield>
  				<s:password  name="password"></s:password>
   				<s:submit cssClass="button"></s:submit>
   	 		</s:form>
   	 		</div>
   	 	</div>
  </body>
</html>
