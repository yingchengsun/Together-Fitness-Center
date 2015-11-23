<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib  uri="/struts-tags" prefix="s"%> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
  <head>
    <base href="<%=basePath%>">
    <title>用户账号管理</title> 
    <script type="text/javascript" src="<%=basePath%>js/TableColor.js"></script>
    <link rel="stylesheet" href="<%=basePath %>/11_BackGroundSystem/jNice.css" />
	<script src="<%=basePath %>/11_BackGroundSystem/jquery.jNice.js" type="text/javascript"></script>
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
    </script>
  </head>
  
  <body>
  <center>
 
    <br /><br />
    <fieldset style="border-color: #ECF5FF">
      <legend>
        用户管理
      </legend>
    <s:form name="searchform" action="UserlistAction!searchuser.action" method="post">
      <table >
       <tr>
          <td >用户账号：<input type="text" name="searchusernumber" /></td>
          <td><input type="submit" value="查 询" /></td>
       </tr>
      </table>
    </s:form>
    <s:form name="userlistform" action="UserlistAction!multipledelete.action" method="post"> 
      <table border="1" id="mytable"  style="border-collapse:collapse" width="98%">
        <tr style="background-image: url('<%=basePath %>images/titlebg.gif')">
          
          <td align="center" >用户账号</td>
          <td align="center" >用户密码</td>
          <td align="center" >修改</td>
          <td align="center" >查看权限</td>
          <td align="center" >删除</td>
          <td align="center" width="100">多选删除</td>
        </tr>
        <s:iterator value="userlist">
        <tr>
          <td align="left"><s:property value="FUserNumber"/></td>
          <td align="left"><s:property value="FUserPassword"/></td>
          <td align="center"><a href='<s:url action="UserlistAction!modifyuser"><s:param name="id" value="FUserNumber"></s:param></s:url>'>修改</a></td>
          <td align="center"><a href='<s:url action="UserlistAction!showUserRoleFunction"><s:param name="id" value="FUserNumber"></s:param></s:url>'>查看权限</a></td>
          <td align="center"><a href='<s:url action="UserlistAction!deleteuser"><s:param name="id" value="FUserNumber"></s:param></s:url>'>删除</a></td>
          <td align="center"><input type="checkbox" name="deletelist" value="${FUserNumber }"/></td>         
        </tr>
        </s:iterator>
        <tr>
          <td colspan="4" align="center">
              
              <center>
                <a href='<s:url action="UserlistAction!showuserlist.action"> <s:param name="p" value="1"></s:param></s:url>'>首页</a>
                <a href='<s:url action="UserlistAction!showuserlist.action"> <s:param name="p" value="%{p-1}"></s:param></s:url>'>上一页</a>
                <a href='<s:url action="UserlistAction!showuserlist.action"> <s:param name="p" value="%{p+1}"></s:param></s:url>'>下一页</a>
                <a href='<s:url action="UserlistAction!showuserlist.action"> <s:param name="p" value="lastPage"></s:param></s:url>'>最后</a>
                  第<s:property value="p"/>页/共<s:property value="lastPage"/>页
              </center>
          </td>
          <td colspan="2">
              <input type="button" value="全选" onclick="selectAll()" />
              <input type="button" value="反选" onclick="unSelectAll()" />
              <input type="submit" value="删除" />
          </td>          
        </tr>
      </table>
   </s:form>
   </fieldset>
         <br>
      
      
  </center>
  </body>
</html>
