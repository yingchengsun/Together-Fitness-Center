<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">
    
<title>My JSP 'ShowZhaoPinInfo.jsp' starting page</title>
<link href="<%=basePath %>css.css" rel="stylesheet" type="text/css" />

</head>
  
<body >
  <div align="center">
    
    <table width="80%" border="0" style="margin-top: 100px;background-image: url('<%=basePath %>7_yjssx_system/SubSystemImage/ddown01[1].gif')">
      <tr>
        <td width="100%" height="26"><div align="center">${infoDetail.FInfoTitle }</div></td>
      </tr>
   </table>
   <table width="80%" >
   	  <tr>
   	  	<td align="left">
		   <img src="<%=basePath %>7_yjssx_system/SubSystemImage/back.png" width="15" height="15"/>
		   <a href="<%=basePath %>yjssxAdmin/AdminNoticeOperation!showAllNotice.action"><strong>返回</strong></a>
   	 	</td>
   	  </tr>
   </table>
   <hr align="center" width="80%" size="2" color="#990033"/>
  <table width="80%" border="0" style="border-collapse:collapse" >
    <tr class="SubMenu" style="background-color:#CCCCCC">
      <td><div align="center"></div></td>
        <td>
      <div align="right">发送日期：<fmt:formatDate value="${infoDetail.FInfoStartTime}" type="date" dateStyle="medium"/></div></td >
    </tr>
    <tr>
      <td>
        <td>
      <div align="center"><span>${infoDetail.FInfoContet}</span> </div></td >
    </tr>
     <tr>
       <td height="42" align="center"><a href="<%=basePath %>yjssxCommon/CommonDownFile!downInfomation.action?downId=${infoDetail.FInfoId }">相关附件下载</a></td>
    </tr>
    <tr style="background-color:#CCCCCC">
      <td height="15"></td>
      <td></td>
    </tr>
    
  </table>
  </div>
</body>
</html>
