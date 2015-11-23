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
			游客注册账号
		</h3>
		<hr>
		<div align="center">
			<table width="61.8%">
				<tr>
					<th align="left">
						<font size='2' face="aria">资料填写规范:</font>
					</th>
				</tr>
				<tr>
					<td width="38.2%">
						<div align="center">
							本科毕业学校
						</div>
					</td>
					<td>
						<div align="left">
							请填写学校全称
						</div>
					</td>
				</tr>
				<tr>
					<td width="38.2%">
						<div align="center">
							本科毕业专业
						</div>
					</td>
					<td>
						<div align="left">
							或多专业学位需分别注明
						</div>
					</td>
				</tr>
			</table>
		</div>
		<div align="center">
		<hr>
			<form action="apreg!getvalue3.action" method="post">
				<table border="1" width="51.8%" id="mytable"
					background="<%=basePath%>images/4_Pictures/newbg.GIF">
					<tr>
						<th background="<%=basePath%>images/4_Pictures/newmenubg.gif" colspan="2" height="20">
							<font color="#FFFFFF">表3/4:学历信息</font>
						</th>
					</tr>
					<TR>
						<TD align="center">
							<P>
								<SPAN class=staralt>*</SPAN>本科毕业学校
							</P>
						</TD>
						<TD>
							<div align="center">
								<input type="text" name="AppRegLastGraduInstitu" maxlength="20"
									value="">
							</div>
						</TD>
					</TR>

					<TR>
						<TD align="center">
							*本科毕业时间
						</TD>
						<TD>
							<div align="center">
								<input readonly="readonly" type="text"
									name="AppRegLastGraduDate"
									onclick="getDateString(this,oCalendarChs)" />
							</div>
						</TD>
					</TR>

					<TR>
						<TD align="center">
							<P>
								<SPAN class=staralt>*</SPAN>本科毕业专业
							</P>
						</TD>
						<TD>
							<div align="center">
								<input type="text" name="AppRegLastGraduMajor" maxlength="20"
									value="">
							</div>
						</TD>
					</TR>
					<TR>
						<TD align="center">
							*获学士学位时间
						</TD>
						<TD>
							<div align="center">
								<input readonly="readonly" type="text"
									name="AppRegLastBacheDegreeDate"
									onclick="getDateString(this,oCalendarChs)" />
							</div>
						</TD>
					</TR>
					<TR>
						<TD align="center">
							<span class="staralt">*</span>学位证书编号
						</TD>
						<TD>
							<div align="center">
								<input type="text" maxlength="6" name="AppRegXueWeiZhengNum">
							</div>
						</TD>
					</TR>
					<TR>
						<TD align="center">
							*毕业证书编号
						</TD>
						<TD>
							<div align="center">
								<input type="text" name="AppRegBiYeZhengNum" maxlength="26"
									style="IME-MODE: disabled">
							</div>
						</TD>
					</TR>
				</table>
				<div align="center">
					<input type="submit" name="提交" value="继续" />
					<input type="reset" value="取消" />
				</div>
			</form>
		</div>
	</body>
</html>
