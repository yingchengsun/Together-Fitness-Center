<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>无标题文档</title>
<link href="<%=basePath %>css.css" rel="stylesheet" type="text/css" />
</head>

<body background="<%=basePath %>7_yjssx_system/SubSystemImage/Background.png">
  
  <div align="center">
   <img src="<%=basePath %>7_yjssx_system/SubSystemImage/selfInfo.png" height="75"/>
   <table width="100%" border="0" style="margin-top: 20px;background-image: url('<%=basePath %>7_yjssx_system/SubSystemImage/ddown01[1].gif')">
      <tr>
        <td width="100%" height="26"><div align="center">企业信息</div></td>
      </tr>
   </table>
   <hr align="center" width="100%"/>
       <table width="100%" style="border-collapse:collapse" bordercolor="#999999" background="../SubSystemImage/bg.gif">
          <tr  style="background-image: url('<%=basePath %>7_yjssx_system/SubSystemImage/titlebg.gif')">
            <td><div align="center"><strong>企业名称</strong></div></td>
      <td><div align="center"><strong>企业地址</strong></div></td>
      <td><div align="center"><strong>企业电话</strong></div></td>
      <td><div align="center"><strong>企业邮箱</strong></div></td>
      <td><div align="center"><strong>联系人</strong></div></td>
      <td><div align="center"><strong>注册时间</strong></div></td>
         </tr>
          <tr>
            <td><div align="center">${companyInfo.FCompanyName }</div></td>
      <td><div align="center">${companyInfo.FAddress }</div></td>
      <td><div align="center">${companyInfo.FTelephone }</div></td>
      <td><div align="center">${companyInfo.FEmailAddress }</div></td>
      <td><div align="center">${companyInfo.FConnectPerson }</div></td>
      <td><div align="center"><fmt:formatDate value="${companyInfo.FRegisterTime}" type="date" dateStyle="medium"/></div></td>
         </tr>
      </table>
        <table width="100%" style="border-collapse:collapse">
          <tr>
            <td>
              <p align="left"><strong>企业详情：</strong></p>
            ${companyInfo.FInformation }
            </td>
      	  </tr>
        </table>
       <hr align="center" width="100%"/>
   </div>
</body>
</html>
