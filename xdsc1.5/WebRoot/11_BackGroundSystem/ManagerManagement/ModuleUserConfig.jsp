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
    <title>用户模块分配</title>  
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

    	function finish(){
    	    window.location.href="<%=basePath%>11_BackGroundSystem/welcome_page.jsp";
    	}
    </script>
  </head>
  
  <body>
    <center>
    <br>
			
			<br><br>
    <center>
     <h2>用户模块表</h2>
     <hr>
     <s:form action="ModuleUserAction!multipleconfig.action" method="post">
      <table border="1" id="mytable" style="border-collapse:collapse">
        <tr style="background-image: url('<%=basePath%>images/titlebg.gif')">
          <td align="center" width="100">子系统ID</td>
          <td align="center" width="100">子系统名</td>
          <td align="center" width="100">子系统URL</td>
          <td align="center" width="100">多选</td>
        </tr>
        <s:iterator value="modulelist">
        <tr>
          <td align="center"><s:property value="FModuleId"/></td>
          <td align="center"><s:property value="FModuleName"/></td>
          <td align="center"><s:property value="FFilePath"/></td>
          <td align="center"><input type="checkbox" name="deletelist" value="${FModuleId }"/></td>
        </tr>
        </s:iterator>
        <tr>
          <td colspan="3" align="center">
              <center>
                <a href='<s:url action="ModuleAction!configmodulelist.action"> <s:param name="p" value="1"></s:param></s:url>'>首页</a>
                <a href='<s:url action="ModuleAction!configmodulelist.action"> <s:param name="p" value="%{p-1}"></s:param></s:url>'>上一页</a>
                <a href='<s:url action="ModuleAction!configmodulelist.action"> <s:param name="p" value="%{p+1}"></s:param></s:url>'>下一页</a>
                <a href='<s:url action="ModuleAction!configmodulelist.action"> <s:param name="p" value="lastPage"></s:param></s:url>'>最后</a>
                    第<s:property value="p"/>页/共<s:property value="lastPage"/>页
              </center>
          </td>
          <td  align="center">
              <input type="button" value="全选" onclick="selectAll()" />
              <input type="button" value="反选" onclick="unSelectAll()" />
                  
          </td>
        </tr>
        <tr>
            <td colspan="3" align="center">
              用户账号：<input type="text" name="usernumber"  />
            </td>
            <td>
            <input type="submit" value="确定">
            </td>
         </tr>
      </table>
      </s:form>
				<table border="1" style="border-collapse: collapse">
					<tr>
						<td>
							<a href="RoleFunctionAction!getrolelist.action">角色功能配置</a>
						</td>
						<td>
							<a href="RoleModuleAction!RoleModuleConfig.action">角色子系统配置配置</a>
						</td>
						<td>
							<a href="UserRoleAction!showroleanduser.action">用户角色配置</a>
						</td>
						<td>
							<a href="UserFunctionAction!UserFunctionConfig.action">用户功能补充配置</a>
						</td>
						<td bgcolor="#3399FF">
							<a href="ModuleAction!modulelist.action">用户子系统补充配置</a>
						</td>
						<td>
							<a href="<%=basePath%>11_BackGroundSystem/welcome_page.jsp">完成</a>
						</td>
					</tr>
				</table>
				<input type="submit" onclick="finish()" value="完成"/>
    </center>
  </body>
</html>
