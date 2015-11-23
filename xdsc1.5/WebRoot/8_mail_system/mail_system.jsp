<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>内部邮件系统</title>
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
<iframe  id="top" name="top" width="100%" height="160px" src="top.jsp" scrolling="NO" frameborder="0" style="border-style: none;"></iframe>
<table width="100%" border="0" align="center" cellpadding="0"
			cellspacing="0">
			<tr>
			<td >
			<iframe id="left" name="left" width="195px" height="620" src="left_function_bar.jsp" scrolling="NO" frameborder="0" style="border-style: none;display:block"></iframe>
			</td>
			<td width="2%" valign="top">
			<iframe id="middleFrame" name="middleFrame"  width="100%" height="620" src="middleFrame.jsp" scrolling="NO" frameborder="0" style="border-style: none;"></iframe>
			</td>
			<td width="80%"  valign="top">
			<iframe id="rightFrame" name="mainFrame" width="100%"  height="620"   src="welcome_page.jsp" scrolling="NO" frameborder="0" style="border-style: none;"></iframe>
			</td>
</tr>
</table>
</body>
</html>
