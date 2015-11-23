<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>西安电子科技大学软件学院</title>
		<link href="../css.css" rel="stylesheet" type="text/css" />
		<script src="../../../AC_RunActiveContent.js" type="text/javascript"></script>
	</head>
	<body style="height: auto">
		<table width="100%" border="0" align="center" cellpadding="0"
			cellspacing="0">
			<tr>
				<td align="center" width="100%">
					<img src="Pictures/topcut.jpg"  width="100%" height="135px">
				</td>
			</tr>
		</table>
		<div align="center">
						<!-- 登陆-->
						<form action="<%=request.getContextPath()%>/userLogin.action"
							method="post">
							<table width="50%" height="130" border=1
								background="Pictures/new_login_bg.gif">
								
								<tr>
									<td>
										<div align="center">
											用户名：
											<br />
										</div>
									</td>
									<td>
										<div align="center">
											<input type="text" name="FUserNumber" size="15" />
										</div>
									</td>
								</tr>
								<tr>
									<td>
										<div align="center">
											密&nbsp;&nbsp;&nbsp;码：
										</div>
									</td>
									<td>
										<div align="center">
											<input type="password" name="FUserPassword" size="15" />
										</div>
									</td>
								</tr>
								<tr>
									<td colspan="2">
										<input type="radio" name="role" value="teacher"
											checked="checked" />
										辅导员
										<input type="radio" name="role" value="parent" />
										家长
										<input type="radio" name="role" value="manager" />
										管理员
									</td>
								</tr>
								<tr>
									<td colspan="2">
										<input type="submit" value="登陆">
									</td>
								</tr>
							</table>
						</form>
		</div>
	</body>
</html>
