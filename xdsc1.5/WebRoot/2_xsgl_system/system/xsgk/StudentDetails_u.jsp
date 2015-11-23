
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
						<th align="center" colspan="8"
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

						<th colspan="2">
							家庭联系电话
						</th>
					</tr>

					<tr>

						<td>
							${undergraduate.tabStudents.FStudentName }
						</td>
						<td>
							${undergraduate.tabStudents.FStudentSex }
						</td>
						<td>
								<fmt:formatDate value="${undergraduate.tabStudents.FStudentBirthday }" type="date" pattern="yyyy-MM-dd"/>
						</td>
						<td>
							${undergraduate.tabStudents.FStudentNation }
						</td>
						<td>
							${undergraduate.tabStudents.FStudentNativeplace }
						</td>

						<td>
							${undergraduate.tabStudents.FStudentPoliStatus }
						</td>

						<td colspan="2">
							${undergraduate.tabStudents.FHomeTel }
						</td>
					</tr>
					<tr>
						<th>
							家庭住址
						</th>
						<td colspan="7">
							${undergraduate.tabStudents.FStudentAddress }
						</td>
					</tr>

					<tr>
						<th align="center" colspan="8"
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
						<th colspan="3">
							班主任及辅导员
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
							${undergraduate.FStudentNumber }
						</td>
						<td>
							${undergraduate.tabStudents.tabClasses.FClassNumber }
						</td>
						<td colspan="3">
							<c:forEach items="${undergraduate.tabStudents.tabClasses.tabGrade.tabTeacherses }" var="teacher">
									${teacher.FTeacherName }
								</c:forEach>
						</td>
						<td>
							${undergraduate.tabStudents.FStudentMajor }
						</td>
						<td>
							${undergraduate.tabStudents.FStudentDormitory }
						</td>
						<td>
							${undergraduate.tabStudents.FStudentTel }
						</td>
					</tr>
					
					<tr>
						<th align="center" colspan="8"
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
							高中毕业学校
						</th>
						<th>
							高考总分
						</th>
						<th>
							高考成绩学院排名
						</th>
						<th>
							是否第一志愿
						</th>
						<th colspan="3">
							表彰及处分
						</th>
					</tr>
					<tr>
					    <td>
								<fmt:formatDate value="${undergraduate.tabStudents.FStudentRegData }" type="date" pattern="yyyy-MM-dd"/>
						</td>
						<td>
							${undergraduate.FStudentHighSchool }
						</td>
						<td>
							${undergraduate.FStudentHscore }
						</td>
						<td>
							${undergraduate.FStudentHrank }
						</td>
						<td>
							${undergraduate.FIsFirstChoice }
						</td>
						<td colspan="3">
							${undergraduate.tabStudents.FRewardPunish }
						</td>
					</tr>

				</table>
			</form>
		</div>

	</body>
</html>
