<%@ page language="java" import="java.util.*" pageEncoding="utf-8"errorPage="/errorPage.jsp"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="http://java.fckeditor.net" prefix="FCK"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<html>
	<head>
		<base href="<%=basePath%>">
		<link rel="stylesheet" type="text/css" href="<%=basePath%>css.css">
		<title>发布新闻</title>
		<style type="text/css">
body {
	font-family: arial, 宋体, serif;
	font-size: 12px;
	background-image:
		url("<%=basePath%>1_mhqx/admin/images/newbackground.png");
}
</style>
	</head>

	<body>
		<!-- 设置新闻发布图片上传路径记录辅助计数器 -->
		<%
			String id = "0";
			session.setAttribute("Id", id);
		%>
		<br>
		<br>
		<div align="center">
			<h3>
				&nbsp; 发布通知公告
			</h3>
			<hr>
			<div align="center">
				<form action="information!addNotice.action" method="post"
					enctype="multipart/form-data">
					<table width="80%" border="1" cellspacing="0">
						<tr height="20">
							<th width="15%">
								&nbsp; 标题
							</th>
							<td colspan="2">
								<input type="text" name="info.FInfoTitle" size="85%" />
								<input type="hidden" name="info.FInfoType" value="通知公告" />
								<input type="hidden" name="info.FModuleId" value="1" />
							</td>
						</tr>
						<tr height="20">
							<th width="15%">
								&nbsp; 是否置顶
							</th>
							<td colspan="2">
								<select name="info.FInfoZhiDing">
									<option value="N">
										否
									</option>
									<option value="Y">
										是
									</option>
								</select>
							</td>
						</tr>
						<tr height="20">
							<th width="15%">
								&nbsp; 是否最新
							</th>
							<td colspan="2">
								<select name="info.FInfoZuiXin">
									<option value="0">
										否
									</option>
									<option value="1">
										是
									</option>
								</select>
							</td>
						</tr>


						<tr>
							<td colspan="3">
								<FCK:editor instanceName="info.FInfoContet"
									basePath="/fckeditor" value=" " width="100%" height="500"
									toolbarSet="mytools"></FCK:editor>
								<br>
							</td>
						</tr>
						<tr>
							<th>
								&nbsp; 上传附件
							</th>
							<td>
								<span> <input type='file' size="60" name="uploadFile"
										value="浏览" /> </span>
							</td>
						</tr>
						<tr>
							<td colspan="3" align="center">
								<input type="submit" value="发布">
								<input type="reset" value="重填">
							</td>

						</tr>
					</table>
				</form>
			</div>
	</body>
</html>
