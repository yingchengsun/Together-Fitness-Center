<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" errorPage="/errorPage.jsp"%>
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
		<title>编辑新闻</title>
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
				&nbsp; 编辑
				<s:property value="info_pre.FInfoType"/>
			</h3>
			<table align="center" width="700">
			<tr>
				<th align="left">
					<a href="information!showMenuToNews.action?FMenuName=<s:property value="FMenuName"/>"
								class="LINK1"  ><img
							src="<%=request.getContextPath()%>/1_mhqx/admin/images/return.gif"
							align="top" border="0" />返回</a>
				</th>
				
			</tr>
		   </table>
			<hr>
			<div align="center">
				<form action="information!updateInformation.action?FInfoId=<s:property value="info_pre.FInfoId"/>" method="post"
					enctype="multipart/form-data">
					<table width="80%" border="1" cellspacing="0">
						<tr height="20">
							<th width="15%">
								&nbsp; 标题
							</th>
							
							<td colspan="4">
								<input type="text" name="FInfoTitle" value="<s:property value="info_pre.FInfoTitle"/>" size="85%" />
							</td>
							<td>&nbsp; 是否最新
								<select name="FInfoZuiXin">
									<option value="0">
										否
									</option>
									<option value="1">
										是
									</option>
								</select>
							</td>
						</tr>
						<tr height="20">
							<th>
								&nbsp; 是否置顶
							</th>
							<td>
								<select name="FInfoZhiDing">
									<option value="N">
										否
									</option>
									<option value="Y">
										是
									</option>
								</select>
							</td>
							
							
							<th width="15%">
								&nbsp; 新闻类型
							</th>
							<td  width="10%">
							<input type="text" name="FInfoType" value="<s:property value="info_pre.FInfoType"/>" />
								
							</td>
							<th>
								&nbsp; 模块编号
							</th>
							<td>
							<input type="text" name="FModuleId" value="<s:property value="info_pre.FModuleId"/>" />
							</td>
						</tr>


						<tr>
							<td colspan="6">
								<FCK:editor instanceName="FInfoContet"
									basePath="/fckeditor" value="${info_pre.FInfoContet}" width="100%" height="500"
									toolbarSet="mytools"></FCK:editor>
								<br>
							</td>
						</tr>
						<tr>
							<th>
								&nbsp; 上传附件
							</th>
							<td colspan="6">
								<span> <input type='file' size="60" name="uploadFile"
										value="浏览" /> </span>
							</td>
						</tr>
						<tr>
							<td colspan="6" align="center">
								<input type="submit" value="发布">
								<input type="reset" value="重填">
							</td>

						</tr>
					</table>
				</form>
			</div>
	</body>
</html>
