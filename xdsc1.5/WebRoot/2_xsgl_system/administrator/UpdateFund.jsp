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
		<h3 align="center">详细信息</h3>
		<hr>
		<div align="center">
		 <form action="<%=request.getContextPath()%>/updateFund.action"
			method="post">
				<table border="1" width="700">
					<tr>
						<th height="30" colspan="2" align="center" background="<%=request.getContextPath() %>/2_xsgl_system/Pictures/newmenubg.gif">
							<font color="#FFFFFF">编辑信息</font>
						</th>
					</tr>
					<tr>
						<td>
							班级：
							<input type="hidden" name="fundID" value="${fund.FId }">
						</td>
						<td>
							<input type="text" name="FClassNumber"
							value="${fund.tabClasses.FClassNumber }">
						</td>
					</tr>
					<tr>
						<td>
							类别名称：
						</td>
						<td>
							<input type="text" name="FName"
							value="${fund.FName }">
						</td>
					</tr>
					<tr>
						<td>
							总人数：
						</td>
						<td>
							<input type="text" name="FTotalNum"
							value="${fund.FTotalNum }">
						</td>
					</tr>
					<tr>
						<td>
							总金额：
						</td>
						<td>
							<input type="text" name="FAmount"
							value="${fund.FAmount  }">
						</td>
					</tr>
					<tr>
						<td>
							年份：
						</td>
						<td>
							<input type="text" name="FYear"
							value="${fund.FYear  }">
						</td>
					</tr>
					
				<tr>
					<td>
						&nbsp;
					</td>
					<td>
						<input type="submit" value="更新">&nbsp;&nbsp;<input type="reset" value="重置">
					</td>
				</tr>
				</table>
				</form>
		   </div>
		<br>
  </body>
</html>
