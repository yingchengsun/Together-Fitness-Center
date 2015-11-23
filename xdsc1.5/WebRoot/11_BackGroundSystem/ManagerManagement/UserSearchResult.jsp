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
    <title>用户搜索结果</title>
    <link href="<%=basePath%>css.css" rel="stylesheet" type="text/css" />
  </head>
  
  <body>
  <center>
    <table border="1" id="mytable" style="border-collapse:collapse">
        <tr style="background-image: url('<%=basePath %>images/titlebg.gif')">
          
          <td align="center" width="100">用户账号</td>
          <td align="center" width="100">用户密码</td>
          <td align="center" width="100">修改</td>
          <td align="center" width="100">删除</td>
        </tr>
        <s:iterator value="userlist">
        <tr>
          <td align="center"><s:property value="FUserNumber"/></td>
          <td align="center"><s:property value="FUserPassword"/></td>
          <td align="center"><a href='<s:url action="UserlistAction!modifyuser"><s:param name="id" value="FUserNumber"></s:param></s:url>'>修改</a></td>
          <td align="center"><a href='<s:url action="UserlistAction!deleteuser"><s:param name="id" value="FUserNumber"></s:param></s:url>'>删除</a></td>       
        </tr>
        </s:iterator>
        <tr>
          <td colspan="4" align="center">
              <center>
                <a href='<s:url action="11_BackGroundSystem/FrontPage/RolelistAction.action"> <s:param name="p" value="1"></s:param></s:url>'>首页</a>
                <a href='<s:url action="11_BackGroundSystem/FrontPage/RolelistAction.action"> <s:param name="p" value="%{p-1}"></s:param></s:url>'>上一页</a>
                <a href='<s:url action="11_BackGroundSystem/FrontPage/RolelistAction.action"> <s:param name="p" value="%{p+1}"></s:param></s:url>'>下一页</a>
                <a href='<s:url action="11_BackGroundSystem/FrontPage/RolelistAction.action"> <s:param name="p" value="lastPage"></s:param></s:url>'>最后</a>
              </center>
          </td>      
        </tr>
      </table>
   </center>
  </body>
</html>
