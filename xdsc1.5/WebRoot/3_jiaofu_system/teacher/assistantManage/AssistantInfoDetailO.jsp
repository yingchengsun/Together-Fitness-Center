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
			           <font color="#FFFFFF">助教信息(院外)</font>
	                </th>
	            </tr>
			<tr>
				<td align="center">
					助教编号
				</td>
				<td align="center">
				    <s:property value="jfptTabOtherassist.FAssistantId" />
				</td>
		    </tr>
		    <tr>
				<td align="center">
					助教姓名
				</td>
				<td align="center">
				    <s:property value="jfptTabOtherassist.FName" />
				</td>
		    </tr>
		    <tr>
				<td align="center">
					性别
				</td>
				<td align="center">
						<s:if test="jfptTabOtherassist.FSex==null">
					                    未填写信息
					    </s:if>
						<s:else>
							<s:property value="jfptTabOtherassist.FSex" />
						</s:else>
				</td>
			</tr>
			<tr>
				<td align="center">
					年龄
				</td>
				<td align="center">
					<s:if test="jfptTabOtherassist.FAge==null">
					     未填写信息     
					</s:if>
					<s:else>
					   <s:property value="jfptTabOtherassist.FAge" />
					</s:else>
				</td>
			</tr>
			<tr>
				<td align="center">
					电话
				</td>
				<td align="center">
					<s:if test="jfptTabOtherassist.FTelephone==null">
					     未填写信息     
					</s:if>
					<s:else>
					  <s:property value="jfptTabOtherassist.FTelephone" />
					</s:else>
				</td>
			</tr>
			<tr>
				<td align="center">
					邮箱
				</td>
				<td align="center">
					<s:if test="jfptTabOtherassist.FEmailAddress==null">
					     未填写信息     
					</s:if>
					<s:else>
					  <s:property value="jfptTabOtherassist.FEmailAddress" />
					</s:else>
				</td>
			</tr>
			<tr>
				<td align="center">
					备注
				</td>
				<td align="center">
					<s:if test="jfptTabOtherassist.FBeizhu==null">
					     未填写信息     
					</s:if>
				    <s:else>
					  <s:property value="jfptTabOtherassist.FBeizhu" />
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