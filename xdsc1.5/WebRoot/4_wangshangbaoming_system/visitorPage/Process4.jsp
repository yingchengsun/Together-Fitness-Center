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
								<th background="<%=basePath%>images/4_Pictures/newmenubg.gif" colspan="2" height="20">流程四：缴纳规定学费   
								</th>
							</tr>
							<tr>
								<td>再您获得软件学院工程硕士的预录取通知书后，请您尽快在规定的
								时间里向指定账户转汇学费，只有在学院确认缴费信息后，才会向考生发出<font color="red">正式录取通知书。</font></td>
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