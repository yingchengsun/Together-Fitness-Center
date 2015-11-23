<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
	</head>
    <div align="center"><img src="3_jiaofu_system/pictures/jfpg.png"></div>
    <br>
    <hr>
    <br>
	<body>
		<br>
		<s:form action="teacher/HomeworkManage!findSelectHomeworkInfo.action" method="post" theme="simple">
		<table width="80%" border="0" align="center">
			<tr>
				<td align="left">
					作业信息列表:
				</td>
				<td align="right">
					<s:select name="FCourseNumber" listKey="FCourseNumber" listValue="FCourseName"
					             list="listCourseInfo" headerKey="" headerValue="==选择相关课程作业==">
				  </s:select>&nbsp;<s:submit value="提交"/>
				</td>
			</tr>
		</table>
		</s:form>
		<hr>
		<br>
	</body>
</html>