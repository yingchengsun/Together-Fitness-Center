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
<title>�ޱ����ĵ�</title>
<link href="<%=basePath %>css.css" rel="stylesheet" type="text/css" />
</head>

<body background="../SubSystemImage/Background.png">
<div align="center" >

   <table width="100%" border="0" style="margin-top: 100px;background-image: url('<%=basePath %>7_yjssx_system/SubSystemImage/ddown01[1].gif')">
      <tr>
        <td width="100%" height="26"><div align="center">${detailInfo.FInfoTitle }</div></td>
      </tr>
   </table>
   <table width="100%" >
   	  <tr>
   	  	<td align="left">
		   <img src="<%=basePath %>7_yjssx_system/SubSystemImage/back.png" width="15" height="15"/>
		   <a href="<%=basePath %>yjssxCompany/CompanyReceiveNotice!findAllNotice.action"><strong>����</strong></a>
   	 	</td>
   	  </tr>
   </table>
   <hr align="center" width="100%" size="2" color="#990033"/>
  <table width="100%"border="1" style="border-collapse:collapse" bordercolor="#999999" background="../SubSystemImage/bg.gif">
    <tr class="SubMenu" style="background-color:#CCCCCC">
        <td align="right">
           ��������:<fmt:formatDate value="${detailInfo.FInfoStartTime}" type="date" dateStyle="medium"/>
        </td >
    </tr>
    <tr>
     <td>
      ${detailInfo.FInfoContet}
     </td>
    </tr>
  </table>
</div>
</body>
</html>
