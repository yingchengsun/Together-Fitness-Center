<%@ page language="java" pageEncoding="UTF-8" errorPage="/errorPage.jsp"%>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/bksx/css/css.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/bksx/css/mycss.css">
<body>
	<br>
	<br>
	<div align="center">
		<h4>
			<img src="<%=request.getContextPath()%>/bksx/pictures/RAR_ZIP.png"
				width="50" height="50" align="middle" />
			下载成功
		</h4>
		<hr>
		<div align="center">
			<table border="1" cellspacing="0" width="98%">
				<tr>
					<td>
						<br>
						<br>
						<br>
						所有文件已全部下载至<font color="green"><h5>${targetDir }</h5></font>目录下，<a href="${targetDir }" target="_blank"><font color="green">请点此查收！</font>
						<br>
						<br>
						<br>
					</td>
				</tr>
			</table>

		</div>
		<br>
		<br>
		<br>
		<!--  
		<a href="<%=request.getContextPath()%>/bksx/bishe/student/fileDownload.jsp"><img
				src="<%=request.getContextPath()%>/bksx/pictures/subject.gif"
				border="0" align="top" />资料下载</a>
		-->
	</div>

</body>