<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" errorPage="/errorPage.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="/struts-tags" prefix="s"%>

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
		<div align="center">
			<table border="0" width="600">
				<tr>
					<td align="right">
						<a href="menu!menuAddRedirect.action"><font size="2">添加菜单</font>
						</a>
					</td>
				</tr>
			</table>
		</div>
		<div align="center">

			<table border="0" id="mytable" width="700">
				<tr>
					<th align="center" colspan="8"
						background="<%=basePath%>1_mhqx/admin/images/newmenubg.gif"
						height="30">
						<font color="#FFFFFF">菜单管理</font>
					</th>
				</tr>
				<tr>
					<th width="10%">
						ID
					</th>
					<th width="20%">
						标题
					</th>
					<th width="10%">
						父ID
					</th>
					<th width="10%">
						优先级
					</th>
					<th width="15%">
						层级级别
					</th>
					<th>
						编辑
					</th>
					<th>
						删除
					</th>
					<th>
						选择
					</th>

				</tr>
				<!--一二三级菜单循环读取 -->

				<s:iterator value="firstList" status="fl">
					<tr>
						<td align="center">
							<s:property value="FMenuId" />
						</td>
						<td align="center">
							<s:property value="FMenuName" />
						</td>
						<td align="center">
							<s:property value="FSuperMenuId" />
						</td>
						<td align="center">
							<s:property value="FMenuPriority" />
						</td>
						<td align="center">
							一级
						</td>
						<td align="center">
							<a
								href="menu!menuUpdateRedirect.action?FMenuId=<s:property value="FMenuId"/>">编辑</a>
						</td>
						<td align="center">
							<a
								href="menu!menuDelete.action?FMenuId=<s:property value="FMenuId"/>">删除</a>
						</td>
						<td align="center">
							<input type="checkbox">
						</td>
						<s:iterator value="subList[#fl.index]" status="sl">
							<tr>
								<td align="center">
									<s:property value="FMenuId" />
								</td>
								<td align="center">
									<s:property value="FMenuName" />
								</td>
								<td align="center">
									<s:property value="FSuperMenuId" />
								</td>
								<td align="center">
									<s:property value="FMenuPriority" />
								</td>
								<td align="center">
									二级
								</td>
								<td align="center">
									<a
										href="menu!menuUpdateRedirect.action?FMenuId=<s:property value="FMenuId"/>">编辑</a>
								</td>
								<td align="center">
									<a
										href="menu!menuDelete.action?FMenuId=<s:property value="FMenuId"/>">删除</a>
								</td>
								<td align="center">
									<input type="checkbox">
								</td>
								<s:iterator value="thirdList[#fl.index][#sl.index]">
									<tr>
										<td align="center">
											<s:property value="FMenuId" />
										</td>
										<td align="center">
											<s:property value="FMenuName" />
										</td>
										<td align="center">
											<s:property value="FSuperMenuId" />
										</td>
										<td align="center">
											<s:property value="FMenuPriority" />
										</td>
										<td align="center">
											三级
										</td>
										<td align="center">
											<a
												href="menu!menuUpdateRedirect.action?FMenuId=<s:property value="FMenuId"/>">编辑</a>
										</td>
										<td align="center">
											<a
												href="menu!menuDelete.action?FMenuId=<s:property value="FMenuId"/>">删除</a>
										</td>
										<td align="center">
											<input type="checkbox">
										</td>
									</tr>
								</s:iterator>
							</tr>
						</s:iterator>
					</tr>
				</s:iterator>
			</table>

			<table width="700">
				<tr>
					<td width="5%">
						<input type="button" value="全选" onclick="selectAll()" />
					</td>

					<td width="5%">
						<input type="button" value="反选" onclick="unSelectAll()" />
					</td>
					<td width="5%">
						<input type="submit" value="删除" />
					</td>

				</tr>
			</table>

			<br>
		</div>

	</body>
</html>
