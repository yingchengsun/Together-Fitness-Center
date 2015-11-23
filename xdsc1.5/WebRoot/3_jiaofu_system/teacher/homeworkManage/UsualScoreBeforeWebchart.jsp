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
		<div align="center"><img src="3_jiaofu_system/pictures/jfweb.png"></div>
		<h3 align="center">请选择查看对象</h3>
		<hr>
		<br>
		<s:form name="f" action="" method="post">
		<table width="80%" border="0" id="mytable" align="center">
		     <tr>
	                <th align="center" colspan="1" background="<%=basePath%>3_jiaofu_system/pictures/jft.gif" height="30">
			           <font color="#FFFFFF">成绩分布</font>
	                </th>
	            </tr>
			<tr align="center">
			  <td align="center">查看指定班级学生的成绩分布图</td>
			</tr>
			<s:if test="listClassNumberInfo.size <= 0"><tr><td align="left">无可用信息!</td></tr></s:if>
			<s:else>
			   <tr align="center">
			     <td align="left">
			       <s:iterator value="listClassNumberInfo" status="status">
						<s:property value="#status.count" />号:&nbsp;<s:property/>班
						<img src="3_jiaofu_system/pictures/jfsee.png" onclick="javascript:document.f.action='teacher/HomeworkManage!webChart.action?DirectionNumber=0&ClassNumber=<s:property/>';document.f.submit();">
						&nbsp;|&nbsp;
						<s:if test="#status.count % 4 ==0">
			       	       <br>
			       	   </s:if>
			       </s:iterator>
			     </td>
			   </tr>
			</s:else>
			
			<tr align="center">
			  <td align="center">查看指定方向学生的成绩分布图</td>
			</tr>
			<s:if test="listDirectionInfo.size <= 0"><tr><td align="left">无可用信息!</td></tr></s:if>
			<s:else>
			   <tr align="center">
			     <td align="left">
			       <s:iterator value="listDirectionInfo" status="status">
						<s:property value="#status.count" />号:&nbsp;<s:property value="FDirectionName"/>方向
						<img src="3_jiaofu_system/pictures/jfsee.png" onclick="javascript:document.f.action='teacher/HomeworkManage!webChart.action?ClassNumber=0&DirectionNumber=<s:property value="FDirectionId"/>';document.f.submit();">
						&nbsp;|&nbsp;
						<s:if test="#status.count % 4 ==0">
			       	       <br>
			       	   </s:if>
			       </s:iterator>
			     </td>
			   </tr>
			</s:else>
			
			<tr align="center">
			  <td align="center">查看全部学生的成绩分布图</td>			
			</tr>
			<tr align="center">
			  <td align="left">全部学生<img src="3_jiaofu_system/pictures/jfsee.png" onclick="javascript:document.f.action='teacher/HomeworkManage!webChart.action?ClassNumber=0&DirectionNumber=0';document.f.submit();"></td>
			</tr>
		</table>
		</s:form>
	</body>
</html>