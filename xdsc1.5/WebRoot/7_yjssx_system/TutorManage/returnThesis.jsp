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
<script language="javascript" src="<%=basePath %>js/PopupCalendar.js"></script>
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

   <table width="100%" border="0" style="margin-top: 100px;background-image: url('<%=basePath %>7_yjssx_system/SubSystemImage/ddown01[1].gif')">
      <tr>
        <td width="100%" height="26"><div align="center">反馈论文报告</div></td>
      </tr>
   </table>
	  <form action="yjssxTutor/TutorReturnThesis!uploadThesis.action" method="post" enctype="multipart/form-data">
	  	  <input type="hidden" name="stuId" value="${stuId }"/>
	      <table width="100%" height="418" border="1" style="border-collapse:collapse" bordercolor="#999999">
	        <tr>
	          <td width="134" height="55"><div align="left">标题：&nbsp;</div></td>
	          <td width="606"><div align="left">
	              <input type="text" height="25" name="retThesis.FThesisName"/>
	          </div></td>
	        </tr>
	        <tr>
	          <td width="100%" height="55"><div align="left">发送日期：&nbsp;</div></td>
	          <td width="606"><div align="left">
	              <input readonly="readonly" type="text" name="retThesis.FDate" id="date1" class="calendarFocus"/>
	          </div></td>
	        </tr>
	        <tr>
	          <td width="134" height="55"><div align="left">论文上传：&nbsp;</div></td>
	          <td width="606"><div align="left">
	              <input type="file" name="uploadFile"/>
	          </div></td>
	        </tr>
	        <tr>
	          <td height="322"><div align="left">备注：</div></td>
	          <td><div align="left">
	              <FCK:editor instanceName="retThesis.FComment" basePath="/fckeditor" value=" " width="100%" height="500" toolbarSet="mytools1"></FCK:editor>
	          </div></td>
	        </tr>
	        <tr>
	          <td height="31"><div align="left">
	              <input type="submit" value="发送" />
	          </div></td>
	          <td><div align="left"></div></td>
	        </tr>
	      </table>
     </form>
   </div>
</body>
</html>
