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
				 <style type="text/css">
			

		</style>
		<script type="text/javascript"
			src="<%=request.getContextPath()%>/js/font-size.js"></script>
	</head>
	<!-- 页面上部 -->
	
	<script type="text/javascript" language="javascript">

function reinitIframe(){
var iframe = document.getElementById("detail-left");
var mainframe = document.getElementById("rightFrame");
try{
var aHeight = mainframe.contentWindow.document.body.scrollHeight;
var cHeight = mainframe.contentWindow.document.documentElement.scrollHeight;
var height2 = Math.max(aHeight, cHeight);
height =height2;

height =Math.max(height,700);
if(height>height2)
alert("2 "+height);
iframe.height = height;
mainframe.height = height;
}catch (ex){}
}
window.setInterval('reinitIframe()', 200);




			
		function fetch_object(idname)
		{
 			var my_obj = document.getElementById(idname);
 			return my_obj;
		}
		function show_sub(obj)
		{
			var content_detail = fetch_object("content_detail_" + obj);
  			var show_content = fetch_object("show_content_" + obj);
  			if (content_detail.style.display == "block")
  			{
  				 content_detail.style.display="none";
   				 show_content.innerHTML="+";
  			}
  			else
  			{
  				content_detail.style.display="block";
  				show_content.innerHTML="-";
 		    }
		}

	</script>
	<body>
	<!--总体框架 -->
		<%@ include file="../top_menu.jsp"%>
		<table width="850" border="0" align="center" cellpadding="0"
			cellspacing="0" style="">
			<tr>
				<td height="2px" bgcolor=blue colspan="2"></td>
			</tr>
			<tr  style="background-image: url(<%=request.getContextPath()%>/images/z-bj2.gif)">
					<td width=23% valign="top" height=auto >
					<!--左侧树形菜单-->
					<div id="detail-left"  style="font-weight: bold">
						<div id="left-title">
							<s:property value="menu.FMenuName" />
						</div>
						<ul >
							<s:iterator value="secondList" status="sl">
								<li> 
									<s:if
										test="thirdList[menu.FMenuPriority-1][#sl.index].size()>0">
										<span id="show_content_${sl.index}"
											style="cursor: hand; color: blue;padding-left:40px;"
											onclick="javasrcipt:show_sub(${sl.index})">+</span>
									</s:if>
									<s:if
										test="thirdList[menu.FMenuPriority-1][#sl.index]==null">
										<span  style="padding-left:54px"></span>
									</s:if>
									<a
										href="information!showMenuDetail.action?FMenuId=<s:property value="FMenuId"/>&content=1"
										class="LINK21" style="line-height:200%;font-size:15px;" target="rightFrame"><s:property value="FMenuName" />3</a>
								</li>
								<s:if test="thirdList[menu.FMenuPriority-1][#sl.index].size()>0">

									<span id="content_detail_${sl.index}"
										style="display: none;  padding-left:70px;padding-top: 0px;line-height:200%;">
							<!--  		<s:if test="FMenuId==42||FMenuId==43">-->	
										<s:iterator value="thirdList[menu.FMenuPriority-1][#sl.index]">
											<a
												href="information!showMenuDetail.action?FMenuId=<s:property value="FMenuId"/>&content=1"
												class="LINK21" style="line-height: 200%; font-size: 14px;"
											target="rightFrame"	> <s:property value="FMenuName" /></a>
											<br>
									</s:iterator>
									<!-- 		</s:if>
										<s:if test="!(FMenuId==42||FMenuId==43)">
										<s:iterator value="thirdList[menu.FMenuPriority-1][#sl.index]">
											<a
												href="information!showMenuDetail.action?FMenuId=<s:property value="FMenuId"/>&content=1"
												class="LINK21" style="line-height: 200%; font-size: 14px;" target="rightFrame"
											> <s:property value="FMenuName" /> <s:property value="FMenuId" /></a>
											<br>
										</s:iterator>
										</s:if> -->
										</span>
								</s:if>
							</s:iterator>
						</ul>
					</div>
				</td>

				<td width="77%" valign=top id="detail-right">
					<iframe id="rightFrame" name="rightFrame" width="100%"  height="700px"   src="information!showMenuDetail.action?FMenuId=<s:property value="FMenuId"/>&content=1" scrolling="NO" frameborder="0" style="border-style: none;"></iframe>	
				</td>
		</table>
		<!-- start of bottom -->
		<%@ include file="../bottom.jsp"%>
	</body>
</html>
