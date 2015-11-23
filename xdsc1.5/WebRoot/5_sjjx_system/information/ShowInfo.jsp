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
			系统未发布任何通知
		    </h3>
		    <table align="center" width="700">
			   <tr>
				  <th align="center">
					<a href="5_sjjx_system/information/AddInformation.jsp">添加新通知公告</a>
			   </tr>
		    </table>
			<br/>
		</c:when>
		<c:otherwise>
		<h3 align="center">
			系统发布通知
		</h3>
		<table align="center" width="700">
			<tr>
				<th align="right">
					<a href="5_sjjx_system/information/AddInformation.jsp">添加新通知公告 
					</a>
				</th>
			</tr>
		</table>
		<hr>
		<div align="center">
		
			<table border="0" width="700" id="mytable">
				<tr>
					<th colspan="10" background="5_sjjx_system/Pictures/newmenubg.gif" height="30">
						<font color="#FFFFFF">全部信息</font>
					</th>
				</tr>
				<tr>
					<th>
						序号
					</th>
					<th>
						通知公告名称
					</th>
					<th>
						发布时间
					</th>
					<th>
						审核状态
					</th>
					<th>
						详细内容
					</th>
					<th>
						编辑
					</th>
					<th>
						删除
					</th>
				</tr>
				<c:forEach items="${tzggList }" var="tzggInfo">
				<tr>
					<td>
						${tzggInfo.FInfoId }
					</td>				
					<td>
						${tzggInfo.FInfoTitle }
					</td>
					<td>
						<fmt:formatDate value="${tzggInfo.FInfoStartTime}" type="date" pattern="yyyy-MM-dd"/>
					</td>
					<td>
						${tzggInfo.FBiaoZhi }
					</td>
					<td>
					 <a href="showTZGGInfoDetail1.action?infoId=${tzggInfo.FInfoId }">查看</a>
					 </td>
					<td>
					  <a href="preUpdateTZGGInfo.action?infoId=${tzggInfo.FInfoId }"><img src="5_sjjx_system/Pictures/edit.gif" align="top" border="0"/></a>
					</td>
					<td>
						<a href="deleteTZGGInfo.action?infoId=${tzggInfo.FInfoId }">删除</a>
					</td>
				</tr>
				</c:forEach>
			</table>
			<table width="40%">
				<tr>
					<td>
						<div align="center">
							<a href="previousI.action">上一页</a>
						</div>
					</td>
					<td>
						<div align="center">
							<a href="nextI.action">下一页</a>
						</div>
					</td>
					<td>
						共${tzggAll.pageCount }页，当前第${tzggAll.page+1 }页
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
