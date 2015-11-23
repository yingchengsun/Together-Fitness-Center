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
<script type="text/javascript" language="javascript" src="<%=basePath %>js/jquery-1.4.2.js"></script>
<script type="text/javascript" src="<%=basePath %>js/jquery-calendar.js"></script>
<link rel="stylesheet" type="text/css" href="<%=basePath %>js/jquery-calendar.css" />
<script type="text/javascript" charset="utf-8">
  $(document).ready(function(){
     $("#date1").date();
  })
 </script>
</head>

<body background="../SubSystemImage/Background.png">
<div align="center">
   <table width="90%" border="0" style="margin-top: 100px;background-image: url('<%=basePath %>7_yjssx_system/SubSystemImage/ddown01[1].gif')">
      <tr>
        <td width="90%" height="26"><div align="center">添加导师信息</div></td>
      </tr>
   </table>
   <hr align="center" width="90%"/>
<s:form  action="yjssxAdmin/AdminTutorInfoManage!addNewTutorInfo.action" method="post">
	<table width="90%"style="border-collapse: collapse; height: 200px;" bordercolor="#CCCCFF" height="541">
	  <tr style="background-color:#CCCCCC">
	    <td width="100"><div align="left"><strong>用户名：</strong></div></td> 
	    <td><div align="left"><span class="STYLE3">
	      <input name="userName" type="text" size="30"  height="25"/> <font color="#ff0000">*</font> 
	    </span></div></td>
	    <td><div align="right"><strong>初始密码：</strong></div></td>
	    <td><div align="left">
	      <input name="password" type="text" size="30"  height="25"/> <font color="#ff0000">*</font> 
	    </div></td>
	  </tr>
	  <tr>
	    <td><div align="left"><strong>姓名：</strong></div></td>
	    <td><div align="left"><span class="STYLE3">
	      <input name="newTeacher.FTeacherName" type="text" size="30"  height="25"/>
	    </span></div></td>
	    <td><div align="right"><strong>姓别：</strong></div></td>
	    <td><div align="left">
	      <select name="newTeacher.FTeacherSex">
	        <option>男</option>
	        <option>女</option>
	      </select>
	    </div></td>
	  </tr>
	  <tr style="background-color:#CCCCCC">
	    <td><div align="left"><strong>出生日期：</strong></div></td>
	    <td><div align="left">
	      <input readonly="readonly" type="text" name="newTeacher.FTeacherBirthday" size="30" id="date1" class="calendarFocus"/>
	    </div></td>
		<td><div align="right"><strong>邮箱：</strong></div></td>
	    <td><div align="left"><span class="STYLE3">
	      <input name="newTeacher.FTeacherEmail" type="text" size="30"  height="25"/>
	    </span></div></td>
	  </tr>
	  <tr>
	    <td>
	    	<div align="left"><strong>办公电话：</strong></div>
	    </td>
	    <td><div align="left"><span class="STYLE3">
	      <input name="newTeacher.FTeacherPhone" type="text" size="30"  height="25"/>
	    </span></div></td>
		<td><div align="right"><strong>办公地址：</strong></div></td>
	    <td><div align="left"><span class="STYLE3">
	      <input name="newTeacher.FTeacherWorkPlace" type="text" size="30"  height="25"/>
	    </span></div></td>
	  </tr>
	  <tr style="background-color:#CCCCCC">
	    <td><div align="left"><strong>手机:</strong></div></td>
	    <td><div align="left"><span class="STYLE3">
	      <input name="newTeacher.FTeacherTel" type="text" size="30"  height="25"/>
	    </span></div></td>
		<td><div align="right"><strong>职称：</strong></div></td>
	    <td><div align="left"><span class="STYLE3">
	      <input name="newTeacher.FTeacherZhiCheng" type="text" size="30"  height="25"/>
	    </span></div></td>
	  </tr>
	  <tr>
	    <td><div align="left"><strong>职位：</strong>&nbsp;</div></td>
	    <td><div align="left"><span class="STYLE3">
	      <select name="newTeacher.FTeacherPosition" >
	        <option>硕导</option>
	        <option>博导</option>
	      </select>
	    </span></div></td>
		<td><div align="right"><strong>研究领域:</strong></div></td>
	    <td><div align="left"><span class="STYLE3">
	       <input name="newTeacher.FTeacherResearch" type="text" size="30"  height="25"/>
	    </span></div></td>
	  </tr>
	</table>
	 <table width="90%" border="1" style="border-collapse: collapse;" bordercolor="#CCCCFF">
	  <tr>
	    <td width="100"><div align="left"><strong>研究成果: </strong></div></td>
	    <td><div align="left">
	      <FCK:editor instanceName="newTeacher.FTeacherAchieve" basePath="/fckeditor" value=" " width="100%" height="300" toolbarSet="mytools1"></FCK:editor>
	    </div></td>
	  </tr>
	    <tr>
	    <td><span class="STYLE3"><label>
	        <input type="submit" name="Submit" value="提交" />	
	      </label>
	    </span></td>
	  </tr>
	</table>
</s:form>
</div>
</body>
</html>
