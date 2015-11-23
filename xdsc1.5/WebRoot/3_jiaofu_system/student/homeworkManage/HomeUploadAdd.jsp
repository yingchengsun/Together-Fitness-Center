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
			提交作业
		</h3>
		<hr>
		<br>
		<s:form action="student/HomeworkManage!addHomeworkInfo.action" theme="simple" method="post" enctype="multipart/form-data">
		<table width="80%" border="0" id="mytable" align="center">
		    <tr>
	                <th align="center" colspan="2" background="<%=basePath%>3_jiaofu_system/pictures/jft.gif" height="30">
			           <font color="#FFFFFF">提交作业</font>
	                </th>
	            </tr>
			<tr>
				<td align="center">
					相关课程
				</td>
				<td align="center">
				   <s:property value="tabCourse.FCourseName"/>
				</td>
			</tr>
			<tr>
				<td align="center">
					标题
				</td>
				<td align="center">
				   <s:textfield name="FHomeTitle"/>
				</td>
			</tr>
			<tr>
				<td align="center">
					内容
				</td>
				<td align="center">
				   <s:textarea name="FHomeContet" cols="100%" rows="5"/>
				</td>
			</tr>
			<tr>
				<td align="center">
					附件
				</td>
				<td align="center">
				   <s:file name="uploadFile"/>
				</td>
			</tr>
			<tr>
				<td align="center">
					发送人ID
				</td>
				<td align="center">
				   <s:property value="tabStudents.FStudentNumber"/>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					 <s:submit value="提交"/>&nbsp;<s:reset value="重置"/>&nbsp;
                   <input type="button" value="返回" onClick="javascript:window.history.go(-1)"/>
				</td>
			</tr>
		</table>
		</s:form>
	</body>
</html>