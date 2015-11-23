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
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>
  
<body background="<%=basePath %>7_yjssx_system/SubSystemImage/Background.png">
  <div align="center">

  <table width="80%" border="0" style="margin-top: 100px;background-image: url('<%=basePath %>7_yjssx_system/SubSystemImage/ddown01[1].gif')">
      <tr>
        <td width="80%"><div align="center"><s:property value="detailInfo.FThesisName"/></div></td>
      </tr>
   </table>
    <table width="80%" border="1" style="border-collapse:collapse">
    <tr>
        <td align="right"><fmt:formatDate value="${detailInfo.FDate}" type="date" dateStyle="medium"/></td>
    </tr>
      <tr>
        <td><s:property value="detailInfo.FComment" escape="false"/></td>
    </tr>
      <tr>
        <td><a href="<%=basePath %>files/7yjssx_system/infoFile/Thesis/${detailInfo.FThesisStorePath }">下载</a></td>
    </tr>
    </table>
  </div>
</body>
</html>
