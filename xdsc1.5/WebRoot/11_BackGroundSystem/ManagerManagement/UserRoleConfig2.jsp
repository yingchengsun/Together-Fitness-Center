<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib  uri="/struts-tags" prefix="s"%> 
<% 
 	String path = request.getContextPath();
 	String basePath = request.getScheme() + "://"
 			+ request.getServerName() + ":" + request.getServerPort()
 			+ path + "/";
 %>
<html>
  <head>
    <base href="<%=basePath%>">
    <title>用户角色分配</title> 
    <script type="text/javascript" src="<%=basePath%>js/TableColor.js"></script> 
    <link href="<%=basePath%>css.css" rel="stylesheet" type="text/css" />  
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
    	function next(){
    	    window.location.href="UserFunctionAction!UserFunctionConfig.action";
    	}
    	function finish(){
    	    window.location.href="<%=basePath%>11_BackGroundSystem/welcome_page.jsp";
    	}
    </script>
  </head>
  
  <body>
   <center><br /><br /><br />
    
      <fieldset style="border-color: #ECF5FF">
      <legend>
        用户角色分配
      </legend>
      <s:form name="listaction" action="UserRoleAction!multipleconfig2.action" method="post" theme="simple">
       请输入用户账号：<s:textfield name="usernumber"/> 
      <br><br>
      <table border="1" id="mytable" style="border-collapse:collapse">
        <tr style="background-image: url('<%=basePath%>images/titlebg.gif')">
          <td align="center" width="100">id</td>
          <td align="center" width="150">角色名称</td>
          <td align="center" >角 色 选 择</td>
        </tr>
        <s:iterator value="rolelist">
        <tr>
          <td align="center"><s:property value="FRoleId"/></td>
          <td align="left"><s:property value="FRoleName"/></td>
          <td align="center"><input type="checkbox" name="deletelist" value="${FRoleId }"/></td>          
        </tr> 
        </s:iterator>
        <tr>
          <td colspan="1" align="center">
          </td>
          <td align="center">
              <input type="submit" value="确定" />
           </td>
          <td align="center">
              <input type="button" value="全选" onclick="selectAll()" />
              <input type="button" value="反选" onclick="unSelectAll()" />        
          </td>
        </tr>
       </table>
      </s:form>
      </fieldset>
    </center>
  </body>
</html>
