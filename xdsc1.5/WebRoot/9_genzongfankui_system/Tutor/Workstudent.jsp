<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
	    <title>就业学生信息</title>
		<base href="<%=basePath%>">
		<link rel="stylesheet" type="text/css" href="<%=basePath%>css.css">
		<link rel="stylesheet" type="text/css" href="<%=basePath%>mycss.css">
				<style type="text/css">
		body {
	font-family: arial, 宋体, serif;
	font-size:12px;
	background-image:url("<%=basePath%>Pictures/newbackground.png");
}
		.STYLE5 {
			font-family: "华文行楷";
			font-size: 14mm;
			color: #000000;
		}

		.STYLE6 {
			font-family: "隶书";
			font-size: 12mm;
			color: #000000;
			font-style: italic;
		}
		.STYLE7 {
			font-family: "隶书";
			font-size: 7mm;
			color: #000000;
		}
</style>
		<script language="javascript" src="<%=basePath%>js/TableColor.js"></script>
	</head>

	<body>
	<br>
		<h3 align="center">
			<img src="<%=basePath%>Pictures/Aluminum_001.png" align="top" border="0" width="50" height="50"/>就业学生信息
		</h3>
			<br>
      <hr>
		<s:form action="tutor/WorkInfo!findWorkInfoByName.action" method="post" theme="simple">
				<table width="40%" border="0" align="center">
					<tr>
						<td align="left">
							<img src="<%=basePath%>Pictures/search.gif" align="top" border="0"/>按学生姓名查询:
							<s:textfield name="FStuNameselect" />
							&nbsp;
							<s:submit value="提交" />
						</td>
						
						
					</tr>
				</table>
			</s:form>
			<s:form action="tutor/WorkInfo!findWorkInfoByCity.action" method="post" theme="simple">
				<table width="40%" border="0" align="center">
					<tr>
					
					<td align="left">
							<img src="<%=basePath%>Pictures/search.gif" align="top" border="0"/>按工作城市查询:
							<s:textfield name="FCityselect" />
							&nbsp;
							<s:submit value="提交" />
						</td>
						</tr>
				</table>
			</s:form>
		
		
		<hr>
		<div align="center">
			<table border="0" width="700" id="mytable">
				<tr>
					<th colspan="12" background="<%=basePath%>Pictures/newmenubg.gif" height="30">
						<font color="#FFFFFF">学生信息</font>
					</th>
				</tr>
				<tr>
				<th>
						序号
					</th>
					
					<th>
						学号
					</th>
					<th>
						姓名
					</th>
					<th>
						性别
					</th>
					<th>
						公司名称
					</th>
					<th>
						职位
					</th>
					
					
					<th>
						工作地点
					</th>
					<th>
						电子邮件
					</th>
					<th>
						工作变更
					</th>
				
				</tr>
				<s:iterator value="listWorkInfo" status="status">
				   <tr>
				     <th align="center"><s:property value="#status.count"/></th>

				     <th align="center"><s:property value="tabStudents.FStudentNumber"/></th>
				     <th align="center"><s:property value="tabStudents.FStudentName"/></th>
				     <th align="center"><s:property value="tabStudents.FStudentSex"/></th>
				     
				     <th align="center"><s:property value="tabCompany.FCompanyName"/></th>
				     <th align="center"><s:property value="FPosition"/></th>
				 
				     <th align="center"><s:property value="FWorkCity"/></th>
				     <th align="center"><s:property value="FEmail"/></th>
				     <th align="center"><s:property value="FWorkAdd"/></th>
				     
				   
				   </tr>  
			</s:iterator>
			</table>
		</div>
		<br>
		<table width="40%" align="center">
  	<tr>
		<td><div align="center"><a href="<%=basePath %>tutor/WorkInfo!findAllWorkInfo.action?p=1" >首页</a></div></td>
		<td><div align="center"><a href="<%=basePath %>tutor/WorkInfo!findAllWorkInfo.action?p=${p-1}" >上一页</a></div></td>
		<td><div align="center"><a href="<%=basePath %>tutor/WorkInfo!findAllWorkInfo.action?p=${p+1}" >下一页</a></div></td>
		<td><div align="center"><a href="<%=basePath %>tutor/WorkInfo!findAllWorkInfo.action?p=${lastPage}" >末页</a></div></td>
	</tr>
  </table>
		<br>
		<br>
	</body>
</html>
