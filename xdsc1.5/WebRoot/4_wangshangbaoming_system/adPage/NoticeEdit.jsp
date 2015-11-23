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

		<br>
		<br>
		<h3 align="center">
			发布新的通知信息
			<br>
		</h3>
		<table align="center" width="700">
			<tr>

			</tr>
		</table>
		<hr>
		<div align="center">
			<form action="message!pubNotice.action" method="post">
				<table width="700" border="1">
					<tr>
						<th colspan="2" background="<%=basePath%>images/4_Pictures/newmenubg.gif"
							height="30">
							<font color="#FFFFFF">网站信息</font>
						</th>
					</tr>
					<tr>
						<td width="150">
							发布种类
							<br>
						</td>
						<td>
							<label>
								<input type="radio" name="art" value="重要通知">
								重要通知
								<input type="radio" name="art" value="考生须知">
								考生须知
							</label>
						</td>
					</tr>
					<tr>
						<td>
							题目
						</td>
						<td>
							<input type="text" name="FInfoTitle" size="25">
						</td>
					</tr>
					<tr>
						<td>
							内容
						</td>
						<td>
							<textarea cols="80" rows="5" name="FInfoContet">
							</textarea>
						</td>
					</tr>
					<tr>
						<td>
							&nbsp;
						</td>
						<td>
							<input type="submit" value="提交" />
							<input type="reset" value="重置" />
						</td>
					</tr>
				</table>
			</form>
		</div>
		<br>
		<br>
		<br>

	</body>
</html>
