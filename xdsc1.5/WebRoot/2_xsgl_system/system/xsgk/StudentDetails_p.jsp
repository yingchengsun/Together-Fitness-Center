
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>学生信息</title>

		<link rel="stylesheet" type="text/css"
			href="<%=request.getContextPath()%>/css.css">
		<script language="javascript"
			src="<%=request.getContextPath()%>/2_xsgl_system/JS/TableColor.js"></script>
		<link rel="stylesheet" type="text/css"
			href="<%=request.getContextPath()%>/2_xsgl_system/mycss.css">
		<script language="javascript"
			src="<%=request.getContextPath()%>/2_xsgl_system/JS/My97DatePicker/WdatePicker.js"></script>
	</head>

	<body>
		<br>
		<br>
		<h3 align="center">
			学生信息
		</h3>
		<hr>
		<div align="center">
			<form action="showStudent.action?id=${student.FStudentNumber }">
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
							${postgraduate.tabStudents.FStudentName }
						</td>
						<td>
							${postgraduate.tabStudents.FStudentSex }
						</td>
						<td>
								<fmt:formatDate value="${postgraduate.tabStudents.FStudentBirthday }" type="date" pattern="yyyy-MM-dd"/>
						</td>
						<td>
							${postgraduate.tabStudents.FStudentNation }
						</td>
						<td>
							${postgraduate.tabStudents.FStudentNativeplace }
						</td>

						<td>
							${postgraduate.tabStudents.FStudentPoliStatus }
						</td>

						<td>
							${postgraduate.tabStudents.FHomeTel }
						</td>
					</tr>
					<tr>
						<th>
							家庭住址
						</th>
						<td colspan="6">
							${postgraduate.tabStudents.FStudentAddress }
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
							导师
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
							${postgraduate.FStudentNumber }
						</td>
						<td>
							${postgraduate.tabStudents.tabClasses.FClassNumber }
						</td>
						<td>
							${postgraduate.tabTeachers.FTeacherName }
						</td>
						<td>
						<c:forEach items="${postgraduate.tabStudents.tabClasses.tabGrade.tabTeacherses }" var="teacher">
									${teacher.FTeacherName }
								</c:forEach>
						</td>
						<td>
							${postgraduate.tabStudents.FStudentMajor }
						</td>
						<td>
							${postgraduate.tabStudents.FStudentDormitory }
						</td>
						<td>
							${postgraduate.tabStudents.FStudentTel }
						</td>

					</tr>
					<tr>
						<th>
							表彰及处分
						</th>
						<td colspan="6">
							${postgraduate.tabStudents.FRewardPunish }
						</td>
					</tr>
					<tr>
						<th align="center" colspan="7"
							background="<%=request.getContextPath()%>/2_xsgl_system/Pictures/newmenubg.gif"
							height="30">
							<font color="#FFFFFF">学生入学信息</font>
						</th>
					</tr>
					<tr>
						<th>
							入学时间
						</th>
						<th>
							硕士类型
						</th>
						<th>
							本科毕业学校
						</th>
						<th colspan="2">
							考研成绩
						</th>
						<th>
							考研成绩学院排名
						</th>
						<th>
							是否第一志愿
						</th>
					</tr>
					<tr>
					    <td>
								<fmt:formatDate value="${postgraduate.tabStudents.FStudentRegData }" type="date" pattern="yyyy-MM-dd"/>
						</td>
						<td>
							${postgraduate.FType }
						</td>
						<td>
							${postgraduate.FStudentExSchool }
						</td>
						<td>
							${postgraduate.FStudentEscore }
						</td>
						<td>
							${postgraduate.FStudentErank }
						</td>
						<td>
							${postgraduate.FIsFirstChoice }
						</td>
					</tr>

				</table>
			</form>
		</div>

	</body>
</html>
