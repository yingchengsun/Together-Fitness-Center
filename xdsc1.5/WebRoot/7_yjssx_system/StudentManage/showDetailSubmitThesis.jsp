<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
        <td width="80%"><div align="center"><s:property value="detailThesis.FThesisName"/></div></td>
      </tr>
   </table>
   <table width="80%" >
   	  <tr>
   	  	<td align="left">
		   <img src="<%=basePath %>7_yjssx_system/SubSystemImage/back.png" width="15" height="15"/>
		   <a href="<%=basePath %>yjssxStudent/PostgraduateReceiveNotice!findAllNotice.action?type=${type }"><strong>返回</strong></a>
   	 	</td>
   	  </tr>
   </table>
    <table width="80%" height="97" border="0" style="border-collapse:collapse" bordercolor="#999999"
background="../SubSystemImage/bg.gif">
      <tr style="background-color:#CCCCCC">
        <td align="right"><s:property value="detailThesis.FDate"/></td>
      </tr>
      <tr>
        <td><s:property value="detailThesis.FComment" escape="false"/></td>
      </tr>
      <tr>
        <td><a href="<%=basePath %>yjssxStudent/PostgraduateSubmitThesis!downFile.action?downId=${detailThesis.FNumber }">论文下载</a></td>
    </tr>
    </table>
  </div>
</body>
</html>
