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
<script language="JavaScript" type="text/javascript" src="<%=basePath %>js/FormValid.js"></script>
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
        <td width="90%" height="26"><div align="center">修改招聘信息</div></td>
      </tr>
   </table>
   <hr align="center" width="90%" size="2" color="#990033"/>
     <s:form  id="form1" name="form1"  action="CompanyModifyZhaoPin!modifyInfo.action" namespace="/yjssxCompany" enctype="multipart/form-data">
       <input type="hidden" name="InfoId" value="<s:property value="updateInfo.FInfoId"/>"/>
	   <table width="90%" border="1" style="border-collapse: collapse; height: 685px;" bordercolor="#CCCCFF" height="575" background="../SubSystemImage/bg.gif">
	      <tr>
	        <td width="100" height="48"><div align="right"><span class="STYLE19">标题：</span></div></td>
	         <td >
	          <div align="left">
	            <input name="Title" type="text" value="<s:property value="updateInfo.FInfoTitle"/>" valid="required|limit" min="2" max="200"  errmsg="标题不能为空|标题太长"/>
	           </div></td>
	         <td height="48"><div align="right"><span class="STYLE19">发布日期：</span></div></td>
	         <td >
	          <div align="left">
	            <input type="text" name="ReleaseDate" id="date1" class="calendarFocus" valid="required" errmsg="日期不能为空"/>
	           </div></td>
	       </tr>
	      <tr>
	          <td height="36"><div align="right"><span class="STYLE19">上传简历模板：</span></div></td>
		      <td colspan="3"><div align="left">
		        <input type="file" name="uploadFile" valid="required" errmsg="请上传简历模板" />
		      </div></td>
	      </tr>
	      <tr>
		        <td height="428" class="STYLE19"><div align="right">修改信息：</div></td>
		      <td colspan="3"><div align="left">
               <FCK:editor instanceName="Contet" basePath="/fckeditor" value=" ${updateInfo.FInfoContet}" width="100%" height="500" toolbarSet="mytools1"></FCK:editor></div></td>
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
