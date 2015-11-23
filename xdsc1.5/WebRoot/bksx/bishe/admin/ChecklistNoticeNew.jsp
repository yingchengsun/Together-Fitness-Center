<%@ page language="java" import="java.util.*" pageEncoding="utf-8" errorPage="/errorPage.jsp"%>
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
		<link rel="stylesheet" type="text/css"
			href="<%=request.getContextPath()%>/bksx/css/css.css">
		<link rel="stylesheet" type="text/css"
			href="<%=request.getContextPath()%>/bksx/css/mycss.css">
		<script language="javascript"
			src="<%=request.getContextPath()%>/bksx/js/FormValid.js"></script>
		<title>发布通知</title>
		<script language="javascript"> 
function addComponent() 
{ 
        var uploadHTML = document.createElement( "<input type='file' size='60'  name='file'/>"); 
        document.getElementById("files").appendChild(uploadHTML); 
        uploadHTML = document.createElement( "<br>"); 
        document.getElementById("files").appendChild(uploadHTML); 
} 
		</script>
	</head>

	<body>
		<br>
		<br>
		<div align="center">
			<h3>
				<img src="<%=request.getContextPath()%>/bksx/pictures/2201.png"
					width="50" height="50" align="middle" />
				发布通知
			</h3>
			<hr>
			<div align="center">
				<form
					action="<%=request.getContextPath()%>/newChecklistNotic.action"
					method="post" enctype="multipart/form-data"
					onsubmit="return validator(this)">
					<table width="90%" border="1" cellspacing="0">
						<tr height="20">
							<th width="15%">
								<img src="<%=request.getContextPath()%>/bksx/pictures/blog.gif"
									align="top">
								标题
							</th>
							<td colspan="2">
								<input type="text" name="FInfoTitle" size="85%" id="Limit"
									valid="required|limit" min="5" max="50"
									errmsg="通知标题不能为空!|标题长度必须在5-50之间!" />
							</td>
						</tr>
						<tr>
							<td colspan="3">
								<FCK:editor instanceName="FInfoContet"
									basePath="/fckeditor" width="100%" height="400"
									toolbarSet="mytools"></FCK:editor>
								<br>
							</td>
						</tr>
						<tr>
							<th>
								<img
									src="<%=request.getContextPath()%>/bksx/pictures/fujian.gif"
									align="top">
								上传附件
							</th>
							<td>
								<span id="files"> <input type='file' size="60"
										name='file' /> </span>
							</td>
							<td>
								<input type="button" onclick="addComponent();" value="继续添加" />
							</td>
						</tr>
						<tr>
							<td colspan="3">
								<input type="submit" value="发布通知">
							</td>
						</tr>
					</table>
				</form>
			</div>
	</body>
</html>
