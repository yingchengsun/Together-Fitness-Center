<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<html>
	<head>
		<title>My jsP 'welcome.jsp' starting page</title>
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<link rel="stylesheet" type="text/css" href="../../mycss.css" />
	</head>
	<script>
function reinitIframe(){
var iframe = document.getElementById("left");
var mainframe = document.getElementById("right");
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
	<div align="center">
		<iframe id="top" name="top" width="100%" height="165px" src="4_wangshangbaoming_system/adPage/top.jsp"
			scrolling="NO" frameborder="0" style="border-style: none;"></iframe>
		<table width="100%" border="0" align="center" cellpadding="0"
			cellspacing="0">
			<tr>
				<td>
					<iframe id="left" name="left" width="195px" height="620"
						src="4_wangshangbaoming_system/adPage/LeftBar.jsp" scrolling="NO" frameborder="0"
						style="border-style: none; display: block"></iframe>
				</td>
				<td width="2%" valign="top">
					<iframe id="middleFrame" name="middleFrame" width="100%"
						height="620" src="4_wangshangbaoming_system/adPage/middleFrame.jsp" scrolling="NO" frameborder="0"
						style="border-style: none;"></iframe>
				</td>
				<td width="80%" valign="top">
					<iframe id="right" name="right" width="100%" height="620"
						src="4_wangshangbaoming_system/adPage/Homepage.jsp" scrolling="NO" frameborder="0"
						style="border-style: none;"></iframe>
				</td>
			</tr>
		</table>
		</div>
	</body>
</html>
