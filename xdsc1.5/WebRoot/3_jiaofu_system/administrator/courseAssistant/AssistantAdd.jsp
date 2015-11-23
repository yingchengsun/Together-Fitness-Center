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
			添加助教配置
		</h3>
		<hr>
		<br>
		<s:form name="Form" action="administrator/AssistantInfo!addAssistantInfo.action" method="post" theme="simple">
		<table width="40%" border="0" id="mytable" align="center">
		    <tr>
	                <th align="center" colspan="8" background="<%=basePath%>3_jiaofu_system/pictures/jft.gif" height="30">
			           <font color="#FFFFFF">添加助教</font>
	                </th>
	            </tr>
			<tr>
				<td align="center">请输入助教ID号：</td>
				<td align="center">
				   <s:textfield name="FAssistantId"/>
				</td>
			</tr>
			<tr>
				<td align="center">请输入教师ID号：</td>
				<td align="center">
				   <s:textfield name="FTeacherNumber"/>
				</td>
			</tr>
			<tr>
				<td align="center">请输入课程ID号：</td>
				<td align="center">
				   <s:textfield name="FCourseNumber"/>
				</td>
			</tr>
			<tr>
			    <td colspan="2" align="center">
                   <s:submit value="添加" onclick="return CheckForm()"/>&nbsp;
                   <s:reset value="取消"/>
                </td>
			</tr>
		</table>
		</s:form>
	</body>
	<SCRIPT language=javascript>
	function CheckForm(){
	  var assistantid=document.Form.FAssistantId.value;
	  var teachernumber=document.Form.FTeacherNumber.value;
	  var coursenumber=document.Form.FCourseNumber.value;
	  
	  if(assistantid==""||assistantid==null){
	     alert("请输入助教编号");
	     return false;
	  }
	  if(teachernumber==""||teachernumber==null){
	     alert("请输入教师编号");
	     return false;
	  }
	  if(coursenumber==""||coursenumber==null){
	     alert("请输入课程编号");
	     return false;
	  }
	}
</SCRIPT>
</html>