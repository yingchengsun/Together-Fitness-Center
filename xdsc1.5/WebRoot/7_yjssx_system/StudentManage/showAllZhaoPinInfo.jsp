<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>无标题文档</title>
<link href="<%=basePath %>css.css" rel="stylesheet" type="text/css" />
<script language="javascript" src="<%=basePath %>js/TableColor.js"></script>
</head>

<body background="<%=basePath %>7_yjssx_system/SubSystemImage/Background.png">
<div align="center">
   <img src="<%=basePath %>7_yjssx_system/SubSystemImage/info2.png" height="75"/>
   <table width="100%" border="0" style="margin-top: 20px;background-image: url('<%=basePath %>7_yjssx_system/SubSystemImage/ddown01[1].gif')">
      <tr>
        <td width="100%" height="26"><div align="center">已发布的招聘信息</div></td>
      </tr>
   </table>
   <hr align="center" width="100%"/>
   <table width="100%" border="1" id="mytable" style="border-collapse:collapse" bordercolor="#999999" background="<%=basePath %>7_yjssx_system/SubSystemImage/bg.gif">
	  <tr style="background-image: url('<%=basePath %>7_yjssx_system/SubSystemImage/titlebg.gif')">
	    <th>编号</th>
	    <th  scope="col"><div align="center">名称</div></th>
	    <th scope="col"><div align="center">发布日期</div></th>
	    <th scope="col"><div align="center">查看</div></th>
	  </tr>
	  <s:if test="infoList.size==0">
			<tr>
				<td>对不起暂无数据！！！</td>
			</tr>
		</s:if>
	    <s:else>
		   <s:iterator value="infoList" status="status">
			  <tr>
				 <td align="center">
			       <s:property value="#status.count" />
			     </td>
			    <td height="24px"><div align="center"><s:property value="FInfoTitle"/></div></td>
			    <td><div align="center"><fmt:formatDate value="${FInfoStartTime}" type="date" dateStyle="medium"/></div></td>
			    <td><div align="center">
			    <img src="<%=basePath %>7_yjssx_system/SubSystemImage/edit_profile.gif" height="15"/>
			    <a href="<%=basePath %>yjssxStudent/PostgraduateZhaoPinInfo!showInfo.action?id=<s:property value="FInfoId"/>">查看</a></div></td>
			  </tr>
			</s:iterator>
	       </s:else>
	  </table>
  <table width="40%">
  	<tr>
		<td><div align="center"><a href="<%=basePath %>yjssxStudent/PostgraduateZhaoPinInfo!showAllInfo.action?p=1" >首页</a></div></td>
		<td><div align="center"><a href="<%=basePath %>yjssxStudent/PostgraduateZhaoPinInfo!showAllInfo.action?p=${p-1}" >上一页</a></div></td>
		<td><div align="center"><a href="<%=basePath %>yjssxStudent/PostgraduateZhaoPinInfo!showAllInfo.action?p=${p+1}" >下一页</a></div></td>
		<td><div align="center"><a href="<%=basePath %>yjssxStudent/PostgraduateZhaoPinInfo!showAllInfo.action?p=${lastPage}" >末页</a></div></td>
	</tr>
  </table>
</div> 
</body>
</html>
