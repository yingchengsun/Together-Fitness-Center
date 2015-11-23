<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib  uri="/struts-tags" prefix="s"%> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'ModifyFunction.jsp' starting page</title>
<script type="text/javascript" src="<%=basePath%>js/TableColor.js"></script>
       
    <link href="<%=basePath%>css.css" rel="stylesheet" type="text/css" />
  </head>
  
  <body>
  <hr>
    <s:form action="FunctionAction!updatefunction" method="post">
         <table border="1" align="center" id="mytable">	
           <caption>编辑功能</caption>
           <tr><s:textfield name="functionname" label="功能名称"/></tr>
           <tr><s:textfield name="moduleid" label="所在模块ID"/></tr>
           <tr><s:textfield name="pfunctionid" label="父功能ID"/></tr>
           <s:select name="rolename" list="rolelist" listKey="FRoleName" listValue="FRoleName" label="角色" ></s:select>
           <tr><s:textfield name="url" label="url"/></tr>
           <tr><s:submit value="保存修改"/></tr>
         </table>
    </s:form>
  </body>
</html>
