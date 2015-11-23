<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
	<link href="<%=basePath%>css.css" rel="stylesheet" type="text/css" />
    <script language="javascript" src="<%=basePath%>js/TableColor.js"></script>
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
    <div align="center"><img src="3_jiaofu_system/pictures/jfkaohe.png"></div>
    <br>
    <hr>
    <br>
	<body>
		<br>
		<table width="80%" border="0" align="center">
			<tr>
				<td align="left">
				    <s:form action="teacher/HomeworkManage!findUsualSelectInfo.action" method="post" theme="simple">
					<table width="80%" border="0" align="center">
					      查询平时成绩:
					   <s:select name="FCourseNumber" listKey="FCourseNumber" listValue="FCourseName"
					             list="listCourseInfo" headerKey="" headerValue="==点击课程查询平时成绩==">
				       </s:select>&nbsp;<s:submit value="查询"/>
					</table>
					</s:form>
				</td>
				<td align="right">
					<s:form action="teacher/HomeworkManage!addUsualscoreInfo.action" method="post" theme="simple">
					<table width="80%" border="0" align="center">
					         添加平时成绩:
				        <s:select name="FCourseNumber" listKey="FCourseNumber" listValue="FCourseName"
					             list="listCourseInfo" headerKey="" headerValue="==点击课程添加平时成绩==">
				        </s:select>&nbsp;<s:submit value="添加"/>
					</table>
					</s:form>
				</td>
			</tr>
		</table>
		<hr>
		<br>
	</body>
</html>