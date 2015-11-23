<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" errorPage="/errorPage.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
	<head>
		<title>新闻高级查找</title>
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
			&nbsp;
		</h3>
		<h3 align="center">
			新闻高级查找
		</h3>
		<h3 align="center">
		</h3>
		<table align="center" width="90%">
			<tr>
				<th align="left">
					<a href="<%=request.getContextPath()%>/showSubstugui.action">返回</a>
				</th>
			</tr>
		</table>
		<hr>
		<div align="center">
			<form action="information!NewsAdvanceSearch.action" method="post">
				<table border="1" width="90%">
					<tr>
						<th align="center" colspan="8"
							background="<%=basePath%>1_mhqx/admin/images/newmenubg.gif"
							height="30">
							<font color="#FFFFFF"><s:property value="FMenuName" /> </font>
						</th>
					</tr>
					<tr>
						<td>
							新闻标题：
						</td>
						<td>
							<input type="text" name="FInfoTitle" size="60">
						</td>
					</tr>
					<tr>
						<td>
							新闻类型：
						</td>
						<td>
							<input type="text" name="FInfoType" value="" size="60" />
						</td>
					</tr>
					<tr>
						<td>
							发布时间：
						</td>
						<td>
							<input type="text" name="FInfoStartTime" value="" size="60" />
						</td>
					</tr>
					<tr>
						<td>
							模块ID：
						</td>
						<td>
							<input type="text" name="FModuleId" value="" size="60" />
						</td>
					</tr>
					<tr>
						<td>
							发布人：
						</td>
						<td>
							<input type="text" name="" value="" size="60" />
						</td>
					</tr>
					<tr>
						<td>
							新闻内容：
						</td>
						<td>
							<input type="text" name="FInfoContet" value="" size="60" />
						</td>
					</tr>
					<tr>
						<td>
							是否置顶：
						</td>
						<td>
							<input type="text" name="FInfoZhiDing" value="" size="60" />
						</td>
					</tr>


					<tr>
						<td>
							&nbsp;
						</td>
						<td>
							<input type="submit" value="查找" />
							<input type="reset" value="重置" />
						</td>
					</tr>
				</table>
			</form>
		</div>
		<br>
		<br>
	</body>
</html>
