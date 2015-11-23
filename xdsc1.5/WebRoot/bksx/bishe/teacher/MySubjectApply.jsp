<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" errorPage="/errorPage.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>选题审批</title>
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
			选题审批
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
					<c:forEach items="${applyList }" var="apply">
						<tr>
							<th rowspan="2">
								序号
							</th>
							<th rowspan="2">
								课题名称
							</th>
							<th colspan="3">
								申请人信息
							</th>
							<th rowspan="2">
								状态
							</th>
						</tr>
						<tr>
							<th bgcolor="#FFFFFF">
								学号
							</th>
							<th bgcolor="#FFFFFF">
								姓名
							</th>
							<th bgcolor="#FFFFFF">
								性别
							</th>
						</tr>
						<tr>
							<td>
								${apply.id }
							</td>
							<td>
								${apply.bksxTabSubstugui.FSubjectName }
							</td>
							<td>
								${apply.tabStudents.FStudentNumber }
							</td>
							<td>
								${apply.tabStudents.FStudentName }
							</td>
							<td>
								${apply.tabStudents.FStudentSex }
							</td>
							<td>
								${apply.FStatus }
							</td>
						</tr>
						<tr>
							<th>
								批示
							</th>
							<td colspan="5">
								<a
									onclick="javascript: if(window.confirm('确定同意该生选题？')) window.location.href='<%=request.getContextPath()%>/agreeSubjectApply.action?id=${apply.id }'; ">
									<img
										src="<%=request.getContextPath()%>/bksx/pictures/accept.png"
										border="0" align="top" /> 同意该生选题</a>&nbsp;&nbsp;&nbsp;
								<a
									onclick="javascript: if(window.confirm('确定拒绝该生选题？')) window.location.href='<%=request.getContextPath()%>/refuseSubjectApply.action?id=${apply.id }'; ">
									<img
										src="<%=request.getContextPath()%>/bksx/pictures/delete.png"
										border="0" align="top" /> 拒绝该生选题</a>
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
							目前没有待处理的选题审批信息！
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
