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
	<link href="<%=request.getContextPath()%>/css.css" rel="stylesheet"
			type="text/css" />
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
<table width="100%" cellspacing="0" cellpadding="0" align="center"
						border="1" id="mytable" style="border-collapse: collapse;" >
						<tr>
							<!-- 位置提示条 -->
								<div id="location">
									您现在的位置 :
										<a href="index.jsp" class="LINK21" target="_top"> 首页</a>
											<s:iterator value="menuTracker">&lt;&lt;
										<a target="_top"
											href="information!showMenuDetail.action?FMenuId=<s:property value="FMenuId"/>"
												class="LINK21"> <s:property value="FMenuName"  /> </a>
											</s:iterator>
								</div>
						
						</tr>
						<tr>
							<td valign="top">
								<table width="80%" border="0" align="center" cellpadding="0"
									cellspacing="0" id="mytable">
									<tr>
										<th colspan="3"
											bgcolor="#0033FF"
											height="30">
											<font color="#FFFFFF"><s:property value="FMenuName" />
											</font>
										</th>
									</tr>
									<tr bgcolor="khaki">
										<td align="center" width=30px>
											编号
										</td>
										<td align="center" width=250px>
											标题
										</td>
										<td align="center" width=110px>
											时间
										</td>
									</tr>
									<s:iterator value="menuInfoList" status="mil">
										<tr>
											<td>
												<s:property value="#mil.index+1" />
											</td>
											<td>
												<a
													href="information!showMenuDetail.action?FMenuName=<s:property value="FMenuName"/>&pid=<s:property value="FInfoId"/>&content=1"
													class="LINK21"><s:property value="FInfoTitle" />
												</a>
											</td>
											<td width="50%" align="center">
												[
												<span id="TimeLabel"><fmt:formatDate
														value="${FInfoStartTime}" type="date" dateStyle="long" />
												</span> ]
											</td>
										</tr>
									</s:iterator>
								</table>
					<table width="80%" border="0" align="center" cellpadding="0"
						cellspacing="0" id="mytable">
						<tr>
							<td width="30px" align="right">
								<a
									href="<%=request.getContextPath()%>/information!showMenuDetail.action?fp=1&content=1">首页</a>
							</td>
							<td width="50px" align="center">
								<a
									href="<%=request.getContextPath()%>/information!showMenuDetail.action?fp=${fp-1}&content=1">上一页</a>
							</td>
							<td width="50px" align="center">
								<a
									href="<%=request.getContextPath()%>/information!showMenuDetail.action?fp=${fp+1}&content=1">下一页</a>
							</td>
							<td width="50px" align="center">
								<a
									href="<%=request.getContextPath()%>/information!showMenuDetail.action?fp=${flastPage}&content=1">末页</a>
							</td>
							<td width="50px" align="center">
								共${flastPage }页
							</td>
						</tr>
					</table></table>
</body>
</html>