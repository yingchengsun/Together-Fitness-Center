<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
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
	<script language="javascript" src="5_sjjx_system/JS/TableColor.js"></script>

  </head>
  
  <body>
    <br>
      <c:choose>
		<c:when test="${isempty=='1'}">
			<h3 align="center">
			目前还无实验安排
		    </h3>
		    <table align="center" width="700">
			<tr>
				<th align="left"><a href="<%=request.getContextPath()%>/search.action"><img src="5_sjjx_system/Pictures/return.gif" align="top" border="0"/>返回</a></th>
			</tr>
		</table> 
		</c:when>
		<c:otherwise>
		<h3 align="center">
			已有实验课程安排
		</h3>
		<table align="center" width="700">
			<tr>
				<th align="left"><a href="<%=request.getContextPath()%>/search.action"><img src="5_sjjx_system/Pictures/return.gif" align="top" border="0"/>返回</a></th>
			</tr>
		</table> 
		<hr>
		<div align="center">
			<table border="0" width="700" id="mytable">
				<tr>
					<th colspan="8" background="5_sjjx_system/Pictures/newmenubg.gif" height="30">
						<font color="#FFFFFF">实验课程安排如下</font>
					</th>
				</tr>
				<tr>
					<th>
						日期
					</th>
					<th>
						课程名称
					</th>
					<th>
						班级
					</th>
					<th>
						实验室名称
					</th>
					<th>
						具体时间
					</th>
				</tr>
				<c:forEach items="${courseLabList }" var="courselab">
				<tr>
					<td>
						<fmt:formatDate value="${courselab.FDate}" type="date" pattern="yyyy-MM-dd"/>
					</td>				
					<td>
						${courselab.tabCourse.FCourseName }
					</td>
					<td>
						${courselab.tabClasses.FClassName }
					</td>
					<td>
						${courselab.sjjxTabLab.FLabName }
					</td>
					<td>
						 ${courselab.FExactTime }
					</td>				
				</tr>
				</c:forEach>
			</table>
		    <table width="40%">
					<tr>
						<td>
							<div align="center">
								<a href="previousT.action">上一页</a>
							</div>
						</td>
						<td>
							<div align="center">
								<a href="nextT.action">下一页</a>
							</div>
						</td>
						<td>
							当前第${courseLabAll.page+1 }页,共${courseLabAll.pageCount }页
						</td>
					</tr>
			</table>
		</div>
		</c:otherwise>
		</c:choose>
		<br>
  </body>
</html>
