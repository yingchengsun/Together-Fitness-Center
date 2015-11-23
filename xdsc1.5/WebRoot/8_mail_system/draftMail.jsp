<%@ page language="java" import="java.util.*,javax.mail.*" pageEncoding="utf-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    
    <title>seen mail</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/8_mail_system/css/css.css">
	
	<script language="javascript" src="<%=request.getContextPath() %>/8_mail_system/js/TableColor.js"></script>
<style type="text/css">
body {
	background-image: url("<%=request.getContextPath() %>/8_mail_system/pictures/newbackground.png");
}
</style>

<script type="text/javascript">
	function refresh(){
		window.location.href="<%=request.getContextPath()%>/8_mail_system/deletedmail.action";
	}
	
</script>
  </head>
  <body>
 
  		<div style="position: absolute;
		        top: 15%;
		        left: 21%;
		        width: 380px;
		        height: auto;
		        border: 1px;
	">
		<fieldset style="height: 200px;">
	<legend style="font-size: 12px;">友情提示</legend>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>
		<table width="350px;">		
		<tr><td width="100px;" align="right"><img width="40px" height="40px" src="<%=request.getContextPath() %>/8_mail_system/pictures/warn.png"></td><td style="font-size: 16px;">草稿箱中没有邮件</td></tr>
		</table>
	</fieldset>
	</div>
  
  
  
  </body>
</html>
