<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" errorPage="/errorPage.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.fckeditor.net" prefix="FCK"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>项目立项</title>
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
				src="<%=request.getContextPath()%>/bksx/pictures/Glass_Folder_001.png"
				width="50" height="50" align="middle" />
			立项申请
		</h3>
		<hr>
		<div align="center">
			<c:if test="${empty noProject }">
				<div align="center">
					<table border="1" cellspacing="0"  width="98%">
						<tr>
							<td>
								<br>
								<br>
								<img
									src="<%=request.getContextPath()%>/bksx/pictures/MinIcons_001.png" />
								<br>
								请首先选题，否则无法立项!
								<br>
								<br>
								<br>
							</td>
						</tr>
					</table>
				</div>
			</c:if>
			<c:if test="${noProject=='NO' }">
				<form
					action="<%=request.getContextPath()%>/createProjectApply.action"
					method="post" onsubmit="return validator(this)">
					<table width="98%" border="1">
						<tr bgcolor="#84C1FF">
							<th colspan="2"
								background="<%=request.getContextPath()%>/bksx/pictures/bluebar.gif"
								height="30">
								填写项目信息
							</th>
						</tr>
						<tr>
							<td colspan="2">
								<img
									src="<%=request.getContextPath()%>/bksx/pictures/time_go.png"
									align="top" />
								创建一个新的项目
							</td>
						</tr>
						<tr>
							<td width="150">
								项目名称
							</td>
							<td>
								<input type="text" name="FProjectName" size="90" id="Limit"
								valid="required|limit" min="3" max="25"
								errmsg="请填写项目名称！|项目名称长度必须在3-25之间">
							</td>
						</tr>
						<tr>
							<td>
								项目类别
							</td>
							<td>
								<input type="radio" name="FProjectCategory" value="本院自主项目"
									checked="checked">
								本院自主项目
								<input type="radio" name="FProjectCategory" value="企业合作项目 ">
								企业合作项目
								<input type="radio" name="FProjectCategory" value="实习单位项目">
								实习单位项目
							</td>
						</tr>
						<tr>
							<td>
								立项理由
							</td>
							<td>
								<FCK:editor instanceName="FProjectDescription"
									basePath="/fckeditor" width="600" height="200"
									toolbarSet="mytools"></FCK:editor>
							</td>
						</tr>
						<tr>
							<td colspan="2">
								<img
									src="<%=request.getContextPath()%>/bksx/pictures/user_suit.png"
									align="top" />
								同时创建你自己的团队
							</td>
						</tr>
						<tr>
							<td>
								团队名称
							</td>
							<td>
								<input type="text" name="FTeamName" size="90" id="Limit"
								valid="required|limit" min="3" max="25"
								errmsg="请填写队伍名称！|队伍名称长度必须在3-25之间">
							</td>
						</tr>
						<tr>
							<td>
								团队描述
							</td>
							<td>
								<FCK:editor instanceName="FTeamDescription"
									basePath="/fckeditor" width="600" height="200"
									toolbarSet="mytools"></FCK:editor>
							</td>
						</tr>
						<tr>
							<td>
								&nbsp;
							</td>
							<td>
								<input type="submit" value="创建">
								<input type="reset" value="取消">
							</td>
						</tr>
					</table>
				</form>
			</c:if>
			<c:if test="${noProject=='YES' }">

				<div align="center">
					<table border="1" cellspacing="0" width="98%">
						<tr>
							<td>
								<br>
								<br>
								<img
									src="<%=request.getContextPath()%>/bksx/pictures/MinIcons_001.png" />
								<br>
								目前已经存在毕业设计项目，勿重复立项!
								<br>
								<br>
								<br>
							</td>
						</tr>
					</table>
				</div>
			</c:if>
		</div>
		<br>
		<br>
		<br>
	</body>
</html>
