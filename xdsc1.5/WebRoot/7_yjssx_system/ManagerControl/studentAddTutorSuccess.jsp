<%@ page contentType="text/html; charset=UTF-8" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>无标题文档</title>
<link href="<%=basePath %>css.css" rel="stylesheet" type="text/css" />
   <script type="text/javascript">
    	function selectAll(){
    		 var objs = document.getElementsByTagName("input");
    		 for(var i=0;i<objs.length;i++){
    		 	 if(objs[i].type.toLowerCase() == "checkbox" )            
                    objs[i].checked = true;
    		 }
    		 
    	}
    	
    	function unSelectAll(){
    		var objs = document.getElementsByTagName("input");
    		 for(var i=0;i<objs.length;i++){
    		 	 if(objs[i].type .toLowerCase()== "checkbox" )            
                    objs[i].checked = false;
    		}
    	}
    </script>
</head>

<body background="../SubSystemImage/Background.png">
<div align="center">

   <table width="80%" border="0" style="margin-top: 100px;background-image: url('<%=basePath %>7_yjssx_system/SubSystemImage/ddown01[1].gif')">
      <tr>
        <td width="80%" height="26"><div align="center">添加成功</div></td>
      </tr>
   </table>
   <hr align="center" width="80%" size="2" color="#990033"/><div align="center"> 
   <font size="3">导师</font> 
  </div><form action="yjssxAdmin/AdminReleaseNotice!noticeTo.action" method="post">
	<table width="80%" height="69" border="1" style="border-collapse:collapse" bordercolor="#999999"
	   background="../SubSystemImage/bg.gif">
	    <tr style="background-color:#CCCCCC">
	      <td width="139"><div align="center"><strong>导师姓名</strong></div></td>
	      <td width="139"><div align="center"><strong>导师电话</strong></div></td>
	      <td width="139"><div align="center"><strong>新增研究生姓名</strong></div></td>
	      <td width="216"><div align="center"><strong>查看详情</strong></div></td>
	    </tr>
	    <tr>
	      <td align="center"><img src="<%=basePath %>7_yjssx_system/SubSystemImage/xuesheng.gif" />&nbsp;${tutorInfo.FTeacherName }</td>
	      <td align="center"><img src="<%=basePath %>7_yjssx_system/SubSystemImage/xuesheng.gif" />&nbsp;${tutorInfo.FTeacherTel }</td>
	       <td align="center">${studentInfo.tabStudents.FStudentName }</td>
	      <td align="center"><div align="center">
	      <img src="<%=basePath %>7_yjssx_system/SubSystemImage/edit_profile.gif" height="15"/>
	      <a href="<%=basePath %>yjssxCommon/CommonOperation!findTutorInfo.action?tutorId=${tutorInfo.FTeacherNumber}" class="STYLE5">点击查看基本信息</a></div></td>    
	    </tr>
	</table>
	<p align="center">	
	<font size="3">研究生</font><p>
	<table width="80%" height="69" border="1" style="border-collapse:collapse" bordercolor="#999999"
	   background="../SubSystemImage/bg.gif">
	     <tr style="background-color:#CCCCCC">
	      <td width="139"><div align="center"><strong>研究生名称</strong></div></td>
	      <td width="139"><div align="center"><strong>研究生电话</strong></div></td>
	      <td width="139"><div align="center"><strong>导师姓名</strong></div></td>
	      <td width="216"><div align="center"><strong>查看详情</strong></div></td>
	    </tr>
	    <tr>
	      <td align="center"><img src="<%=basePath %>7_yjssx_system/SubSystemImage/xuesheng.gif" />&nbsp;${studentInfo.tabStudents.FStudentName }</td>
	      <td align="center"><img src="<%=basePath %>7_yjssx_system/SubSystemImage/xuesheng.gif" />&nbsp;${studentInfo.tabStudents.FStudentTel }</td>
	      <td>${tutorInfo.FTeacherName  }</td>
	      <td align="center"><div align="center">
	      <img src="<%=basePath %>7_yjssx_system/SubSystemImage/edit_profile.gif" height="15"/>
	      <a href="<%=basePath %>yjssxCommon/CommonOperation!findStudentInfo.action?stuId=${studentInfo.FStudentNumber}" class="STYLE5">点击查看基本信息</a></div></td>    
	    </tr>
	    <tr style="background-color:#CCCCCC">
	      <td width="139"></td>
	      <td width="139"></td>
	      <td width="139"></td>
	      <td width="216"><</td>
	    </tr>
	</table> 
   </div>

</body>
</html>
