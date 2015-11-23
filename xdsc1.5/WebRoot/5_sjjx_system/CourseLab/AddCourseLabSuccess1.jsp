<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
			
			function checktwice(){
				var input = document.getElementById("labid").value
				if(input.length==0)
				{
					document.getElementById("isnull").style.visibility="visible";
					document.getElementById("isnull").innerHTML="必须填入实验室编号";
				}
				else{
					document.getElementById("isnull").style.visibility="hidden";
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
		<h3 align="center">
			成功添加课程安排信息
		</h3>
		<h3 align="center">
			继续添加课程安排信息
		</h3>
		<table align="center" width="700">
			<tr>
				<th align="left"><a href="showAllCourseLab.action"><img src="5_sjjx_system/Pictures/return.gif" align="top" border="0"/>返回</a></th>
			</tr>
	    </table> 
		<hr>
		<div align="center">
			<form action="addCourseLabInfo1.action" method="post">
				<table border="1" width="700">
					<tr>
						<th height="30" colspan="2" align="center" background="5_sjjx_system/Pictures/newmenubg.gif">
							<font color="#FFFFFF">填写信息</font>
						</th>
					</tr>
					<tr>
						<td>
							任课教师：
						</td>
						<td>
						   <input type="text" name="FTeacherName"  size="60"/>
						</td>
					</tr>
					<tr>
						<td>
							课程名称：
						</td>
						<td>
							<input type="text" name="FCourseName"  size="60"/>
						</td>
					</tr>
					<tr>
						<td>
							年级：
						</td>
						<td>
							<input type="text" name="FGradeName"  size="60"/>
						</td>
					</tr>
					<tr>
						<td>
							班级：
						</td>
						<td>
							<input type="text" name="FClassNumber"  size="60"/>
						</td>
					</tr>
					<tr>
						<td>
							专业方向：
						</td>
						<td>
							<input type="text" name="FDirectionName"  size="60"/>
						</td>
					</tr>
					<tr>
						<td>
							上课日期：
						</td>
						<td>
							<input type="text" readonly="readonly" name="FDate" id="aa" onclick="getDateString(this,oCalendarChs)" size="60">
						</td>
					</tr>
					<tr>
						<td>
							实验室编号：
						</td>
						<td>
						<input onkeyup="check(this.value)" type="text" name="FLabId" size="60" id="labid"/>
						<div id="isnull" style="visibility: hidden"></div>
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
							<input type="submit" value="提交" onmouseover="checktwice()"/>
						</td>
					</tr>
				</table>
			</form>
		</div> 

	</body>
</html>
