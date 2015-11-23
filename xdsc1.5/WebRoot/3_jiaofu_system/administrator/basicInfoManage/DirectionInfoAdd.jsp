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
		<title>添加方向信息</title>
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
			添加方向信息
		</h3>
		<hr>
	    <br>
	    <s:form name="Form" action="administrator/BasicInfo!AddDirectionInfo.action" method="post" theme="simple">
		  <table width="40%" border="0" id="mytable" align="center">
             <tr>
	                <th align="center" colspan="2" background="<%=basePath%>3_jiaofu_system/pictures/jft.gif" height="30">
			           <font color="#FFFFFF">添加方向信息</font>
	                </th>
	            </tr>	     
             <tr>
               <td align="center">方向名称</td>
               <td><s:textfield name="FDirectionName"/></td>
             </tr>
             <tr>
               <td colspan="2" align="center">
                 <s:submit value="添加" onclick="return CheckForm()"/>&nbsp;
                 <s:reset value="取消"/>&nbsp;
                 <input type="button" value="返回" onClick="javascript:window.history.go(-1)"/>
               </td>
             </tr>
		  </table>
		</s:form>
	</body>
	<SCRIPT language=javascript>
	function CheckForm(){
	  var FDirectionName=document.Form.FDirectionName.value;

	  if(FDirectionName==""||FDirectionName==null){
	     alert("请输入方向名称！");
	     return false;
	  }
	}
</SCRIPT>
</html>
