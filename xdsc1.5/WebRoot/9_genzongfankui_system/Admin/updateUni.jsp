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
		<title>修改升学学校</title>
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
			<img src="<%=basePath%>Pictures/sketchy_paper_001.png" align="top" border="0" width="50" height="50"/>升学学校信息
		</h3>
		<hr>
		<s:form action="admin/UniInfo!updateUniInfo.action" method="post" theme="simple">
			<table border="0" id="mytable" width="700">
			
				<tr>
               		<td align="center">编号</td>
               		<td>
                 		<input type="text" value="<s:property value="uni.FId"/>" name="FId" disabled="disabled">
               		</td>
             	</tr>
             	<tr>
               <td align="center">高校名称</td>
               <td>
                 <input type="text" value="<s:property value="uni.FUniName"/>" name="FUniName">
               </td>
             </tr>
                          	<tr>
               <td align="center">国家</td>
               <td>
                 <input type="text" value="<s:property value="uni.FUniCountry"/>" name="FUniCountry">
               </td>
             </tr>
                       	<tr>
               <td align="center">城市</td>
               <td>
                 <input type="text" value="<s:property value="uni.FUniCity"/>" name="FUniCity">
               </td>
             </tr>
                       	<tr>
               <td align="center">高校地址</td>
               <td>
                 <input type="text" value="<s:property value="uni.FUniAddress"/>" name="FUniAddress">
               </td>
             </tr>
                       	<tr>
               <td align="center">电子邮件</td>
               <td>
                 <input type="text" value="<s:property value="uni.FUniEmail"/>" name="FUniEmail">
               </td>
             </tr>
                      	<tr>
               <td align="center">联系电话</td>
               <td>
                 <input type="text" value="<s:property value="uni.FUniTel"/>" name="FUniTel">
               </td>
             </tr>
                         	<tr>
               <td align="center">公司简介</td>
               <td>
                 <input type="text" value="<s:property value="uni.FUniIntro"/>" name="FUniIntro">
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
