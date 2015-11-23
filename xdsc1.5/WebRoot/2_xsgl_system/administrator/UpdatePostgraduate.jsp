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
		<br>
		<h3 align="center">详细信息</h3>
		<hr>
		<div align="center">
		 <form action="<%=request.getContextPath()%>/updatePostgraduate.action"
			method="post">
				<table border="1" width="700">
					<tr>
						<th height="30" colspan="2" align="center" background="<%=request.getContextPath() %>/2_xsgl_system/Pictures/newmenubg.gif">
							<font color="#FFFFFF">编辑信息</font>
						</th>
					</tr>
					<tr>
						<td>
							学号：
						</td>
						<td>
							<input type="text" name="FStudentNumber"
							value="${postgraduate.FStudentNumber }">
						</td>
					</tr>
					<tr>
						<td>
							姓名：
						</td>
						<td>
							<input type="text" name="FStudentName"
							value="${postgraduate.tabStudents.FStudentName }">
						</td>
					</tr>
					<tr>
					<tr>
						<td>
							性别：
						</td>
						<td>
							<input type="text" name="FStudentSex"
							value="${postgraduate.tabStudents.FStudentSex }">
						</td>
					</tr>
					<tr>
						<td>
							出生年月：
						</td>
						<td>
							<input type="text" name="FStudentBirthday"
							value="${postgraduate.tabStudents.FStudentBirthday }">
						</td>
					</tr>
					<tr>
						<td>
							民族：
						</td>
						<td>
							<input type="text" name="FStudentNation"
							value="${postgraduate.tabStudents.FStudentNation }">
						</td>
					</tr>
					<tr>
						<td>
							籍贯：
						</td>
						<td>
							<input type="text" name="FStudentNativeplace"
							value="${postgraduate.tabStudents.FStudentNativeplace }">
						</td>
					</tr>
					<tr>
						<td>
							政治面貌：
						</td>
						<td>
							<input type="text" name="FStudentPoliStatus"
							value="${postgraduate.tabStudents.FStudentPoliStatus }">
						</td>
					</tr>
					<tr>
						<td>
							家庭联系电话：
						</td>
						<td>
							<input type="text" name="FHomeTel"
							value="${postgraduate.tabStudents.FHomeTel }">
						</td>
					</tr>
					<tr>
						<td>
							家庭住址：
						</td>
						<td>
							<input type="text" name="FStudentAddress"
							value="${postgraduate.tabStudents.FStudentAddress }">
						</td>
					</tr>
					<tr>
						<td>
							班级：
						</td>
						<td>
							<input type="text" name="FClassNumber"
							value="${postgraduate.tabStudents.tabClasses.FClassNumber }">
						</td>
					</tr>
					<tr>
						<td>
							导师：
						</td>
						<td>
							<input type="text" name="FTeacherName"
							value="${postgraduate.tabTeachers.FTeacherName }">
						</td>
					</tr>
					<tr>
						<td>
							辅导员：
						</td>
						<td>
							<c:forEach items="${postgraduate.tabStudents.tabClasses.tabGrade.tabTeacherses }" var="teacher">
							<input type="text" name="FTeacherName" value="${teacher.FTeacherName }">
								</c:forEach>
						</td>
					</tr>
					<tr>
						<td>
							专业方向：
						</td>
						<td>
							<input type="text" name="FStudentMajor"
							value="${postgraduate.tabStudents.FStudentMajor }">
						</td>
					</tr>
					<tr>
						<td>
							宿舍地址：
						</td>
						<td>
							<input type="text" name="FStudentDormitory"
							value="${postgraduate.tabStudents.FStudentDormitory }">
						</td>
					</tr>
					<tr>
						<td>
							联系电话：
						</td>
						<td>
							<input type="text" name="FStudentTel"
							value="${postgraduate.tabStudents.FStudentTel }">
						</td>
					</tr>
					<tr>
						<td>
							入学时间：
						</td>
						<td>
							<input type="text" name="FStudentRegData"
							value="${postgraduate.tabStudents.FStudentRegData }">
						</td>
					</tr>
					<tr>
						<td>
							硕士类型：
						</td>
						<td>
							<input type="text" name="FType"
							value="${postgraduate.FType }">
						</td>
					</tr>
					<tr>
						<td>
							本科毕业学校：
						</td>
						<td>
							<input type="text" name="FStudentExSchool"
							value="${postgraduate.FStudentExSchool }">
						</td>
					</tr>
					<tr>
						<td>
							考研成绩：
						</td>
						<td>
							<input type="text" name="FStudentEscore"
							value="${postgraduate.FStudentEscore }">
						</td>
					</tr>
					<tr>
						<td>
							考研成绩学院排名：
						</td>
						<td>
							<input type="text" name="FStudentErank"
							value="${postgraduate.FStudentErank }">
						</td>
					</tr>
					<tr>
						<td>
							是否第一志愿：
						</td>
						<td>
							<input type="text" name="FIsFirstChoice"
							value="${postgraduate.FIsFirstChoice }">
						</td>
					</tr>
					<tr>
						<td>
							表彰及处分：
						</td>
						<td>
							<input type="text" name="FRewardPunish"
							value="${postgraduate.tabStudents.FRewardPunish }">
						</td>
					</tr>
					
				<tr>
					<td>
						&nbsp;
					</td>
					<td>
						<input type="submit" value="更新">&nbsp;&nbsp;<input type="reset" value="重置">
					</td>
				</tr>
				</table>
				</form>
		   </div>
		<br>
  </body>
</html>
