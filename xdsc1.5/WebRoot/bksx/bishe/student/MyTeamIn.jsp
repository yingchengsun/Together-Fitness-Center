<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" errorPage="/errorPage.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>团队列表</title>
		<link rel="stylesheet" type="text/css"
			href="<%=request.getContextPath()%>/bksx/css/css.css">
		<link rel="stylesheet" type="text/css"
			href="<%=request.getContextPath()%>/bksx/css/mycss.css">
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
				src="<%=request.getContextPath()%>/bksx/pictures/De_icon_001.png"
				width="50" height="50" align="middle" />
			团队查询
		</h3>
		<hr>
		<div align="center">
			<ul>
				<li>
					<form action="<%=request.getContextPath()%>/showTeamByName.action"
						method="post" onsubmit="return validator(this)">
						<font size="2">团队名称：</font>
						<input type="text" name="FTeamName" size="32" valid="required"
							errmsg="请输入队伍名称或关键字!" />
						<input type="submit" value="搜索">
					</form>
				</li>
				<li>
					<form action="<%=request.getContextPath()%>/showTeamByDate.action"
						method="post" onsubmit="return validator(this)">
						<font size="2">创建时间：</font>
						<input readonly="readonly" type="text" name="startDate"
							onClick="WdatePicker()" size="12" valid="required"
							errmsg="请选择开始日期!" />
						至
						<input readonly="readonly" type="text" name="endDate"
							onClick="WdatePicker()" size="12" valid="required"
							errmsg="请选择结束日期!" />
						<input type="submit" value="搜索">
					</form>
				</li>
			</ul>
		</div>
		<hr>
		<div align="center">
			<c:if test="${not empty member }">
				<img src="<%=request.getContextPath()%>/bksx/pictures/leaf.gif" />
				<font size="2"><br>提示：您目前已有队伍，这里只提供队伍信息查询的功能，<br>如想加入另一支队伍，请先退出当前队伍</font>
				<br>
				<br>
			</c:if>

			<table width="98%" border="1" cellspacing="0">
				<tr>
					<th colspan="5"
						background="<%=request.getContextPath()%>/bksx/pictures/bluebar.gif"
						height="30">
						团队信息 
					</th>
				</tr>
				<tr>
					<th>
						团队编号
					</th>
					<th>
						团队名称
					</th>
					<th>
						创建者
					</th>
					<th>
						创建日期
					</th>
					<c:if test="${empty member }">
						<th>
							操作
						</th>
					</c:if>
				</tr>
				<c:forEach items="${teamlist }" var="team">
					<tr>
						<td>
							${team.FTeamId }
						</td>
						<td>
							${team.FTeamName }
						</td>
						<td>
							${team.FTeamCreator }
						</td>
						<td>
							<fmt:formatDate value="${team.FTeamCreateDate }" type="date"
								dateStyle="medium" />
						</td>
						<c:if test="${empty member }">
							<td>
								<a
									onclick="javascript: if(window.confirm('确定要向这个队伍提出申请么？')) window.location.href='<%=request.getContextPath()%>/applyTeam.action?id=${team.FTeamId }'; "
									>申请加入</a>
							</td>
						</c:if>
					</tr>
				</c:forEach>
			</table>
			<table width="40%">
				<tr>
					<td>
						<div align="center">
							<a href="<%=request.getContextPath()%>/showAllTeam.action?p=1">首页</a>
						</div>
					</td>
					<td>
						<div align="center">
							<a
								href="<%=request.getContextPath()%>/showAllTeam.action?p=${p-1}">上一页</a>
						</div>
					</td>
					<td>
						<div align="center">
							<a
								href="<%=request.getContextPath()%>/showAllTeam.action?p=${p+1}">下一页</a>
						</div>
					</td>
					<td>
						<div align="center">
							<a
								href="<%=request.getContextPath()%>/showAllTeam.action?p=${lastPage}">末页</a>
						</div>
					</td>
				</tr>
			</table>
		</div>
		<hr>
		<div align="center">
			<c:if test="${not empty applyList }">
				<table width="98%" border="1" cellspacing="0">
					<tr>
						<th colspan="6"
							background="<%=request.getContextPath()%>/bksx/pictures/bluebar.gif"
							height="30">
							以下是您的入队申请信息 
						</th>
					</tr>
					<tr>
						<th>
							团队编号
						</th>
						<th>
							团队名称
						</th>
						<th>
							创建者
						</th>
						<th>
							申请结果
						</th>
						<th>
							操作
						</th>
					</tr>
					<c:forEach items="${applyList }" var="apply">
						<tr>
							<td>
								${apply.bksxTabTeam.FTeamId }
							</td>
							<td>
								${apply.bksxTabTeam.FTeamName }
							</td>
							<td>
								${apply.bksxTabTeam.FTeamCreator }
							</td>
							<td>
								<font color="red">${apply.FResult }</font>
							</td>
							<td>
								<a
									onclick="javascript: if(window.confirm('确定要取消此项入队申请么？')) window.location.href='<%=request.getContextPath()%>/deleteApply.action?id=${apply.FAid }'; "
									>取消申请</a>
							</td>
						</tr>
					</c:forEach>
				</table>
			</c:if>
			<c:if test="${empty applyList }">
				<font color="green" size="2">目前没有您申请队伍的反馈信息</font>
			</c:if>
		</div>
		<br>
		<br>
		<br>
	</body>
</html>
