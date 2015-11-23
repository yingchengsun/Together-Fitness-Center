<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
  <head>
    <title>编辑用户模块</title>
    <script type="text/javascript" src="<%=basePath%>js/TableColor.js"></script>
    <link href="<%=basePath%>css.css" rel="stylesheet" type="text/css" />
  </head>
  
  <body>
   <center>
   <s:form action="ModuleUserAction!updateModuleUserRelation" theme="simple" method="post">
    <table border="1" id="mytable">
       <tr>
           <td colspan="2" align="center">
                编辑用户模块
           </td>
      </tr>
      <tr>
           <td>关系ID</td>
           <td><s:textfield name="moduleuser.FId" readonly="true"></s:textfield></td>
      </tr> 
      <tr>
           <td>请选择角色：</td>
           <td><s:select list="modulenamelist" name="modulename" label="请选择角色" headerKey="-1" headerValue="请选择角色"></s:select></td>
      </tr>    
      <tr>
           <td>用户帐号:</td>
           <td><s:textfield name="moduleusermhqxTabUserFUserNumber"/></td>
      </tr>  
      <tr><td><s:submit value="提交"></s:submit></td></tr>
     </table>
   </s:form>
   </center>  
  </body>
</html>
