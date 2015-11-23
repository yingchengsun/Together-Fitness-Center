<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
	        <base href="<%=basePath%>"> 
		<link rel="stylesheet" type="text/css" href="<%=basePath%>css.css">
		<link rel="stylesheet" type="text/css" href="<%=basePath%>mycss.css">
				<style type="text/css">
		body {
	font-family: arial, 宋体, serif;
	font-size:12px;
	background-image:url("<%=basePath%>Pictures/newbackground.png");
}
		.STYLE5 {
			font-family: "华文行楷";
			font-size: 14mm;
			color: #000000;
		}

		.STYLE6 {
			font-family: "隶书";
			font-size: 12mm;
			color: #000000;
			font-style: italic;
		}
		.STYLE7 {
			font-family: "隶书";
			font-size: 7mm;
			color: #000000;
		}
</style>
		<script language="javascript" src="<%=basePath%>js/TableColor.js"></script>
		<script language="javascript" src="<%=basePath %>js/PopupCalendar.js"></script>
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
	</head>

	<body>
	
		<br>
		<br>
		<h3 align="center">
			<img src="<%=basePath%>Pictures/Office14.jpg" align="top" border="0" width="50" height="50"/>就业记录
		</h3>
		<hr>
	
		
		<div align="center">
		<table border="0" width="700" id="mytable" method="post">
          <tr >
           
            <td width="17%" height="24" align="left"><div align="center"><strong>学号：</strong></div></td>
		    <td width="31%" align="left"><s:property value="workStudent.TabStudents.FStudentNumber"/></td>
		    <td width="14%" align="left"><div align="center"><strong>姓名：</strong></div></td>
		    <td width="17%" align="left"><s:property value="workStudent.TabStudents.FStudentName"/></td>
		    
	      </tr>
	      <tr >
	      	
            <td width="17%" height="24" align="left"><div align="center"><strong>用人单位：</strong></div></td>
		    <td width="31%" align="left"><s:property value="workStudent.TabCompany.FCompanyName"/></td>
		               <td width="17%" height="24" align="left"><div align="center"><strong>职位：</strong></div></td>
		    <td width="31%" align="left"><s:property value="workStudent.FPosition"/></td>
	      </tr>
	      <tr >
	      	<td width="14%" align="left"><div align="center"><strong>就业城市：</strong></div></td>
		    <td width="17%" align="left"><s:property value="workStudent.FWorkCity"/></td>
 			<td width="17%" height="24" align="left"><div align="center"><strong>电子邮件：</strong></div></td>
		    <td width="31%" align="left"><s:property value="workStudent.FEmail"/></td>
		   
	      </tr>
	    
          <tr >
            <td width="17%" height="24" align="left"><div align="center"><strong>去向变更：</strong></div></td>
		    <td width="31%" align="left"><s:property value="workStudent.FWorkAdd"/></td>
		    </tr>
   </table>
		
			<table width="80%" border="0" align="center">
					<tr>
				<th align="right"><a href="student/WorkInfo!findWorkInfoByID.action?FNumber=<s:property value="workStudent.FNumber"/>"  ><img src="<%=basePath%>Pictures/fujian.gif" align="top" border="0"/>修改信息</a></th>
			</tr>
				</table>
		</div>
		<br>
		<br>
		<br>
	</body>
</html>
