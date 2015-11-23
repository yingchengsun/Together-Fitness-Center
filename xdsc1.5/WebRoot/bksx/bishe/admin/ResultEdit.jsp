<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" errorPage="/errorPage.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>修改成绩</title>

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
			成绩编辑
		</h3>
		<table align="center" width="98%">
			<tr>
				<th align="left">
					<a href="<%=request.getContextPath()%>/showAllAchieve.action"><img
							src="<%=request.getContextPath()%>/bksx/pictures/return.gif"
							align="top" border="0" />返回</a>
				</th>
			</tr>
		</table>
		<hr>
		<div align="center">
			<form action="<%=request.getContextPath()%>/updateAchieve.action"
				method="post" onsubmit="return validator(this)">
				<table border="1" width="98%" cellspacing="0">
					<tr>
						<th height="30" colspan="2" align="center"
							background="<%=request.getContextPath()%>/bksx/pictures/bluebar.gif">
							更新信息
						</th>
					</tr>
					<tr>
						<td>
							学生学号：
							<input type="hidden" name="FSubStuGuiId"
								value="${achieve.FSubStuGuiId }">
						</td>
						<td>
							${achieve.bksxTabSubstugui.tabStudents.FStudentNumber }
						</td>
					</tr>
					<tr>
						<td>
							学生姓名：
						</td>
						<td>
							${achieve.bksxTabSubstugui.FStudentName }
						</td>
					</tr>
					<tr>
						<td>
							前期成绩：
						</td>
						<td>
							<input type="text" name="FFirstScore"
								value="${achieve.FFirstScore }" id="Range"
								valid="required|range" min="0" max="100"
								errmsg="前期成绩不能为空！|成绩值必须在0-100之间!" />
						</td>
					</tr>
					<tr>
						<td>
							中期成绩：
						</td>
						<td>
							<input type="text" name="FSecondScore"
								value="${achieve.FSecondScore }" id="Range"
								valid="required|range" min="0" max="100"
								errmsg="中期成绩不能为空！|成绩值必须在0-100之间!" />
						</td>
					</tr>
					<tr>
						<td>
							后期成绩：
						</td>
						<td>
							<input type="text" name="FThirdScore"
								value="${achieve.FThirdScore }" id="Range"
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
								<option value="优秀"
									<c:if test="${achieve.FFinalScore=='优秀' }">selected="selected"</c:if>>
									---------优秀---------
								</option>
								<option value="中等"
									<c:if test="${achieve.FFinalScore=='中等' }">selected="selected"</c:if>>
									---------中等---------
								</option>
								<option value="及格"
									<c:if test="${achieve.FFinalScore=='及格' }">selected="selected"</c:if>>
									---------及格---------
								</option>
								<option value="不及格"
									<c:if test="${achieve.FFinalScore=='不及格' }">selected="selected"</c:if>>
									--------不及格--------
								</option>
							</select>
						</td>
					</tr>
					<tr>
						<td>
							&nbsp;
						</td>
						<td>
							<input type="submit" value="更新" />
							<input type="reset" value="重置" />
						</td>
					</tr>
				</table>
			</form>
		</div>

		<br>
	</body>
</html>
