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
		<title>友情链接管理</title>
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
			友情链接管理
		</h3>
		<hr size="0.5">
		<div align="center">
			<table border="0" width="700">
				<tr>
					<td valign="bottom">
						<form
							action="link!listByTitle.action"
							method="post">
							<font size="2">按标题查找</font>
							<input type="text" name="FLinkTitle" />
							<input type="submit" value="搜索">
						</form>
					</td>
			
					<td align="center">
						<a href="1_mhqx/admin/Link/LinkAdd.jsp"><font size="2">添加友情链接</font> </a>
					</td>
				</tr>
			</table>
		</div>
		<div align="center">
          <form action="link!deleteAll.action"
							method="post">
			<table border="0" id="mytable" width="700">
				<tr>
					<th align="center" colspan="8"
						background="<%=basePath%>1_mhqx/admin/images/newmenubg.gif"
						height="30">
						<font color="#FFFFFF">友情链接 </font>
					</th>
				</tr>
				<tr>
					<th >
						序号
					</th>
					<th >
						名称
					</th>
					<th>
						链接地址
					</th>
					<th>
						优先级
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
				<s:iterator value="linkList" status="status">
					<tr>
						<td align="center">
							<s:property value="#status.count" />
						</td>
						
						<td align="center">
								<s:property value="FLinkTitle" />
						</td>
						<td align="center">
							<s:property value="FLinkUrl" />
						</td>
						<td align="center">
							<s:property value="FLinkPriority" />
						</td>
						<td align="center">
							<a
								href="link!preUpdate.action?FLinkId=<s:property value="FLinkId"/>">编辑</a>

						</td>
						<td align="center">
							<a
								href="link!delete.action?FLinkId=<s:property value="FLinkId"/>" onclick="javascript:return p_del()">删除</a>

						</td>
						<td align="center">
							<input name="check" type="checkbox" value="<s:property value="FLinkId"/>">
						</td>

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
					<td width="26%" align="right">
						<a href="<%=request.getContextPath()%>/link!listAll.action?p=1">首页</a>
					</td>
					<td width="6%" align="center">
						<a href="<%=request.getContextPath()%>/link!listAll.action?p=${p-1}">上一页</a>
					</td>
					<td width="6%" align="center">
						<a href="<%=request.getContextPath()%>/link!listAll.action?p=${p+1}">下一页</a>
					</td>
					<td align="left">
						<a href="<%=request.getContextPath()%>/link!listAll.action?p=${lastPage}">末页</a>
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
