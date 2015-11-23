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
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>
  
<body>
  <div align="center">

  <table width="100%" border="0" style="margin-top: 100px;background-image: url('<%=basePath %>7_yjssx_system/SubSystemImage/ddown01[1].gif')">
      <tr>
        <td width="100%"><div align="center"><s:property value="infoDetail.FInfoTitle"/></div></td>
      </tr>
   </table>
   <hr align="center" width="100%"/>
    <table width="100%">
    <tr>
        <td align="right">发布日期:<fmt:formatDate value="${infoDetail.FInfoStartTime}" type="date" dateStyle="medium"/></td>
    </tr>
      <tr>
        <td><s:property value="infoDetail.FInfoContet" escape="false"/></td>
    </tr>
      <tr>
        <td align="center"><a href="<%=basePath %>files/7yjssx_system/infoFile/information/${infoDetail.FInfoPath }">简历模板下载</a>
        <img src="<%=basePath %>7_yjssx_system/SubSystemImage/gif-0145.gif" />
        </td>
    </tr>
    </table>
    <hr align="center" width="100%"/>
  </div>
</body>
</html>
