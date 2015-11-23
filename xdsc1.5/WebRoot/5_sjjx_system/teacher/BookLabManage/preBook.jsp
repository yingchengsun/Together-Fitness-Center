<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
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
		<h3 align="center">预定机房</h3>
		<table align="center" width="700">
			<tr>
				<th align="right">
					<a href="showCourseLabT.action?userNumber=${userNumber }"><img
								src="5_sjjx_system/Pictures/foward.png" align="top" border="0" />查看实验安排 
					</a>
				</th>
			</tr>
		</table>
		<hr>
		<div align="center">
			<form action="unique.action" method="post">
				<table border="1" width="400">
				<tr>
						<th height="30" colspan="2" align="center" background="5_sjjx_system/Pictures/newmenubg.gif">
							<font color="#FFFFFF">填写信息</font>
						</th>
					</tr>
					
				    <tr>
				    	<td>日期</td>
				    	<td><input type="text" readonly="readonly" name="FDate" id="aa" onclick="getDateString(this,oCalendarChs)">
				    	</td>
				    </tr>
				    <tr>
				    	<td>具体时间</td>
				    	<td>
				    	<input type="radio" name="FExactTime" value="pm" checked="checked">下午
				    	<input type="radio" name="FExactTime" value="ev" >晚上
				    	</td>
				    </tr>
				    <tr>
				    	<td>校区</td>
				    	<td><input type="radio" name="Fxiaoqu" value="south" checked="checked">南校区
				    		<input type="radio" name="Fxiaoqu" value="north">北校区</td>
				    </tr>
				     <tr>
					    <td>上机人数</td>
				        <td><input type="text" name="Frenshu"></td>
				    </tr>
				    <tr>
				        <td>班级</td>
				        <td><select name="FClassNumber">
    	                      <c:forEach items="${class_list}" var="result1">
    		                     <option value="${result1.FClassNumber }">${result1.FClassNumber }</option>
    	                      </c:forEach>
    	                    </select>
    	                </td>
    	            </tr>
		    	    <tr>
		    	    	<td>课程</td>
		    	    	<td><select name="FCourseName">
						    	<c:forEach items="${course_list}" var="result2">
						    		<option value="${result2.FCourseName }">${result2.FCourseName }</option>
						    	</c:forEach>
							</select>
						</td>
					</tr>
				    <tr>
				        <td>&nbsp;</td>
				        <td align="right"><input type="submit" value="提交"></td>
				    </tr>
				</table>
			</form>
			</div>	
  </body>
</html>
