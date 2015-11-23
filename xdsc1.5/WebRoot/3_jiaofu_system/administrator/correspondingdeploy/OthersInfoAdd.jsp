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
	</head>

	<body>
		<br>
		<h3 align="center">
			选修课信息配置
		</h3>
		<hr>
		<br>   
		<s:form action="administrator/corresponding!addOtherDeploy.action" method="post" theme="simple">
		<table width="50%" border="0" id="mytable" align="center">
		    <tr>
	                <th align="center" colspan="3" background="<%=basePath%>3_jiaofu_system/pictures/jft.gif" height="30">
			           <font color="#FFFFFF">选修课信息配置</font>
	                </th>
	            </tr>
			<tr>
				<td width="" bgcolor="3D99A5" align="center">
					<s:updownselect list="listTeachersInfo" name="listSelectTeachersInfo" listKey="FTeacherNumber" listValue="FTeacherNumber"
					       headerKey="-1" headerValue="---请选择教师(单选)---" emptyOption="false" multiple="false"
					       size="12">
					</s:updownselect>
				</td>
				<td width="" bgcolor="3D99A5" align="center">
					<s:updownselect list="listCourseInfo" name="listSelectCourseInfo" listKey="FCourseNumber" listValue="FCourseName"
					       headerKey="-1" headerValue="---请选择课程(单选)---" emptyOption="false" multiple="false"
					       size="12">
					</s:updownselect>
				</td>
				<td width="" bgcolor="3D99A5" align="center">
					<s:updownselect list="listStudentsInfo" name="listSelectStudentsInfo" listKey="FStudentNumber" listValue="FStudentNumber"
					       headerKey="-1" headerValue="---请选择学生(多选)---" emptyOption="false" multiple="true"
					       size="12">
					</s:updownselect>
				</td>
			</tr>
			<tr>
			    <td colspan="3" align="center">
                   <s:submit value="更新"/>&nbsp;<s:reset value="取消"/>&nbsp;
                   <input type="button" value="返回" onClick="javascript:window.history.go(-1)"/>
                </td>
			</tr>
		</table>
		</s:form>
	</body>
</html>