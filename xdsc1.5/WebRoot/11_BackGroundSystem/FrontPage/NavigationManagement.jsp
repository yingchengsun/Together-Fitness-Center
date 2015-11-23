<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<html>
  <head>
    <title>My JSP 'NavigationManagement.jsp' starting page</title>
		<link href="../css.css" rel="stylesheet" type="text/css" />
  </head>
  <body>
    <table width="431" height="189" border="1" align="center">
  <tr bgcolor="#3399FF">
    <td colspan="2"><div align="center">首 页 导 航 管 理</div></td>
    </tr>
  <tr>
    <td width="137">选择主导航条</td>
    <td width="278"><form name="form1" method="post" action="">
      <label>
        <select name="select">
          <option>--请选择--</option>
          <option>首页</option>
          <option>学院概况</option>
          <option>招生信息</option>
          <option>师资队伍</option>
          <option>学生工作</option>
          <option>科学研究</option>
          <option>实践教学</option>
        </select>
        </label>
    </form>    </td>
    </tr>
  <tr>
    <td>相应子导航条</td>
    <td><select name="select2">
      <option>-------</option>
      <option>学院简介</option>
      <option>组织结构</option>
      <option>学院大事记</option>
        </select></td>
    </tr>
  <tr>
    <td>添加相应子导航</td>
    <td><input name="" type="text" height="20">
      <input type="submit" name="Submit" value="提交">
      <input type="submit" name="Submit2" value="重置"></td>
  </tr>
  <tr>
    <td>添加主导航条</td>
    <td><input name="Input" type="text" height="20">
      <input type="submit" name="Submit3" value="提交">
      <input type="submit" name="Submit22" value="重置"></td>
    </tr>
</table>

  </body>
  
</html>
