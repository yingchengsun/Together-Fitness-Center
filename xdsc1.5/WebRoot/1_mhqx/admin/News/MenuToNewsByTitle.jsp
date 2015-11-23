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
		<title>查找结果</title>
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
			查找结果
		</h3>
		<hr size="0.5">
		<div align="center">
			<table border="0" width="700">
				<tr>
					<td valign="bottom">
						<form
							action="information!showNewsByTitle.action"
							method="post">
							<font size="2">按标题查找</font>
							<input type="text" name="FInfoTitle" />
							<input type="submit" value="搜索">
						</form>
					</td>
					<td align="right" valign="middle">
						<a href="1_mhqx/admin/News/AdvanceSearch.jsp"><font size="2">高级查找</font> </a>
					</td>
					<td align="center">
						<a href="1_mhqx/admin/News/NewsAdd.jsp?FMenuName=<s:property value="FMenuName" />"><font size="2">添加新闻</font> </a>
					</td>
				</tr>
			</table>
		</div>
		<div align="center">

			<table border="0" id="mytable" width="700">
				<tr>
					<th align="center" colspan="9"
						background="<%=basePath%>1_mhqx/admin/images/newmenubg.gif"
						height="30">
						<font color="#FFFFFF"><s:property value="FMenuName" /> </font>
					</th>
				</tr>
				<tr>
					<th>
						序号
					</th>
					<th>
						标题
					</th>
					<th>
						发布时间
					</th>
					<th>
						是否置顶
					</th>
					<th>
						是否最新
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
				<s:iterator value="menuInfoList" status="status">
					<tr>
						<td align="center">
							<s:property value="#status.count" />
						</td>
						<td align="center">
							<s:property value="FInfoTitle" />
						</td>
						<td align="center">
							<fmt:formatDate value="${FInfoStartTime}" type="both" />
						</td>
						<td align="center">
							<s:property value="FInfoZhiDing" />
						</td>
						<td align="center">
						
							<s:if test="FInfoZuiXin==1">
							Y
							</s:if>
							<s:if test="FInfoZuiXin!=1">
							N
							</s:if>
						</td>
						<td align="center">
							<a
								href="information!updateInformationRedirect.action?FInfoId=<s:property value="FInfoId"/>">编辑</a>

						</td>
						<td align="center">
							<a
								href="information!deleteInformation.action?FInfoId=<s:property value="FInfoId"/>">删除</a>

						</td>
						<td align="center">
							<input type="checkbox">
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
						<a href="">首页</a>
					</td>
					<td width="6%" align="center">
						<a href="">上一页</a>
					</td>
					<td width="6%" align="center">
						<a href="">下一页</a>
					</td>
					<td align="left">
						<a href="">末页</a>
					</td>
				</tr>
			</table>

			<br>
		</div>

	</body>
</html>
