<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<title>西安电子科技大学软件学院</title>
		<link href="css.css" rel="stylesheet" type="text/css" />
	</head>
	<style type="text/css">
/**<!--
	body {
		filter:gray;
	}*/
-->
</style>
	<script type="text/javascript">
		<!--	
			function goTheme(){
				if (document.form2.cboTheme.options[document.form2.cboTheme.selectedIndex].value !=""){
					//self.location.href=document.form2.cboTheme.options[document.form2.cboTheme.selectedIndex].value;
						window.open(document.form2.cboTheme.options[document.form2.cboTheme.selectedIndex].value,'PopularSite','location=yes,toolbar=yes,menubar=yes,directories=yes,status=yes,resizable=yes,scrollbars=yes,width=1000,height=800');
				}				
			}
		//-->
</script>
	<BODY>
		<%@ include file="1_mhqx/top_menu.jsp"%>

		<table width="850" border="0" align="center" cellpadding="0"
			cellspacing="0" style="background-image: url('images/z-bj2.gif');">
			<!-- start of left -->
			<td valign=top height="515px" width="30%">
				<!-- start of notice -->
				<div>
					<div style="height: 30px;" class="NewsTitle3 title1">
						<div style="padding-top: 5px;">
							&nbsp;通知公告
						</div>
					</div>
					<div id="marquees" style="width: 200px; height: 150px">
						<ul style="">
							<s:iterator value="tzggList">
								<li>
									<a
										href="information!showInformationsDetail.action?FInfoId=<s:property value="FInfoId"/>"
										class="LINK21"><font color="#333333" size="2"> <s:property
												value="FInfoTitle" /> </font> <s:if test="FInfoZuiXin==1">
											<span
												style="color: red; font-size: 10px; text-decoration: blink;">new</span>
										</s:if> </a>
								</li>
							</s:iterator>
						</ul>
					</div>
					<div style="width: 100%;">
					</div>
				</div>

				<script language="JavaScript">
											marqueesHeight=158;
											stopscroll=false;				
											with(marquees){
											   style.width=180;
											   style.height=marqueesHeight;
											   style.overflowX="visible";
											   style.overflowY="hidden";
											   noWrap=true;
											   onmouseover=new Function("stopscroll=true");
											   onmouseout=new Function("stopscroll=false");
											}
											document.write('<div id="templayer" width="180" style="position:absolute;z-index:1;visibility:hidden"></div>');
											
											preTop=0; currentTop=0; 
											
											function init(){
											   templayer.innerHTML="";
											   while(templayer.offsetHeight<marqueesHeight){
											     templayer.innerHTML+=marquees.innerHTML;
											        if(templayer.offsetHeight==0)
    													 break;
											   }
											   marquees.innerHTML=templayer.innerHTML+templayer.innerHTML;
											   setInterval("scrollUp()",50);
											}
											window.onload=init;
											document.body.onload=init;火狐不支持
											
											function scrollUp(){
											   if(stopscroll==true) return;
											   preTop=marquees.scrollTop;
											   marquees.scrollTop+=1;
											   if(preTop==marquees.scrollTop){
											     marquees.scrollTop=templayer.offsetHeight-marqueesHeight;
											     marquees.scrollTop+=1;
											   }
											}
									</script>



				<!-- end of notice -->
				<!-- start of navigation -->
				<div>
					<div style="height: 10px;" class="NewsTitle3 title1">
						<div style="padding-top: 5px">
							&nbsp;快速导航
						</div>
					</div>
					<!-- 左侧 快速导航 -->
					<div style="width: 220px;">
						<ul style="position: 固定; margin: 0px; text-align: center;">
						
					   <s:iterator value="NavigationList">
							<a href="<s:property value="FNavigationUrl"/>" class="LINK21"><img
									src="upfile/<s:property value="FNavigationPicUrl"/>" border=0 /> </a>
							<br>
						</s:iterator>
							<div style="width: 220px; background-color: sliver">
							</div>
						</ul>
					</div>
				</div>

				<!-- end of navigation -->
				<!-- start of friend-link -->
				<div
					style="height: 50px; float: left; display: block; z-index: 0; width: 210px"
					class="NewsTitle3 title1">
					<div style="padding-top: 5px">
						&nbsp;友情链接
					</div>
				</div>
				<form name=form2 style="padding-left: 23px; width: 210px;">
					<select name=cboTheme>

						<option>
							------ 请选择 -------
						</option>
						<s:iterator value="linkList">
							<option value="http://<s:property value="FLinkUrl"/>">
								<s:property value="FLinkTitle" />
							</option>
						</s:iterator>
					</select>
					<a href="javascript:goTheme();" class="LINK11">&nbsp;&nbsp;GO</a>
				</form>

				<!-- end of friend-link -->
			</td>
			<!-- end of left -->
			<!-- start of middle -->
			<td class="middleBody" valign=top
				style="background-image: url('images/z-bj2.gif')">
				<!-- start of news -->
				<div>
					<div
						style="height: 237px; width: 350px; background-image: url('images/News_2.jpg'); background-repeat: no-repeat;">

					</div>
				</div>
				<!-- end of news -->
				<div style="">
					<div style="height: 30px; width: 320px;" class="NewsTitle title1">
						<div style="padding-top: 5px">
							&nbsp;学院新闻
						</div>
					</div>
					<div style="padding-left: 5px;">
						<table>
							<s:iterator value="xyxwList">
								<tr>
									<td width=230px>
										<img src="images/dotblue.gif" />
										<a
										href="information!showInformationsDetail.action?FInfoId=<s:property value="FInfoId"/>"
										class="LINK21"><font color="#333333" size="2"> <s:property
												value="FInfoTitle" /> </font> <s:if test="FInfoZuiXin==1">
											<span
												style="color: red; font-size: 10px; text-decoration: blink;">new</span>
										</s:if> </a>
										<!--  
										<a class="LINK21"
											href="information!showMenuDetail.action?FMenuId=-1&pid=<s:property value="FInfoId"/>&FMenuName=<s:property value="FInfoType"/>&FInfoId=<s:property value="FInfoId"/>"><s:property
												value="FInfoTitle" /> <s:if test="FInfoZuiXin==1">
												<span
													style="color: red; font-size: 10px; text-decoration: blink;">new</span>
											</s:if> </a>-->
									</td>
									<td>
										<span style="" class="date"> --[ <fmt:formatDate
												value="${FInfoStartTime}" type="date" dateStyle="long" /> ]
										</span>
									</td>
								</tr>
							</s:iterator>
						</table>
					</div>
				</div>
			</td>
			<!-- end of middle -->
			<!--start of right  -->
			<td class="leftbar" valign=top width=auto
				style="background-image: url('images/z-bj2.gif')">

				<div style="height: 30px; width: 250px;" class="NewsTitle3 title1">
					<div style="padding-top: 5px">
						&nbsp;学生就业
					</div>
				</div>
				<div style="padding-left: 1px; padding-right: 1px; height: 150px;">
					<div style="padding-left: 5px; width: 250px;">
						<table>
							<s:iterator value="zsjyList">
								<tr>
									<td>
										<img src="images/dotblue.gif" />
										<a class="LINK21"
											href="information!showMenuDetail.action?FMenuId=-1&pid=<s:property value="FInfoId"/>&FMenuName=<s:property value="FInfoType"/>&FInfoId=<s:property value="FInfoId"/>"><s:property
												value="FInfoTitle" /> <s:if test="FInfoZuiXin==1">
												<span
													style="color: red; font-size: 10px; text-decoration: blink;">new</span>
											</s:if> </a>
									</td>
								</tr>
							</s:iterator>
						</table>
					</div>
				</div>
				<div style="height: 30px; width: 250px;" class="NewsTitle3 title1">
					<div style="padding-top: 5px">
						&nbsp;合作交流
					</div>
				</div>
				<div style="padding-left: 1px; padding-right: 1px; height: 150px;">
					<div style="padding-left: 5px; width: 250px;">
						<table>
							<s:iterator value="hzjlList">
								<tr>
									<td>
										<img src="images/dotblue.gif" />
										<a class="LINK21"
											href="information!showMenuDetail.action?FMenuId=-1&pid=<s:property value="FInfoId"/>&FMenuName=<s:property value="FInfoType"/>&FInfoId=<s:property value="FInfoId"/>"><s:property
												value="FInfoTitle" /> <s:if test="FInfoZuiXin==1">
												<span
													style="color: red; font-size: 10px; text-decoration: blink;">new</span>
											</s:if> </a>
									</td>
								</tr>
							</s:iterator>
						</table>
					</div>
				</div>
				<div style="height: 30px; width: 250px;" class="NewsTitle3 title1">
					<div style="padding-top: 5px; width: auto;">
						&nbsp;招贤纳士
					</div>
				</div>
				<div style="padding-left: 1px; padding-right: 1px; height: 150px;">
					<div style="padding-left: 5px; width: 250px;">
						<table>
							<s:iterator value="zxnsList">
								<tr>
									<td>
										<img src="images/dotblue.gif" />
										<a class="LINK21"
											href="information!showMenuDetail.action?FMenuId=-1&pid=<s:property value="FInfoId"/>&FMenuName=<s:property value="FInfoType"/>&FInfoId=<s:property value="FInfoId"/>"><s:property
												value="FInfoTitle" /> <s:if test="FInfoZuiXin==1">
												<span
													style="color: red; font-size: 10px; text-decoration: blink;">new</span>
											</s:if> </a>
									</td>
								</tr>
							</s:iterator>
						</table>
					</div>
				</div>
			</td>
			<!-- end of right -->
		</table>

		<!-- start of bottom -->
		<%@ include file="1_mhqx/bottom.jsp"%>

		<!-- end of bottom -->
	</body>
</html>
