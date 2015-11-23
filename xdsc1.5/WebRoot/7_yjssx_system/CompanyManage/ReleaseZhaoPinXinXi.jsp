<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>"/>
<title>无标题文档</title>
<link href="<%=basePath %>css.css" rel="stylesheet" type="text/css" />

<style type="text/css">
<!--
.STYLE2 {font-size: 18px}
.STYLE4 {font-size: 18px; font-weight: bold; }
.STYLE22 {color: #FFFFFF}
.STYLE23 {font-size: 16px}
-->
</style>
<script type="text/javascript" language="javascript" src="<%=basePath %>js/jquery-1.4.2.js"></script>
<script type="text/javascript" src="<%=basePath %>js/jquery-calendar.js"></script>
<link rel="stylesheet" type="text/css" href="<%=basePath %>js/jquery-calendar.css" />
<script type="text/javascript" charset="utf-8">
  $(document).ready(function(){
     $("#date1").date();
  })
 </script>
</head>

<body background="<%=basePath %>SubSystemImage/Background.png">
<div align="center">
   <img src="<%=basePath %>7_yjssx_system/SubSystemImage/manage5.png" height="75"/>
   <table width="90%" border="0" style="margin-top: 20px;background-image: url('<%=basePath %>7_yjssx_system/SubSystemImage/ddown01[1].gif')">
      <tr>
        <td width="90%" height="26"><div align="center">发布招聘信息</div></td>
      </tr>
   </table>
   <hr align="center" width="90%"/>
     <s:form action="CompanyReleaseZhaoPin!ReleaseInfo.action" namespace="/yjssxCompany" enctype="multipart/form-data">
	   <table width="90%" border="1" style="border-collapse: collapse;" bordercolor="#CCCCFF" background="../SubSystemImage/bg.gif">
	      <tr>
	        <td width="100"><div align="right"><span class="STYLE19">标题：</span></div></td>
	         <td>
	          <div align="left">
	            <input name="releaseInfo.FInfoTitle" type="text"/>
	           </div></td>
	          <td><div align="right"><span class="STYLE19">发布日期：</span></div></td>
		      <td><div align="left">
		       <input readonly="readonly" type="text" name="releaseInfo.FInfoStartTime" id="date1" class="calendarFocus"/>
		      </div></td>
	       </tr>
	      <tr>
	          <td><div align="right"><span class="STYLE19">上传简历模板：</span></div></td>
		      <td colspan="3"><div align="left">
		        <input type="file" name="uploadFile" size="40"/>
		      </div></td>
	      </tr>
	      <tr>
		        <td class="STYLE19"><div align="right">招聘信息：</div></td>
		      <td colspan="3"><div align="left">
               <FCK:editor instanceName="releaseInfo.FInfoContet" basePath="/fckeditor" value=" " width="100%" height="300" toolbarSet="mytools1"></FCK:editor></div></td>
	      </tr>
	      <tr>
		      <td>
		          <div align="left"> 
		            <input type="submit"value="提交" /> 
		          </div>
			  </td>
	    </tr>
	  </table>
	</s:form>
</div>
</body>
</html>
