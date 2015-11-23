<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"errorPage="/errorPage.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>

		<title>更新图片新闻</title>
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
			更新图片新闻
		</h3>
		<table align="center" width="700">
			<tr>
				<th align="left">
					<a href="information!showNewsByTitle.action"><img
							src="<%=request.getContextPath()%>/1_mhqx/admin/images/return.gif"
							align="top" border="0" />返回</a>
				</th>
			</tr>
		</table>
		<hr>
		<div align="center">
			<form action="picture!update.action" 
				method="post">
				<table width="700" border="0" id="mytable">
					<tr>
						<th colspan="2"
							background="<%=request.getContextPath()%>/1_mhqx/admin/images/bluebar.gif"
							height="30">
							<font color="#FFFFFF">图片新闻更新</font>
						</th>
					</tr>
					<tr>
						<th>
							
						</th>
						<td>
							<input type="hidden" name=" FId" value="${pict.FId }">
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
		                   <td colspan="6">
						    <img style="height:80px; margin:0 0 0 100px" src='<%=request.getContextPath()%>/upfile/<s:property value ="n.FNavigationPicUrl" /> ' /><br />
						    <span> <input type="text" size="60" name="FNavigationPicUrl" value="/upfile/<s:property value ="n.FNavigationPicUrl" />" disabled="disabled"/>
						    <s:file size="60" name="uploadFile" /><small>(点击更换)</small></span>
						</td>
	                  
					</tr>
					
					<tr>
						<th>
							设置最新
						</th>
						<td colspan="2">
								<select name="pict.FZuixin">
									<option value="N">
										否
									</option>
									<option value="Y">
										是
									</option>
								</select>
						</td>
					</tr>
					<tr>
						<th>
							<input type="submit" value="更新">
						</th>
						<th>
							<input type="reset" value="重置">
						</th>
					</tr>
				</table>
			</form>
		</div>
	</body>
</html>
					