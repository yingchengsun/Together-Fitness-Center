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
 
  <table width="100%" border="0" style="margin-top: 100px;background-image: url('<%=basePath %>7_yjssx_system/SubSystemImage/ddown01[1].gif')">
      <tr>
        <td width="100%"><div align="center"><s:property value="SubmitThesis.FThesisName"/></div></td>
      </tr>
   </table>
   <table width="100%" >
   	  <tr>
   	  	<td align="left">
		   <img src="<%=basePath %>7_yjssx_system/SubSystemImage/back.png" width="15" height="15"/>
		   <a href="<%=basePath %>yjssxStudent/PostgraduateReceiveNotice!findAllNotice.action?type=${type }"><strong>返回</strong></a>
   	 	</td>
   	  </tr>
   </table>
    <table width="100%" height="97" border="0" style="border-collapse:collapse" bordercolor="#999999"
background="../SubSystemImage/bg.gif">
      <tr style="background-color:#CCCCCC">
        <td align="right" height="12"><fmt:formatDate value="${SubmitThesis.FDate}" type="date" dateStyle="medium"/></td>
      </tr>
      <tr>
        <td><s:property value="SubmitThesis.FComment" escape="false"/></td>
      </tr>
      <tr>
        <td><a href="<%=basePath %>files/7yjssx_system/infoFile/Thesis/${SubmitThesis.FThesisStorePath }">论文下载</a></td>
    </tr>
    <tr style="background-color:#CCCCCC">
        <td align="right" height="12"></td>
    </tr>
    </table>
  </div>
</body>
</html>
