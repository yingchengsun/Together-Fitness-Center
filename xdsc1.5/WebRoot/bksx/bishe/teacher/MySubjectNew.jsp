<%@ page language="java" pageEncoding="utf-8" errorPage="/errorPage.jsp"%>
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
		<title>新建课题</title>
	</head>

	<body>
		<br>
		<br>
		<div align="center">
			<h3>
				<img src="<%=request.getContextPath()%>/bksx/pictures/MBA.png"
					width="50" height="50" align="middle" />
				新建课题
			</h3>
			<hr>
			<div align="center">
				<form action="<%=request.getContextPath()%>/newMySubject.action"
					method="post" onsubmit="return validator(this)">
					<table width="90%" border="1" cellspacing="0">
						<tr height="20">
							<td width="15%">
								<img src="<%=request.getContextPath()%>/bksx/pictures/blog.gif"
									align="top">
								课题名称
							</td>
							<td>
								<input type="text" name="FSubjectName" size="85%" id="Limit"
									valid="required|limit" min="5" max="25"
									errmsg="请填写课题名称！|课题名称长度必须在5-25之间" />
							</td>
						</tr>
						<tr height="20">
							<td width="15%">
								<img src="<%=request.getContextPath()%>/bksx/pictures/blog.gif"
									align="top">
								课题类型
							</td>
							<td>
								<input type="radio" name="type" value='0' checked="checked">
								软件
								<input type="radio" name="type" value='1'>
								硬件
								<input type="radio" name="type" value='2'>
								软硬结合
								<input type="radio" name="type" value='3'>
								文献综述
							</td>
						</tr>
						<tr height="20">
							<td width="15%">
								<img src="<%=request.getContextPath()%>/bksx/pictures/blog.gif"
									align="top">
								课题来源
							</td>
							<td>
								<input type="radio" name="category" value='0' checked="checked">
								科研
								<input type="radio" name="category" value='1'>
								模拟
								<input type="radio" name="category" value='2'>
								实验室建设
								<input type="radio" name="category" value='3'>
								其他
							</td>
						</tr>
						<tr height="20">
							<td width="15%">
								<img src="<%=request.getContextPath()%>/bksx/pictures/blog.gif"
									align="top">
								难度等级
							</td>
							<td>
								<input type="radio" name="FLevel" value="A" checked="checked">
								A-难
								<input type="radio" name="FLevel" value="B">
								B-中
								<input type="radio" name="FLevel" value="C">
								C-易
							</td>
						</tr>
						<tr height="20">
							<td width="15%">
								<img src="<%=request.getContextPath()%>/bksx/pictures/blog.gif"
									align="top">
								工作地点
							</td>
							<td>
								<input type="text" name="FWorkPlace" size="85%" id="Limit"
									valid="required|limit" min="2" max="5"
									errmsg="请填写工作地点！|工作地点长度必须在2-5之间" />
							</td>
						</tr>
						<tr>
							<td colspan="2">
								<FCK:editor instanceName="FSubjectDescription" value="此处添加课题描述"
									basePath="/fckeditor" width="100%" height="300"
									toolbarSet="mytools"></FCK:editor>
								<br>
							</td>
						</tr>
						<tr>
							<td colspan="2">
								<input type="submit" value=" 新建课题 ">
							</td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</body>
</html>
