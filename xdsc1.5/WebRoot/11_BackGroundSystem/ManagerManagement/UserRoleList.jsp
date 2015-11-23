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
    <script type="text/javascript" src="<%=basePath%>js/TableColor.js"></script>
    <link href="<%=basePath%>css.css" rel="stylesheet" type="text/css" />
    <title>用户角色关系表</title>
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
      <h2>用户角色关系表</h2>
      <hr>
      <s:form name="SearchUserRoleForm" action="UserRoleAction!searchuserrolerelation" theme="simple" method="post">
           <table >
              <tr>
                 <td>
                     用户账号:<s:textfield name="usernumber" label="用户账号" />
                     <s:submit value="查询"/>
                 </td>
              </tr>
           </table>
      </s:form>
      
      <s:form name="UserRoleForm" action="UserRoleAction!multipledelete.action" method="post"><div> 
      </div><table border="1" id="mytable" style="border-collapse:collapse">
        <tr style="background-image: url('<%=basePath %>images/titlebg.gif')">
          <td align="center" width="100">ID</td>
          <td align="center" width="100">角色ID</td>
          <td align="center" width="100">用户账号</td>
          <td align="center" width="100">删除</td>
          <td align="center" width="100">多选删除</td>
        </tr>
        <s:iterator value="userrolelist">
        <tr>
          <td align="center"><s:property value="FId"/></td>
          <td align="center">${mhqxTabRole.FRoleName }</td>
          <td align="center">${mhqxTabUser.FUserNumber }</td>
          <td align="center"><a href='<s:url action="UserRoleAction!deleteUserRoleRelation"><s:param name="id" value="FId"></s:param></s:url>'>删除</a></td>
          <td align="center"><input type="checkbox" name="deletelist" value="${FId }"/></td>          
        </tr>
        </s:iterator>
        <tr>
          <td colspan="3" align="center">
              <center>
                <a href='<s:url action="UserRoleAction!showlist.action"> <s:param name="p" value="1"></s:param></s:url>'>首页</a>
                <a href='<s:url action="UserRoleAction!showlist.action"> <s:param name="p" value="%{p-1}"></s:param></s:url>'>上一页</a>
                <a href='<s:url action="UserRoleAction!showlist.action"> <s:param name="p" value="%{p+1}"></s:param></s:url>'>下一页</a>
                <a href='<s:url action="UserRoleAction!showlist.action"> <s:param name="p" value="lastPage"></s:param></s:url>'>最后</a>
                  第<s:property value="p"/>页/共<s:property value="lastPage"/>页
              </center>
          </td>
          <td colspan="2" align="center">
              <input type="button" value="全选" onclick="selectAll()" />
              <input type="button" value="反选" onclick="unSelectAll()" />
              <input type="submit" value="删除" />          
          </td>
        </tr>
      </table>
      </s:form>
  </center>
  </body>
</html>
