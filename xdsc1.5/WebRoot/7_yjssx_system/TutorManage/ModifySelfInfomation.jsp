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
   <img src="<%=basePath %>7_yjssx_system/SubSystemImage/selfInfo.png" height="75"/>
   <table width="90%" border="0" style="margin-top: 20px;background-image: url('<%=basePath %>7_yjssx_system/SubSystemImage/ddown01[1].gif')">
      <tr>
        <td width="90%" height="26"><div align="center">修改个人信息</div></td>
      </tr>
   </table>
   <hr align="center" width="90%"/>
<s:form  action="TutorSelfInfo!modifyselfInfo.action" namespace="/yjssxTutor">
    <input name="modifyInfo.FTeacherNumber" value="${teacherInfo.FTeacherNumber}" type="hidden" size="30"  height="25"/>
	<table width="90%" border="1" style="border-collapse: collapse; height: 200px;" bordercolor="#CCCCFF" height="541" >
	  <tr>
	    <td width="70"><div align="left">姓名：</div></td>
	    <td><div align="left"><span class="STYLE3">
	      <input name="modifyInfo.FTeacherName" value="${teacherInfo.FTeacherName}"type="text" size="30"  height="25"/>
	    </span></div></td>
	    <td><div align="left">姓别：</div></td>
	    <td><div align="left">
	      <select name="modifyInfo.FTeacherSex">
	        <option>男</option>
	        <option>女</option>
	      </select>
	    </div></td>
	  </tr>
	  <tr>
	    <td><div align="left">出生日期：</div></td>
	    <td><div align="left">
	      <input readonly="readonly" type="text" name="modifyInfo.FTeacherBirthday" id="date1" size="30" class="calendarFocus"/>
	    </div></td>
		<td><div align="left">邮箱：</div></td>
	    <td><div align="left"><span class="STYLE3">
	      <input name="modifyInfo.FTeacherEmail" value="${teacherInfo.FTeacherEmail }" type="text" size="30"  height="25"/>
	    </span></div></td>
	  </tr>
	  <tr>
	    <td>
	    	<div align="left">办公电话：</div>
	    </td>
	    <td><div align="left"><span class="STYLE3">
	      <input name="modifyInfo.FTeacherPhone" value="${teacherInfo.FTeacherPhone }" type="text" size="30"  height="25"/>
	    </span></div></td>
		<td><div align="left">办公地址：</div></td>
	    <td><div align="left"><span class="STYLE3">
	      <input name="modifyInfo.FTeacherWorkPlace" value="${teacherInfo.FTeacherWorkPlace }" type="text" size="30"  height="25"/>
	    </span></div></td>
	  </tr>
	  <tr>
	    <td><div align="left">手机<strong>：</strong></div></td>
	    <td><div align="left"><span class="STYLE3">
	      <input name="modifyInfo.FTeacherTel" value="${teacherInfo.FTeacherTel }" type="text" size="30"  height="25"/>
	    </span></div></td>
		<td><div align="left">职称：</div></td>
	    <td><div align="left"><span class="STYLE3">
	      <input name="modifyInfo.FTeacherZhiCheng" value="${teacherInfo.FTeacherZhiCheng }"  type="text" size="30"  height="25"/>
	    </span></div></td>
	  </tr>
	  <tr>
	    <td><div align="left">职位：&nbsp;</div></td>
	    <td><div align="left"><span class="STYLE3">
	      <select name="modifyInfo.FTeacherPosition" >
	        <option>硕导</option>
	        <option>博导</option>
	      </select>
	    </span></div></td>
		<td><div align="left"></div></td>
	    <td><div align="left"><span class="STYLE3">
	      
	    </span></div></td>
	  </tr>
	</table>
	 <table width="90%" border="1" style="border-collapse: collapse; height: 685px;" bordercolor="#CCCCFF" height="541">
	  <tr>
	    <td height="207" width="70"><div align="left">研究领域: </div></td>
	    <td><div align="left"><span class="STYLE3">
	      <FCK:editor instanceName="modifyInfo.FTeacherResearch" basePath="/fckeditor" value=" ${teacherInfo.FTeacherResearch }" width="100%" height="400" toolbarSet="mytools1"></FCK:editor>
	    </span></div></td>
	  </tr>
	  <tr>
	    <td height="214" width="70"><div align="left">研究成果: </div></td>
	    <td><div align="left"><span class="STYLE3">
	      <FCK:editor instanceName="modifyInfo.FTeacherAchieve" basePath="/fckeditor" value=" ${teacherInfo.FTeacherAchieve }" width="100%" height="400" toolbarSet="mytools1"></FCK:editor>
	    </span></div></td>
	  </tr>
	    <tr>
	    <td height="64"><span class="STYLE3"><label>
	        <input type="submit" name="Submit" value="提交" />	
	      </label>
	    </span></td>
	    <td></td>
	  </tr>
	</table>
</s:form>
</div>
</body>
</html>
