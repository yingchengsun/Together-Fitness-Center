<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
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

<body background="../SubSystemImage/Background.png">
<div align="center">
   <table width="90%" border="0" style="margin-top: 100px;background-image: url('<%=basePath %>7_yjssx_system/SubSystemImage/ddown01[1].gif')">
      <tr>
        <td width="90%" height="26"><div align="center">添加企业信息</div></td>
      </tr>
   </table>
   <hr align="center" width="90%"/>
   <s:form action="yjssxAdmin/AdminCompanyInfoManage!AddCompanyInfo.action" method="post">
	   <table width="90%" style="border-collapse:collapse">
	  		<tr>
			    <td width="133" height="29" align="center"><div align="left"><strong>用户名：</strong></div></td>
			    <td width="363" align="left"><div align="left"><input name="userName"  type="text"/></div></td>
			    <td width="129" align="center"><div align="left"><strong>初始密码：</strong></div></td>
			    <td width="318" align="left"><div align="left"><input name="password"  type="text" />
			      </div></td>
			  </tr>
			<tr  style="background-color:#CCCCCC">
			    <td width="133" height="29" align="center"><div align="left"><strong>企业名称：</strong></div></td>
			    <td width="363" align="left"><div align="left"><input name="companyInfo.FCompanyName"  type="text"/></div></td>
			    <td width="129" align="center"><div align="left"><strong>企业地址：</strong></div></td>
			    <td width="318" align="left"><div align="left"><input name="companyInfo.FAddress"  type="text" />
			      </div></td>
			  </tr>
			  <tr>
			    <td height="28" align="center"><div align="left"><strong>注册时间：</strong></div></td>
			    <td align="left"><div align="left"><input name="FCompanyEnrollTime" type="text"  id="date1" class="calendarFocus"/></div></td>
			    <td align="center"><div align="left"><strong>企业邮箱：</strong></div></td>
			    <td align="left"><div align="left"><input name="companyInfo.FEmailAddress" type="text" /></div></td>
			  </tr>
			  
			  <tr style="background-color:#CCCCCC">
			    <td height="30" align="center"> 
			      <div align="left"><strong>联系人：</strong></div></td>
			    <td align="left"><div align="left"><input name="FCompanyConnetPerson"  type="text" /></div></td>
			    <td align="center"><div align="left"><strong>联系电话：</strong></div></td>
			    <td align="left"><div align="left"><input name="companyInfo.FTelephone" type="text" /></div></td>
			  </tr>
	</table>
	 <table width="90%" border="0" style="border-collapse:collapse" bordercolor="#999999" 
	   background="../SubSystemImage/bg.gif">
	    <tr>
	      <td align="left"><div align="left"><strong>企业详情：</strong>
	      </div><br/>
	      <FCK:editor instanceName="companyInfo.FInformation" basePath="/fckeditor" value=" " width="100%" height="300" toolbarSet="mytools1"></FCK:editor>
	        </td>
	    </tr>
	    <tr>
	    	<td align="left">
	    		<input type="submit" value="提交"/>
	    	</td>
	    </tr>
	  </table>
  </s:form>
</div>
</body>
</html>
