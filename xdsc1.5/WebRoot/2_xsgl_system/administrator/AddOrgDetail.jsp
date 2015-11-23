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
		<h3 align="center">详细信息</h3>
		<hr>
		<div align="center">
		 <form action="<%=request.getContextPath()%>/saveOrganization.action"
			method="post">
				<table border="1" width="700">
					<tr>
						<th height="30" colspan="2" align="center" background="<%=request.getContextPath() %>/2_xsgl_system/Pictures/newmenubg.gif">
							<font color="#FFFFFF">编辑信息</font>
						</th>
					</tr>
					<tr>
						<td>
							组织编号：
						</td>
						<td>
							<input type="text" name="FOid">
						</td>
					</tr>
					
					<tr>
						<td>
							组织名称：
						</td>
						<td>
							<input type="text" name="FOname">
						</td>
					</tr>
					<tr>
						<td>
							成立时间：
						</td>
						<td>
							<input readonly="readonly" type="text" name="FBuildTime" 
								onClick="WdatePicker()" size="12" />
						</td>
					</tr>
					<tr>
						<td>
							成员人数：
						</td>
						<td>
							<input type="text" name="FTotal">
						</td>
					</tr>
					<tr>
					<td>
						&nbsp;&nbsp;
					</td>
					<td>
						<input type="submit" value="提交">&nbsp;&nbsp;<input type="reset" value="重置">
					</td>
				</tr>
				</table>
				</form>
		   </div>
		<br>
  </body>
</html>
