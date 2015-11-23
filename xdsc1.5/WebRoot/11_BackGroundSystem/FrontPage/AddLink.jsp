<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<html>
  <head>    
    <title>My JSP 'addnews.jsp' starting page</title>
	<link href="../css.css" rel="stylesheet" type="text/css" />

</head>
  <body>
  <center>
    <table width="417" height="126" border="1" bordercolor="#3399FF" >
      <tr bgcolor="#0066FF">
        <td colspan="2"><div align="center">添 加 通 知</div></td>
      </tr>
      <tr>
        <td width="69">标题:</td>
        <td width="332"><input name="text" type="text" />
          (长度在10字以内)</td>
      </tr>
      <tr>
        <td height="30">网址:</td>
        <td><input name="text2" type="text"  size="40"/></td>
      </tr>
      <tr>
        <td>&nbsp;</td>
        <td><input name="button" type="button" value="submit" width="30">
           
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <input name="button" type="button" value="reset" width="30">        </td>
      </tr>
    </table>
  </center>
  </body>
</html>
