<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>西安电子科技大学软件学院</title>
		<link href="<%=request.getContextPath()%>/css/index.css"
			rel="stylesheet" type="text/css" />
		<link href="<%=request.getContextPath()%>/css/detail.css"
			rel="stylesheet" type="text/css" />
		<link href="<%=request.getContextPath()%>/css.css" rel="stylesheet"
			type="text/css" />
		<script type="text/javascript"
			src="<%=request.getContextPath()%>/js/font-size.js"></script>
	</head>
	<!-- 页面上部 -->
	

	<body>
		<!--总体框架 -->
		<%@ include file="../top_menu.jsp"%>
		<!-- 中心内容 -->
		<table width="850" height="800" border="0" align="center" cellpadding="0"
			cellspacing="0" style="background-color: #ffffff">
		
			<tr>
				<td width="100%" valign=top bgcolor=#ffffff>
					<table width="100%" border="0" align="center" cellpadding="0"
						cellspacing="0">
						<tr align="left">
							<td>
								<table width="100%" id="middle" align="center" cellspacing="0"
									cellpadding="0"
									style="word-break: break-all; table-layout: fixed; text-align: left">
									<tr>
										<td valign="top">
											<br />
											<div align="center">
												<h3>
													<s:property value="info.FInfoTitle" />
												</h3>
											</div>
											<table width="97%" align="center">
												<tr style="font-size: 11px">
													<td width="50%" align="center">
														[日期：
														<s:property value="info.FInfoStartTime" /> ]
													</td>
													<td width="50%" align="center">
														[字体：
														<a href="javascript:ContentSize(16)">大</a>
														<a href="javascript:ContentSize(14)">中</a>
														<a href="javascript:ContentSize(12)">小</a>]
													</td>
												</tr>
												<tr>
													<td height="5" colspan="2" align="center"></td>
												</tr>
											</table>
											<div id="BodyLabel"
												style="padding: 0px 0px; font-size: 14px; padding-left: 10px">
												<s:property value="info.FInfoContet" escape="false" />
											</div>
										</td>
									</tr>
								</table>
							</td>
						</tr>
						<tr>
							<td id="detail-file">
								<s:if test="info.FInfoPath.length()>0">
									<span>相关附件：</span>
								</s:if>
								<a
									href="download.action?downloadPath='/newsFile/uploadFile/'+<s:property value="info.FInfoPath"/>">
									<s:property value="info.FInfoPath" escape="false" /> </a>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	<!-- start of bottom -->
		<%@ include file="../bottom.jsp"%>
	</body>
</html>
