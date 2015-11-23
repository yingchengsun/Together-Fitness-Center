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
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>无标题文档</title>
<link href="<%=basePath %>css.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath %>7_yjssx_system/dialog.css" rel="stylesheet" type="text/css"></link>

<script language="javascript" src="<%=basePath %>7_yjssx_system/jquery-latest.pack.js"></script>
<script language="javascript" src="<%=basePath %>7_yjssx_system/dialog.js"></script>
<style type="text/css">
<!--
#Layer1 {
	position:absolute;
	width:200px;
	height:115px;
	z-index:1;
	left: 87px;
	top: -47px;
}
.STYLE1 {color: #FF0000}
-->
</style>
</head>

<body background="<%=basePath %>7_yjssx_system/SubSystemImage/Background.png">
 <div align="center">
  
   <table width="80%" border="0" >
      <tr>
        <td width="80%" height="26"><div align="center"></div></td>
      </tr>
   </table>
   <table width="80%" border="0" style="margin-top: 100px;background-image: url('<%=basePath %>7_yjssx_system/SubSystemImage/ddown01[1].gif')">
      <tr>
        <td width="80%" height="26"><div align="center">${stuInfo.tabStudents.FStudentName }个人信息</div></td>
      </tr>
   </table>
   <hr align="center" width="80%"/>
      <table width="80%">
          <tr >
            <td height="24" align="left"><div align="center"><strong>姓名：</strong></div></td>
      <td align="left"><s:property value="stuInfo.tabStudents.FStudentName"/></td>
      <td align="left"><div align="center"><strong>出生日期</strong>：</div></td>
      <td align="left"><fmt:formatDate value="${stuInfo.tabStudents.FStudentBirthday}" type="date" dateStyle="medium"/></td>
      </tr>
          <tr style="background-color:#CCCCCC">
            <td height="24" align="left"><div align="center"><strong>性别：</strong></div></td>
            <td align="left"><s:property value="stuInfo.tabStudents.FStudentSex"/></td>
	        <td align="left"><div align="center"><strong>民族：</strong></div></td>
	        <td align="left"><s:property value="stuInfo.tabStudents.FStudentNation"/></td>
      </tr>
          <tr>
            <td height="29" align="left"><div align="center"><strong>籍贯：</strong></div></td>
            <td align="left"><s:property value="stuInfo.tabStudents.FStudentNativeplace"/></td>
            <td align="left"><div align="center"><strong>本科学校：</strong></div></td>
            <td align="left"><s:property value="stuInfo.FStudentExSchool"/></td>
        </tr>
          <tr style="background-color:#CCCCCC">
            <td height="30" align="left"><div align="center"><strong>入校时间：</strong></div></td>
            <td align="left"><s:property value="stuInfo.tabStudents.FStudentRegData"/></td>
            <td align="left"><div align="center"><strong>硕士类型：</strong></div></td>
            <td align="left"><s:property value="stuInfo.tabStudents.FType"/></td>
        </tr>
          <tr>
            <td height="31" align="left"><div align="center"><strong>联系电话：</strong></div></td>
            <td align="left"><s:property value="stuInfo.tabStudents.FStudentTel"/></td>
            <td align="left"><div align="center"><strong>邮箱：</strong></div></td>
            <td align="left"><s:property value="stuInfo.tabStudents.FStudentEmail"/></td>
        </tr>
   </table>
   <hr align="center" width="80%"/>
</div>
</body>
</html>
