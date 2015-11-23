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
			<img src="<%=basePath%>Pictures/Aluminum_001.png" align="top" border="0" width="50" height="50"/>用人单位招聘信息编辑
		</h3>
		<table align="center" width="700">
			<tr>
				<th align="left"><a href="<%=basePath%>admin/CompanyInfo!findAllCompanyInfo.action"><img src="<%=basePath%>Pictures/return.gif" align="top" border="0"/>返回</a></th>
			</tr>
		</table> 
	
			<table width="80%" border="0" align="center">
					
					<tr>
					<th align="right"><a href="9_genzongfankui_system/Admin/addWorkyear.jsp"  ><img src="<%=basePath%>Pictures/edit.gif" align="top" border="0"/>添加公司录用信息</a>
					</th>
					</tr>
					
				</table>
		<hr>
		<div align="center">
			<table border="0" width="700" id="mytable" method="post">
				<tr>
					<th colspan="13" background="<%=basePath%>Pictures/newmenubg.gif" height="30">
						<font color="#FFFFFF">招聘信息</font>
					</th>
				</tr>
				<tr>
					<th>
						序号
					</th>
					
					<th>
						用人单位
					</th>
					
					<th>
						招聘年份
					</th>
					<th>
						就业联系人
					</th>
					<th>
						招聘人数
					</th>
					
					<th>
						修改
					</th>
					<th>
						删除
					</th>
				</tr>
				<s:iterator value="listWorkyearInfo" status="status">
				   <tr>
				     <td align="center"><s:property value="#status.count"/></td>
				     
				     <td align="center"><s:property value="TabCompany.FCompanyName"/></td>
				     <td align="center"><s:property value="FComNumYear"/></td>
				     <td align="center"><s:property value="FContactPerson"/></td>
				     <td align="center"><s:property value="FComNum"/></td>
				     <td align="center">
				        <a href="admin/Workyear!findWorkyearByNum.action?FId=<s:property value="FId"/>">
				                          修改
				        </a>
				     </td>
				     <td align="center">
				        <a href="admin/Workyear!deleteWorkyearByNum.action?FId=<s:property value="FId"/>">
				                          删除
				        </a>
				     </td>
				   </tr>
			</s:iterator>
			</table>
		</div>
		<br>

		<br>
		<br>
	</body>
</html>
