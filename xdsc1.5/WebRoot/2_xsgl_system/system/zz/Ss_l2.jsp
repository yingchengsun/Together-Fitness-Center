<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css.css">
		<script language="javascript" src="<%=request.getContextPath() %>/2_xsgl_system/JS/TableColor.js"></script>
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/2_xsgl_system/mycss.css">
	</head>


	<body>
	
		<br>
		<h3 align="center">
			助学金信息
		</h3>
		<hr>
		<div align="center">
		<form action="getStipendList.action">
			<table border="0" width="700" id="mytable">
				<tr>
					<th colspan="7" background="<%=request.getContextPath() %>/2_xsgl_system/Pictures/newmenubg.gif" height="30">
						<font color="#FFFFFF">软件学院学生助学金信息</font>
					</th>
				</tr>
				<tr>
					<th>
						班级
					</th>
					<th>
						总人数
					</th>
					
					<th>
						总金额
					</th>
						<th>
						年份
					</th>
					<th>
						详细信息
					</th>
					
				</tr>
				<tr>
					<c:forEach items="${JiangzhuList }" var="fund">
				<tr>
					<td>
						${fund.tabClasses.FClassNumber }
					</td>
					<td>${fund.FTotalNum }
					</td>				
					<td> 
						${fund.FAmount } 
					</td>
					<td> 
						${fund.FYear } 
					</td>
					<td>
						<a href="ClassList_2.jsp/getFStudentListByStipend.action">浏览</a>
					</td>
				</tr>
				</c:forEach>
			</table>
			</form>
		</div>
	</body>
</html>
