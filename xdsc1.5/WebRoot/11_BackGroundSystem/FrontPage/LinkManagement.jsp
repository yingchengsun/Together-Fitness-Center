<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
  <head>
    <title>My JSP 'news_management.jsp' starting page</title>
    <style type="text/css">

    </style>
	<link href="../css.css" rel="stylesheet" type="text/css" />
</head>
  
  <body>
  <div align="left"><a href="AddLink.jsp">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;添加链接</a>  </div>
  <center>
    <table width="818" height="39" border="1">
      <tr>
        <td width="95" height="33">排序方式</td>
        <td width="150"><form name="form1" method="post" action="">
            <label>
            <select name="select" class="STYLE7">
              <option>------------</option>
              <option>按发布时间排序</option>
              <option>按ID号排序</option>
              <option>按修改时间排序</option>
            </select>
            </label>
        </form></td>
        <td width="78">查找</td>
        <td width="142"><select name="select2" class="STYLE7">
            <option>------------</option>
            <option>链接名称查找</option>
            <option>按ID号查找</option>
            <option>按地址查找</option>
        </select></td>
        <td width="239"><form name="form2" method="post" action="">
            <label></label>
            <label>
            <input name="textfield" type="text" class="STYLE7" maxlength="15" width="200" value="查询内容">
            </label>
        </form></td>
        <td width="74"><input type="submit" name="Submit" value=" 提 交 "></td>
      </tr>
    </table>
    <table width="819" height="524" border="1" bordercolor="#3399FF" >
      <tr bgcolor="#0066FF">
        <td colspan="6" align="center">友 情 链 接 管 理</td>
      </tr>
      <tr bgcolor="#0066FF">
        <td width="81" align="center">ID</td>
        <td width="163" align="center">链接名称</td>
        <td width="177" align="center">链接地址</td>
        <td width="116" align="center">修改</td>
        <td width="122" align="center">删除</td>
        <td width="119" align="center">多选删除</td>
      </tr>
      <tr>
        <td>01</td>
        <td>西安电子科技大学</td>
        <td>www.xidain.edu.cn</td>
        <td><div align="center"><a href="">修改</a></div></td>
        <td><div align="center"><a href="">删除</a></div></td>
        <td><input name="checkbox13" type="checkbox"></td>
      </tr>
      <tr>
        <td>01</td>
        <td>西安电子科技大学</td>
        <td>www.xidain.edu.cn</td>
        <td><div align="center"><a href="">修改</a></div></td>
        <td><div align="center"><a href="">删除</a></div></td>
        <td><input name="checkbox11" type="checkbox"></td>
      </tr>
      <tr>
        <td>01</td>
        <td>西安电子科技大学</td>
        <td>www.xidain.edu.cn</td>
        <td><div align="center"><a href="">修改</a></div></td>
        <td><div align="center"><a href="">删除</a></div></td>
        <td><input name="checkbox12" type="checkbox"></td>
      </tr>
      <tr>
        <td>01</td>
        <td>西安电子科技大学</td>
        <td>www.xidain.edu.cn</td>
        <td><div align="center"><a href="">修改</a></div></td>
        <td><div align="center"><a href="">删除</a></div></td>
        <td><input name="checkbox11" type="checkbox"></td>
      </tr>
      <tr>
        <td>01</td>
        <td>西安电子科技大学</td>
        <td>www.xidain.edu.cn</td>
        <td><div align="center"><a href="">修改</a></div></td>
        <td><div align="center"><a href="">删除</a></div></td>
        <td><input name="checkbox13" type="checkbox"></td>
      </tr>
      <tr>
        <td>01</td>
        <td>西安电子科技大学</td>
        <td>www.xidain.edu.cn</td>
        <td><div align="center"><a href="">修改</a></div></td>
        <td><div align="center"><a href="">删除</a></div></td>
        <td><input name="checkbox11" type="checkbox"></td>
      </tr>
      <tr>
        <td>01</td>
        <td>西安电子科技大学</td>
        <td>www.xidain.edu.cn</td>
        <td><div align="center"><a href="">修改</a></div></td>
        <td><div align="center"><a href="">删除</a></div></td>
        <td><input name="checkbox12" type="checkbox"></td>
      </tr>
      <tr>
        <td>01</td>
        <td>西安电子科技大学</td>
        <td>www.xidain.edu.cn</td>
        <td><div align="center"><a href="">修改</a></div></td>
        <td><div align="center"><a href="">删除</a></div></td>
        <td><input name="checkbox11" type="checkbox"></td>
      </tr>
      <tr>
        <td>01</td>
        <td>西安电子科技大学</td>
        <td>www.xidain.edu.cn</td>
        <td><div align="center"><a href="">修改</a></div></td>
        <td><div align="center"><a href="">删除</a></div></td>
        <td><input name="checkbox12" type="checkbox"></td>
      </tr>
      <tr>
        <td>01</td>
        <td>西安电子科技大学</td>
        <td>www.xidain.edu.cn</td>
        <td><div align="center"><a href="">修改</a></div></td>
        <td><div align="center"><a href="">删除</a></div></td>
        <td><input name="checkbox11" type="checkbox"></td>
      </tr>
      <tr>
        <td>01</td>
        <td>西安电子科技大学</td>
        <td>www.xidain.edu.cn</td>
        <td><div align="center"><a href="">修改</a></div></td>
        <td><div align="center"><a href="">删除</a></div></td>
        <td><input name="checkbox12" type="checkbox"></td>
      </tr>
      <tr>
        <td>01</td>
        <td>西安电子科技大学</td>
        <td>www.xidain.edu.cn</td>
        <td><div align="center"><a href="">修改</a></div></td>
        <td><div align="center"><a href="">删除</a></div></td>
        <td><input name="checkbox13" type="checkbox"></td>
      </tr>
      <tr>
        <td>01</td>
        <td>西安电子科技大学</td>
        <td>www.xidain.edu.cn</td>
        <td><div align="center"><a href="">修改</a></div></td>
        <td><div align="center"><a href="">删除</a></div></td>
        <td><input name="checkbox11" type="checkbox"></td>
      </tr>
      <tr>
        <td>01</td>
        <td>西安电子科技大学</td>
        <td>www.xidain.edu.cn</td>
        <td><div align="center"><a href="">修改</a></div></td>
        <td><div align="center"><a href="">删除</a></div></td>
        <td><input name="checkbox12" type="checkbox"></td>
      </tr>
      <tr>
        <td>02</td>
        <td>Google</td>
        <td>www.google.cn</td>
        <td><div align="center"><a href="">修改</a></div></td>
        <td><div align="center"><a href="">删除</a></div></td>
        <td><input name="checkbox11" type="checkbox"></td>
      </tr>
      <tr>
        <td>02</td>
        <td>Google</td>
        <td>www.google.cn</td>
        <td><div align="center"><a href="">修改</a></div></td>
        <td><div align="center"><a href="">删除</a></div></td>
        <td><input name="checkbox12" type="checkbox"></td>
      </tr>
      <tr>
        <td height="24" colspan="3"><div align="center"><a href="">first</a> <a href="">next</a> <a href="">previous</a> <a href="">last</a></div></td>
        <td colspan="3"><form name="form4" method="post" action="">
          <label>
          <input type="submit" name="Submit2" value="delete">
          </label>
          <input type="submit" name="Submit22" value="selete all">
          <input type="submit" name="Submit23" value="reset">
        </form></td>
      </tr>
    </table>
    <p>&nbsp;</p>
  </center>
  </body>
</html>
