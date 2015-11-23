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
			提交作业
		</h3>
		<hr>
		<s:form action="student/HomeworkManage!addHomeworkInfoBefore.action" method="post" theme="simple">
		<table width="80%" border="0" align="center">
			<tr>
				<td align="left">
					提交过的作业信息:
				</td>
				<td align="right">
					<s:select name="FCourseNumber" listKey="FCourseNumber" listValue="FCourseName"
					             list="listCourseInfo" headerKey="" headerValue="==选择课程提交作业==">
				  </s:select>&nbsp;<s:submit value="提交"/>
				</td>
			</tr>
		</table>
		</s:form>
		<s:form action="" method="post" theme="simple">
		<table width="80%" border="0" id="mytable" align="center">
		    <tr>
	                <th align="center" colspan="8" background="<%=basePath%>3_jiaofu_system/pictures/jft.gif" height="30">
			           <font color="#FFFFFF">作业信息</font>
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
					时间
				</th>
				<th width=""  align="center">
					是否有回复
				</th>
				<th width=""  align="center">
					回复状态
				</th>
				<th width=""  align="center">
					作业详情
				</th>
				<th width=""  align="center">
					删除
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
						<s:date name="FHomeTime" format="yyyy年MM月dd日HH时mm分ss秒" />
					</td>
					<td align="center">
						<s:if test="FReply==null">
						   无回复
						</s:if>
						<s:else>
						  有回复
						</s:else>
					</td>
					<td align="center">
						<s:if test="FReply==null">
						  空(无回复)
						</s:if>
						<s:elseif test='FReplyRead=="N"'>
						  回复未读
						</s:elseif>
						<s:else>
						  回复已读
						</s:else>
					</td>
					<td align="center">
						<a href="student/HomeworkManage!findHomeworkDetailByID.action?FHomeId=<s:property value="FHomeId"/>">点击查看</a>
					</td>
					<td align="center">
						<a href="student/HomeworkManage!deleteHomeworkInfoByID.action?FHomeId=<s:property value="FHomeId"/>">点击删除</a>
					</td>
				</tr>
			</s:iterator>
			<s:if test="listHomeuploadInfo.size >0">
			<tr align="center">
				   <td colspan="8">
				       <a href='<s:url action="student/HomeworkManage!findHomeUploadInfo.action"> <s:param name="p" value="1"></s:param></s:url>'>首页</a>
				       <a href='<s:url action="student/HomeworkManage!findHomeUploadInfo.action"> <s:param name="p" value="%{p-1}"></s:param></s:url>'>上一页</a>
                       <a href='<s:url action="student/HomeworkManage!findHomeUploadInfo.action"> <s:param name="p" value="%{p+1}"></s:param></s:url>'>下一页</a>
                       <a href='<s:url action="student/HomeworkManage!findHomeUploadInfo.action"> <s:param name="p" value="lastPage"></s:param></s:url>'>最后</a>
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
		</s:form>
	</body>
</html>