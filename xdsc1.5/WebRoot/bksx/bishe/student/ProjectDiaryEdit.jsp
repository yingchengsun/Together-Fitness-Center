<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" errorPage="/errorPage.jsp"%>
<%@taglib uri="http://java.fckeditor.net" prefix="FCK"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>新建工作日志</title>
		<link rel="stylesheet" type="text/css"
			href="<%=request.getContextPath()%>/bksx/css/css.css">
		<link rel="stylesheet" type="text/css"
			href="<%=request.getContextPath()%>/bksx/css/mycss.css">
		<script language="javascript"
			src="<%=request.getContextPath()%>/bksx/js/FormValid.js"></script>
	</head>

	<body>

		<br>
		<br>
		<h3 align="center">
			<img
				src="<%=request.getContextPath()%>/bksx/pictures/Antique_Icon_update_001.png"
				width="50" height="50" align="middle" />
			撰写日志
		</h3>
		<table align="center" width="98%">
			<tr>
				<th align="left">
					<a href="<%=request.getContextPath()%>/showDiary.action"><img
							src="<%=request.getContextPath()%>/bksx/pictures/return.gif"
							align="top" border="0" />返回</a>
				</th>
			</tr>
		</table>
		<hr>
		<div align="center">
			<form action="<%=request.getContextPath()%>/addDiary.action"
				method="post" onsubmit="return validator(this)">
				<table width="98%" cellspacing="0" border="1">
					<tr>
						<th colspan="2"
							background="<%=request.getContextPath()%>/bksx/pictures/bluebar.gif"
							height="30">
							毕业设计工作日志
						</th>
					</tr>
					<tr>
						<th width="150">
							项目
						</th>
						<th>
							状态
						</th>
					</tr>
					<tr>
						<td>
							日志标题
						</td>
						<td>
							<img src="<%=request.getContextPath()%>/bksx/pictures/blog.gif"
								align="top">
							<input type="text" name="FDiaryTitle" size="90" id="Limit"
								valid="required|limit" min="3" max="25"
								errmsg="请填写日志标题！|日志标题长度必须在3-25之间">
						</td>
					</tr>
					<tr>
						<td>
							详细内容
						</td>
						<td>
							<FCK:editor instanceName="FDiaryContent"
								basePath="/fckeditor" width="100%" height="400"
								toolbarSet="mytools"></FCK:editor>
						</td>
					</tr>
					<tr>
						<td width="15%">
							&nbsp;
						</td>
						<td>
							<input type="submit" value="提交" />
							<input type="reset" value="重置" />
						</td>
					</tr>
				</table>
			</form>
		</div>
		<br>
		<br>
		<br>

	</body>
</html>
