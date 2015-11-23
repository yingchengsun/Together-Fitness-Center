<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
  <head>
    <title>My JSP 'news_management.jsp' starting page</title>
    <style type="text/css">
<!--
.STYLE1 {
	font-size: 36px;
	font-weight: bold;
	color: #0000FF;
}
-->
    </style>
	<link href="../css.css" rel="stylesheet" type="text/css" />

</head>
  
  <body >
  
  <div align="left"><a href="AddNotice.jsp">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;添加通知</a></div>
  <center>
    <table width="807" height="39" border="1">
      <tr>
        <td width="81" height="33">排序方式</td>
        <td width="164"><form name="form1" method="post" action="">
            <label>
            <select name="select" class="STYLE7">
              <option>------------</option>
              <option>按发布时间排序</option>
              <option>按ID号排序</option>
              <option>按修改时间排序</option>
            </select>
            </label>
        </form></td>
        <td width="67">查找</td>
        <td width="160"><select name="select2" class="STYLE7">
            <option>------------</option>
            <option>按发布时间查找</option>
            <option>按ID号查找</option>
            <option>按修改时间查找</option>
        </select></td>
        <td width="232"><form name="form2" method="post" action="">
            <label></label>
            <label>
            <input name="textfield" type="text" class="STYLE7" maxlength="15" width="200" value="查询内容">
            </label>
        </form></td>
        <td width="63"><input type="submit" name="Submit" value=" 提 交 "></td>
      </tr>
    </table>
    <table width="801" height="607" border="1" bordercolor="#3399FF" >
      <tr bgcolor="#0066FF">
        <td colspan="6" align="center">通 知 管 理</td>
      </tr>
      <tr bgcolor="#0066FF">
        <td width="89" align="center">ID</td>
        <td width="177" align="center">内容</td>
        <td width="182" align="center">时间</td>
        <td width="98" align="center">修改</td>
        <td width="96" align="center">删除</td>
        <td width="119" align="center">多选删除</td>
      </tr>
      <tr>
        <td height="29">01</td>
        <td>注意用电安全</td>
        <td>2009-12-20</td>
        <td><div align="center"><a href="">修改</a></div></td>
        <td><div align="center"><a href="">删除</a></div></td>
        <td><input name="checkbox11" type="checkbox"></td>
      </tr>
      <tr>
        <td>02</td>
        <td>Nicholas-Tse</td>
        <td>2009-12-21</td>
        <td><div align="center"><a href="">修改</a></div></td>
        <td><div align="center"><a href="">删除</a></div></td>
        <td><input name="checkbox12" type="checkbox"></td>
      </tr>
      <tr>
        <td>02</td>
        <td>Nicholas-Tse</td>
        <td>2009-12-21</td>
        <td><div align="center"><a href="">修改</a></div></td>
        <td><div align="center"><a href="">删除</a></div></td>
        <td><input name="checkbox13" type="checkbox"></td>
      </tr>
      <tr>
        <td>02</td>
        <td>Nicholas-Tse</td>
        <td>2009-12-21</td>
        <td><div align="center"><a href="">修改</a></div></td>
        <td><div align="center"><a href="">删除</a></div></td>
        <td><input name="checkbox11" type="checkbox"></td>
      </tr>
      <tr>
        <td>02</td>
        <td>Nicholas-Tse</td>
        <td>2009-12-21</td>
        <td><div align="center"><a href="">修改</a></div></td>
        <td><div align="center"><a href="">删除</a></div></td>
        <td><input name="checkbox12" type="checkbox"></td>
      </tr>
      <tr>
        <td>02</td>
        <td>Nicholas-Tse</td>
        <td>2009-12-21</td>
        <td><div align="center"><a href="">修改</a></div></td>
        <td><div align="center"><a href="">删除</a></div></td>
        <td><input name="checkbox13" type="checkbox"></td>
      </tr>
      <tr>
        <td>02</td>
        <td>Nicholas-Tse</td>
        <td>2009-12-21</td>
        <td><div align="center"><a href="">修改</a></div></td>
        <td><div align="center"><a href="">删除</a></div></td>
        <td><input name="checkbox11" type="checkbox"></td>
      </tr>
      <tr>
        <td>02</td>
        <td>Nicholas-Tse</td>
        <td>2009-12-21</td>
        <td><div align="center"><a href="">修改</a></div></td>
        <td><div align="center"><a href="">删除</a></div></td>
        <td><input name="checkbox12" type="checkbox"></td>
      </tr>
      <tr>
        <td>02</td>
        <td>Nicholas-Tse</td>
        <td>2009-12-21</td>
        <td><div align="center"><a href="">修改</a></div></td>
        <td><div align="center"><a href="">删除</a></div></td>
        <td><input name="checkbox13" type="checkbox"></td>
      </tr>
      <tr>
        <td>02</td>
        <td>Nicholas-Tse</td>
        <td>2009-12-21</td>
        <td><div align="center"><a href="">修改</a></div></td>
        <td><div align="center"><a href="">删除</a></div></td>
        <td><input name="checkbox11" type="checkbox"></td>
      </tr>
      <tr>
        <td>02</td>
        <td>Nicholas-Tse</td>
        <td>2009-12-21</td>
        <td><div align="center"><a href="">修改</a></div></td>
        <td><div align="center"><a href="">删除</a></div></td>
        <td><input name="checkbox12" type="checkbox"></td>
      </tr>
      <tr>
        <td>02</td>
        <td>Nicholas-Tse</td>
        <td>2009-12-21</td>
        <td><div align="center"><a href="">修改</a></div></td>
        <td><div align="center"><a href="">删除</a></div></td>
        <td><input name="checkbox13" type="checkbox"></td>
      </tr>
      <tr>
        <td>02</td>
        <td>Nicholas-Tse</td>
        <td>2009-12-21</td>
        <td><div align="center"><a href="">修改</a></div></td>
        <td><div align="center"><a href="">删除</a></div></td>
        <td><input name="checkbox11" type="checkbox"></td>
      </tr>
      <tr>
        <td>02</td>
        <td>Nicholas-Tse</td>
        <td>2009-12-21</td>
        <td><div align="center"><a href="">修改</a></div></td>
        <td><div align="center"><a href="">删除</a></div></td>
        <td><input name="checkbox12" type="checkbox"></td>
      </tr>
      <tr>
        <td>02</td>
        <td>Nicholas-Tse</td>
        <td>2009-12-21</td>
        <td><div align="center"><a href="">修改</a></div></td>
        <td><div align="center"><a href="">删除</a></div></td>
        <td><input name="checkbox13" type="checkbox"></td>
      </tr>
      <tr>
        <td>02</td>
        <td>Nicholas-Tse</td>
        <td>2009-12-21</td>
        <td><div align="center"><a href="">修改</a></div></td>
        <td><div align="center"><a href="">删除</a></div></td>
        <td><input name="checkbox11" type="checkbox"></td>
      </tr>
      <tr>
        <td>02</td>
        <td>Nicholas-Tse</td>
        <td>2009-12-21</td>
        <td><div align="center"><a href="">修改</a></div></td>
        <td><div align="center"><a href="">删除</a></div></td>
        <td><input name="checkbox12" type="checkbox"></td>
      </tr>
      <tr>
        <td>02</td>
        <td>Nicholas-Tse</td>
        <td>2009-12-21</td>
        <td><div align="center"><a href="">修改</a></div></td>
        <td><div align="center"><a href="">删除</a></div></td>
        <td><input name="checkbox11" type="checkbox"></td>
      </tr>
      <tr>
        <td>02</td>
        <td>Nicholas-Tse</td>
        <td>2009-12-21</td>
        <td><div align="center"><a href="">修改</a></div></td>
        <td><div align="center"><a href="">删除</a></div></td>
        <td><input name="checkbox12" type="checkbox"></td>
      </tr>
      <tr>
        <td>02</td>
        <td>Nicholas-Tse</td>
        <td>2009-12-21</td>
        <td><div align="center"><a href="">修改</a></div></td>
        <td><div align="center"><a href="">删除</a></div></td>
        <td><input name="checkbox13" type="checkbox"></td>
      </tr>
      <tr>
        <td colspan="3"><div align="center"><a href="">first</a> <a href="">next</a> <a href="">previous</a> <a href="">last</a></div></td>
        <td colspan="3"><div align="center">
          <label>
          <input type="submit"  name="Submit2" value="delete">
          </label>
          <input type="submit" name="Submit22" value="selete all">
          <input type="submit" name="Submit23" value="reset">
</div>          <div align="center"></div></td>
      </tr>
    </table>
    <p>&nbsp;</p>
  </center>
  </body>
</html>
