<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" errorPage="/errorPage.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>日常工作记录</title>

		<link rel="stylesheet" type="text/css"
			href="<%=request.getContextPath()%>/bksx/css/css.css">
		<link rel="stylesheet" type="text/css"
			href="<%=request.getContextPath()%>/bksx/css/mycss.css">
		<script language="javascript"
			src="<%=request.getContextPath()%>/bksx/js/My97DatePicker/WdatePicker.js"></script>
		<script language="javascript"
			src="<%=request.getContextPath()%>/bksx/js/TableColor.js"></script>
		<script language="javascript"
			src="<%=request.getContextPath()%>/bksx/js/FormValid.js"></script>
	</head>

	<body>
		<br>
		<br>
		<h3 align="center">
			<img
				src="<%=request.getContextPath()%>/bksx/pictures/Antique_Icon_update_001.png"
				width="50" height="50" align="middle" />
			工作日志
		</h3>
		<hr>
		<br>
		<div align="center">
			<form action="<%=request.getContextPath()%>/getDiaryByDate.action"
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
		<br>
		<table align="center" width="98%">
			<tr>
				<th align="right">
					<a
						href="<%=request.getContextPath()%>/bksx/bishe/student/ProjectDiaryEdit.jsp"><img
							src="<%=request.getContextPath()%>/bksx/pictures/edit.gif"
							align="top" border="0">写日志 </a>
				</th>
			</tr>
		</table>

		<hr>

		<div align="center">
			<c:if test="${not empty diraylist }">
				<table width="98%" cellspacing="0" border="1" id="mytable">
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
						<th>
							备注
						</th>
					</tr>
					<c:forEach items="${diraylist }" var="diary">
						<tr>
							<td>
								<fmt:formatDate value="${diary.FDiaryDate }" type="date"
									dateStyle="medium" />
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
							<td>
								<a
									onclick="javascript: if(window.confirm('数据不可恢复，确定要删除么？')) window.location.href='<%=request.getContextPath()%>/deleteDiary.action?id=${diary.FWid }'; "><img
										src="<%=request.getContextPath()%>/bksx/pictures/delete.gif"
										border="0" />
								</a>
							</td>
						</tr>
					</c:forEach>
				</table>
				<table width="40%">
					<tr>
						<td>
							<div align="center">
								<a href="<%=request.getContextPath()%>/showDiary.action?p=1">首页</a>
							</div>
						</td>
						<td>
							<div align="center">
								<a
									href="<%=request.getContextPath()%>/showDiary.action?p=${p-1}">上一页</a>
							</div>
						</td>
						<td>
							<div align="center">
								<a
									href="<%=request.getContextPath()%>/showDiary.action?p=${p+1}">下一页</a>
							</div>
						</td>
						<td>
							<div align="center">
								<a
									href="<%=request.getContextPath()%>/showDiary.action?p=${lastPage}">末页</a>
							</div>
						</td>
					</tr>
				</table>
			</c:if>
			<c:if test="${empty diraylist }">
				<div align="center">
					<table border="1" cellspacing="0" width="98%">
						<tr>
							<td>
								<br>
								<br>
								<img
									src="<%=request.getContextPath()%>/bksx/pictures/MinIcons_001.png" />
								<br>
								你还没有写过（该时间区间的）《工作日志》
								<br>
								<br>
								<a
									href="<%=request.getContextPath()%>/bksx/bishe/student/ProjectDiaryEdit.jsp"><img
										src="<%=request.getContextPath()%>/bksx/pictures/edit.gif"
										align="top" border="0"><font color="green">点击此处记录第一篇日志</font>
								</a>
								<br>
								<br>
							</td>
						</tr>
					</table>
				</div>
			</c:if>
			<br>
		</div>
		<br>
		<br>
		<br>
	</body>
</html>
