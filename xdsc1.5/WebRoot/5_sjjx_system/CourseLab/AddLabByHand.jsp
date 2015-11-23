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
		<script type="text/javascript">
			function check(number){
				if(isNaN(number))
				{
					window.alert("输入有误，请重新填写");
				}
			}
		</script>

	</head>

	<body>
		<br>
		<br>
		<h3 align="center">添加新实验室</h3>
		<table align="center" width="700">
			<tr>
				<th align="left"><a href="showLab.action"><img src="5_sjjx_system/Pictures/return.gif" align="top" border="0"/>返回</a></th>
			</tr>
		</table> 
		<hr>
		<div align="center">
			<form action="addLabInfo.action" method="post">
				<table border="1" width="700">
					<tr>
						<th height="30" colspan="2" align="center" background="5_sjjx_system/Pictures/newmenubg.gif">
							<font color="#FFFFFF">填写实验室信息</font>
						</th>
					</tr>
					<tr>
						<td>
							实验室名称：
						</td>
						<td>
							<input type="text" name="FLabName" size="60"/>
						</td>
					</tr>
					<tr>
						<td>
							所在校区：
						</td>
						<td>
						   <input type="radio" name="XiaoQu" value="0" checked="checked">
							北校区
							<input type="radio" name="XiaoQu" value="1">
							南校区
						</td>
					</tr>
					<tr>
						<td>
							房间编号：
						</td>
						<td>
							<input type="text" name="FRoomNumber"  size="60"/>
						</td>
					</tr>
					<tr>
						<td>
							座位数：
						</td>
						<td>
							<input onkeyup="check(this.value)" type="text" name="FSeatNumber"  size="60"/>
								
						</td>
					</tr>
					<tr>
						<td>
							
							<input type="reset" value="重置" />
						</td>
						<td>
							<input type="submit" value="提交" />
						</td>
					</tr>
				</table>
			</form>
		</div>
		<br>
	</body>
</html>
