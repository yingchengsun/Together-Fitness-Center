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
			课程答疑详细信息
		</h3>
		<hr>
		<br>
		<s:form name="f" action="" method="post" theme="simple">
			<table width="80%" border="0" id="mytable" align="center">
			    <tr>
	                <th align="center" colspan="2" background="<%=basePath%>3_jiaofu_system/pictures/jft.gif" height="30">
			           <font color="#FFFFFF">问题详细信息</font>
	                </th>
	            </tr>
				<tr>
					<td align="left">
						发起人姓名：
						<s:property
							value="jfptTabCourseaskquestion.tabStudents.FStudentName" />
					</td>
					<td align="right">
						提问时间：
						<s:date name="jfptTabCourseaskquestion.FDateTime" format="yyyy年MM月dd日HH时mm分ss秒" />
					</td>
				</tr>
				<tr>
					<td align="left">
						询问问题：
					</td>
					<td align="left">
						<s:property value="jfptTabCourseaskquestion.FContents" />
					</td>
				</tr>
				<s:if test="listCoursereplyquestionInfo.size > 0">
					<s:iterator value="listCoursereplyquestionInfo">
						<tr>
							<td align="left">
								<s:property value="FReplyUserId" />回复:
							</td>
							<td align="left">
								<s:property value="FContents" />-----<s:date name="FDateTime" format="yyyy年MM月dd日HH时mm分ss秒" />
							</td>
						</tr>
					</s:iterator>
				</s:if>
				<tr>
				    <td align="left">进行回复：</td>
				    <td align="left"><s:textarea name="FContents" cols="100%" rows="5"/></td>
				</tr>
				<tr>
			        <td colspan="2" align="center">
                       <input type="button" value="提交" onclick="javascript:document.f.action='assist/CourseManage!addReplyInfoByID.action?FQuestionId=<s:property value="jfptTabCourseaskquestion.FQuestionId"/>';document.f.submit();"/>
                        &nbsp;<s:reset value="重置"/>&nbsp;
                       <input type="button" value="返回" onClick="javascript:window.history.go(-1)"/>
                    </td>
			    </tr>
			</table>
		</s:form>
	</body>
</html>