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
							姓名
						</div>
					</td>
					<td>
						<div align="left">
							您所填写的姓名需与身份证上所写的姓名完全一致
						</div>
					</td>
				</tr>
				<tr>
					<td width="38.2%">
						<div align="center">
							系统帐号
						</div>
					</td>
					<td>
						<div align="left">
							请您填写您的
							<font color="red">常用手机号码</font>，您的系统帐号将是您登陆系统的用户名，请您牢记
						</div>
					</td>
				</tr>
				<tr>
					<td width="38.2%">
						<div align="center">
							密码
						</div>
					</td>
					<td>
						<div align="left">
							请您牢记系统登陆密码
						</div>
					</td>
				</tr>
			</table>
		</div>
		<div align="center">
			<hr>
			<form action="register.action" method="post" theme="simple" name="Form">
				<table border="0" width="300px" id="mytable"
					background="<%=basePath%>images/4_Pictures/newbg.GIF">
					<tr>
						<th background="<%=basePath%>images/4_Pictures/newmenubg.gif"
							colspan="2" height="20">
							<font color="#FFFFFF">注册 </font></th>
					</tr>
					<TR>
						<TD >
								<div align="right">*性别</div>
						</TD>
						<TD background="#ffffff">
							<div align="left">
								<select name="FAppRegSex">
									<option value="男">
										男
									</option>
									<option value="女">
										女
									</option>
								</select>
							</div>
						</TD>
					</TR>
					
					<TR>
						<TD >
							<div align="right">*籍贯</div>
						</TD>
						<TD>
							<div align="left">
								<select name="FAppRegHomeTown">
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
						<TD>
							<div align="right">*民族</div>
						</TD>
						<TD>
							<div align="left">
								<select name="FAppRegNation">
									<option value="汉族">
										汉族
									</option>
									<option value="回族">
										回族
									</option>
									<option value="蒙古族">
										蒙古族
									</option>
									<option value="藏族">
										藏族
									</option>
									<option value="维吾尔族">
										维吾尔族
									</option>
									<option value="苗族">
										苗族
									</option>
									<option value="彝族">
										彝族
									</option>
									<option value="壮族">
										壮族
									</option>
									<option value="布依族">
										布依族
									</option>
									<option value="朝鲜族">
										朝鲜族
									</option>
									<option value="满族">
										满族
									</option>
									<option value="侗族">
										侗族
									</option>
									<option value="瑶族">
										瑶族
									</option>
									<option value="白族">
										白族
									</option>
									<option value="土家族">
										土家族
									</option>
									<option value="哈尼族">
										哈尼族
									</option>
									<option value="哈萨克族">
										哈萨克族
									</option>
									<option value="傣族">
										傣族
									</option>
									<option value="黎族">
										黎族
									</option>
									<option value="傈僳族">
										傈僳族
									</option>
									<option value="佤族">
										佤族
									</option>
									<option value="畲族">
										畲族
									</option>
									<option value="高山族">
										高山族
									</option>
									<option value="拉祜族">
										拉祜族
									</option>
									<option value="水族">
										水族
									</option>
									<option value="东乡族">
										东乡族
									</option>
									<option value="纳西族">
										纳西族
									</option>
									<option value="景颇族">
										景颇族
									</option>
									<option value="柯尔克孜">
										柯尔克孜
									</option>
									<option value="土族">
										土族
									</option>
									<option value="达斡尔族">
										达斡尔族
									</option>
									<option value="仫佬族">
										仫佬族
									</option>
									<option value="羌族">
										羌族
									</option>
									<option value="布朗族">
										布朗族
									</option>
									<option value="撒拉族">
										撒拉族
									</option>
									<option value="毛难族">
										毛难族
									</option>
									<option value="仡佬族">
										仡佬族
									</option>
									<option value="锡伯族">
										锡伯族
									</option>
									<option value="阿昌族">
										阿昌族
									</option>
									<option value="普米族">
										普米族
									</option>
									<option value="塔吉克族">
										塔吉克族
									</option>
									<option value="怒族">
										怒族
									</option>
									<option value="乌孜别克">
										乌孜别克
									</option>
									<option value="俄罗斯族">
										俄罗斯族
									</option>
									<option value="鄂温克族">
										鄂温克族
									</option>
									<option value="崩龙族">
										崩龙族
									</option>
									<option value="保安族">
										保安族
									</option>
									<option value="裕固族">
										裕固族
									</option>
									<option value="京族">
										京族
									</option>
									<option value="塔塔尔族">
										塔塔尔族
									</option>
									<option value="独龙族">
										独龙族
									</option>
									<option value="鄂伦春族">
										鄂伦春族
									</option>
									<option value="赫哲族">
										赫哲族
									</option>
									<option value="门巴族">
										门巴族
									</option>
									<option value="珞巴族">
										珞巴族
									</option>
									<option value="基诺族">
										基诺族
									</option>
									<option value="外国血统">
										外国血统
									</option>
								</select>
							</div>
						</TD>
					</TR>
					<TR>
						<TD >
							<div align="right">*身份证号</div>
						</TD>
						<TD>
							<div align="left">
								<input type="text" name="FAppRegIdCard" maxlength="18"/>
							</div>
						</TD>
					</TR>
					<TR>
						<TD width="30%">
							<div align="right">*姓名</div>
						</TD>
						<TD>
							<div align="left">
								<input type="text" name="FAppRegName" maxlength="10" />
							</div>
						</TD>
					</TR>
					<TR>
						<TD>
								<div align="right">*手机号<br>(系统登陆帐号)</div> 
						</TD>
						<TD>
							<div align="left">
								<input type="text" name="FUserNumber" maxlength="11"/>
							</div>
						</TD>
					</TR>
					<TR>
						<TD>
							<div align="right">*登陆密码</div>
						</TD>
						<TD>
							<div align="left">
								<input size="10" type="password" name="FUserPassword" maxlength="6"/>
							</div>
						</TD>
					</TR>
					<TR>
						<TD>
							<div align="right">*确认密码</div>
						</TD>
						<TD>
							<div align="left">
								<input size="10" type="password" name="confirm" maxlength="6"/>
							</div>
						</TD>
					</TR>
				
				</TABLE>
				<div align="center">
					<input type="submit" value="提交" onclick="return CheckForm()"/>
					<input type="reset" value="取消" />
				</div>
				<div align="center">
					<font color="red" size="4" face="aria"><s:fielderror/></font>
				</div>
			</form>
			
	<SCRIPT language=javascript>
	function CheckForm(){

	var password=document.Form.FUserPassword.value;
	var confirm=document.Form.confirm.value;

	if(password!=confirm)
	{
	alert("两次密码不一致");
	return false;
	}
	}
</SCRIPT>
		</div>
	</body>
	
	
</html>
