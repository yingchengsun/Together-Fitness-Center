<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
	<head>
		<base href="<%=basePath%>">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
	</head>
	<script language="javascript">
	function switchSysBar() {
		var leftBar = parent.document.getElementById("left");
		var img = document.getElementById("switch");
		if (leftBar.style.display == "block") {
			leftBar.style.display = "none";
			leftBar.style.width = "0";
			topBar.style.display = "block";
			topBar.style.height = "160px";
			img.src = "images/open_left_frame.jpg";
		} else {
			leftBar.style.display = "block";
			leftBar.style.width = "195px";
			topBar.style.display = "block";
			topBar.style.height = "160px";
			img.src = "images/close_left_frame.jpg";
		}
	}
</script>
	<body style="margin: 0; padding: 0;">
		<a href="#" onclick=javasrcipt: switchSysBar();>
		   <img id="switch" border=0 src="images/close_left_frame.jpg" />
		</a>
	</body>
</html>