<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    
    <title>write mail</title>
    
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
		
	function addComponent(){
			var uploadHTML=document.createElement("<input type='file' name='uploads'/>");
			document.getElementById("files").appendChild(uploadHTML);
			uploadHTML=document.createElement("<br/>");
			document.getElementById("files").appendChild(uploadHTML);
			}
	</script>

  </head>
  
  <body>
    <div style="position: absolute;
    padding-left:0px;
    padding-top:0px;
    top:2%;
    left:1%;
    width: 100%;
    height: 23px;
    background-color: #97cbff;">
   	<s:form action="sendemail.action" method="post" enctype="multipart/form-data" >
    	<table >
    		<tr>
    			<td width="50" align="center"><input type="button" value="存草稿" onclick="switch()"></td>
    			
    		</tr>
    	</table>
    	<div style="
    	position: absolute;
    	top: 30px;
    	left: 1%;
    	width: 100%;
    	height: auto;
    	">
    	<table>
    		<tr>
    			<td>发件人</td>
    			<td ><input type="text" disabled="disabled" value="${username }@localhost" style="width: 200px">
    			<a href="" class="LINK21">&nbsp;&nbsp;&nbsp;显示密送</a><a href="" class="LINK21">|显示抄送</a></td>
    		</tr>
    		<tr>
    			<td>收件人</td><td><input id="mailto" type="text" name="mail.to" style="width: 450px" ></td>
    		</tr>
    		<tr>
    			<td>主 &nbsp; 题</td><td><input type="text" name="mail.subject" style="width: 450px"></td>
    		</tr>
    		<tr>
    			<td>附 &nbsp; 件</td><td><input type="button" value="添加附件" onclick="addComponent()"></td>
    		</tr>
    		<tr>
    		<td></td>
    			<td>
    				<span id="files">
    					
					</span>
				</td>
    		</tr>
    		
    		<tr>
    			<td width="800" colspan="2"><textarea name="mail.content" rows="15" cols="92"></textarea></td>
    		</tr>
    		<tr>
    			<td><input type="submit" value="发送邮件"></td>
    		</tr>
    	</table>
    	
    	</div>
    	
    </s:form>
    </div>
    
  </body>
</html>