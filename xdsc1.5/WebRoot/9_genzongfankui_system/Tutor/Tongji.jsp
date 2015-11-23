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
		<title>毕业去向统计</title>
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
			毕业去向统计
		</h3>
		<hr>
		<s:form action="tutor/Tongji!findClassoneByNum.action" method="post" theme="simple">
				<table width="80%" border="0" align="center">
					<tr>
						<td align="left">
							查询班级:
							<s:textfield name="FClassNumSelect" />
							&nbsp;
							<s:submit value="提交" />
						</td>

					</tr>
				</table>
			</s:form>
		<hr>
		<div align="center">
		
			<table border="0" id="mytable" width="700">
				<tr>
					<th align="center" colspan="9" background="<%=basePath%>Pictures/newmenubg.gif" height="30">
						<font color="#FFFFFF">软件学院毕业去向统计</font>
					</th>
				</tr>
				<tr>
				<th>
						序号
					</th>
					<th>
						班级
					</th>
					<th>
						总人数
					</th>
					<th>
						工作人数
					</th>
					<th>
						考研人数
					</th>
					<th>
						出国人数
					</th>
					<th>
						其他人数
					</th>
					<th>
						花名册
					</th>
					

				</tr>
				<s:iterator value="listClassInfo" status="status">
				   <tr>
				     <td align="center"><s:property value="#status.count"/></td>
				     <td align="center"><s:property value="FClassNumber"/></td>
				     <td align="center"><s:property value="FClassTotalNum"/></td>
				     <td align="center"><s:property value="FClassWorkNum"/></td>
				     <td align="center"><s:property value="FClassKaoYanNum"/></td>
				     <td align="center"><s:property value="FClassAbroadNum"/></td>
				     <td align="center"><s:property value="FClassOtherNum"/></td>
				     <td>查看<a href="Jiangcheng.jsp"><img src="<%=basePath%>Pictures/userinfo.gif" align="middle" border="0"> </a></td>
		
				   </tr>
			</s:iterator>
				
			</table>
	
<s:form action="tutor/ClassInfo!findGradeByNum.action" method="post" theme="simple">
				<table width="80%" border="0" align="center">
					<tr>
						<td align="left">
							查询年级:
							<s:textfield name="FGradeNumSelect" />
							&nbsp;
							<s:submit value="提交" />
						</td>
						
					</tr>
				</table>
			</s:form>

			<br>
		</div>

	</body>
</html>
