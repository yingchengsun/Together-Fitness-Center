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
		<title>个人安排</title>
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
			个人记事本
		</h3>
		<hr>
		<div align="center">
			<table width="80%" border="0">
				<tr>
					<td align="right"><a href="3_jiaofu_system/teacher/teachingManage/OwnArrangementAdd.jsp">添加</a></td>
				</tr>
			</table>
			<br>
			<table width="80%" border="0" id="mytable">
				<tr>
	                <th align="center" colspan="4" background="<%=basePath%>3_jiaofu_system/pictures/jft.gif" height="30">
			           <font color="#FFFFFF">自我安排</font>
	                </th>
	            </tr>
				<tr>
					<th width="20%"  align="center">序号</th>
					<th width="30%"  align="center">记事标题</th>
					<th width="30%"  align="center">发表时间</th>
					<th width="20%"  align="center">删除</th>
				</tr>
				<s:iterator value="listInfo" status="status">
				   <tr>
				     <td align="center"><s:property value="#status.count"/></td>
				     <td align="center">
				            <a href="teacher/OwnArrangeInfo!findInfoDetailByID.action?FId=<s:property value="FId"/>">
				                <s:property value="FTitle"/> 
				            </a>
				     </td>
				     <td align="center"><s:date name="FDataTime" format="yyyy年MM月dd日HH时mm分ss秒" /></td>
				     <td align="center"><a href="teacher/OwnArrangeInfo!deleteInfoByID.action?FId=<s:property value="FId"/>">删除</a></td>
				   </tr>
				</s:iterator>
				<s:if test="listInfo.size >0">
				<tr align="center">
				   <td colspan="4">
				       <a href='<s:url action="teacher/OwnArrangeInfo!findAllInfo.action"> <s:param name="p" value="1"></s:param></s:url>'>首页</a>
				       <a href='<s:url action="teacher/OwnArrangeInfo!findAllInfo.action"> <s:param name="p" value="%{p-1}"></s:param></s:url>'>上一页</a>
                       <a href='<s:url action="teacher/OwnArrangeInfo!findAllInfo.action"> <s:param name="p" value="%{p+1}"></s:param></s:url>'>下一页</a>
                       <a href='<s:url action="teacher/OwnArrangeInfo!findAllInfo.action"> <s:param name="p" value="lastPage"></s:param></s:url>'>最后</a>
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
		</div>
	</body>
</html>



