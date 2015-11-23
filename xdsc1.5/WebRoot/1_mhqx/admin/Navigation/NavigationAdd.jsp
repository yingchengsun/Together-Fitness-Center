<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" errorPage="/errorPage.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>

		<title>添加快速导航</title>
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
			添加快速导航
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
			<form action="navigation!add.action" 
				method="post" enctype="multipart/form-data">
				<table width="700" border="0" id="mytable">
					<tr>
						<th colspan="2"
							background="<%=request.getContextPath()%>/1_mhqx/admin/images/bluebar.gif"
							height="30">
							<font color="#FFFFFF" >快速导航添加</font>
						</th>
					</tr>
					<tr>
						<th>	
						</th>
						<td>
							<input type="hidden" name="FNavigationId" value="${n.FNavigationId }">
						</td>
					</tr>
					<tr>
						<th>
							快速导航名称
						</th>
						<td>
		                  <input name="n.FNavigationName" type="text" size="20" label="快速导航名称："/>
	                   </td>
					</tr>
					<tr>
						<th>
					                导航链接地址
						</th>
						<td>
		                   <input name="n.FNavigationUrl" type="text" size="20" label="快速导航链接地址："/>
	                   </td>
					</tr>
					<tr>
						<th>
					                图片链接地址
						</th>
						<td>
		                   <span> <input type='file' size="60" name="uploadFile" value="浏览"/> </span>
	                   </td>
					</tr>
					<tr>
						<th>
							导航优先级
						</th>
						<td>
		                      <input name="n.FNavigationPriority" type="text" size="20" label="快速导航优先级："/>
	                     </td>
					</tr>
					
					<tr>
						<th>
							 <input type="submit" name="Submit" value="提交" /> 
						</th>
						<th>
							 <input type="reset" name="Submit2" value="重置" />
						</th>
					</tr>
				</table>
			</form>
		</div>
	</body>
</html>