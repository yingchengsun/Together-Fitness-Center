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
<style type="text/css">
<!--
.STYLE10 {font-size: 16px}
-->
</style>
</head>

<body background="<%=basePath %>7_yjssx_system/SubSystemImage/Background.png">
<div align="center">

   <table width="80%" border="0"  style="margin-top: 100px;background-image: url('<%=basePath %>7_yjssx_system/SubSystemImage/ddown01[1].gif')">
      <tr>
        <td width="80%" height="26"><div align="center">导师${teacherInfo.FTeacherName }信息</div></td>
      </tr>
   </table>
   <hr align="center" width="80%"/>
  <table width="80%">  
	<tr style="background-color:#CCCCCC">
	    <td width="203" height="28" align="left"><div align="center"><strong>姓名：</strong></div></td>
	    <td width="267" align="left">${teacherInfo.FTeacherName }</td>
	    <td width="219" align="left"><div align="center"><strong>性别：</strong></div></td>
	    <td width="254" align="left">${teacherInfo.FTeacherSex }</td>
	  </tr>
	  <tr>
	    <td height="30" align="left"><div align="center"><strong>出生日期：</strong></div></td>
	    <td align="left"><fmt:formatDate value="${teacherInfo.FTeacherBirthday}" type="date" dateStyle="medium"/></td>
	    <td align="left"><div align="center"><strong>办公地址：</strong></div></td>
	    <td align="left">${teacherInfo.FTeacherWorkPlace }</td>
	  </tr>
	  
	  <tr style="background-color:#CCCCCC">
	    <td height="29" align="left"> 
	      <div align="center"><strong>导师邮箱：</strong></div></td>
	    <td align="left">${teacherInfo.FTeacherEmail }</td>
	    <td align="left"><div align="center"><strong>联系电话：</strong></div></td>
	    <td align="left">${teacherInfo.FTeacherPhone }</td>
	  </tr>
  </table>
  <table width="80%">
    <tr>
      <td>
        <div align="left"><strong>研究方向：</strong></div><br/>
      		${teacherInfo.FTeacherResearch }
      </td>
    </tr>
    <tr>
      <td>
        <div align="left"><strong>研究成果：</strong></div><br/>
      		${teacherInfo.FTeacherAchieve }
      </td>
    </tr>
  </table>
   <hr align="center" width="80%"/>
</div>
</body>
</html>
