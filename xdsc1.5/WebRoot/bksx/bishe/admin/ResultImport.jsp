<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" errorPage="/errorPage.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>成绩录入</title>
		<link rel="stylesheet" type="text/css"
			href="<%=request.getContextPath()%>/bksx/css/css.css">
		<link rel="stylesheet" type="text/css"
			href="<%=request.getContextPath()%>/bksx/css/mycss.css">
		<script language="javascript"
			src="<%=request.getContextPath()%>/bksx/js/FormValid.js"></script>

	</head>

	<body>
		<br>
		<br>
		<h3 align="center">
			<img src="<%=request.getContextPath()%>/bksx/pictures/551.png"
				width="50" height="50" align="middle" />
			成绩录入
		</h3>
		<hr>

		<div align="center">
			<form action="<%=request.getContextPath()%>/resultImport.action"
				enctype="multipart/form-data" method="post"
				onsubmit="return validator(this)">
				<table border="1" width="98%" cellspacing="0">
					<tr>
						<th height="30" colspan="2" align="center"
							background="<%=request.getContextPath()%>/bksx/pictures/bluebar.gif">
							<img src="<%=request.getContextPath()%>/bksx/pictures/excel.bmp"
								border="0" align="top" />
							导入Excel文件
						</th>
					</tr>
					<tr>
						<td>
							选择文件:
						</td>
						<td>
							<input type="file" name="file" size="40" valid="required"
								errmsg="请首先选择文件!" />
							<input type="submit" value=" 导入 " />
						</td>
					</tr>
					<tr>
						<td>
							导入说明：
						</td>
						<td>
							<a href="<%=request.getContextPath()%>/exportEmptyAchieve.action"><img
									src="<%=request.getContextPath()%>/bksx/pictures/download.gif"
									border="0" align="bottom">点此下载模板</a>
						</td>
					</tr>
				</table>
			</form>
		</div>
		<hr>
		<br>
		<div align="center">
			<form action="<%=request.getContextPath()%>/addAchieve.action"
				method="post" onsubmit="return validator(this)">
				<table width="98%" align="center" border="1" cellspacing="0">
					<tr>
						<th colspan="2" align="center"
							background="<%=request.getContextPath()%>/bksx/pictures/bluebar.gif"
							height="30">
							<img src="<%=request.getContextPath()%>/bksx/pictures/hand.gif"
								border="0" align="top" />
							手工添加
						</th>
					</tr>
					<tr>
						<td>
							学生学号：
						</td>
						<td>
							<input type="text" name="FStudentNumber" id="Limit"
								valid="required|limit" min="8" max="8"
								errmsg="学生学号不能为空！|学生学号长度必须是8位数字!" >
							<!-- 防止内存溢出
							<select name="FStudentNumber">
								<c:forEach items="${studentList }" var="student">
									<option value="${student.FStudentNumber }">
										${student.FStudentNumber }--${student.FStudentName }
									</option>
								</c:forEach>
								<option disabled="disabled">
									-----请选择学生-----
								</option>
							</select> -->
						</td>
					</tr>
					<tr>
						<td>
							前期成绩：
						</td>
						<td>
							<input type="text" name="FFirstScore" id="Range"
								valid="required|range" min="0" max="100"
								errmsg="前期成绩不能为空！|成绩值必须在0-100之间!" />
						</td>
					</tr>
					<tr>
						<td>
							中期成绩：
						</td>
						<td>
							<input type="text" name="FSecondScore" id="Range"
								valid="required|range" min="0" max="100"
								errmsg="中期成绩不能为空！|成绩值必须在0-100之间!" />
						</td>
					</tr>
					<tr>
						<td>
							后期成绩：
						</td>
						<td>
							<input type="text" name="FThirdScore" id="Range"
								valid="required|range" min="0" max="100"
								errmsg="后期成绩不能为空！|成绩值必须在0-100之间!" />
						</td>
					</tr>
					<tr>
						<td>
							最终成绩：
						</td>
						<td>
							<select name="FFinalScore">
								<option value="优秀">
									---------优秀--------
								</option>
								<option value="中等">
									---------中等--------
								</option>
								<option value="及格">
									---------及格--------
								</option>
								<option value="不及格">
									--------不及格-------
								</option>
							</select>
						</td>
					</tr>
					<tr>
						<td>
							&nbsp;
						</td>
						<td>
							<input type="submit" value="提交" />
							<input type="reset" value="重置" />
						</td>
					</tr>
				</table>
			</form>
		</div>
		<br>
		<br>
		<br>
	</body>
</html>
