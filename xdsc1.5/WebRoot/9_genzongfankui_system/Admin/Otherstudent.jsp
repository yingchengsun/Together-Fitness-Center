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
	    <title>其他去向学生信息</title>
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
			<img src="<%=basePath%>Pictures/Aluminum_001.png" align="top" border="0" width="50" height="50"/>其他去向学生信息编辑
		</h3>
			<br>
      <hr>
		<s:form action="admin/OtherInfo!findOtherInfoByName.action" method="post" theme="simple">
				<table width="40%" border="0" align="center">
					<tr>
						<td align="left">
							<img src="<%=basePath%>Pictures/search.gif" align="top" border="0"/>按学生姓名查询:
							<s:textfield name="FOtherNameSelect" />
							&nbsp;
							<s:submit value="提交" />
						</td>
						
					</tr>
				</table>
			</s:form>
		<table width="80%" border="0" align="center">
		<tr>
				<th align="right"><a href="9_genzongfankui_system/Admin/addOther.jsp"  >
				<img src="<%=basePath%>Pictures/edit.gif" align="top" border="0"/>添加其他去向学生信息</a></th>
			</tr>
					
				</table>
		<hr>
		<div align="center">
			<table border="0" width="700" id="mytable">
				<tr>
					<th colspan="11" background="<%=basePath%>Pictures/newmenubg.gif" height="30">
						<font color="#FFFFFF">其他去向学生</font>
					</th>
				</tr>
				<tr>
				<th>
						序号
					</th>
					<th>
						姓名
					</th>
					<th>
						学号
					</th>
					<th>
						毕业记录
					</th>
					<th>
						Email
					</th>
					<th>
						去向变更
					</th>
					<th>
						修改
					</th>
					<th>
						删除
					</th>
					
				</tr>
				<s:iterator value="listOtherInfo" status="status">
				   <tr>
				     <th align="center"><s:property value="#status.count"/></th>
				     <th align="center"><s:property value="TabStudents.FStudentName"/></th>
				     <th align="center"><s:property value="TabStudents.FStudentNumber"/></th>
				     <th align="center"><s:property value="FRecord"/></th>
				     <th align="center"><s:property value="FEmail"/></th>
				     <th align="center"><s:property value="FWorkAdd"/></th>
				     
				     <td align="center">
				        <a href="admin/OtherInfo!findOtherInfoByID.action?FOtherId=<s:property value="FOtherId"/>">
				         <img src="<%=basePath%>Pictures/edit_profile.gif" align="middle" border="0">
				        </a>
				     </td>
				     <td align="center">
				        <a href="admin/OtherInfo!deleteOtherInfoByID.action?FOtherId=<s:property value="FOtherId"/>">
				          <img src="<%=basePath%>Pictures/Del1.png" align="middle" border="0">
				        </a>
				     </td>
				   </tr>  
			</s:iterator>
			</table>
		</div>
		<br>
		<table width="40%" align="center">
  	<tr>
		<td><div align="center"><a href="<%=basePath %>admin/OtherInfo!findAllOtherInfo.action?p=1" >首页</a></div></td>
		<td><div align="center"><a href="<%=basePath %>admin/OtherInfo!findAllOtherInfo.action?p=${p-1}" >上一页</a></div></td>
		<td><div align="center"><a href="<%=basePath %>admin/OtherInfo!findAllOtherInfo.action?p=${p+1}" >下一页</a></div></td>
		<td><div align="center"><a href="<%=basePath %>admin/OtherInfo!findAllOtherInfo.action?p=${lastPage}" >末页</a></div></td>
	</tr>
  </table>
		<br>
		<br>
	</body>
</html>
