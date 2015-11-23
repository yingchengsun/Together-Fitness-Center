<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
	<head>
		<title>西安电子科技大学软件学院</title>
		<link href="<%=request.getContextPath()%>/css/index.css"
			rel="stylesheet" type="text/css" />
		<link href="<%=request.getContextPath()%>/css/detail.css"
			rel="stylesheet" type="text/css" />
		<link href="<%=request.getContextPath()%>/css.css" rel="stylesheet"
			type="text/css" />
		<script language="javascript" src="<%=basePath%>/1_mhqx/TableColor.js"></script>
		<script language="javascript" src="<%=basePath%>js/jquery-1.4.2.js"></script>
	
		<script type="text/javascript"
			src="<%=request.getContextPath()%>/js/font-size.js"></script>
						 <style type="text/css">
			
body {
	font-size: 9px;
	color: #000000;
	text-decoration: none;
	height: auto;
	width: auto;
	margin: 0px;
	padding: 0px;
	background-color: #887788;
	line-height: 18px;
	background-image: url('./images/z-bj2.gif');
	background-repeat:repeat-x;
	background-color: #FFFFFF;
}
		</style>
	</head>
<body>

				<table width="100%" border="0" align="center" cellpadding="0"
						cellspacing="0">
						<tr>
							<!-- 位置提示条 -->
								<div id="location">
									您现在的位置 :
										<a href="index.jsp" class="LINK21" target="_top"> 首页</a>
											<s:iterator value="menuTracker">&lt;&lt;
										<a  target="_top"
											href="information!showMenuDetail.action?FMenuId=<s:property value="FMenuId"/>"
												class="LINK21" > <s:property value="FMenuName" /> </a>
											</s:iterator>
								</div>
						
						</tr>
						
						<tr>
							<td valign="top" >
								<table cellspacing="4" cellpadding="0" width="100%"
									align="center" border="0">
									<tbody>
										<tr align="left">
											<td>
												<table width="100%" id="middle" align="center"
													cellspacing="0" cellpadding="0"
													style="word-break: break-all; table-layout: fixed; text-align: left">
													<tr>
														<s:iterator value="menuInfoList">
															<td valign="top">
																<br />
																<div align="center">
																	<h3>
																		<s:property value="FInfoTitle" />
																	</h3>
																</div>
																<table width="97%" align="center">
																	<tr style="font-size: 11px">
																		<td width="50%" align="center">
																			[日期：
																			<span id="TimeLabel"><fmt:formatDate
																					value="${FInfoStartTime}" type="date"
																					dateStyle="long" /> </span> ]
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
																	<s:property value="FInfoContet" escape="false" />
																</div>
															</td>
														</s:iterator>
													</tr>
												</table>
											</td>
										</tr>
										<tr>
											<td id="detail-file">
												<s:if test="FInfoPath.length()>0">
													<span>相关附件：</span>	<a href="<%=basePath %>upfile/<s:property value="FInfoPath"/>"><s:property value="FInfoPath" escape="false" /></a>&nbsp;<img src="<%=basePath %>7_yjssx_system/SubSystemImage/gif-0145.gif" />
												</s:if>
											
												
											</td>
										</tr>
									</tbody>
								</table>
							</td>
						</tr>
					</table>
</body>
</html>