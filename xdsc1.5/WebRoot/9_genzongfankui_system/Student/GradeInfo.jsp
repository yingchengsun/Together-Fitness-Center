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
		<title>年级记录</title>
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
			<img src="<%=basePath%>Pictures/Aluminum_001.png" align="top" border="0" width="50" height="50"/>软件学院已毕业年级跟踪记录
		</h3>
				<table align="center" width="700">
			<tr>
				<th align="left"><a href="<%=basePath%>9_genzongfankui_system/Student/selectGrade.jsp"><img src="<%=basePath%>Pictures/return.gif" align="top" border="0"/>返回</a></th>
			</tr>
		</table>
		<div align="center">
		
			<table border="0" id="mytable" width="700">
				<tr>
					<th align="center" colspan="8" background="<%=basePath%>Pictures/newmenubg.gif" height="30">
						<font color="#FFFFFF">毕业去向统计</font>
					</th>
				</tr>
				<tr>
				<th>
						序号
					</th>
					<th>
						班级
					</th>
					<th>
						总人数
					</th>
					<th>
						工作人数
					</th>
					<th>
						考研人数
					</th>
					<th>
						出国人数
					</th>

				</tr>
				<s:iterator value="listClassInfo" status="status">
				   <tr>
				     <td align="center"><s:property value="#status.count"/></td>
				     <td align="center"><s:property value="FClassNumber"/></td>
				     <td align="center"><s:property value="FClassTotalNum"/></td>
				     <td align="center"><s:property value="FClassWorkNum"/></td>
				     <td align="center"><s:property value="FClassKaoYanNum"/></td>
				     <td align="center"><s:property value="FClassAbroadNum"/></td>
				     
				   </tr>
			</s:iterator>
				
			</table>
	
			<table width="200">
				<tr>
					<td>
						<a href="ChecklistInfo.jsp">首页</a>
					</td>
					<td>
						<a href="ChecklistInfo.jsp">上一页</a>
					</td>
					<td>
						<a href="ChecklistInfo.jsp">下一页</a>
					</td>
					<td>
						<a href="ChecklistInfo.jsp">末页</a>
					</td>
				</tr>
			</table>

			<br>
		</div>

	</body>
</html>
