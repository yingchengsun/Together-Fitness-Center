<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
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
    
    <title>用户功能配置</title>
    <script type="text/javascript" src="<%=basePath%>js/TableColor.js"></script>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
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
    	    window.location.href="ModuleAction!modulelist.action";
    	}
    	function finish(){
    	    window.location.href="<%=basePath%>11_BackGroundSystem/welcome_page.jsp";
    	}
    </script>
  </head>
  
  <body>
    <br>
    <center>
	    <br>
		
		<br><br>

    <h2>用户功能配置"</h2>
     <hr>
     <s:form name="showbysystem" action="UserFunctionAction!UserFunctionConfig.action" method="post" theme="simple">
     <table>
       <tr>
         <td>
           系统：<s:select name="moduleid" list="modulelist" listKey="FModuleId" listValue="FModuleName" label="子系统" />
         </td>
         <td>
          角色：<s:select name="rolename" list="rolelist" listKey="FRoleName" listValue="FRoleName" label="角色" />
         </td>
         <td>
           <s:submit value="提交"/>
         </td>
       </tr>
     </table>
    </s:form>
     <s:form action="UserFunctionAction!saveUserFunctionRelation" method="post">  
      <table border="1" id="mytable" style="border-collapse:collapse">
        <tr style="background-image: url('<%=basePath%>images/titlebg.gif')">
          <td align="center" width="100">功能ID</td>
          <td align="center" width="100">功能名称</td>
          <td align="center" width="100">父功能ID</td>
          <td align="center" width="100">子系统名称</td>
          <td align="center" width="150">功能标识(是否常用)</td>
          <td align="center" width="100">URL</td>
          <td align="center" width="100">多选</td>
        </tr>
        <s:iterator value="functionlist">
        <tr>
          <td align="center"><s:property value="FFunctionId"/></td>
          <td align="center"><s:property value="FFunctionName"/></td>
          <td align="center"><s:property value="FSuperFunctionId"/></td>
          <td align="center"><s:property value="mhqxTabModule.FModuleName"/></td>       
          <td align="center"><s:property value="FFunctionMark"/></td>
          <td align="center"><s:property value="FFilePath"/></td>  
          <td align="center"><input type="checkbox" name="deletelist" value="${FFunctionId }" /></td>          
        </tr>
        </s:iterator>
        <tr>
          <td colspan="5" align="center">
              <center>
                <a href='<s:url action="UserFunctionAction!UserFunctionConfig.action"> <s:param name="p" value="1"></s:param></s:url>'>首页</a>
                <a href='<s:url action="UserFunctionAction!UserFunctionConfig.action"> <s:param name="p" value="%{p-1}"></s:param></s:url>'>上一页</a>
                <a href='<s:url action="UserFunctionAction!UserFunctionConfig.action"> <s:param name="p" value="%{p+1}"></s:param></s:url>'>下一页</a>
                <a href='<s:url action="UserFunctionAction!UserFunctionConfig.action"> <s:param name="p" value="lastPage"></s:param></s:url>'>最后</a>
                  第<s:property value="p"/>页/共<s:property value="lastPage"/>页
              </center>
          </td>
          <td colspan="2"> 
              <input type="button" value="全选" onclick="selectAll()" />
              <input type="button" value="反选" onclick="unSelectAll()" />
          </td> 
        </tr>
      </table>
      <table>
        <tr>
           <td>
              <s:textfield name="usernumber" label="用户账号" />
           </td>
        </tr>
        <tr>
           <s:submit value="确定" />
        </tr>
      </table>   
  </s:form>
    </center>
  </body>
</html>
