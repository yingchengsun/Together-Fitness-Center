<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>西安电子科技大学软件学院</title>
		<link href="../css/css.css" rel="stylesheet" type="text/css" />
	</head>
	<body style="height: auto">
		<table width="100%" border="0" align="center" cellpadding="0"
			cellspacing="0">
			<tr>
				<td align="center" width="100%" colspan="2">
					<img src="../pictures/top2.jpg" width="100%" height="135px">
				</td>
			</tr>
			<tr height="30" align="right">
				<td background="../pictures/bluebar.gif" width="90%">

					<a
						<c:if test="${role=='ADMIN' }"> href="admin/Homepage.jsp" </c:if>
						<c:if test="${role=='STUDENT' }"> href="student/Homepage.jsp" </c:if>
						<c:if test="${role=='TEACHER' }"> href="teacher/Homepage.jsp" </c:if>
						target="right"> <img src="../pictures/home.gif" align="top"
							border="0"> <font color="#FFFFFF">首页</font>&nbsp;&nbsp;&nbsp;
					</a><font color="#FFFFFF"> <img src="../pictures/teacher.gif"
							align="top"> <%=(String) session.getAttribute("name")%>,你好！</font>
				</td>
				<td background="../pictures/bluebar.gif">
					<a href="../index.jsp" class="a_write" target=_top><font
						color="#FFFFFF">安全退出</font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
				</td>
			</tr>
		</table>
	</body>
</html>
