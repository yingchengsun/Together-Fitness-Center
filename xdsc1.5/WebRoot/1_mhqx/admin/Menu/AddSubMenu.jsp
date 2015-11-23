<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	errorPage="/errorPage.jsp"%>
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
		<title>菜单操作</title>
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
	<script type="text/javascript" language="javascript">
	</script>
	<body>
		<br>
		<h3 align="center">
			<s:property value="CurrentMenu.FMenuName" />维护
		</h3>
		<hr size="0.5">
		<div align=center>
			<a
				href="<%=request.getContextPath()%>/1_mhqx/admin/Menu/HTMenuList.jsp"><img
					src="<%=request.getContextPath()%>/1_mhqx/admin/images/return.gif"
					align="top" border="0" />返回查询页面</a>
		</div>
		<div align="center">
			<table border="0" width="700">
				<tr>
					<td>
						<s:if test="IsShouYe!=1">
							<form action="HTMenu!changeName.action" method="post">
								<font size=2 color=royalblue>修改菜单名称 :</font>&nbsp
								<input type="text" name="name"
									value="<s:property value="CurrentMenu.FMenuName"/>"></input>
								<input type="submit" name="submit" value="提交">
							</form>
						</s:if>
					</td>
				</tr>
			</table>
			<table border="0" width="700">
				<tr>
					<td valign="top" width="25%">
						<s:if test="IsShouYe!=1">
						<img src="<%=basePath%>/images/go.gif" style="visibility: hidden">
						&nbsp
						<a href="HTMenu!menuManager.action">调整优先级</a>
						</s:if>
					</td>
					<td valign="top" width="25%">
						<s:if test="!Leaf">
							<img src="<%=basePath%>/images/go.gif"
								style="visibility: visible">
						&nbsp
						<a href="HTMenu!preaddMenu.action">插入子菜单</a>
						</s:if>
					</td>
					<td valign="top" width="25%">
						<s:if test="!Leaf">
							<img src="<%=basePath%>/images/go.gif" style="visibility: hidden">
						&nbsp
						<a href="HTMenu!predelete.action">删除子菜单</a>
						</s:if>
					</td>
					<td valign="top" width="25%">
						<s:if test="!Leaf">
						<img src="<%=basePath%>/images/go.gif" style="visibility: hidden">
						&nbsp
						<a href="HTMenu!subMenuList.action">查看子菜单</a>
						</s:if>
					</td>
				</tr>

			</table>
		</div>

		<hr size="0.5">
		<div align="center">
			<table border="0" width="700">

				<tr>
					<td width=100% bgcolor=royalblue>
						<div align="center" style="color: white">
							<font size=2 color=#ffffff>当前菜单 ：&nbsp</font>

							<span> <font size=2 color=#ffffff> 
										<s:property value="CurrentMenu.FMenuName" /> </font> </span>
						</div>
					</td>
				</tr>
				<tr>
					<td align="center">
						<form action="HTMenu!addMenu.action" method="post">
							<table border="0" width="100%">
								<tr>
									<th>
										子菜单名称
									</th>
									<th>
										是否为叶子节点
									</th>
								</tr>
								<tr>
									<td align="center">
										<input type="text" name="name" />
									</td>
									<td align="center">
										<select name="IsLeaf">
											<option value="1">
												是
											</option>
											<option value="0">
												不是
											</option>
										</select>
									</td>

								</tr>
								<tr>
									<td align="center">
										<input type="submit" name="submit" value="提交" />
									</td>
								</tr>
							</table>
						</form>
					</td>
				</tr>
			</table>

		</div>

	</body>
</html>
