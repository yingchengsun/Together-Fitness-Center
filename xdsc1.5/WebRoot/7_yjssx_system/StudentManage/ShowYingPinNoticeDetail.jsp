<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
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
</head>

<body background="../SubSystemImage/Background.png">
<div align="center" >
 
   <table width="100%" border="0" style="margin-top: 100px;background-image: url('<%=basePath %>7_yjssx_system/SubSystemImage/ddown01[1].gif')">
      <tr>
        <td width="100%" height="26"><div align="center">${NoticeDetail.FInfoTitle }</div></td>
      </tr>
   </table>
   <table width="100%" >
   	  <tr>
   	  	<td align="left">
		   <img src="<%=basePath %>7_yjssx_system/SubSystemImage/back.png" width="15" height="15"/>
		   <a href="<%=basePath %>yjssxStudent/PostgraduateYingPinInfo!ShowNotice.action"><strong>返回</strong></a>
   	 	</td>
   	  </tr>
   </table>
   <hr align="center" width="100%"/>
  <table width="100%">
    <tr class="SubMenu" style="background-color:#CCCCCC">
        <td>
      <div align="right">发送日期:<fmt:formatDate value="${NoticeDetail.FInfoStartTime}" type="date" dateStyle="medium"/></div></td >
    </tr>
    <tr>
     <td>
      <div align="center">${NoticeDetail.FInfoContet}</div>
     </td >
    </tr>
  </table>
   <hr align="center" width="100%"/>
</div>
</body>
</html>
