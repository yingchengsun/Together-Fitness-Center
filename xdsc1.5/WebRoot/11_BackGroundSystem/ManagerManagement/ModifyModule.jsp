<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib  uri="/struts-tags" prefix="s"%> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
	<head>
	    <base href="<%=basePath%>">
		<title>编辑子系统</title>
         <script type="text/javascript" src="<%=basePath%>js/TableColor.js"></script>
		<link href="<%=basePath%>css.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
		<center>
			<s:form action="ModuleAction!updatemodule" method="post">
				<table border="1" id="mytable">
					<tr>
						<td colspan="2" align="center">
							修改子系统
						</td>
					</tr>
					<tr>
					   <td>
					        子系统ID
					   </td>
					   <td>
							<s:textfield name="module.FModuleId" readonly="true"></s:textfield>
					   </td>
					</tr>
					<tr>
						<td>
						    子系统名称
						</td>
						<td>
							<s:textfield name="module.FModuleName"></s:textfield>
						</td>
					</tr>
					<tr>
						<td>
							子系统URL:
						</td>
						<td>
							<s:textfield name="module.FFilePath"></s:textfield>
						</td>
					</tr>
					<tr>
						<s:submit value="提交"></s:submit>
					</tr>
				</table>
			</s:form>
		</center>
	</body>
</html>
