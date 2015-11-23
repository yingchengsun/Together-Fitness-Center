<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>修改工作学生</title>
        <base href="<%=basePath%>"> 
		<link rel="stylesheet" type="text/css" href="<%=basePath%>css.css">
		<link rel="stylesheet" type="text/css" href="<%=basePath%>mycss.css">
				<style type="text/css">
		body {
	font-family: arial, 宋体, serif;
	font-size:12px;
	background-image:url("<%=basePath%>Pictures/newbackground.png");
}
		.STYLE5 {
			font-family: "华文行楷";
			font-size: 14mm;
			color: #000000;
		}

		.STYLE6 {
			font-family: "隶书";
			font-size: 12mm;
			color: #000000;
			font-style: italic;
		}
		.STYLE7 {
			font-family: "隶书";
			font-size: 7mm;
			color: #000000;
		}
</style>
		<script language="javascript" src="<%=basePath%>js/TableColor.js"></script>
	</head>

	<body>
		<br>
		<br>
		<h3 align="center">
			<img src="<%=basePath%>Pictures/sketchy_paper_001.png" align="top" border="0" width="50" height="50"/>修改工作学生信息
		</h3>
		<hr>
		<s:form action="admin/WorkInfo!updateWorkInfo.action" method="post" theme="simple">
			<table border="0" id="mytable" width="700">
			
				<tr>
               		<td align="center">编号</td>
               		<td>
                 		<input type="text" value="<s:property value="workStudent.FNumber"/>" name="FNumber" disabled="disabled">
               		</td>
             	</tr>
             	<tr>
               <td align="center">学号</td>
               <td>
                 <input  type="text" value="<s:property value="workStudent.TabStudents.FStudentNumber"/>" disabled="disabled">
               </td>
             </tr>
             <tr>
               <td align="center">姓名</td>
               <td>
                 <input type="text" value="<s:property value="workStudent.TabStudents.FStudentName"/>" disabled="disabled">
               </td>
             </tr>
             <tr>
               <td align="center">公司</td>
               <td>
                 <input type="text" value="<s:property value="workStudent.TabCompany.FCompanyName"/>" disabled="disabled" name="TabCompany.FCompanyName">
               </td>
             </tr>
             <tr>
               <td align="center">职位</td>
               <td>
                 <input type="text" value="<s:property value="workStudent.FPosition"/>" name="FPosition">
               </td>
             </tr>
             <tr>
               <td align="center">月薪</td>
               <td>
                 <input type="text" value="<s:property value="workStudent.FSalary"/>" name="FSalary">
               </td>
             </tr>
             <tr>
               <td align="center">工作地点</td>
               <td>
                 <input type="text" value="<s:property value="workStudent.FWorkCity"/>" name="FWorkCity">
               </td>
             </tr>
             <tr>
               <td align="center">电子邮件</td>
               <td>
                 <input type="text" value="<s:property value="workStudent.FEmail"/>" name="FEmail">
               </td>
             </tr>
             <tr>
               <td align="center">去向更新</td>
               <td>
                 <input type="text" value="<s:property value="workStudent.FWorkAdd"/>" name="FWorkAdd">
               </td>
             </tr>
             <tr>
               <td colspan="2" align="center">
                 <s:submit value="更新"/>&nbsp;<s:reset value="取消"/>&nbsp;
                 <input type="button" value="返回" onClick="javascript:window.history.go(-1)"/>
               </td>
             </tr>
			</table>

			<br>
		</s:form>
	</body>
</html>
