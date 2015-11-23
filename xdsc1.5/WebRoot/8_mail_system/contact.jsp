<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  
    
    <title>通讯录</title>
    
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
	<script type="text/javascript">
	function addAddress(cid){
			address = cid.value;
			//address = document.getElementById(cid).value;
			self.parent.frames["writemail"].document.getElementById("mailto").value =self.parent.frames["writemail"].document.getElementById("mailto").value + address; 
			//parent.window.returnValue = address; 
			//parent.window.close();
		}
	</script>
  </head>
  
  <body>
  <br>
  <table><tr style="height: 25px;"><td bgcolor="#97cbff" width="150" align="center">通讯录</td></tr></table>
 <table>
 
  <form name="contact">
  
  	<c:forEach items="${contactList}" var="contact">
		<!--tr>
		<td>${contact.FUserNumber }</td>
		</tr-->
		<tr>
		<td><input type="text" value="${contact.FUserNumber }@localhost;" name="addressbar" id="${contact.FUserNumber }"
				readonly="readonly" 
				onclick="addAddress(this);"
				onMouseOver="this.style.background='#c4e1ff'"
				onmouseout="this.style.background='white'"></td>
		</tr>
	
	</c:forEach>
	</form>
	
	</table>
  </body>
</html>
