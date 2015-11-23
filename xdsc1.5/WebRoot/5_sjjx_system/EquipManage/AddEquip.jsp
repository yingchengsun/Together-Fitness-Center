<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
	    <base href="<%=basePath%>">
		<link rel="stylesheet" type="text/css" href="css.css">
		<link rel="stylesheet" type="text/css" href="5_sjjx_system/mycss.css">
	</head>

	<body>
		<br>
		<h3 align="center">
			添加设备类型信息
		</h3>
		<hr>
		<table align="center" width="700">
			<tr>
				<th align="right">
					<a href="5_sjjx_system/EquipManage/AddEquipTypeByHand.jsp"><img
								src="5_sjjx_system/Pictures/foward.png" align="top" border="0" />手动添加 
					</a>
				</th>
			</tr>
		</table>
		<div align="center">
			<form action="<%=path %>/excelInEquType.action" enctype="multipart/form-data" method="post">
				<table width="700" border="1">
					<tr>
						<th colspan="2" align="center" background="5_sjjx_system/Pictures/newmenubg.gif" height="30">
							<img src="5_sjjx_system/Pictures/excel.bmp" border="0" align="top" />
							<font color="#FFFFFF">批量导入设备类型信息</font>
						</th>
					</tr>
					<tr>
						<td>
							选择文件：
						</td>
						<td>
							<input type="file" size="40" name="file">
						</td>
					</tr>
					<tr>
						<td align="center">
							<a href="5_sjjx_system/Down/AddEquipType.xls">模版下载</a>
						</td>
						<td align="center">
							<input type="submit" value="上传">
							<input type="reset" value="取消">
						</td>
					</tr>
				</table>
			</form>
		</div>
		<h3 align="center">
			添加设备信息
		</h3>
		<hr>
		<div align="center">
			<form action="<%=path %>/excelInEquipment.action" enctype="multipart/form-data" method="post">
				<table width="700" border="1">
					<tr>
						<th colspan="2" align="center" background="5_sjjx_system/Pictures/newmenubg.gif" height="30">
							<img src="5_sjjx_system/Pictures/excel.bmp" border="0" align="top" />
							<font color="#FFFFFF">批量导入设备信息</font>
						</th>
					</tr>
					<tr>
						<td>
							选择文件：
						</td>
						<td>
							<input type="file" name="file" size="40">
						</td>
					</tr>
					<tr>
						<td align="center">
							<a href="5_sjjx_system/Down/AddEquip.xls">模版下载</a>
						</td>
						<td align="center">
							<input type="submit" value="上传">
							<input type="reset" value="取消">
						</td>
					</tr>
				</table>
			</form>
		</div>
<br>
		
	<br>	
		
	</body>
</html>
