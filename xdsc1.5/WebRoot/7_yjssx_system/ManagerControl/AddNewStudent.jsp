<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link href="<%=basePath %>css.css" rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>无标题文档</title>
<script type="text/javascript" language="javascript" src="<%=basePath %>js/jquery-1.4.2.js"></script>
<script type="text/javascript" src="<%=basePath %>js/jquery-calendar.js"></script>
<link rel="stylesheet" type="text/css" href="<%=basePath %>js/jquery-calendar.css" />
<script type="text/javascript" charset="utf-8">
  $(document).ready(function(){
     $("#date1").date();
     $("#date2").date();
  })
 </script>
</head>

<body background="../SubSystemImage/Background.png">
  <div align="center">

   <table width="90%" border="0"  style="margin-top: 100px;background-image: url('<%=basePath %>7_yjssx_system/SubSystemImage/ddown01[1].gif')">
      <tr>
        <td width="90%" height="26"><div align="center">添加研究生</div></td>
      </tr>
   </table>
   <hr align="center" width="90%"/>
   <form action="yjssxAdmin/AdminStudentInfoManage!addNewStudent.action" method="post">
	 <table width="90%" style="border-collapse:collapse">
	  <tr>
	    <td height="47"><div align="left"><strong>用户名：</strong></div></td>
	    <td><div align="left"><span class="STYLE3">
	      <input name="userName" type="text"/><font color="#ff0000">&nbsp;*</font> 
	    </span></div></td>
	    <td height="47"><div align="left"><strong>初始密码：</strong></div></td>
	    <td><div align="left"><span class="STYLE3">
	      <input name="password" type="text"/><font color="#ff0000">&nbsp;*</font> 
	    </span></div></td>
	  </tr>
	  <tr  style="background-color:#CCCCCC">
	    <td height="47"><div align="left"><strong>姓名：</strong></div></td>
	    <td><div align="left"><span class="STYLE3">
	      <input name="stuInfo.FStudentName" type="text"/>
	    </span></div></td>
	    <td height="47"><div align="left"><strong>籍贯：</strong></div></td>
	    <td><div align="left"><span class="STYLE3">
	      <input name="stuInfo.FStudentNation" type="text"/>
	    </span></div></td>
	  </tr>
	  <tr>
	    <td height="42"><div align="left"><strong>姓别：</strong></div></td>
	    <td><div align="left">
	      <select name="stuInfo.FStudentSex" >
	        <option value="男">男</option>
	        <option value="女">女</option>
	      </select>
	    </div></td>
	    <td height="47"><div align="left"><strong>入校时间：</strong></div></td>
	    <td><div align="left"><span class="STYLE3">
	      <input readonly="readonly" type="text" name="stuInfo.FStudentRegData" id="date1" class="calendarFocus"/>
	    </span></div></td>
	  </tr>
	  <tr style="background-color:#CCCCCC">
	    <td height="37"><div align="left"><strong>出生日期：</strong></div></td>
	    <td><div align="left"><span class="STYLE3">
	     <input readonly="readonly" type="text" name="stuInfo.FStudentBirthday" id="date2" class="calendarFocus"/>
	    </span></div></td>
	    <td height="47"><div align="left"><strong>邮箱：</strong></div></td>
	    <td><div align="left"><span class="STYLE3">
	      <input name="stuInfo.FStudentEmail" type="text"/>
	    </span></div></td>
	  </tr>
	  <tr>
	    <td height="43"><div align="left"><strong>宿舍地址：</strong></div></td>
	    <td><div align="left"><span class="STYLE3">
	      <input name="stuInfo.FStudentDormitory" type="text"/>
	    </span></div></td>
	    <td height="47"><div align="left"><strong>电话：</strong></div></td>
	    <td><div align="left"><span class="STYLE3">
	      <input name="stuInfo.FStudentTel" type="text"/>
	    </span></div></td>
	  </tr>
	  <tr style="background-color:#CCCCCC">
	    <td height="44"><div align="left"><strong>硕士类型:</strong></div></td>
	    <td><div align="left">
	      <select name="newStudent.FType" >
	        <option value="单证">单证</option>
	        <option value="双证">双证</option>
	      </select>
	    </div></td>
	    <td height="47"><div align="left"><strong>本科学校：</strong></div></td>
	    <td><div align="left"><span class="STYLE3">
	      <input name="newStudent.FStudentExSchool" type="text" />
	    </span></div></td>
	  </tr>
	  <tr>
	    <td>
	    	<div align="left"><input type="submit" name="Submit" value="提交" /></div>
        </td>
	    <td></td>
	    <td></td>
	    <td></td>
	  </tr>
	</table>
  </form>
     <hr align="center" width="90%"/>
  </div>
</body>
</html>
