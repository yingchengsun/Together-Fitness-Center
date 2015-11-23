<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>

  <head>
    <title>My JSP 'news_management.jsp' starting page</title>

    <link href="../css.css" rel="stylesheet" type="text/css" />
</head>
  <link rel="stylesheet" type="text/css" href="style.css" />
  <body >
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="AddNews.jsp" class="STYLE2">添加新闻</a>
  <table width="848" height="39" border="1" align="center">
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
          <option>按标题查找</option>
      </select></td>
      <td width="232"><form name="form2" method="post" action="">
          <label></label>
          <label>
          <input name="textfield" type="text" class="STYLE7" maxlength="15" width="200" value="查询内容">
          </label>
      </form></td>
      <td width="104"><input type="submit" name="Submit" value=" 提 交 "></td>
    </tr>
  </table>
  <center>
    <table width="846" height="465" border="1" bordercolor="#3399FF" >
      <tr bgcolor="#0066FF">
        <td colspan="7" align="center" id="mytr">首 页 新 闻 管 理</td>
      </tr>
      <tr bgcolor="#0066FF">
        <td width="89" align="center" id="mytr">ID</td>
        <td width="177" align="center" id="mytr">标题</td>
        <td width="182" align="center" id="mytr">时间</td>
        <td width="118" align="center" id="mytr">详细</td>
        <td width="116" align="center" id="mytr">修改</td>
        <td width="122" align="center" id="mytr">删除</td>
        <td width="119" align="center">多选删除</td>
      </tr>
      <tr>
        <td>01</td>
        <td>第21届星火杯闭幕</td>
        <td>2009-12-20</td>
        <td><div align="center"><a href="">详细</a></div></td>
        <td><div align="center"><a href="">修改</a></div></td>
        <td><div align="center"><a href="">删除</a></div></td>
        <td><input type="checkbox"></td>
      </tr>
      <tr>
        <td>01</td>
        <td>第21届星火杯闭幕</td>
        <td>2009-12-20</td>
        <td><div align="center"><a href="">详细</a></div></td>
        <td><div align="center"><a href="">修改</a></div></td>
        <td><div align="center"><a href="">删除</a></div></td>
        <td><input name="checkbox" type="checkbox"></td>
      </tr>
      <tr>
        <td>01</td>
        <td>第21届星火杯闭幕</td>
        <td>2009-12-20</td>
        <td><div align="center"><a href="">详细</a></div></td>
        <td><div align="center"><a href="">修改</a></div></td>
        <td><div align="center"><a href="">删除</a></div></td>
        <td><input name="checkbox2" type="checkbox"></td>
      </tr>
      <tr>
        <td>01</td>
        <td>第21届星火杯闭幕</td>
        <td>2009-12-20</td>
        <td><div align="center"><a href="">详细</a></div></td>
        <td><div align="center"><a href="">修改</a></div></td>
        <td><div align="center"><a href="">删除</a></div></td>
        <td><input name="checkbox3" type="checkbox"></td>
      </tr>
      <tr>
        <td>01</td>
        <td>第21届星火杯闭幕</td>
        <td>2009-12-20</td>
        <td><div align="center"><a href="">详细</a></div></td>
        <td><div align="center"><a href="">修改</a></div></td>
        <td><div align="center"><a href="">删除</a></div></td>
        <td><input name="checkbox4" type="checkbox"></td>
      </tr>
      <tr>
        <td>01</td>
        <td>第21届星火杯闭幕</td>
        <td>2009-12-20</td>
        <td><div align="center"><a href="">详细</a></div></td>
        <td><div align="center"><a href="">修改</a></div></td>
        <td><div align="center"><a href="">删除</a></div></td>
        <td><input name="checkbox5" type="checkbox"></td>
      </tr>
      <tr>
        <td>01</td>
        <td>第21届星火杯闭幕</td>
        <td>2009-12-20</td>
        <td><div align="center"><a href="">详细</a></div></td>
        <td><div align="center"><a href="">修改</a></div></td>
        <td><div align="center"><a href="">删除</a></div></td>
        <td><input name="checkbox6" type="checkbox"></td>
      </tr>
      <tr>
        <td>01</td>
        <td>第21届星火杯闭幕</td>
        <td>2009-12-20</td>
        <td><div align="center"><a href="">详细</a></div></td>
        <td><div align="center"><a href="">修改</a></div></td>
        <td><div align="center"><a href="">删除</a></div></td>
        <td><input name="checkbox7" type="checkbox"></td>
      </tr>
      <tr>
        <td>01</td>
        <td>第21届星火杯闭幕</td>
        <td>2009-12-20</td>
        <td><div align="center"><a href="">详细</a></div></td>
        <td><div align="center"><a href="">修改</a></div></td>
        <td><div align="center"><a href="">删除</a></div></td>
        <td><input name="checkbox8" type="checkbox"></td>
      </tr>
      <tr>
        <td>01</td>
        <td>第21届星火杯闭幕</td>
        <td>2009-12-20</td>
        <td><div align="center"><a href="">详细</a></div></td>
        <td><div align="center"><a href="">修改</a></div></td>
        <td><div align="center"><a href="">删除</a></div></td>
        <td><input name="checkbox9" type="checkbox"></td>
      </tr>
      <tr>
        <td>01</td>
        <td>第21届星火杯闭幕</td>
        <td>2009-12-20</td>
        <td><div align="center"><a href="">详细</a></div></td>
        <td><div align="center"><a href="">修改</a></div></td>
        <td><div align="center"><a href="">删除</a></div></td>
        <td><input name="checkbox10" type="checkbox"></td>
      </tr>
      <tr>
        <td>01</td>
        <td>第21届星火杯闭幕</td>
        <td>2009-12-20</td>
        <td><div align="center"><a href="">详细</a></div></td>
        <td><div align="center"><a href="">修改</a></div></td>
        <td><div align="center"><a href="">删除</a></div></td>
        <td><input name="checkbox11" type="checkbox"></td>
      </tr>
      <tr>
        <td>01</td>
        <td>第21届星火杯闭幕</td>
        <td>2009-12-20</td>
        <td><div align="center"><a href="">详细</a></div></td>
        <td><div align="center"><a href="">修改</a></div></td>
        <td><div align="center"><a href="">删除</a></div></td>
        <td><input name="checkbox12" type="checkbox"></td>
      </tr>
      <tr>
        <td>01</td>
        <td>第21届星火杯闭幕</td>
        <td>2009-12-20</td>
        <td><div align="center"><a href="">详细</a></div></td>
        <td><div align="center"><a href="">修改</a></div></td>
        <td><div align="center"><a href="">删除</a></div></td>
        <td><input name="checkbox13" type="checkbox"></td>
      </tr>
      <tr>
        <td>01</td>
        <td>第21届星火杯闭幕</td>
        <td>2009-12-20</td>
        <td><div align="center"><a href="">详细</a></div></td>
        <td><div align="center"><a href="">修改</a></div></td>
        <td><div align="center"><a href="">删除</a></div></td>
        <td><input name="checkbox11" type="checkbox"></td>
      </tr>
      <tr>
        <td>01</td>
        <td>第21届星火杯闭幕</td>
        <td>2009-12-20</td>
        <td><div align="center"><a href="">详细</a></div></td>
        <td><div align="center"><a href="">修改</a></div></td>
        <td><div align="center"><a href="">删除</a></div></td>
        <td><input name="checkbox12" type="checkbox"></td>
      </tr>
      <tr>
        <td>01</td>
        <td>第21届星火杯闭幕</td>
        <td>2009-12-20</td>
        <td><div align="center"><a href="">详细</a></div></td>
        <td><div align="center"><a href="">修改</a></div></td>
        <td><div align="center"><a href="">删除</a></div></td>
        <td><input name="checkbox13" type="checkbox"></td>
      </tr>
      <tr>
        <td height="43" colspan="3"><div align="center"><a href="">first</a> <a href="">next</a> <a href="">previous</a> <a href="">last</a></div></td>
        <td colspan="4"><div align="center">
          <input type="submit" name="Submit2" value="delete">
          <input type="submit" name="Submit22" value="select all">
          <input type="submit" name="Submit23" value="reset">
        </div>
            <div align="center"></div></td>
      </tr>
    </table>
  </center>
  </body>
</html>
