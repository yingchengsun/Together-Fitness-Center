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
		<c:choose>
		<c:when test="${exist=='1'}">
			<h3 align="center">
			  该设备类型已经存在，请重新填写信息
			</h3>

		    <table align="center" width="700">
			   <tr>
				<th align="left"><a href="showEquipType.action"><img src="5_sjjx_system/Pictures/return.gif" align="top" border="0"/>查看所有设备类型</a></th>
			   </tr>
		    </table> 
		   <hr>
		<div align="center">
			<form action="addEquipType.action" method="post">
				<table border="1" width="700">
					<tr>
						<th height="30" colspan="2" align="center" background="5_sjjx_system/Pictures/newmenubg.gif">
							<font color="#FFFFFF">重新填写设备类型信息</font>
						</th>
					</tr>
					<tr>
						<td>
							设备类型：
						</td>
						<td>
							<input type="text" name="FEquTypeName" value="${equipType.FEquTypeName }" size="60"/>
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
		
		</c:when>
		<c:otherwise>
		<h3 align="center">
			成功添加设备类型信息
		</h3>
		
		<table align="center" width="700">
			<tr>
				<th align="left"><a href="showEquipType.action"><img src="5_sjjx_system/Pictures/return.gif" align="top" border="0"/>查看所有设备类型</a></th>
			</tr>
		</table> 
		<hr>
		<div align="center">
			<form action="addEquipType.action" method="post">
				<table border="1" width="700">
					<tr>
						<th height="30" colspan="2" align="center" background="5_sjjx_system/Pictures/newmenubg.gif">
							<font color="#FFFFFF">继续设备类型信息</font>
						</th>
					</tr>
					<tr>
						<td>
							设备类型：
						</td>
						<td>
							<input type="text" name="FEquTypeName" value="${equipType.FEquTypeName }" size="60"/>
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
		
		</c:otherwise>
		</c:choose>
	</body>
</html>
