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
	<script type="text/javascript" language="javascript">

		function ContentSize(size)
		{
			var obj=document.getElementById("BodyLabel");
			obj.style.fontSize=size+"px";
		}	
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

		<!--start of function_Part  -->

		<div class="PI_main" style="height: 500px">
			<div style="position: relative; top: 5%; left: 11px">

				<div id="divsecond">
					<font size="3" color="#ffffff"><strong> 首页各类新闻管理</strong> </font>
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
							<a href="information!news.action" target="right">学院新闻管理</a>
						</li>
					</ul>
				</div>

				<div id="PARENT">
					<ul id="nav">
						<li>
							<a href="information!corp.action" target="right">企业合作管理</a>
						</li>
					</ul>
				</div>

				<div id="PARENT">
					<ul id="nav">
						<li>
							<a href="information!recruit.action" target="right">招贤纳士管理</a>
						</li>
					</ul>
				</div>

				<div id="PARENT">
					<ul id="nav">
						<li>
							<a href="information!job.action" target="right">招生就业管理</a>
						</li>
					</ul>
				</div>
				<div id="PARENT">
					<ul id="nav">
						<li>
							<a href="information!menuManagement.action" target="left"> 菜单对应各页面管理</a>
						</li>
					</ul>
				</div>


				<div id="detail-left">

					<ul>
						<s:iterator value="firstList" status="fl">
							<li style="padding-left: 20px;">
							<s:if test="subList[#fl.index].size()>0">
												<span id="show_content_${fl.index}"
													style="cursor: hand; color: blue;"
													onclick="javasrcipt:show_sub(${fl.index})">+</span>
											</s:if>
								<s:property value="FMenuName" />
								<ul>
								<span id="content_detail_${fl.index}"
												style="display: none; align: top; padding-top: 0px; padding-left: 20px;">
									<s:iterator value="subList[#fl.index]" status="sl">
										<li>
											<s:if test="thirdList[#fl.index][#sl.index].size()>0">
												<span id="show_content_${sl.index}"
													style="cursor: hand; color: blue;"
													onclick="javasrcipt:show_sub(${sl.index})">+</span>
											</s:if>
											<s:if test="thirdList[#fl.index][#sl.index].size()<=0">
												<span>-</span>
											</s:if>
											<a
												href="information!showMenuDetail.action?FMenuName=<s:property value="FMenuName"/>">
												<s:property value="FMenuName" /> </a>
										</li>
										<s:if test="thirdList[#fl.index][#sl.index].size()>0">

											<span id="content_detail_${sl.index}"
												style="display: none; align: top; padding-top: 0px; padding-left: 20px;" >

												<s:iterator value="thirdList[#fl.index][#sl.index]">
												<br>
													<a
														href="information!showMenuDetail.action?FMenuName=<s:property value="menu.FMenuName"/>"
														class="LINK1"> <s:property value="FMenuName" /> </a>
													<br>
												</s:iterator> </span>
										</s:if>
									</s:iterator>
									</span>
								</ul>
							</li>
						</s:iterator>
					</ul>
				</div>


				<div id="divsecond">
					<ul>
						<font size="3" color="#ffffff"> <strong> 其他类目管理</strong> </font>
					</ul>
				</div>

				<div id="PARENT">
					<ul id="nav">
						<li>
							<a href="information!menuManagement.action" target="right">菜单栏管理</a>
						</li>

					</ul>
				</div>
				<div id="PARENT">
					<ul id="nav">
						<li>
							<a href="newsp.action" target="right">图片新闻管理</a>
						</li>

					</ul>
				</div>

				<div id="PARENT">
					<ul id="nav">
						<li>
							<a href='<s:url action="Navigation_list"></s:url>' target="right">快速导航管理</a>
						</li>

					</ul>
				</div>
				<div id="PARENT">
					<ul id="nav">
						<li>
							<a href='<s:url action="Link_list"></s:url>' target="right">友情链接管理</a>
						</li>

					</ul>
				</div>



			</div>
		</div>

		<!--end of function_Part  -->
	</body>

</html>