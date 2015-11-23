<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@taglib uri="http://java.fckeditor.net" prefix="FCK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
	    <base href="<%=basePath%>">
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
		<h3 align="center">通知公告具体内容</h3>
		<table align="center" width="700">
			<tr>
				<th align="left"><a href="showInfoList.action"><img src="5_sjjx_system/Pictures/return.gif" align="top" border="0"/>返回</a></th>
			</tr>
		</table> 
		<hr>
		<c:choose>
		<c:when test="${attachment=='iscontent'}">
		<div align="center">
				 <table border="1" width="700" height="50" >
					<tr>
						<th height="30" colspan="2" align="center" background="5_sjjx_system/Pictures/newmenubg.gif">
							<font color="#FFFFFF">信息</font>
						</th>
					</tr>
					<tr>
						<td colspan="1">
							标题：
						</td>
						<td>
							${info.FInfoTitle }
						</td>
						
					</tr>
					<tr>
						<td colspan="1">
							具体内容：
						</td>
						<td height="100">
							${info.FInfoContet }
						</td>
					</tr>
					<tr>
						<td width="100">
								相关附件：
					    </td>
						<td>
						<a href="sjjxDownLoad.action?name=${info.FInfoPath }">
									${info.FInfoPath } </a>
			            </td>
					</tr>
			</table>
		</div>
		</c:when>
		<c:otherwise>
		<div align="center">
				 <table border="1" width="700" height="50" >
					<tr>
						<th height="30" colspan="2" align="center" background="5_sjjx_system/Pictures/newmenubg.gif">
							<font color="#FFFFFF">信息</font>
						</th>
					</tr>
					<tr>
						<td width="20%">
							标题：
						</td>
						<td>
							${info.FInfoTitle }
						</td>
						
					</tr>
					<tr>
						<td colspan="1" width="20%">
							具体内容：
						</td>
						<td height="100">
							${info.FInfoContet }
						</td>
					</tr>
			</table>
		</div>
		</c:otherwise>
		</c:choose>
		<br>
	</body>
</html>
