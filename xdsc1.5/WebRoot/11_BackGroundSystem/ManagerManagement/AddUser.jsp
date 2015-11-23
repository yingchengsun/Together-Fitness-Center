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
    
    <title>My JSP 'AddUser.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <script type="text/javascript" src="<%=basePath%>js/TableColor.js"></script>
    <link href="<%=basePath%>css.css" rel="stylesheet" type="text/css" />
  </head>
  
  <body>
    <br /><br />
      <center>
      
      <fieldset style="border-color: #ECF5FF">
      <legend>
        添加单个用户
      </legend>
      <s:form name="useraddform" action="UserlistAction!adduser.action"  method="post">
        <table border="1" style="border-collapse: collapse">
          <tr style="background-image: url('<%=basePath %>images/titlebg.gif')">
             <td colspan="2" align="center">添加用户</td>
          </tr>
          <tr>
             <td><s:textfield label="账号" name="Usernumber" required="true"/></td>
          </tr>
          <tr>
             <td><s:password label="密码" name="Userpassword" required="true"/></td>
          </tr>
          <tr>
             <td> <s:password label="密码确认" name="confirmpassword" required="true"/></td>
          </tr>
          <tr>
             <td align="center"><s:submit value="提交"/></td>
          </tr>
        </table>
      </s:form>
      </fieldset>
      <br>
      <fieldset style="border-color: #ECF5FF">
      <legend>
        批量导入本科生用户
      </legend>
      <form name="InExcelForm" action="excelInpgs.action" enctype="multipart/form-data" method="post"> 
         <table border="1" style="border-collapse: collapse">
            <tr style="background-image: url('<%=basePath %>images/titlebg.gif')">
               <td colspan="2" align="center">批量导入本科生用户信息</td>
            </tr>
            <tr>
               <td>选择文件</td>
               <td><input type="file" name="file" /></td>
            </tr>
            <tr>
               <td colspan="2" align="center"><input type="submit" value="导入" /></td>
            </tr>
         </table>
      </form>
      </fieldset>
            <br>
      <s:label value="批量导入研究生用户信息" />
      <fieldset style="border-color: #ECF5FF" >
      <legend>
        批量导入研究生用户
      </legend>
      <form name="InExcelForm" action="excelIngs.action" enctype="multipart/form-data" method="post"> 
			<table border="1" style="border-collapse: collapse">
            <tr style="background-image: url('<%=basePath %>images/titlebg.gif')">
               <td colspan="2" align="center">批量导入研究生用户信息</td>
            </tr>
            <tr>
               <td>选择文件</td>
               <td><input type="file" name="file" /></td>
            </tr>
            <tr>
               <td colspan="2" align="center"><input type="submit" value="导入" /></td>
            </tr>
            </table> 
      </form>
      </fieldset>
      </center>
  </body>
</html>
