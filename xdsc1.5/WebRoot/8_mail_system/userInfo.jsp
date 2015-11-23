<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>

		<title>My JSP 'userInfo.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">

		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/8_mail_system/css/css.css">

		<style type="text/css">
body {
	background-image: url("<%=request.getContextPath() %>/8_mail_system/pictures/newbackground.png");
}
</style>

	</head>

	<body>
		<div
			style="position: absolute; top: 5%; left: 21%; width: 380px; height: auto; border: 1px;">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<span><img src="<%=request.getContextPath() %>/8_mail_system/images/mailtitle.png"><font size="6"
				face="华文新魏"><strong>邮件系统个人主页</strong>
			</font>
			</span>
		</div>
		<c:choose>
			<c:when test="${isme=='0'}">
				<div
					style="position: absolute; top: 15%; left: 70%; width: 380px; height: auto; border: 1px;">
					<span><a
						href="sentBack.jsp?from=${userInfo.infoUsername }" class="LINK21">给他回信</a>	
					</span>
					<span style="color: yellow"><a
						href="<%=request.getContextPath() %>/8_mail_system/newmail.action" class="LINK21">返回首页</a>	
					</span>
				</div>
			</c:when>
			<c:otherwise>
				<div
					style="position: absolute; top: 15%; left: 70%; width: 380px; height: auto; border: 1px;">
					<span style="color: yellow"><a
						href="modifyinfo.action?info_id=${userInfo.infoId }" class="LINK21">修改信息</a>
					</span>
					<span style="color: yellow"><a
						href="welcome_page.jsp" class="LINK21">返回首页</a>	
					</span>
				</div>
			</c:otherwise>
		</c:choose>

		<div
			style="position: absolute; top: 20%; left: 20%; width: 380px; height: auto; border: 1px dashed;">

			<table>
				<tr>
					<td rowspan="6">
						<img src="<%=request.getContextPath() %>/8_mail_system/pictures/${userInfo.infoPhoto }">
					</td>
				</tr>
				<tr>
					<td>
						&nbsp;&nbsp;&nbsp;姓名：${userInfo.infoRealname }
					</td>
					<td>ID:${userInfo.infoUsername }</td>

				</tr>
				<tr>
					<td>
						&nbsp;&nbsp;&nbsp;性别:${userInfo.infoSex }
					</td>

					<td>
						&nbsp;&nbsp;&nbsp;年龄:${userInfo.infoAge }
					</td>
				</tr>
				<tr>
					<td>
						&nbsp;&nbsp;&nbsp;年级:${userInfo.infoClass }
					</td>
				</tr>
				<tr>
					<td>
						&nbsp;&nbsp;&nbsp;学号:${userInfo.infoNumber }
					</td>
				</tr>
				<tr>
					<td>
						&nbsp;&nbsp;&nbsp;身份:${userInfo.infoProperty }
					</td>
				</tr>
				<tr>
					<td colspan="3">
						--------------------------------------------------------------------------
					</td>
				</tr>
				<tr>
					<td colspan="3" bgcolor="gray">
						&nbsp;&nbsp;&nbsp;备注
					</td>
				</tr>
				<tr>
					<td colspan="3" style="height: 100">
						&nbsp;&nbsp;&nbsp;${userInfo.infoNotes }
					</td>
				</tr>
				<tr>
					<td colspan="3">
						--------------------------------------------------------------------------
					</td>
				</tr>
				<tr>
					<td colspan="3" bgcolor="gray">
						&nbsp;&nbsp;&nbsp;最近动态
					</td>
				</tr>
				<tr>
					<td colspan="3" style="height: 100">
						&nbsp;&nbsp;&nbsp;${userInfo.infoPresent }
					</td>
				</tr>

			</table>
		</div>

	</body>
</html>
