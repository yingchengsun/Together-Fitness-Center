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
		<title>修改公司</title>
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
			<img src="<%=basePath%>Pictures/sketchy_paper_001.png" align="top" border="0" width="50" height="50"/>修改公司信息
		</h3>
		<hr>
		<s:form action="admin/CompanyInfo!updateCompanyInfo.action" method="post" theme="simple">
			<table border="0" id="mytable" width="700">
			
				<tr>
               		<td align="center">编号</td>
               		<td>
                 		<input type="text" value="<s:property value="company.FCompanyNumber"/>" name="FCompanyNumber" disabled="disabled">
               		</td>
             	</tr>
             	<tr>
               <td align="center">公司名称</td>
               <td>
                 <input type="text" value="<s:property value="company.FCompanyName"/>" name="FCompanyName">
               </td>
             </tr>
                          	<tr>
               <td align="center">公司性质</td>
               <td>
                 <input type="text" value="<s:property value="company.FProperty"/>" name="FProperty">
               </td>
             </tr>
                       	<tr>
               <td align="center">公司电话</td>
               <td>
                 <input type="text" value="<s:property value="company.FTelephone"/>" name="FTelephone">
               </td>
             </tr>
                       	<tr>
               <td align="center">公司地址</td>
               <td>
                 <input type="text" value="<s:property value="company.FAddress"/>" name="FAddress">
               </td>
             </tr>
                       	<tr>
               <td align="center">电子邮件</td>
               <td>
                 <input type="text" value="<s:property value="company.FEmailAddress"/>" name="FEmailAddress">
               </td>
             </tr>
                         	<tr>
               <td align="center">公司简介</td>
               <td>
                 <input type="text" value="<s:property value="company.FInformation"/>" name="FInformation">
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
