<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
	<head>
	    <base href="<%=basePath%>">
		<title>西安电子科技大学软件学院</title>
		<link href="css.css" rel="stylesheet" type="text/css" />
		<script src="AC_RunActiveContent.js" type="text/javascript"></script>
	</head>
	<body style="height: auto">
		<script language="javascript">
		setInterval("time.innerHTML=new Date().toLocaleString();",1000);
		</script>
		<table width="100%" border="0" align="center" cellpadding="0"
			cellspacing="0">
			<tr>
				<td align="center" width="100%">
					<img src="pictures/topcut.jpg"  width="100%" height="135px">
				</td>
			</tr>
			
			<tr   style="background-color: #0948F7">
			<td height="30px" align="center" valign="middle" width="700"
					background="pictures/newmenubg.gif" >
					|
					<a href="index.jsp" class="a_write" target=_top><span id="selected"
						>首页</span> </a> |&nbsp;
					<a href="3_jiaofu_system/teacher/jf_teacher.jsp" class="a_write" target=_top><span id="selected"
						>3课程教辅(teacher)</span> </a> |&nbsp;
						<a href="3_jiaofu_system/student/jf_student.jsp" class="a_write" target=_top><span id="selected"
						>3课程教辅(student)</span> </a> |&nbsp;
						<a href="3_jiaofu_system/assistant/jf_assistant.jsp" class="a_write" target=_top><span id="selected"
						>3课程教辅(assistant)</span> </a> |&nbsp;
					<a href="3_jiaofu_system/administrator/jf_manager.jsp" class="a_write" target=_top><span id="selected"
						>3教辅后台</span> </a> |&nbsp;
				</td>
			</tr>
		</table>
	</body>
</html>
