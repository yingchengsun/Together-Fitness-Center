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
		<title>添加课程类型信息</title>
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
			添加课程类型信息
		</h3>
		<hr>
		<br>
		<s:form name="Form" action="administrator/BasicInfo!addCoursetypeInfo.action" method="post" theme="simple">
			<table width="40%" border="0" id="mytable" align="center">
			    <tr>
	                <th align="center" colspan="2" background="<%=basePath%>3_jiaofu_system/pictures/jft.gif" height="30">
			           <font color="#FFFFFF">添加类型信息</font>
	                </th>
	            </tr>
				<tr>
					<td align="center">
						请选择课程名称：
					</td>
					<td align="center">
					   <s:select name="FCourseNumber" listKey="FCourseNumber" listValue="FCourseName"
					             list="tabCourseselect" headerKey="-1" headerValue="==请选择课程名称==">
					   </s:select>
					</td>
				</tr>
				<tr>
					<td align="center">
						请选择专业方向：
					</td>
					<td align="center">
					   <s:select name="FDirectionId" listKey="FDirectionId" listValue="FDirectionName"
					             list="tabDirectionselect" headerKey="-1" headerValue="==请选择专业方向==">
					   </s:select>
					</td>
				</tr>
				<tr>
					<td align="center">
						请输入课程类型：
					</td>
					<td align="center">
					   <s:textfield name="FCourseType"/>
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<s:submit value="添加" onclick="return CheckForm()"/>&nbsp;
						<s:reset value="取消" />&nbsp;
						<input type="button" value="返回" onClick="javascript:window.history.go(-1)" />
					</td>
				</tr>
			</table>
		</s:form>
	</body>
	<SCRIPT language=javascript>
	function CheckForm(){
	  alert("test");
	  alert(FCourseNumber);
	  var FCourseNumber=document.Form.FCourseNumber.value;
	  var FDirectionId=document.Form.FDirectionId.value;
	  var FCourseType=document.Form.FCourseType.value;

	  alert(FCourseNumber);
	  if(FCourseNumber==-1||FCourseNumber==null){
	     alert("请选择课程名称");
	     return false;
	  }
	  if(FDirectionId==-1||FDirectionId==null||){
	     alert("请选择专业方向");
	     return false;
	  }
	  if(FCourseType==""||FCourseType==null||){
	     alert("请输入课程类型信息");
	     return false;
	  }
	}
</SCRIPT>
</html>
