<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
  <head>
    <base href="<%=basePath%>">
    <title>角色编辑</title>
	<link href="<%=basePath%>css.css" rel="stylesheet" type="text/css" />
       <script type="text/javascript" src="<%=basePath%>js/TableColor.js"></script>
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
  
  <body>
    <center>
    <br>
    
    <fieldset style="border-color: #ECF5FF">
      <legend>
        角色管理
      </legend>
    <s:form name="listaction" action="MultipleDeleteRole!multipledelete.action" method="post">
      <table border="1" id="mytable" style="border-collapse:collapse">
        <tr style="background-image: url('<%=basePath %>images/titlebg.gif')">
          <td align="center" width="100">ID</td>
          <td align="center" width="100">角色名称</td>
          <td align="center" width="100">修改</td>
          <td align="center" width="100">删除</td>
          <td align="center" width="100">查看权限</td>
          <td align="center" width="100">多选</td>
        </tr>
        <s:iterator value="rolelist">
        <tr>
          <td align="center"><s:property value="FRoleId"/></td>
          <td align="center"><s:property value="FRoleName"/></td>
          <td align="center"><a href='<s:url action="modrole"><s:param name="id" value="FRoleId"></s:param></s:url>'>修改</a></td>
          <td align="center"><a href='<s:url action="delroleaction"><s:param name="id" value="FRoleId"></s:param></s:url>'>删除</a></td>
          <td align="center"><a href="ShowRoleDetailAction!showroledetail.action?roleid=${FRoleId }">查看角色权限</a></td> 
          <td align="center"><input type="checkbox" name="deletelist" value="${FRoleId }"/></td>          
        </tr>
        </s:iterator>
        <tr>
          <td colspan="3" align="center">
              <center>
                <a href='<s:url action="11_BackGroundSystem/FrontPage/RolelistAction.action"> <s:param name="p" value="1"></s:param></s:url>'>首页</a>
                <a href='<s:url action="11_BackGroundSystem/FrontPage/RolelistAction.action"> <s:param name="p" value="%{p-1}"></s:param></s:url>'>上一页</a>
                <a href='<s:url action="11_BackGroundSystem/FrontPage/RolelistAction.action"> <s:param name="p" value="%{p+1}"></s:param></s:url>'>下一页</a>
                <a href='<s:url action="11_BackGroundSystem/FrontPage/RolelistAction.action"> <s:param name="p" value="lastPage"></s:param></s:url>'>最后</a>
                   第<s:property value="p"/>页/共<s:property value="lastPage"/>页
              </center>
          </td>
          <td colspan="3" align="center">
              <input type="button" value="全选" onclick="selectAll()" />
              <input type="button" value="反选" onclick="unSelectAll()" />
              <input type="submit" value="删除" />          
          </td>
        </tr>
      </table>
   </s:form> 
   </fieldset>
   <br/>
   <fieldset style="border-color: #ECF5FF">
      <legend>
        添加新角色
      </legend>
   <s:form action="AddRoleaction" method="post">
      <table border="1" style="border-collapse:collapse">
         <tr bgcolor="d0d0d0">
             <td colspan="3" align="center">
                   添加新角色
             </td>
         </tr>
         <tr>
             <td><s:textfield name="Rolename" label="角色名称"></s:textfield></td>
             <td><s:submit value="添加角色"> </s:submit></td>
         </tr>
      </table>
    </s:form>
    </fieldset>
    </center>
    
</body>
</html>
