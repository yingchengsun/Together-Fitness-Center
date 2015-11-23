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
		<c:when test="${isempty=='3'}">
			<h3 align="center">
			目前还无任何设备信息
		    </h3>
		    <table align="center" width="700">
			   <tr>
				  <th align="center">
					<a href="5_sjjx_system/EquipManage/AddEquip.jsp"><img
								src="5_sjjx_system/Pictures/return.gif" align="top" border="0" />添加设备 
					</a>
				  </th>
			   </tr>
		    </table>
		    <table align="center" width="700">
			<tr>
				<th align="right">
					<a href="showEquipType.action">查看全部设备类型 
					</a>
				</th>
			</tr>
		</table>
			<br/>
		</c:when>
		<c:otherwise>
		<h3 align="center">
			设备查询
		</h3>
		<table align="center" width="700">
			<tr>
				<th align="right">
					<a href="showEquipType.action">全部设备类型 
					</a>
				</th>
			</tr>
		</table>
		<hr>
		<div align="center">
					<form action="showTypeEquip.action">
						<font size="4">按设备类型查找</font>
						<select name="search_item">
						<c:forEach items="${list_type}" var="type">
							<option value="${type.FEquTypeId}">${type.FEquTypeName }</option>
						</c:forEach>
						</select>
						<input type="submit" value="查询">
					</form>		
		</div>
		<div align="center">
					<form action="showLabEquip.action">
						<font size="4">按实验室查找</font>
						<select name="search_item1">
						<c:forEach items="${list_lab}" var="lab">
						<option value="${lab.FLabId}">${lab.FLabName }</option>
							</c:forEach>
						</select>
						<input type="submit" value="查询">
					</form>		
		</div>
		<hr>
		<c:choose>
		<c:when test="${isempty=='1'}">
			<h3 align="center">
			该实验室无设备记录
		    </h3>
			<br/>
		</c:when>
		<c:when test="${isempty=='2'}">
			<h3 align="center">
			无该类型的设备记录
		    </h3>
			<br/>
		</c:when>
		<c:otherwise>
		<div align="center">
			<table align="center" width="800">
					<tr>
						<th align="right">
							<a href="<%=request.getContextPath()%>/exportEquipment.action"><img
									src="<%=request.getContextPath()%>/5_sjjx_system/Pictures/excel.bmp"
									align="top" border="0" />导出为Excel文件 </a>
						</th>
					</tr>
			</table>
			<table border="0" width="800" id="mytable">
				<tr>
					<th colspan="16" background="5_sjjx_system/Pictures/newmenubg.gif" height="30">
						<font color="#FFFFFF">设备信息</font>
					</th>
				</tr>
				<tr>
					
					<th>
						分类号
					</th>
					<th>
						设备类型
					</th>
					<th>
						设备编号
					</th>
					<th>
						设备名称
					</th>
					<th>
						设备品牌
					</th>
					<th>
						购买日期
					</th>
					<th>
						实验室编号
					</th>
					<th>
						详细信息
					</th>
					<th>
					           调拨记录
					</th>
					<th>
						删除信息
					</th>
				</tr>				
				<c:forEach items="${equiplist }" var="equip">
				  <tr>
					<td>
					    ${equip.FTypeId }
					</td>
					<td>
					    ${equip.sjjxTabEquipmenttype.FEquTypeName }
					</td>
					<td>
					    ${equip.FEquId }
					</td>
					<td>
					    ${equip.FEquName }
					</td>
					<td>
					    ${equip.FEquBrand }
					</td>
					<td>
					    <fmt:formatDate value="${equip.FEquBuyTime}" type="date" pattern="yyyy-MM-dd"/>
					</td>
					<td>
					    ${equip.sjjxTabLab.FLabId }
					</td>
					<td>
					  <a href="showEquipDetailInfo.action?id=${equip.FEquId }">详细</a>
					</td>
					<td>
					  <a href="showEquipDetail.action?equipid=${equip.FEquId }&&labId=${equip.sjjxTabLab.FLabId }">查看</a>
					</td>
					<td>
					    <a href="deleteEquip.action?id=${equip.FEquId }">删除</a>
					</td>
				  </tr>
				</c:forEach>
			</table>
			<table width="40%">
				<tr>
					<td>
						<div align="center">
							<a href="previousE.action">上一页</a>
						</div>
					</td>
					<td>
						<div align="center">
							<a href="nextE.action">下一页</a>
						</div>
					</td>
					<td>
						共${equipAll.pageCount }页，当前第${equipAll.page+1 }页
					</td>
				</tr>
			</table>
		</div>
	 </c:otherwise>
	</c:choose>
	</c:otherwise>
	</c:choose>
		<br>
		<br>
		<br>
	</body>
</html>
