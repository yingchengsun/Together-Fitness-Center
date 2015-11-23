
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>学生信息</title>

		<link rel="stylesheet" type="text/css"
			href="<%=request.getContextPath()%>/css.css">
		<link rel="stylesheet" type="text/css" href="../../mycss.css">
		<script language="javascript"
			src="<%=request.getContextPath()%>/2_xsgl_system/JS/TableColor.js"></script>
		<link rel="stylesheet" type="text/css"
			href="<%=request.getContextPath()%>/2_xsgl_system/mycss.css">
	</head>

	<body>
		<br>
		<br>
		<h3 align="center">
			学生信息
		</h3>
		<hr>
		<div align="center">
			<form action="getParentByPId?id=001">
				<table border="1" width="700">
					<tr>
						<th align="center" colspan="7"
							background="<%=request.getContextPath()%>/2_xsgl_system/Pictures/newmenubg.gif"
							height="30">
							<font color="#FFFFFF">个人信息</font>
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
							${parent.tabStudents.FStudentName }
						</td>
						<td>
							${parent.tabStudents.FStudentSex }
						</td>
						<td>
							${parent.tabStudents.FStudentBirthday }
						</td>
						<td>
							${parent.tabStudents.FStudentNation }
						</td>
						<td>
							${parent.tabStudents.FStudentNativeplace }
						</td>

						<td>
							${parent.tabStudents.FStudentPoliStatus }
						</td>

						<td>
							${parent.tabStudents.FHomeTel }
						</td>
					</tr>
					<tr>
						<th>
							家庭住址
						</th>
						<td colspan="6">
							${parent.tabStudents.FStudentAddress }&nbsp;
						</td>
					</tr>

					<tr>
						<th align="center" colspan="7"
							background="<%=request.getContextPath()%>/2_xsgl_system/Pictures/newmenubg.gif"
							height="30">
							<font color="#FFFFFF">在校信息</font>
						</th>
					</tr>
					<tr>
						<th>
							学号
						</th>
						<th>
							班级
						</th>
						<th>
							班主任
						</th>
						<th>
							辅导员
						</th>
						<th>
							专业方向
						</th>
						<th>
							宿舍地址
						</th>
						<th>
							联系电话
						</th>

					</tr>
					<tr>
						<td>
							${parent.tabStudents.FStudentName }
						</td>
						<td>
							${parent.tabStudents.tabClasses.FClassNumber }
						</td>
						<td>
							&nbsp;
						</td>
						<td>
							&nbsp;
						</td>
						<td>
							${student.FStudentMajor }
						</td>
						<td>
							${student.FStudentDormitory }
						</td>
						<td>
							${student.FStudentTel }
						</td>

					</tr>
					<tr>
						<th>
							表彰及处分
						</th>
						<td colspan="6">
							&nbsp;
						</td>
					</tr>
				</table>
			</form>
		</div>

	</body>
</html>
