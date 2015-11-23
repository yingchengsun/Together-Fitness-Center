<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"errorPage="/errorPage.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>编辑友情链接</title>
		<base href="<%=basePath%>">
		<link rel="stylesheet" type="text/css" href="<%=basePath%>css.css">
	<style type="text/css">
	body {
		font-family: arial, 宋体, serif;
		font-size: 12px;
		background-image:
			url("<%=basePath%>1_mhqx/admin/images/newbackground.png");
	}
	
	</style>
		<script language="javascript"
			src="<%=basePath%>1_mhqx/admin/js/TableColor.js"></script>
		<script language="javascript"
			src="<%=basePath%>1_mhqx/admin/js/SelectAll.js"></script>
	</head>


	<body>
		<br>
		<br>
		<h3 align="center">
			更新友情链接
		</h3>
		<table align="center" width="700">
			<tr>
				<th align="left">
					<a href="link!listAll.action?location=right" ><img
							src="<%=request.getContextPath()%>/1_mhqx/admin/images/return.gif"
							align="top" border="0" />返回</a>
				</th>
			</tr>
		</table>
		<hr>
		<div align="center">
			<form action="link!update.action" 
				method="post">
				<table width="700" border="0" id="mytable">
					<tr>
						<th colspan="2"
							background="<%=request.getContextPath()%>/1_mhqx/admin/images/bluebar.gif"
							height="30">
							<font color="#FFFFFF">友情链接更新</font>
						</th>
					</tr>
					<tr>
						<th>
							
						</th>
						<td>
							<input type="hidden" name="FLinkId" value="${l.FLinkId }">
						</td>
					</tr>
					<tr>
						<th>
							友情链接名称
						</th>
						<td>
							<input type="text" name="FLinkTitle"
								value="${l.FLinkTitle }">
						</td>
					</tr>
					<tr>
						<th>
					                友情链接地址
						</th>
						<td>
							<input  type="text" name="FLinkUrl" value="${l.FLinkUrl }"/>
						</td>
					</tr>
					<tr>
						<th>
							链接优先级
						</th>
						<td>
							<input type="text" name="FLinkPriority"  value="${l.FLinkPriority }"/>
						</td>
					</tr>
					<tr>
						<th>
							<input type="submit" value="更新">
						</th>
						<th>
							<input type="reset" value="重置">
						</th>
					</tr>
				</table>
			</form>
		</div>
	</body>
</html>
					