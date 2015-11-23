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
			课程助教
		</h3>
		<hr>
		<table width="80%" border="0" align="center">
			<tr>
				<td align="left">
					课程助教信息:
				</td>
				<td align="right">
					<a href="3_jiaofu_system/teacher/assistantManage/AssistantInfoAdd.jsp">申请课程助教</a>
				</td>
			</tr>
		</table>
		<s:form name="f" action="" method="post">
			<table width="80%" border="0" id="mytable" align="center">
			    <tr>
	                <th align="center" colspan="7" background="<%=basePath%>3_jiaofu_system/pictures/jft.gif" height="30">
			           <font color="#FFFFFF">课程助教信息</font>
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
						助教编号
					</th>
					<th width=""  align="center">
						助教状态
					</th>
					<th width=""  align="center">
						具体信息
					</th>
					<th width=""  align="center">
						申请取消
					</th>
				</tr>
				<s:iterator value="listAssistantapplyInfo" status="status">
					<tr>
						<td align="center">
							<s:property value="#status.count" />
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
							<s:if test='FShenQing=="Y"'>
						           申请中...
						    </s:if>
							<s:elseif test='FShenQing=="C"'>
						            取消中...
						    </s:elseif>
							<s:else>
						            在职助教
						    </s:else>
						</td>
						<td align="center">
							<a href="teacher/AssistantInfo!findAssistantDetailInfoByID.action?FAssistantId=<s:property value="FAssistantId"/>">点击查看</a>
						</td>
						<td align="center">
							<a href="teacher/AssistantInfo!deleteAssistantInfo.action?FId=<s:property value="FId"/>">取消助教</a>
						</td>
					</tr>
				</s:iterator>
				<s:if test="listAssistantapplyInfo.size >0">
				<tr align="center">
				   <td colspan="7">
				       <a href='<s:url action="teacher/AssistantInfo!findAssistantInfo.action"> <s:param name="p" value="1"></s:param></s:url>'>首页</a>
				       <a href='<s:url action="teacher/AssistantInfo!findAssistantInfo.action"> <s:param name="p" value="%{p-1}"></s:param></s:url>'>上一页</a>
                       <a href='<s:url action="teacher/AssistantInfo!findAssistantInfo.action"> <s:param name="p" value="%{p+1}"></s:param></s:url>'>下一页</a>
                       <a href='<s:url action="teacher/AssistantInfo!findAssistantInfo.action"> <s:param name="p" value="lastPage"></s:param></s:url>'>最后</a>
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