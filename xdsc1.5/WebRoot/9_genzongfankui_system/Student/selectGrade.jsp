<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>选择年级</title>
        <base href="<%=basePath%>"> 
		<link rel="stylesheet" type="text/css" href="<%=basePath%>css.css">
		<link rel="stylesheet" type="text/css" href="<%=basePath%>mycss.css">
				<style type="text/css">
		body {
	font-family: arial, 宋体, serif;
	font-size:12px;
	background-image:url("<%=basePath%>Pictures/newbackground.png");
}
		.STYLE5 {
			font-family: "华文行楷";
			font-size: 14mm;
			color: #000000;
		}

		.STYLE6 {
			font-family: "隶书";
			font-size: 12mm;
			color: #000000;
			font-style: italic;
		}
		.STYLE7 {
			font-family: "隶书";
			font-size: 7mm;
			color: #000000;
		}
</style>
		<script language="javascript" src="<%=basePath%>js/TableColor.js"></script>
	</head>

	<body>
		<br>
		<br>
		<h3 align="center">
			<img src="<%=basePath%>Pictures/Antique_Icon_update_001.png" align="top" border="0" width="100" height="100"/>软件学院已毕业年级跟踪记录
		</h3>
		<hr>
		
				<table width="40%" border="0" align="center">
					<tr>
						<td align="center">
							<img src="<%=basePath%>Pictures/gif-0498.gif" align="top" border="0"/>2006级:
						</td>	
						<td align="center">
							查看<a href="<%=basePath%>student/ClassInfo!findGradeByNum.action?FGradeNumSelect=1306"><img src="<%=basePath%>Pictures/userinfo.gif"
								align="middle" border="0" /> </a>
						</td>
						
					</tr>
					<tr>
						<td align="center">
							<img src="<%=basePath%>Pictures/gif-0498.gif" align="top" border="0"/>2005级:
						</td>	
						<td align="center">
							查看<a href="<%=basePath%>student/ClassInfo!findGradeByNum.action?FGradeNumSelect=1305"><img src="<%=basePath%>Pictures/userinfo.gif"
								align="middle" border="0" /> </a>
						</td>
						
					</tr>
					<tr>
						<td align="center">
							<img src="<%=basePath%>Pictures/gif-0498.gif" align="top" border="0"/>2004级:
						</td>	
						<td align="center">
							查看<a href="<%=basePath%>student/ClassInfo!findGradeByNum.action?FGradeNumSelect=1304"><img src="<%=basePath%>Pictures/userinfo.gif"
								align="middle" border="0" /> </a>
						</td>
						
					</tr>
					<tr>
						<td align="center">
							<img src="<%=basePath%>Pictures/gif-0498.gif" align="top" border="0"/>2003级:
						</td>	
						<td align="center">
							查看<a href="<%=basePath%>student/ClassInfo!findGradeByNum.action?FGradeNumSelect=1303"><img src="<%=basePath%>Pictures/userinfo.gif"
								align="middle" border="0" /> </a>
						</td>
						
					</tr><tr>
						<td align="center">
							<img src="<%=basePath%>Pictures/gif-0498.gif" align="top" border="0"/>2002级:
						</td>	
						<td align="center">
							查看<a href="<%=basePath%>student/ClassInfo!findGradeByNum.action?FGradeNumSelect=1302"><img src="<%=basePath%>Pictures/userinfo.gif"
								align="middle" border="0" /> </a>
						</td>
						
					</tr>
				</table>
		

	</body>
</html>
