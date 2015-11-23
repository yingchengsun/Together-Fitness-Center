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
		<title>修改课程信息</title>
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
			课程信息修改
		</h3>
		<hr>
	    <br>
	    <s:form action="administrator/BasicInfo!updateCourseInfo.action" method="post" theme="simple">
		  <table width="40%" border="0" id="mytable" align="center">
		     <tr>
	                <th align="center" colspan="2" background="<%=basePath%>3_jiaofu_system/pictures/jft.gif" height="30">
			           <font color="#FFFFFF">修改信息</font>
	                </th>
	            </tr>
             <tr>
               <td align="center">课程编号</td>
               <td>
                 <input type="text" value="<s:property value="tabCourse.FCourseNumber"/>" name="FCourseNumber" disabled="disabled">
               </td>
             </tr>
             <tr>
               <td align="center">课程名称</td>
               <td>
                 <input type="text" value="<s:property value="tabCourse.FCourseName"/>" name="FCourseName">
               </td>
             </tr>
             <tr>
               <td align="center">课程学分</td>
               <td>
                 <input type="text" value="<s:property value="tabCourse.FCourseScore"/>" name="FCourseScore">
               </td>
             </tr>
             <tr>
               <td align="center">课程学时</td>
               <td><input type="text" value="<s:property value="tabCourse.FCourseXueShi"/>" name="FCourseXueShi"></td>
             </tr>
             <tr>
               <td align="center">课程备注</td>
               <td><input type="text" value="<s:property value="tabCourse.FRemark"/>" name="FRemark"></td>
             </tr>
             <tr>
               <td colspan="2" align="center">
                 <s:submit value="更新"/>&nbsp;<s:reset value="取消"/>&nbsp;
                 <input type="button" value="返回" onClick="javascript:window.history.go(-1)"/>
               </td>
             </tr>
		  </table>
		</s:form>
	</body>
</html>
