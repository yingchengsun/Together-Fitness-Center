<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		
		<title>西安电子科技大学软件学院</title>
		<link href="css/css.css" rel="stylesheet" type="text/css" />
		<script src="AC_RunActiveContent.js" type="text/javascript"></script>
	</head>
	<body style="height: auto">
		<!-- script language="javascript">
		setInterval("time.innerHTML=new Date().toLocaleString();",1000);
		</script> -->
		<table width="100%" border="0" align="center" cellpadding="0"
			cellspacing="0">
			<tr>
				<td align="center" width="100%" bgcolor=#ffffff colspan="3">
					<!--  embed src="images/top.swf"  width="100%" height="133">
					</embed>-->
					<img src="pictures/topcut.jpg" width="100%" border="0" height="130" style="width: 100%">
				</td>
			</tr>
			<tr  style="background-image: url('pictures/newmenubg.gif')">
			<td height="30" align="left" valign="middle" width="500"
					 >
					&nbsp;&nbsp;|
					<a href="<%=request.getContextPath() %>/8_mail_system/newmail.action" class="a_write" target="mainFrame"><span id="selected"
						>首页</span> </a> |&nbsp;
					
				     <a href="index.jsp" class="a_write" target=_top><span id="selected"
				    	>退出登录</span> </a> |&nbsp;
				</td>
				<!-- td colspan="2" align="right">
					<input type="text" value="--邮件全文搜索--">	
				
					<input type="submit" value="搜索">&nbsp;&nbsp;
				</td-->
				
			</tr>
		</table>
		
	</body>
</html>
