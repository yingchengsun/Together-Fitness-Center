<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" errorPage="/errorPage.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>团队信息</title>

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
				src="<%=request.getContextPath()%>/bksx/pictures/001CAT3EKQV.png"
				width="50" height="50" align="middle" />
			我的团队
		</h3>

		<hr>
		<br>
		<c:choose>
			<c:when test="${subject=='project' }">
				<div align="center">
					<c:if test="${not empty project}">
						
									<fieldset>
										<legend>
											<img
												src="<%=request.getContextPath()%>/bksx/pictures/bricks.png">
											&nbsp;
											<font size="3">团队信息</font>
										</legend>
										<table border="0" width="90%">

											<tr>
												<th colspan="2">

												</th>
											</tr>
											<tr>
												<td>
													团队编号
												</td>
												<td>
													${project.bksxTabTeam.FTeamId }
												</td>
											</tr>
											<tr>
												<td>
													团队名称
												</td>
												<td>
													${project.bksxTabTeam.FTeamName }
												</td>
											</tr>
											<tr>
												<td>
													团队项目
												</td>
												<td>
													${project.FProjectName }
												</td>
											</tr>

											<c:if test="${teamrole!='项目经理' }">
												<tr>
													<td colspan="2">
														<a
															onclick="javascript: if(window.confirm('确定要退出当前队伍么？')) window.location.href='<%=request.getContextPath()%>/outOfTeam.action'; "><img
																src="<%=request.getContextPath()%>/bksx/pictures/byebye.gif"
																border="0" align="top">退出当前团队</a>
													</td>
												</tr>
											</c:if>
										</table>
									</fieldset>
								
									<fieldset>
										<legend>
											<img
												src="<%=request.getContextPath()%>/bksx/pictures/door_in.png">
											&nbsp;
											<font size="3">申请信息</font>
										</legend>
										<table border="0" width="100%">
											<tr>
												<td>

													<c:if test="${not empty applyMyTeamList}">
														<table width="90%" border="1" cellspacing="0">
															<tr height="25">
																<th>
																	<font color="#005AB5">申请人学号</font>
																</th>
																<th>
																	<font color="#005AB5">申请人姓名</font>
																</th>
																<th>
																	<font color="#005AB5">申请人性别</font>
																</th>
																<th colspan="2">
																	<c:if test="${teamrole=='项目经理' }">
																		<font color="#005AB5">操作</font>
																	</c:if>
																</th>
															</tr>
															<c:forEach items="${applyMyTeamList }" var="apply">
																<tr>
																	<td>
																		<font color="#005AB5">
																			${apply.tabStudents.FStudentNumber }</font>
																	</td>
																	<td>
																		<font color="#005AB5">
																			${apply.tabStudents.FStudentName }</font>
																	</td>
																	<td>
																		<font color="#005AB5">
																			${apply.tabStudents.FStudentSex }</font>
																	</td>
																	<td>
																		<c:if test="${teamrole=='项目经理' }">
																			<a
																				onclick="javascript: if(window.confirm('确定接受该同学加入你的队伍么？')) window.location.href='<%=request.getContextPath()%>/agreeApply.action?id=${apply.FAid }'; ">
																				<font color="#005AB5">【同意】</font> </a>
																		</c:if>
																	</td>
																	<td>
																		<c:if test="${teamrole=='项目经理' }">
																			<a
																				onclick="javascript: if(window.confirm('确定拒绝该同学加入你的队伍么？')) window.location.href='<%=request.getContextPath()%>/refuseApply.action?id=${apply.FAid }'; ">
																				<font color="#005AB5">【拒绝】</font> </a>
																		</c:if>
																	</td>

																</tr>
															</c:forEach>
														</table>
													</c:if>
													<c:if test="${empty applyMyTeamList}">
														<font size="2">目前没有需处理的入队申请信息</font>
													</c:if>

												</td>
											</tr>
										</table>
									</fieldset>
								
						<br>
						<table width="98%" border="1" cellspacing="0" id="mytable">
							<tr>
								<th colspan="7"
									background="<%=request.getContextPath()%>/bksx/pictures/bluebar.gif"
									height="30">
									成员信息
								</th>
							</tr>
							<tr>
								<th>
									学号
								</th>
								<th>
									姓名
								</th>
								<th>
									职责
								</th>
								<th>
									团队
								</th>
								<th>
									备注
								</th>
								<c:if test="${teamrole=='项目经理' }">
									<th colspan="2">
										操作
									</th>
								</c:if>
							</tr>
							<c:forEach items="${memberList }" var="member">
								<tr>
									<td>
										${member.FStudentNumber }
									</td>
									<td>
										${member.tabStudents.FStudentName }
									</td>
									<td>
										${member.FTeamRole }
									</td>
									<td>
										${member.bksxTabTeam.FTeamName }
									</td>
									<td>
										${member.FMemberDescription }
									</td>
									<c:if test="${teamrole=='项目经理' }">
										<td>
											<a
												href="<%=request.getContextPath()%>/preUpdateMember.action?id=${member.FStudentNumber }">任务指派</a>
										</td>
										<td>
											<a
												onclick="javascript: if(window.confirm('确定要将其由队伍中剔除么？')) window.location.href='<%=request.getContextPath()%>/deleteMember.action?id=${member.FStudentNumber }'; ">将其逐出</a>
										</td>
									</c:if>
								</tr>
							</c:forEach>
						</table>
						<br>
						<hr>
					</c:if>
					<br>
					<br>
					<br>
					<c:if test="${empty project}">
						<font size="2">您还未加入任何项目团队！<br> 您可以选择 <a
							href="<%=request.getContextPath()%>/showAllTeam.action"><img
									src="<%=request.getContextPath()%>/bksx/pictures/people.gif"
									border="0"><font color="red">加入一个团队</font> </a> 或者 <a
							href="<%=request.getContextPath()%>/preCreateProject.action"><img
									src="<%=request.getContextPath()%>/bksx/pictures/student.gif"
									align="top" border="0"><font color="red">创建一个新的项目团队</font>
						</a> </font>
					</c:if>
				</div>
			</c:when>
			<c:otherwise>
				<div align="center">
					<table border="1" cellspacing="0" width="98%">
						<tr>
							<td>
								<br>
								<br>
								<img
									src="<%=request.getContextPath()%>/bksx/pictures/MinIcons_001.png" />
								<br>
								你还未立项或未加入某项目团队，请使用【科研课题】进行毕业设计管理工作
								<br>
								如需使用，请首先使用【毕设立项】做好准备工作
								<br>
								<br>
								<br>
								<br>
							</td>
						</tr>
					</table>
				</div>
			</c:otherwise>
		</c:choose>
		<br>
		<br>
		<br>
	</body>
</html>
