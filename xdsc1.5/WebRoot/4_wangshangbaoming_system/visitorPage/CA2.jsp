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
			<form action="apreg!getvalue2.action" method="post">
				<table border="1" width="51.8%" id="mytable"
					background="<%=basePath%>images/4_Pictures/newbg.GIF">
					<tr>
						<th background="<%=basePath%>images/4_Pictures/newmenubg.gif" colspan="2" height="20">
							<font color="#FFFFFF">表2/4：工作信息</font>
						</th>
					</tr>
					<TR>
						<TD align="center">
							*现工作单位
							<br>
							(档案所在地)
						</TD>
						<TD>
							<div align="center">
								<select name="AppRegLocation">
									<option value=""></option>
									<option value="北京市">
										北京市
									</option>
									<option value="天津市">
										天津市
									</option>
									<option value="河北省">
										河北省
									</option>
									<option value="山西省">
										山西省
									</option>
									<option value="内蒙古区">
										内蒙古区
									</option>
									<option value="辽宁省">
										辽宁省
									</option>
									<option value="吉林省">
										吉林省
									</option>
									<option value="黑龙江省">
										黑龙江省
									</option>
									<option value="上海市">
										上海市
									</option>
									<option value="江苏省">
										江苏省
									</option>
									<option value="浙江省">
										浙江省
									</option>
									<option value="安徽省">
										安徽省
									</option>
									<option value="福建省">
										福建省
									</option>
									<option value="江西省">
										江西省
									</option>
									<option value="山东省">
										山东省
									</option>
									<option value="河南省">
										河南省
									</option>

									<option value="湖北省">
										湖北省
									</option>
									<option value="湖南省">
										湖南省
									</option>
									<option value="广东省">
										广东省
									</option>
									<option value="广西区">
										广西区
									</option>
									<option value="海南省">
										海南省
									</option>
									<option value="重庆市">
										重庆市
									</option>
									<option value="四川省">
										四川省
									</option>
									<option value="贵州省">
										贵州省
									</option>
									<option value="云南省">
										云南省
									</option>
									<option value="西藏区">
										西藏区
									</option>
									<option value="陕西省">
										陕西省
									</option>
									<option value="甘肃省">
										甘肃省
									</option>
									<option value="青海省">
										青海省
									</option>
									<option value="宁夏区">
										宁夏区
									</option>
									<option value="新疆区">
										新疆区
									</option>
									<option value="台湾省">
										台湾省
									</option>
									<option value="香港特别行政区">
										香港特别行政区
									</option>
									<option value="澳门特别行政区">
										澳门特别行政区
									</option>
								</select>
							</div>
						</TD>
					</TR>
					<TR>
						<TD align="center">
							<P>
								<SPAN class=staralt>*</SPAN>职务
							</P>
						</TD>
						<TD>
							<div align="center">
								<input type="text" name="AppRegWorkDuty" maxlength="20"
									value="">
							</div>
						</TD>
					</TR>
					<TR>
						<TD align="center">
							<P>
								<SPAN class=staralt>*</SPAN>职称
							</P>
						</TD>
						<TD>
							<div align="center">
								<input type="text" name="AppRegWorkTitle" maxlength="20"
									value="">
							</div>
						</TD>
					</TR>
					<TR>
						<TD align="center">
							<SPAN class=staralt>*</SPAN>联系电话(手机)
						</TD>
						<TD>
							<div align="center">
								<input type="text" name="AppRegTel" maxlength="20" value="">
							</div>
						</TD>
					</TR>
					<TR>
						<TD align="center">
							<P>
								<SPAN class=staralt>*</SPAN>电子信箱
							</P>
						</TD>

						<TD>
							<div align="center">
								<input type="text" name="AppRegEmail" maxlength="50" value="">
							</div>
						</TD>
					</TR>
					<TR>
						<TD align="center">
							<P>
								<SPAN class=staralt>*</SPAN>通讯地址
							</P>
						</TD>
						<TD>
							<div align="center">
								<input type="text" name="AppRegAddress" maxlength="100"
									value="">
							</div>
						</TD>
					</TR>
					<TR>
						<TD align="center">
							<P>
								<SPAN class=staralt>*</SPAN>邮政编码
							</P>
						</TD>
						<TD>
							<div align="center">
								<input type="text" name="AppRegPostCode" maxlength="8" value=""">
							</div>
						</TD>
					</TR>
					<TR>
						<TD align="center">
							<P>
								<SPAN class=staralt>*</SPAN>政治面貌
							</P>
						</TD>
						<TD>
							<div align="center">
								<select name="AppRegPolitical">
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
