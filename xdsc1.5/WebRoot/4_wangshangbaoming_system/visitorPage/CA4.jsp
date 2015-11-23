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
							全国统考号
						</div>
					</td>
					<td>
						<div align="left">
							无则填写数字“0”
						</div>
					</td>
				</tr>
				<tr>
					<td width="38.2%">
						<div align="center">
							全国统考成绩
						</div>
					</td>
					<td>
						<div align="left">
							格式如：“数学：90；英语：90；专业课：90；政治：90”
						</div>
					</td>
				</tr>
			</table>
		</div>
		<div align="center">
		<hr>
			<form action="apreg!getvalue4.action" method="post">
				<table border="1" width="51.8%" id="mytable"
					background="<%=basePath%>images/4_Pictures/newbg.GIF">
					<tr>
						<th background="<%=basePath%>images/4_Pictures/newmenubg.gif" colspan="2" height="20">
							<font color="#FFFFFF">表4/4：其他信息</font>
						</th>
					</tr>
					<TR>
						<TD align="center">
							<span class="staralt">*</span>参加全国研究生统考考号
						</TD>
						<TD>
							<div align="center">
								<input type="text" name="AppRegQgtkaoNum" maxlength="26"
									value="" style="IME-MODE: disabled">
							</div>
						</TD>
					</TR>

					<TR>
						<TD align="center">
							<span class="staralt">*</span>全国统考专业名称及各科成绩：(有则填，无则先填0，等待审核)
						</TD>
						<TD>
							<div align="center">
								<input type="text" name="AppRegQgtkao" value="" maxlength="50">
							</div>
						</TD>
					</TR>
					<TR>
						<TD align="center">
							<P>
								请输入你的英语四级成绩
							</P>
						</TD>
						<TD>
							<div align="center">
								<input type="text" name="AppRegCet4" maxlength="16"">
							</div>
						</TD>
					</TR>
					<TR>
						<TD align="center">
							请输入你的英语六级成绩
						</TD>
						<TD>
							<div align="center">
								<input type="text" name="AppRegCet6" maxlength="16"">
							</div>
						</TD>
					</TR>

					<TR>
						<TD align="center">
							*何时，何地，何部门，任何职务
						</TD>
						<TD>
							<div align="center">
								<textarea name="AppRegCv" cols="30"></textarea>
							</div>
						</TD>
					</TR>
				</TABLE>
				<div align="center">
					<input type="submit" name="提交" value="继续" />
					<input type="reset" value="取消" />
				</div>
			</form>
		</div>
	</body>
</html>
