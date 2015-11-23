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
    	function selectAll(){
    		 var objs = document.getElementsByTagName("input");
    		 for(var i=0;i<objs.length;i++){
    		 	 if(objs[i].type.toLowerCase() == "checkbox" )            
                    objs[i].checked = true;
    		 }
    		 
    	}
    	
    	function unSelectAll(){
    		var objs = document.getElementsByTagName("input");
    		 for(var i=0;i<objs.length;i++){
    		 	 if(objs[i].type .toLowerCase()== "checkbox" )            
                    objs[i].checked = false;
    		}
    	}
    </script>
	</head>

	<body>
		<br>
		<h3 align="center">
			资源管理
		</h3>
		<hr>
		<br>
		<s:form action="administrator/ResourceManage!deleteUpfileInfo.action" method="post" theme="simple">
		<table width="80%" border="0" id="mytable" align="center">
		    <tr>
	                <th align="center" colspan="8" background="<%=basePath%>3_jiaofu_system/pictures/jft.gif" height="30">
			           <font color="#FFFFFF">资源信息</font>
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
					文件名称
				</th>
				<th width=""  align="center">
					内容简介
				</th>
				<th width=""  align="center">
					上传时间
				</th>
				<th width=""  align="center">
					上传者ID号
				</th>
				<th width=""  align="center">
			             点击删除
				</th>
				<th width=""  align="center">
				         标记
				</th>
			</tr>
			<s:iterator value="listUploadfileInfo" status="status">
				<tr>
					<td align="center">
						<s:property value="#status.count" />
					</td>
					<td align="center">
						<s:property value="tabCourse.FCourseName" />
					</td>
					<td align="center">
						<s:property value="FFileName" />
					</td>
					<td align="center">
						<s:property value="FFileDetail" />
					</td>
					<td align="center">
						<s:date name="FUpTime" format="yyyy年MM月dd日HH时mm分ss秒" />
					</td>
					<td align="center">
						<s:property value="mhqxTabUser.FUserNumber" />
					</td>
					<td align="center">
						<a href="administrator/ResourceManage!deleteUpfileInfoByID.action?FNumber=<s:property value="FNumber"/>">点击删除</a>
					</td>
					<td align="center">
					    <input type="checkbox" name="deletelist" value="${FNumber}"/>
					</td>
				</tr>
			</s:iterator>
			<s:if test="listUploadfileInfo.size >0">
			<tr align="right">
			    <td colspan="8">
			        <input type="button" value="全选" onclick="selectAll()" />
                    <input type="button" value="反选" onclick="unSelectAll()" />
                    <input type="submit" value="删除" />
			    </td>
			</tr>
			<tr align="center">
			   <td colspan="8">
			      <a href='<s:url action="administrator/ResourceManage!findResourceInfo.action"> <s:param name="p" value="1"></s:param></s:url>'>首页</a>
			      <a href='<s:url action="administrator/ResourceManage!findResourceInfo.action"> <s:param name="p" value="%{p-1}"></s:param></s:url>'>上一页</a>
                  <a href='<s:url action="administrator/ResourceManage!findResourceInfo.action"> <s:param name="p" value="%{p+1}"></s:param></s:url>'>下一页</a>
                  <a href='<s:url action="administrator/ResourceManage!findResourceInfo.action"> <s:param name="p" value="lastPage"></s:param></s:url>'>最后</a>
                                                共<s:property value="lastPage"/>页,当前第<s:property value="p"/>页
			   </td>
			</tr>
			</s:if>
		</table>
		</s:form>
	</body>
</html>