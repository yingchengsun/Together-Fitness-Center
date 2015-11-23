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
			研究生名单  
		</h3>
		<hr>
		<div align="center">
			<form action="selectPostgraduateByClass.action">
				<table>
					<tr>
						<th>
							查找班级：
						</th>
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
			<!-- 精确查询 -->
			
			<form action="selectPostgraduateByStu.action" method="post">
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
							<option value="number">
								学生学号
							</option>
							<option value="name">
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
				<th align="right"><a href="<%=request.getContextPath() %>/2_xsgl_system/administrator/AddPostgraduate.jsp">
				<img src="<%=request.getContextPath() %>/2_xsgl_system/Pictures/return.gif" align="top" border="0"/>添加</a></th>
			</tr>
		</table> 
		<div align="center">
		<form action="getPostgraduateList.action">
		 			<table border="0" width="700" id="mytable">
				<tr>
					<th colspan="7" background="<%=request.getContextPath() %>/2_xsgl_system/Pictures/newmenubg.gif" height="30">
						<font color="#FFFFFF">研究生信息列表</font>
					</th>
				</tr>
				<tr>
				<th>
					学号
					</th>
					<th>
						姓名
					</th>
					<th>班级 
					</th>
					<th>导师 
					</th>
					<th colspan=2>详细信息 
					</th>
					<th>
						删除
					</th>
				</tr>
				<c:forEach items="${postgraduateList }" var="postgraduate">
				<tr>
				<td>  ${postgraduate.FStudentNumber }
					</td>
					<td>
					 ${postgraduate.tabStudents.FStudentName }
					</td>
					<td> ${postgraduate.tabStudents.tabClasses.FClassNumber }
						</td>				
					<td> 
						 ${postgraduate.tabTeachers.FTeacherName }</td>	
				<td>
						<a href="<%=request.getContextPath() %>/showPostgraduate.action?id=${postgraduate.FStudentNumber }">浏览</a>
					</td>
					<td>
						<a href="<%=request.getContextPath() %>/preUpdatePostgraduate.action?id=${postgraduate.FStudentNumber }">编辑</a>
					</td>
					<td>
						<a href="<%=request.getContextPath() %>/deletePostgraduate.action?id=${postgraduate.FStudentNumber }">删除</a>
					</td>
				</tr>
				</c:forEach>
			</table>
			</form>
			<table width="40%">
				<tr>
					<td>
						<div align="center">
							<a href="postgraPrevious.action">上一页</a>
						</div>
					</td>
					<td>
						<div align="center">
							<a href="postgraNext.action">下一页</a>
						</div>
					</td>
					<td>
						共${postgraduateAll.pageCount }页，当前第${postgraduateAll.page+1 }页
					</td>
				</tr>
			</table>
			</div>
			<br>
			<br>
			<div align="center">
				<form action="excelInPostgraduate.action" enctype="multipart/form-data" method="post">
					<table border="1" width="700">
						<tr>
							<th height="30" colspan="2" align="center"
								background="<%=request.getContextPath() %>/2_xsgl_system/Pictures/newmenubg.gif">
								<img src="<%=request.getContextPath() %>/2_xsgl_system/Pictures/excel.bmp" border="0" align="top" />
								<font color="#FFFFFF">批量导入（Excel文件）</font>
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
