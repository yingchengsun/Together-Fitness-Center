<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" errorPage="/errorPage.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
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
			<img src="<%=request.getContextPath()%>/bksx/pictures/3dicon_001.png"
				width="50" height="50" align="middle" />
			课题查询
		</h3>
		<hr>
		<div align="center">
			<form action="getResearchByAttribute.action" method="post"
				onsubmit="return validator(this)">
				<font size="2">精确查找</font>
				<select name="attributeType">
					<option value="tabStudents.FStudentNumber">
						学生学号
					</option>
					<option value="FStudentName">
						学生姓名
					</option>
					<option value="FSubjectName">
						课题名称
					</option>
					<option value="FTeacherName">
						指导教师
					</option>
				</select>
				<input type="text" name="attribute" valid="required"
					errmsg="请输入查询条件!" />
				<input type="submit" value="搜索">
			</form>
			<form action="getResearchByGrade.action" method="post">
				<font size="2">快速查找</font>
				<select name="regDate">
					<option value="2006">
						2006
					</option>
					<option value="2007">
						2007
					</option>
					<option value="2008">
						2008
					</option>
					<option value="2009">
						2009
					</option>
					<option value="2010">
						2010
					</option>
					<option value="2011">
						2011
					</option>
					<option value="2012">
						2012
					</option>
				</select>
				<select name="subtype">
					<option value="FIsSoftware">
						软件项目
					</option>
					<option value="FIsHardware">
						硬件项目
					</option>
					<option value="FIsSoftHard">
						软硬结合
					</option>
					<option value="FIsDocument">
						文献综述
					</option>
				</select>
				<input type="submit" value="   快速查找  ">
			</form>
		</div>
		<hr>
		<c:if test="${not empty researchList }">
			<div align="center">
				<table border="1" cellspacing="0" width="98%" id="mytable">
					<tr>
						<th colspan="6"
							background="<%=request.getContextPath()%>/bksx/pictures/bluebar.gif"
							height="30">
							毕业设计课题信息
						</th>
					</tr>
					<tr>
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
							指导教师
						</th>
						<th>
							选题学生
						</th>
						<th>
							详细进展
						</th>
					</tr>
					<c:forEach items="${researchList }" var="research">
						<tr>
							<td>
								${research.FSubjectName }
							</td>
							<td>
								<c:if test="${research.FIsSoftware=='Y' }">软件项目</c:if>
								<c:if test="${research.FIsHardware=='Y' }">硬件项目</c:if>
								<c:if test="${research.FIsSoftHard=='Y' }">软硬结合</c:if>
								<c:if test="${research.FIsDocument=='Y' }">文献综述</c:if>
							</td>
							<td>
								<c:if test="${research.FIsResearch=='Y' }">科研项目</c:if>
								<c:if test="${research.FIsSimulation=='Y' }">模拟项目</c:if>
								<c:if test="${research.FIsLab=='Y' }">实验室建设</c:if>
								<c:if test="${research.FIsOthers=='Y' }">其他类别</c:if>
							</td>
							<td>
								${research.FTeacherName }
							</td>
							<td>
								${research.FStudentName }
							</td>
							<td>
								<a
									href="<%=request.getContextPath()%>/researchView.action?id=${research.FSubStuGuiId }&subtype=<%=request.getAttribute("subtype")%>"><img
										src="<%=request.getContextPath()%>/bksx/pictures/lookdetail.gif"
										border="0" align="top" /> </a>
							</td>
						</tr>
					</c:forEach>
				</table>
				<c:if test="${pageTag=='ALL' }">
					<table width="40%">
						<tr>
							<td>
								<div align="center">
									<a
										href="<%=request.getContextPath()%>/getResearchSubject.action?p=1">首页</a>
								</div>
							</td>
							<td>
								<div align="center">
									<a
										href="<%=request.getContextPath()%>/getResearchSubject.action?p=${p-1}">上一页</a>
								</div>
							</td>
							<td>
								<div align="center">
									<a
										href="<%=request.getContextPath()%>/getResearchSubject.action?p=${p+1}">下一页</a>
								</div>
							</td>
							<td>
								<div align="center">
									<a
										href="<%=request.getContextPath()%>/getResearchSubject.action?p=${lastPage}">末页</a>
								</div>
							</td>
						</tr>
					</table>
				</c:if>
			</div>
		</c:if>
		<c:if test="${empty researchList }">
			<div align="center">
				<table border="1" cellspacing="0" width="98%">
					<tr>
						<td>
							<br>
							<br>
							<img
								src="<%=request.getContextPath()%>/bksx/pictures/MinIcons_001.png" />
							<br>
							目前没有此类课题信息！
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
		<br>
	</body>
</html>
