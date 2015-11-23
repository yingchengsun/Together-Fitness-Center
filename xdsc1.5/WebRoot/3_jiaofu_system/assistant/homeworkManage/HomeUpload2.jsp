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
			批改作业
		</h3>
		<hr>
		<s:form action="assist/HomeworkManage!findSelectHomeworkInfo.action" method="post" theme="simple">
		<table width="80%" border="0" align="center">
			<tr>
				<td align="left">
					作业信息列表:
				</td>
				<td align="right">
					<s:select name="FCourseNumber" listKey="FCourseNumber" listValue="FCourseName"
					             list="listCourseInfo" headerKey="" headerValue="==选择相关课程作业==">
				  </s:select>&nbsp;<s:submit value="提交"/>
				</td>
			</tr>
		</table>
		</s:form>
		<s:form action="" method="post" theme="simple">
		<table width="80%" border="0" id="mytable" align="center">
		    <tr>
	                <th align="center" colspan="7" background="<%=basePath%>3_jiaofu_system/pictures/jft.gif" height="30">
			           <font color="#FFFFFF">批改作业</font>
	                </th>
	            </tr>
			<tr>
				<th width=""  align="center">
					序号
				</th>
				<th width=""  align="center">
					课程名称
				</th>
				<th width=""  align="center">
					标题
				</th>
				<th width=""  align="center">
					学号
				</th>
				<th width=""  align="center">
					时间
				</th>
				<th width=""  align="center">
					作业状态
				</th>
				<th width=""  align="center">
					作业详情
				</th>
			</tr>
			<s:iterator value="listHomeuploadInfo" status="status">
				<tr>
					<td align="center">
						<s:property value="#status.count" />
					</td>
					<td align="center">
						<s:property value="tabCourse.FCourseName" />
					</td>
					<td align="center">
						<s:property value="FHomeTitle" />
					</td>
					<td align="center">
						<s:property value="tabStudents.FStudentNumber" />
					</td>
					<td align="center">
						<s:date name="FHomeTime" format="yyyy年MM月dd日HH时mm分ss秒" />
					</td>
					<td align="center">
						<s:if test='FRead=="N"'>
						  未批阅
						</s:if>
						<s:else>
						 已批阅
						</s:else>
						<s:property value="FRead" />
					</td>
					<td align="center">
						<a href="assist/HomeworkManage!findHomeworkDetailByID.action?FHomeId=<s:property value="FHomeId"/>">点击查看</a>
					</td>
				</tr>
			</s:iterator>
			<tr align="center">
			   <td colspan="7">
			           <a href='<s:url action="assist/HomeworkManage!findSelectHomeworkInfo.action"> <s:param name="p" value="1"></s:param></s:url>'>首页</a>
				       <a href='<s:url action="assist/HomeworkManage!findSelectHomeworkInfo.action"> <s:param name="p" value="%{p-1}"></s:param></s:url>'>上一页</a>
                       <a href='<s:url action="assist/HomeworkManage!findSelectHomeworkInfo.action"> <s:param name="p" value="%{p+1}"></s:param></s:url>'>下一页</a>
                       <a href='<s:url action="assist/HomeworkManage!findSelectHomeworkInfo.action"> <s:param name="p" value="lastPage"></s:param></s:url>'>最后</a>
				                  共<s:property value="lastPage"/>页,当前第
				             <s:if test='lastPage==0'>
				               0页
				             </s:if>
				             <s:else>
				               <s:property value="p"/>页
				             </s:else>
			   </td>
			</tr>
		</table>
		</s:form>
	</body>
</html>