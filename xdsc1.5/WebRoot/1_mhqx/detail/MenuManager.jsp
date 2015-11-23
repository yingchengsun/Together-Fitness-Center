<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
		<title>菜单管理</title>
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
		<h3 align="center">
			查找选择菜单
		</h3>
		<hr size="0.5">
		
		
		<div align="center">
			<table border="0" width="700">
				<tr>
					<td valign="bottom">
						<form
							action="HTMenu!searchMenu.action"
							method="post">
							<font size="2">按菜单名查找</font>
							<input type="text" name="FMenuName" />
							<input type="submit" value="搜索">
						</form>
					</td>
				</tr>
				<tr>
					<td>当前共有&nbsp<s:if test="searchCount==null">0</s:if><s:if test="searchCount!=null"><s:property value="searchCount"/></s:if>&nbsp个查找结果</td>
				</tr>
			</table>
		</div>
		<div align="center">
			<table border="0" id="mytable" width="700">
				<tr>
					<th align="center" colspan="8"
						background="<%=basePath%>1_mhqx/admin/images/newmenubg.gif"
						height="30">
						<font color="#FFFFFF">菜单管理 </font>
					</th>
				</tr>
				<tr>
					<th>
						序号
					</th>
					<th>
						菜单名称
					</th>
					<th>
						父菜单名称
					</th>
					<th>
						菜单优先级
					</th>		
				</tr>
				<s:iterator value="menulist" status="status">
					<tr>
						<td align="center">
							<s:property value="#status.count" />
						</td>
						<td align="center">
								<a href="HTMenu!menuManager.action?mid=<s:property value="FMenuId"/>" class="LINK21" style="color:blue;"><s:property value="FMenuName" /></a>
						</td>
						<td align="center">
						<a href="HTMenu!menuManager.action?mid=<s:property value="supermenulist.get(#status.count).FMenuId" />" class="LINK21" style="color:blue;"><s:property value="supermenulist.get(#status.count).FMenuName" /></a>
						</td>
						<td align="center">
							<s:property value="FMenuPriority" />
						</td>
					</tr>
				</s:iterator>
			</table>

			<table width="700">
				<tr>
					
				</tr>
			</table>
      
			<br>
		</div>

	</body>
</html>
