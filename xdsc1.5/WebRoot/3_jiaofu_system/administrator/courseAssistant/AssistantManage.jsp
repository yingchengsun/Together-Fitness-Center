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
			助教权限申请信息
		</h3>
		<hr>
		<br>
		<s:form name="f" action="" method="post">
			<table width="80%" border="0" id="mytable" align="center">
			    <tr>
	                <th align="center" colspan="8" background="<%=basePath%>3_jiaofu_system/pictures/jft.gif" height="30">
			           <font color="#FFFFFF">申请信息</font>
	                </th>
	            </tr>
				<tr>
					<th width=""  align="center">
						序号
					</th>
					<th width=""  align="center">
						教师编号
					</th>
					<th width=""  align="center">
						教师姓名
					</th>
					<th width=""  align="center">
						课程编号
					</th>
					<th width=""  align="center">
						课程名称
					</th>
					<th width=""  align="center">
						助教编号
					</th>
					<th width=""  align="center">
						申请描述
					</th>
					<th width=""  align="center">
						管理员操作
					</th>
				</tr>
				<s:iterator value="listAssistantapplyInfo" status="status">
					<tr>
						<td align="center">
							<s:property value="#status.count" />
						</td>
						<td align="center">
							<s:property value="tabTeachers.FTeacherNumber" />
						</td>
						<td align="center">
							<s:property value="tabTeachers.FTeacherName" />
						</td>
						<td align="center">
							<s:property value="tabCourse.FCourseNumber" />
						</td>
						<td align="center">
							<s:property value="tabCourse.FCourseName" />
						</td>
						<td align="center">
							<s:property value="FAssistantId" />
						</td>
						<td align="center">
							<s:if test='FShenQing == "Y"'>
							申请中...
							</s:if>
							<s:elseif test='FShenQing == "C"'>
							取消中...
							</s:elseif>
						</td>
						<td align="center">
							<input type="button" value="同意" onclick="javascript:document.f.action='administrator/AssistantInfo!updateApplyInfoByID.action?FId=<s:property value="FId"/>';document.f.submit();" />&nbsp;
                            <input type="button" value="拒绝" onclick="javascript:document.f.action='administrator/AssistantInfo!deleteApplyInfoByID.action?FId=<s:property value="FId"/>';document.f.submit();" />
						</td>
					</tr>
				</s:iterator>
				<s:if test="listAssistantapplyInfo.size >0">
				<tr align="center">
				    <td colspan="8">
				       <a href='<s:url action="administrator/AssistantInfo!findAssistantapplyInfo.action"> <s:param name="p" value="1"></s:param></s:url>'>首页</a>
				       <a href='<s:url action="administrator/AssistantInfo!findAssistantapplyInfo.action"> <s:param name="p" value="%{p-1}"></s:param></s:url>'>上一页</a>
                       <a href='<s:url action="administrator/AssistantInfo!findAssistantapplyInfo.action"> <s:param name="p" value="%{p+1}"></s:param></s:url>'>下一页</a>
                       <a href='<s:url action="administrator/AssistantInfo!findAssistantapplyInfo.action"> <s:param name="p" value="lastPage"></s:param></s:url>'>最后</a>
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