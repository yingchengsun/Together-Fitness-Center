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
    <table border="0" cellpadding="1" cellspacing="0" width="801" align="center" style="border-collapse:collapse" >
    <tr>
      <td height="166" colspan="2">
        <embed src="<%=basePath%>7_yjssx_system/SubSystemImage/top.swf" width="799" height="164"></embed>
        <table width="800" height="25" border="0" background="<%=basePath%>7_yjssx_system/SubSystemImage/navigate.gif">
          <tr>
            <td height="21" align="left" valign="middle" width="794"
					background="<%=basePath%>7_yjssx_system/SubSystemImage/navigate.gif" class="text_write"> <div align="left"> &nbsp;&nbsp;&nbsp; <a href="<%=basePath%>yjssxCommon/YjssxFirstPage!showFirstPageInfo.action"><strong><font color="#ffffff">首 页</font></strong> </a> 
              <!--顶部链接-->            
            </div></td>
          </tr>
         </table>
      </td>
     </tr>
    </table>
    <table width="801" border="0" style="margin-top: 10px;background-image: url('<%=basePath %>7_yjssx_system/SubSystemImage/titlebg.gif')">
      <tr>
        <td width="100%" height="26"><div align="center">${infoDetail.FInfoTitle }</div></td>
      </tr>
   </table>
  <table width="801" border="0" style="border-collapse:collapse" >
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
