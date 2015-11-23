<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
			无设备类型记录
		    </h3>
		    <table align="center" width="700">
			   <tr>
				  <th align="center">
					<a href="5_sjjx_system/EquipManage/AddEquip.jsp">添加新设备类型</a>
			   </tr>
		    </table>
			<br/>
		</c:when>
		<c:otherwise>
      <h3 align="center">
			全部设备类型
	  </h3>
	  <table align="center" width="700">
			<tr>
				<th align="left"><a href="showallEquip.action"><img 
					             src="5_sjjx_system/Pictures/return.gif" align="top" border="0" />返回</a></th>
			</tr>
		</table> 
	  <hr>
		<div align="center">
			<table border="0" width="700" id="mytable">
				<tr>
					<th colspan="8" background="5_sjjx_system/Pictures/newmenubg.gif" height="30">
						<font color="#FFFFFF">设备类型信息</font>
					</th>
				</tr>
				<tr>
					<th>
						设备类型编号
					</th>
					<th>
						设备类型名称
					</th>
				</tr>				
				<c:forEach items="${EquipTypeList }" var="equipType">
				  <tr>
					<td>
					    ${equipType.FEquTypeId }
					</td>
					<td>
					    ${equipType.FEquTypeName }
					</td>
					<td>
					    <a href="deleteEquipType.action?equipTypeId=${equipType.FEquTypeId }">删除</a>
					</td>
				  </tr>
				</c:forEach>
			</table>
			<table width="40%">
				<tr>
					<td>
						<div align="center">
							<a href="previousEY.action">上一页</a>
						</div>
					</td>
					<td>
						<div align="center">
							<a href="nextEY.action">下一页</a>
						</div>
					</td>
					<td>
						共${EquipTypeAll.pageCount }页，当前第${EquipTypeAll.page+1 }页
					</td>
				</tr>
			</table>
		</div>
		</c:otherwise>
		</c:choose>
		<br>
   
   
  </body>
</html>
