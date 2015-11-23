<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		

		<title>My JSP 'newRemind.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">

		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/8_mail_system/css/css.css">
		
<script type="text/javascript">
	</script>

	
	</head>

	<body>
	
	<div style="position: absolute;
		        top: 15%;
		        left: 20%;
		        width: auto;
		        height: auto;
		        
	">
	<table><tr style="height: 30px;"><td bgcolor="orange" width="100" align="center">添加帐户</td></tr></table>
	<div style="position: relative;
		        top: 4%;
		        left: 0%;
		        width: auto;
		        height: auto;
		        border: 1px dashed;
	">
	
		<s:form action="addcontact.action" method="post">
			<table align="center">
				<tr>
					<td>
						用户名:
					</td>
					<td>
						<input type="text" style="width: 200px" name="CUsername">

					</td>
				</tr>
				<tr>
					<td>
						密码:
					</td>
					<td>
						<input type="text" style="width: 200px" name="CPassword">
						<!-- s:textarea name="remind.RTask" cols="30" rows="5" value="输入事务内容"/-->
					</td>
				</tr>
				<tr>
					<td>
						真实姓名:
					</td>
					<td>
						<input type="text" style="width: 200px" name="CName">
					</td>
				</tr>
				<tr>
					<td>
						&nbsp;

					</td>
					<td>
						<input type="submit" value="确定">
						&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;
						<input type="reset" value="重置">
					</td>
				</tr>
			</table>
		</s:form>
		</div>
		</div>
		
	</body>
</html>
