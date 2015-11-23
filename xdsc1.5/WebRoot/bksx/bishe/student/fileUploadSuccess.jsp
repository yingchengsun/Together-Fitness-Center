<%@ page language="java" pageEncoding="UTF-8" errorPage="/errorPage.jsp"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

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
			上传成功
		</h4>

		<br>
		<hr>
		<br>
		<br>
		<div align="center">
			<table border="1" cellspacing="0" width="98%">
				<tr>
					<td>
						<br>
						<br>
						<table>
							<tr>
								<th>
									文件名称:
								</th>
								<th>
									<font color="green"><s:property value="fileFileName" />
									</font>
								</th>
							</tr>
							<tr>
								<th>
									文件类型:
								</th>
								<th>
									<font color="green"><s:property value="fileContentType" />
									</font>
								</th>
							</tr>
						</table>
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