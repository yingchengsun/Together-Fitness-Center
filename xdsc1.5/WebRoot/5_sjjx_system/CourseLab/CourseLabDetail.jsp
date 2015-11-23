<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'CourseLabDetail.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="css.css">
	<link rel="stylesheet" type="text/css" href="5_sjjx_system/mycss.css">
    <script language="javascript" src="5_sjjx_system/JS/PopupCalendar.js"></script>

  </head>
  
  <body>
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
   <br>
		<br>
		<h3 align="center">成功修改课程安排信息</h3>
		<table align="center" width="700">
			<tr>
				<th align="left"><a href="showAllCourseLab.action"><img src="5_sjjx_system/Pictures/return.gif" align="top" border="0"/>返回</a></th>
			</tr>
		</table> 
		<hr>
		<div align="center">
              <form action="CourseLabDetail.jsp" method="post">
				<table border="1" width="700">
					<tr>
						<th height="30" colspan="2" align="center" background="5_sjjx_system/Pictures/newmenubg.gif">
							<font color="#FFFFFF">详细信息</font>
						</th>
					</tr>
					<tr>
						<td>
							课程名称：
						</td>
						<td>
							<input type="text" name="FCourseName" value="${courselab.tabCourse.FCourseName }" size="60" readonly="readonly"/>
						    <input type="hidden" name="FNumber" value="${courselab.FNumber }"/>
						</td>
					</tr>
					<tr>
						<td>
							任课教师：
						</td>
						<td>
							<input type="text" name="FTeacherName" value="${courselab.tabTeachers.FTeacherName }" size="60" readonly="readonly"/>
						</td>
					</tr>
					<tr>
						<td>
							班级：
						</td>
						<td>
							<input type="text" name="FClassNumber" value="${courselab.tabClasses.FClassNumber }" size="60" readonly="readonly"/>
						</td>
					</tr>
					<tr>
						<td>
							上课日期：
						</td>
						<td>
							<input type="text" name="FDate" value="${courselab.FDate }" id="aa" onclick="getDateString(this,oCalendarChs)" readonly="readonly" size="60">
						</td>
					</tr>
					<tr>
						<td>
							实验室编号：
						</td>
						<td>
						<input type="text" name="FLabId" value="${courselab.sjjxTabLab.FLabId }" size="60" readonly="readonly"/>
						</td>
					</tr>
					<tr>
						<td>
							具体时间：
						</td>
						<td>
							<input type="text" name="FExactTime" value="${courselab.FExactTime }" size="60" readonly="readonly"/>
						</td>
					</tr>
				</table>
			</form>
		</div>
		
		<br>
  </body>
</html>