<%@ page language="java" import="java.util.*,javax.mail.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

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
		window.location.href="<%=request.getContextPath()%>/8_mail_system/seenmail.action";
	}
	
</script>
  </head>
  <body>
  <c:choose>
  	<c:when test="${seenmailempty=='1'}">
  		<div style="position: absolute;
		        top: 25%;
		        left: 21%;
		        width: 380px;
		        height: auto;
		        border: 1px;
	">
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>
		<img width="60px" height="60px" src="<%=request.getContextPath() %>/8_mail_system/pictures/warn.png">
		<font size="5" face="华文新魏"><strong>已读邮件箱中没有邮件</strong></font></span>
	</div>
  	</c:when>
  	<c:otherwise>
  		 
  <%
  	//这个脚本是用来从folder对象中取到所有的邮件的
  	String from = new String("");
	String subject = new String("");
	Date sendDate = new Date();
	int size;
  	Folder folder =(Folder) session.getAttribute("folder");
  	
  	
  	List msgnumList = (List)request.getAttribute("msgnumContainer");
  	//得到已读邮件的msgnum,对应msgnum在邮件服务器上得到相应的邮件
  	Message[] messages = new Message[msgnumList.size()];
  	if(!msgnumList.isEmpty()){
  		for(int j = 0 ;j<msgnumList.size();j++){
  			messages[j]= folder.getMessage((Integer)msgnumList.get(j));
  		}
  	}
   %>
  	<div style="position: absolute;top: 3%;left: 1%;;">
    	<font style="font-family: arial, 宋体, serif;
    					font-size: 15px;
    					font-weight: bold;
    	">已阅读邮件箱</font>
    	<font style="font-family: arial, 宋体, serif;
    					font-size: 12px;
    					
    	">(共<%=messages.length %>封邮件)</font>
    	</div>
    <div style="position: absolute;
    padding-left:0px;
    padding-top:0px;
    top:7%;
    left:1%;
    width: 100%;
    height: 23px;
    background-color: #97cbff;">
    
    <form action="tagmail.action">
    	<table >
    		<tr>
    			<td>
    				<input type="button" value="刷新列表" onclick="refresh()">
    			</td>
    			
    			<td width="60" align="center">
    				<select name="move_target">
    					<option>标记为</option>
    					<option value="0">已读</option>
    					<option value="1">未读</option>
    					<option value="2">垃圾邮件</option>
    				</select>
    			</td>
    			<td><input type="submit" value="标记" onclick="window.alert('邮件已被标记成功')"name="submit"></td>
    			
    		</tr>
    	</table>
    	<div style="
    	position: absolute;
    	top: 30px;
    	left: 2px;
    	width: 100%;
    	height: auto;
    	">
    	
    	
    		<table cellspacing="1" id="mytable">
    			<tr bgcolor="#750000;" >
    				<td width="30"></td>
    				<td width="200">发件人</td>
    				<td width="500">主题</td>
    				<td width="160">时间</td>
    				<td width="80">大小</td>
    			</tr>
    			<% 
    			for(int i=0;i<messages.length;i++){
			  		from = messages[i].getFrom()[0].toString();
			  		subject = messages[i].getSubject();
			  		sendDate = messages[i].getSentDate();
			  		size = messages[i].getSize();
			  		//out.print(i);
    			%>
    			<tr>
    			<td width="30"><input type="checkbox" name="move_object" value="<%=(Integer)msgnumList.get(i) %>"></td>
    			<td width="200"><%=from %></td>
    				<td width="500"><a href="<%=request.getContextPath() %>/8_mail_system/mailMessage.jsp?msgnum=<%=(Integer)msgnumList.get(i) %>" class="LINK212"><%=subject %></a></td>
    				<td width="15%"><fmt:formatDate value="<%=sendDate %>" type="both"/></td>
    				<td width="80"><%=size %>b</td>
    			</tr>
    			<%
    				}
    			 %>
    			
    		</table>
    		</div>
    		</form>
    		
    	</div>
    	
    

  	</c:otherwise>
  </c:choose>
 
  </body>
</html>
