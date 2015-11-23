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
    	function selectAll(){
    		 var objs = document.getElementsByTagName("input");
    		 for(var i=0;i<objs.length;i++){
    		 	 if(objs[i].type.toLowerCase() == "checkbox" )            
                    objs[i].checked = true;
    		 }
    		 
    	}
    	
    	function unSelectAll(){
    		var objs = document.getElementsByTagName("input");
    		 for(var i=0;i<objs.length;i++){
    		 	 if(objs[i].type .toLowerCase()== "checkbox" )            
                    objs[i].checked = false;
    		}
    	}
    </script>
</head>

<body background="../SubSystemImage/Background.png">
<div align="center">
<img src="<%=basePath %>7_yjssx_system/SubSystemImage/manage3.png" height="72" />
   <table width="100%" border="0" style="margin-top: 20px;background-image: url('<%=basePath %>7_yjssx_system/SubSystemImage/ddown01[1].gif')">
      <tr>
        <td width="100%" height="26"><div align="center">企业实习管理</div></td>
      </tr>
   </table>
   <fieldset  style="background-image: url('<%=basePath %>7_yjssx_system/SubSystemImage/login_bg.gif')">
   <legend><img src="<%=basePath %>7_yjssx_system/SubSystemImage/search.png" height="50"/></legend>
   <table width="100%" border="0" height="70">
   	  <tr>
   	  	<td><div align="center"><strong>实习企业确定情况查询：</strong></div></td>
   	  	<td><div align="center"><strong>输入企业名称：</strong></div></td>
   	  </tr>
      <tr>
        <td><div align="center">
			<form action="yjssxAdmin/AdminPractingZhaoPinManage!CompanyConfirmedSearch.action" method="post">
		  	 <select name="confirmInfo" >
		  	 	  <option >-----------请选择-----------</option>
			      <option value="Y">已确定实习企业的研究生</option>
			      <option value="N">未确定实习企业的研究生</option>
		      </select>
		      	<input type="submit" value="搜索"/>
	  		</form>
		</div></td>
		<td><div align="center">
			<form action="yjssxAdmin/AdminPractingZhaoPinManage!searchByCompanyName.action" method="post">
		  	     <select name="ComName">
		  	      <option value="">----请选择-----</option>
		  	      <s:iterator value="companyList">
			      <option value="${FCompanyNumber }">${FCompanyName }</option>
			      </s:iterator>
		      </select>
		      	<input type="submit" value="搜索"/>
	  		</form>
		</div></td>
     </tr>	
   </table>  	  
   </fieldset>
</div>
</body>
</html>
