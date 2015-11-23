<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" errorPage="/errorPage.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>资料下载</title>

		<link rel="stylesheet" type="text/css"
			href="<%=request.getContextPath()%>/bksx/css/css.css">
		<link rel="stylesheet" type="text/css"
			href="<%=request.getContextPath()%>/bksx/css/mycss.css">
		<script language="javascript"
			src="<%=request.getContextPath()%>/bksx/js/TableColor.js"></script>
	</head>

	<body>
		<br>
		<br>
		<h3 align="center">
			<img src="<%=request.getContextPath()%>/bksx/pictures/RAR_ZIP.png"
				width="50" height="50" align="middle" />
			资料下载
		</h3>

		<hr>
		<br>
		<div align="center">
		<fieldset style="width: 98%">
		<legend>
			<font size="2">选择查收文档类别</font>
		</legend>
			<table>
				<tr>
					<td>
						<br>
						<br>
						<form action="<%=request.getContextPath()%>/preDownload.action"
							method="post">
							<table>
								<tr>
									<td>
										学生级别
									</td>
									<td>
										<select name="regYear">
											<option value="2006">
												2006
											</option>
											<option value="2007">
												2007
											</option>
											<option value="2008">
												2008
											</option>
											<option value="2009">
												2009
											</option>
											<option value="2010">
												2010
											</option>
											<option value="2011">
												2011
											</option>
											<option value="2012">
												2012
											</option>
										</select>
									</td>
									<td>
										文档类别
									</td>
									<td>
										<select name="fileType">
											<option value="firstStage">
												初期文件
											</option>
											<option value="secondStage">
												中期文件
											</option>
											<option value="thirdStage">
												后期文件
											</option>
											<option value="lunwen">
												毕设论文
											</option>
										</select>
									</td>
									<td>
										<input type="submit" value="查收">
									</td>
								</tr>
							</table>
						</form>
						<br>
						<br>
					</td>
				</tr>
			</table>
</fieldset>
		</div>
		<br>
	</body>
</html>
