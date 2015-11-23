<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="/errorPage.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>左侧管理菜单列表</title>
		<link href="css/leftManagement.css" rel="stylesheet" type="text/css" />
	</head>

		<script type="text/javascript" language="javascript" src="<%=basePath%>1_mhqx/admin/js/MenuOpenClose.js"></script>
	<body>

		<!--start of function_Part  -->

		<div class="PI_main" style="height: 500px">
			<div style="position: relative; top: 5%; left: 11px">

				<div id="divsecond">
					<font size="3" color="#ffffff"><strong> 首页各栏目管理</strong> </font>
				</div>

				<div id="PARENT">
					<ul id="nav">
						<li>
							<a href="information!notice.action" target="right">通知公告管理</a>
						</li>
					</ul>
				</div>

				<div id="PARENT">
					<ul id="nav">
						<li>
							<a href="menu!menuManagement.action?location=right" target="right">菜单管理</a>
						</li>

					</ul>
				</div>

				<div id="PARENT">
					<ul id="nav">
						<li>
							<a href="navigation!listAll.action?location=right" target="right">快速导航管理</a>
						</li>

					</ul>
				</div>
				<div id="PARENT">
					<ul id="nav">
						<li>
							<a href="link!listAll.action?location=right" target="right">友情链接管理</a>
						</li>

					</ul>
				</div>
				
					<div id="divsecond">
					<ul>
						<font size="3" color="#ffffff"> <strong> 	
						<a href="menu!menuManagement.action?location=left" target="left" > 其他页面栏目管理</a>
						</strong> </font>
					</ul>
				</div>
				

			<!--一二三级菜单循环读取 -->
			
				<div id="detail-left">

					<ul>
						<s:iterator value="firstList" status="fl">
						<li style="padding-left: 20px;">
							<s:if test="subList[#fl.index].size()>0">
								<span id="show_content_${fl.index}" style="cursor: hand; color: blue;" 
									onclick="javasrcipt:show_sub(${fl.index})">+</span>
							</s:if>
							<s:if test="subList[#fl.index].size()<=0">
								<span>&nbsp;&nbsp;</span>
							</s:if>							
							<a href="information!showMenuToNews.action?FMenuName=<s:property value="FMenuName"/>"
								class="LINK1"  target="right"> <s:property value="FMenuName" /> </a>
							</li>
							<ul>
								<span id="content_detail_${fl.index}"
									style="display: none; align: top; padding-top: 0px; padding-left: 20px;">
									<s:iterator value="subList[#fl.index]" status="sl">
										<li style="padding-left: 20px;">
											<s:if test="thirdList[#fl.index][#sl.index].size()>0">
												<span id="show_content_${sl.index+30}"
													style="cursor: hand; color: blue;"
													onclick="javasrcipt:show_sub(${sl.index+30})">+</span>
											</s:if>
											<s:if test="thirdList[#fl.index][#sl.index].size()<=0">
												<span>&nbsp;&nbsp;</span>
											</s:if>
											<a href="information!showMenuToNews.action?FMenuName=<s:property value="FMenuName"/>"
												class="LINK1"  target="right"> <s:property value="FMenuName" /> </a>
										</li>
										<s:if test="thirdList[#fl.index][#sl.index].size()>0">

											<span id="content_detail_${sl.index+30}"
												style="display: none; align: top; padding-top: 0px; padding-left: 20px;" >

												<s:iterator value="thirdList[#fl.index][#sl.index]">
												<li style="padding-left: 30px;">
												<a href="information!showMenuToNews.action?FMenuName=<s:property value="FMenuName"/>"
														class="LINK1"  target="right"> <s:property value="FMenuName" /> </a>
													</li>
												</s:iterator> </span>
										</s:if>
									
									</s:iterator>
									</span>
								</ul>
						</s:iterator>
					
					</ul>
				</div>



			</div>
		</div>

		<!--end of function_Part  -->
	</body>

</html>