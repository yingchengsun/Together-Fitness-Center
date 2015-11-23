<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" errorPage="/errorPage.jsp"%>
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
		<title>快速导航管理</title>
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
			快速导航管理
		</h3>
		<hr size="0.5">
		<div align="center">
		
			<table border="0" width="800">
				<tr>
					<td valign="bottom">
						<form
							action="navigation!listByName.action"
							method="post">
							<font size="2">按标题查找</font>
							<input type="text" name="FNavigationName" />
							<input type="submit" value="搜索">
						</form>
					</td>
				
					<td align="center">
						<a href="1_mhqx/admin/Navigation/NavigationAdd.jsp"><font size="2">添加快速导航</font> </a>
					</td>
				</tr>
			</table>
		</div>
		<div align="center">
          <form action="navigation!deleteAll.action"
							method="post">
			<table border="0" id="mytable" width="800">
				<tr>
					<th align="center" colspan="8"
						background="<%=basePath%>1_mhqx/admin/images/newmenubg.gif"
						height="30">
						<font color="#FFFFFF">快速导航 </font>
					</th>
				</tr>
				<tr>
					<th width=40px>
						序号
					</th>
					<th width=80px>
						名称
					</th>
					<th width=120px>
						图片链接地址
					</th>
					<th width=120px>
						导航链接地址
					</th>
					<th width=100px>
						导航优先级
					</th>
					<th width=40px>
						编辑
					</th>
					<th width=40px>
						删除
					</th>
					<th width=40px>
						选择
					</th>

				</tr>
				<s:iterator value="navigationList" status="status">
					<tr>
						<td align="center">
							<s:property value="#status.count" />
						</td>
						
						<td align="center">
								<s:property value="FNavigationName" />
						</td>
						<td align="center">
							<s:property value="FNavigationPicUrl" />
						</td>
						<td align="center">
							<s:property value="FNavigationUrl" />
						</td>
						<td align="center">
							<s:property value="FNavigationPriority" />
						</td>
						<td align="center">
							<a
								href="navigation!preUpdate.action?FNavigationId=<s:property value="FNavigationId"/>">编辑</a>

						</td>
						<td align="center">
							<a
								href="navigation!delete.action?FNavigationId=<s:property value="FNavigationId"/>">删除</a>

						</td>
						<td align="center">
							<input name="check" type="checkbox" value="<s:property value="FNavigationId"/>">
						</td>

					</tr>
				</s:iterator>

			</table>

			<table width="800">
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
					<td width="26%" align="right">
						<a href="<%=request.getContextPath()%>/navigation!listAll.action?p=1">首页</a>
					</td>
					<td width="6%" align="center">
						<a href="<%=request.getContextPath()%>/navigation!listAll.action?p=${p-1}">上一页</a>
					</td>
					<td width="6%" align="center">
						<a href="<%=request.getContextPath()%>/navigation!listAll.action?p=${p+1}">下一页</a>
					</td>
					<td align="left">
						<a href="<%=request.getContextPath()%>/navigation!listAll.action?p=${lastPage}">末页</a>
					</td>
					<td align="left">
					       共${lastPage }页
					</td>
				</tr>
			</table>
            </form>
			<br>
		</div>

	</body>
</html>
