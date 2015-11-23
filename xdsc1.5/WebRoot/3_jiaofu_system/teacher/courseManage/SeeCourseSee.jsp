<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title></title>
	</head>

	<body>
		<table width="80%" border="0" align="center">
		    <tr>
	           <th align="center" colspan="1" background="<%=basePath%>3_jiaofu_system/pictures/jft.gif" height="30">
			        <font color="#FFFFFF">代课信息</font>
	           </th>
	        </tr>
	        <tr align="center">
			  <td align="center">代课方向信息</td>
			</tr>
			<s:if test="listDirectionInfo.size > 0">
			   <tr>
			      <td bgcolor="#d0d0d0">
			         <s:iterator value="listDirectionInfo" status="status">
						<s:property value="FDirectionName"/>方向
						&nbsp;|&nbsp;
						<s:if test="#status.count % 3 ==0">
			       	       <br>
			       	   </s:if>
			        </s:iterator>
			      </td>
			   </tr>
			</s:if>
			<s:else>
			   <tr>
			      <td bgcolor="#d0d0d0">
			          无方向信息
			      </td>
			   </tr>
			</s:else>
			<tr align="center">
			  <td align="center">代课班级信息</td>
			</tr>
			<s:if test="listClassNumberInfo.size > 0">
			   <tr>
			      <td bgcolor="#d0d0d0">
			         <s:iterator value="listClassNumberInfo" status="status">
						<s:property />班
						&nbsp;|&nbsp;
						<s:if test="#status.count % 4 ==0">
			       	       <br>
			       	   </s:if>
			        </s:iterator>
			      </td>
			   </tr>
			</s:if>
			<s:else>
			 <tr>
			      <td bgcolor="#d0d0d0">
			         无班级信息
			      </td>
			   </tr>
			</s:else>
		</table>
	</body>
</html>