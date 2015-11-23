<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css.css">
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/2_xsgl_system/mycss.css">
		<script language="javascript" src="<%=request.getContextPath() %>/2_xsgl_system/JS/TableColor.js"></script>
	</head>

	<body>
	
		<br>
		<h3 align="center">
			研究生信息
		</h3>
		<hr>
		<div align="center">
		<form action="getGradeListByPostgraduate.action">
			<table border="0" width="700" id="mytable">
				<tr>
					<th colspan="7" background="<%=request.getContextPath() %>/2_xsgl_system/Pictures/newmenubg.gif" height="30">
						<font color="#FFFFFF">软件学院研究生信息</font>
					</th>
				</tr>
				<tr>
					<th>
						年级
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
				<c:forEach items="${gradeList }" var="grade">
				<tr>
					<td>
							${grade.FGradeName }
						</td>
						<td>
							${grade.FGradeTotalNum }
						</td>
						<td>
							${grade.FGradeMaleNum }
						</td>
						<td>
							${grade.FGradeFemaleNum }
						</td>
						<td>
						<a href="<%=request.getContextPath() %>/getPostgraduateListByGrade.action?gid=${grade.FGradeId }"><img src="<%=request.getContextPath() %>/2_xsgl_system/Pictures/userinfo.gif"
								align="middle" border="0" /> </a>
					</td>
				</tr>
				</c:forEach>
			</table>
			</form>
		</div>
		
	</body>
</html>
