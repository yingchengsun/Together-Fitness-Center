<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
	<head>
		<title>编辑用户</title>
		      <script type="text/javascript" src="<%=basePath%>js/TableColor.js"></script>
              <link href="<%=basePath%>css.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
		<center>
			<s:form action="UserlistAction!updateuser" method="post" theme="simple">
				<table border="1" id="mytable">
					<tr>
						<td colspan="2" align="center">
							编辑用户
						</td>
					</tr>
					<tr>
						<td>
							用户账号
						</td>
						<td>
							<s:textfield name="user.FUserNumber" readonly="true"></s:textfield>
						</td>
					</tr>
					<tr>
						<td>
							用户密码:
						</td>
						<td>
							<s:textfield name="user.FUserPassword"></s:textfield>
						</td>
					</tr>
					<tr>
						<td colspan="2" align="right">
						  <s:submit value="提交"></s:submit>
					    </td>
					</tr>
				</table>
			</s:form>
		</center>
	</body>
</html>
