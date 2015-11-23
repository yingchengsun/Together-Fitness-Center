<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<html>
  <head>    
    <title>My JSP 'addnews.jsp' starting page</title>
	<link href="../css.css" rel="stylesheet" type="text/css" />

</head>
  <body>
  <center>
 
      <form action="" method="get">
      <br>
	      <br><br><br>
	      <br>
	      <table width="417" height="269" border="1" bordercolor="#3399FF" >
            <tr bgcolor="#0066FF">
              <td colspan="2"><div align="center">添 加 新闻</div></td>
            </tr>
            <tr>
              <td width="90">标题:</td>
              <td width="311"><input name="text" type="text" />
                (长度在20字以内)</td>
            </tr>
            <tr>
              <td height="34">图片:</td>
              <td><input name="file" type="file"  height="20"/></td>
            </tr>
            <tr>
              <td height="34">类别:</td>
              <td><select name="select2" class="STYLE7">
                  <option>------------</option>
                  <option>学院新闻</option>
                  <option>招聘信息</option>
                  <option>国内时事</option>
              </select></td>
            </tr>
            <tr>
              <td height="93">内容:</td>
              <td><textarea name="textarea" cols="42" rows="10"></textarea></td>
            </tr>
            <tr>
              <td>&nbsp;</td>
              <td><input name="button" type="button" value="submit" width="30">
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input name="button" type="button" value="reset" width="30">              </td>
            </tr>
          </table>
	      <br><br>
      </form>
  </center>
  </body>
</html>
