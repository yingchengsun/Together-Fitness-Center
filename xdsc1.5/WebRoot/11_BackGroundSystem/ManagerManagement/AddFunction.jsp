<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib  uri="/struts-tags" prefix="s"%> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'AddFunction.jsp' starting page</title>
    <link href="<%=basePath%>css.css" rel="stylesheet" type="text/css" />
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>  
  <br /><br />
  <center>
 
     <fieldset style="border-color: #ECF5FF">
      <legend>
        添加功能
      </legend>
       <s:form name="addform" action="FunctionAction!addfunction" method="post">
         
         <table border="1" align="center" style="border-collapse:collapse">	
           <tr><s:textfield name="function.FFunctionId" label="功能ID" required="true"/></tr>
           <tr><s:textfield name="function.FFunctionName" label="功能名称" required="true"/></tr>
           <tr><s:select name="function.mhqxTabModule.FModuleId" list="modulelist" listKey="FModuleId" listValue="FModuleName" label="模块" required="true"/></tr>
           <tr><s:textfield name="function.FSuperFunctionId" label="父功能ID" required="true"/></tr>
           <tr><s:select name="function.FPriority" list="#{'1':'1','2':'2','3':'3','4':'4','5':'5','6':'6'}" label="优先级" required="true"></s:select></tr>
           <tr><s:select name="function.FIsLeaf" list="#{'1':'是','0':'否'}" label="是否为叶子结点" required="true"></s:select></tr>
           <tr><s:select name="rolename" list="rolelist" listKey="FRoleName" listValue="FRoleName" label="角色" required="true"></s:select></tr>
           <tr><s:textfield name="function.FFilePath" label="URL" /></tr>
           <tr><s:submit value="添加"/></tr>
         </table>
    </s:form>
    
    </fieldset>
     <br/><br/>
      <fieldset style="border-color: #ECF5FF">
      <legend>
        批量导入功能信息
      </legend>
      <form name="InExcelForm" action="functionexcelIn.action" enctype="multipart/form-data" method="post"> 
			导入excel文件：			
			<br>  
			<input type="file" name="file" /><br>
			<input type="submit" value="导入" />
			<br>
      </form>
      </fieldset>
      </center>
  </body>
</html>
