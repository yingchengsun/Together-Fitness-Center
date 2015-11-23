<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>添加其他学生信息</title>
		<base href="<%=basePath%>">
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">

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
		<h3 align="center"><img src="<%=basePath%>Pictures/submittutorial_001.png" align="top" border="0" width="50" height="50"/>添加其他去向学生信息</h3>
		<table align="center" width="700">
			<tr>
				<th align="left"><a href="<%=basePath%>admin/OtherInfo!findAllOtherInfo.action"><img src="<%=basePath%>Pictures/return.gif" align="top" border="0"/>返回</a></th>
			</tr>
		</table> 
		<hr>
		<div align="center">
			<form action="admin/OtherInfo!addOtherInfo.action" method="post">
				<table border="1" width="700">
					<tr>
						<th height="30" colspan="2" align="center" background="<%=basePath%>Pictures/newmenubg.gif">
							<font color="#FFFFFF">添加学生信息</font>
						</th>
					</tr>
					<tr>
						<td>
							学号：
						</td>
						<td>
							<input type="text" name="FStudentNumber"  /><a href="<%=basePath%>admin2/StudentInfo!findAllStudentInfo.action">
							<img src="<%=basePath%>Pictures/userinfo.gif" align="middle" border="0">查看学生ID表</a>
						</td>
					</tr>
					
					<tr>
						<td>
							毕业记录:
						</td>
						<td>
							<input type="text" name="FRecord"  />
						</td>
					</tr>

					
					<tr>
						<td>
						电子邮件：
						</td>
						<td>
							<input type="text" name="FEmail" />
						</td>
					</tr>
					<tr>
						<td>
						去向变更：
						</td>
						<td>
							<input type="text" name="FWorkAdd" />
						</td>
					</tr>
					<tr>
						<td align="center" colspan="2">
							<input type="submit" value="添加" />
							<input type="reset" value="重置" />
						</td>
					</tr>
				</table>
			</form>
			<br>
			
			
		</div>
		<br>
		<br>
	</body>
</html>
