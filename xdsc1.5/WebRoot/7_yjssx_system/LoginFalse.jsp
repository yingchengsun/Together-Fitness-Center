<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <link href="<%=basePath %>css.css" rel="stylesheet" type="text/css" />
    <title>My JSP 'noNoticeRightNow.jsp' starting page</title>

  </head>
  
  <body background="<%=basePath %>7_yjssx_system/SubSystemImage/Background.png">
  	<div align="center">
  	<table width="80%" border="0" >
      <tr>
        <td width="80%" height="60">&nbsp;<div align="center"></div></td>
      </tr>
    </table>
    <table width="30%" >
   	  <tr>
   	  	<td align="left">
		   <img src="<%=basePath %>7_yjssx_system/SubSystemImage/back.png" width="15" height="15"/>
		   <a href="<%=basePath %>yjssxCommon/YjssxFirstPage!showFirstPageInfo.action"><strong>返回</strong></a>
   	 	</td>
   	  </tr>
   </table>
  	<table width="30%">
  		<tr style="background-image: url('<%=basePath %>7_yjssx_system/SubSystemImage/titlebg.gif')">
  			<td></td>
  			<td height="15" width="60%" align="left"><strong>登陆失败!</strong></td>
  		</tr>
  		<tr>
  			<td>
  			<img src="<%=basePath %>7_yjssx_system/SubSystemImage/404.gif" />
  			</td>
  			<td>登陆失败！用户名或密码错误！</td>
  		</tr>
  		<tr style="background-image: url('<%=basePath %>7_yjssx_system/SubSystemImage/titlebg.gif')">
  			<td height="15"></td>
  			<td></td>
  		</tr>
  	</table>
  </div>
  </body>
</html>
