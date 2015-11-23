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
		<br>
		<h3 align="center">
			详细信息
		</h3>
		<hr>
		<div align="center">
			<form action="<%=request.getContextPath()%>/addGrade.action"
				method="post">
				<table border="1" width="700">
					<tr>
						<th height="30" colspan="2" align="center"
							background="<%=request.getContextPath()%>/2_xsgl_system/Pictures/newmenubg.gif">
							<font color="#FFFFFF">编辑信息</font>
						</th>
					</tr>
					<tr>
						<td>
							年份：
						</td>
						<td>
							<input type="text" name="FGradeNum">
						</td>
					</tr>
					<tr>
						<td>
							类别：
						</td>
						<td>
							<input type="radio" name="gradeType" value="0" checked="checked">
							本科生
							<input type="radio" name="gradeType" value="1">
							研究生
						</td>
					</tr>
					<tr>
						<td>
							年级名称：
						</td>
						<td>
							<input type="text" name="FGradeName">
						</td>
					</tr>
					<tr>
						<td>
							总人数：
						</td>
						<td>
							<input type="text" name="FGradeTotalNum">
						</td>
					</tr>
					<tr>
						<td>
							男生人数：
						</td>
						<td>
							<input type="text" name="FGradeMaleNum">
						</td>
					</tr>
					<tr>
						<td>
							女生人数：
						</td>
						<td>
							<input type="text" name="FGradeFemaleNum">
						</td>
					</tr>
					<tr>
						<td>
							班主任：
						</td>
						<td>
							<input type="text" name="teacherName0">
						</td>
					</tr>
					<tr>
						<td>
							辅导员：
						</td>
						<td>
							<input type="text" name="teacherName1">
						</td>
					</tr>
					<tr>
						<td>
							提示：多个辅导员请用“/”隔开
						</td>
						<td>
							<input type="submit" value="提交">
							&nbsp;&nbsp;
							<input type="reset" value="重置">
						</td>
					</tr>
				</table>
			</form>
		</div>
		<br>
	</body>
</html>
