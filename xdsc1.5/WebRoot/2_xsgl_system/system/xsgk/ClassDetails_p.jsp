<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
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
			2009届研究生信息 
		</h3>
		<hr>
		<div align="center">
					<form action="ProjectManagement.jsp">
						<font size="2">精确查找：</font>
						<select>
							<option>
								----选择查询方式----
							</option>
							<option value="0">
								学生学号
							</option>
							<option value="1">
								学生姓名
							</option>
						</select>
						<input type="text" name="attribute" />
						<input type="submit" value="搜索">
					</form>		
		</div>
		<hr>
		
		
			<div align="center">
			<form action="showClassList.action">
			<table border="0" width="700" id="mytable">
				<tr>
					<th colspan="7" background="<%=request.getContextPath() %>/2_xsgl_system/Pictures/newmenubg.gif" height="30">
						<font color="#FFFFFF">软件学院2009届研究生信息</font>
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
						男生人数
					</th>
					<th>
						女生人数
					</th>
					<th>
						学生名单
					</th>
				</tr>
				<c:forEach items="${classList }" var="tabClass">
				<tr>
					<td>${tabClass.FClassNumber }
					</td>
					<td>${tabClass.FClassTotalNum } 
					</td>				
					<td>${tabClass.FClassMaleNum } 
					</td>
					<td>${tabClass.FClassFemaleNum } 
					</td>
					<td>
						<a href="Class1.jsp"><img src="<%=request.getContextPath() %>/2_xsgl_system/Pictures/userinfo.gif"
								align="middle" border="0" /> </a>
					</td>
				</tr>
				</c:forEach>
			</table>
			</form>
		</div>
	</body>
</html>
