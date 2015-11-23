<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" errorPage="/errorPage.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<link rel="stylesheet" type="text/css"
			href="<%=request.getContextPath()%>/bksx/css/css.css">
		<link rel="stylesheet" type="text/css"
			href="<%=request.getContextPath()%>/bksx/css/mycss.css">
		<script language="javascript"
			src="<%=request.getContextPath()%>/bksx/js/TableColor.js"></script>
		<script language="javascript"
			src="<%=request.getContextPath()%>/bksx/js/FormValid.js"></script>
	</head>

	<body>
		<br>
		<br>
		<h3 align="center">
			<img src="<%=request.getContextPath()%>/bksx/pictures/ontained.png"
				width="50" height="50" align="middle" />
			项目查询
		</h3>
		<hr>
		<div align="center">
			<form
				action="<%=request.getContextPath()%>/getProjectByAttribute.action"
				method="post" onsubmit="return validator(this)">
				<font size="2">精确查找</font>
				<select name="regDate">
					<option value="2006">
						2006
					</option>
					<option value="2007">
						2007
					</option>
					<option value="2008">
						2008
					</option>
					<option value="2009">
						2009
					</option>
					<option value="2010">
						2010
					</option>
					<option value="2011">
						2011
					</option>
					<option value="2012">
						2012
					</option>
				</select>
				<select name="attributeType">
					<option value="FProjectName" selected="selected">
						项目名称
					</option>
					<option value="bksxTabTeam.FTeamName">
						团队名称
					</option>
				</select>
				<input type="text" name="attribute" valid="required" errmsg="请输入查询条件!"/>
				<input type="submit" value="搜索">
			</form>
		</div>
		<hr>
		<div align="center">
		<c:choose>
			<c:when test="${not empty projectList }">
				<table border="1" cellspacing="0" width="98%" id="mytable">
				<tr>
					<th colspan="6"
						background="<%=request.getContextPath()%>/bksx/pictures/bluebar.gif"
						height="30">
						毕业设计项目信息
					</th>
				</tr>
				<tr>
					<th>
						项目序号
					</th>
					<th>
						项目名称
					</th>
					<th>
						项目团队
					</th>
					<th>
						项目来源
					</th>
					<th>
						查看项目
					</th>
				</tr>
				<c:forEach items="${projectList }" var="project">
					<tr>
						<td>
							${project.FProjId }
						</td>
						<td>
							${project.FProjectName }
						</td>
						<td>
							${project.bksxTabTeam.FTeamName }
						</td>
						<td>
							${project.FProjectCategory }
						</td>
						<td>
							<a
								href="<%=request.getContextPath()%>/showProjectDetail.action?id=${project.FProjId }"><img
									src="<%=request.getContextPath()%>/bksx/pictures/lookdetail.gif"
									border="0" align="top"/> </a>
						</td>
					</tr>
				</c:forEach>
			</table>
			<table width="40%">
				<tr>
					<td>
						<div align="center">
							<a href="<%=request.getContextPath()%>/showAllProject.action?p=1">首页</a>
						</div>
					</td>
					<td>
						<div align="center">
							<a
								href="<%=request.getContextPath()%>/showAllProject.action?p=${p-1}">上一页</a>
						</div>
					</td>
					<td>
						<div align="center">
							<a
								href="<%=request.getContextPath()%>/showAllProject.action?p=${p+1}">下一页</a>
						</div>
					</td>
					<td>
						<div align="center">
							<a
								href="<%=request.getContextPath()%>/showAllProject.action?p=${lastPage}">末页</a>
						</div>
					</td>
				</tr>
			</table>
			</c:when>
			<c:otherwise>
				<div align="center">
				<table border="1" cellspacing="0" width="98%">
					<tr>
						<td>
							<br>
							<br>
							<img
								src="<%=request.getContextPath()%>/bksx/pictures/MinIcons_001.png" />
							<br>
							目前没有此类课题信息！
							<br>
							<br>
							<br>
						</td>
					</tr>
				</table>
			</div>
			</c:otherwise>
		</c:choose>
			
		</div>
		<br>
		<br>
		<br>
	</body>
</html>
