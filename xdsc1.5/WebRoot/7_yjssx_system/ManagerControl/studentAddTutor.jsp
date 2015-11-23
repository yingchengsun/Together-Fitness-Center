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
        <td width="100%" height="26"><div align="center">研究生添加导师</div></td>
      </tr>
   </table>
   <hr align="center" width="100%"/>
   <table width="100%"style="border-collapse:collapse">
	  <tr style="background-image: url('<%=basePath %>7_yjssx_system/SubSystemImage/titlebg.gif')">
		<td><div align="center"></div><br /></td>
	  </tr>	  
	  <tr>
	    <td width="15%" scope="col"><div align="center">
			<form action="yjssxAdmin/AdminStudentInfoManage!studentAddTutorSearch.action" method="post">
			研究生姓名：	<input type="text" name="stuName" />&nbsp;&nbsp;&nbsp;
			导师：	
			<select name="tutorName">
	  	      <option value="">----请选择-----</option>
	  	      <s:iterator value="teacherList">
		      <option value="${FTeacherName }">${FTeacherName }</option>
		      </s:iterator>
	        </select><p>
				<input  type="submit" value="搜索"/>
			</form>
		</div></td>
	  </tr>	 
	  <tr style="background-image: url('<%=basePath %>7_yjssx_system/SubSystemImage/titlebg.gif')">
		<td><div align="center"></div><br /></td>
	  </tr>	 
  </table>
</div> 
</body>
</html>
