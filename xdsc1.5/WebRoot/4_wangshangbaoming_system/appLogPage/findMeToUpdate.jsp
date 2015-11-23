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
		<br>
		<h3 align="center"> 
			考生信息修改 
		</h3>
		<div align="center">
		<form action="adAllCheck!appMeUpdate.action" method="post">
			<table border="1" width="61.8%"
				background="<%=basePath%>images/4_Pictures/newbackground.png"
				id="mytable">

				<tr>
					<th height="20" colspan="2" align="center"
						background="<%=basePath%>images/4_Pictures/newmenubg.gif">
					</th>
				</tr>

				<tr>
					<td>
						政治面貌
					</td>
					<td>
						<input type="text" name="FAppRegPolitical" value="<s:property value="wsbmTabRegapplicant.FAppRegPolitical" />">
					</td>
				</tr>

				<tr>
					<td>
						现所在地
					</td>
					<td>
						<input type="text" name="FAppRegLocation" value="<s:property value="wsbmTabRegapplicant.FAppRegLocation" />">
					</td>
				</tr>

				<tr>
					<td>
						现工作职务
					</td>
					<td>
						<input type="text" name="FAppRegWorkDuty" value="<s:property value="wsbmTabRegapplicant.FAppRegWorkDuty" />">
					</td>
				</tr>

				<tr>
					<td>
						现工作职称
					</td>
					<td>
						<input type="text" name="FAppRegWorkTitle" value="<s:property value="wsbmTabRegapplicant.FAppRegWorkTitle" />">
					</td>
				</tr>

				<tr>
					<td>
						联系电话
					</td>
					<td>
						<input type="text" name="FAppRegTel" value="<s:property value="wsbmTabRegapplicant.FAppRegTel" />">
					</td>
				</tr>

				<tr>
					<td>
						地址
					</td>
					<td>
						<input type="text" name="FAppRegAddress" value="<s:property value="wsbmTabRegapplicant.FAppRegAddress" />">
					</td>
				</tr>

				<tr>
					<td>
						邮编
					</td>
					<td>
						<input type="text" name="FAppRegPostCode" value="<s:property value="wsbmTabRegapplicant.FAppRegPostCode" />">
					</td>
				</tr>

				<tr>
					<td>
						最后学历毕业日期
					</td>
					<td>
						<input type="text" name="FAppRegLastGraduDate" value="<s:property value="wsbmTabRegapplicant.FAppRegLastGraduDate" />">
					</td>
				</tr>

				<tr>
					<td>
						最后学历毕业院校
					</td>
					<td>
						<input type="text" name="FAppRegLastGraduInstitu" value="<s:property value="wsbmTabRegapplicant.FAppRegLastGraduInstitu"/>">
					</td>
				</tr>

				<tr>
					<td>
						最后学历毕业专业
					</td>
					<td>
						<input type="text" name="FAppRegLastGraduMajor" value="<s:property value="wsbmTabRegapplicant.FAppRegLastGraduMajor" />">
					</td>
				</tr>

				<tr>
					<td>
						学士学位获得日期
					</td>
					<td>
						<input type="text" name="FAppRegLastBacheDegreeDate" value="<s:property value="wsbmTabRegapplicant.FAppRegLastBacheDegreeDate" />">
					</td>
				</tr>

				<tr>
					<td>
						学位证编号
					</td>
					<td>
						<input type="text" name="FAppRegXueWeiZhengNum" value="<s:property value="wsbmTabRegapplicant.FAppRegXueWeiZhengNum" />">
					</td>
				</tr>

				<tr>
					<td>
						毕业证编号
					</td>
					<td>
						<input type="text" name="FAppRegBiYeZhengNum" value="<s:property value="wsbmTabRegapplicant.FAppRegBiYeZhengNum" />">
					</td>
				</tr>

				<tr>
					<td>
						电子邮件
					</td>
					<td>
						<input type="text" name="FAppRegEmail" value="<s:property value="wsbmTabRegapplicant.FAppRegEmail" />">
					</td>
				</tr>

				<tr>
					<td>
						四级成绩
					</td>
					<td>
						<input type="text" name="FAppRegCet4" value="<s:property value="wsbmTabRegapplicant.FAppRegCet4" />">
					</td>
				</tr>

				<tr>
					<td>
						六级成绩
					</td>
					<td>
						<input type="text" name="FAppRegCet6" value="<s:property value="wsbmTabRegapplicant.FAppRegCet6" />">
					</td>
				</tr>


				<tr>
					<td>
						简历信息
					</td>
					<td>
						<input type="text" name="FAppRegCv" value="<s:property value="wsbmTabRegapplicant.FAppRegCv" />">
					</td>
				</tr>
			</table>
			<input type="submit" value="提交修改">
			</form>
		</div>


	</body>
</html>