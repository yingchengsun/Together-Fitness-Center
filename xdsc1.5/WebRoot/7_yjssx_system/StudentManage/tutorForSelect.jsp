<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
		<title>请选择导师</title>		
	<link rel="stylesheet" type="text/css" href="css.css">
	<script language="javascript">
		function action(tutorname)
		{
			parent.window.returnValue=tutorname;
			window.close();
		}
	</script>

</head>

<body background="rP01.jpg">
	<div align="center">
	<h2>导师名单</h2>
	  <table width="80%"  border="0" style="border-collapse:collapse" bordercolor="#999999" background="../SubSystemImage/bg.gif"> 
		    <tr>
		      <td width="562" height="34">
		         <s:iterator value="allTutorInfo">
	                 <a class="LINK21" href="#" onclick="action('<s:property value="FTeacherName"/>&<s:property value="FTeacherNumber"/>')"><s:property value="FTeacherName"/></a> &nbsp;&nbsp;&nbsp;&nbsp; 
	             </s:iterator>
	          </td>
	        </tr>	      
        </table>
        <br><input type="button" value="关闭" onclick="window.close()">
    </div>
	</body>
</html>
