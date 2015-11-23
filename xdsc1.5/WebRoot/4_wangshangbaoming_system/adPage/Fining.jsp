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
		<h3 align="center">登记考生概览<br> 
			 
		</h3>
		<hr>
		<table align="center" width="80%">
			<tr>
				<th align="right"> 
					点击考生系统注册号查看其详细信息<br>
			  </th>
			</tr>
		</table>
		<div align="center">
				<table border="1" width="80%">
					<tr>
							<th colspan="10" align="center" background="<%=basePath%>images/4_Pictures/newmenubg.gif"> 
							<font color="#ffffff">考生信息</font> 
						</th>
					</tr>
					<tr>
						<td>序号<br>
						</td>
						<td>   
							系统注册号<br></td>
						<td> 
							姓名<br>
						</td>
						<td>身份证号<br>
						</td>
						<td>毕业学校
						</td>
					</tr>
					
					<s:iterator value="listRegapplicantinfo" status="status">
				   <tr>
				     <td align="center"><s:property value="#status.count"/></td>
				     <td align="center">
				     <a href="adAllCheck!sepFindByNum.action?FAppRegNum=<s:property value="FAppRegNum"/>"><s:property value="FAppRegNum"/></a>
				     </td>
				     <td align="center"><s:property value="FAppRegName"/></td>
				     <td align="center"><s:property value="FAppRegIdCard"/></td>
				     <td align="center"><s:property value="FAppRegLastGraduInstitu"/></td>
				     </tr>
				     </s:iterator>
				</table>
				<table width="40%" align="center">
			<tr>
				<td>
					<div align="center">
						<a href="adAllCheck!Fining.action?p=1">首页</a>
					</div>
				</td>
				<td>
					<div align="center">
						<a
							href="adAllCheck!Fining.action?p=${p-1}">上一页</a>
					</div>
				</td>
				<td>
					<div align="center">
						<a
							href="adAllCheck!Fining.action?p=${p+1}">下一页</a>
					</div>
				</td>
				<td>
					<div align="center">
						<a
							href="adAllCheck!Fining.action?p=${lastPage}">末页</a>
					</div>
				</td>
			</tr>
		</table>
		</div>


	</body>
</html>
