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
		<title>专业方向</title>
		<style type="text/css">
<!--
body {
	background-image: url(images/Background.png)
}
-->
</style>
    <script type="text/javascript">
    	function next(){
    	    window.location.href="<%=basePath%>administrator/BasicInfo!findCoursetypeInfo.action";
    	}
    	function finish(){
    	    window.location.href="<%=basePath%>3_jiaofu_system/administrator/basicInfoManage/finish.jsp";
    	}
    	function preference(){
    	   window.location.href="<%=basePath%>administrator/BasicInfo!findCourseInfo.action";
    	}
    </script>
	</head>

	<body>
		<br>
		<h3 align="center">
			专业方向管理
		</h3>
		<hr>
		<table width="80%" border="0" align="center">
			<tr>
				<td align="right">
					<a
						href="3_jiaofu_system/administrator/basicInfoManage/DirectionInfoAdd.jsp">添加专业方向信息</a>
				</td>
			</tr>
		</table>
		<br>
		<table width="80%" border="0" id="mytable" align="center">
		    <tr>
	                <th align="center" colspan="3" background="<%=basePath%>3_jiaofu_system/pictures/jft.gif" height="30">
			           <font color="#FFFFFF">方向信息</font>
	                </th>
	            </tr>
			<tr>
				<th width="20%" align="center">
					序号
				</th>
				<th width="30%" align="center">
					方向名称
				</th>
				<th width="20%" align="center">
					删除
				</th>
			</tr>
			<s:iterator value="listDirectionInfo" status="status">
				<tr>
					<td align="center">
						<s:property value="#status.count" />
					</td>
					<td align="center">
						<s:property value="FDirectionName" />
					</td>
					<td align="center">
						<a href="administrator/BasicInfo!deleteDirectionInfoByID.action?FDirectionId=<s:property value="FDirectionId"/>">
							删除 </a>
					</td>
				</tr>
			</s:iterator>
			<s:if test="listDirectionInfo.size >0">
			<tr align="center">
			   <td colspan="3">
			           <a href='<s:url action="administrator/BasicInfo!findDirectionInfo.action"> <s:param name="p" value="1"></s:param></s:url>'>首页</a>
				       <a href='<s:url action="administrator/BasicInfo!findDirectionInfo.action"> <s:param name="p" value="%{p-1}"></s:param></s:url>'>上一页</a>
                       <a href='<s:url action="administrator/BasicInfo!findDirectionInfo.action"> <s:param name="p" value="%{p+1}"></s:param></s:url>'>下一页</a>
                       <a href='<s:url action="administrator/BasicInfo!findDirectionInfo.action"> <s:param name="p" value="lastPage"></s:param></s:url>'>最后</a>
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
		<br>
		<br>
		<table border="0" style="border-collapse: collapse" align="center">
				<tr>
				    <td>
				        课程信息配置流程：
				    </td>
					<td>
						<img src="3_jiaofu_system/pictures/jfnown.png"><a href="administrator/BasicInfo!findCourseInfo.action">管理基本课程信息</a>
					</td>
					<th>
						<img src="3_jiaofu_system/pictures/jfnow.png"><a href="administrator/BasicInfo!findDirectionInfo.action">管理专业方向信息</a>
					</th>
					<td>
						<img src="3_jiaofu_system/pictures/jfnown.png"><a href="administrator/BasicInfo!findCoursetypeInfo.action">配置课程类型信息</a>
					</td>
					<td>
						<img src="3_jiaofu_system/pictures/jfnown.png"><a href="<%=basePath%>3_jiaofu_system/administrator/basicInfoManage/finish.jsp">完成</a>
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
