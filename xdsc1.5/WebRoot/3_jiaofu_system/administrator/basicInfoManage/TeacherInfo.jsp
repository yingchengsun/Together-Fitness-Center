<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<link href="<%=basePath%>css.css" rel="stylesheet" type="text/css" />
<script language="javascript" src="<%=basePath%>js/TableColor.js"></script>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<title></title>
		<style type="text/css">
<!--
body {
	background-image: url(images/Background.png)
}
-->
</style>
	</head>

	<body>
		<br>
		<h3 align="center">
			教师个人信息
		</h3>
		<hr>
		<form action="administrator/excelIn3.action" enctype="multipart/form-data" method="post">
		<table width="80%" border="0" align="center">
			<tr>
				<td align="left">
					     导入<input type="file" name="file" />&nbsp;<input type="submit" value="导入" />
					     <img src="3_jiaofu_system/pictures/excel.bmp">文件格式要求为：序号、教师编号、教师姓名、账号状态(N:有效Y:无效)
				</td>
				<td align="right">
					<a href="3_jiaofu_system/administrator/basicInfoManage/TeacherInfoAdd.jsp">添加教师信息</a>
				</td>
			</tr>
		</table>
		</form>
		<br>
		<table width="80%" border="0" id="mytable" align="center">
		    <tr>
					<th align="center" colspan="6"
						background="<%=basePath%>3_jiaofu_system/pictures/jft.gif"
						height="30">
						<font color="#FFFFFF">教师信息</font>
					</th>
				</tr>
		    <!-- <tr>
		       <td width="%" bgcolor="3D99A5" align="center">序号</td>
		       <td width="%" bgcolor="3D99A5" align="center">教师编号</td>
		       <td width="%" bgcolor="3D99A5" align="center">教师姓名</td>
		       <td width="%" bgcolor="3D99A5" align="center">账号状态</td>
		       <td width="%" bgcolor="3D99A5" align="center">个人详情</td>
		       <td width="%" bgcolor="3D99A5" align="center">删除</td>
		    </tr> -->
		    <tr>
		       <th width="%"  align="center">序号</th>
		       <th width="%"  align="center">教师编号</th>
		       <th width="%"  align="center">教师姓名</th>
		       <th width="%"  align="center">账号状态</th>
		       <th width="%"  align="center">个人详情</th>
		       <th width="%"  align="center">删除</th>
		    </tr>
		    <s:iterator value="listTeacherInfo" status="status">
				<tr>
					<td align="center"><s:property value="#status.count" /></td>
					<td align="center"><s:property value="FTeacherNumber" /></td>
					<td align="center"><s:property value="FTeacherName" /></td>
					<td align="center">
					    <s:if test='FIsLocked=="Y"'>
					               账号被封
					    </s:if>
					    <s:else>
					               账号有效
					    </s:else>
					</td>
					<td align="center">
						<a href="administrator/BasicInfo!findTeacherInfoDetailByID.action?FTeacherNumber=<s:property value="FTeacherNumber" />">点击查看</a>
					</td>
					<td align="center">
						<a href="administrator/BasicInfo!deleteTeacherInfoByID.action?FTeacherNumber=<s:property value="FTeacherNumber" />">删除</a>
					</td>
				</tr>
			</s:iterator>
			<s:if test="listTeacherInfo.size >0">
            <tr align="center">
               <td colspan="6">
                       <a href='<s:url action="administrator/BasicInfo!findTeacherInfo.action"> <s:param name="p" value="1"></s:param></s:url>'>首页</a>
				       <a href='<s:url action="administrator/BasicInfo!findTeacherInfo.action"> <s:param name="p" value="%{p-1}"></s:param></s:url>'>上一页</a>
                       <a href='<s:url action="administrator/BasicInfo!findTeacherInfo.action"> <s:param name="p" value="%{p+1}"></s:param></s:url>'>下一页</a>
                       <a href='<s:url action="administrator/BasicInfo!findTeacherInfo.action"> <s:param name="p" value="lastPage"></s:param></s:url>'>最后</a>
				                  共<s:property value="lastPage"/>页,当前第
				             <s:if test='lastPage==0'>
				               0页
				             </s:if>
				             <s:else>
				               <s:property value="p"/>页
				             </s:else>
               </td>
            </tr>		
            </s:if>	
		</table>
	</body>
</html>
