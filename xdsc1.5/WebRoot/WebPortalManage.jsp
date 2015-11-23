<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>后台管理</title>
	<link href="css.css" rel="stylesheet" type="text/css" />
</head>
<script>
function reinitIframe(){
var iframe = document.getElementById("left");
var mainframe = document.getElementById("rightFrame");
try{
var bHeight = iframe.contentWindow.document.body.scrollHeight;
var dHeight = iframe.contentWindow.document.documentElement.scrollHeight;
var height = Math.max(bHeight, dHeight);

var aHeight = mainframe.contentWindow.document.body.scrollHeight;
var cHeight = mainframe.contentWindow.document.documentElement.scrollHeight;
var height2 = Math.max(aHeight, cHeight);
height =Math.max(height, height2);

height =Math.max(height,620);
iframe.height = height;
mainframe.height = height;
}catch (ex){}
}
window.setInterval('reinitIframe()', 200);
</script>
<body>
<iframe id="top" name="top" width="100%" height="200" src="top.jsp" scrolling="NO" frameborder="0" style="border-style: none;"></iframe>
<table width="850" border="0" align="center" cellpadding="0"
			cellspacing="0">
			<tr>
			<td  style="background-color:blue">
			<iframe id="left" name="left" width="148px" height="620" src="left_function_bar/function_bar.jsp" scrolling="NO" frameborder="0" style="border-style: none;display:block"></iframe>
			</td>
			<td width="2%" valign="top">
			<iframe id="middleFrame" name="middleFrame"  width="100%" height="620" src="middleFrame.jsp" scrolling="NO" frameborder="0" style="border-style: none;"></iframe>
			</td>
			<td width="80%" valign="top">
			<iframe id="rightFrame" name="rightFrame" width="100%"  height="620"   src="ManagePage/Manage01.jsp" scrolling="NO" frameborder="0" style="border-style: none;"></iframe>
			</td>
</tr>
</table>
<!-- start of bottom -->
		<table width="850" border="0" align="center" cellpadding="0"
			cellspacing="0">
			<tr>
				<td style="background-color:royalblue;" height="32">
			
					<div align="right" class="text_write">
						|
						<a href="/index.jsp" class="a_write">首 页</a> |
						<a href="/index.jsp" class="a_write">办事指南</a> |
						<a href="/index.jsp" class="a_write">院长信箱</a> |
						<a href="/index.jsp" class="a_write">网站导航</a>
					   <span style="color:#ffffff">  &nbsp;&nbsp;访问统计：20000 &nbsp;&nbsp; &nbsp;&nbsp;</span>
					</div>
				</td>
			</tr>
			<tr>
				<td height="20" bgcolor="#CCCCCC">
					<div align="center" style="color: #666666;font-size:11px">
						版权所有 西安电子科技大学软件学院 Copyright 2009 All Rights Reserved
					</div>
				</td>
			</tr>
		</table>
		<!-- end of bottom -->
</body>
</html>