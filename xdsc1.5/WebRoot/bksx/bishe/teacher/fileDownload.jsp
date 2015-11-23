<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" errorPage="/errorPage.jsp"%>
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
			<table border="1" cellspacing="0" width="98%">
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
							//得到教师的学生提交的文件
							List files = (List) request.getAttribute("myFiles");
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
									+ "目录下您指导的学生共提交了以下 <font color='red'>" + files.size()
									+ "</font> 个文件，如有需要，点击可下载</h5><br>");
							out.println("<table>");
							out.println("<tr>");
							out.println("<br>");
							out.println("<th  align='left'>");
							for (int i = 0; i < files.size(); i++) {
								String fname = ((File) files.get(i)).getName();
								fname = URLEncoder.encode(fname, "UTF-8");
								out.println("[" + (i + 1) + "]");
								out.println("<a href=bksxDownload.action?name=" + fname + ">"
										+ ((File) files.get(i)).getName() + "</a>");
								out.println("<br>");
							}
							out.println("</th>");
							out.println("</tr>");
							out.println("</table>");
							out.println("</div>");
						%>
						<br>
						<br>
						<c:if test="${role=='ADMIN' }">
							<a href="<%=request.getContextPath()%>/clearFoder.action"><img
									src="<%=request.getContextPath()%>/bksx/pictures/001CAO9MEF9.png"
									border="0" width="25" height="25" /> <br>清空附件</a>
						</c:if>
						<br>
					</td>
				</tr>
			</table>
		</div>
		<br>
	</body>
</html>
