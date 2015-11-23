<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
	<link href="<%=basePath%>css.css" rel="stylesheet" type="text/css" />
    <script language="javascript" src="<%=basePath%>js/TableColor.js"></script>
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
			平时成绩管理
		</h3>
		<hr>
		<br>
		<table width="80%" border="0" align="center">
			<tr>
				<td align="left">
				    <s:form action="assist/HomeworkManage!findUsualSelectInfo.action" method="post" theme="simple">
					<table width="80%" border="0" align="center">
					      查询平时成绩:
					   <s:select name="FCourseNumber" listKey="FCourseNumber" listValue="FCourseName"
					             list="listCourseInfo" headerKey="" headerValue="==点击课程查询平时成绩==">
				       </s:select>&nbsp;<s:submit value="查询"/>
					</table>
					</s:form>
				</td>
				<td align="right">
					<s:form action="assist/HomeworkManage!addUsualscoreInfo.action" method="post" theme="simple">
					<table width="80%" border="0" align="center">
					         添加平时成绩:
				        <s:select name="FCourseNumber" listKey="FCourseNumber" listValue="FCourseName"
					             list="listCourseInfo" headerKey="" headerValue="==点击课程添加平时成绩==">
				        </s:select>&nbsp;<s:submit value="添加"/>
					</table>
					</s:form>
				</td>
			</tr>
		</table>
		<table width="80%" border="0" id="mytable" align="center">
		    <tr>
	                <th align="center" colspan="9" background="<%=basePath%>3_jiaofu_system/pictures/jft.gif" height="30">
			           <font color="#FFFFFF"><s:property value="FMenuName" /> </font>
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
					学生学号
				</th>
				<th width=""  align="center">
					学生姓名
				</th>
				<th width=""  align="center">
					成绩得分
				</th>
				<th width=""  align="center">
					学期
				</th>
				<th width=""  align="center">
				          成绩类型
				</th>
				<th width=""  align="center">
				          删除
				</th>
			</tr>
			<s:iterator value="listUsualscoreInfo" status="status">
				<tr>
					<td align="center">
						<s:property value="#status.count" />
					</td>
					<td align="center">
						<s:property value="tabCourse.FCourseNumber"/>
					</td>
					<td align="center">
						<s:property value="tabCourse.FCourseName"/>
					</td>
					<td align="center">
						<s:property value="tabStudents.FStudentNumber"/>
					</td>
					<td align="center">
						<s:property value="tabStudents.FStudentName"/>
					</td>
					<td align="center">
						<s:property value="FScore"/>
					</td>
					<td align="center">
						<s:property value="FXueQi"/>
					</td>
					<td align="center">
						<s:property value="FType"/>
					</td>
					<td align="center">
						<a href="assist/HomeworkManage!deleteUsualscoreInfoByID.action?FNumber=<s:property value="FNumber"/>">点击删除</a>
					</td>
				</tr>
			</s:iterator>
			<s:if test="listUsualscoreInfo.size > 0">
			<tr align="center">
			   <td colspan="9">
			           <a href='<s:url action="assist/HomeworkManage!findUsualSelectInfo.action"> <s:param name="p" value="1"></s:param></s:url>'>首页</a>
				       <a href='<s:url action="assist/HomeworkManage!findUsualSelectInfo.action"> <s:param name="p" value="%{p-1}"></s:param></s:url>'>上一页</a>
                       <a href='<s:url action="assist/HomeworkManage!findUsualSelectInfo.action"> <s:param name="p" value="%{p+1}"></s:param></s:url>'>下一页</a>
                       <a href='<s:url action="assist/HomeworkManage!findUsualSelectInfo.action"> <s:param name="p" value="lastPage"></s:param></s:url>'>最后</a>
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
		<hr>
		<table width="80%" border="0" id="mytable" align="center">
		  <s:if test="listUsualscoreInfo.size > 0">
		     <tr align="center">
		        <td><a href="assist/HomeworkManage!updateStudentsScore.action">进行平时成绩汇总</a><img src="3_jiaofu_system/pictures/go.gif"></td>
		        <td><a href="assist/HomeworkManage!webChartBefore.action">查看平时成绩分布图</a><img src="3_jiaofu_system/pictures/go.gif"></td>
		     </tr>
		  </s:if>
		</table>
	</body>
</html>