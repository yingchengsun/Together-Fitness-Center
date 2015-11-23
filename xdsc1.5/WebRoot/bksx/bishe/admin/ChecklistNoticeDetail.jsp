<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" errorPage="/errorPage.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>更新答辩信息</title>
		<link rel="stylesheet" type="text/css"
			href="<%=request.getContextPath()%>/bksx/css/css.css">
		<link rel="stylesheet" type="text/css"
			href="<%=request.getContextPath()%>/bksx/css/mycss.css">
	</head>

	<body>
		<br>
		<br>
		<h4 align="center">
			<img src="<%=request.getContextPath()%>/bksx/pictures/bagong_005.png"
				width="20" height="20" align="top" />
			${notice.FInfoTitle }
		</h4>
		<table align="center" width="98%">
			<tr>
				<th align="left">
					<a href="<%=request.getContextPath()%>/showChecklistNotice.action"><img
							src="<%=request.getContextPath()%>/bksx/pictures/return.gif"
							align="top" border="0" />返回</a>
				</th>
			</tr>
		</table>
		<hr>
		<div align="center">
			<table border="1" width="98%" cellspacing="0">
				<tr height="400">
					<td>
						<c:choose>
							<c:when test="${not empty notice.FInfoContet }">
								${notice.FInfoContet }
							</c:when>
							<c:otherwise>
								详情见标题！
							</c:otherwise>
						</c:choose>
					</td>
				</tr>
				<tr>
					<td>
						<c:if test="${role=='ADMIN' }">
							<a
								onclick="javascript: if(window.confirm('确定要删除此条通知么？')) window.location.href='<%=request.getContextPath()%>/deleteChecklistNotice.action?id=${notice.FInfoId }'; "><img
									src="<%=request.getContextPath()%>/bksx/pictures/delete.gif"
									align="top" border="0" />&nbsp;删除此条通知</a>
						</c:if>
					</td>
				</tr>
			</table>
			<hr>
			<font size="2"> 发布时间：${notice.FInfoStartTime }
				发布者：${notice.FInfoFrom } </font>
		</div>
		<br>
		<br>
	</body>
</html>
