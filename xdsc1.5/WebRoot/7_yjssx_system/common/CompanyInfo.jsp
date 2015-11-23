<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
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
<title>无标题文档</title>
<link href="<%=basePath %>css.css" rel="stylesheet" type="text/css" />
</head>

<body background="../SubSystemImage/Background.png">
<div align="center">

   <table width="80%" border="0" style="margin-top: 100px;background-image: url('<%=basePath %>7_yjssx_system/SubSystemImage/ddown01[1].gif')">
      <tr>
        <td width="80%" height="26"><div align="center"><strong>企业信息</strong></div></td>
      </tr>
   </table>
   <hr align="center" width="80%"/>
	 <table width="80%">
	  
	  <tr style="background-color:#CCCCCC">
	    <td width="145" height="29" align="center"><div align="left"><strong>企业名称：</strong></div></td>
	    <td width="404" align="left"><div align="left"><s:property value="companyInfo.FCompanyName"/></div></td>
	    <td width="136" align="center"><div align="left"><strong>企业地址：</strong></div></td>
	    <td width="258" align="left"><div align="left"><s:property value="companyInfo.FAddress"/></div></td>
	  </tr>
	  <tr>
	    <td height="28" align="center"><div align="left"><strong>注册时间：</strong></div></td>
	    <td align="left"><div align="left"><fmt:formatDate value="${companyInfo.FRegisterTime}" type="date" dateStyle="medium"/></div></td>
	    <td align="center"><div align="left"><strong>企业邮箱：</strong></div></td>
	    <td align="left"><div align="left"><s:property value="companyInfo.FEmailAddress"/></div></td>
	  </tr>
	  
	  <tr style="background-color:#CCCCCC">
	    <td height="30" align="center"> 
	      <div align="left"><strong>联系人：</strong></div></td>
	    <td align="left"><div align="left"><s:property value="companyInfo.FConnectPerson"/></div></td>
	    <td align="center"><div align="left"><strong>联系电话：</strong></div></td>
	    <td align="left"><div align="left"><s:property value="companyInfo.FTelephone"/></div></td>
	  </tr>
	</table>
   <table width="80%">
    <tr>
      <td align="left"><div align="left"><strong>企业详情：</strong>
      </div><br/>
      <s:property value="companyInfo.FInformation" escape="false"/>
        </td>
    </tr>
   </table>
   <hr align="center" width="80%"/>
</div>
</body>
</html>
