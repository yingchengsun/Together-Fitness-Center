<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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


  </head>
  
  <body>
   <br>
		<br>
		<c:choose>
		<c:when test="${isempty=='1'}">
			<h3 align="center">
			该设备无调拨记录
		    </h3>
		    <table align="center" width="700">
			<tr>
				<th align="center">
					<a href="5_sjjx_system/EquipManage/AddEquipDetailByHand.jsp?equipId=${equipId }&&labId=${ labId}">调拨该设备</a>
				</th>
			</tr>
			<table align="center" width="700">
			<tr>
				<th align="center">
					<a href="showallEquip.action">返回</a>
				</th>
			</tr>
		    </table>
		</c:when>
		<c:otherwise>
		<br/>
		<h3 align="center">设备详细信息</h3>
		<table align="center" width="700">
			<tr>
				<th align="left"><a href="showallEquip.action"><img src="5_sjjx_system/Pictures/return.gif" align="top" border="0"/>返回</a></th>
			</tr>
		</table> 
		<hr>
		<div align="center">
			<table border="0" width="700" id="mytable">
				<tr>
					<th colspan="7" background="5_sjjx_system/Pictures/newmenubg.gif" height="30">
						<font color="#FFFFFF">设备信息</font>
					</th>
				</tr>
				<tr>
					<th>
						设备编号
					</th>
					<th>
						调拨时间
					</th>
					<th>
						原实验室编号
					</th>
					<th>
						使用状态
					</th>
					<th>
					           报废时间
					</th>
					<th>
						报废原因
					</th>
					<th>
				                    调拨设备
					</th>
				</tr>				
				<c:forEach items="${equipDetailList}" var="equipDetail">
				  <tr>
					<td>
					    ${equipDetail.sjjxTabEquipment.FEquId}
					</td>
					<td>
					     <fmt:formatDate value="${equipDetail.FEquMoveTime }" type="date" pattern="yyyy-MM-dd"/>
					</td>
					<td>
					     ${equipDetail.FExLabId }
					</td>
					<td>
					     ${equipDetail.FBaoFei }
					</td>
					<td>
					     ${equipDetail.FEquBreakTime }
					</td>
					<td>
					     <fmt:formatDate value="${equipDetail.FEquBreakReason}" type="date"/>
					</td>
					<td>
					   <a href="preUpdateEquipDetail.action?equip_id=${equipDetail.sjjxTabEquipment.FEquId }"><img src="5_sjjx_system/Pictures/edit.gif" align="middle" border="0"/>调拨设备</a>
					</td>
				  </tr>
				  </c:forEach>
				
			</table>
			</div>
			</c:otherwise>
			</c:choose>
		<br>
  </body>
</html>
