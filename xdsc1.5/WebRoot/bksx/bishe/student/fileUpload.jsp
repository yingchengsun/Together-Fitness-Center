<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" errorPage="/errorPage.jsp"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>资料上传</title>

		<link rel="stylesheet" type="text/css"
			href="<%=request.getContextPath()%>/bksx/css/css.css">
		<link rel="stylesheet" type="text/css"
			href="<%=request.getContextPath()%>/bksx/css/mycss.css">
		<script language="javascript"
			src="<%=request.getContextPath()%>/bksx/js/FormValid.js"></script>
		<script language="javascript"> 
function addComponent() 
{ 
        var uploadHTML = document.createElement( "<input type='file' size='60'  name='file' valid='required' errmsg='请首先选择文件!'/>"); 
        document.getElementById("files").appendChild(uploadHTML); 
        uploadHTML = document.createElement( "<p/>"); 
        document.getElementById("files").appendChild(uploadHTML); 
} 
		</script>


	</head>

	<body>
		<br>
		<br>
		<h3 align="center">
			<img src="<%=request.getContextPath()%>/bksx/pictures/RAR_ZIP.png"
				width="50" height="50" align="middle" />
			文档上传
		</h3>
		<hr>
		<div align="center">
			<table width="98%">
				<tr align="left">
					<td width="600">
					</td>
					<td>
						<input type="button" onclick="addComponent();" value="继续添加" />
					</td>
				</tr>
			</table>
			<div align="center">
				<table border="1" cellspacing="0" width="98%">
					<tr>
						<td>
							<br>
							<br>
							<form action="<%=request.getContextPath()%>/bksxUpload.action"
								method="post" enctype="multipart/form-data"
								onsubmit="return validator(this)">
								<table border="0">
									<tr>
										<th align="right">
											<img
												src="<%=request.getContextPath()%>/bksx/pictures/edit.gif"
												align="top" />
											文件类型:
										</th>
										<th align="left">
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
										</th>
									</tr>
									<tr>
										<td colspan="2">
											<br>
											<span id="files"> <input type='file' size="60"
													name='file' valid="required" errmsg="请首先选择文件!"/>
												<p />
											</span>
										</td>
									</tr>
									<tr>
										<td colspan="2">
											<input type="submit" value="上传" />
										</td>
									</tr>
								</table>
							</form>


						</td>
					</tr>
				</table>

				<br>
				<font size="2" color="green">友情提示：只限上传后缀名为
					JPG、GIF、BMP、PNG、DOC、PPT、XLS、TXT、ZIP的文件<br> 且文件不大于20M </font>
				<br>
				<br>
				<br>
				<br>
			</div>
		</div>
	</body>
</html>
