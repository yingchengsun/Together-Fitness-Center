<%@ page language="java" pageEncoding="UTF-8" errorPage="/errorPage.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.fckeditor.net" prefix="FCK"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>课题详细信息</title>

		<link rel="stylesheet" type="text/css"
			href="<%=request.getContextPath()%>/bksx/css/css.css">
		<link rel="stylesheet" type="text/css"
			href="<%=request.getContextPath()%>/bksx/css/mycss.css">
	</head>

	<body>
		<br>
		<br>
		<h3 align="center">
			<img src="<%=request.getContextPath()%>/bksx/pictures/CS3_CheckMark_001.png"
				width="50" height="50" align="middle" />
			详细信息
		</h3>
		<table align="center" width="98%">
			<tr>
				<th align="left">
					<a href="<%=request.getContextPath()%>/getNewApplySubject.action"><img
							src="<%=request.getContextPath()%>/bksx/pictures/return.gif"
							align="top" border="0" />返回</a>
				</th>
			</tr>
		</table>
		<hr>
		<div align="center">
			<table border="1" cellspacing="0" width="98%">
				<tr>
					<th height="30" colspan="2" align="center"
						background="<%=request.getContextPath()%>/bksx/pictures/bluebar.gif">
						课题信息
					</th>
				</tr>
				<tr>
					<td width="25%">
						序号：
					</td>
					<td>
						${substugui.FSubStuGuiId }
					</td>
				</tr>
				<tr>
					<td>
						课题名称：
					</td>
					<td>
						${substugui.FSubjectName }
					</td>
				</tr>
				<tr>
					<td>
						课题性质：
					</td>
					<td>
						<c:if test="${substugui.FIsSoftware=='Y' }">软件项目</c:if>
						<c:if test="${substugui.FIsHardware=='Y' }">硬件项目</c:if>
						<c:if test="${substugui.FIsSoftHard=='Y' }">软硬结合</c:if>
						<c:if test="${substugui.FIsDocument=='Y' }">文献综述</c:if>
					</td>
				</tr>
				<tr>
					<td>
						课题来源：
					</td>
					<td>
						<c:if test="${substugui.FIsResearch=='Y' }">科研项目</c:if>
						<c:if test="${substugui.FIsSimulation=='Y' }">模拟项目</c:if>
						<c:if test="${substugui.FIsLab=='Y' }">实验室建设</c:if>
						<c:if test="${substugui.FIsOthers=='Y' }">其他类别</c:if>
					</td>
				</tr>
				<tr>
					<td>
						难度等级：
					</td>
					<td>
						${substugui.FLevel }
					</td>
				</tr>
				<tr>
					<td>
						题目作者：
					</td>
					<td>
						${substugui.FTeacherName }&nbsp;
					</td>
				</tr>
				<tr>
					<td>
						作者职称：
					</td>
					<td>
						${substugui.FTeacherDegreen }&nbsp;
					</td>
				</tr>
				<tr>
					<td>
						工作地点：
					</td>
					<td>
						${substugui.FWorkPlace }&nbsp;
					</td>
				</tr>
				<tr>
					<td>
						题目描述：
					</td>
					<td>
						${substugui.FSubjectDescription }&nbsp;
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<form action="<%=request.getContextPath() %>/dealApplySubject.action?id=${substugui.FSubStuGuiId }" method="post">
							<FCK:editor instanceName="FReason" value="此处填写同意或者拒绝理由"
								basePath="/fckeditor" width="100%" height="200"
								toolbarSet="mytools"></FCK:editor>
							<br>
							<input type="submit" name="result"  value="同意" />
							&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="submit" name="result" value="拒绝">
						</form>
					</td>
				</tr>
			</table>
		</div>

		<br>
	</body>
</html>
