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
			院外助教
		</h3>
		<hr>
		<form action="administrator/excelIn4.action" enctype="multipart/form-data" method="post">
		<table width="80%" border="0" align="center">
			<tr>
				<td align="left">
					     导入excel文件<input type="file" name="file" />&nbsp;<input type="submit" value="导入" />
					     <img src="3_jiaofu_system/pictures/excel.bmp">文件格式要求为：序号、助教编号、助教姓名、性别
				</td>
				<td align="right">
					<a href="3_jiaofu_system/administrator/basicInfoManage/OtherInfoAdd.jsp">添加院外助教信息</a>
				</td>
			</tr>
		</table>
		</form>
		<br>
		<table width="80%" border="0" id="mytable" align="center">
		    <tr>
	                <th align="center" colspan="9" background="<%=basePath%>3_jiaofu_system/pictures/jft.gif" height="30">
			           <font color="#FFFFFF">院外助教</font>
	                </th>
	        </tr>
		    <tr>
		       <th width="10%"  align="center">序号</th>
		       <th width="10%"  align="center">助教编号</th>
		       <th width="10%"  align="center">助教姓名</th>
		       <th width="10%"  align="center">性别</th>
		       <th width="10%"  align="center">年龄</th>
		       <th width="10%"  align="center">电话</th>
		       <th width="10%"  align="center">邮箱</th>
		       <th width="20%"  align="center">备注</th>
		       <th width="10%"  align="center">删除</th>
		    </tr>
		    <s:iterator value="listOtherassistInfo" status="status">
				<tr>
					<td align="center"><s:property value="#status.count" /></td>
					<td align="center"><s:property value="FAssistantId" /></td>
					<td align="center"><s:property value="FName" /></td>
					<td align="center">
					  <s:if test="FSex==null">
					         空
					  </s:if>
					  <s:else>
					     <s:property value="FSex"/>
					  </s:else>
					</td>
					<td align="center">
					  <s:if test="FAge==null">
					    空     
					  </s:if>
					  <s:else>
					     <s:property value="FAge" />
					  </s:else>
					</td>
					<td align="center">
					  <s:if test="FTelephone==null">
					     空     
					  </s:if>
					  <s:else>
					     <s:property value="FTelephone" />
					  </s:else>  
					</td>
					<td align="center">
					  <s:if test="FEmailAddress==null">
					     空     
					  </s:if>
					  <s:else>
					     <s:property value="FEmailAddress"/>
					  </s:else>
					</td>
					<td align="center">
					  <s:if test="FBeizhu==null">
					     空     
					  </s:if>
					  <s:else>
					     <s:property value="FBeizhu"/>
					  </s:else>
					</td>
					<td align="center">
					    <a href="administrator/BasicInfo!deleteOtherInfoByID.action?FAssistantId=<s:property value="FAssistantId" />">删除</a>
					</td>
				</tr>
			</s:iterator>
			<s:if test="listOtherassistInfo.size >0">
			<tr align="center">
			    <td colspan="9">
			           <a href='<s:url action="administrator/BasicInfo!findOtherInfo.action"> <s:param name="p" value="1"></s:param></s:url>'>首页</a>
				       <a href='<s:url action="administrator/BasicInfo!findOtherInfo.action"> <s:param name="p" value="%{p-1}"></s:param></s:url>'>上一页</a>
                       <a href='<s:url action="administrator/BasicInfo!findOtherInfo.action"> <s:param name="p" value="%{p+1}"></s:param></s:url>'>下一页</a>
                       <a href='<s:url action="administrator/BasicInfo!findOtherInfo.action"> <s:param name="p" value="lastPage"></s:param></s:url>'>最后</a>
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
	</body>
</html>
