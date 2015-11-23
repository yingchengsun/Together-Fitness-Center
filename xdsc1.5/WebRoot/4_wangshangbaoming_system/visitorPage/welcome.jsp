<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>工程硕士网上报名系统首页</title>
		<base href="<%=basePath%>">
		<link rel="stylesheet" type="text/css" href="<%=basePath%>css.css">
		<link rel="stylesheet" type="text/css" href="<%=basePath%>mycss.css">
		<script language="javascript" src="<%=basePath%>js/TableColor.js"></script>
		<style type="text/css">
body {
	font-family: arial, 宋体, serif;
	font-size: 12px;
	background-image:
		url("<%=basePath%>images/4_Pictures/newbackground.png");
}
</style>
	</head>
	<body>
	
		<div align="center" >
			<img width=800 src="<%=basePath%>images/4_Pictures/topcut1.jpg"
				height="135px">				
		</div>
		
		<table width="800px" align="center">
		<tr >
		<th colspan=2>
			<table width=500 align="center"  >
			<form action="login.action">
				<tr>
					<td width="10%">
						用户名：
					</td>
					<td width="10%">
						<input size="8" name="name">
					</td>
					<td width="10%">
						密码:
					</td>
					<td width="10%">
						<input size="8" type="password" name="password">
					</td>
					<td width="10%">
						<input type="submit" value="考生登陆">
					</td>
					<td width="10%">
						<a href="<%=basePath%>4_wangshangbaoming_system/visitorPage/Register.jsp">注册</a>
					</td>
				</tr>
				
			</table>
		
		</th>
		</tr>
			<tr>
				<td width="20%" valign="top">
					<table width="100%">
						<tr>
							<th align="center" colspan=""
							background="<%=basePath%>images/4_Pictures/newmenubg.gif" height="22px" >
							<font color="black">网上报名系统流程说明</font>
							</th>
					</tr>
					<tr><td>
					<div align="left">
						<img src="<%=basePath%>images/4_Pictures/pro.JPG" border=0
							usemap="#mymap">
						<map name="mymap">
							<area shape="rect" coords="25,9,147,36"
								href="<%=basePath%>4_wangshangbaoming_system/visitorPage/zhaoshengjianzhang.html">
							<area shape="rect" coords="180,8,295,40"
								href="<%=basePath%>4_wangshangbaoming_system/visitorPage/Register.jsp">
							<area shape="rect" coords="344,9,456,41"
								href="4_wangshangbaoming_system/visitorPage/Process.jsp">
							<area shape="rect" coords="433,54,522,83"
								href="4_wangshangbaoming_system/visitorPage/Process2.jsp">
							<area shape="rect" coords="355,102,463,136"
								href="4_wangshangbaoming_system/visitorPage/Process3.jsp">
							<area shape="rect" coords="38,71,332,222">
						</map>
					</div>
					</table>
				</td>
				<td valign="top">
				<div style="height: 20px; width: 250px;" class="NewsTitle3 title1">
							<div style="float: left; padding-top: 5px">
								&nbsp;通&nbsp;知&nbsp;公&nbsp;告
							</div>
				</div>
					<div id="marquees" style="width: 200px; height: 150px">
						<ul style="">
							<s:iterator value="listTabNotice">
								<li>
									<a
										href="adAllCheck!sepFindByNoticeNumVisitor.action?FInfoId=<s:property value="FInfoId"/>"
										class="LINK21"><font color="#333333" size="2"> <s:property
												value="FInfoTitle" /> </font> <s:if test="FInfoZuiXin==1">
											<span
												style="color: red; font-size: 10px; text-decoration: blink;">new</span>
										</s:if> </a>
								</li>
							</s:iterator>
						</ul>
					</div>
				</td>

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
											document.body.onload=init;
											
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

			</tr>
			</table>
			<table align="center" width="800"  >
			<tr>
				<td width="38.2%" valign="top">
					<table width="100%">
						<tr>
							<th align="center" colspan="1"
								background="<%=basePath%>images/4_Pictures/newmenubg.gif" height="22px">
								<font size="2" color="black">网上报名常问问题</font>&nbsp;&nbsp;
								<font size="1"><a
									href="<%=basePath%>4_wangshangbaoming_system/visitorPage/FAQ.jsp">...more</a>
								</font>
							</th>
						</tr>
						<tr>
							<td width="38.2%">
								<div align="left">
									Q1:怎样查询自己的录取状态
								</div>
						</tr>
						<tr>
							<td width="38.2%">
								<div align="left">
									Q2:填写信息出错了怎么改正？
								</div>
						</tr>
						<tr>
							<td width="38.2%">
								<div align="left">
									Q3:忘记密码怎么办？
								</div>
						</tr>
						<tr>
							<td width="38.2%">
								<div align="left">
									Q4:忘记账号怎么办？
								</div>
						</tr>
					</table>
					</td>
					<td width="61.8%" valign="top">
					<table width="100%" >
						<tr>
							<th align="center" colspan="3"
								background="<%=basePath%>images/4_Pictures/newmenubg.gif" height="22px">
								网上报名系统考生报考阶段说明&nbsp;
								<a
									href="<%=basePath%>4_wangshangbaoming_system/visitorPage/Process.jsp">...more</a>
								<br>
							</th>
						</tr>
						<tr>
							<td width="25%">
								<div align="left">
									填写个人信息：
								</div>
							</td>
							<td> 
								再您成功完成注册后，您可以凭自己的账号登陆系统.... 
							</td>
						</tr>
						<tr>
							<td>
								<div align="left">
									个人信息验证：
								</div>
							</td>
							<td> 
								您所提交的个人信息，将有助于生成一张考生信息审.... 
							</td>
						</tr>
						<tr>
							<td>
								<div align="left">
									参加学院复试：
								</div>
							</td>
							<td> 
								软件学院将组织复试，报考工程硕士的考生请留意网.... 
							</td>
						</tr>
						<tr>
							<td>
								<div align="left">
									缴纳规定学费：
								</div>
							</td>
							<td> 
								再您获得软件学院工程硕士的预录取通知书后，请您.... 
							</td>
					</table>
					</td>
			</tr>
		</table>


	</body>
</html>
