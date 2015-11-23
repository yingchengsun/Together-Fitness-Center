<%@ page contentType="text/html; charset=UTF-8" language="java" import="java.sql.*" errorPage="" %>
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

<body background="<%=basePath %>7_yjssx_system/SubSystemImage/Background.png">
<div align="center">
   <img src="<%=basePath %>7_yjssx_system/SubSystemImage/selfInfo.png" height="75"/>
   <table width="100%" border="0" style="margin-top: 20px;background-image: url('<%=basePath %>7_yjssx_system/SubSystemImage/ddown01[1].gif')">
      <tr>
        <td width="100%" height="26"><div align="center">导师信息</div></td>
      </tr>
   </table>
   <hr align="center" width="100%"/>
  <table width="100%" height="100"style="border-collapse:collapse" bordercolor="#999999" background="../SubSystemImage/bg.gif">
  
<tr style="background-color:#CCCCCC">
    <td width="203" height="24" align="left"><div align="center"><strong>姓名：</strong></div></td>
    <td width="267" align="left">${teacherInfo.FTeacherName }</td>
    <td width="219" align="left"><div align="center"><strong>性别：</strong></div></td>
     <td width="254" align="left">${teacherInfo.FTeacherSex }</td>
  </tr>
  <tr>
    <td height="24" align="left"><div align="center"><strong>出生日期：</strong></div></td>
    <td align="left"><fmt:formatDate value="${teacherInfo.FTeacherBirthday}" type="date" dateStyle="medium"/></td>
    <td align="left"><div align="center"><strong>办公地址：</strong></div></td>
    <td align="left">${teacherInfo.FTeacherWorkPlace }</td>
  </tr>
  
  <tr style="background-color:#CCCCCC">
    <td height="24" align="left"> 
      <div align="center"><strong>导师邮箱：</strong></div></td>
    <td align="left">${teacherInfo.FTeacherEmail }</td>
    <td align="left"><div align="center"><strong>联系电话：</strong></div></td>
    <td align="left">${teacherInfo.FTeacherPhone }</td>
  </tr>
</table>
  <table width="100%" height="101" style="border-collapse:collapse"bordercolor="#999999" background="../SubSystemImage/bg.gif">
    <tr>
      <td width="890">
        <p align="left"><strong>研究方向：</strong></p>
      		${teacherInfo.FTeacherResearch }
      </td>
    </tr>
    <tr>
      <td width="890"><p>
      		${teacherInfo.FTeacherAchieve }
      </td>
    </tr>
  </table>
   <hr align="center" width="100%"/>
</div>
</body>
</html>
