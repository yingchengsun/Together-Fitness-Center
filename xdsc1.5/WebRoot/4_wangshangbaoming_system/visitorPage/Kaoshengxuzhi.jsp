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
		<div align="center">
			<img width=900 src="<%=basePath%>images/4_Pictures/topcut1.jpg"
				height="135px">
		</div>

		<div align="center">
			<hr>

			<table width="900">
				<tr>
					<td width="200">
						<img src="<%=basePath%>images/4_Pictures/night.JPG">
					</td>
					<td width="500">
						<table width="100%" height="100%" align="left">
							<tr>
								<th background="<%=basePath%>images/4_Pictures/newmenubg.gif"
									colspan="2" height="20">
									考生须知内容
								</th>
							</tr>
							<tr>
								<td>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									点击右侧题目，获得考生须知内容</td>
							</tr>
						</table>
					</td>
					<td width="200">
						<table height="100%" width="100%" align="left" id="mytable">
							<tr>
								<th background="<%=basePath%>images/4_Pictures/newmenubg.gif"
									colspan="2" height="20">
									标题
								</th>
							</tr>
							<s:iterator value="listTabNotice" status="status">
								<tr>
									<td>
										<s:property value="#status.count" />
									</td>
									<td align="center">
										<a
											href="adAllCheck!sepFindByNoticeNumVisitor.action?FInfoId=<s:property value="FInfoId"/>"><s:property
												value="FInfoTitle" /> </a>
									</td>
								</tr>
							</s:iterator>
						</table>
					</td>
				</tr>
			</table>
			<hr color="brown">
			<br>
			<a
				href="<%=basePath%>4_wangshangbaoming_system/visitorPage/welcome.jsp"><img
					src="<%=basePath%>images/4_Pictures/return.gif">
			</a>
			<br>
		</div>
	</body>