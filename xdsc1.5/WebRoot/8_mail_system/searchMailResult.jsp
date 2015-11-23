<%@ page language="java" import="java.util.*,javax.mail.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>main bodypart</title>
<link href="<%=request.getContextPath() %>/8_mail_system/css/css.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath() %>/8_mail_system/css/dialog.css" rel="stylesheet" type="text/css">

<script language="javascript" src="<%=request.getContextPath() %>/8_mail_system/js/TableColor.js"></script>
<script type="text/javascript">
	function loadCalendar(field){
       		var rtn = window.showModalDialog("contact.action","","dialogWidth:220px;dialogHeight:450px;dialogLeft:700px;dialogTop:450px;status:no;help:no;scrolling=no;scrollbars=no");
			if(rtn!=null)
			field.value=rtn;
			return;
			}
	

</script>
<style type="text/css">
body.iframe.content{padding:0;}
body {
	background-image: url("<%=request.getContextPath() %>/8_mail_system/pictures/newbackground.png");
}
</style>
</head>

<body>
	<div style="position: absolute;
		        top: 3%;
		        left: 21%;
		        width: 380px;
		        height: auto;
		        border: 1px;
	">
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span><img src="<%=request.getContextPath() %>/8_mail_system/images/mailtitle.png"><font size="6" face="华文新魏"><strong>欢迎使用邮件系统</strong></font></span>
	</div>
	
	<div style="
     position: absolute;
     left: 21%;
     top: 13%;
     width: 600px;
     height: auto;
     border: 1px ;
     ">
     <form action="<%=request.getContextPath() %>/8_mail_system/searchmail.action">
     <table>
     	<tr>
     		<td>
     			按发件人查找
     		</td>
     		<td>
     			<input name="search_from" type="text" onclick="loadCalendar(this)">
     		</td>
     	</tr>
     	<tr>
     		<td>
     			按邮件主题查找
     		</td>
     		<td>
     			<input name="search_date" type="text" >
     		</td>
     	</tr>
     	<tr>
     		<td>
     			<input type="submit" value="搜索">
     		</td>
     	</tr>
     </table>
     </form>
     <hr>
	<!-- span><a class="LINK21" href="#" onclick='dialog("高级搜索","iframe:SearchMail.jsp","500px","240px","iframe");'>高级搜索</a></span-->
	
	<!--table cellspacing="1" id="mytable">
    			<tr bgcolor="#750000;" >
    				<td width="30"><input type="checkbox" name=""></td>
    				<td width="200">发件人</td>
    				<td width="500">主题</td>
    				<td width="160">时间</td>
    				<td width="80">大小</td>
    			</tr>
    			<c:forEach items="">
    			
    			</c:forEach>
    </table-->
    <%	
    	Message[] messages =(Message[]) request.getAttribute("messages");
    	String from = new String("");
		String subject = new String("");
		Date sendDate = new Date();
		int size;
     %>
	<h2>共搜索到<%=messages.length %>封符合条件的邮件</h2>
	</div>
	<div style="
     position: absolute;
     left: 20%;
     top: 50%;
     width: 600px;
     height: auto;
     border: 1px ;
     ">
	<table cellspacing="1" id="mytable">
    			<tr bgcolor="#750000;">
    				
    				<td width="200">发件人</td>
    				<td width="500">主题</td>
    				<td width="160">时间</td>
    				<td width="80">大小</td>
    			</tr>
    			<% 
    			if(messages.length>0){
	    			for(int i=0;i<messages.length;i++){
				  		from = messages[i].getFrom()[0].toString();
				  		subject = messages[i].getSubject();
				  		sendDate = messages[i].getSentDate();
				  		size = messages[i].getSize();
			  		//out.print(i);
    			%>
    			<tr>
    			
    			<td width="200"><%=from %></td>
    				<td width="500"><a href="mailMessage.jsp?msgnum=<%=i+1 %>" class="LINK21"><%=subject %></a></td>
    				<td width="160"><fmt:formatDate value="<%=sendDate %>" type="both"/></td>
    				<td width="80"><%=size %>b</td>
    			</tr>
    			<%
    					}
    				}
    			 %>
    			
    		</table>
    		</div>

</body>
</html>