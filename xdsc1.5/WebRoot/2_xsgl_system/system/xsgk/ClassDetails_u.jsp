<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="../../../css.css">
		<link rel="stylesheet" type="text/css" href="../../mycss.css">
		<script language="javascript" src="../../JS/TableColor.js"></script>
	</head>

	<body>
	
		<br>
		<h3 align="center"> 
			2009届本科生信息 
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
			<table border="0" width="700" id="mytable">
				<tr>
					<th colspan="7" background="../../Pictures/newmenubg.gif" height="30">
						<font color="#FFFFFF">软件学院2009届本科生信息</font>
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
				<tr>
					<td>130911 
					</td>
					<td>130 
					</td>				
					<td>110 
					</td>
					<td>20 
					</td>
					<td>
						<a href="Class1.jsp"><img src="../../Pictures/userinfo.gif"
								align="middle" border="0" /> </a>
					</td>
				</tr>
				<tr>
					<td>130912 
					</td>
					<td>130 
					</td>				
					<td>110 
					</td>
					<td>20 
					</td>
					<td>
						<a href="Class2.jsp"><img src="../../Pictures/userinfo.gif"
								align="middle" border="0" /> </a>
					</td>
				</tr><tr>
					<td>130913 
					</td>
					<td>140 
					</td>				
					<td>120 
					</td>
					<td>20 
					</td>
					<td>
						<a href="Class3.jsp"><img src="../../Pictures/userinfo.gif"
								align="middle" border="0" /> </a>
					</td>
				</tr>
			</table>
		</div>
		<br>
		<br>
		<br>
	</body>
</html>
