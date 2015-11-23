<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
	 <base href="<%=basePath%>">
	
		<title>西安电子科技大学软件学院</title>
		<link href="css.css" rel="stylesheet" type="text/css" />
		<script src="js/AC_RunActiveContent.js" type="text/javascript"></script>
	</head>
	<body style="height: auto">
		<table width="100%" border="0" align="center" cellpadding="0"
			cellspacing="0">
			<tr>
				<td align="center" width="100%">
					<img src="5_sjjx_system/Pictures/topcut.jpg"  width="100%" height="135px">
				</td>
			</tr>
			<tr height="30" >
			<td align="center" valign="middle" width="500"
					background="5_sjjx_system/Pictures/newmenubg.gif" >
					|
					<a href="index.jsp" class="a_write" target=_top><span id="selected"
						>首页</span> </a> |&nbsp;
					
					
				</td>
			</tr>
		</table>
	</body>
</html>
