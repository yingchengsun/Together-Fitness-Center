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

		<link rel="stylesheet" type="text/css" href="css.css">
		<link rel="stylesheet" type="text/css" href="5_sjjx_system/mycss.css">
		<script language="javascript" src="5_sjjx_system/JS/PopupCalendar.js"></script>
        <script type="text/javascript">
			function check(number){
				if(isNaN(number))
				{
					window.alert("输入有误，请重新填写");
				}
			}
		</script>
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
		<h3 align="center">添加设备详细信息</h3>
		<table align="center" width="700">
			<tr>
				<th align="left"><a href="showallEquip.action"><img src="5_sjjx_system/Pictures/return.gif" align="top" border="0"/>返回</a></th>
			</tr>
		</table> 
		<hr>
		<div align="center">
			<form action="addEquipDetailInfo.action" method="post">
				<table border="1" width="700">
					<tr>
						<th height="30" colspan="2" align="center" background="5_sjjx_system/Pictures/newmenubg.gif">
							<font color="#FFFFFF">填写设备详细信息</font>
						</th>
					</tr>
					<tr>
						<td>
							设备编号：
						</td>
						<td>
						    <input type="hidden" name="FExLabId" value="${labId }">
							<input type="text" name="FEquId" value="${equipid }" readonly="readonly" size="60"/>
						</td>
					</tr>
					<tr>
						<td>
							调拨时间：
						</td>
						<td>
							<input readonly="readonly" type="text" name="FEquMoveTime" id="aa"
								onclick="getDateString(this,oCalendarChs)" size="60">
						</td>
					</tr>
					<tr>
						<td>
							新实验室编号：
						</td>
						<td>
							<input onkeyup="check(this.value)" type="text" name="FLabId" size="60"/>
						</td>
					</tr>
					<tr>
						<td>
							使用状态：
						</td>
						<td>
							<input type="radio" name="BaoFei" value="0" checked="checked">
							正常
							<input type="radio" name="BaoFei" value="1">
							报废
						</td>
					</tr>
					<tr>
						<td>
							报废时间：
						</td>
						<td>
							<input readonly="readonly" type="text" name="FEquBreakTime"  id="aa"
								onclick="getDateString(this,oCalendarChs)" size="60">
						</td>
					</tr>
					<tr>
						<td>
							报废原因：
						</td>
						<td>
							<input type="text" name="FEquBreakReason" size="60">
						</td>
					</tr>
					<tr>
						<td>
							
							<input type="reset" value="重置" />
						</td>
						<td>
							<input type="submit" value="提交" />
						</td>
					</tr>
				</table>
			</form>
		</div>		
		<br>
	</body>
</html>
