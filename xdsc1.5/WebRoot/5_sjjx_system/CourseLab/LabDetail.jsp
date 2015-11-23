<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
	    <base href="<%=basePath%>">
		<title>My JSP 'LabDetail.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">

		<link rel="stylesheet" type="text/css" href="css.css">
		<link rel="stylesheet" type="text/css" href="5_sjjx_system/mycss.css">
		<script language="javascript" src="5_sjjx_system/JS/PopupCalendar.js"></script>

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
		<h3 align="center">成功修改实验室信息</h3>
		<table align="center" width="700">
			<tr>
				<th align="left"><a href="showLab1.action"><img src="5_sjjx_system/Pictures/return.gif" align="top" border="0"/>返回</a></th>
			</tr>
		</table> 
		<hr>
		<div align="center">
			<form action="LabDetail.jsp">
				<table border="1" width="700">
					<tr>
						<th height="30" colspan="2" align="center" background="5_sjjx_system/Pictures/newmenubg.gif">
							<font color="#FFFFFF">详细信息</font>
						</th>
					</tr>
					<tr>
						<td>
							实验室名称：
						</td>
						<td>
							<input type="text" name="FLabName" value="${lab.FLabName }" size="60" readonly="readonly"/>
						    <input type="hidden" name="FLabId" value="${lab.FLabId }"/>
						</td>
					</tr>
					<tr>
						<td>
							所在校区：
						</td>
						<td>
							<input type="text" name="FLabLocation" value="${lab.FLabLocation }" size="60" readonly="readonly"/>
						</td>
					</tr>
					<tr>
						<td>
							房间编号：
						</td>
						<td>
							<input type="text" name="FRoomNumber" value="${lab.FRoomNumber }" size="60" readonly="readonly"/>
						</td>
					</tr>
					<tr>
						<td>
							座位数：
						</td>
						<td>
							<input type="text" name="FSeatNumber" value="${lab.FSeatNumber }" size="60" readonly="readonly"/>	
						</td>
					</tr>
				</table>
			</form>
		</div>
		
		<br>
	</body>
</html>
