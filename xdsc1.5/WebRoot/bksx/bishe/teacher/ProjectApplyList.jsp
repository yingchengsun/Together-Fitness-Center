<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" errorPage="/errorPage.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>题目查询</title>
		<link rel="stylesheet" type="text/css"
			href="<%=request.getContextPath()%>/bksx/css/css.css">
		<link rel="stylesheet" type="text/css"
			href="<%=request.getContextPath()%>/bksx/css/mycss.css">
		<script language="javascript"
			src="<%=request.getContextPath()%>/bksx/js/TableColor.js"></script>
	</head>

	<body>
		<br>
		<br>
		<h3 align="center">
			<img
				src="<%=request.getContextPath()%>/bksx/pictures/balloonica_001.png"
				width="50" height="50" align="middle" />
			立项审批
		</h3>
		<hr>
		<br>
		<c:if test="${not empty applyList }">
			<div align="center">
				<table border="1" cellspacing="0" width="98%" id="mytable">
					<tr>
						<th height="30" colspan="8"
							background="<%=request.getContextPath()%>/bksx/pictures/bluebar.gif">
							申请信息
						</th>
					</tr>
					<tr>
						<th>
							项目名称
						</th>
						<th>
							项目类别
						</th>
						<th>
							申请人学号
						</th>
						<th>
							姓名
						</th>
						<th>
							队伍名称
						</th>
						<th>
							状态
						</th>
					</tr>
					<c:forEach items="${applyList }" var="apply">
						<tr>
							<td>
								${apply.FProjectName }
							</td>
							<td>
								${apply.FProjectCategory }
							</td>
							<td>
								${apply.tabStudents.FStudentNumber }
							</td>
							<td>
								${apply.tabStudents.FStudentName }
							</td>
							<td>
								${apply.bksxTabTeam.FTeamName }
							</td>
							<td>
								${apply.FResult }
							</td>
						</tr>
						<tr>
							<th>
								立项理由
							</th>
							<td colspan="4">
								${apply.FProjectDescription }&nbsp;
							</td>
							<td>
								<a
									onclick="javascript: if(window.confirm('确定同意该立项申请么？')) window.location.href='<%=request.getContextPath()%>/agreeProjectApply.action?id=${apply.id }'; ">同意</a>||
								<a
									onclick="javascript: if(window.confirm('确定拒绝该立项申请么？')) window.location.href='<%=request.getContextPath()%>/refuseProjectApply.action?id=${apply.id }'; ">驳回</a>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</c:if>
		<c:if test="${empty applyList }">
			<div align="center">
				<table border="1" cellspacing="0" width="98%">
					<tr>
						<td>
							<br>
							<br>
							<img
								src="<%=request.getContextPath()%>/bksx/pictures/MinIcons_001.png" />
							<br>
							目前没有待处理的立项申请信息！
							<br>
							<br>
							<br>
						</td>
					</tr>
				</table>

			</div>
		</c:if>
		<br>
		<br>
	</body>
</html>
