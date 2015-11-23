<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>班级</title>
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
		<br>
		<h3 align="center">
			<img src="<%=basePath%>Pictures/Aluminum_001.png" align="top" border="0" width="50" height="50"/>班级统计信息编辑
		</h3>
		<hr>
		<s:form action="admin/ClassInfo!findClassoneByNum.action" method="post" theme="simple">
				<table width="40%" border="0"  align="center">
					<tr align="center">
						<td align="left"><img src="<%=basePath%>Pictures/search.gif" align="top" border="0"/>
							查询班级:
							<s:textfield name="FClassNumSelect" />
							&nbsp;
							<s:submit value="提交" />
						</td>
						
					</tr>
				</table>
			</s:form>
			<s:form action="admin/ClassInfo!findGradeByNum.action" method="post" theme="simple">
				<table width="40%" border="0" align="center">
					<tr>
						<td align="left"><img src="<%=basePath%>Pictures/search.gif" align="top" border="0"/>
							查询年级:
							<s:textfield name="FGradeNumSelect" />
							&nbsp;
							<s:submit value="提交" />例如06级：输入1306
						</td>
						
					</tr>
				</table>
			</s:form>
			<table width="80%" border="0" align="center">
					<tr>
				<th align="right"><a href="9_genzongfankui_system/Admin/addClassInfo.jsp"  ><img src="<%=basePath%>Pictures/edit.gif" align="top" border="0"/>添加班级信息</a></th>
			</tr>
					
				</table>
		<hr>
		<div align="center">
		
			<table border="0" id="mytable" width="700">
				<tr>
					<th align="center" colspan="13" background="<%=basePath%>Pictures/newmenubg.gif" height="30">
						<font color="#FFFFFF">软件学院班级统计信息</font>
					</th>
				</tr>
				<tr>
				<th>
						序号
					</th>
					<th>
						班级
					</th>
					<th>
						总人数
					</th>
					<th>
						男生人数
					</th>
					<th>
						女生人数
					</th>
					
					<th>
						就业人数
					</th>
					<th>
						上研人数
					</th>
					<th>
						出国人数
					</th>
					<th>
						其他人数
					</th>
					<th>
						花名册
					</th>
					<th>
						修改
					</th>
					<th>
						删除
					</th>

				</tr>
							  
				     <s:iterator value="listClassInfo" status="status">
				   <tr>
				     <td align="center"><s:property value="#status.count"/></td>
				     <td align="center"><s:property value="FClassNumber"/></td>
				     <td align="center"><s:property value="FClassTotalNum"/></td>
				     <td align="center"><s:property value="FClassMaleNum"/></td>
				     <td align="center"><s:property value="FClassFemaleNum"/></td>

				     <td align="center"><s:property value="FClassWorkNum"/></td>
				     <td align="center"><s:property value="FClassKaoYanNum"/></td>
				     <td align="center"><s:property value="FClassAbroadNum"/></td>
				     <td align="center"><s:property value="FClassOtherNum"/></td>
				     <td><a href="admin/StudentInfo!findStudentByClass.action?FClassNumSelect=<s:property value="FClassNumber"/>">
				     <img src="<%=basePath%>Pictures/userinfo.gif" align="middle" border="0"> </a></td>		     
					 <td align="center">
				        <a href="admin/ClassInfo!findClassByNum.action?FClassNumSelect=<s:property value="FClassNumber"/>">
				        <img src="<%=basePath%>Pictures/edit_profile.gif" align="middle" border="0"></a>
				     </td>
				    
				     <td align="center">
				        <a href="admin/ClassInfo!delClassByNum.action?FClassNumber=<s:property value="FClassNumber"/>">
				        <img src="<%=basePath%>Pictures/Del1.png" align="middle" border="0"></a>
				     </td> 
				   </tr>
			
			</s:iterator>
				
			</table>
	
			<br>
		</div>

					<table width="40%" align="center">
  	<tr>
		<td><div align="center"><a href="<%=basePath %>admin/ClassInfo!findAllClassInfo.action?p=1" >首页</a></div></td>
		<td><div align="center"><a href="<%=basePath %>admin/ClassInfo!findAllClassInfo.action?p=${p-1}" >上一页</a></div></td>
		<td><div align="center"><a href="<%=basePath %>admin/ClassInfo!findAllClassInfo.action?p=${p+1}" >下一页</a></div></td>
		<td><div align="center"><a href="<%=basePath %>admin/ClassInfo!findAllClassInfo.action?p=${lastPage}" >末页</a></div></td>
	</tr>
  </table>
	</body>
</html>
