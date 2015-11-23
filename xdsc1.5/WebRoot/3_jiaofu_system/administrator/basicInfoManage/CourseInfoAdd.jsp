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
		<title>添加课程信息</title>
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
			添加课程信息
		</h3>
		<hr>
	    <br>
	    <s:form name="Form" action="administrator/BasicInfo!addCourseInfo.action" method="post" theme="simple">
		  <table width="40%" border="0" id="mytable" align="center">
		     <tr>
	                <th align="center" colspan="2" background="<%=basePath%>3_jiaofu_system/pictures/jft.gif" height="30">
			           <font color="#FFFFFF">添加信息</font>
	                </th>
	            </tr>
             <tr>
               <td align="center">课程编号</td>
               <td align="center"><s:textfield name="FCourseNumber"/></td>
             </tr>
             <tr>
               <td align="center">课程名称</td>
               <td align="center"><s:textfield name="FCourseName"/></td>
             </tr>
             <tr>
               <td align="center">课程学分</td>
               <td align="center"><s:textfield name="FCourseScore"/></td>
             </tr>
             <tr>
               <td align="center">课程学时</td>
               <td align="center"><s:textfield name="FCourseXueShi"/></td>
             </tr>
             <tr>
               <td align="center">课程备注</td>
               <td align="center"><s:textfield name="FRemark"/></td>
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
	alert("imc ejdk");
	  var FCourseNumber=document.Form.FCourseNumber.value;
	  var FCourseName=document.Form.FCourseName.value;
	  
	  if(FCourseNumber==""||FCourseNumber==null){
	     alert("请输入课程编号");
	     return false;
	  }
	  if(FCourseName==""||FCourseName==null){
	     alert("请输入课程名称");
	     return false;
	  }
	}

</html>
