<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css.css">
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/2_xsgl_system/mycss.css">
		<script language="javascript" src="<%=request.getContextPath() %>/2_xsgl_system/JS/TableColor.js"></script>
	</head>

	<body>
	
		<br>
		<h3 align="center">
			欠费信息
		</h3>
		<hr>
		<br>
		<div align="center">
		<form action="selectFeeByClassYear.action" method="post">
				<table>
					<tr>
						<th>
							快速查询：
						</th>
						<td>
						年份：
						</td>
						<td>
						<select name="year">
							<option value="2009年度">
								2009
							</option>
							<option value="2008年度">
								2008
							</option>
							<option value="2007年度">
								2007
							</option>
						</select>
						</td>
						<td>
						班级：
						</td>
						<td>
							<select name="classid">
								<c:forEach items="${classList }" var="class">
									<option value="${class.FClassNumber }">
										${class.FClassNumber }
									</option>
								</c:forEach>
							</select>
						</td>
						<td>
						<input type="submit" value="查询">	
						</td>
					</tr>
				</table>
			</form>	
			
		<form action="selectFee.action" method="post">
				<table>
					<tr>
						<th>
							精确查找：
						</th>
						<td>
						<select name="way">
							<option>
								----选择查询方式----
							</option>
							<option value="stuNum">
								学生学号
							</option>
							<option value="stuName">
								学生姓名
							</option>
						</select>
						</td>
						<td>
						<input type="text" name="attribute" />
						<input type="submit" value="搜索">	
						</td>
					</tr>
				</table>
			</form>
			</div>	
		<div align="center">
		<form action="getStudentListByGrade.action">
			<table border="0" width="700" id="mytable">
				<tr>
					<th colspan="7" background="<%=request.getContextPath() %>/2_xsgl_system/Pictures/newmenubg.gif" height="30">
						<font color="#FFFFFF">2009届本科生欠费名单</font>
					</th>
				</tr>
				<tr>
				    <th>
						班级
					</th>
					<th>
						学号
					</th>
					<th>
						姓名
					</th>
					<th>
						收费区间
					</th>
					<th>
						学费
					</th>
					<th> 
						住宿费 
					</th>
					<th>
						欠费合计
					</th>
				</tr>
				<c:forEach items="${jStudentList }" var="jstudent">
				<tr>
				   <td>
						${jstudent.tabStudents.tabClasses.FClassNumber }
					</td>
					<td>
						${jstudent.tabStudents.FStudentNumber }
					</td>
					<td>${jstudent.tabStudents.FStudentName }
					</td>
					<td>
						${jstudent.FYear }
					</td>
					<td>${jstudent.FTuition }
					</td>
					<td>${jstudent.FAccommodation } 
					</td>
					<td>
						${jstudent.FTotal }
					</td>
				</tr>
				</c:forEach>
			</table>
			</form>
			<table width="40%">
				<tr>
					<td>
						<div align="center">
							<a href="gradeFeePrevious.action">上一页</a>
						</div>
					</td>
					<td>
						<div align="center">
							<a href="gradeFeeNext.action">下一页</a>
						</div>
					</td>
					<td>
						共${jStudentAll.pageCount }页，当前第${jStudentAll.page+1 }页
					</td>
				</tr>
			</table>
		</div>
		<br>
		<br>
		<br>
	</body>
</html>
