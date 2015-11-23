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
		 <form action="<%=request.getContextPath()%>/savePostgraduate.action"
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
							<input type="text" name="FStudentNumber">
						</td>
					</tr>
					<tr>
						<td>
							姓名：
						</td>
						<td>
							<input type="text" name="FStudentName">
						</td>
					</tr>
					<tr>
					<tr>
						<td>
							性别：
						</td>
						<td>
							<input type="text" name="FStudentSex">
						</td>
					</tr>
					<tr>
						<td>
							出生年月：
						</td>
						<td>
							<input type="text" name="FStudentBirthday">
						</td>
					</tr>
					<tr>
						<td>
							民族：
						</td>
						<td>
							<input type="text" name="FStudentNation">
						</td>
					</tr>
					<tr>
						<td>
							籍贯：
						</td>
						<td>
							<input type="text" name="FStudentNativeplace">
						</td>
					</tr>
					<tr>
						<td>
							政治面貌：
						</td>
						<td>
							<input type="text" name="FStudentPoliStatus">
						</td>
					</tr>
					<tr>
						<td>
							家庭联系电话：
						</td>
						<td>
							<input type="text" name="FHomeTel">
						</td>
					</tr>
					<tr>
						<td>
							家庭住址：
						</td>
						<td>
							<input type="text" name="FStudentAddress">
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
							<input type="text" name="FTeacherName">
						</td>
					</tr>
					
					<tr>
						<td>
							专业方向：
						</td>
						<td>
							<input type="text" name="FStudentMajor">
						</td>
					</tr>
					<tr>
						<td>
							宿舍地址：
						</td>
						<td>
							<input type="text" name="FClassFemaleNum">
						</td>
					</tr>
				
					<tr>
						<td>
							联系电话：
						</td>
						<td>
							<input type="text" name="FStudentTel">
						</td>
					</tr>
					<tr>
						<td>
							入学时间：
						</td>
						<td>
							<input type="text" name="FStudentRegData">
						</td>
					</tr>
					<tr>
						<td>
							硕士类型：
						</td>
						<td>
							<input type="text" name="FType">
						</td>
					</tr>
					<tr>
						<td>
							本科毕业学校：
						</td>
						<td>
							<input type="text" name="FStudentExSchool">
						</td>
					</tr>
					<tr>
						<td>
							考研成绩：
						</td>
						<td>
							<input type="text" name="FStudentEscore">
						</td>
					</tr>
					<tr>
						<td>
							考研成绩学院排名：
						</td>
						<td>
							<input type="text" name="FStudentErank">
						</td>
					</tr>
					<tr>
						<td>
							是否第一志愿：
						</td>
						<td>
							<input type="text" name="FIsFirstChoice">
						</td>
					</tr>
					<tr>
						<td>
							表彰及处分：
						</td>
						<td>
							<input type="text" name="FRewardPunish">
						</td>
					</tr>
					
				<tr>
					<td>
						&nbsp;
					</td>
					<td>
						<input type="submit" value="提交">&nbsp;&nbsp;<input type="reset" value="重置">
					</td>
				</tr>
				</table>
				</form>
		   </div>
		<br>
  </body>
</html>
