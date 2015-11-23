<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>My JSP 'index.jsp' starting page</title>
    <link href="<%=basePath %>css.css" rel="stylesheet" type="text/css" />
</head>

<body background="../SubSystemImage/Background.png">
<div align="center">

   <table width="85%" border="0" style="background-image: url('<%=basePath %>7_yjssx_system/SubSystemImage/titlebg.gif')">
      <tr>
        <td width="80%" height="26"><div align="center">修改个人信息</div></td>
      </tr>
   </table>
   <hr align="center" width="85%"/>
<s:form  action="PostgraudateSelfInfo!ModifySelfInfo.action" namespace="/yjssxStudent">
	<table width="85%" border="1" style="border-collapse: collapse; height: 200px;" bordercolor="#CCCCFF" height="541">
	  <tr>
	    <td><div align="left">姓名：</div></td>
	    <td><div align="left"><span class="STYLE3">
	      <input name="name" value="${postgraduateSelfInfo.tabStudents.FStudentName}"type="text" size="30"  height="25" disabled="disabled"/>
	    </span></div></td>
	    <td><div align="left">姓别：</div></td>
	    <td><div align="left">
	      <input name="sex" value="${postgraduateSelfInfo.tabStudents.FStudentSex}"type="text" size="30"  height="25" disabled="disabled"/>
	    </div></td>
	  </tr>
	  <tr>
	    <td><div align="left">出生日期：</div></td>
	    <td><div align="left">
	      <input name="sex" value="${postgraduateSelfInfo.tabStudents.FStudentBirthday}"type="text" size="30"  height="25" disabled="disabled"/>
	    </div></td>
		<td><div align="left">邮箱：</div></td>
	    <td><div align="left"><span class="STYLE3">
	      <input name="email" value="${postgraduateSelfInfo.tabStudents.FStudentEmail }" type="text" size="30"  height="25"/>
	    </span></div></td>
	  </tr>
	  <tr>
	    <td><div align="left">手机<strong>：</strong></div></td>
	    <td><div align="left"><span class="STYLE3">
	      <input name="phone" value="${postgraduateSelfInfo.tabStudents.FStudentTel }" type="text" size="30"  height="25"/>
	    </span></div></td>
		<td><div align="left">本科学校：</div></td>
	    <td><div align="left"><span class="STYLE3">
	      <input name="exitSchool" value="${postgraduateSelfInfo.FStudentExSchool }"  type="text" size="30"  height="25" disabled="disabled"/>
	    </span></div></td>
	  </tr>
	  <tr>
	    <td height="64"><span class="STYLE3"><label>
	        <input type="submit" name="Submit" value="提交" />	
	      </label>
	    </span>
	   </td>
	   <td></td>
	   <td></td>
	   <td></td>
	  </tr>
	</table>
</s:form>
</div>
</body>
</html>
