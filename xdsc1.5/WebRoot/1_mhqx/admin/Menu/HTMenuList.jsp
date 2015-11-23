<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" errorPage="/errorPage.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>菜单查询</title>
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
		<script language="javascript"
			src="<%=basePath%>1_mhqx/admin/js/ConfirmDeleteAll.js"></script>
	</head>

	<body>
		<br>
		<h3 align="center">
			菜单查询
		</h3>
		<hr size="0.5">
		<div align="center">
			<table border="0" width="700">
				<tr>
					<td valign="bottom">
					
						<form action="HTMenu!searchMenu.action" method="post">
							<font size=2 color=royalblue>查找菜单名称 :</font>&nbsp
							<input type="text" name="FMenuName"
								></input>
							<input type="submit" name="submit" value="提交">
						</form>
					
					</td>
					<td>
					  <a style="color:royalblue" href="HTMenu!menuManager.action?mid=0">
							首页一级菜单维护
					  </a>
					</td>
				</tr>
			</table>
		</div>
		
		
		
		<div align="center">
      
			<table border="0" id="mytable" width="700">
				<tr>
				
				当前查询 &nbsp <s:if test="searchCount==null">0</s:if><s:if test="searchCount!=null"><s:property value="searchCount"/></s:if> &nbsp  个结果
				</tr>
				<tr>
					<th align="center" colspan="8"
						background="<%=basePath%>1_mhqx/admin/images/newmenubg.gif"
						height="30">
					<font color="#FFFFFF">查询结果</font>
					</th>
				</tr>
				<tr>
					
					<th>
						菜单名称
					</th>
					<th>
						父菜单名称
					</th>
					<th>
						优先级
					</th>
				</tr>
					<tr>
						<td align="center">
						<a style="color:royalblue" href="HTMenu!menuManager.action?mid=<s:property value="CurrentMenu.FMenuId"/>" class="LINK21" /><s:property value="CurrentMenu.FMenuName"/></a>
						</td>
						<td align="center">
						<a style="color:royalblue" href="HTMenu!menuManager.action?mid=<s:property value="CurrentfatherMenu.FMenuId"/>" class="LINK21" /><s:property value="CurrentfatherMenu.FMenuName"/></a>
						</td>
						<td align="center">
							<s:property value="CurrentMenu.FMenuPriority" />
						</td>
					</tr>
		
			</table>
			<br>
		</div>

	</body>
</html>
