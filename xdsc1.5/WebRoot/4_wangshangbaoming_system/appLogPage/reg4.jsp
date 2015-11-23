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
		<title>完善信息</title>

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
			完善信息</h3>
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
			</table>
		</div>
		<div align="center">
		<hr>
			<form action="appUp!reg4.action" method="post">
				<table border="1" width="41.8%" id="mytable"
					background="<%=basePath%>images/4_Pictures/newbg.GIF">
					<tr>
						<th background="<%=basePath%>images/4_Pictures/newmenubg.gif" colspan="2" height="20">
							<font color="#FFFFFF">其他信息</font>
						</th>
					</tr>
					<TR>
						<TD >
							<div align="right"><span class="staralt">*</span>参加全国研究生统考考号</div>
						</TD>
						<TD>
							<div align="left">
								<input type="text" name="FAppRegQgtkaoNum" maxlength="26"
									value="" style="IME-MODE: disabled">
							</div>
						</TD>
					</TR>
					
					<TR>
						<TD >
							<div align="right"><span class="staralt">*</span>参加全国研究生统考专业</div>
						</TD>
						<TD>
							<div align="left">
								<input type="text" name="FAppRegQgtkao" maxlength="26"
									value="" >
							</div>
						</TD>
					</TR>

					<TR>
						<TD align="center">
							<div align="right"><span class="staralt">*</span>全国统考专业课成绩 </div>
						</TD>
						<TD>
							<div align="left">
								<input type="text" name="FAppRegQGTKaoZhuanYeKe" maxlength="50">
							</div>
						</TD>
					</TR>
					<TR>
						<TD align="center">
							<div align="right"><span class="staralt">*</span>全国统考英语成绩</div>
						</TD>
						<TD>
							<div align="left">
								<input type="text" name="FAppRegQGTKaoEnglish" maxlength="50">
							</div>
						</TD>
					</TR>
					<TR>
						<TD align="center">
							<div align="right"><span class="staralt">*</span>全国统考数学成绩 </div>
						</TD>
						<TD>
							<div align="left">
								<input type="text" name="FAppRegQGTKaoZhengzhi" maxlength="50">
							</div>
						</TD>
					</TR>
					
					<TR>
						<TD align="center">
							<div align="right"><span class="staralt">*</span>全国统考总分</div>
						</TD>
						<TD>
							<div align="left">
								<input type="text" name="FAppRegBackUpText" maxlength="50">
							</div>
						</TD>
					</TR>
					<TR>
						<TD align="center">
							<div align="right">
								*请输入你的英语四级成绩</div>
							
						</TD>
						<TD>
							<div align="left">
								<input type="text" name="FAppRegCet4" maxlength="16"">
							</div>
						</TD>
					</TR>
					<TR>
						<TD align="center">
							<div align="right">*请输入你的英语六级成绩</div>
						</TD>
						<TD>
							<div align="left">
								<input type="text" name="FAppRegCet6" maxlength="16"">
							</div>
						</TD>
					</TR>
					
					<TR>
						<TD align="center">
							<div align="right">*您是否原参加辅导班</div>
						</TD>
						<TD>
							<div align="left">
								<select name="FAppRegFuDaoBan">
									<option value="Y">愿意</option>
									<option value="N">不愿意</option>
								</select>
							</div>
						</TD>
					</TR>
					
					<TR>
						<TD align="center">
							<div align="right">*您选择参加的专业课考试</div>
						</TD>
						<TD>
							<div align="left">
								<select name="FAppRegZhuanYeKe">
									<option value="数据结构">数据结构</option>
									<option value="微机原理">微机原理</option>
								</select>
							</div>
						</TD>
					</TR>

					<TR>
						<TD >
							<div align="right">*何时，何地，何部门，任何职务</div>
						</TD>
						<TD>
							<div align="left">
								<textarea name="FAppRegCv" cols="30"></textarea>
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
