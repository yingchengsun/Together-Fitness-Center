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
			作业通知详细信息
		</h3>
		<hr>
		<br>
		<s:form theme="simple">
		<table width="80%" border="0" id="mytable" align="center">
		    <tr>
	                <th align="center" colspan="2" background="<%=basePath%>3_jiaofu_system/pictures/jft.gif" height="30">
			           <font color="#FFFFFF">通知详情</font>
	                </th>
	            </tr>
			<tr>
				<td align="center">
					相关课程
				</td>
				<td align="center">
				   <s:property value="jfptTabHomenotice.tabCourse.FCourseName"/>
				</td>
			</tr>
			<tr>
				<td align="center">
					标题
				</td>
				<td align="center">
				   <s:property value="jfptTabHomenotice.FTitle"/>
				</td>
			</tr>
			<tr>
				<td align="center">
					内容
				</td>
				<td align="center">
				   <input type="text" value="<s:property value="jfptTabHomenotice.FContent"/>" disabled="disabled">
				</td>
			</tr>
			<tr>
				<td align="center">
					附件
				</td>
				<td align="center">
				   <s:if test="jfptTabHomenotice.FUrl == null">
				      --无附件--
				   </s:if>
				   <s:else>
				      <a href="assist/HomeworkManage!downFile.action?FHomeNoticeId=<s:property value="jfptTabHomenotice.FHomeNoticeId"/>"> 点击下载</a>
				   </s:else>
				</td>
			</tr>
			<tr>
				<td align="center">
					通知时间
				</td>
				<td align="center">
				   <s:date name="jfptTabHomenotice.FDate" format="yyyy年MM月dd日HH时mm分ss秒" />
				</td>
			</tr>
			<tr>
				<td align="center">
					发送人ID
				</td>
				<td align="center">
				   <s:property value="jfptTabHomenotice.mhqxTabUser.FUserNumber"/>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="button" value="返回" onClick="javascript:window.history.go(-1)" />
				</td>
			</tr>
		</table>
		</s:form>
	</body>
</html>