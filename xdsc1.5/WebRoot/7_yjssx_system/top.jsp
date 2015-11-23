<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
	<head>
		<title>西安电子科技大学软件学院</title>
		<link href="<%=basePath %>css.css" rel="stylesheet" type="text/css" />
	</head>
	<body >
		
		<table width="100%" border="0" align="center" cellpadding="0"
			cellspacing="0">
			<tr>
				<td align="center" width="100%" bgcolor=#ffffff>
					<img src="pictures/topcut.jpg"  width="100%" height="135px">
				</td>
			</tr>
			<tr   style="background-color: #0948F7">
			<td height="30" align="center" valign="middle" width="100%"
					background="pictures/newmenubg.gif">
					
					<a href="<%=basePath %>yjssxCommon/CommonLogin!LogOut.action" class="a_write" target=_top><span id="selected"
						>退出</span> </a>
				    <!-- 
                    <a href="yjssx_system_forStu.jsp" class="a_write" target=_top><span id="selected"
						>7研究生实习系统（学生）</span></a> |&nbsp; 
					<a href="yjssx_system_forTutor.jsp" class="a_write" target=_top><span id="selected"
						>7研究生实习系统（导师）</span> </a> |&nbsp;
					<a href="yjssx_system_forCompany.jsp" class="a_write" target=_top><span id="selected"
						>7研究生实习系统（企业） </span> </a> |&nbsp;
					<a href="yjssx_system_forAdmin.jsp" class="a_write" target=_top><span id="selected"
						>7研究生实习系统（管理员） </span> </a> |&nbsp;
				    -->
				</td>
			</tr>
		</table>
	</body>
</html>
