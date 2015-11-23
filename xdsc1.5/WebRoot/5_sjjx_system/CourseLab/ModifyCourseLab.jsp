<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
	
	<link rel="stylesheet" type="text/css" href="css.css">
	<link rel="stylesheet" type="text/css" href="5_sjjx_system/mycss.css">
    <script language="javascript" src="5_sjjx_system/JS/PopupCalendar.js"></script>
    <script type="text/javascript">
			function check(number){
				if(isNaN(number))
				{
					window.alert("请重新输入实验室编号");
					
				}
			}
		</script>
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
		<h3 align="center">详细信息</h3>
		<table align="center" width="700">
			<tr>
				<th align="left"><a href="showAllCourseLab.action"><img src="5_sjjx_system/Pictures/return.gif" align="top" border="0"/>返回</a></th>
			</tr>
		</table> 
		<hr>
		<div align="center">
              <form action="updateCourseLab.action" method="post">
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
							<input type="text" name="FCourseName" value="${courselab.tabCourse.FCourseName }" size="60"/>
						    <input type="hidden" name="FNumber" value="${courselab.FNumber }"/>
						</td>
					</tr>
					<tr>
						<td>
							任课教师：
						</td>
						<td>
							<input type="text" name="FTeacherName" value="${courselab.tabTeachers.FTeacherName }" size="60"/>
						</td>
					</tr>
					<tr>
						<td>
							班级：
						</td>
						<td>
							<input type="text" name="FClassNumber" value="${courselab.tabClasses.FClassNumber }" size="60"/>
						</td>
					</tr>
					<tr>
						<td>
							上课日期：
						</td>
						<td>
							<input type="text" name="FDate" value="${courselab.FDate }" id="aa" onclick="getDateString(this,oCalendarChs)" size="60" >
						</td>
					</tr>
					<tr>
						<td>
							实验室编号：
						</td>
						<td>
						<input onkeyup="check(this.value)" type="text"  name="FLabId" value="${courselab.sjjxTabLab.FLabId }" size="60"/>
						</td>
					</tr>
					<tr>
						<td>
							具体时间：
						</td>
						<td>
							<input type="radio" name="exactTime" value="0" checked="checked">
							下午
							<input type="radio" name="exactTime" value="1">
							晚上
						</td>
					</tr>
					<tr>
					    <td>
					       <input type="reset" value="重置" />
					    </td>
						<td>
							<input type="submit" value="提交" />
						</td>
					</tr>
				</table>
			</form>
		</div>
		
		<br>
  </body>
</html>