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
		<br>
		<h3 align="center">
			<img height="60" width="60" src="<%=basePath %>4_wangshangbaoming_system/adPage/info2.png">公告信息概览
			<br>

		</h3>
		<hr>
		<table align="center" width="80%">
			<tr>
				<th align="right">
					点击公告编号查看其详细信息
					<br>
				</th>
			</tr>
		</table>
		<div align="center">
			<table border="1" id="mytable" width="80%">
				<tr>
					<th colspan="10" align="center"
						background="<%=basePath%>images/4_Pictures/newmenubg.gif">
						<font color="#ffffff">公告信息</font>
					</th>
				</tr>
				<tr>
					<td>
						序号
					</td>
					<td>
						公告编号
					</td>
					<td>
						标题
					</td>
					<td>
						类型
					</td>
				</tr>

				<s:iterator value="listTabNotice" status="status">
					<tr>
						<td align="center">
							<s:property value="#status.count" />
						</td>
						<td align="center">
							<a
								href="adAllCheck!sepFindByNoticeNum.action?FInfoId=<s:property value="FInfoId"/>"><s:property
									value="FInfoId" />
							</a>
						</td>
						<td align="center">
							<s:property value="FInfoTitle" />
						</td>
						<td align="center">
							<s:property value="FInfoPath" />
						</td>
					</tr>
				</s:iterator>
			</table>
		</div>


	</body>
</html>
