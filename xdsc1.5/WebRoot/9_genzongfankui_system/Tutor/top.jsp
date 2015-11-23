<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>西安电子科技大学软件学院</title>
		 <base href="<%=basePath%>"> 
		<link href="<%=basePath%>css.css" rel="stylesheet" type="text/css" />
		<script src="<%=basePath%>js/AC_RunActiveContent.js" type="text/javascript"></script>
	</head>
	<body style="height: auto">
		<table width="100%" border="0" align="center" cellpadding="0"
			cellspacing="0">
			<tr>
				<td align="center" width="100%" bgcolor=#ffffff>
					<img src="<%=basePath%>Pictures/topcut.jpg"  width="100%" height="135">
					
				</td>
			</tr>
			<tr height="30">
			<td align="center" valign="middle" width="500"
					background="<%=basePath%>Pictures/newmenubg.gif" >
					|
					<a href="<%=basePath%>index.jsp" class="a_write" target=_top><span id="selected"
						>首页</span> </a> |&nbsp;
					<!-- <a href="../Admin/welcomepage.jsp" class="a_write" target=_top><span id="selected"
						>管理员</span> </a> |&nbsp;
					 <a href="../Student/welcomepage.jsp" class="a_write" target=_top><span id="selected"
						>学生</span> </a> |&nbsp;  
					<a href="../Tutor/welcomepage.jsp" class="a_write" target=_top><span id="selected"
						>辅导员</span> </a> |&nbsp;-->
					 <!-- <a href="welcome.jsp" class="a_write" target=_top><span id="selected"
						>学院领导</span> </a> |&nbsp;
					<a href="welcome.jsp" class="a_write" target=_top><span id="selected"
						>家长</span> </a> |&nbsp; -->
				</td>
			</tr>
		</table>
	</body>
</html>
