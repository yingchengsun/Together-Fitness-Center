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
			奖学金信息
		</h3>
		<hr>
		<div align="center">
		<form action="getFStudentListBySchOption.action">
				<table>
					<tr>
						<th>
							历史查询：
						</th>
						<td>
							年份：
						</td>
						<td>
							<select name="year">
							
							<option value="2009">
									2009
								</option>
							<option value="2008">
									2008
								</option>
							<option value="2007">
									2007
								</option>
							</select>
						</td>
						<td>
							班级：
						</td>
						<td>
							<select name="classid">
								<option value="130611">
									130611
								</option>
								<option value="130612">
									130612
								</option>
								<option value="130613">
									130613
								</option>
							</select>
						</td>
						
						<td>
							<input type="submit" value="查询">
						</td>
					</tr>
				</table>
			</form>
		</div>
		<hr>
		<br>
		<table align="center" width="700">
			<tr>
				<th align="right"><a href="<%=request.getContextPath() %>/2_xsgl_system/system/zz/Add.jsp">
				<img src="<%=request.getContextPath() %>/2_xsgl_system/Pictures/return.gif" align="top" border="0"/>添加</a></th>
			</tr>
		</table> 
		<div align="center">
		<form action="getFStudentListByScholarship.action">
			<table border="0" width="700" id="mytable">
				<tr>
					<th colspan="8" background="<%=request.getContextPath() %>/2_xsgl_system/Pictures/newmenubg.gif" height="30">
						<font color="#FFFFFF">奖学金信息列表</font>
					</th>
				</tr>
				<tr>
				    <th>
						姓名
					</th>
					<th>
						学号
					</th>
					<th>
						班级
					</th>
					<th>
						类别
					</th>
					
					<th>
						金额（元）
					</th>
					<th>
						年份
					</th>
					<th>
						修改
					</th>
					<th>
						删除
					</th>
				</tr>
				<c:forEach items="${fstudentList }" var="fstudent">
				<tr>
					<td>
						${fstudent.tabStudents.FStudentName }
					</td>
					<td>${fstudent.tabStudents.FStudentNumber }
					</td>				
					<td> 
						${fstudent.tabStudents.tabClasses.FClassNumber } 
					</td>
					<td>
						${fstudent.FName }
					</td>
					<td>
						${fstudent.FAmount }
					</td>
					<td>
						${fstudent.FYear }
					</td>
					<td>
						<a href="<%=request.getContextPath() %>/preUpdateFundStudent.action?id=${fstudent.FId }">更新</a>
					</td>
					<td>
						<a href="<%=request.getContextPath() %>/deleteFundStudent.action?id=${fstudent.FId }">删除</a>
					</td>
				</tr>
				</c:forEach>
			</table>
			</form>
		<table width="40%">
				<tr>
					<td>
						<div align="center">
							<a href="schStuPrevious.action">上一页</a>
						</div>
					</td>
					<td>
						<div align="center">
							<a href="schStuNext.action">下一页</a>
						</div>
					</td>
					<td>
						共${fStudentAll.pageCount }页，当前第${fStudentAll.page+1 }页
					</td>
				</tr>
			</table>
		</div>
		<br>
		<br>
		<div align="center">
				<form action="excelInGradeFund.action" enctype="multipart/form-data" method="post">
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
