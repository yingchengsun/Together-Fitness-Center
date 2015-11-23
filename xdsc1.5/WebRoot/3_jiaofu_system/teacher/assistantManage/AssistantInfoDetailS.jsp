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
			助教信息
		</h3>
		<hr>
		<br>
		<table width="40%" border="0" id="mytable" align="center">
		    <tr>
	                <th align="center" colspan="2" background="<%=basePath%>3_jiaofu_system/pictures/jft.gif" height="30">
			           <font color="#FFFFFF">助教信息(学生)</font>
	                </th>
	            </tr>
			<tr>
				<td align="center">
					助教编号
				</td>
				<td align="center">
				    <s:property value="tabStudents.FStudentNumber" />
				</td>
		    </tr>
		    <tr>
				<td align="center">
					助教姓名
				</td>
				<td align="center">
				    <s:property value="tabStudents.FStudentName" />
				</td>
		    </tr>
		    <tr>
				<td align="center">
					性别
				</td>
				<td align="center">
						<s:if test="tabStudents.FStudentSex==null">
					                    未填写信息
					    </s:if>
						<s:else>
							<s:property value="tabStudents.FStudentSex" />
						</s:else>
				</td>
			</tr>
			<tr>
				<td align="center">
					班级
				</td>
				<td align="center">
					<s:if test="tabStudents.tabClasses.FClassNumber==null">
					     未填写信息     
					</s:if>
				    <s:else>
					  <s:property value="tabStudents.tabClasses.FClassNumber" />
					</s:else>
				</td>
			</tr>
			<tr>
				<td align="center">
					电话
				</td>
				<td align="center">
					<s:if test="tabStudents.FStudentTel==null">
					     未填写信息     
					</s:if>
				    <s:else>
					  <s:property value="tabStudents.FStudentTel" />
					</s:else>
				</td>
			</tr>
			<tr>
				<td align="center">
					邮箱
				</td>
				<td align="center">
					<s:if test="tabStudents.FStudentEmail==null">
					     未填写信息     
					</s:if>
				    <s:else>
					  <s:property value="tabStudents.FStudentEmail" />
					</s:else>
				</td>
			</tr>
			<tr>
				<td align="center">
					专业方向
				</td>
				<td align="center">
					<s:if test="tabStudents.FStudentMajor==null">
					     未填写信息     
					</s:if>
				    <s:else>
					  <s:property value="tabStudents.FStudentMajor" />
					</s:else>
				</td>
			</tr>
			<tr>
			    <td colspan="2" align="center">
                   <input type="button" value="返回" onClick="javascript:window.history.go(-1)"/>
                </td>
			</tr>
		</table>
	</body>
</html>