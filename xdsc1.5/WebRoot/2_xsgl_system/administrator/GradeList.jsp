<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<link rel="stylesheet" type="text/css"
			href="<%=request.getContextPath()%>/css.css">
		<link rel="stylesheet" type="text/css"
			href="<%=request.getContextPath()%>/2_xsgl_system/mycss.css">
		<script language="javascript"
			src="<%=request.getContextPath()%>/2_xsgl_system/JS/TableColor.js"></script>
	</head>

	<body>

		<br>
		<h3 align="center">
			年级学生信息
		</h3>
		<hr>
		<table align="center" width="700">
			<tr>
				<th align="right">
					<a
						href="<%=request.getContextPath()%>/2_xsgl_system/administrator/AddGrade.jsp">
						<img
							src="<%=request.getContextPath()%>/2_xsgl_system/Pictures/return.gif"
							align="top" border="0" />添加</a>
				</th>
			</tr>
		</table>
		<div align="center">
			<form action="getGradeList.action">
				<table border="0" width="700" id="mytable">
					<tr>
						<th colspan="9"
							background="<%=request.getContextPath()%>/2_xsgl_system/Pictures/newmenubg.gif"
							height="30">
							<font color="#FFFFFF">各年级学生信息列表</font>
						</th>
					</tr>
					<tr>
						<th>
							年级
						</th>
						<th>
							总人数
						</th>
						<th>
							男生人数
						</th>
						<th>
							女生人数
						</th>
						<th>
							指导教师
						</th>
						<th>
							修改
						</th>
						<th>
							删除
						</th>
					</tr>
					<c:forEach items="${gradeList }" var="grade">
						<tr>
							<td>
								${grade.FGradeName }
							</td>
							<td>
								${grade.FGradeTotalNum }
							</td>
							<td>
								${grade.FGradeMaleNum }
							</td>
							<td>
								${grade.FGradeFemaleNum }
							</td>
							<td>
								<c:forEach items="${grade.tabTeacherses }" var="teacher">
									${teacher.FTeacherName }&nbsp;&nbsp;
								</c:forEach>
							<td>
								<a
									href="<%=request.getContextPath()%>/preUpdateGrade.action?gradeid=${grade.FGradeId }">更新</a>
							</td>
							<td>
								<a
									href="<%=request.getContextPath()%>/deleteGrade.action?gradeid=${grade.FGradeId }">删除</a>
							</td>
						</tr>
					</c:forEach>
				</table>
			</form>
			<table width="40%">
				<tr>
					<td>
						<div align="center">
							<a href="gradePrevious.action">上一页</a>
						</div>
					</td>
					<td>
						<div align="center">
							<a href="gradeNext.action">下一页</a>
						</div>
					</td>
					<td>
						共${gradeAll.pageCount }页，当前第${gradeAll.page+1 }页
					</td>
				</tr>
			</table>
		</div>
		<br>
		<br>
		<div align="center">
				<form action="excelInGrade.action" enctype="multipart/form-data" method="post">
					<table border="1" width="700">
						<tr>
							<th height="30" colspan="2" align="center"
								background="<%=request.getContextPath() %>/2_xsgl_system/Pictures/newmenubg.gif">
								<img src="<%=request.getContextPath() %>/2_xsgl_system/Pictures/excel.bmp" border="0" align="top" />
								<font color="#FFFFFF">导入Excel文件</font>
							</th>
						</tr>
						<tr>
							<td>
								选择文件:
							</td>
							<td>
								<input type="file" name="file" size="40">
							</td>
						</tr>
						<tr>
							<td>
								&nbsp;
							</td>
							<td>
								<input type="submit" value="提交" />
								<input type="reset" value="重置" />
							</td>
						</tr>
					</table>
				</form>
			</div>
	</body>
</html>
