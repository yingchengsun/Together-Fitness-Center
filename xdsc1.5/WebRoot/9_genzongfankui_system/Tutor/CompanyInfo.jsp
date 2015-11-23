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
			<img src="<%=basePath%>Pictures/Aluminum_001.png" align="top" border="0" width="50" height="50"/>用人单位信息
		</h3>
		<hr>
						<s:form action="tutor/CompanyInfo!findCompanybyName.action" method="post" theme="simple">
				<table width="40%" border="0" align="center">
				
					<tr>
						<td align="left"><img src="<%=basePath%>Pictures/search.gif" align="top" border="0"/>
							按单位名称查询:
							<s:textfield name="FNameselect" />
							&nbsp;
							<s:submit value="提交" />
						</td>
						
					</tr>
				</table>
			</s:form>
		<s:form action="tutor/CompanyInfo!findCompanyByProperty.action" method="post" theme="simple">
				<table width="40%" border="0" align="center">
					<tr>
						<td align="left"><img src="<%=basePath%>Pictures/search.gif" align="top" border="0"/>
							按单位性质查询:
							<s:textfield name="FPropertyselect" />
							&nbsp;
							<s:submit value="提交" />
						</td>

					</tr>
				</table>
			</s:form>
		
		<div align="center">
			<table border="0" width="700" id="mytable" method="post">
				<tr>
					<th colspan="13" background="<%=basePath%>Pictures/newmenubg.gif" height="30">
						<font color="#FFFFFF">用人单位</font>
					</th>
				</tr>
				<tr>
					<th>
						序号
					</th>
					
					<th>
						单位名称
					</th>
					<th>
						性质
					</th>
					<th>
						联系电话
					</th>
					<th>
						联系地址
					</th>
					<th>
						电子邮件
					</th>
					<th>
						简介
					</th><th>
						录用记录
					</th>
					
				</tr>
				<s:iterator value="listCompanyInfo" status="status">
				   <tr>
				     <td align="center"><s:property value="#status.count"/></td>
				     <td align="center"><s:property value="FCompanyName"/></td>
				     <td align="center"><s:property value="FProperty"/></td>
				     <td align="center"><s:property value="FTelephone"/></td>
				     <td align="center"><s:property value="FAddress"/></td>
				     <td align="center"><s:property value="FEmailAddress"/></td>
				     <td align="center"><s:property value="FInformation"/></td>
				     <td><a href="tutor/Workyear!findWorkyearInfoByNum.action?FCompanyNumber=<s:property value="FCompanyNumber"/>">
				     <img src="<%=basePath%>Pictures/userinfo.gif" align="middle" border="0"> </a></td>		
				   </tr>
			</s:iterator>
			</table>
		</div>
		<br>
		<table width="40%" align="center">
  	<tr>
		<td><div align="center"><a href="<%=basePath %>tutor/CompanyInfo!findAllCompanyInfo.action?p=1" >首页</a></div></td>
		<td><div align="center"><a href="<%=basePath %>tutor/CompanyInfo!findAllCompanyInfo.action?p=${p-1}" >上一页</a></div></td>
		<td><div align="center"><a href="<%=basePath %>tutor/CompanyInfo!findAllCompanyInfo.action?p=${p+1}" >下一页</a></div></td>
		<td><div align="center"><a href="<%=basePath %>tutor/CompanyInfo!findAllCompanyInfo.action?p=${lastPage}" >末页</a></div></td>
	</tr>
  </table>
		<br>
		<br>
	</body>
</html>
