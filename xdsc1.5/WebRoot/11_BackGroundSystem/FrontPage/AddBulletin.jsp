<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<html>
  <head>    
    <title>My JSP 'addnews.jsp' starting page</title>
	<link href="../css.css" rel="stylesheet" type="text/css" />

</head>
  <body>
  <center>
    <table width="313" height="169" border="1" bordercolor="#3399FF" >
      <tr bgcolor="#0066FF">
        <td height="31" colspan="2"><div align="center">添加通知</div></td>
      </tr>
      <tr>
        <td width="70" height="31">标题:</td>
        <td width="227"><font size="+2">
          <input name="title" type="text" height=20">
        </font></td>
      </tr>
      <tr>
        <td height="100">内容:</td>
        <td><textarea name="textarea" cols="30" rows="10"></textarea></td>
      </tr>
      <tr>
        <td>&nbsp;</td>
        <td><label>
          <input type="submit" name="Submit" value="提交">
          <input type="submit" name="Submit2" value="重置">
        </label></td>
      </tr>
    </table>
  </center>
  </body>
</html>
