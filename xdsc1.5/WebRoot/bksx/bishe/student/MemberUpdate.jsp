<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" errorPage="/errorPage.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.fckeditor.net" prefix="FCK"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>

		<title>分配项目任务</title>
		<link rel="stylesheet" type="text/css"
			href="<%=request.getContextPath()%>/bksx/css/css.css">
		<link rel="stylesheet" type="text/css"
			href="<%=request.getContextPath()%>/bksx/css/mycss.css">
	</head>

	<body>
		<br>
		<br>
		<h3 align="center">
			<img src="<%=request.getContextPath()%>/bksx/pictures/001CAT3EKQV.png"
				width="50" height="50" align="middle" />
			任务指派
		</h3>
		<table align="center" width="98%">
			<tr>
				<th align="left">
					<a href="<%=request.getContextPath()%>/getTeamInfo.action"><img
							src="<%=request.getContextPath()%>/bksx/pictures/return.gif"
							align="top" border="0" />返回 </a>
				</th>
			</tr>
		</table>
		<hr>
		<div align="center">
			<form action="<%=request.getContextPath()%>/updateMember.action"
				method="post">
				<table width="98%" border="1" cellspacing="0" id="mytable">
					<tr>
						<th colspan="2"
							background="<%=request.getContextPath()%>/bksx/pictures/bluebar.gif"
							height="30">
							角色信息更新
						</th>
					</tr>
					<tr>
						<th width="10%">
							队员学号
						</th>
						<td>
							${member.FStudentNumber }
							<input type="hidden" value="${member.FStudentNumber }"
								name="FStudentNumber">
						</td>
					</tr>
					<tr>
						<th>
							队员姓名
						</th>
						<td>
							${member.tabStudents.FStudentName }
						</td>
					</tr>
					<tr>
						<th>
							队员性别
						</th>
						<td>
							${member.tabStudents.FStudentSex }
						</td>
					</tr>
					<tr>
						<th>
							队员职责
						</th>
						<td>
							<select name="FTeamRole">
								<option value="未分配角色">
									-----选择角色-----
								</option>
								<option value="项目经理"
									<c:if test="${member.FTeamRole=='项目经理' }">selected="selected"</c:if>>
									项目经理
								</option>
								<option value="需求分析"
									<c:if test="${member.FTeamRole=='需求分析' }">selected="selected"</c:if>>
									需求分析
								</option>
								<option value="架构设计"
									<c:if test="${member.FTeamRole=='架构设计' }">selected="selected"</c:if>>
									架构设计
								</option>
								<option value="开发实现"
									<c:if test="${member.FTeamRole=='开发实现' }">selected="selected"</c:if>>
									开发实现
								</option>
								<option value="测试集成"
									<c:if test="${member.FTeamRole=='测试集成' }">selected="selected"</c:if>>
									测试集成
								</option>
								<option value="数据库设计"
									<c:if test="${member.FTeamRole=='数据库设计' }">selected="selected"</c:if>>
									数据库设计
								</option>
								<option value="技术支持"
									<c:if test="${member.FTeamRole=='技术支持' }">selected="selected"</c:if>>
									技术支持
								</option>
							</select>
						</td>
					</tr>
					<tr>
						<th>
							其他信息
						</th>
						<td>
							<FCK:editor instanceName="FMemberDescription"
								value="${member.FMemberDescription }" basePath="/fckeditor"
								width="100%" height="200" toolbarSet="mytools"></FCK:editor>
						</td>
					</tr>
					<tr>
						<th>
							&nbsp;
						</th>
						<th>
							<input type="submit" value="更新">
							<input type="reset" value="取消">
						</th>
					</tr>
				</table>
			</form>
		</div>
	</body>
</html>
