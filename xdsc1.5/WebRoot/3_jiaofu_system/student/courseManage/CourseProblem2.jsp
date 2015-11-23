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
			课程答疑信息列表
		</h3>
		<hr>
		<s:form action="student/CourseManage!selectQuestionReplyInfo.action" method="post" theme="simple">
		<table width="80%" border="0" align="center">
			<tr>
				<td align="left">
					课程答疑列表:
				</td>
				<td align="centet">
				请选择:<s:select name="FCourseNumber" listKey="FCourseNumber" listValue="FCourseName"
					             list="listCourseInfo" headerKey="" headerValue="====请选择====">
				  </s:select>&nbsp;<s:submit value="提交"/>
				</td>
				<td align="right">
				  <a href="student/CourseManage!addInfoBeforeAsk.action">进行新提问</a>
				</td>
			</tr>
		</table>
		</s:form>
		<s:iterator value="listCourseaskquestionInfo" status="status">
			<table width="80%" border="1" align="center" style="border-collapse: collapse">
			     <tr bgcolor="#d0d0d0">
	                <td align="center" colspan="3">
			                               课程问题
	                </td>
	            </tr>
				<tr>
					<td align="left">
						发起人姓名：<s:property value="tabStudents.FStudentName" />
					</td>
					<td align="right">
						时间：<s:date name="FDateTime" format="yyyy年MM月dd日HH时mm分ss秒" />
					</td>
				</tr>
				<tr>
					<td align="left">
						询问问题：
					</td>
					<td align="left">
						<s:property value="FContents"/>
					</td>
				</tr>
				<tr>
				   <td colspan="2" align="center"> 
				        <a href="student/CourseManage!findProblemDetailByID.action?FQuestionId=<s:property value="FQuestionId"/>">点击查看详情</a>
				   </td>
				</tr>
			</table>
			<br>
		</s:iterator>
		<hr>
		<s:if test="listCourseaskquestionInfo.size > 0">
		<table width="80%" border="0" id="mytable" align="center">
		    <tr align="center">
		       <td>
		               <a href='<s:url action="student/CourseManage!selectQuestionReplyInfo.action"> <s:param name="p" value="1"></s:param></s:url>'>首页</a>
				       <a href='<s:url action="student/CourseManage!selectQuestionReplyInfo.action"> <s:param name="p" value="%{p-1}"></s:param></s:url>'>上一页</a>
                       <a href='<s:url action="student/CourseManage!selectQuestionReplyInfo.action"> <s:param name="p" value="%{p+1}"></s:param></s:url>'>下一页</a>
                       <a href='<s:url action="student/CourseManage!selectQuestionReplyInfo.action"> <s:param name="p" value="lastPage"></s:param></s:url>'>最后</a>
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
		</s:if>
	</body>
</html>