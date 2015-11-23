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
	
		<h3 align="center">
			软件学院学生组织
		</h3>
		<hr>
		<div align="center">
		<form action="selectStudentByOrgDep.action">
				<table>
					<tr>
						<th>
							快速查找：
						</th>
						<td>
							组织部门名称：
						</td>
						<td>
							<select name="dname">
								<c:forEach items="${departmentList }" var="department">
									<option value="${department.FDid }">
										${department.FDname }
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
			<form action="selectDepStudentByStu.action" method="post">
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
				<th align="right"><a href="<%=request.getContextPath() %>/2_xsgl_system/administrator/AddOrgStu.jsp">
				<img src="<%=request.getContextPath() %>/2_xsgl_system/Pictures/return.gif" align="top" border="0"/>添加</a></th>
			</tr>
		</table> 
		<div align="center">
		<form action="getOrgStudentList.action">
			<table border="0" width="700" id="mytable">
				<tr>
					<th colspan="9" background="<%=request.getContextPath() %>/2_xsgl_system/Pictures/newmenubg.gif" height="30">
						<font color="#FFFFFF">软件学院学生组织成员信息列表</font>
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
						性别
					</th>
					<th>
						组织
					</th>
					<th>
						部门
					</th>
					<th>
						职务
					</th>
					<th> 
						联系电话 
					</th>
					
					<th> 
						修改 
					</th>
					<th>
						删除
					</th>
				</tr>
				<c:forEach items="${studentList }" var="student">
				<tr>
					<td>
						${student.tabStudents.FStudentName }
					</td>
					<td>${student.tabStudents.FStudentNumber }
					</td>	
					<td>${student.tabStudents.FStudentSex }
					</td>
					<td>${student.xsglTabDepartment.xsglTabOrganizations.FOname }
					</td>
					<td>${student.xsglTabDepartment.FDname }
					</td>
					<td>${student.FPosition }
					</td>
					<td>${student.tabStudents.FStudentTel } 
					</td>
					<td>
						<a href="<%=request.getContextPath() %>/preUpdateOrgStu.action?fid=${student.FId }">更新</a>
					</td>
					<td>
						<a href="<%=request.getContextPath() %>/deleteOrgStu.action?fid=${student.FId }">删除</a>
					</td>
				</tr>
				</c:forEach>
			</table>
			</form>
			<table width="40%">
				<tr>
					<td>
						<div align="center">
							<a href="orgStuPrevious.action">上一页</a>
						</div>
					</td>
					<td>
						<div align="center">
							<a href="orgStuNext.action">下一页</a>
						</div>
					</td>
					<td>
						共${studentAll.pageCount }页，当前第${studentAll.page+1 }页
					</td>
				</tr>
			</table>
		</div>
		<br>
		<br>
		<div align="center">
				<form action="excelInOrgStu.action" enctype="multipart/form-data" method="post">
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
