<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
  <head>
    <title>编辑角色</title>
    <script type="text/javascript" src="<%=basePath%>js/TableColor.js"></script>
<link href="<%=basePath%>css.css" rel="stylesheet" type="text/css" />
  </head>
  
  <body>
   <center>
   <s:form action="UserRoleAction!updateUserRoleRelation" method="post">
    <table border="1" id="mytable">
       <tr>
           <td colspan="2" align="center">
                编辑用户角色
           </td>
      </tr>
      <tr>
           <td>关系ID</td>
           <td><s:textfield name="roleuser.FId" readonly="true"></s:textfield></td>
      </tr>
      <tr>
           <td>角色ID:</td>
           <td><s:textfield name="roleusermhqxTabRoleFRoleId"></s:textfield></td>
      </tr>      
      <tr>
           <td>用户帐号:</td>
           <td><s:textfield name="roleusermhqxTabUserFUserNumber"></s:textfield></td>
      </tr>  
      <tr><s:submit value="提交"></s:submit></tr>
     </table>
   </s:form>
   </center>  
  </body>
</html>
