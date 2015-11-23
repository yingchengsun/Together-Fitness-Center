<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
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
   <img src="<%=basePath %>7_yjssx_system/SubSystemImage/gif-0072.gif" height="75" />
   <table width="100%" border="0" style="margin-top: 20px;background-image: url('<%=basePath %>7_yjssx_system/SubSystemImage/ddown01[1].gif')">
      <tr>
        <td width="100%" height="26"><div align="center">研究生添加企业</div></td>
      </tr>
   </table>
   <hr align="center" width="100%" size="2" color="#990033"/>
   <table width="100%" border="1" style="border-collapse:collapse">
	  <tr style="background-image: url('<%=basePath %>7_yjssx_system/SubSystemImage/titlebg.gif')">
		<td height="20"></td>
	  </tr>	  
	  <tr>
	    <td width="15%" scope="col"><div align="center">
	    <br/>
			<form action="yjssxAdmin/AdminStudentInfoManage!studentAddCompanySearch.action" method="post">
			研究生姓名：	<input type="text" name="stuName" />&nbsp;&nbsp;&nbsp;
			企业名称：	
			<select name="companyName">
	  	      <option value="">----请选择-----</option>
	  	      <s:iterator value="companyList">
		      <option value="${FCompanyName }">${FCompanyName }</option>
		      </s:iterator>
	        </select>
             <p>
				<input  type="submit" value="搜索"/>
			</form>
		</div></td>
	  </tr>	 
	  <tr style="background-image: url('<%=basePath %>7_yjssx_system/SubSystemImage/titlebg.gif')">
		<td height="20"></td>
	  </tr>	 
  </table>
</div> 
</body>
</html>
