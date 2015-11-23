<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
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
	<script type="text/javascript">
    	function setToNull(){
    		var objs = document.getElementById("stuName");
    		objs.value="";
    	}
    </script>

</head>

<body background="<%=basePath %>7_yjssx_system/SubSystemImage/Background.png">
<div align="center">
   <img src="<%=basePath %>7_yjssx_system/SubSystemImage/yingpin.png" height="70" />
  <fieldset>
       <legend><img src="<%=basePath %>7_yjssx_system/SubSystemImage/search.png" height="60"/></legend>
	   <table width="100%" border="0" style="border-collapse:collapse" >
		  <tr style="background-image: url('<%=basePath %>7_yjssx_system/SubSystemImage/titlebg.gif')">
			<td><div align="center"><strong>发 送 通 知</strong></div><br /></td>
		  </tr>	
		  <tr>
		    <td width="15%" scope="col"><div align="center">
				<form action="yjssxAdmin/AdminReleaseNotice!NoticeToRoles.action" method="post">
					<input type="radio" name="type" value="研究生" checked="checked"/>研究生
					<input type="radio" name="type" value="导师"/>导师
					<input type="radio" name="type" value="企业"/>企业<p>
					<input  type="submit" value="搜索" />
				</form>
			</div></td>
		  </tr>
	  </table>
  </fieldset>
</div> 
</body>
</html>
