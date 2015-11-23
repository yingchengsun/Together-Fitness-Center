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
			<img src="<%=basePath%>Pictures/Aluminum_001.png" align="top" border="0" width="50" height="50"/>高校信息
		</h3>
		<hr>
		<s:form action="tutor/UniInfo!searchUniByName.action" method="post" theme="simple">
				<table width="40%" border="0" align="center">
					<tr>
						<td align="left">
							<img src="<%=basePath%>Pictures/search.gif" align="top" border="0"/>查询学校名称:
							<s:textfield name="FUniNameselect" />
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
						<font color="#FFFFFF">学校信息</font>
					</th>
				</tr>
				<tr>
					<th>
						序号
					</th>
					<th>
						编号
					</th>
					<th>
						名称
					</th>
					<th>
						国家
					</th>
					<th>
						城市
					</th>
					<th>
						联系地址
					</th>
					<th>
						电子邮件
					</th>
					<th>
						联系电话
					</th>
					<th>
						简介
					</th>
					<th>
						录取记录
					</th>

				<s:iterator value="listUniInfo" status="status">
				   <tr>
				     <td align="center"><s:property value="#status.count"/></td>
				     <td align="center"><s:property value="FUniId"/></td>
				     <td align="center"><s:property value="FUniName"/></td>
				     <td align="center"><s:property value="FUniCountry"/></td>
				     <td align="center"><s:property value="FUniCity"/></td>
				     <td align="center"><s:property value="FUniAddress"/></td>
				     <td align="center"><s:property value="FUniEmail"/></td>
				     <td align="center"><s:property value="FUniTel"/></td>
				     <td align="center"><s:property value="FUniIntro"/></td>
				     <td><a href="tutor/Uniyear!findUniyearInfoByNum.action?FId=<s:property value="FId"/>">
				     <img src="<%=basePath%>Pictures/userinfo.gif" align="middle" border="0"> </a></td>		
				  </tr>
			</s:iterator>
			</table>
		</div>
		<br>
		<table width="40%" align="center">
  	<tr>
		<td><div align="center"><a href="<%=basePath %>tutor/UniInfo!findAllUniInfo.action?p=1" >首页</a></div></td>
		<td><div align="center"><a href="<%=basePath %>tutor/UniInfo!findAllUniInfo.action?p=${p-1}" >上一页</a></div></td>
		<td><div align="center"><a href="<%=basePath %>tutor/UniInfo!findAllUniInfo.action?p=${p+1}" >下一页</a></div></td>
		<td><div align="center"><a href="<%=basePath %>tutor/UniInfo!findAllUniInfo.action?p=${lastPage}" >末页</a></div></td>
	</tr>
  </table>
		<br>
		<br>
	</body>
</html>
