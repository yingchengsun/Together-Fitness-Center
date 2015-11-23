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
	<div align="center">
	<img width=900 src="<%=basePath%>images/4_Pictures/topcut1.jpg"
				height="135px">
	<table width="900">
				<tr>
				<td width="70"><img src="<%=basePath%>images/4_Pictures/boy.jpg">
				</td>
				
				<td>在软件学院学习的三年，我获益良多，应用程序编写的一个验收测试工具。与其他测试工具相比，使用 Selenium 的最大好处是： Selenium 测试直接在浏览器中运行，就像真实用户所做的一样。Selenium 测试可以在Windows、Linux和 MacintoshAnd 上的 Internet Explorer、Mozilla ，Opera， Firefox 中运行。其他测试工具都不能覆盖如此多的平台。 
Selenium 不同于一般的测试工具的操作ml 页面听用户对html 页面的操作的录制工具。Selenium 完全了解用户操作的html 页面。Selenium利用xpath对页面上的所有位置进行定位。（详见xpath.doc）
				
				</td>
				</tr>
				</table>
				<hr>
				<table width="900" >
				<tr>
				<td width="70"><img src="<%=basePath%>images/4_Pictures/girl.jpg">
				</td>
				
				<td>Selenium 是 ThoughtWorks 专门为 Web应用程序编写的一个验收测试工具。与其他测试工具相比，使用 Selenium 的最大好处是： Selenium 测试直接在浏览器中运行，就像真实用户所做的一样。Selenium 测试可以在Windows、Linux和 MacintoshAnd 上的 Internet Explorer、Mozilla ，Opera， Firefox 中运行。其他测试工具都不能覆盖如此多的平台。 
Selenium 不同于一般的测试工具的操作ml 页面听用户对html 页面的操作的录制工具。Selenium 完全了解用户操作的html 页面。Selenium利用xpath对页面上的所有位置进行定位。（详见xpath.doc）
				
				</td>
				
				</tr>
				</table>
				<hr>
				<table width="900" >
				<tr>
				<td width="70"><img src="<%=basePath%>images/4_Pictures/girl2.jpg">
				</td>
				
				<td>Selenium 是 ThoughtWorks 专门为 Web应用程序编写的一个验收测试工具。与其他测试工具相比，使用 Selenium 的最大好处是： Selenium 测试直接在浏览器中运行，就像真实用户所做的一样。Selenium 测试可以在Windows、Linux和 MacintoshAnd 上的 Internet Explorer、Mozilla ，Opera， Firefox 中运行。其他测试工具都不能覆盖如此多的平台。 
Selenium 不同于一般的测试工具的操作ml 页面听用户对html 页面的操作的录制工具。Selenium 完全了解用户操作的html 页面。Selenium利用xpath对页面上的所有位置进行定位。（详见xpath.doc）
				
				</td>
				
				</tr>
				</table>
				<hr>
				<table width="900" >
				<tr>
				<td width="70"><img src="<%=basePath%>images/4_Pictures/boy3.jpg">
				</td>
				
				<td>Selenium 是 ThoughtWorks 专门为 Web应用程序编写的一个验收测试工具。与其他测试工具相比，使用 Selenium 的最大好处是： Selenium 测试直接在浏览器中运行，就像真实用户所做的一样。Selenium 测试可以在Windows、Linux和 MacintoshAnd 上的 Internet Explorer、Mozilla ，Opera， Firefox 中运行。其他测试工具都不能覆盖如此多的平台。 
Selenium 不同于一般的测试工具的操作ml 页面听用户对html 页面的操作的录制工具。Selenium 完全了解用户操作的html 页面。Selenium利用xpath对页面上的所有位置进行定位。（详见xpath.doc）
				
				</td>
				
				</tr>
				</table>
				<hr>
				<table width="900" >
				<tr>
				<td width="70"><img src="<%=basePath%>images/4_Pictures/boy2.jpg">
				</td>
				
				<td>Selenium 是 ThoughtWorks 专门为 Web应用程序编写的一个验收测试工具。与其他测试工具相比，使用 Selenium 的最大好处是： Selenium 测试直接在浏览器中运行，就像真实用户所做的一样。Selenium 测试可以在Windows、Linux和 MacintoshAnd 上的 Internet Explorer、Mozilla ，Opera， Firefox 中运行。其他测试工具都不能覆盖如此多的平台。 
Selenium 不同于一般的测试工具的操作ml 页面听用户对html 页面的操作的录制工具。Selenium 完全了解用户操作的html 页面。Selenium利用xpath对页面上的所有位置进行定位。（详见xpath.doc）
				
				</td>
				
				</tr>
	</table>
	<a href="<%=basePath%>4_wangshangbaoming_system/visitorPage/welcome.jsp"><img src="<%=basePath%>images/4_Pictures/return.gif"></a>
	</div>
	</body>