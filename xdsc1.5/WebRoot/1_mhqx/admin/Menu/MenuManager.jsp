<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" errorPage="/errorPage.jsp"%>
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
		<title>菜单操作</title>
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
	<script type="text/javascript" language="javascript">
	</script>
	<body>
		<br>
		<h3 align="center">
			<s:property value="CurrentMenu.FMenuName" />维护
		</h3>
		<hr size="0.5">
<div align=center>
			<a
				href="<%=request.getContextPath()%>/1_mhqx/admin/Menu/HTMenuList.jsp"><img
					src="<%=request.getContextPath()%>/1_mhqx/admin/images/return.gif"
					align="top" border="0" />返回查询页面</a>
		</div>
		<div align="center">
			<table border="0" width="700">
				<tr>
					<td >
						<s:if test="IsShouYe!=1">
						<form action="HTMenu!changeName.action" method="post">
							<font size=2 color=royalblue>修改菜单名称 :</font>&nbsp
							<input type="text" name="name"
								value="<s:property value="CurrentMenu.FMenuName"/>"></input>
							<input type="submit" name="submit" value="提交">
						</form>
						</s:if>
					</td>
				</tr>
			</table>
			<table border="0" width="700">
				<tr>
					<td valign="top" width="25%">
						<s:if test="IsShouYe!=1">
						<img src="<%=basePath%>/images/go.gif" style="visibility: visible">
						&nbsp
						<a href="HTMenu!menuManager.action">调整优先级</a>
						</s:if>
					</td>
					<td valign="top" width="25%">
						<s:if test="!Leaf">
						<img src="<%=basePath%>/images/go.gif" style="visibility: hidden">
						&nbsp
						<a href="HTMenu!preaddMenu.action">插入子菜单</a>
						</s:if>
					</td>
					<td valign="top" width="25%">
						<s:if test="!Leaf">
						<img src="<%=basePath%>/images/go.gif" style="visibility: hidden">
						&nbsp
						<a href="HTMenu!predelete.action">删除子菜单</a>
						</s:if>
					</td>
					<td valign="top" width="25%">
						<s:if test="!Leaf">
						<img src="<%=basePath%>/images/go.gif" style="visibility: hidden">
						&nbsp
						<a href="HTMenu!subMenuList.action">查看子菜单</a>
						</s:if>
					</td>
				</tr>

			</table>
		</div>

		<hr size="0.5">
	   <div style="font-size: 12px; color: red">
				<c:forEach items="${errorlist}" var="error">
					<option>
					${error}
					</option>
				</c:forEach>
				<% session.removeAttribute("errorlist"); 
				%>
			</div>
		<div align="center">
			<table border="0" width="700">
			
				<tr>
					<td width=100% bgcolor=royalblue align="center">
						
						<s:if test="IsShouYe!=1">	
						<span><font size=2 color=white>点击进入上一级菜单维护：</font></span>	
						<s:if test="CurrentfatherMenu!=null">
						<font size=2 color=black></font>	
						<span>
						<font size=2 color=white>
						<a href="HTMenu!menuManager.action?mid=<s:property value="CurrentfatherMenu.FMenuId"/>" style="color:#ffffff;">
						<s:property value="CurrentfatherMenu.FMenuName"/>
						</a>
						</font>
						</span>
						</s:if>
						
						<s:if test="CurrentfatherMenu==null">
						<span>
						<font size=2 color=white>
					     <a class="LINK21" href="HTMenu!menuManager.action?mid=0&Leaf=false" style="color:#ffffff;">
							根菜单
						 </a>
						</font>
						</span>
						
						</s:if>
						</s:if>
						</td>
						</tr>
						<tr>
						<td align="center">
						<br><br>
							<s:iterator value="sameLevelmenulist" status="sl">
								<s:if test="mid==sameLevelmenulist.get(#sl.index).FMenuId">
								当前菜单->  <s:property
											value="FMenuPriority" /> :<span style="background-color: royalblue">
											
											<a style="color:purple" href="HTMenu!menuManager.action?mid=<s:property value="FMenuId"/>">
						<s:property value="FMenuName"/>
						</a>
										
									</span>
									<br><br>
								</s:if>
								<s:if test="mid!=sameLevelmenulist.get(#sl.index).FMenuId">
								<span style="padding-left:64px"><s:property
											value="FMenuPriority" /> :
											<a style="color:royalblue" href="HTMenu!menuManager.action?mid=<s:property value="FMenuId"/>">
						<s:property value="FMenuName"/>
						</a>
											
									</span>
									<br><br>
								</s:if>
							</s:iterator>
						
					</td>
				</tr>
				<tr>
					<td align="right">
						<s:if test="IsShouYe!=1">
						<s:if test="isfirst!=1">
						<img src="<%=basePath%>/images/up.gif" /><a href="HTMenu!swichMenu.action?swichtype=1" class="LINK21" STYLE="color:royalblue">上移</a>
						</s:if>&nbsp&nbsp&nbsp&nbsp
						<s:if test="islast!=1">
						<img src="<%=basePath%>/images/down.gif" /><a href="HTMenu!swichMenu.action?swichtype=0" class="LINK21" STYLE="color:royalblue">下移</a>
						</s:if>
						</s:if>
					</td>
				</tr>
			</table>

		</div>

	</body>
</html>
