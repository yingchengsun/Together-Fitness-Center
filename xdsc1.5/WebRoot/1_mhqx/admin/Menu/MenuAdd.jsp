<%@ page language="java" import="java.util.*" pageEncoding="utf-8"errorPage="/errorPage.jsp"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="http://java.fckeditor.net" prefix="FCK"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<html>
	<head>
		<base href="<%=basePath%>">
		<link rel="stylesheet" type="text/css" href="<%=basePath%>css.css">
		<title>添加菜单</title>
		<style type="text/css">
body {
	font-family: arial, 宋体, serif;
	font-size: 12px;
	background-image:
		url("<%=basePath%>1_mhqx/admin/images/newbackground.png");
}
</style>
	</head>
	<script type="text/javascript" language="javascript"
		src="<%=basePath%>1_mhqx/admin/js/MenuOpenClose.js"></script>
	<body>
		<br>
		<br>
		<div align="center">
			<h3>
				&nbsp; 添加菜单
			</h3>
			<hr>
			<div align="center">
				<form action="menu!menuAdd.action" method="post"
					enctype="multipart/form-data">
					<table width="80%" border="1" cellspacing="0">
						<tr height="20">
							<th width="15%">
								&nbsp; 标题
							</th>
							<td colspan="2">
								<input type="text" name="menu.FMenuName" size="25%" />
							</td>
						</tr>
<tr>
						<th width="15%">
								优先级
							</th>
							<td colspan="2">
								<input type="text" name="menu.FMenuPriority"
									 size="10%" />
							</td>
						</tr>
						<tr>
						<th width="15%">
								父ID
							</th>
							<td colspan="2">
								<input type="text" name="menu.FSuperMenuId"
									 size="10%" />
							</td>
						</tr>


						<tr height="20">
							<th width="15%" valign="top">
								&nbsp; 位置
							</th>
							<td >

									<s:iterator value="firstList" status="fl">
											<s:if test="subList[#fl.index].size()>0">
												<span id="show_content_${fl.index}" style="cursor: hand;"
													onclick="javasrcipt:show_sub(${fl.index})">+</span>
											</s:if>
											<s:if test="subList[#fl.index].size()<=0">
												<span>&nbsp;&nbsp;</span>
											</s:if>
											<a
												href="information!showMenuToNews.action?FMenuName=<s:property value="FMenuName"/>"
												class="" target="right"> <s:property value="FMenuName" /><br>
											</a>
											<span id="content_detail_${fl.index}"
												style="display: none; align: top; padding-top: 0px;padding-left:20px;">
												<s:iterator value="subList[#fl.index]" status="sl">
														<s:if test="thirdList[#fl.index][#sl.index].size()>0">
															<span id="show_content_${sl.index+30}"
																style="cursor: hand;"
																onclick="javasrcipt:show_sub(${sl.index+30})">+</span>
														</s:if>
														<s:if test="thirdList[#fl.index][#sl.index].size()<=0">
															<span>&nbsp;&nbsp;</span>
														</s:if>
														<a
															href="information!showMenuDetail.action?FMenuName=<s:property value="menu.FMenuName"/>"
															class="" target="right"> <s:property
																value="FMenuName" /> </a><br>
													<s:if test="thirdList[#fl.index][#sl.index].size()>0">

														<span id="content_detail_${sl.index+30}"
															style="display: none; align: top; padding-top: 0px; padding-left: 30px; list-style-type: none;">

															<s:iterator value="thirdList[#fl.index][#sl.index]">
																<a
																	href="information!showMenuDetail.action?FMenuName=<s:property value="menu.FMenuName"/>"
																	class="" target="right"> <s:property
																		value="FMenuName" /> </a>
																<br>
															</s:iterator> </span>
													</s:if>

												</s:iterator> </span>
									</s:iterator>




							</td>
						</tr>
						<tr>
							<td colspan="3" align="center">
								<input type="submit" value="确定">
								<input type="reset" value="重填">
							</td>

						</tr>
					</table>
				</form>
			</div>
	</body>
</html>
