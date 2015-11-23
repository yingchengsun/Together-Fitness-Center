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
			上传资源
		</h3>
		<hr>
		<s:form action="teacher/ResourceManage!addFileIntoUpload.action" method="post" theme="simple" enctype="multipart/form-data">
		<table width="40%" border="0" align="center" id="mytable">
		    <tr>
	                <th align="center" colspan="2" background="<%=basePath%>3_jiaofu_system/pictures/jft.gif" height="30">
			           <font color="#FFFFFF">资源信息</font>
	                </th>
	            </tr>
			<tr>
				<td align="center">请选择相关课程</td>
				<td align="left">
				  <s:select name="FCourseNumber" listKey="FCourseNumber" listValue="FCourseName"
					             list="listCourseInfoUpload" headerKey="-1" headerValue="===请选择相关课程===">
				  </s:select>
				</td>
			</tr>
			<tr>
				<td align="center">请选择上传文件</td>
				<td align="left">
				   <s:file name="uploadFile"/>
				</td>
			</tr>
			
			<tr>
				<td align="center">请输入文件描述</td>
				<td align="left"><s:textarea name="FFileDetail" cols="40%" rows="5"/></td>
			</tr>
			<tr>
			    <td align="center" colspan="2">
			      <s:submit value="上传"/>&nbsp;<s:reset value="取消"/>
			    </td>
			</tr>
		</table>
		</s:form>
	</body>
</html>