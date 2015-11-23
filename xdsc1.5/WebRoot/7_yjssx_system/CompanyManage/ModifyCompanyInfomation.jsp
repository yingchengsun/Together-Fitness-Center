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
</head>

<body background="../SubSystemImage/Background.png">
<div align="center">
   <img src="<%=basePath %>7_yjssx_system/SubSystemImage/selfInfo.png" height="75"/>
   <table width="90%" border="0" style="margin-top: 20px;background-image: url('<%=basePath %>7_yjssx_system/SubSystemImage/ddown01[1].gif')">
      <tr>
        <td width="90%" height="26"><div align="center">修改企业信息</div></td>
      </tr>
   </table>
   <hr align="center" width="90%"/>
   <s:form action="CompanyModifySelfInfo!modifyInfo.action" namespace="/yjssxCompany">
	   <table width="90%" border="1" style="border-collapse:collapse">
	  
			<tr style="background-color:#CCCCCC">
			    <td width="133" height="29" align="center"><div align="left">企业名称：</div></td>
			    <td width="363" align="left"><div align="left"><input name="companyInfo.FCompanyName" value="<s:property value="companyInfo.FCompanyName"/>" type="text" /></div></td>
			    <td width="129" align="center"><div align="left">企业地址：</div></td>
			    <td width="318" align="left"><div align="left"><input name="companyInfo.FAddress" value="<s:property value="companyInfo.FAddress"/>" type="text" />
			      </div></td>
			  </tr>
			  <tr>
			    <td height="28" align="center"><div align="left">注册时间：</div></td>
			    <td align="left"><div align="left"><input name="companyInfo.FRegisterTime" value="<s:property value="companyInfo.FRegisterTime"/>" type="text" disabled="disabled"/></div></td>
			    <td align="center"><div align="left">企业邮箱：</div></td>
			    <td align="left"><div align="left"><input name="FCompanyConnetPerson" value="<s:property value="companyInfo.FConnectPerson"/>" type="text"/></div></td>
			  </tr>
			  
			  <tr style="background-color:#CCCCCC">
			    <td height="30" align="center"> 
			      <div align="left">联系人：</div></td>
			    <td align="left"><div align="left"><input name="FCompanyConnetPerson" value="张三" type="text" /></div></td>
			    <td align="center"><div align="left">联系电话：</div></td>
			    <td align="left"><div align="left"><input name="companyInfo.FTelephone" value="<s:property value="companyInfo.FTelephone"/>" type="text" /></div></td>
			  </tr>
	</table>
	 <table width="90%" height="69" border="1" style="border-collapse:collapse" bordercolor="#999999" 
	   background="../SubSystemImage/bg.gif">
	    <tr>
	      <td width="90%" height="321" align="left"><div align="left">企业详情：
	      </div><br/>
	      <FCK:editor instanceName="companyInfo.FInformation" basePath="/fckeditor" value=" ${companyInfo.FInformation}" width="100%" height="300" toolbarSet="mytools1"></FCK:editor>
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
