<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css.css">
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/2_xsgl_system/mycss.css">
		<script language="javascript" src="<%=request.getContextPath() %>/2_xsgl_system/JS/TableColor.js"></script>
	    <script language="javascript"
			src="<%=request.getContextPath()%>/2_xsgl_system/JS/My97DatePicker/WdatePicker.js"></script>
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
				<th align="right"><a href="<%=request.getContextPath() %>/2_xsgl_system/administrator/AddOrgDetail.jsp">
				<img src="<%=request.getContextPath() %>/2_xsgl_system/Pictures/return.gif" align="top" border="0"/>添加</a></th>
			</tr>
		</table>
		<div align="center">
		<form action="getOrgStudentList.action">
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
						成立时间
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
				<c:forEach items="${organizationList }" var="organization">
				<tr>
					<td>
						${organization.FOid }
					</td>
					<td>${organization.FOname }
					</td>	
					<td>
						<fmt:formatDate value="${organization.FBuildTime }" type="date" pattern="yyyy-MM-dd"/>
					</td>
					<td>${organization.FTotal }
					</td>
					<td>
						<a href="<%=request.getContextPath() %>/preUpdateOrganization.action?oid=${organization.FOid }">更新</a>
					</td>
					<td>
						<a href="<%=request.getContextPath() %>/deleteOrganization.action?oid=${organization.FOid }">删除</a>
					</td>
				</tr>
				</c:forEach>
			</table>
			</form>
		</div>
		<br>
		<br>
		<div align="center">
				<form action="excelInOrg.action" enctype="multipart/form-data" method="post">
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
