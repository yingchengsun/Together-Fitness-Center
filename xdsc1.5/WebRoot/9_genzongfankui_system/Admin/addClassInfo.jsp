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
		<title>添加班级信息</title>
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
		<h3 align="center"><img src="<%=basePath%>Pictures/submittutorial_001.png" align="top" border="0" width="50" height="50"/>添加班级基本信息</h3>
		<table align="center" width="700">
			<tr>
				<th align="left"><a href="<%=basePath%>admin/ClassInfo!findAllClassInfo.action"  ><img src="<%=basePath%>Pictures/return.gif" align="top" border="0"/>返回</a></th>
			</tr>
		</table> 
		<hr>
		<div align="center">
			<form action="admin/ClassInfo!addClassInfo.action" method="post">
				<table border="1" width="700">
					<tr>
						<th height="30" colspan="2" align="center" background="<%=basePath%>Pictures/newmenubg.gif">
							<font color="#FFFFFF">软件学院班级信息</font>
						</th>
					</tr>
					<tr>
						<td>
							班级：
						</td>
						<td>
							<input type="text" name="FClassNumber"  />
						</td>
					</tr>
					
					<tr>
						<td>
							总人数：
						</td>
						<td>
							<input type="text" name="FClassTotalNum"  />
						</td>
					</tr>
					<tr>
						<td>
							男生人数：
						</td>
						<td>
							<input type="text" name="FClassMaleNum"  />
						</td>
					</tr>
					<tr>
						<td>
							女生人数:
						</td>
						<td>
							<input type="text" name="FClassFemaleNum"  />
						</td>
					</tr>
							<tr>
						<td>
							工作人数：
						</td>
						<td>
							<input type="text" name="FClassWorkNum"  />
						</td>
					</tr>
					<tr>
						<td>
							读研/博人数：
						</td>
						<td>
							<input type="text" name="FClassKaoYanNum"  />
						</td>
					</tr>
					<tr>
						<td>
							出国人数：
						</td>
						<td>
							<input type="text" name="FClassAbroadNum"  />
						</td>
					</tr>
					<tr>
						<td>
							其他人数：
						</td>
						<td>
							<input type="text" name="FClassOtherNum"  />
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
