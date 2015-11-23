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
    <script type="text/javascript">
    	function next(){
    	    window.location.href="administrator/corresponding!findStudentDeployInfo.action";
    	}
    	function finish(){
    	    window.location.href="<%=basePath%>3_jiaofu_system/administrator/correspondingdeploy/finish.jsp";
    	}
    	function preference(){
    	   window.location.href="administrator/corresponding!findTeacherDeployInfo.action";
    	}
    </script>

	</head>

	<body>
		<br>
		<h3 align="center">
			教师相关配置信息
		</h3>
		<hr>
		<form action="administrator/excelIn2.action" enctype="multipart/form-data" method="post">
			<table width="80%" border="0" align="center">
				<tr>
					<td align="left">
					     导入excel文件<input type="file" name="file" />&nbsp;<input type="submit" value="导入" />
					     <img src="3_jiaofu_system/pictures/excel.bmp">文件格式要求为：序号、课程号、教师工号、班级号
					</td>
					<td align="right">
						<a href="administrator/corresponding!addInfoIntoTeacherDeploy.action">添加教师配置信息</a><img src="3_jiaofu_system/pictures/go.gif">
					</td>
				</tr>
			</table>
		</form>
		<table width="80%" border="0" id="mytable" align="center">
		    <tr>
	                <th align="center" colspan="8" background="<%=basePath%>3_jiaofu_system/pictures/jft.gif" height="30">
			           <font color="#FFFFFF">教师相关配置信息</font>
	                </th>
	            </tr>
			<tr>
				<th width="15%"  align="center">
					序号
				</th>
				<th width="10%"  align="center">
					教师编号
				</th>
				<th width="15%"  align="center">
					教师姓名
				</th>
				<th width="10%"  align="center">
					对应课程
				</th>
				<th width="15%"  align="center">
					课程名称
				</th>
				<th width="10%"  align="center">
					对应班级
				</th>
				<th width="15%"  align="center">
					班级名称
				</th>
				<th width="10%"  align="center">
					删除
				</th>
			</tr>
			<s:iterator value="listTeacherDeployInfo" status="status">
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
						<s:property value="tabClasses.FClassNumber" />
					</td>
					<td align="center">
						<s:property value="tabClasses.FClassName" />
					</td>
					<td align="center">
					  <a href="administrator/corresponding!deleteTeacherInfoByID.action?FId=<s:property value="FId" />">
					          删除
					  </a>
					</td>
				</tr>
			</s:iterator>
			<s:if test="listTeacherDeployInfo.size >0">
			<tr align="center">
			   <td colspan="8">
			    <a href='<s:url action="administrator/corresponding!findTeacherDeployInfo.action"> <s:param name="p" value="1"></s:param></s:url>'>首页</a>
			    <a href='<s:url action="administrator/corresponding!findTeacherDeployInfo.action"> <s:param name="p" value="%{p-1}"></s:param></s:url>'>上一页</a>
                <a href='<s:url action="administrator/corresponding!findTeacherDeployInfo.action"> <s:param name="p" value="%{p+1}"></s:param></s:url>'>下一页</a>
                <a href='<s:url action="administrator/corresponding!findTeacherDeployInfo.action"> <s:param name="p" value="lastPage"></s:param></s:url>'>最后</a>
                                          共<s:property value="lastPage"/>页,当前第<s:property value="p"/>页
			  </td>
			</tr>
			</s:if>
		</table>
		<br>
		<br>
		<table border="0" style="border-collapse: collapse" align="center">
				<tr>
				    <td>
				        必修及方向课程信息配置流程：
				    </td>
					<th>
						<img src="3_jiaofu_system/pictures/jfnow.png"><a href="administrator/corresponding!findTeacherDeployInfo.action">教师班级课程对应信息配置</a>
					</th>
					<td>
						<img src="3_jiaofu_system/pictures/jfnown.png"><a href="administrator/corresponding!findStudentDeployInfo.action">学生课程班级对应信息配置</a>
					</td>
					<td>
						<img src="3_jiaofu_system/pictures/jfnown.png"><a href="<%=basePath%>3_jiaofu_system/administrator/correspondingdeploy/finish.jsp">完成</a>
					</td>
					<td>
					    &nbsp;&nbsp;<img src="3_jiaofu_system/pictures/jflast.gif" onclick="preference()">
					    &nbsp;&nbsp;<img src="3_jiaofu_system/pictures/jfnext.gif" onclick="next()">
					    &nbsp;&nbsp;<img src="3_jiaofu_system/pictures/jfend.gif" onclick="finish()">
					</td>
				</tr>
		</table>
	</body>
</html>
