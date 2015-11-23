<%@ page language="java" import="java.util.*,javax.mail.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>main bodypart</title>
<link href="<%=request.getContextPath() %>/8_mail_system/css/css.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath() %>/8_mail_system/css/dialog.css" rel="stylesheet" type="text/css">
<script language="javascript" src="<%=request.getContextPath() %>/8_mail_system/js/jquery-latest.pack.js"></script>
<script language="javascript" src="<%=request.getContextPath() %>/8_mail_system/js/dialog.js"></script>
<script type="text/javascript">
	function loadCalendar(field){
       		var rtn = window.showModalDialog("contact.action","","dialogWidth:220px;dialogHeight:450px;dialogLeft:700px;dialogTop:450px;status:no;help:no;scrolling=no;scrollbars=no");
			if(rtn!=null)
			field.value=rtn;
			return;
			}
	function loadCalendar1(field){
       		var rtn = window.showModalDialog("calendar.jsp","","dialogWidth:290px;dialogHeight:250px;status:no;help:no;scrolling=no;scrollbars=no");
			if(rtn!=null)
			field.value=rtn;
			return;
			}
			
	function check(){
		var name = document.getElementById("search_from").value;
		var time = document.getElementById("search_date").value;
		if(name.length==0&&time.length==0)
		{
			window.alert("请输入查询条件");
		}
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
     width: 400px;
     height: auto;
     border: 1px ;
     ">
     <hr>
     <form action="<%=request.getContextPath() %>/8_mail_system/searchmail.action">
     <table>
     	<tr>
     		<td>
     			按发件人查找
     		</td>
     		<td>
     			<input id="search_from" name="search_from" type="text" style="width: 200px;" onclick="loadCalendar(this)">
     		</td>
     	</tr>
     	<tr>
     		<td>
     			按邮件主题查找
     		</td>
     		<td>
     			<input id="search_date" name="search_date" type="text" style="width: 200px;">&nbsp;
     		</td>
     	</tr>
     	<tr>
     		<td colspan="2" align="right">
     			<input type="submit" value="搜索" onmouseover="check()">
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
	</div>
</body>
</html>