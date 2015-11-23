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
<link href="<%=basePath %>css.css" rel="stylesheet" type="text/css" />    
<title>My JSP 'ShowZhaoPinInfo.jsp' starting page</title>
</head>
  
<body background="<%=basePath %>7_yjssx_system/SubSystemImage/Background.png">
  <div align="center">
 
  <table width="100%" border="0" style="margin-top: 100px;background-image: url('<%=basePath %>7_yjssx_system/SubSystemImage/ddown01[1].gif')">
      <tr>
        <td width="100%"><div align="center"><s:property value="infoDetail.FInfoTitle"/></div></td>
      </tr>
   </table>
   <table width="100%" >
   	  <tr>
   	  	<td align="left">
		   <img src="<%=basePath %>7_yjssx_system/SubSystemImage/back.png" width="15" height="15"/>
		   <a href="<%=basePath %>yjssxStudent/PostgraduateZhaoPinInfo!showAllInfo.action"><strong>返回</strong></a>
   	 	</td>
   	  </tr>
   </table>
   <hr align="center" width="100%"/>
    <table width="100%">
    <tr>
    	<td></td>
        <td><div align="right">发布日期：<fmt:formatDate value="${infoDetail.FInfoStartTime}" type="date" dateStyle="medium"/></div></td>
    </tr>
      <tr>
      	<td></td>
        <td><s:property value="infoDetail.FInfoContet" escape="false"/></td>
    </tr>
      <tr>
         <td></td>
        <td><div align="center"><a href="<%=basePath %>files/7yjssx_system/infoFile/information/${infoDetail.FInfoPath }">简历模板下载</a>
        <img src="<%=basePath %>7_yjssx_system/SubSystemImage/gif-0145.gif" /></div></td>
    </tr>
    <tr>
         <td></td>
        <td><input type="button" value="申请" onclick="location.href='<%=basePath %>yjssxCompany/CompanyZhaoPinOperation!applyCompany.action?comNum=${infoDetail.mhqxTabUser.FUserNumber}&&infoPath=${infoDetail.FInfoPath }'" /></td>
    </tr>
    </table>
    <hr align="center" width="100%"/>
  </div>
</body>
</html>
