<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
		excel表格未导入成功，请核对信息格式重新导入！	
	</h3>
	<table align="center" width="700">
			<tr>
				<th align="left"><a href="showAllCourseLab.action"><img src="5_sjjx_system/Pictures/return.gif" align="top" border="0"/>返回</a></th>
			</tr>
	</table>
	<div align="center">
			<form action="excelInCourseLab.action"  enctype="multipart/form-data" method="post">
				<table width="700" border="1">
					<tr>
						<th colspan="2" align="center" background="5_sjjx_system/Pictures/newmenubg.gif" height="30">
							<img src="5_sjjx_system/Pictures/excel.bmp" border="0" align="top" />
							<font color="#FFFFFF">重&nbsp;新&nbsp;导&nbsp;入</font>
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
							<a href="5_sjjx_system/Down/Schedular.xls">模板下载</a>
						</td>
						<td align="center">
							<input type="submit" value="上传">
							<input type="reset" value="取消">
						</td>
					</tr>
				</table>
			</form>
		</div>
  </body>
</html>
