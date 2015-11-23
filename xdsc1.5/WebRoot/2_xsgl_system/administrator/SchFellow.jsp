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
			校友信息查询
		</h3>
		<hr>
		<div align="center">
			<form action="getXStudentByOption.action">
				<table>
					<tr>
						<th>
							模糊查找：
						</th>
						<td>
							地区：
						</td>
						<td>
							<select name="region">
								<option value="0">
									北京
								</option>
								<option value="1">
									上海
								</option>
								<option value="2">
									广东
								</option>
							</select>
						</td>
						<td>
							毕业年份：
						</td>
						<td>
							<select name="year">
								<option value="2010">
									2010
								</option>
								<option value="2009">
									2009
								</option>
								<option value="2008"> 
									2008
								</option>
								<option value="2007">
									2007
								</option>
								<option value="2006">
									2006
								</option>
							</select>
						</td>
						<td>
							<input type="submit" value="查询">
						</td>
					</tr>
				</table>
			</form>
			<!-- 精确查询 -->
			<form action="getXStudentByName.action" method="post">
				<table>
					<tr>
						<th>
							精确查找：
						</th>
						<td>
							校友姓名：
						</td>
						<td>
							<input type="text" name="attribute" />
						</td>
						<td>
							<input type="submit" value="查询">
						</td>
					</tr>
				</table>
			</form>	
			</div>	
		<hr>
		<table align="center" width="700">
			<tr>
				<th align="right"><a href="<%=request.getContextPath() %>/2_xsgl_system/system/zz/Add.jsp">
				<img src="<%=request.getContextPath() %>/2_xsgl_system/Pictures/return.gif" align="top" border="0"/>添加</a></th>
			</tr>
		</table> 
		<div align="center">
		<form action="getMXStudentList.action">
			<table border="0" width="700" id="mytable">
				<tr>
					<th colspan="7" background="<%=request.getContextPath() %>/2_xsgl_system/Pictures/newmenubg.gif" height="30">
						<font color="#FFFFFF">校友信息</font>
					</th>
				</tr>
				<tr>
					<th>
						姓名
					</th>
					<th>
						地区
					</th>
					<th>
						毕业年份
					</th>
					
					<th>
						详细信息
					</th>
					<th> 
						修改 
					</th>
					<th>
						删除
					</th>
				</tr>
				<c:forEach items="${xStudentList }" var="xstudent">
				<tr>
					<td>${xstudent.FXiaoYouName }
					</td>
					<td>${xstudent.FRegion } 
					</td>	
					<td>${xstudent.FGraduateYear } 
					</td>
					<td>
						<a href="SchFellowDetails.jsp/showXStudentDetails?id=${xstudent.FXiaoYouId }">浏览</a>
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
			<table width="200">
				<tr>
					<td>
						<a href="ProjectManagement.jsp">首页</a>
					</td>
					<td>
						<a href="ProjectManagement.jsp">上一页</a>
					</td>
					<td>
						<a href="ProjectManagement.jsp">下一页</a>
					</td>
					<td>
						<a href="ProjectManagement.jsp">末页</a>
					</td>
				</tr>
			</table>
		</div>
		<div align="center">
				<form action="schFellowExcelIn.action" enctype="multipart/form-data" method="post">
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
