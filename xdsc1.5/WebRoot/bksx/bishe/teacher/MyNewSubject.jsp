<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" errorPage="/errorPage.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>我的课题</title>
		<link rel="stylesheet" type="text/css"
			href="<%=request.getContextPath()%>/bksx/css/css.css">
		<link rel="stylesheet" type="text/css"
			href="<%=request.getContextPath()%>/bksx/css/mycss.css">
		<script language="javascript"
			src="<%=request.getContextPath()%>/bksx/js/TableColor.js"></script>
	</head>

	<body>
		<br>
		<br>
		<h3 align="center">
			<img src="<%=request.getContextPath()%>/bksx/pictures/MBA.png"
				width="50" height="50" align="middle" />
			我的课题
		</h3>
		<hr>
		<br>
		<c:if test="${not empty newSubjectList}">
			<div align="center">
				<table width="98%">
					<tr>
						<th align="right">
							<a
								href="<%=request.getContextPath()%>/bksx/bishe/teacher/MySubjectNew.jsp">
								<img src="<%=request.getContextPath()%>/bksx/pictures/add.gif"
									width="15" height="15" border="0" align="bottom" />新建课题 </a>
						</th>
					</tr>
				</table>
				<table border="1" cellspacing="0" width="98%" id="mytable">
					<tr>
						<th height="30" colspan="8"
							background="<%=request.getContextPath()%>/bksx/pictures/bluebar.gif">
							课题信息(学生未选)
						</th>
					</tr>
					<tr>
						<th width="40">
							序号
						</th>
						<th>
							课题名称
						</th>
						<th>
							课题性质
						</th>
						<th>
							课题来源
						</th>
						<th>
							难度等级
						</th>
						<th>
							课题状态
						</th>
					</tr>
					<c:forEach items="${newSubjectList }" var="substugui">
						<tr>
							<td>
								${substugui.FSubStuGuiId }
							</td>
							<td>
								${substugui.FSubjectName }
							</td>
							<td>
								<c:if test="${substugui.FIsSoftware=='Y' }">软件项目</c:if>
								<c:if test="${substugui.FIsHardware=='Y' }">硬件项目</c:if>
								<c:if test="${substugui.FIsSoftHard=='Y' }">软硬结合</c:if>
								<c:if test="${substugui.FIsDocument=='Y' }">文献综述</c:if>
							</td>
							<td>
								<c:if test="${substugui.FIsResearch=='Y' }">科研项目</c:if>
								<c:if test="${substugui.FIsSimulation=='Y' }">模拟项目</c:if>
								<c:if test="${substugui.FIsLab=='Y' }">实验室建设</c:if>
								<c:if test="${substugui.FIsOthers=='Y' }">其他类别</c:if>
							</td>
							<td>
								${substugui.FLevel }
							</td>
							<td>
								${substugui.FIsChecked }
								<c:if test="${substugui.FIsChecked == '被拒绝' }">
									<a
										onclick="javascript: if(window.confirm('数据不可恢复，确定要删除么？')) window.location.href='<%=request.getContextPath()%>/deleteRefuseInfo.action?id=${substugui.FSubStuGuiId }'; ">
										<img
											src="<%=request.getContextPath()%>/bksx/pictures/delete.gif"
											border="0" align="middle"/> </a>
								</c:if>
							</td>
						</tr>
						<tr>
							<th>
								描述
							</th>
							<td colspan="5">
								-------题目表述-------
								<br>
								${substugui.FSubjectDescription }
								<br>
								-------审批理由-------
								<br>
								${substugui.FReason }
								<c:if test="${empty substugui.FReason }">暂无</c:if>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</c:if>
		<c:if test="${empty newSubjectList}">
			<div align="center">
				<table border="1" cellspacing="0" width="98%">
					<tr>
						<td>
							<br>
							<br>
							<img
								src="<%=request.getContextPath()%>/bksx/pictures/MinIcons_001.png" />
							<br>
							目前没有您的课题审批信息，是否新建课题？
							<br>
							<a
								href="<%=request.getContextPath()%>/bksx/bishe/teacher/MySubjectNew.jsp"><font
								color="green">新建课题</font> </a>
							<br>
							<br>
							<br>
						</td>
					</tr>
				</table>
			</div>
		</c:if>
		<br>
		<br>
	</body>
</html>
