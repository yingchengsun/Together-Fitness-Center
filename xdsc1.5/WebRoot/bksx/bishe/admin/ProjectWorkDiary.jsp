<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" errorPage="/errorPage.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>学生工作日志</title>

		<link rel="stylesheet" type="text/css"
			href="<%=request.getContextPath()%>/bksx/css/css.css">
		<link rel="stylesheet" type="text/css"
			href="<%=request.getContextPath()%>/bksx/css/mycss.css">
		<script language="javascript"
			src="<%=request.getContextPath()%>/bksx/js/TableColor.js"></script>
		<script language="javascript"
			src="<%=request.getContextPath()%>/bksx/js/My97DatePicker/WdatePicker.js"></script>
		<script language="javascript"
			src="<%=request.getContextPath()%>/bksx/js/FormValid.js"></script>
	</head>

	<body>
		<br>
		<br>
		<h3 align="center">
			<img
				src="<%=request.getContextPath()%>/bksx/pictures/people_vista.png"
				width="50" height="50" align="middle" />
			个人检查
		</h3>
		<hr>
		<div align="center">
			<table width="600">
				<tr>
					<th colspan="2">
						学生信息
					</th>
				</tr>
				<tr>
					<th>
						学生学号
					</th>
					<td>
						${substugui.tabStudents.FStudentNumber }
					</td>
				</tr>
				<tr>
					<th>
						学生姓名
					</th>
					<td>
						${substugui.tabStudents.FStudentName }
					</td>
				</tr>
				<tr>
					<th>
						毕设题目
					</th>
					<td>
						${substugui.FSubjectName }
					</td>
				</tr>
				<tr>
					<th>
						指导教师
					</th>
					<td>
						${substugui.FTeacherName }
					</td>
				</tr>
				<tr>
					<th>
						电子邮件
					</th>
					<td>
						${substugui.tabStudents.FStudentEmail }
					</td>
				</tr>
				<tr>
					<th>
						联系电话
					</th>
					<td>
						${substugui.tabStudents.FStudentTel }
					</td>
				</tr>
				<tr>
					<th>
						所属团队
					</th>
					<td>
						${substugui.bksxTabProject.bksxTabTeam.FTeamName }
					</td>
				</tr>
				<tr>
					<th>
						阶段成绩
					</th>
					<td>
						初期成绩：${achieve.FFirstScore }
						<c:if test="${empty achieve.FFirstScore }">暂无</c:if>
						中期成绩：${achieve.FSecondScore }
						<c:if test="${empty achieve.FSecondScore }">暂无</c:if>
						后期成绩：${achieve.FThirdScore }
						<c:if test="${empty achieve.FSecondScore }">暂无</c:if>
					</td>
				</tr>
				<c:if test="${role=='TEACHER' }">
					<tr>
						<th>
							&nbsp;
						</th>
						<td>
							<form
								action="<%=request.getContextPath()%>/addSingleScore.action?id=${substugui.FSubStuGuiId }"
								method="post">
								<select name="stage">
									<option value="0">
										初期成绩
									</option>
									<option value="1">
										中期成绩
									</option>
									<option value="2">
										后期成绩
									</option>
								</select>
								<select name="score">
									<option value="10">
										10
									</option>
									<option value="20">
										20
									</option>
									<option value="30">
										30
									</option>
									<option value="40">
										40
									</option>
									<option value="50">
										50
									</option>
									<option value="60">
										60
									</option>
									<option value="70">
										70
									</option>
									<option value="80">
										80
									</option>
									<option value="90">
										90
									</option>
									<option value="100">
										100
									</option>
								</select>
								<input type="submit" value="评分">
							</form>
						</td>
					</tr>
				</c:if>
			</table>
		</div>
		<hr>
		<div align="center">
			<form
				action="<%=request.getContextPath()%>/showStudentDiaryByDate.action?id=${substugui.FSubStuGuiId }"
				method="post" onsubmit="return validator(this)">
				<table>
					<tr>
						<td>
							查看历史工作日志：
						</td>
						<td>
							<input readonly="readonly" type="text" name="startDate"
								onClick="WdatePicker()" size="12" valid="required"
								errmsg="请选择开始日期!" />
							至
							<input readonly="readonly" type="text" name="endDate"
								onClick="WdatePicker()" size="12" valid="required"
								errmsg="请选择结束日期!" />
						</td>
						<td>
							<input type="submit" value="搜索">
						</td>
					</tr>
				</table>
			</form>

		</div>
		<div align="center">

			<c:if test="${not empty diraylist}">
				<table border="1" cellspacing="0" width="98%" id="mytable">
					<tr>
						<th
							background="<%=request.getContextPath()%>/bksx/pictures/bluebar.gif"
							colspan="5" height="30">
							个人工作日志
						</th>
					</tr>
					<tr>
						<th>
							日期
						</th>
						<th>
							人员
						</th>
						<th>
							任务
						</th>
						<th>
							简述
						</th>
					</tr>
					<c:forEach items="${diraylist }" var="diary">
						<tr>
							<td>
								<fmt:formatDate value="${diary.FDiaryDate }" type="date"
									dateStyle="long" />
							</td>
							<td>
								${diary.FDiaryAuthor }
							</td>
							<td>
								${diary.FDiaryTitle }
							</td>
							<td>
								${diary.FDiaryContent }
							</td>
						</tr>
					</c:forEach>
				</table>
				<table width="40%">
					<tr>
						<td>
							<div align="center">
								<a
									href="<%=request.getContextPath()%>/showStudentDiary.action?p=1&id=${substugui.tabStudents.FStudentNumber }">首页</a>
							</div>
						</td>
						<td>
							<div align="center">
								<a
									href="<%=request.getContextPath()%>/showStudentDiary.action?p=${p-1}&id=${substugui.tabStudents.FStudentNumber }">上一页</a>
							</div>
						</td>
						<td>
							<div align="center">
								<a
									href="<%=request.getContextPath()%>/showStudentDiary.action?p=${p+1}&id=${substugui.tabStudents.FStudentNumber }">下一页</a>
							</div>
						</td>
						<td>
							<div align="center">
								<a
									href="<%=request.getContextPath()%>/showStudentDiary.action?p=${lastPage}&id=${substugui.tabStudents.FStudentNumber }">末页</a>
							</div>
						</td>
					</tr>
				</table>
			</c:if>
			<c:if test="${empty diraylist}">
				<h5>
					<br>

					<img
						src="<%=request.getContextPath()%>/bksx/pictures/MinIcons_001.png" />
					<br>
					学生${substugui.tabStudents.FStudentName }还没有写过（该时间区间的） 《工作日志》

				</h5>
			</c:if>
			<br>
		</div>
		<br>
		<br>
	</body>
</html>
