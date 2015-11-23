<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<link href="<%=basePath%>css.css" rel="stylesheet" type="text/css" />
<script language="javascript" src="<%=basePath%>js/TableColor.js"></script>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<title></title>
		<style type="text/css">
<!--
body {
	background-image: url(images/Background.png)
}
-->
</style>
    <script type="text/javascript">
    	function next(){
    	    window.location.href="<%=basePath%>3_jiaofu_system/administrator/basicInfoManage/finish.jsp";
    	}
    	function finish(){
    	    window.location.href="<%=basePath%>3_jiaofu_system/administrator/basicInfoManage/finish.jsp";
    	}
    	function preference(){
    	   window.location.href="<%=basePath%>administrator/BasicInfo!findCoursetypeInfo.action";
    	}
    </script>
	</head>

	<body>
	    <br>
		<table width="80%" border="0"align="center">
		   <tr>
		     <td align="right"><img src="<%=basePath%>3_jiaofu_system/pictures/jfhello.png"></td>
		     <td> <h4>您好，已完成基本信息配置</h4></td>
		   </tr>
		</table>
		<hr>
		<br>
		<br>
		<br>
		<table border="0" style="border-collapse: collapse" align="center">
				<tr>
				    <td>
				        课程信息配置流程：
				    </td>
					<td>
						<img src="3_jiaofu_system/pictures/jfnown.png"><a href="administrator/BasicInfo!findCourseInfo.action">管理基本课程信息</a>
					</td>
					<td>
						<img src="3_jiaofu_system/pictures/jfnown.png"><a href="administrator/BasicInfo!findDirectionInfo.action">管理专业方向信息</a>
					</td>
					<td>
						<img src="3_jiaofu_system/pictures/jfnown.png"><a href="administrator/BasicInfo!findCoursetypeInfo.action">配置课程类型信息</a>
					</td>
					<th>
						<img src="3_jiaofu_system/pictures/jfnow.png"><a href="<%=basePath%>3_jiaofu_system/administrator/basicInfoManage/finish.jsp">
						    完成
						</a>
					</th>
					<td>
					    &nbsp;&nbsp;<img src="3_jiaofu_system/pictures/jflast.gif" onclick="preference()">
					    &nbsp;&nbsp;<img src="3_jiaofu_system/pictures/jfnext.gif" onclick="next()">
					    &nbsp;&nbsp;<img src="3_jiaofu_system/pictures/jfend.gif" onclick="finish()">
					</td>
				</tr>
		</table>
	</body>
</html>