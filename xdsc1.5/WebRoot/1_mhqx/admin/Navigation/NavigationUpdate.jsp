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
		<title>编辑快速导航</title>
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
			更新快速导航
		</h3>
		<table align="center" width="700">
			<tr>
				<th align="left">
					<a href="navigation!listAll.action?location=right" ><img
							src="<%=request.getContextPath()%>/1_mhqx/admin/images/return.gif"
							align="top" border="0" />返回</a>
				</th>
			</tr>
		</table>
		<hr>
		<div align="center">
			<s:form action="navigation!update.action" 
				enctype="multipart/form-data" method="post" theme="simple">
				<table width="700" border="0" id="mytable">
					<tr>
						<th colspan="2"
							background="<%=request.getContextPath()%>/1_mhqx/admin/images/bluebar.gif"
							height="30">
							<font color="#FFFFFF">快速导航更新</font>
						</th>
					</tr>
					<tr>
						<th>
							
						</th>
						<td>
							<input type="hidden" name=" FNavigationId" value="${n.FNavigationId}">
						</td>
					</tr>
					<tr>
						<th width="150px">
							快速导航名称
						</th>
						<td>
							<input type="text" name="FNavigationName"
								value="${n.FNavigationName}">
								
						</td>
					</tr>
					<tr>
						<th>
					             图片链接地址
						</th>
						<td colspan="6">
						    <img style="height:80px; margin:0 0 0 100px" src='<%=request.getContextPath()%>/upfile/<s:property value ="n.FNavigationPicUrl" /> ' /><br />
						    <span> <input type="text" size="60" name="FNavigationPicUrl" value="/upfile/<s:property value ="n.FNavigationPicUrl" />" disabled="disabled"/>
						    <s:file size="60" name="uploadFile" /><small>(点击更换)</small></span>
						</td>
					</tr>
					<tr>
						<th>
					                     导航链接地址
						</th>
						<td>
							<input  type="text" name="FNavigationUrl" value="${n.FNavigationUrl}"/>
						</td>
					</tr>
					<tr>
						<th>
							导航优先级
						</th>
						<td>
							<input type="text" name="FNavigationPriority"  value="${n.FNavigationPriority}"/>
						</td>
					</tr>
					<tr>
						<th>
							<input type="submit" value="更新">
						</th>
						<th>
							<input type="reset" value="重置">
						</th>
					</tr>
				</table>
			</s:form>
		</div>
	</body>
</html>
					