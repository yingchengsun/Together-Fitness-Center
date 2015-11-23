<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
  <head>
    <title>My JSP 'news_management.jsp' starting page</title>
    <style type="text/css">
<!--
.STYLE1 {
	color: #0000FF;
	font-size: 36px;
	font-weight: bold;
}
-->
    </style>
	<link href="../css.css" rel="stylesheet" type="text/css" />
</head>
  
  <body>
  <div align="left"><a href="AddBulletin.jsp">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 添加公告</a></div>
  <center>
    <table width="844" height="39" border="1">
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
            <option>--全部--</option>
            <option>按发布时间查找</option>
            <option>按ID号查找</option>
            <option>按修改时间查找</option>
            <option>按标题查找</option>
        </select></td>
        <td width="232"><form name="form2" method="post" action="">
            <label></label>
            <label>
            <input name="textfield" type="text" class="STYLE7" maxlength="15" width="200" value="查询内容">
            </label>
        </form></td>
        <td width="100"><input type="submit" name="Submit" value=" 提 交 "></td>
      </tr>
    </table>
    <table width="838" height="444" border="1" bordercolor="#3399FF" >
      <tr bgcolor="#0066FF">
        <td colspan="7" align="center"><center>
          公 告 管 理
        </center></td>
      </tr>
      <tr bgcolor="#0066FF">
        <td width="65" align="center">ID</td>
        <td width="140" align="center">标题</td>
        <td width="134" align="center">时间</td>
        <td width="120" align="center">修改</td>
        <td width="120" align="center">查看</td>
        <td width="120" align="center">删除</td>
        <td width="93" align="center">多选删除</td>
      </tr>
      <tr>
        <td>01</td>
        <td>注意用电安全</td>
        <td>2009-12-20</td>
        <td><div align="center"><a href="">修改</a></div></td>
        <td><div align="center"><a href="">查看</a></div></td>
        <td><div align="center"><a href="">删除</a></div></td>
        <td><input name="checkbox11" type="checkbox"></td>
      </tr>
      <tr>
        <td>01</td>
        <td>注意用电安全</td>
        <td>2009-12-20</td>
        <td><div align="center"><a href="">修改</a></div></td>
        <td><div align="center"><a href="">查看</a></div></td>
        <td><div align="center"><a href="">删除</a></div></td>
        <td><input name="checkbox12" type="checkbox"></td>
      </tr>
      <tr>
        <td>01</td>
        <td>注意用电安全</td>
        <td>2009-12-20</td>
        <td><div align="center"><a href="">修改</a></div></td>
        <td><div align="center"><a href="">查看</a></div></td>
        <td><div align="center"><a href="">删除</a></div></td>
        <td><input name="checkbox13" type="checkbox"></td>
      </tr>
      <tr>
        <td>01</td>
        <td>注意用电安全</td>
        <td>2009-12-20</td>
        <td><div align="center"><a href="">修改</a></div></td>
        <td><div align="center">
            <div align="center"><a href="">查看</a></div>
        </div></td>
        <td><div align="center"><a href="">删除</a></div></td>
        <td><input name="checkbox11" type="checkbox"></td>
      </tr>
      <tr>
        <td>01</td>
        <td>注意用电安全</td>
        <td>2009-12-20</td>
        <td><div align="center"><a href="">修改</a></div></td>
        <td><div align="center">
            <div align="center"><a href="">查看</a></div>
        </div></td>
        <td><div align="center"><a href="">删除</a></div></td>
        <td><input name="checkbox12" type="checkbox"></td>
      </tr>
      <tr>
        <td>01</td>
        <td>注意用电安全</td>
        <td>2009-12-20</td>
        <td><div align="center"><a href="">修改</a></div></td>
        <td><div align="center">
            <div align="center"><a href="">查看</a></div>
        </div></td>
        <td><div align="center"><a href="">删除</a></div></td>
        <td><input name="checkbox13" type="checkbox"></td>
      </tr>
      <tr>
        <td>01</td>
        <td>注意用电安全</td>
        <td>2009-12-20</td>
        <td><div align="center"><a href="">修改</a></div></td>
        <td><div align="center">
            <div align="center"><a href="">查看</a></div>
        </div></td>
        <td><div align="center"><a href="">删除</a></div></td>
        <td><input name="checkbox11" type="checkbox"></td>
      </tr>
      <tr>
        <td>01</td>
        <td>注意用电安全</td>
        <td>2009-12-20</td>
        <td><div align="center"><a href="">修改</a></div></td>
        <td><div align="center"><a href="">查看</a></div></td>
        <td><div align="center"><a href="">删除</a></div></td>
        <td><input name="checkbox12" type="checkbox"></td>
      </tr>
      <tr>
        <td>01</td>
        <td>注意用电安全</td>
        <td>2009-12-20</td>
        <td><div align="center"><a href="">修改</a></div></td>
        <td><div align="center">
            <div align="center"><a href="">查看</a></div>
        </div></td>
        <td><div align="center"><a href="">删除</a></div></td>
        <td><input name="checkbox13" type="checkbox"></td>
      </tr>
      <tr>
        <td>01</td>
        <td>注意用电安全</td>
        <td>2009-12-20</td>
        <td><div align="center"><a href="">修改</a></div></td>
        <td><div align="center">
            <div align="center"><a href="">查看</a></div>
        </div></td>
        <td><div align="center"><a href="">删除</a></div></td>
        <td><input name="checkbox11" type="checkbox"></td>
      </tr>
      <tr>
        <td>01</td>
        <td>注意用电安全</td>
        <td>2009-12-20</td>
        <td><div align="center"><a href="">修改</a></div></td>
        <td><div align="center">
            <div align="center"><a href="">查看</a></div>
        </div></td>
        <td><div align="center"><a href="">删除</a></div></td>
        <td><input name="checkbox12" type="checkbox"></td>
      </tr>
      <tr>
        <td>01</td>
        <td>注意用电安全</td>
        <td>2009-12-20</td>
        <td><div align="center"><a href="">修改</a></div></td>
        <td><div align="center">
            <div align="center"><a href="">查看</a></div>
        </div></td>
        <td><div align="center"><a href="">删除</a></div></td>
        <td><input name="checkbox13" type="checkbox"></td>
      </tr>
      <tr>
        <td>01</td>
        <td>注意用电安全</td>
        <td>2009-12-20</td>
        <td><div align="center"><a href="">修改</a></div></td>
        <td><div align="center">
            <div align="center"><a href="">查看</a></div>
        </div></td>
        <td><div align="center"><a href="">删除</a></div></td>
        <td><input name="checkbox11" type="checkbox"></td>
      </tr>
      <tr>
        <td>01</td>
        <td>注意用电安全</td>
        <td>2009-12-20</td>
        <td><div align="center"><a href="">修改</a></div></td>
        <td><div align="center">
            <div align="center"><a href="">查看</a></div>
        </div></td>
        <td><div align="center"><a href="">删除</a></div></td>
        <td><input name="checkbox12" type="checkbox"></td>
      </tr>
      <tr>
        <td>01</td>
        <td>注意用电安全</td>
        <td>2009-12-20</td>
        <td><div align="center"><a href="">修改</a></div></td>
        <td><div align="center">
            <div align="center"><a href="">查看</a></div>
        </div></td>
        <td><div align="center"><a href="">删除</a></div></td>
        <td><input name="checkbox11" type="checkbox"></td>
      </tr>
      <tr>
        <td>01</td>
        <td>注意用电安全</td>
        <td>2009-12-20</td>
        <td><div align="center"><a href="">修改</a></div></td>
        <td><div align="center">
            <div align="center"><a href="">查看</a></div>
        </div></td>
        <td><div align="center"><a href="">删除</a></div></td>
        <td><input name="checkbox12" type="checkbox"></td>
      </tr>
      <tr>
        <td colspan="5"><div align="center"><a href="">first</a> <a href="">next</a> <a href="">previous</a> <a href="">last</a></div></td>
        <td colspan="2"><label>
          <input type="submit"  name="Submit2" value="delete">
        </label>
          <input type="submit" name="Submit22" value="selete all">
          <input type="submit" name="Submit23" value="reset"></td>
      </tr>
    </table>
  </center>
  </body>
</html>
