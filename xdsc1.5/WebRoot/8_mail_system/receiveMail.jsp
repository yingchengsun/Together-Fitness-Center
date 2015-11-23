<%@ page language="java" import="java.util.*,javax.mail.*" pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    
    <title>recieve mail</title>
    
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
		window.location.href="<%=request.getContextPath()%>/8_mail_system/newmail1.action";
	}
	

	
</script>
  </head>
  <body>
  <%
  	//这个脚本是用来从folder对象中取到所有的邮件的
  	String from = new String("");
	String subject = new String("");
	Date sendDate = new Date();
	int size;
  	Folder folder =(Folder) session.getAttribute("folder");
  	Message[] messages = folder.getMessages();
  	
  	List deletedList = (List)request.getAttribute("deletedMsgNumList");
  	List rubbishList = (List)request.getAttribute("rubbishNumList");
  	List seenList = (List)request.getAttribute("seenMsgNumList");
  	
  	if((!rubbishList.isEmpty())&&(!deletedList.isEmpty()))
  	{
  		for(int p = 0; p<rubbishList.size();p++){
  			if(!deletedList.contains(rubbishList.get(p)))
  			{
  				deletedList.add(rubbishList.get(p));
  			}
  		}
  	}
   %>
  	<div style="position: absolute;top: 3%;left: 1%;;">
    	<font style="font-family: arial, 宋体, serif;
    					font-size: 15px;
    					font-weight: bold;
    	">收件箱</font>
    	<font style="font-family: arial, 宋体, serif;
    					font-size: 12px;
    					
    	">(共<%=messages.length-deletedList.size() %>封邮件，其中未读${countOfNew }封)</font>
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
    	<table>
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
    			<td><input type="submit" value="标记" onclick="window.alert('邮件已被标记成功')" name="submit"></td>
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
    			<td width="30">&nbsp;</td>
    				<td width="200">发件人</td>
    				<td width="500">主题</td>
    				<td width="160">时间</td>
    				<td width="80">大小</td>
    				<td width="">删除</td>
    			</tr>
    			<% 
    			for(int i=0;i<messages.length;i++){
    				if(!deletedList.contains(messages[i].getMessageNumber())&&!rubbishList.contains(messages[i].getMessageNumber())){
				  		from = messages[i].getFrom()[0].toString();
				  		subject = messages[i].getSubject();
				  		sendDate = messages[i].getSentDate();
				  		size = messages[i].getSize();
			  		//out.print(i);
    			%>
    			<tr>
    			<td width="5%"><input type="checkbox" name="move_object" value="<%=messages[i].getMessageNumber() %>"></td>
    			<td width="20%"><%=from %></td>
    				<td width="40%">
    				<%if(seenList.contains(new Integer(i+1))){%>
    				<a href="<%=request.getContextPath() %>/8_mail_system/mailMessage.jsp?msgnum=<%=messages[i].getMessageNumber() %>" class="LINK212"><%=subject %></a>
    				
    				<%
    				}
    				else{
    				 %>
    				 <a href="<%=request.getContextPath() %>/8_mail_system/mailMessage.jsp?msgnum=<%=messages[i].getMessageNumber() %>" class="LINK21"><%=subject %></a>
    				 <%} %>
    				</td>
    				<td width="15%"><fmt:formatDate value="<%=sendDate %>" type="both"/></td>
    				<td width="10%"><%=size %>b</td>
    				<td width="10%">
    					<a class="LINK21" onclick="javascript:window.alert('邮件已经被移动到已删除');" href="<%=request.getContextPath()%>/8_mail_system/deletemail.action?msgnum=<%=messages[i].getMessageNumber() %>" >删除</a>
    					<!-- input type="button" value="删除" onclick="javascript:window.alert('邮件已经被移动到'已删除'邮件箱中');
    						window.location.href='<%=request.getContextPath()%>/8_mail_system/deletemail.action?msgnum=<%=i+1 %>';"-->
    				</td>
    			</tr>
    			<%
    				}
    					}
    			 %>
    			
    		</table>
    		</div>
    		</form>
    	</div>
    
  </body>
</html>
