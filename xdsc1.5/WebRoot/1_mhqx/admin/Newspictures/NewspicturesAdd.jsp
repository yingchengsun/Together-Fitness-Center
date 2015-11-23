<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" errorPage="/errorPage.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>

		<title>添加图片新闻</title>
		<link rel="stylesheet" type="text/css"
			href="<%=request.getContextPath()%>/1_mhqx/admin/css/css1.css">
		<link rel="stylesheet" type="text/css"
			href="<%=request.getContextPath()%>/1_mhqx/admin/css/mycss.css">
		<script language="javascript"
			src="<%=request.getContextPath()%>/1_mhqx/admin/js/TableColor.js"></script>

	</head>

	<body>
		<br>
		<br>
		<h3 align="center">
			添加图片新闻
		</h3>
		<table align="center" width="700">
			<tr>
				<th align="left">
					<a href="information!showNewsByTitle.action" ><img
							src="<%=request.getContextPath()%>/1_mhqx/admin/images/return.gif"
							align="top" border="0" />返回</a>
				</th>
			</tr>
		</table>
		<hr>  
		<div align="center">
			<form action="picture!add.action" 
				method="post" enctype="multipart/form-data">
				<table width="700" border="0" id="mytable">
					<tr>
						<th colspan="2"
							background="<%=request.getContextPath()%>/1_mhqx/admin/images/bluebar.gif"
							height="30">
							<font color="#FFFFFF">图片新闻添加</font>
						</th>
					</tr>
					<tr>
						<th>	
						</th>
						<td>
							<input type="hidden" name="FId" value="${pict.FId }">
						</td>
					</tr>
					<tr>
						<th>
							图片新闻标题
						</th>
						<td>
		                  <input name="pict.FPicTitle" type="text" size="20" label="图片新闻标题："/>
	                   </td>
					</tr>
					<tr>
						<th>
					                   上传图片
						</th>
						<td>
		                  <span> <input type='file' size="60" name="uploadFile" value="浏览"/> </span>
	                   </td>
					</tr>
					
					<tr>
						<th>
							设置最新
						</th>
						<td colspan="2">
								<select name="pict.FZuiXin">
									<option value="N">
										否
									</option>
									<option value="Y">
										是
									</option>
								</select>
								<input type="hidden" name="FInfoId"  value="<%=request.getParameter("FInfoId") %>" />
						</td>
					</tr>
					
					<tr>
						<th>
							 <input type="submit" name="Submit" value="提交" /> 
						</th>
						<th>
							 <input type="reset" name="Submit2" value="重置" />
						</th>
					</tr>
				</table>
			</form>
		</div>
	</body>
</html>