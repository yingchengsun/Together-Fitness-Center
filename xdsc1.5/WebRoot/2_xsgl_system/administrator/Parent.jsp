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
			学生家长信息  
		</h3>
		<hr>
		<div align="center">
			
			<!-- 精确查询 -->
			
			<form action="selectParent.action" method="post">
				<table>
					<tr>
						<th>
							快速查找：
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
							<option value="parentNum">
								家长ID
							</option>
							<option value="parentName">
								家长姓名
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
				<th align="right"><a href="<%=request.getContextPath() %>/2_xsgl_system/administrator/AddParent.jsp">
				<img src="<%=request.getContextPath() %>/2_xsgl_system/Pictures/return.gif" align="top" border="0"/>添加</a></th>
			</tr>
		</table> 
		<div align="center">
		<form action="getParentList.action">
		 			<table border="0" width="700" id="mytable">
				<tr>
					<th colspan="7" background="<%=request.getContextPath() %>/2_xsgl_system/Pictures/newmenubg.gif" height="30">
						<font color="#FFFFFF">研究生信息列表</font>
					</th>
				</tr>
				<tr>
				<th>
					家长ID
					</th>
					<th>
						家长姓名
					</th>
					<th>学生学号 
					</th>
					<th>学生姓名 
					</th>
					<th>学生详细信息 
					</th>
					<th>
						修改
					</th>
					<th>
						删除
					</th>
				</tr>
				<c:forEach items="${parentList }" var="parent">
				<tr>
				<td>  ${parent.FParentId }
					</td>
					<td>
					 ${parent.FParentName }
					</td>
					<td> ${parent.tabStudents.FStudentNumber }
						</td>				
					<td> 
						 ${parent.tabStudents.FStudentName }</td>	
				<td>
						<a href="<%=request.getContextPath() %>/showStudent.action?id=${parent.tabStudents.FStudentNumber }">浏览</a>
					</td>
					
					<td>
						<a href="<%=request.getContextPath() %>/preUpdateParent.action?pid=${parent.FParentId }">更新</a>
					</td>
					<td>
						<a href="<%=request.getContextPath() %>/deleteParent.action?pid=${parent.FParentId }">删除</a>
					</td>
				</tr>
				</c:forEach>
			</table>
			</form>
			<table width="40%">
				<tr>
					<td>
						<div align="center">
							<a href="parentPrevious.action">上一页</a>
						</div>
					</td>
					<td>
						<div align="center">
							<a href="parentNext.action">下一页</a>
						</div>
					</td>
					<td>
						共${parentAll.pageCount }页，当前第${parentAll.page+1 }页
					</td>
				</tr>
			</table>
			</div>
			<br>
			<br>
			<div align="center">
				<form action="excelInParent.action" enctype="multipart/form-data" method="post">
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
