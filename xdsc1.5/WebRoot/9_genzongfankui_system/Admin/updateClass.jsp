<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>修改班级</title>
        <base href="<%=basePath%>"> 
		<link rel="stylesheet" type="text/css" href="<%=basePath%>css.css">
		<link rel="stylesheet" type="text/css" href="<%=basePath%>mycss.css">
				<style type="text/css">
		body {
	font-family: arial, 宋体, serif;
	font-size:12px;
	background-image:url("<%=basePath%>Pictures/newbackground.png");
}
		.STYLE5 {
			font-family: "华文行楷";
			font-size: 14mm;
			color: #000000;
		}

		.STYLE6 {
			font-family: "隶书";
			font-size: 12mm;
			color: #000000;
			font-style: italic;
		}
		.STYLE7 {
			font-family: "隶书";
			font-size: 7mm;
			color: #000000;
		}
</style>
		<script language="javascript" src="<%=basePath%>js/TableColor.js"></script>
	</head>

	<body>
		<br>
		<br>
		<h3 align="center">
			<img src="<%=basePath%>Pictures/sketchy_paper_001.png" align="top" border="0" width="50" height="50"/>修改班级信息
		</h3>
		<hr>
		<s:form action="admin/ClassInfo!updateClassInfo.action" method="post" theme="simple">
			<table border="0" id="mytable" width="700">
			
				<tr>
               		<td align="center">班级</td>
               		<td>
                 		<input type="text" value="<s:property value="class1.FClassNumber"/>" name="FClassNumber" disabled="disabled">
               		</td>
             	</tr>
             	<tr>
               <td align="center">总人数</td>
               <td>
                 <input name="FClassTotalNum" type="text" value="<s:property value="class1.FClassTotalNum"/>" name="FClassTotalNum">
               </td>
             </tr>
             <tr>
               <td align="center">男生人数</td>
               <td>
                 <input type="text" value="<s:property value="class1.FClassMaleNum"/>" name="FClassMaleNum">
               </td>
             </tr>
             <tr>
               <td align="center">女生人数</td>
               <td>
                 <input type="text" value="<s:property value="class1.FClassFemaleNum"/>" name="FClassFemaleNum">
               </td>
             </tr>
            
             <tr>
               <td align="center">工作人数</td>
               <td>
                 <input type="text" value="<s:property value="class1.FClassWorkNum"/>" name="FClassWorkNum">
               </td>
             </tr>
             <tr>
               <td align="center">考研人数</td>
               <td>
                 <input type="text" value="<s:property value="class1.FClassKaoYanNum"/>" name="FClassKaoYanNum">
               </td>
             </tr>
             <tr>
               <td align="center">出国人数</td>
               <td>
                 <input type="text" value="<s:property value="class1.FClassAbroadNum"/>" name="FClassAbroadNum">
               </td>
             </tr>
             <tr>
               <td align="center">其他人数</td>
               <td>
                 <input type="text" value="<s:property value="class1.FClassOtherNum"/>" name="FClassOtherNum">
               </td>
             </tr>
             <tr>
               <td colspan="2" align="center">
                 <s:submit value="更新"/>&nbsp;<s:reset value="取消"/>&nbsp;
                 <input type="button" value="返回" onClick="javascript:window.history.go(-1)"/>
               </td>
             </tr>
			</table>

			<br>
		</s:form>
	</body>
</html>
