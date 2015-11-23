<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" errorPage="/errorPage.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page import="org.apache.struts2.ServletActionContext"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.io.*"%>
<html>
	<head>
		<title>答辩导入</title>

		<link rel="stylesheet" type="text/css"
			href="<%=request.getContextPath()%>/bksx/css/css.css">
		<link rel="stylesheet" type="text/css"
			href="<%=request.getContextPath()%>/bksx/css/mycss.css">
		<script language="javascript"
			src="<%=request.getContextPath()%>/bksx/js/TableColor.js"></script>

	</head>

	<body>
		
		<br>
		<h3 align="center">
			<img src="<%=request.getContextPath()%>/bksx/pictures/bagong_005.png"
				width="50" height="50" align="middle" />
			答辩安排
		</h3>
		<hr>

		<div align="center">
			<table width="98%" id="mytable" border="1" cellspacing="0">
				<tr>
					<th colspan="6"
						background="<%=request.getContextPath()%>/bksx/pictures/bluebar.gif"
						height="30">
						答辩安排通知列表
					</th>
				</tr>
				<tr>
					<th>
						通知标题
					</th>
					<th>
						通知类型
					</th>
					<th>
						发布时间
					</th>
					<th>
						发布者
					</th>
					<th>
						详细信息
					</th>
				</tr>
				<c:forEach items="${noticeList }" var="notice">
					<tr>
						<td>
							${notice.FInfoTitle }
						</td>
						<td>
							${notice.FInfoType }
						</td>
						<td>
							<fmt:formatDate value="${notice.FInfoStartTime }" type="date"
								dateStyle="medium" />
						</td>
						<td>
							${notice.FInfoFrom }
						</td>
						<td>
							<a
								href="<%=request.getContextPath()%>/noticeDetail.action?id=${notice.FInfoId }"><img
									src="<%=request.getContextPath()%>/bksx/pictures/lookdetail.gif"
									align="middle" border="0" /> </a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<hr>
		<div align="center">
			<fieldset style="width: 98%">
				<legend>
					<font size="2">答辩安排附件列表</font>
				</legend>

				<table>
					<tr>
						<td>
							<br>
							<br>
							<%
								String path = ServletActionContext.getServletContext().getRealPath(
										"files/6bksx_system/uploadFiles/checklist");
								File file = new File(path);
								if (!file.exists())
									file.mkdirs();
								File[] files = file.listFiles();
								out.println("<div align='center'>");
								out.println("<h5>毕业设计答辩共上传了如下 " + files.length + " 个文件</h5>");
								out.println("<table>");
								out.println("<tr>");
								out.println("<th  align='left'>");
								for (int i = 0; i < files.length; i++) {
									String fname = files[i].getName();
									fname = URLEncoder.encode(fname, "UTF-8");
									out.println("[" + (i + 1) + "]");
									out.println("<a href=downloadChecklist.action?name=" + fname
											+ ">" + files[i].getName() + "</a>");
									out.println("<br>");
								}
								out.println("</th>");
								out.println("</tr>");
								out.println("</table>");
								out.println("</div>");
								request.setAttribute("length", files.length);
							%>
							<br>
							<br>
							<c:if test="${length!=0 }">
								<c:if test="${role=='ADMIN' }">
									<a
										onclick="javascript: if(window.confirm('确定要清空此目录下所有文件么？')) window.location.href='<%=request.getContextPath()%>/clearChecklist.action'; "><img
											src="<%=request.getContextPath()%>/bksx/pictures/delete.gif"
											border="0" align="top" />清空附件</a>
								</c:if>
							</c:if>
							<br>

						</td>
					</tr>
				</table>
			</fieldset>
		</div>

		<br>
		<br>
		<br>
	</body>
</html>
