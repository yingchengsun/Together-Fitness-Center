<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" errorPage="/errorPage.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>成绩管理</title>

		<link rel="stylesheet" type="text/css"
			href="<%=request.getContextPath()%>/bksx/css/css.css">
		<link rel="stylesheet" type="text/css"
			href="<%=request.getContextPath()%>/bksx/css/mycss.css">
		<script language="javascript"
			src="<%=request.getContextPath()%>/bksx/js/TableColor.js"></script>
		<script language="javascript"
			src="<%=request.getContextPath()%>/bksx/js/FormValid.js"></script>

	</head>

	<body>
		<br>
		<br>
		<h3 align="center">
			<img src="<%=request.getContextPath()%>/bksx/pictures/551.png"
				width="50" height="50" align="middle" />
			成绩管理
		</h3>
		<hr>
		<div align="center">
			<!-- 精确查询 -->
			<form
				action="<%=request.getContextPath()%>/getAchieveByStuNum.action"
				method="post" onsubmit="return validator(this)">
				<table>
					<tr>
						<th>
							精确查找
						</th>
						<td>
							输入学号：
						</td>
						<td>
							<input type="text" name="FStudentNumber" size="15" id="Limit"
								valid="required|limit" min="8" max="8" errmsg="请输入学号！|学号必须是8位！">
						</td>
						<td>
							<input type="submit" value="查询">
						</td>
					</tr>
				</table>
			</form>
			<form action="<%=request.getContextPath()%>/getAchieveByGrade.action"
				method="post">
				<table>
					<tr>
						<th>
							快速查找
						</th>
						<td>
							选择年级：
						</td>
						<td>
							<select name="regDate">
								<option value="2006">
									-----2006-----
								</option>
								<option value="2007">
									-----2007-----
								</option>
								<option value="2008">
									-----2008-----
								</option>
								<option value="2009">
									-----2009-----
								</option>
								<option value="2010">
									-----2010-----
								</option>
								<option value="2011">
									-----2011-----
								</option>
								<option value="2012">
									-----2012-----
								</option>
							</select>
						</td>
						<td>
							<input type="submit" value="查询">
						</td>
					</tr>
				</table>
			</form>


			<table align="center" width="98%">
				<tr>
					<th align="right">
						<a href="<%=request.getContextPath()%>/exportAchieve.action"><img
								src="<%=request.getContextPath()%>/bksx/pictures/excel.bmp"
								align="top" border="0" />导出为Excel文件 </a>
					</th>
				</tr>
			</table>
			<table border="1" width="98%" id="mytable" cellspacing="0">
				<tr>
					<th align="center" colspan="10"
						background="<%=request.getContextPath()%>/bksx/pictures/bluebar.gif"
						height="30">
						软件学院毕业设计成绩单
					</th>
				</tr>
				<tr>
					<th>
						学生学号
					</th>
					<th>
						学生姓名
					</th>
					<th>
						前期成绩
					</th>
					<th>
						中期成绩
					</th>
					<th>
						后期成绩
					</th>
					<th>
						最终成绩
					</th>
					<th colspan="2">
						操 作
					</th>
				</tr>
				<c:forEach items="${achieveList }" var="achieve">
					<tr>
						<td>
							${achieve.bksxTabSubstugui.tabStudents.FStudentNumber }
						</td>
						<td>
							${achieve.bksxTabSubstugui.FStudentName }
						</td>
						<td>
							${achieve.FFirstScore }&nbsp;
						</td>
						<td>
							${achieve.FSecondScore }&nbsp;
						</td>
						<td>
							${achieve.FThirdScore }&nbsp;
						</td>
						<td>
							${achieve.FFinalScore }&nbsp;
						</td>
						<td>
							<a
								href="<%=request.getContextPath()%>/preUpdateAchieve.action?id=${achieve.FSubStuGuiId }"><img
									src="<%=request.getContextPath()%>/bksx/pictures/update.gif"
									border="0" /> </a>
						</td>
						<td>
							<a
								onclick="javascript: if(window.confirm('数据不可恢复，确定要删除么？')) window.location.href='<%=request.getContextPath()%>/deleteAchieve.action?id=${achieve.FSubStuGuiId }'; "><img
									src="<%=request.getContextPath()%>/bksx/pictures/delete.gif"
									border="0" /> </a>
						</td>
					</tr>
				</c:forEach>
			</table>
			<table width="40%">
				<tr>
					<td>
						<div align="center">
							<a href="<%=request.getContextPath()%>/showAllAchieve.action?p=1">首页</a>
						</div>
					</td>
					<td>
						<div align="center">
							<a
								href="<%=request.getContextPath()%>/showAllAchieve.action?p=${p-1}">上一页</a>
						</div>
					</td>
					<td>
						<div align="center">
							<a
								href="<%=request.getContextPath()%>/showAllAchieve.action?p=${p+1}">下一页</a>
						</div>
					</td>
					<td>
						<div align="center">
							<a
								href="<%=request.getContextPath()%>/showAllAchieve.action?p=${lastPage}">末页</a>
						</div>
					</td>
				</tr>
			</table>
		</div>

		<br>
		<br>
		<br>
	</body>
</html>
