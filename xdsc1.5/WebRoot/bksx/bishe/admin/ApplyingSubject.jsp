<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" errorPage="/errorPage.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>审批课题</title>
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
			<img
				src="<%=request.getContextPath()%>/bksx/pictures/CS3_CheckMark_001.png"
				width="50" height="50" align="middle" />
			课题审批
		</h3>
		<hr>
		<br>
		<c:if test="${not empty applyList}">
			<div align="center">

				<table border="1" cellspacing="0" width="98%" id="mytable">
					<tr>
						<th height="30" colspan="8"
							background="<%=request.getContextPath()%>/bksx/pictures/bluebar.gif">
							待审批的课题信息
						</th>
					</tr>
					<tr>
						<th>
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
							出题人
						</th>
						<th>
							详细信息
						</th>
					</tr>
					<c:forEach items="${applyList }" var="substugui">
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
								${substugui.FTeacherName }
							</td>
							<td>
								<a
									href="<%=request.getContextPath()%>/applyingSubjectDetail.action?id=${substugui.FSubStuGuiId }"><img
										src="<%=request.getContextPath()%>/bksx/pictures/lookdetail.gif"
										border="0" align="top" /> </a>
							</td>
						</tr>
					</c:forEach>
				</table>
				<table width="40%">
				<tr>
					<td>
						<div align="center">
							<a href="<%=request.getContextPath()%>/getNewApplySubject.action?p=1">首页</a>
						</div>
					</td>
					<td>
						<div align="center">
							<a
								href="<%=request.getContextPath()%>/getNewApplySubject.action?p=${p-1}">上一页</a>
						</div>
					</td>
					<td>
						<div align="center">
							<a
								href="<%=request.getContextPath()%>/getNewApplySubject.action?p=${p+1}">下一页</a>
						</div>
					</td>
					<td>
						<div align="center">
							<a
								href="<%=request.getContextPath()%>/getNewApplySubject.action?p=${lastPage}">末页</a>
						</div>
					</td>
				</tr>
			</table>
				<br>
			</div>
		</c:if>
		<c:if test="${empty applyList}">
			<div align="center">
				<table border="1" cellspacing="0" width="98%">
					<tr>
						<td>
							<br>
							<br>
							<img
								src="<%=request.getContextPath()%>/bksx/pictures/MinIcons_001.png" />
							<br>
							目前没有待审批的课题信息
							<br>
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
