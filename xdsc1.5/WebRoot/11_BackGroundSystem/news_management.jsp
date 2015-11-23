<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
  <head>
    <title>My JSP 'news_management.jsp' starting page</title>
    <style type="text/css">
<!--
.STYLE1 {color: #FFFFFF}
.STYLE2 {color: #0000FF}
.STYLE3 {
	font-family: "宋体";
	font-size: 36px;
	font-weight: bold;
	color: #000099;
}
-->
    </style>
</head>
  
  <body bgcolor="#CCCCCC">
  <center>
    <span class="STYLE3">首 页 新 闻 管 理</span>
  </center>
  <br><br>
  <a href="addnews.jsp" class="STYLE2">添加新闻</a>
  <br>
  <br>
  <center>
  <table width="828" height="139" border="1" bordercolor="#999999">
  <tr bgcolor="#0066FF">
    <td width="89" align="center">ID</td>
    <td width="177" align="center">标题</td>
    <td width="182" align="center">时间</td>
    <td width="173" align="center">修改</td>
    <td width="173" align="center">删除</td>
  </tr>
  <tr>
    <td>01</td>
    <td><span class="STYLE1"></span>第21届星火杯闭幕</td>
    <td>2009-12-20</td>
    <td><div align="center"><a href="">修改</a></div></td>
    <td><div align="center"><a href="">删除</a></div></td>
  </tr>
  <tr>
    <td>02</td>
    <td>硕士生报名工作结束</td>
    <td>2009-12-21</td>
    <td><div align="center"><a href="">修改</a></div></td>
    <td><div align="center"><a href="">删除</a></div></td>
  </tr>
    <tr>
    <td colspan="5" align="center">
	<a href="">first</a>
	<a href="">next</a>
	<a href="">previous</a>
	<a href="">last</a>	</td>
    </tr>
</table>
</center>
    
  </body>
</html>
