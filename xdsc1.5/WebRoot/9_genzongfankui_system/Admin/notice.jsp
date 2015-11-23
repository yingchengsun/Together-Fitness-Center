<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>添加通知信息</title>
		<base href="<%=basePath%>">
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">

		<link rel="stylesheet" type="text/css" href="<%=basePath%>css.css">
		<link rel="stylesheet" type="text/css" href="<%=basePath%>mycss.css">
		<script language="javascript" src="<%=basePath%>js/TableColor.js"></script>
<script language="javascript" src="<%=basePath %>js/PopupCalendar.js"></script>
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
	</head>

	<body>
		<br>
		<h3 align="center">添加通知信息</h3>
		<table align="center" width="700">
			<tr>
				<th align="left"><a href="9_genzongfankui_system/Admin/Homepage.jsp"  target="right"><img src="<%=basePath%>Pictures/return.gif" align="top" border="0"/>返回</a></th>
			</tr>
		</table> 
		<hr>
		<div align="center">
			<form action="9_genzongfankui_system/Admin/noticeResult.jsp" method="post">
				<table border="1" width="700">
					<tr>
						<th height="30" colspan="2" align="center" background="<%=basePath%>Pictures/newmenubg.gif">
							<font color="#FFFFFF">通知</font>
						</th>
					</tr>
					<tr>
						<td>
							标题：
						</td>
						<td>
							<input type="text" name=""  />
						</td>
					</tr>
					
					<tr>
						<td>
							内容：
						</td>
						<td>
							<input type="text" name=""  />
						</td>
					</tr>
					<tr>
						<td>
							时间：
						</td>
						<td>
							<div align="left">
		         <input readonly="readonly" type="text" name="FStudentBirthday"
								onclick="getDateString(this,oCalendarChs)" />
								
						</td>
					</tr>
					
					<tr>
						<td align="center" colspan="2">
							<input type="submit" value="添加" />
							<input type="reset" value="重置" />
						</td>
					</tr>
				</table>
			</form>
			<br>
			 
		</div>
		<br>
		<br>
	</body>
</html>
