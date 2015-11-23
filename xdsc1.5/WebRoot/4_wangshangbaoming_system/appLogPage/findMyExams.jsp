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
	background-image:
		url("<%=basePath%>images/4_Pictures/newbackground.png");
}
</style>
	</head>
	<body>
		<h3 align="center">
			<br>
		</h3>
		<h3 align="center">
			我的考试安排
			<br>
		</h3>
		<hr>
		<table align="center" width="61.8%" id="mytable" border="1">
			<tr>
				<th colspan="5"
					background="<%=basePath%>images/4_Pictures/newmenubg.gif"
					height="30">
					&nbsp;
					<font color="#FFFFFF">考试信息</font>
				</th>
			</tr>
			<tr>
				<td>
					科目id
				</td>
				<td>
					科目名称
				</td>
				<td>
					考试时间
				</td>
				<td>
					考试地点
				</td>
			</tr>
			<s:iterator value="listWsbmTabExamsubject" status="status">
				<tr>
					<td align="center">
						<s:property value="FSubjectNumber" />
					</td>
					<td align="center">
						<s:property value="FSubjectName" />
					</td>
					<td align="center">
						<s:property value="FSubjectTime" />
					</td>
					<td align="center">
						<s:property value="FSubjectAddress" />
					</td>
				</tr>
			</s:iterator>
		</table>
	</body>
</html>
