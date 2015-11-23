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
		<script language="javascript" src="5_sjjx_system/JS/TableColor.js"></script>
	</head>

	<body>
	
		<br>
		<c:choose>
		<c:when test="${isempty=='1'}">
			<h3 align="center">
			    无任何实验室信息
		    </h3>
			<br/>
		</c:when>
		<c:otherwise>
		<h3 align="center">
			实验室信息
		</h3>
		
		<hr>
		<div align="center">
			<table border="0" width="700" id="mytable">
				<tr>
					<th colspan="6" background="5_sjjx_system/Pictures/newmenubg.gif" height="30">
						<font color="#FFFFFF">实验室信息</font>
					</th>
				</tr>
				<tr>
					<th>
						实验室编号
					</th>
					<th>
						实验室名称
					</th>
					<th>
						实验室机位
					</th>
					<th>
						校区
					</th>
					<th>
					    房间号
					</th>
					<th>
						实验安排
					</th>
				</tr>
				<c:forEach items="${labList }" var="lab">
				<tr>				
					<td>
						${lab.FLabId }
					</td>
					<td>
						${lab.FLabName }
					</td>
					<td>
						${lab.FSeatNumber }
					</td>
					<td>
						${lab.FLabLocation }
					</td>
					<td>
						${lab.FRoomNumber }
					</td>
					<td>
						<a href="showCourseLab4.action?lab_id=${lab.FLabId }">详细</a>
					</td>
				</tr>
				</c:forEach>
			</table>
			<table width="40%">
				<tr>
					<td>
						<div align="center">
							<a href="previous1.action">上一页</a>
						</div>
					</td>
					<td>
						<div align="center">
							<a href="next1.action">下一页</a>
						</div>
					</td>
					<td>
						共${LabAll.pageCount }页，当前第${LabAll.page+1 }页
					</td>
				</tr>
			</table>
		</div>
		</c:otherwise>
		</c:choose>
		<br>
		<br>
		<br>
	</body>
</html>
