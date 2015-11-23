<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib  uri="/struts-tags" prefix="s"%> 
<%
 	String path = request.getContextPath();
 	String basePath = request.getScheme() + "://"
 			+ request.getServerName() + ":" + request.getServerPort()
 			+ path + "/";
 %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'RoleModuleFunctionConfig.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="<%=basePath%>css.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript">
	   function selectAll(){
    		 var objs = document.getElementsByName("choosefunctionlist");
    		 for(var i=0;i<objs.length;i++){
    		 	 if(objs[i].type.toLowerCase() == "checkbox" )            
                    objs[i].checked = true;
    		 }
    		 
    	}
    	
    	function unSelectAll(){
    		
    		var objs = document.getElementsByName("choosefunctionlist");
    		 for(var i=0;i<objs.length;i++){
    		 	 if(objs[i].type .toLowerCase()== "checkbox" )            
                    objs[i].checked = false;
    		}
    	}
        function selectAll2(){
    		 var objs = document.getElementsByName("choosemodulelist");
    		 for(var i=0;i<objs.length;i++){
    		 	 if(objs[i].type.toLowerCase() == "checkbox" )            
                    objs[i].checked = true;
    		 }
    		 
    	}
    	
    	function unSelectAll2(){
    		
    		var objs = document.getElementsByName("choosemodulelist");
    		 for(var i=0;i<objs.length;i++){
    		 	 if(objs[i].type .toLowerCase()== "checkbox" )            
                    objs[i].checked = false;
    		}
    	}
	</script>
	<style type="text/css">
	body{
		margin-left:200px;
		
		}
	</style>
  </head>
  
  <body>
   <br />
   <fieldset style="border-color: #ECF5FF">
   <legend>
      <font size="2">用户权限如下：</font>
   </legend>
    <s:form action="UpdateRoleDetailAction!updateroledetail" method="post" theme="simple">
    <font size="2"> 
        <%=session.getAttribute("rolename") %>&nbsp;角色所拥有的功能权限如下： 
        <s:iterator value="rolefunctionlist" >
           <li>${mhqxTabFunction.FFunctionId }${mhqxTabFunction.FFunctionName }<input type="checkbox" name="choosefunctionlist" value="${mhqxTabFunction.FFunctionId }" checked="checked" /></li>
        </s:iterator>
        <s:iterator value="functionlist" >
           <li>${FFunctionId }${FFunctionName }<input type="checkbox" name="choosefunctionlist" value="${FFunctionId }" /></li>
        </s:iterator>
        
        <br />
        <input type="button" value="全选" onclick="selectAll()" />
	    <input type="button" value="反选" onclick="unSelectAll()" />
        <br /> <br />
        <%=session.getAttribute("rolename") %>&nbsp;角色的模块权限如下： 
        <s:iterator value="rolemodulelist" >
           <li>${mhqxTabModule.FModuleId}${mhqxTabModule.FModuleName}<input type="checkbox" name="choosemodulelist" value="${mhqxTabModule.FModuleId }" checked="checked"/></li>
        </s:iterator>
        <s:iterator value="modulelist" >
           <li>${FModuleId}${FModuleName}<input type="checkbox" name="choosemodulelist" value="${FModuleId }" /></li>
        </s:iterator>
        <br />
        <input type="button" value="全选" onclick="selectAll2()" />
		<input type="button" value="反选" onclick="unSelectAll2()" />
        <br /> <br />
        <s:submit value="确认"/>
        </font>
    </s:form>
    </fieldset>
  </body>
</html>
