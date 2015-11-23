<%@ page contentType="text/html; charset=UTF-8" language="java" import="java.sql.*" errorPage="" %>
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
<script language="javascript" src="<%=basePath %>js/TableColor.js"></script>
<style type="text/css">
<!--
.STYLE10 {font-size: 16px}
-->
</style>
</head>

<body background="<%=basePath %>7_yjssx_system/SubSystemImage/Background.png">
<div align="center">
   <img src="<%=basePath %>7_yjssx_system/SubSystemImage/selfInfo.png" height="75"/>
   <table width="100%" border="0" style="margin-top: 20px;background-image: url('<%=basePath %>7_yjssx_system/SubSystemImage/ddown01[1].gif')">
      <tr>
        <td width="100%" height="26"><div align="center">个人信息</div></td>
      </tr>
   </table>
   <hr align="center" width="100%"/>
  <table width="100%" id="mytable"style="border-collapse:collapse">
  
  <tr>
    <td width="203" height="24" align="left"><div align="center">姓名：</div></td>
    <td width="267" align="left">${teacherInfo.FTeacherName }</td>
    <td width="219" align="left"><div align="center">性别：</div></td>
    <td width="254" align="left">${teacherInfo.FTeacherSex }</td>
  </tr>
  <tr>
    <td height="24" align="left"><div align="center">出生日期：</div></td>
    <td align="left">${teacherInfo.FTeacherBirthday }</td>
    <td align="left"><div align="center">办公地址：</div></td>
    <td align="left">${teacherInfo.FTeacherWorkPlace }</td>
  </tr>
  
  <tr>
    <td height="24" align="left"> 
      <div align="center">导师邮箱：</div></td>
    <td align="left">${teacherInfo.FTeacherEmail }</td>
    <td align="left"><div align="center">联系电话：</div></td>
    <td align="left">${teacherInfo.FTeacherPhone }</td>
  </tr>
</table>
  <table width="100%" height="101" style="border-collapse:collapse"bordercolor="#999999" background="../SubSystemImage/bg.gif">
    <tr>
      <td width="890">
       <p align="left"> 研究方向：</p>
      		${teacherInfo.FTeacherResearch }
      </td>
    </tr>
    <tr>
      <td width="890">
      		${teacherInfo.FTeacherAchieve }
      </td>
    </tr>
  </table>
   <hr align="center" width="100%"/>
</div>
</body>
</html>
