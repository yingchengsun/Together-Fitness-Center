<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

	<head>
		<base href="<%=basePath%>">
		<title>注册信息</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">

		<link rel="stylesheet" type="text/css" href="css.css">
		<link rel="stylesheet" type="text/css" href="mycss.css">
		<script language="javascript" src="js/TableColor.js"></script>
		<script language="javascript" src="js/PopupCalendar.js"></script>
		<script>
			var oCalendarEn = new PopupCalendar("oCalendarEn");
			oCalendarEn.Init();
		
			var oCalendarChs = new PopupCalendar("oCalendarChs");
			oCalendarChs.weekDaySting = new Array("日", "一", "二", "三", "四", "五", "六");
			oCalendarChs.monthSting = new Array("一月", "二月", "三月", "四月", "五月", "六月",
					"七月", "八月", "九月", "十月", "十一月", "十二月");
			oCalendarChs.oBtnTodayTitle = "今天";
			oCalendarChs.oBtnCancelTitle = "取消";
			oCalendarChs.Init();
		</script>
		<style type="text/css">
			body {
				font-family: arial, 宋体, serif;
				font-size: 12px;
				background-image: url("<%=basePath%>images/4_Pictures/newbackground.png");
			}
		</style>
	</head>
	<body>
		<form action="message.action" method="post">
			<br>
			<br>
			<h3 align="center">
				发送留言
				<br>
			</h3>
			<hr>
			<div align="center">
				<table>
					<tr>
						<td>
							输入接受者系统注册号：
						</td>
						<td>
							<input name="FInfoPath" type="text">
					</tr>
				</table>
			</div>

			<div align="center">
				<table border="1" width="700">
					<tr>
						<th background="<%=basePath%>images/4_Pictures/newmenubg.gif" colspan="2"
							height="30">
							<font color="#FFFFFF">留言</font>
						</th>
					</tr>
					<tr>
						<th width="100">
							题目
						</th>
						<th width="500">
							内容
							<br>
						</th>
					</tr>
					<tr>
						<td align="center">
							<input name="FInfoTitle" type="text" size="20" >
						</td>
						<td>
							<input name="FInfoContet" type="text" size="80">
						</td>
					</tr>
				</table>
			</div>
			<br>
			<div align="center">
			<input type="submit" value="发送">
			</div>
			<br>
			<br>
		</form>
	</body>
</html>
