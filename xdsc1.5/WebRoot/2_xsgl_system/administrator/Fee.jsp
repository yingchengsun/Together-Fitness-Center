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
		<form action="selectFeeByYear.action" method="post">
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
							查找学生：
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
			<hr>
		<table align="center" width="700">
			<tr>
				<th align="right"><a href="<%=request.getContextPath() %>/2_xsgl_system/administrator/AddFee.jsp">
				<img src="<%=request.getContextPath() %>/2_xsgl_system/Pictures/return.gif" align="top" border="0"/>添加</a></th>
			</tr>
		</table> 
		<div align="center">
		<form action="getMStudentList.action">
			<table border="0" width="700" id="mytable">
				<tr>
					<th colspan="9" background="<%=request.getContextPath() %>/2_xsgl_system/Pictures/newmenubg.gif" height="30">
						<font color="#FFFFFF">欠费名单列表</font>
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
						学费（元） 
					</th>
					<th> 
						住宿费（元） 
					</th>
					<th>
						欠费合计（元）
					</th>
					<th> 
						修改 
					</th>
					<th>
						删除
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
					<td>
						<a href="<%=request.getContextPath() %>/preUpdateFee.action?id=${jstudent.tabStudents.FStudentNumber }">更新</a>
					</td>
					<td>
						<a href="<%=request.getContextPath() %>/deleteFee.action?id=${jstudent.tabStudents.FStudentNumber }">删除</a>
					</td>
				</tr>
				</c:forEach>
			</table>
			</form>
			<table width="40%">
				<tr>
					<td>
						<div align="center">
							<a href="feePrevious.action">上一页</a>
						</div>
					</td>
					<td>
						<div align="center">
							<a href="feeNext.action">下一页</a>
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
		<div align="center">
				<form action="excelInFee.action" enctype="multipart/form-data" method="post">
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
