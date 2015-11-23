<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"errorPage="/errorPage.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>通知公告管理</title>
		<base href="<%=basePath%>">
		<link rel="stylesheet" type="text/css" href="<%=basePath%>css.css">
	<style type="text/css">
	body {
		font-family: arial, 宋体, serif;
		font-size: 12px;
		background-image:
			url("<%=basePath%>1_mhqx/admin/images/newbackground.png");
	}
	
	</style>
		<script language="javascript"
			src="<%=basePath%>1_mhqx/admin/js/TableColor.js"></script>
		<script language="javascript"
			src="<%=basePath%>1_mhqx/admin/js/SelectAll.js"></script>
	</head>

	<body>
		<br>
		<h3 align="center">
			通知公告管理
		</h3>
		<hr size="0.5">
		<div align="center">
			<table border="0" width="700">
				<tr>
					<td valign="bottom">
						<form
							action="information!showNoticeByTitle.action"
							method="post">
							<font size="2">按标题查找</font>
							<input type="text" name="FInfoTitle" />
							<input type="submit" value="搜索">
						</form>
					</td>
					<td align="right" valign="middle">
						<a href="1_mhqx/admin/Notice/AdvanceSearch.jsp"><font size="2">高级查找</font> </a>
					</td>
					<td align="center">
						<a href="1_mhqx/admin/Notice/NoticeAdd.jsp"><font size="2">添加通知公告</font> </a>
					</td>
				</tr>
			</table>
		</div>
		<div align="center">
 			 <form action="information!deleteAllInfo.action"
							method="post">
			<table border="0" id="mytable" width="700">
				<tr>
					<th align="center" colspan="9"
						background="<%=basePath%>1_mhqx/admin/images/newmenubg.gif"
						height="30">
						<font color="#FFFFFF">通知公告 </font>
					</th>
				</tr>
				<tr>
					<th width=40px>
						序号
					</th>
					<th>
						标题
					</th>
					<th>
						发布时间
					</th>
					<th width=80px>
						是否置顶
					</th>
					<th width=80px>
						是否最新
					</th>
					<th width=40px>
						编辑
					</th>
					<th width=40px>
						删除
					</th>
					<th width=40px>
						选择
					</th>

				</tr>
				<s:iterator value="tzggList" status="status">
					<tr>
						<td align="center">
							<s:property value="#status.count" />
						</td>
						<td align="center">
							<s:property value="FInfoTitle" />
						</td>
						<td align="center">
							<fmt:formatDate value="${FInfoStartTime}" type="both" />
						</td>
						<td align="center">
							<s:property value="FInfoZhiDing" />
						</td>
						<td align="center">
							<s:if test="FInfoZuiXin==1">
							Y
							</s:if>
							<s:if test="FInfoZuiXin!=1">
							N
							</s:if>
						</td>
						<td align="center">
							<a
								href="information!updateTZGGRedirect.action?FInfoId=<s:property value="FInfoId"/>">编辑</a>

						</td>
						<td align="center">
							<a
								href="information!deleteNotice.action?FInfoId=<s:property value="FInfoId"/>">删除</a>

						</td>
						<td align="center">
							<input name="check" type="checkbox" value="<s:property value="FInfoId"/>">
						</td>

					</tr>
				</s:iterator>

			</table>

			<table width="700">
				<tr>
					<td width="5%">
						<input type="button" value="全选" onclick="selectAll()" />
					</td>

					<td width="5%">
						<input type="button" value="反选" onclick="unSelectAll()" />
					</td>
					<td width="5%">
						<input type="submit" value="删除" />
					</td>
					<td width="26%" align="right">
						<a href="<%=request.getContextPath()%>/information!notice.action?np=1">首页</a>
					</td>
					<td width="6%" align="center">
						<a href="<%=request.getContextPath()%>/information!notice.action?np=${np-1}">上一页</a>
					</td>
					<td width="6%" align="center">
						<a href="<%=request.getContextPath()%>/information!notice.action?np=${np+1}">下一页</a>
					</td>
					<td align="left">
						<a href="<%=request.getContextPath()%>/information!notice.action?np=${nlastPage}">末页</a>
					</td>
					<td align="left">
					       共${nlastPage }页
					</td>
				</tr>
			</table>

			<br>
		</div>

	</body>
</html>
