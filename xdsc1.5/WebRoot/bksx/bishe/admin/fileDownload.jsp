<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" errorPage="/errorPage.jsp"%>
<%@page import="org.apache.struts2.ServletActionContext"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.io.*"%>

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
			资料列表
		</h3>

		<hr>
		<br>
		<div align="center">
		<fieldset style="width: 98%">
		<legend>
			<font size="2">查询结果</font>
		</legend>
			<table>
				<tr>
					<td>
						<br>
						<br>
						<%
							String regYear = (String) request.getAttribute("regYear");
							String fileType = (String) request.getAttribute("fileType");
							//使用session前将属性清空
							session.removeAttribute("fyear");
							session.removeAttribute("ftype");
							session.setAttribute("fyear", regYear);
							session.setAttribute("ftype", fileType);
							String path = ServletActionContext.getServletContext().getRealPath(
									"files/6bksx_system/uploadFiles/" + regYear + "/"
											+ fileType);
							File file = new File(path);
							if (!file.exists())
								file.mkdirs();
							File[] files = file.listFiles();
							String dirName = "";
							if (fileType.equals("firstStage")) {
								dirName = "初期文档";
							} else if (fileType.equals("secondStage")) {
								dirName = "中期文档";
							} else if (fileType.equals("thirdStage")) {
								dirName = "后期文档";
							} else {
								dirName = "毕设论文";
							}
							out.println("<div align='center'>");
							out.println("<h5>" + regYear + "届毕业设计" + dirName
									+ "目录下共有以下 <font color='red'>" + files.length
									+ "</font> 个文件</h5><br>");
							out.println("<table>");
							out.println("<tr>");
							out.println("<br>");
							out.println("<th  align='left'>");
							for (int i = 0; i < files.length; i++) {
								String fname = files[i].getName();
								fname = URLEncoder.encode(fname, "UTF-8");
								out.println("[" + (i + 1) + "]");
								out.println("<a href=bksxDownload.action?name=" + fname + ">"
										+ files[i].getName() + "</a>");
								out.println("<br>");
							}
							out.println("</th>");
							out.println("</tr>");
							out.println("</table>");
							out.println("</div>");
							request.setAttribute("length", files.length);
						%>
						<br>
						<c:if test="${length!=0 }">
							<table width="200">
								<tr>
									<td>
										<a
											href="<%=request.getContextPath()%>/downloadAsZip.action"><img
												src="<%=request.getContextPath()%>/bksx/pictures/download.gif"
												border="0" align="top" />打包下载</a>
									</td>
									<td>
										<a
											onclick="javascript: if(window.confirm('确定要清空此目录下所有文件么？')) window.location.href='<%=request.getContextPath()%>/clearFoder.action'; "><img
												src="<%=request.getContextPath()%>/bksx/pictures/delete.gif"
												border="0" align="top"/>清空附件</a>
									</td>
								</tr>
							</table>
						</c:if>
					</td>
				</tr>
			</table>
			</fieldset>
		</div>
		<br>
	</body>
</html>
