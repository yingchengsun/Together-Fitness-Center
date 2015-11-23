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
			考生信息一览
		</h3>
		<div align="center">
			<table width="500"
				background="<%=basePath%>images/4_Pictures/newbackground.png"
				id="mytable">

				<tr>
					<th height="20" colspan="2" align="center"
						background="<%=basePath%>images/4_Pictures/newmenubg.gif">
					</th>
				</tr>

				<tr>
					<td width="120">
						<div align="left">
							姓名
						</div>
					</td>
					<td>
						<div align="left"><s:property value="wsbmTabRegapplicant.FAppRegName" /></div>
					</td>
				</tr>

				<tr>
					<td width="120">
						<div align="left">
							性别
						</div>
					</td>
					<td>
						<div align="left"><s:property value="wsbmTabRegapplicant.FAppRegSex" /></div>
					</td>
				</tr>

				<tr>
					<td width="120">
						<div align="left">
							民族
						</div>
					</td>
					<td>
						<div align="left"><s:property value="wsbmTabRegapplicant.FAppRegNation" /></div>
					</td>
				</tr>

				<tr>
					<td width="120">
						<div align="left">
							籍贯
						</div>
					</td>
					<td>
						<div align="left"><s:property value="wsbmTabRegapplicant.FAppRegHomeTown" /></div>
					</td>
				</tr>

				<tr>
					<td width="120">
						<div align="left">
							出生日期
						</div>
					</td>
					<td>
						<div align="left"><s:property value="wsbmTabRegapplicant.FAppRegBirthday" /></div>
					</td>
				</tr>

				<tr>
					<td width="120">
						<div align="left">
							身份证号码
						</div>
					</td>
					<td>
						<div align="left"><s:property value="wsbmTabRegapplicant.FAppRegIdCard" /></div>
					</td>
				</tr>

				<tr>
					<td width="120">
						<div align="left">
							政治面貌
						</div>
					</td>
					<td>
						<div align="left"><s:property value="wsbmTabRegapplicant.FAppRegPolitical" /></div>
					</td>
				</tr>

				<tr>
					<td width="120">
						<div align="left">
							现所在地
						</div>
					</td>
					<td>
						<div align="left"><s:property value="wsbmTabRegapplicant.FAppRegLocation" /></div>
					</td>
				</tr>

				<tr>
					<td width="120">
						<div align="left">
							现工作职务
						</div>
					</td>
					<td>
						<div align="left"><s:property value="wsbmTabRegapplicant.FAppRegWorkDuty" /></div>
					</td>
				</tr>

				<tr>
					<td width="120">
						<div align="left">
							现工作职称
						</div>
					</td>
					<td>
						<div align="left"><s:property value="wsbmTabRegapplicant.FAppRegWorkTitle" /></div>
					</td>
				</tr>

				<tr>
					<td width="120">
						<div align="left">
							联系电话
						</div>
					</td>
					<td>
						<div align="left"><s:property value="wsbmTabRegapplicant.FAppRegTel" /></div>
					</td>
				</tr>

				<tr>
					<td width="120">
						<div align="left">
							地址
						</div>
					</td>
					<td>
						<div align="left"><s:property value="wsbmTabRegapplicant.FAppRegAddress" /></div>
					</td>
				</tr>

				<tr>
					<td width="120">
						<div align="left">
							邮编
						</div>
					</td>
					<td>
						<div align="left"><s:property value="wsbmTabRegapplicant.FAppRegPostCode" /></div>
					</td>
				</tr>

				<tr>
					<td width="120">
						<div align="left">
							最后学历毕业日期
						</div>
					</td>
					<td>
						<div align="left"><s:property value="wsbmTabRegapplicant.FAppRegLastGraduDate" /></div>
					</td>
				</tr>

				<tr>
					<td width="120">
						<div align="left">
							最后学历毕业院校
						</div>
					</td>
					<td>
						<div align="left"><s:property value="wsbmTabRegapplicant.FAppRegLastGraduInstitu" /></div>
					</td>
				</tr>

				<tr>
					<td width="120">
						<div align="left">
							最后学历毕业专业
						</div>
					</td>
					<td>
						<div align="left"><s:property value="wsbmTabRegapplicant.FAppRegLastGraduMajor" /></div>
					</td>
				</tr>

				<tr>
					<td width="120">
						<div align="left">
							学士学位获得日期
						</div>
					</td>
					<td>
						<div align="left"><s:property value="wsbmTabRegapplicant.FAppRegLastBacheDegreeDate" /></div>
					</td>
				</tr>

				<tr>
					<td width="120">
						<div align="left">
							学位证编号
						</div>
					</td>
					<td>
						<div align="left"><s:property value="wsbmTabRegapplicant.FAppRegXueWeiZhengNum" /></div>
					</td>
				</tr>

				<tr>
					<td width="120">
						<div align="left">
							毕业证编号
						</div>
					</td>
					<td>
						<div align="left"><s:property value="wsbmTabRegapplicant.FAppRegBiYeZhengNum" /></div>
					</td>
				</tr>

				<tr>
					<td width="120">
						<div align="left">
							电子邮件
						</div>
					</td>
					<td><div align="left">
						<s:property value="wsbmTabRegapplicant.FAppRegEmail" /></div>
					</td>
				</tr>

				<tr>
					<td width="120">
						<div align="left">
							四级成绩
						</div>
					</td>
					<td>
						<div align="left"><s:property value="wsbmTabRegapplicant.FAppRegCet4" /></div>
					</td>
				</tr>

				<tr>
					<td width="120">
						<div align="left">
							六级成绩
						</div>
					</td>
					<td>
						<div align="left"><s:property value="wsbmTabRegapplicant.FAppRegCet6" /></div>
					</td>
				</tr>

				<tr>
					<td width="120">
						<div align="left">
							全国统考考号
						</div>
					</td>
					<td>
						<div align="left"><s:property value="wsbmTabRegapplicant.FAppRegQgtkaoNum" /></div>
					</td>
				</tr>

				<tr>
					<td width="120">
						<div align="left">
							全国统考专业
						</div>
					</td>
					<td>
						<div align="left"><s:property value="wsbmTabRegapplicant.FAppRegQgtkao" /></div>
					</td>
				</tr>

				<tr>
					<td width="120">
						<div align="left">
							国统考数学成绩
						</div>
					</td>
					<td>
						<div align="left"><s:property value="wsbmTabRegapplicant.FAppRegQgtkaoZhengzhi" /></div>
					</td>
				</tr>

				<tr>
					<td width="120">
						<div align="left">
							全国统考英语成绩
						</div>
					</td>
					<td>
						<div align="left"><s:property value="wsbmTabRegapplicant.FAppRegQgtkaoEnglish" /></div>
					</td>
				</tr>

				<tr>
					<td width="120">
						<div align="left">
							全国统考专业课成绩
						</div>
					</td>
					<td>
						<div align="left"><s:property value="wsbmTabRegapplicant.FAppRegQgtkaoZhuanYeKe" /></div>
					</td>
				</tr>

				<tr>
					<td width="120">
						<div align="left">
							简历信息
						</div>
					</td>
					<td>
						<div align="left"><s:property value="wsbmTabRegapplicant.FAppRegCv" /></div>
					</td>
				</tr>

				<tr>
					<td width="120">
						<div align="left">
							复试报考的专业课
						</div>
					</td>
					<td>
						<div align="left"><s:property value="wsbmTabRegapplicant.FAppRegZhuanYeKe" /></div>
					</td>
				</tr>


				<tr>
					<td width="120">
						<div align="left">
							是否已交报名费
						</div>
					</td>
					<td>
						<div align="left"><s:property value="wsbmTabRegapplicant.FAppRegBaoMingFei" /></div>
					</td>
				</tr>

				<tr>
					<td width="120">
						<div align="left">
							否要上辅导班
						</div>
					</td>
					<td>
						<div align="left"><s:property value="wsbmTabRegapplicant.FAppRegFuDaoBan" /></div>
					</td>
				</tr>

				<tr>
					<td width="120">
						<div align="left">
							为其分配的准考证号
						</div>
					</td>
					<td>
						<div align="left"><s:property value="wsbmTabRegapplicant.FAppRegZhunKaoZhengHao" /></div>
					</td>
				</tr>



				<tr>
					<td width="120">
						<div align="left">资料审核是否通过</div>
					</td>
					<td>
						<div align="left"><s:property value="wsbmTabRegapplicant.FAppRegPassAuth" /></div>
					</td>
				</tr>

				<tr>
					<td width="120">
						<div align="left">
							预录取是否通过
						</div>
					</td>
					<td>
						<div align="left"><s:property value="wsbmTabRegapplicant.FAppRegPassPreAd" /></div>
					</td>
				</tr>

				<tr>
					<td width="120">
						<div align="left">
							是否已录取
						</div>
					</td>
					<td>
						<div align="left"><s:property value="wsbmTabRegapplicant.FAppRegPassFinAd" /></div>
					</td>
				</tr>
			</table>
		</div>


	</body>
</html>