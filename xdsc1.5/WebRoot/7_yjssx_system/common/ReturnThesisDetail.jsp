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
    
<title></title>
<link href="<%=basePath %>css.css" rel="stylesheet" type="text/css" />
</head>
  
<body background="<%=basePath %>7_yjssx_system/SubSystemImage/Background.png">
  <div align="center">

  <table width="80%" border="0" style="margin-top: 100px;background-image: url('<%=basePath %>7_yjssx_system/SubSystemImage/ddown01[1].gif')">
      <tr>
        <td width="80%"><div align="center"><s:property value="ReturnThesis.FThesisName"/></div></td>
      </tr>
   </table>
    <table width="80%" border="1" style="border-collapse:collapse">
    <tr>
        <td align="right" height="12"><fmt:formatDate value="${ReturnThesis.FDate}" type="date" dateStyle="medium"/></td>
    </tr>
      <tr>
        <td><s:property value="ReturnThesis.FComment" escape="false"/></td>
    </tr>
    <tr>
        <td><a href="<%=basePath %>files/7yjssx_system/infoFile/Thesis/${ReturnThesis.FThesisStorePath }">论文下载</a></td>
    </tr>
    <tr style="background-color:#CCCCCC">
        <td align="right" height="12"></td>
    </tr>
    </table>
  </div>
</body>
</html>
