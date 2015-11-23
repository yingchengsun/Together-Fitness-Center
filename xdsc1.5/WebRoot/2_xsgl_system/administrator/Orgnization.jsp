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
	<br>
		<h3 align="center">
			软件学院学生组织
		</h3>
		<hr>
		<table align="center" width="700">
			<tr>
			<th align="left"><a href="<%=request.getContextPath() %>/getOrganizationList.action">
				<img src="<%=request.getContextPath() %>/2_xsgl_system/Pictures/return.gif" align="top" border="0"/>各组织信息</a></th>
				<th align="center"><a href="<%=request.getContextPath() %>/getOrgStudentList.action">
				<img src="<%=request.getContextPath() %>/2_xsgl_system/Pictures/return.gif" align="top" border="0"/>各组织成员信息</a></th>
				<th align="right"><a href="<%=request.getContextPath() %>/2_xsgl_system/administrator/AddOrg.jsp">
				<img src="<%=request.getContextPath() %>/2_xsgl_system/Pictures/return.gif" align="top" border="0"/>添加</a></th>
			</tr>
		</table> 
		<div align="center">
		<form action="getDepartmentList.action">
			<table border="0" width="700" id="mytable">
				<tr>
					<th colspan="9" background="<%=request.getContextPath() %>/2_xsgl_system/Pictures/newmenubg.gif" height="30">
						<font color="#FFFFFF">软件学院学生组织信息列表</font>
					</th>
				</tr>
				<tr>
					<th>
						组织编号
					</th>
					<th>
						组织名称
					</th>
					<th>
						部门编号
					</th>
					<th>
						部门名称
					</th>
					<th>
						成员人数
					</th>
					<th> 
						修改 
					</th>
					<th>
						删除
					</th>
				</tr>
				<c:forEach items="${departmentList }" var="department">
				<tr>
					<td>
						${department.xsglTabOrganizations.FOid }
					</td>
					<td>
						${department.xsglTabOrganizations.FOname }
					</td>				
					<td>
						${department.FDid }
					</td>
					
					<td>${department.FDname }
					</td>
					<td>${department.FTotal }
					</td>
					<td>
						<a href="<%=request.getContextPath() %>/preUpdateDepartment.action?Did=${department.FDid }">更新</a>
					</td>
					<td>
						<a href="<%=request.getContextPath() %>/deleteDepartment.action?Did=${department.FDid }">删除</a>
					</td>
				</tr>
				</c:forEach>
			</table>
			</form>
			<table width="40%">
				<tr>
					<td>
						<div align="center">
							<a href="departmentPrevious.action">上一页</a>
						</div>
					</td>
					<td>
						<div align="center">
							<a href="departmentNext.action">下一页</a>
						</div>
					</td>
					<td>
						共${departmentAll.pageCount }页，当前第${departmentAll.page+1 }页
					</td>
				</tr>
			</table>
		</div>
		<br>
		<br>
		<div align="center">
				<form action="excelInDepartment.action" enctype="multipart/form-data" method="post">
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
								组织编号：1-学生会；2-科协；3-团委
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
