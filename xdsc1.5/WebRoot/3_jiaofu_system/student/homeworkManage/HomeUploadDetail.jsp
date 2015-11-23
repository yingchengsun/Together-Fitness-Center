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
			作业信息
		</h3>
		<hr>
		<br>
		<s:form theme="simple" action="" name="f">
		<table width="80%" border="0" id="mytable" align="center">
		    <tr>
	                <th align="center" colspan="2" background="<%=basePath%>3_jiaofu_system/pictures/jft.gif" height="30">
			           <font color="#FFFFFF">作业信息</font>
	                </th>
	            </tr>
			<tr>
				<td align="center">
					课程名称
				</td>
				<td align="center">
					<s:property value="jfptTabHomeupload.tabCourse.FCourseName"/>
				</td>
			</tr>
			<tr>
				<td align="center">
					标题
				</td>
				<td align="center">
					<s:property value="jfptTabHomeupload.FHomeTitle"/>
				</td>
			</tr>
			<tr>
				<td align="center">
					内容
				</td>
				<td align="center">
					<s:property value="jfptTabHomeupload.FHomeContet"/>
				</td>
			</tr>
			<tr>
				<td align="center">
					时间
				</td>
				<td align="center">
					<s:date name="jfptTabHomeupload.FHomeTime" format="yyyy年MM月dd日HH时mm分ss秒" />
				</td>
			</tr>
			<tr>
				<td align="center">
					附件
				</td>
				<td align="center">
					<s:if test='jfptTabHomeupload.FFilePath==null'>
					  无附件
					</s:if>
					<s:else>
					  <a href="student/HomeworkManage!downFile1.action?FHomeId=<s:property value="jfptTabHomeupload.FHomeId"/>">下载附件</a>
					</s:else>
				</td>
			</tr>
			<tr>
				<td align="center">
					回复内容
				</td>
				<td align="center">
					<s:if test="jfptTabHomeupload.FReply == null">
					   没有回复内容
					</s:if>
					<s:else>
					  <s:property value="jfptTabHomeupload.FReply"/>
					</s:else>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="button" value="返回" onClick="javascript:document.f.action='student/HomeworkManage!findHomeUploadInfo.action';document.f.submit();" />
				</td>
			</tr>
		</table>
		</s:form>
	</body>
</html>