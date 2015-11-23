<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" errorPage="/errorPage.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>选题查询</title>

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
			<img
				src="<%=request.getContextPath()%>/bksx/pictures/Vista_Glass_Folders_001.png"
				width="50" height="50" align="middle" />
			选题管理
		</h3>

		<hr>
		<div align="center">
			<ul>
				<li>
					<form
						action="<%=request.getContextPath()%>/showSomeSubstuguiByAttribute.action"
						method="post" onsubmit="return validator(this)">
						<font size="2">精确查找</font>
						<select name="attributeType">
							<option value="tabStudents.FStudentNumber" selected="selected">
								-------学生学号------
							</option>
							<option value="FStudentName">
								-------学生姓名------
							</option>
							<option value="FSubjectName">
								-------课题名称------
							</option>
							<option value="FTeacherName">
								-------导师姓名------
							</option>
						</select>
						<input type="text" name="attribute" valid="required"
							errmsg="请输入查询条件!" />
						<input type="submit" value="搜索">
					</form>
				</li>
				<li>
					<form
						action="<%=request.getContextPath()%>/showSomeSubstuguiByCategory.action"
						method="post">
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
						<select name="substuguiCategory">
							<option value="FIsResearch" selected="selected">
								------科研------------
							</option>
							<option value="FIsSimulation">
								------模拟------------
							</option>
							<option value="FIsLab">
								------实验室建设-----
							</option>
							<option value="FIsOthers">
								------其他------------
							</option>
						</select>
						<input type="submit" value="快速搜索信息" />
					</form>
				</li>
			</ul>
		</div>
		<hr>

		<div align="center">
		<c:choose>
			<c:when test="${not empty substuguilist}">
				<table align="center" width="98%">
				<tr>
					<th align="right">
						<a href="<%=request.getContextPath()%>/exportSubstugui.action"><img
								src="<%=request.getContextPath()%>/bksx/pictures/excel.bmp"
								align="top" border="0" />导出为Excel文件 </a>
					</th>
				</tr>
			</table>
			<table border="1" cellspacing="0" id="mytable" width="98%">
				<tr>
					<th colspan="18"
						background="<%=request.getContextPath()%>/bksx/pictures/bluebar.gif"
						height="30">
						毕业设计选题信息
					</th>
				</tr>
				<tr>
					<th rowspan="2">
						序号
					</th>
					<th rowspan="2">
						课题名称
					</th>
					<th colspan="4">
						课题性质
					</th>
					<th colspan="4">
						课题来源
					</th>
					<th rowspan="2" width="20">
						难度等级
					</th>
					<th colspan="2">
						导师
					</th>
					<th rowspan="2" width="30">
						工作地点
					</th>
					<th colspan="2">
						学生
					</th>
					<th colspan="2">
						操作
					</th>
				</tr>
				<tr>
					<th width="30" bgcolor="#FFFFFF">
						软件
					</th>
					<th width="30" bgcolor="#FFFFFF">
						硬件
					</th>
					<th width="30" bgcolor="#FFFFFF">
						软硬结合
					</th>
					<th width="30" bgcolor="#FFFFFF">
						文献综述
					</th>
					<th width="30" bgcolor="#FFFFFF">
						科研
					</th>
					<th width="30" bgcolor="#FFFFFF">
						模拟
					</th>
					<th width="30" bgcolor="#FFFFFF">
						实验室建设
					</th>
					<th width="30" bgcolor="#FFFFFF">
						其他
					</th>
					<th bgcolor="#FFFFFF">
						姓名
					</th>
					<th bgcolor="#FFFFFF">
						职称
					</th>
					<th bgcolor="#FFFFFF">
						姓名
					</th>
					<th bgcolor="#FFFFFF">
						学号
					</th>
					<th bgcolor="#FFFFFF">
						更新
					</th>
					<th bgcolor="#FFFFFF">
						删除
					</th>
				</tr>
				<c:forEach items="${substuguilist}" var="ssg">
					<tr>
						<td>
							${ssg.FSubStuGuiId }
						</td>
						<td>
							${ssg.FSubjectName }&nbsp;
						</td>
						<td>
							${ssg.FIsSoftware }&nbsp;
						</td>
						<td>
							${ssg.FIsHardware }&nbsp;
						</td>
						<td>
							${ssg.FIsSoftHard }&nbsp;
						</td>
						<td>
							${ssg.FIsDocument }&nbsp;
						</td>
						<td>
							${ssg.FIsResearch }&nbsp;
						</td>
						<td>
							${ssg.FIsSimulation }&nbsp;
						</td>
						<td>
							${ssg.FIsLab }&nbsp;
						</td>
						<td>
							${ssg.FIsOthers }&nbsp;
						</td>
						<td>
							${ssg.FLevel }&nbsp;
						</td>
						<td>
							${ssg.FTeacherName }&nbsp;
						</td>
						<td>
							${ssg.FTeacherDegreen }&nbsp;
						</td>
						<td>
							${ssg.FWorkPlace }&nbsp;
						</td>
						<td>
							${ssg.FStudentName }&nbsp;
						</td>
						<td>
							${ssg.tabStudents.FStudentNumber }&nbsp;
						</td>
						<td>
							<a
								href="<%=request.getContextPath()%>/preUpdateSubstugui.action?id=${ssg.FSubStuGuiId }"><img
									src="<%=request.getContextPath()%>/bksx/pictures/update.gif"
									border="0" />
							</a>
						</td>
						<td>
							<a
								onclick="javascript: if(window.confirm('数据不可恢复，确定要删除么？')) window.location.href='<%=request.getContextPath()%>/deleteSubstugui.action?id=${ssg.FSubStuGuiId }'; ">
								<img
									src="<%=request.getContextPath()%>/bksx/pictures/delete.gif" border="0"/>
							</a>
						</td>
					</tr>
				</c:forEach>
			</table>
			<table width="40%">
				<tr>
					<td>
						<div align="center">
							<a href="<%=request.getContextPath()%>/showSubstugui.action?p=1">首页</a>
						</div>
					</td>
					<td>
						<div align="center">
							<a
								href="<%=request.getContextPath()%>/showSubstugui.action?p=${p-1}">上一页</a>
						</div>
					</td>
					<td>
						<div align="center">
							<a
								href="<%=request.getContextPath()%>/showSubstugui.action?p=${p+1}">下一页</a>
						</div>
					</td>
					<td>
						<div align="center">
							<a
								href="<%=request.getContextPath()%>/showSubstugui.action?p=${lastPage}">末页</a>
						</div>
					</td>
				</tr>
			</table>
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
							目前没有课题信息！
							<br>
							<br>
							<br>
						</td>
					</tr>
				</table>
			</div>
			</c:otherwise>
		</c:choose>
			
		</div>
		<br>
		<br>

	</body>
</html>
