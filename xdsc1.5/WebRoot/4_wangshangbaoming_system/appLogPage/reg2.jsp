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
			完善个人信息
		</h3>
		<hr>
		<div align="center">
			<table width="61.8%">
				<tr>
					<th align="left"><font size='2' face="aria">资料填写规范:</font>
					</th>
				</tr>
				<tr>
					<td width="38.2%">
						<div align="center">
							现工作单位
						</div>
					</td>
					<td>
						<div align="left">
							请填写您的档案所在地
						</div>
					</td>
				</tr>
				<tr>
					<td width="38.2%">
						<div align="center">
							职务
						</div>
					</td>
					<td>
						<div align="left">如果您未工作，请填写数字“0”
						</div>
					</td>
				</tr>
				<tr>
					<td width="38.2%">
						<div align="center">职称<br> 
							 
						</div>
					</td>
					<td>
						<div align="left">
							如果您未工作，请填写数字“0”
						</div>
					</td>
				</tr>
			</table>
		</div>
		<div align="center">
		<hr>
			<form action="appUp!reg2.action" method="post">
				<table border="1" width="41.8%" id="mytable"
					background="<%=basePath%>images/4_Pictures/newbg.GIF">
					<tr>
						<th background="<%=basePath%>images/4_Pictures/newmenubg.gif" colspan="2" height="20">
							<font color="#FFFFFF">工作信息</font>
						</th>
					</tr>
					<tr>
						<TD><div align="right">
							*出生日期</div>
						</TD>
						<TD>
							<div align="left">
								<input type="text" name="FAppRegBirthday"
									onclick="getDateString(this,oCalendarChs)" />
							</div>
						</TD>
					</TR>
					<TR>
						<TD>
							<div align="right">*现工作单位
							<br>
							(档案所在地)</div>
						</TD>
						<TD>
							<div align="left">
								<input name="FAppRegLocation1" type="text" size="6">省
								<input name="FAppRegLocation2" type="text"size="6">市/县
								<input name="FAppRegLocation3" type="text"size="10">（单位名）
							</div>
						</TD>
					</TR>
					<TR>
						<TD>
								<div align="right">*职务</div>
						</TD>
						
						<TD>
							<div align="left">
								<input type="text" name="FAppRegWorkDuty" maxlength="20"
									value="">
							</div>
						</TD>
					</TR>
					
					<TR>
						<TD><div align="right">
								*职称</div>
						</TD>
						<TD>
							<div align="left">
								<input type="text" name="FAppRegWorkTitle" maxlength="20"
									value="">
							</div>
						</TD>
					</TR>
					<TR>
						<TD>
							<div align="right">*联系电话(手机)</div>
						</TD>
						<TD>
							<div align="left">
								<input type="text" name="FAppRegTel" maxlength="20" value="">
							</div>
						</TD>
					</TR>
					<TR>
						<TD>
								<div align="right">*电子信箱</div>
						</TD>

						<TD>
							<div align="left">
								<input type="text" name="FAppRegEmail" maxlength="50" value="">
							</div>
						</TD>
					</TR>
					<TR>
						<TD>
							<div align="right">*通讯地址</div>
						</TD>
						<TD>
							<div align="left">
								<input type="text" name="FAppRegAddress" maxlength="100"
									value="">
							</div>
						</TD>
					</TR>
					<TR>
						<TD>
							<div align="right">*邮政编码</div>
						</TD>
						<TD>
							<div align="left">
								<input type="text" name="FAppRegPostCode" maxlength="8" value=""">
							</div>
						</TD>
					</TR>
					<TR>
						<TD>
							<div align="right">*政治面貌</div>
						</TD>
						<TD>
							<div align="left">
								<select name="FAppRegPolitical">
									<option value="" selected="selected"></option>
									<option value="党员">
										党员
									</option>
									<option value="群众">
										群众
									</option>
									<option value="团员">
										团员
									</option>
								</select>
								<input type="submit" name="提交" value="继续" />
					<input type="reset" value="取消" />
							</div>
						</TD>
					</TR>
				</table>
			</form>
		</div>
	</body>
</html>
