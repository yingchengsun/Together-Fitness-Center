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
		<title>招生阶段说明</title>

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
						<table  height="100%">
							<tr>
								<td><img src="<%=basePath%>images/4_Pictures/pro.JPG">
								</td>
							</tr>
							<tr>
								<td>
								</td>
							</tr>
						</table>
					</td>
					<td width="450">
						<table width="100%" height="100%" align="left">
							<tr>
								<th background="<%=basePath%>images/4_Pictures/newmenubg.gif" colspan="2" height="20">流程一：填写个人信息   
								</th>
							</tr>
							<tr>
								<td>在网上报名注册时，需要填写的第一个表为个人基本信息表，您必须填写<font color="red">正确的，规范的</font>个人信息。正确的填写方法在相应的页面上有提示。您的个人信息只有被验证的情况下才可以支持您后续的预录取，考试等过程。
								</td>
							</tr>
						</table>
					</td>
					<td width="250">
						<table width="100%" height="100%" id="mytable">
							<tr>
								<td><a href="<%=basePath %>4_wangshangbaoming_system/visitorPage/Process.jsp">填写个人信息
								</a></td>
							</tr>
							<tr>
								<td><a href="<%=basePath %>4_wangshangbaoming_system/visitorPage/Process2.jsp">个人信息验证
								</a></td>
							</tr>
							<tr>
								<td><a href="<%=basePath %>4_wangshangbaoming_system/visitorPage/Process3.jsp">参加学院复试
								</a></td>
							</tr>
							<tr>
								<td><a href="<%=basePath %>4_wangshangbaoming_system/visitorPage/Process4.jsp">缴纳规定学费
								</a></td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			<hr color="brown">
						<br>
			<a href="adAllCheck!noticeVisitor1.action"><img src="<%=basePath%>images/4_Pictures/return.gif"></a>
			<br>
		</div>
	</body>