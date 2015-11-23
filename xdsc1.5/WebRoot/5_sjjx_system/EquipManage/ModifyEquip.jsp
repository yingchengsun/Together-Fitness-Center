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
		<h3 align="center">修改设备基本信息</h3>
		<table align="center" width="700">
			<tr>
				<th align="left"><a href="showallEquip.action"><img src="5_sjjx_system/Pictures/return.gif" align="top" border="0"/>返回</a></th>
			</tr>
		</table> 
		<hr>
		<div align="center">
			<form action="updateEquip.action" method="post">
				<table border="1" width="700">
					<tr>
						<th height="30" colspan="2" align="center" background="5_sjjx_system/Pictures/newmenubg.gif">
							<font color="#FFFFFF">填写设备信息</font>
						</th>
					</tr>
					<tr>
						<td>
							领用单位：
						</td>
						<td>
							<input type="text" name="FDepartmentId" value="${equip.FDepartmentId }" size="60"/>
						</td>
					</tr>
					<tr>
						<td>
							单位名称：
						</td>
						<td>
							<input type="text" name="FDepartmentName" value="${equip.FDepartmentName }" size="60"/>
						</td>
					</tr>
					<tr>
						<td>
							设备类型：
						</td>
						<td>
							<input type="text" name="FEquTypeName" value="${equip.sjjxTabEquipmenttype.FEquTypeName }" size="60" readonly="readonly"/>
						</td>
					</tr>
					<tr>
						<td>
							设备编号：
						</td>
						<td>
							<input type="text" name="FEquId" value="${equip.FEquId }"  size="60"/>
						</td>
					</tr>
					<tr>
						<td>
							设备名称：
						</td>
						<td>
							<input type="text" name="FEquName" value="${equip.FEquName }" size="60"/>
						</td>
					</tr>
					<tr>
						<td>
							设备品牌：
						</td>
						<td>
							<input type="text" name="FEquBrand" value="${equip.FEquBrand }" size="60"/>
						</td>
					</tr>
					<tr>
						<td>
							设备型号：
						</td>
						<td>
							<input type="text" name="FEquPattern" value="${equip.FEquPattern }" size="60"/>
						</td>
					</tr>
					<tr>
						<td>
							设备规格：
						</td>
						<td>
							<input type="text" name="FEquStandard" value="${equip.FEquStandard }" size="60"/>
						</td>
					</tr>
					<tr>
						<td>
							设备单价：
						</td>
						<td>
							<input type="text" name="FEquPrice" value="${equip.FEquPrice }" size="60"/>
						</td>
					</tr>
					<tr>
						<td>
							出厂号：
						</td>
						<td>
							<input type="text" name="FChuChangId" value="${equip.FChuChangId }" size="60"/>
						</td>
					</tr>
					<tr>
						<td>
							购买日期：
						</td>
						<td>
							<input readonly="readonly" type="text" name="FEquBuyTime" id="aa" value="${equip.FEquBuyTime }"
								onclick="getDateString(this,oCalendarChs)" size="60">
						</td>
					</tr>
					
					<tr>
						<td>
							领用人：
						</td>
						<td>
							<input type="text" name="FPersonL" value="${equip.FPersonL }" size="60"/>
						</td>
					</tr>
					<tr>
						<td>
							经手人：
						</td>
						<td>
							<input type="text" name="FPersonJ" value="${equip.FPersonJ }" size="60"/>
						</td>
					</tr>
					<tr>
						<td>
							实际使用人：
						</td>
						<td>
							<input type="text" name="FPersonS" value="${equip.FPersonS }" size="60"/>
						</td>
					</tr>
					<tr>
						<td>
							备注：
						</td>
						<td>
							<input type="text" name="FRemarks" value="${equip.FRemarks }" size="60"/>
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
