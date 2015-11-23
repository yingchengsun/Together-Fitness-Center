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
			考生信息查询及更新
		</h3>
		<hr>
		<div align="center">
			<form action="adAllCheck!sepFindByNum.action">
				请输入考生注册号码
				<input type="text" name="FAppRegNum" />
				<input type="submit" value="确定">
			</form>
			
			<table width="61.8%" border="1" >
				<tr>
					<td><a href="adAllCheck.action">列出全部注册考生信息</a>
					</td>
					<td><a href="adAllCheck!feed.action">列出已交报名费考生</a>
					</td>
					<td><a href="adAllCheck!unfeed.action">列出未交报名费考生</a>
					</td>
				</tr>
			</table>
			<br>
			<table width="61.8%" border="1" id="mytable">
				<tr>
					<td>
						<a href="adAllCheck!AuthPass.action">列出已通过信息验证的考生</a>
					</td>
					<td>
						<a href="adAllCheck!AuthPassNot.action">列出未通过信息验证的考生</a>
					</td>
					<td>
						<a href="adAllCheck!Authing.action">列出未验证考生</a>
					</td>
				</tr>
				<tr>
					<td>
						<a href="adAllCheck!PrePass.action">列出已预录取考生</a>
					</td>
					<td>
						<a href="adAllCheck!PrePassNot.action">列出未通过预录取的考生</a>
					</td>
					<td>
						<a href="adAllCheck!Preing.action">列出未决定是否预录取考生</a>
					</td>
				</tr>
				
				<tr>
					<td>
						<a href="adAllCheck!FinPass.action">列出已录取考生</a>
					</td>
					<td>
						<a href="adAllCheck!FinPassNot.action">列出未通过录取的考生</a>
					</td>
					<td>
						<a href="adAllCheck!Fining.action">列出未决定是否录取考生</a>
					</td>
				</tr>
			</table>
		</div>




		<br>
	</body>
</html>
