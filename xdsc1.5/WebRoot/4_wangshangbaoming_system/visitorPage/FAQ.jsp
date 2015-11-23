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
		<title>常问问题</title>

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
								<td><img src="<%=basePath%>images/4_Pictures/interstu.jpg">
								</td>
							</tr>
							<tr>
								<td>
								</td>
							</tr>
						</table>
					</td>
					<td width="700">
						<table width="100%" height="100%" align="left" id="mytable">
							<tr>
								<th background="<%=basePath%>images/4_Pictures/newmenubg.gif" colspan="2" height="20">
								常问问题
								</th>
							</tr>
							<tr>
								<td><div align="left">Q:软件学院的地址在哪里？
								</div></td>
							</tr>
							<tr>
								<td>A:软件学院的地址是：西安市太白南路2号，西安电子科技大学办公楼四层。
								</td>
							</tr>
							<tr>
								<td><div align="left">Q:软件学院的有没有培养研究生的资格？
								</div></td>
							</tr>
							<tr>
								<td>A:软件学远隶属西安电子科技大学，我校是正式大学，具有招生资格。
								</td>
							</tr>
							<tr>
								<td><div align="left">Q:网上报名系统中登记的联系信息有变化怎么办？
								</div></td>
							</tr>
							<tr>
								<td>A:注册完成并登陆后，你可以更新自己的联系信息。
								</td>
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