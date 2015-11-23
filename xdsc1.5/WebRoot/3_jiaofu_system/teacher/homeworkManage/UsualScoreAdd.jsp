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

	<body>
		<br>
		<h3 align="center">
			平时成绩添加
		</h3>
		<hr>
		<br>
		<s:form action="teacher/HomeworkManage!addNewUsualScoreInfo.action" method="post" theme="simple">
		<table width="80%" border="0" id="mytable" align="center">
		    <tr>
	                <th align="center" colspan="2" background="<%=basePath%>3_jiaofu_system/pictures/jft.gif" height="30">
			           <font color="#FFFFFF">添加成绩</font>
	                </th>
	            </tr>
			<tr>
				<td align="center">
					课程编号
				</td>
				<td align="center">
					<s:property value="tabCourse.FCourseNumber"/>
				</td>
			</tr>
			<tr>
				<td align="center">
					课程名称
				</td>
				<td align="center">
					<s:property value="tabCourse.FCourseName"/>
				</td>
			</tr>
			<tr>
				<td align="center">
					学生学号
				</td>
				<td align="center">
					<s:textfield name="FStudentNumber"/>
				</td>
			</tr>
			<tr>
				<td align="center">
					成绩类型
				</td>
				<td align="center">
					<s:select name="FType" list="listFTypeInfo" headerKey="" headerValue="==选择成绩类型==">
				    </s:select>
				</td>
			</tr>
			<tr>
				<td align="center">
					得分
				</td>
				<td align="center">
					<s:textfield name="FScore"/>
				</td>
			</tr>
			<tr>
				<td align="center">
					学期
				</td>
				<td align="center">
					<s:property value="FXueQi"/>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<s:submit value="更新" />
					&nbsp;
					<s:reset value="取消" />
					&nbsp;
					<input type="button" value="返回" onClick="javascript:window.history.go(-1)" />
				</td>
			</tr>
		</table>
		</s:form>
	</body>
</html>