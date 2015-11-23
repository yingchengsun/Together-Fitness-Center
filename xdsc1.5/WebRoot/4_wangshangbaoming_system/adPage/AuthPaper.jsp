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
		url("");
	
}
</style>
	</head>
	<body >

		<div align="center">
			<br>
			<span style='font-size: 15.0pt; font-family: 黑体'>2010年攻读软件工程硕士专业学位考生报名表（单证）</span>
		</div>
		<br>
		<div align="center">
			<table width="66%">
				<tr>
					<td>
						<div align="left">
							<font size="2">招生单位代码(名称)：10701(西安电子科技大学)</font>
						</div>
					</td>
					<td>
						<div align="right">
							<font size="2">年 &nbsp; &nbsp;月</font>
						</div>
					</td>
				</tr>
			</table>
			<div align="center">
				<table class=MsoNormalTable border=1 cellspacing=0 cellpadding=0
					width=680
					style='width: 510.0pt; border-collapse: collapse; border: none'>
					<tr style='page-break-inside: avoid; height: 24.0pt'>
						<td width=63 colspan=3
							style='width: 47.25pt; border: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 24.0pt'>
							<p class=MsoNormal>
								<span style='font-size: 12.0pt; font-family: 仿宋_GB2312'>姓<span>
								</span>名</span>
							</p>
						</td>
						<td width=119 colspan=7
							style='width: 89.25pt; border: solid windowtext 1.0pt; border-left: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 24.0pt'>
							<p class=MsoNormal align=center style='text-align: center'>&nbsp; <span style='font-size: 12.0pt; font-family: 仿宋_GB2312'><s:property value="wsbmTabRegapplicant.FAppRegName"/></span>
							</p>
						</td>
						<td width=49 colspan=2
							style='width: 36.75pt; border: solid windowtext 1.0pt; border-left: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 24.0pt'>
							<p class=MsoNormal align=center style='text-align: center'>
								<span style='font-size: 12.0pt; font-family: 仿宋_GB2312'>性别</span>
							</p>
						</td>
						<td width=74 colspan=2
							style='width: 45.35pt; border: solid windowtext 1.0pt; border-left: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 24.0pt'>
							<p class=MsoNormal align=center style='text-align: center'>
								<span style='font-size: 12.0pt; font-family: 仿宋_GB2312'><s:property value="wsbmTabRegapplicant.FAppRegSex"/></span>
							</p>
						</td>
						<td width=81 colspan=4
							style='width: 70.6pt; border: solid windowtext 1.0pt; border-left: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 24.0pt'>
							<p class=MsoNormal align=center style='text-align: center'>
								<span style='font-size: 12.0pt; font-family: 仿宋_GB2312'>出生日期</span>
							</p>
						</td>
						<td width=174 colspan=5
							style='width: 130.65pt; border: solid windowtext 1.0pt; border-left: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 24.0pt'>
							<p class=MsoNormal align=center style='text-align: center'>
								<span style='font-size: 12.0pt; font-family: 仿宋_GB2312'></span><span style='font-size: 12.0pt; font-family: 仿宋_GB2312'><s:property value="AppRegBirthday"/></span>
							</p>
						</td>
						<td width=120 colspan=3 rowspan=5
							style='width: 90.15pt; border: solid windowtext 1.0pt; border-left: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 24.0pt'>
							<p class=MsoNormal style='text-indent: 36.0pt'>
								<span style='font-size: 12.0pt; font-family: 仿宋_GB2312'>照</span>
							</p>
							<p class=MsoNormal align=center style='text-align: center'>
								<span style='font-size: 12.0pt; font-family: 仿宋_GB2312'>片</span>
							</p>
							<p class=MsoNormal align=center style='text-align: center'>
								<span style='font-size: 12.0pt; font-family: 仿宋_GB2312'>&nbsp;</span>
							</p>
							<p class=MsoNormal align=center style='text-align: center'>
								<span style='font-size: 12.0pt; font-family: 仿宋_GB2312'>&nbsp;</span>
							</p>
						</td>
					</tr>
					<tr style='page-break-inside: avoid; height: 24.0pt'>
						<td width=105 colspan=5
							style='width: 78.75pt; border: solid windowtext 1.0pt; border-top: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 24.0pt'>
							<p class=MsoNormal
								style='text-align: justify; text-justify: distribute-all-lines'>
								<span
									style='font-size: 12.0pt; font-family: 仿宋_GB2312; letter-spacing: -.8pt'>身份证号码</span>
							</p>
						</td>
						<td width=262 colspan=12
							style='width: 186.65pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 24.0pt'>
							<p class=MsoNormal align=center style='text-align: center'>
								<span style='font-size: 12.0pt; font-family: 仿宋_GB2312'><s:property value="wsbmTabRegapplicant.FAppRegIdCard"/></span>
							</p>
						</td>
						<td width=84 colspan=3
							style='width: 73.0pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 24.0pt'>
							<p class=MsoNormal align=center style='text-align: center'>
								<span style='font-size: 12.0pt; font-family: 仿宋_GB2312'>政治面貌</span>
							</p>
						</td>
						<td width=109 colspan=3
							style='width: 71.45pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 24.0pt'>
							<p class=MsoNormal align=center style='text-align: center'>
								<span style='font-size: 12.0pt; font-family: 仿宋_GB2312'><s:property value="wsbmTabRegapplicant.FAppRegPolitical"/></span>
							</p>
						</td>
					</tr>
					<tr style='page-break-inside: avoid; height: 23.25pt'>
						<td width=156 colspan=8
							style='width: 127.0pt; border: solid windowtext 1.0pt; border-top: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 23.25pt'>
							<p class=MsoNormal
								style='text-align: justify; text-justify: distribute-all-lines'>
								<span style='font-size: 12.0pt; font-family: 仿宋_GB2312'>现工作或学习单位</span>
							</p>
						</td>
						<td width=404 colspan=15
							style='width: 302.85pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 23.25pt'>
							<p class=MsoNormal align=center style='text-align: center'>
								<span style='font-size: 12.0pt; font-family: 仿宋_GB2312'><s:property value="wsbmTabRegapplicant.FAppRegLocation"/></span>
							</p>
						</td>
					</tr>
					<tr style='page-break-inside: avoid; height: 23.25pt'>
						<td width=49 colspan=2
							style='width: 36.75pt; border: solid windowtext 1.0pt; border-top: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 23.25pt'>
							<p class=MsoNormal>
								<span style='font-size: 12.0pt; font-family: 仿宋_GB2312'>职务</span>
							</p>
						</td>
						<td width=98 colspan=4
							style='width: 73.5pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 23.25pt'>
							<p class=MsoNormal align=center style='text-align: center'>
								<span style='font-size: 12.0pt; font-family: 仿宋_GB2312'><s:property value="wsbmTabRegapplicant.FAppRegWorkDuty"/></span>
							</p>
						</td>
						<td width=49 colspan=5
							style='width: 46.75pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 23.25pt'>
							<p class=MsoNormal align=center style='text-align: center'>
								<span style='font-size: 12.0pt; font-family: 仿宋_GB2312'>职称</span>
							</p>
						</td>
						<td width=111 colspan=4
							style='width: 73.4pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 23.25pt'>
							<p class=MsoNormal align=center style='text-align: center'>
								<span style='font-size: 12.0pt; font-family: 仿宋_GB2312'><s:property value="wsbmTabRegapplicant.FAppRegWorkTitle"/></span>
							</p>
						</td>
						<td width=113 colspan=4
							style='width: 3.0cm; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 23.25pt'>
							<p class=MsoNormal>
								<span style='font-size: 12.0pt; font-family: 仿宋_GB2312'>本人联系电话</span>
							</p>
						</td>
						<td width=139 colspan=4
							style='width: 104.4pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 23.25pt'>
							<p class=MsoNormal>&nbsp; 
								<span style='font-size: 12.0pt; font-family: 仿宋_GB2312'><s:property value="wsbmTabRegapplicant.FAppRegTel"/></span>
							</p>
						</td>
					</tr>
					<tr style='page-break-inside: avoid; height: 23.25pt'>
						<td width=84 colspan=4
							style='width: 63.0pt; border: solid windowtext 1.0pt; border-top: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 23.25pt'>
							<p class=MsoNormal align=center style='text-align: center'>
								<span style='font-size: 12.0pt; font-family: 仿宋_GB2312'>通信地址<br>
							(</span><span
									style='font-size: 12.0pt; font-family: 仿宋_GB2312'>邮编<span>)</span>
								</span>
							</p>
						</td>
						<td width=476 colspan=19
							style='width: 356.85pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 23.25pt'>
							<p class=MsoNormal style='text-indent: 2.0pt'>
								<span style='font-size: 12.0pt; font-family: 仿宋_GB2312'><s:property value="wsbmTabRegapplicant.FAppRegAddress"/>(<s:property value="wsbmTabRegapplicant.FAppRegPostCode"/>)</span>
							</p>
						</td>
					</tr>
					<tr style='page-break-inside: avoid; height: 23.25pt'>
						<td width=84 colspan=4
							style='width: 63.0pt; border: solid windowtext 1.0pt; border-top: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 23.25pt'>
							<p class=MsoNormal align=center style='text-align: center'>
								<span style='font-size: 12.0pt; font-family: 仿宋_GB2312'>最后学历</span>
							</p>
						</td>
						<td width=422 colspan=17
							style='width: 316.8pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 23.25pt'>
							<p class=MsoNormal>
								<span style='font-size: 12.0pt; font-family: 仿宋_GB2312'>&nbsp;&nbsp;
								</span><span style='font-size: 12.0pt; font-family: 仿宋_GB2312'><s:property value="AppRegLastGraduDate"/>毕业于<s:property value="wsbmTabRegapplicant.FAppRegLastGraduInstitu"/><s:property value="wsbmTabRegapplicant.FAppRegLastGraduMajor"/>专业</span>
							</p>
						</td>
						<td width=98 colspan=3
							style='width: 83.5pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 23.25pt'>
							<p class=MsoNormal>
								<span style='font-size: 12.0pt; font-family: 仿宋_GB2312'>获学士时间</span>
							</p>
						</td>
						<td width=75
							style='width:46.1pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 23.25pt'>
							<p class=MsoNormal
								style='margin-right: -5.35pt; text-indent: 12.0pt'>
								<span style='font-size: 12.0pt; font-family: 仿宋_GB2312'><s:property value="AppRegLastBacheDegreeDate"/></span>
							</p>
						</td>
						<td style='border: none; border-bottom: solid windowtext 1.0pt'
							width=1>
							<p class='MsoNormal'>
								&nbsp;
						</td>
					</tr>
					<tr style='page-break-inside: avoid; height: 23.25pt'>
						<td width=84 colspan=4
							style='width: 63.0pt; border: solid windowtext 1.0pt; border-top: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 23.25pt'>
							<p class=MsoNormal align=center style='text-align: center'>
								<span style='font-size: 12.0pt; font-family: 仿宋_GB2312'>英语水平</span>
							</p>
						</td>
						<td width=194 colspan=9
							style='width: 145.8pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 23.25pt'>
							<p class=MsoNormal>
								<span style='font-size: 12.0pt; font-family: 仿宋_GB2312'>□</span><span
									style='font-size: 12.0pt; font-family: 仿宋_GB2312'>国家四级 </span><span
									style='font-size: 12.0pt; font-family: 仿宋_GB2312'>□</span><span
									style='font-size: 12.0pt; font-family: 仿宋_GB2312'>国家六级</span>
							</p>
						</td>
						<td width=82 colspan=3
							style='width: 61.2pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 23.25pt'>
							<p class=MsoNormal align=center style='text-align: center'>
								<span style='font-size: 12.0pt; font-family: 仿宋_GB2312'>学习方式</span>
							</p>
						</td>
						<td width=146 colspan=5
							style='width: 109.8pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 23.25pt'>
							<p class=MsoNormal>
								<span style='font-size: 12.0pt; font-family: 仿宋_GB2312'>□</span><span
									style='font-size: 12.0pt; font-family: 仿宋_GB2312'>全日制 </span><span
									style='font-size: 12.0pt; font-family: 仿宋_GB2312'>□</span><span
									style='font-size: 12.0pt; font-family: 仿宋_GB2312'>业余</span>
							</p>
						</td>
						<td width=53
							style='width: 39.6pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 23.25pt'>
							<p class=MsoNormal>
								<span style='font-size: 12.0pt; font-family: 仿宋_GB2312'>住宿</span>
							</p>
						</td>
						<td width=121 colspan=4
							style='width: 90.6pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 23.25pt'>
							<p class=MsoNormal>
								<span style='font-size: 12.0pt; font-family: 仿宋_GB2312'>□是</span><span
									style='font-size: 12.0pt; font-family: 仿宋_GB2312'>&nbsp;&nbsp;
								</span><span style='font-size: 12.0pt; font-family: 仿宋_GB2312'>□</span><span
									style='font-size: 12.0pt; font-family: 仿宋_GB2312'>否</span>
							</p>
						</td>
					</tr>
					<tr style='page-break-inside: avoid; height: 37.65pt'>
						<td width=156 colspan=8
							style='width: 117.0pt; border: solid windowtext 1.0pt; border-top: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 37.65pt'>
							<p class=MsoBodyText>
								<span style='font-size: 12.0pt; font-family: 仿宋_GB2312'>
									参加全国硕士研究生统一入学考试：</span>
							</p>
						</td>
						<td width=524 colspan=18
							style='width: 393.0pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 37.65pt'>
							<p class=MsoNormal style='margin-right: -5.35pt'>
								<span style='font-size: 12.0pt; font-family: 仿宋_GB2312'>□是</span><span
									style='font-size: 12.0pt; font-family: 仿宋_GB2312'>&nbsp;&nbsp;
								</span><span style='font-size: 12.0pt; font-family: 仿宋_GB2312'>□</span><span
									style='font-size: 12.0pt; font-family: 仿宋_GB2312'>否<span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								</span>报考专业名称：<s:property value="wsbmTabRegapplicant.FAppRegQgtkao"/></span>
							</p>
							<p class=MsoNormal style='margin-right: -5.35pt'>
								<span style='font-size: 12.0pt; font-family: 仿宋_GB2312'>总分：<span><s:property value="wsbmTabRegapplicant.FAppRegBackUpText"/></span>英语：<span><s:property value="wsbmTabRegapplicant.FAppRegQgtkaoEnglish"/></span>数学：<span><s:property value="wsbmTabRegapplicant.FAppRegQgtkaoZhengzhi"/></span>专业课：<span><s:property value="wsbmTabRegapplicant.FAppRegQgtkaoZhuanYeKe"/></span> </span>
							</p>
						</td>
					</tr>
					<tr style='page-break-inside: avoid; height: 38.1pt'>
						<td width=156 colspan=8
							style='width: 117.0pt; border: solid windowtext 1.0pt; border-top: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 38.1pt'>
							<p class=MsoBodyText>
								<span style='font-size: 12.0pt; font-family: 仿宋_GB2312'>
									曾参加何种<br>专业技术培训</span>
							</p>
						</td>
						<td width=524 colspan=18
							style='width: 393.0pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 38.1pt'>
							<p class=MsoNormal style='margin-right: -5.35pt'>
								<span style='font-size: 12.0pt; font-family: 仿宋_GB2312'>&nbsp;</span>
							</p>
						</td>
					</tr>
					<tr style='page-break-inside: avoid; height: 19.85pt'>
						<td width=36 rowspan=2
							style='width: 26.8pt; border: solid windowtext 1.0pt; border-top: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 19.85pt'>
							<p class=MsoNormal align=center
								style='margin-left: .1pt; text-align: center; text-indent: -.1pt'>
								<span style='font-size: 12.0pt; font-family: 仿宋_GB2312'>考生个人简历</span>
							</p>
						</td>
						<td width=119 colspan=6
							style='width: 89.6pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 19.85pt'>
							<p class=MsoNormal align=center
								style='margin-left: .1pt; text-align: center; text-indent: -.1pt'>
								<span style='font-size: 12.0pt; font-family: 仿宋_GB2312'>起止年月</span>
							</p>
						</td>
						<td width=525 colspan=19
							style='width: 393.6pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 19.85pt'>
							<p class=MsoNormal align=center
								style='margin-left: .1pt; text-align: center; text-indent: -.1pt'>
								<span style='font-size: 12.0pt; font-family: 仿宋_GB2312'>在何地、何部门、任何职务（从中学开始填写）</span>
							</p>
						</td>
					</tr>
					<tr style='page-break-inside: avoid; height: 142.75pt'>
						<td width=119 colspan=6
							style='width: 89.6pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 142.75pt'>
							<p class=MsoNormal align=center
								style='margin-left: .1pt; text-align: center; text-indent: -.1pt'>
								<span style='font-size: 12.0pt; font-family: 仿宋_GB2312'>&nbsp;</span>
							</p>
							<p class=MsoNormal align=center
								style='margin-left: .1pt; text-align: center; text-indent: -.1pt'>
								<span style='font-size: 12.0pt; font-family: 仿宋_GB2312'>&nbsp;</span>
							</p>
							<p class=MsoNormal align=center
								style='margin-left: .1pt; text-align: center; text-indent: -.1pt'>
								<span style='font-size: 12.0pt; font-family: 仿宋_GB2312'>&nbsp;</span>
							</p>
						</td>
						<td width=525 colspan=19
							style='width: 393.6pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 100.75pt'>
							<p class=MsoNormal><s:property value="wsbmTabRegapplicant.FAppRegCv"/> 
								<span style='font-size: 12.0pt; font-family: 仿宋_GB2312'></span>
							</p>
						</td>
					</tr>
					<tr style='page-break-inside: avoid'>
						<td width=680 colspan=26
							style='width: 510.0pt; border: solid windowtext 1.0pt; border-top: none; padding: 0cm 5.4pt 0cm 5.4pt'>
							
							
							<p class="MsoNormal"> 
								<span style="font-size: 12pt; font-family: 仿宋_GB2312;">&nbsp;&nbsp; 
								</span><span style="font-size: 12pt; font-family: 仿宋_GB2312;">我承诺：以上填写的各项内容均属实。<br>考生签名：<br>2010</span><span style="font-size: 12pt; font-family: 仿宋_GB2312;">年<span>&nbsp;&nbsp;&nbsp; 
								</span>月<span>&nbsp;&nbsp;&nbsp; </span>日</span> 
							</p>
						</td>
					</tr>
					<tr style='page-break-inside: avoid'>
						<td width=680 colspan=26
							style='width: 510.0pt; border: solid windowtext 1.0pt; border-top: none; padding: 0cm 5.4pt 0cm 5.4pt'>
							<p class=MsoNormal align=center style='text-align: center'>
								<b><span style='font-size: 12.0pt; font-family: 仿宋_GB2312'>（以上各项由考生本人填写）</span>
								</b>
							</p>
						</td>
					</tr>
					<tr style='page-break-inside: avoid; height: 103.9pt'>
						<td width=680 colspan=26 valign=top
							style='width: 510.0pt; border: solid windowtext 1.0pt; border-top: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 103.9pt'>
							<p class=MsoNormal>
								<span style='font-size: 12.0pt; font-family: 仿宋_GB2312'>招生部门审核意见（包括对报名资格和考试科目的意见）：</span>
							</p>
							<p class=MsoNormal>
								<span style='font-size: 12.0pt; font-family: 仿宋_GB2312'>&nbsp;</span>
							</p>
							<p class=MsoNormal>
								<span style='font-size: 12.0pt; font-family: 仿宋_GB2312'>&nbsp;</span>
							</p>
							
							
							
							<p class="MsoNormal" style="text-indent: 6pt;"> 
								<span style="font-size: 12pt; font-family: 仿宋_GB2312;">&nbsp;</span> 
							<br>&nbsp; 
			<span style="font-size: 12pt; font-family: 仿宋_GB2312;"></span><span style="font-size: 12pt; font-family: 仿宋_GB2312;">审核人签字：<br></span><span style="font-size: 12pt; font-family: 仿宋_GB2312;">招生单位盖章：</span> 
							</p>
							<p class=MsoNormal>
								<span style='font-size: 12.0pt; font-family: 仿宋_GB2312'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									2010</span><span style='font-size: 12.0pt; font-family: 仿宋_GB2312'>年<span>&nbsp;&nbsp;
								</span>月<span>&nbsp;&nbsp; </span>日</span>
							</p>
						</td>
					</tr>
					<tr height=0>
						<td width=36 style='border: none'></td>
						<td width=13 style='border: none'></td>
						<td width=14 style='border: none'></td>
						<td width=21 style='border: none'></td>
						<td width=21 style='border: none'></td>
						<td width=42 style='border: none'></td>
						<td width=8 style='border: none'></td>
						<td width=1 style='border: none'></td>
						<td width=24 style='border: none'></td>
						<td width=2 style='border: none'></td>
						<td width=14 style='border: none'></td>
						<td width=35 style='border: none'></td>
						<td width=47 style='border: none'></td>
						<td width=26 style='border: none'></td>
						<td width=2 style='border: none'></td>
						<td width=53 style='border: none'></td>
						<td width=7 style='border: none'></td>
						<td width=18 style='border: none'></td>
						<td width=35 style='border: none'></td>
						<td width=31 style='border: none'></td>
						<td width=55 style='border: none'></td>
						<td width=53 style='border: none'></td>
						<td width=1 style='border: none'></td>
						<td width=45 style='border: none'></td>
						<td width=75 style='border: none'></td>
						<td width=1 style='border: none'></td>
					</tr>
				</table>
				<p class=MsoNormal>
					<span style='font-family: 仿宋_GB2312'>注：有选择项目的，在相应</span><span
						style='font-family: 仿宋_GB2312'>□内打√；<span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					</span>
					</span>
				</p>
			</div>
		</div>
	</body>
</html>
