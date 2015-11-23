<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@taglib uri="http://java.fckeditor.net" prefix="FCK" %>
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
<style type="text/css">
<!--
.STYLE26 {font-size: 14px}
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

<body background="../SubSystemImage/Background.png">
   <div align="center">
   <table width="90%" border="0" style="margin-top: 100px;background-image: url('<%=basePath %>7_yjssx_system/SubSystemImage/ddown01[1].gif')">
      <tr>
        <td width="90%" height="26"><div align="center">发送通知</div></td>
      </tr>
   </table>
   <table width="90%" >
   	  <tr>
   	  	<td align="left">
		   <img src="<%=basePath %>7_yjssx_system/SubSystemImage/back.png" width="15" height="15"/>
		   <a href="<%=basePath %>yjssxAdmin/AdminReleaseNotice!releaseNotice.action"><strong>返回</strong></a>
   	 	</td>
   	  </tr>
   </table>
	  <form action="yjssxAdmin/AdminReleaseNotice!saveNotice.action"  method="post" enctype="multipart/form-data">
	  	  <input type="hidden" name="type" value="${type}"/><br/>
		  <s:iterator value="noticeId" var="id">
		  	<input type="hidden" name="noticeId" value="${id}"/>
		  </s:iterator>
	      <table width="90%" border="1" style="border-collapse:collapse" bordercolor="#999999">
	        <tr>
	          <td width="100"><div align="left">标题：&nbsp;</div></td>
	          <td ><div align="left">
	              <input type="text" height="25" name="notice.FInfoTitle"/>
	          </div></td>
	          <td><div align="left">发布日期：&nbsp;</div></td>
	          <td><div align="left">
	              <input readonly="readonly" type="text" name="notice.FInfoStartTime" id="date1" class="calendarFocus"/>
	          </div></td>
	        </tr>
	        <tr>
	          <td><div align="left">相关资料：&nbsp;</div></td>
	          <td colspan="3"><div align="left">
	              <input type="file" name="uploadFile"/>
	          </div></td>
	        </tr>
	        <tr>
	          <td><div align="left">内容：</div></td>
	          <td colspan="3"><div align="left">
	              <FCK:editor instanceName="notice.FInfoContet" basePath="/fckeditor" value=" " width="100%" height="300" toolbarSet="mytools1"></FCK:editor>
	          </div></td>
	        </tr>
	        <tr>
	          <td><div align="left">
	              <input type="submit" name="Submit2" value="发送" />
	            &nbsp;
	          </div></td>
	          <td><div align="left"></div></td>
	        </tr>
	      </table>
     </form>
   </div>
</body>
</html>
