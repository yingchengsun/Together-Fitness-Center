
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
		<br>
		<h3 align="center">
			学生信息
		</h3>
		<hr>
		<br>
		<div align="center">
			<form action="showStudentArchives.action?id=13061012">
			<table border="1" width="700" id="mytable">
				<tr>
					<th align="center" colspan="7" background="<%=request.getContextPath() %>/2_xsgl_system/Pictures/newmenubg.gif" height="30">
						<font color="#FFFFFF">个人档案</font>
					</th>
				</tr>
				<tr>
						<th>
							姓名
						</th>
						<th>
							性别
						</th>
						<th>
							出生年月
						</th>
						<th>
							民族
						</th>
						<th>
							籍贯
						</th>
						<th>
							政治面貌
						</th>

						<th>
							家庭联系电话
						</th>
					</tr>

					<tr>

						<td>
							${student.FStudentName }
						</td>
						<td>
							${student.FStudentSex }
						</td>
						<td>
							${student.FStudentBirthday }
						</td>
						<td>
							${student.FStudentNation }
						</td>
						<td>
							${student.FStudentNativeplace }
						</td>

						<td>
							${student.FStudentPoliStatus }
						</td>

						<td>
							${student.FHomeTel }
						</td>
					</tr>
					<tr>
						<th>
							家庭住址
						</th>
						<td colspan="6">
							${student.FStudentAddress }&nbsp;
						</td>
					</tr>
			</table>
			</form>
		</div>
	</body>
</html>
