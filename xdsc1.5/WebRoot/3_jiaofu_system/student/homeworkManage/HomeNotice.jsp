<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
			作业通知信息
		</h3>
		<hr>
		<br>
		<table width="80%" border="0" id="mytable" align="center">
		    <tr>
	                <th align="center" colspan="7" background="<%=basePath%>3_jiaofu_system/pictures/jft.gif" height="30">
			           <font color="#FFFFFF">通知信息</font>
	                </th>
	            </tr>
			<tr>
				<th width=""  align="center">
					序号
				</th>
				<th width=""  align="center">
					相关课程
				</th>
				<th width=""  align="center">
					标题
				</th>
				<th width=""  align="center">
					时间
				</th>
				<th width=""  align="center">
					通知状态
				</th>
				<th width=""  align="center">
					查看详情
				</th>
				<th width=""  align="center">
					删除
				</th>
			</tr>
			<s:iterator value="listHomenoticetoreceiveInfo" status="status">
				<tr>
					<td align="center">
						<s:property value="#status.count" />
					</td>
					<td align="center">
						<s:property value="jfptTabHomenotice.tabCourse.FCourseName" />
					</td>
					<td align="center">
						<s:property value="jfptTabHomenotice.FTitle" />
					</td>
					<td align="center">
						<s:date name="jfptTabHomenotice.FDate" format="yyyy年MM月dd日HH时mm分ss秒" />
					</td>
					<td align="center">
						<s:if test='FMarkable=="N"'>
						 未读
						</s:if>
						<s:else>
						 已读
						</s:else>
					</td>
					<td align="center">
						<a href="student/HomeworkManage!findHomeDetailByID.action?FHomeNoticeId=<s:property value="jfptTabHomenotice.FHomeNoticeId"/>&FNumber=<s:property value="FNumber"/>">点击查看</a>
					</td>
					<td align="center">
						<a href="student/HomeworkManage!deleteHomeByID.action?FNumber=<s:property value="FNumber"/>">点击删除</a> 
					</td>
				</tr>
			</s:iterator>
			<s:if test="listHomenoticetoreceiveInfo.size >0">
			<tr align="center">
			  <td colspan="7">
			           <a href='<s:url action="student/HomeworkManage!findHomeNoticeInfo.action"> <s:param name="p" value="1"></s:param></s:url>'>首页</a>
				       <a href='<s:url action="student/HomeworkManage!findHomeNoticeInfo.action"> <s:param name="p" value="%{p-1}"></s:param></s:url>'>上一页</a>
                       <a href='<s:url action="student/HomeworkManage!findHomeNoticeInfo.action"> <s:param name="p" value="%{p+1}"></s:param></s:url>'>下一页</a>
                       <a href='<s:url action="student/HomeworkManage!findHomeNoticeInfo.action"> <s:param name="p" value="lastPage"></s:param></s:url>'>最后</a>
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