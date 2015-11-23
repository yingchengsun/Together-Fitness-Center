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
<script language="javascript" src="<%=basePath %>js/TableColor.js"></script>
	<script type="text/javascript">
	    	function setNull1(){
	    		var objs = document.getElementById("id1");
	    		objs.value="";
	    	}
	    	function setNull2(){
	    		var objs = document.getElementById("id2");
	    		objs.value="";
	    	}
	</script>
</head>

<body background="<%=basePath %>7_yjssx_system/SubSystemImage/Background.png">
<div align="center">
   <img src="<%=basePath %>7_yjssx_system/SubSystemImage/clock.png" height="70" />
   <table width="100%" border="0" style="margin-top: 20px;background-image: url('<%=basePath %>7_yjssx_system/SubSystemImage/ddown01[1].gif')">
      <tr>
        <td width="100%" height="26"><div align="center">企业招聘功能配置</div></td>
      </tr>
   </table>
 
   <hr align="center" width="100%"/>
   <table width="100%" border="0" style="border-collapse:collapse">
   	  <tr style="background-image: url('<%=basePath %>7_yjssx_system/SubSystemImage/titlebg.gif')">
   	  	<td><div align="center"><strong>开通企业招聘功能：</strong></div></td>
   	  	<td><div align="center"><strong>关闭企业招聘功能：</strong></div></td>
   	  </tr>
      <tr>
        <td height="26">
        	<div align="center">
				<input type="button" value="点击开通此功能" onclick="location.href='<%=basePath %>yjssxAdmin/AdminSystemFunctionDeploy!CompanyReleaseInfoDeployToAll.action'" />
			</div>
		</td>
		<td height="26"><div align="center">
			<input type="button" value="点击关闭此功能" onclick="location.href='<%=basePath %>yjssxAdmin/AdminSystemFunctionDeploy!CompanyReleaseInfoCloseToAll.action'" />
		    </div>
		</td>
     </tr>
   </table>
   <table width="100%" border="0" style="border-collapse:collapse">
   	  <tr style="background-image: url('<%=basePath %>7_yjssx_system/SubSystemImage/titlebg.gif')">
   	  	<td><div align="center"><strong>开通特定企业招聘功能：</strong></div></td>
   	  	<td><div align="center"><strong>关闭特定企业招聘功能：</strong></div></td>
   	  </tr>
      <tr>
        <td height="26"><div align="center">
			<form action="yjssxAdmin/AdminSystemFunctionDeploy!CompanySearchByNameForCompanyReleaseInfo.action" method="post">
				<input type="hidden" name="type" value="open"/>
		  	  	<input name="companyName" id="id1" value="请输入企业名称..." onclick="setNull1()"/>
		      	<input type="submit" value="搜索"/>
	  		</form>
			</div>
		</td>
		<td height="26"><div align="center">
			<form action="yjssxAdmin/AdminSystemFunctionDeploy!CompanySearchByNameForCompanyReleaseInfo.action" method="post">
				<input type="hidden" name="type" value="close"/>
		  	  	<input name="companyName" id="id2" value="请输入企业名称..." onclick="setNull2()"/>
		      	<input type="submit" value="搜索"/>
	  		</form>
			</div>
		</td>
     </tr>
   </table>
   <hr align="center" width="100%"/>
  <form action="yjssxAdmin/AdminSystemFunctionDeploy!CloseSmCompanyReleaseInfo.action" method="post">
     <input type="hidden" name="type" value="${type }"/>
	 <table width="100%" border="1" id="mytable" style="border-collapse:collapse">
	    <tr style="background-image: url('<%=basePath %>7_yjssx_system/SubSystemImage/titlebg.gif')">
	      <th>编号</th>
	      <td ><div align="center"><strong>选择</strong></div></td>
	      <td ><div align="center"><strong>企业名称</strong></div></td>
	      <td ><div align="center"><strong>企业电话</strong></div></td>
	      <td ><div align="center"><strong>查看详情</strong></div></td>
	    </tr>
	    <s:if test="thesisList.size==0">
			<tr>
				<td>对不起暂无数据！！！</td>
			</tr>
		</s:if>
	    <s:else>
	    <s:iterator value="companyList" status="status">
	    <tr>
	      <td align="center" height="24"><s:property value="#status.count" /></td>
	      <td><input type="radio" name="companyNumber" value="${FCompanyNumber }"/></td>
	      <td align="center"><img src="<%=basePath %>7_yjssx_system/SubSystemImage/xuesheng.gif" />&nbsp;${FCompanyName }</td>
	      <td align="center"><img src="<%=basePath %>7_yjssx_system/SubSystemImage/xuesheng.gif" />&nbsp;${FTelephone }</td>
	      <td align="center"><div align="center">
	      <img src="<%=basePath %>7_yjssx_system/SubSystemImage/edit_profile.gif" height="15"/>
	      <a href="<%=basePath %>yjssxCommon/CommonOperation!findCompanyInfo.action?comId=${FCompanyNumber}" class="STYLE5">点击查看基本信息</a></div></td>    
	    </tr>
	   </s:iterator>
	   <tr style="background-color:#CCCCCC">
	      <td ><div align="center"></div></td>
	      <td ><div align="center"></div></td>
	      <td ><div align="center"><input type="submit" value="关闭此功能" /></div></td>
	      <td></td>
	      <td></td>
	    </tr>
	    </s:else>
	  </table>	  
   </form>
</div>
</body>
</html>
