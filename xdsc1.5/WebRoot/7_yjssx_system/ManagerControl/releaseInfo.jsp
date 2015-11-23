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

   <table width="90%" border="0" style="margin-top: 100px;background-image: url('<%=basePath %>7_yjssx_system/SubSystemImage/ddown01[1].gif')">
      <tr>
        <td width="90%" height="26"><div align="center">发布${typeName }信息</div></td>
      </tr>
   </table>
   <table width="90%" >
   	  <tr>
   	  	<td align="left">
		   <img src="<%=basePath %>7_yjssx_system/SubSystemImage/back.png" width="15" height="15"/>
		   <a href="<%=basePath %>yjssxAdmin/AdminReleaseFirstPageInfo!showInfo.action?type=${type }"><strong>返回</strong></a>
   	 	</td>
   	  </tr>
   </table>
   <hr align="center" width="90%"/>
     <s:form action="AdminReleaseFirstPageInfo!saveInfo.action" namespace="/yjssxAdmin" enctype="multipart/form-data">
       <input type="hidden" name="infoType" value="${type }"/>
	   <table width="90%" border="1" style="border-collapse: collapse;">
	      <tr>
	        <td width="100"><div align="right"><span class="STYLE19"><strong>标题：</strong></span></div></td>
	         <td>
	          <div align="left">
	            <input name="releaseInfo.FInfoTitle" type="text"/>
	           </div></td>
	          <td height="36"><div align="right"><span class="STYLE19"><strong>发布日期：</strong></span></div></td>
		      <td><div align="left">
		       <input readonly="readonly" type="text" name="releaseInfo.FInfoStartTime" id="date1" class="calendarFocus"/>
		      </div></td>
	      </tr>
	      <tr>
	          <td><div align="right"><span class="STYLE19"><strong>相关附件：</strong></span></div></td>
		      <td colspan="3"><div align="left">
		        <input type="file" name="uploadFile" />
		      </div></td>
	      </tr>
	      <tr>
		        <td class="STYLE19"><div align="right"><strong>信息详情：</strong></div></td>
		      <td colspan="3"><div align="left">
               <FCK:editor instanceName="releaseInfo.FInfoContet" basePath="/fckeditor" value=" " width="100%" height="300" toolbarSet="mytools1"></FCK:editor></div></td>
	      </tr>
	      <tr>
		      <td >
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
