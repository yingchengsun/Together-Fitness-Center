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
		<title></title>
		<style type="text/css">
<!--
body {
	background-image: url(<%=basePath%>images/Background.png)
}
-->
</style>
<link href="<%=basePath%>3_jiaofu_system/myjs/dialog.css" rel="stylesheet" type="text/css"></link>
<script language="javascript" src="<%=basePath%>3_jiaofu_system/myjs/jquery-latest.pack.js"></script>
<script language="javascript" src="<%=basePath%>3_jiaofu_system/myjs/dialog.js"></script>
	</head>

	<body>
		<br>
		<h3 align="center">
			本学期课程详细信息
		</h3>
		<hr>
		<br>
		<table width="80%" border="0" id="mytable" align="center">
		    <tr>
	                <th align="center" colspan="7" background="<%=basePath%>3_jiaofu_system/pictures/jft.gif" height="30">
			           <font color="#FFFFFF">课程信息</font>
	                </th>
	            </tr>
			<tr>
				<th width=""  align="center">
					序号
				</th>
				<th width=""  align="center">
					课程编号
				</th>
				<th width=""  align="center">
					课程名称
				</th>
				<th width=""  align="center">
					学分
				</th>
				<th width=""  align="center">
					学时
				</th>
				<th width=""  align="center">
					备注
				</th>
				<th width=""  align="center">
					班级方向
				</th>
			</tr>
			<s:iterator value="listCourseInfo" status="status">
				<tr>
					<td align="center">
						<s:property value="#status.count" />
					</td>
					<td align="center">
						<s:property value="FCourseNumber" />
					</td>
					<td align="center">
						<s:property value="FCourseName" />
					</td>
					<td align="center">
						<s:property value="FCourseScore" />
					</td>
					<td align="center">
						<s:property value="FCourseXueShi" />
					</td>
					<td align="center">
						<s:property value="FRemark" />
					</td>
					<td align="center">                                                                              
					    <a class="LINK21" href="#" onclick='dialog(&quot;班级方向信息&quot;,&quot;url:get?<%=basePath%>assist/CourseManage!seeCourseDetail.action?FCourseNumber=<s:property value="FCourseNumber" />&quot;,&quot;370px&quot;,&quot;auto&quot;,&quot;id&quot;); '>查看详细</a>
					</td>
				</tr>
			</s:iterator>
			<s:if test="listCourseInfo.size >0">
			<tr align="center">
			   <td colspan="7">
			           <a href='<s:url action="assist/CourseManage!findCourseInfo.action"> <s:param name="p" value="1"></s:param></s:url>'>首页</a>
				       <a href='<s:url action="assist/CourseManage!findCourseInfo.action"> <s:param name="p" value="%{p-1}"></s:param></s:url>'>上一页</a>
                       <a href='<s:url action="assist/CourseManage!findCourseInfo.action"> <s:param name="p" value="%{p+1}"></s:param></s:url>'>下一页</a>
                       <a href='<s:url action="assist/CourseManage!findCourseInfo.action"> <s:param name="p" value="lastPage"></s:param></s:url>'>最后</a>
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