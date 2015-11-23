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
	<body style="height: auto;">
		<script language="javascript">
setInterval("time.innerHTML=new Date().toLocaleString();",1000);
setInterval("changeNewsSpanByTime();",3000);
function changeNewsSpanByTime(){
var index=1;
var block;
var span;
for (i = 1; i<= 3; i++  )
 {
  block = fetch_object("news_block" + i);
  span=fetch_object("NewsKindSpan" + i);
  if(block.style.display =="block")
  {
 		index=i%3+1;
 		break;
  }
 }
NewsKind(index);
}		
		
function fetch_object(idname)
{
 var my_obj = document.getElementById(idname);
 return my_obj;
}

function NewsKind(obj)
{
for (i = 1; i<= 5; i++  )
 {
  var news_block = fetch_object("news_block" + i);
  var news_span=fetch_object("NewsKindSpan" + i);
  if (obj == i)
  {
   news_block.style.display = "block";
   news_span.style.background="url(images/span01.gif)";
  }
  else
  {
   news_block.style.display="none";
   news_span.style.background="url(images/span02.gif)";
  }
 }
}


function wskm_nav(obj)
{
 for (i = 1; i<= 20; i++  )
 {
  var sub_nav = fetch_object("sub_nav_" + i);
  if (obj == i)
  {
   sub_nav.style.display = "block";
  }
  else
  {
   sub_nav.style.display="none";
  }
 }
}

</script>
		<table width="700" border="0" align="center" cellpadding="0"
			cellspacing="0">
			<tr>
				<td>
					<embed src="images/top.swf" align="middle" width="700" height="133">
					</embed>
				</td>
			</tr>
			<tr style="background-color: #0948F7">
				<td height="37" align="left" valign="middle" width="500"
					background="/images/mune02.gif" class="text_write">
					|
					<a href="#" class="a_write"><span id="selected"
						onmouseover="javasrcipt:wskm_nav(0)">首 页</span> </a> |&nbsp;
					<a href="#" class="a_write"><span id="selected"
						onmouseover="javasrcipt:wskm_nav(1)">学院概况</span> </a> |&nbsp;
					<a href="#" class="a_write"><span id="selected"
						onmouseover="javasrcipt:wskm_nav(2)">招生信息</span> </a> |&nbsp;
					<a href="#" class="a_write"><span id="selected"
						onmouseover="javasrcipt:wskm_nav(3)">师资队伍 </span> </a> |&nbsp;
					<a href="#" class="a_write"><span id="selected"
						onmouseover="javasrcipt:wskm_nav(4)">学生工作</span> </a> |&nbsp;
					<a href="#" class="a_write"><span id="selected"
						onmouseover="javasrcipt:wskm_nav(5)">科学研究</span> </a> |&nbsp;
					<a href="#" class="a_write"><span id="selected"
						onmouseover="javasrcipt:wskm_nav(6)">实践教学 </span> </a> |
					<!--顶部链接-->
				</td>
			</tr>
			<tr>
				<!-- 次导行栏开始 -->
				<td id="subnav" style="background-color: #F5FFFA">
					<div id="sub_nav_0" style="display: none;">
					</div>
					<div id="sub_nav_1" style="display: none;">
						<a href=xxgk/xrld/index.htm class="LINK21">学院简介</a> |
						<a href=xxgk/xrld/index.htm class="LINK21">组织结构</a> |
						<a href=xxgk/lrld/index.htm class="LINK21">学院大事记</a> |
					</div>
					<div id="sub_nav_2" style="display: none;">
						<a href=jyjx/szdw/index.htm class="LINK21">招生简章</a> |
						<a href=jyjx/bksjy/index.htm class="LINK21">招生通道</a> |
						<a href=jyjx/yjsjy/index.htm class="LINK21">培养方案</a> |
						<a href=jyjx/lxsjy/index.htm class="LINK21">课程设置</a> |
						<a href=jyjx/caxy/index.htm class="LINK21">招生问答</a> |
						<a href=jyjx/wljy/index.htm class="LINK21">我要报名</a> |
					</div>
					<div id="sub_nav_3" style="display: none;">
					</div>
					<div id="sub_nav_4" style="display: none;">
						<a href=gljg/xxbm/index.htm class="LINK21">党团工作</a> |
						<a href=gljg/fzbm/index.htm class="LINK21">校园活动</a> |
						<a href=gljg/wyh/index.htm class="LINK21">学生社团</a> |
						<a href=gljg/wyh/index.htm class="LINK21">助学金奖</a> |
						<a href=gljg/wyh/index.htm class="LINK21">学学金</a> |
						<a href=gljg/wyh/index.htm class="LINK21">助学贷款</a> |
					</div>
					<div id="sub_nav_5" style="display: none;">
						<a href=jxyj/kyc/index.htm class="LINK21">企业合作</a> |
						<a href=jxyj/gjzdsys/index.htm class="LINK21">院校合作</a> |
						<a href=jxyj/jybzdsys/index.htm class="LINK21">科研机构</a> |
						<a href=jxyj/sbjzdsys/index.htm class="LINK21">科研成果</a> |
					</div>
					<div id="sub_nav_20" style="background-color: #666666">
						<marquee direction="left" width=470>
							<a href="" class="LINK21" style="color: #FFFFFF">请登入 </a>
						</marquee>
						<label style="color: #FFFFFF" id="time"></label>
					</div>
				</td>
				<!-- 次导行栏结束 -->
			</tr>
		</table>
		<table width="700" border="0" align="center" cellpadding="0"
			cellspacing="0">
			<!-- start of rightBody -->
			<td class="rightBody"
				style="background-color: #FFFff8; height: 500px;">
				<!-- loginform start -->
				<div>
					<div style="height: 30px; width: 220px;" class="NewsTitle3 title1">
						<div style="float: left; padding-top: 5px">
							&nbsp;系&nbsp;统&nbsp;登&nbsp;陆
						</div>
					</div>
					<div style="" class="loginBg">
						<form action="/login">
							<div style="height: 40px; padding-top: 30px">
								<span style="width: 60px;color:#013f78">用户名</span>
								<label>
									<input name="" type="text" size="13"
										id="ctl00_PlhMiddle_LoginCtrl1_TxtUserName" class="title3"
										VALUE="" />
								</label>
								&nbsp;
							</div>
							<div style="height: 40px; padding-top: 5px">
								<span style="width: 60px;color:#013f78">密码</span>
								<label>
									<input name="" type="password" size="13" class="title3"
										VALUE="123456" />
								</label>
							</div>
							<div style="padding-left: 122px">
								<input type="image" name="" Text="登录" src="images/bot.gif"
									border="0" />
								<span><font color="Red"></font> </span>
							</div>
						</form>
					</div>
				</div>
				<!-- end of loginform -->
				<!-- start of notice -->
				<div>
					<div>
						<div style="height: 30px; width: 220px;" class="NewsTitle3 title1">
						<div style="float: left; padding-top: 5px">
							&nbsp;通&nbsp;知&nbsp;公&nbsp;告
						</div>
				        </div>
						<div style=" width: 227px">
							<div background="images/right02.gif">
								<div id="marquees">
									<div>
										<ul class="ul_right">
											<li>
												<a href="detail.php?id=2907" class="a_blue"><font
													color="#1C86EE"> 通告一通告一通告一 </font> </a>
											</li>
											<li>
												<a href="detail.php?id=2854" class="a_blue"><font
													color="#1C86EE"> 通告二通告二通告二 </font> </a>
											</li>
											<li>
												<a href="detail.php?id=2839" class="a_blue"><font
													color="#1C86EE"> 通告三通告三通告三 </font> </a>
											</li>
											<li>
												<a href="detail.php?id=1935" class="a_blue"><font
													color="#1C86EE"> 通告四通告四通告四 </font> </a>
											</li>
										</ul>
									</div>
								</div>
								<script language="JavaScript">

marqueesHeight=158;
stopscroll=false;

with(marquees){
   style.width=200;
   style.height=marqueesHeight;
   style.overflowX="visible";
   style.overflowY="hidden";
   noWrap=true;
   onmouseover=new Function("stopscroll=true");
   onmouseout=new Function("stopscroll=false");
}
document.write('<div id="templayer" width="200" style="position:absolute;z-index:1;visibility:hidden"></div>');

preTop=0; currentTop=0; 

function init(){
   templayer.innerHTML="";
   while(templayer.offsetHeight<marqueesHeight){
     templayer.innerHTML+=marquees.innerHTML;
   }
   marquees.innerHTML=templayer.innerHTML+templayer.innerHTML;
   setInterval("scrollUp()",30);
}
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



							</div>
						</div>
						<div>
							<img src="images/right03.gif" width="220" height="20" border="0" />
						</div>
					</div>
				</div>
				<!-- end of notice -->
				<!-- start of navigation -->
				<div >
						<div style="height: 30px; width: 220px;" class="NewsTitle3 title1">
						<div style="float: left; padding-top: 5px">
							&nbsp;友&nbsp;情&nbsp;链&nbsp;接
						</div>
				        </div>
					<div style="width: 220px;">
						<ul class="ul_left"
							style="font-family: 宋体; text-decoration: none; position: 固定; margin: 0px; padding-left: 10px;">
							<a href="#" class="LINK21">·快速导航西电首页</a>
							<br>
							<a href="#" class="LINK21">·快速导航教务管理系统</a>
							<br>
							<a href="#" class="LINK21">·快速导航计算机学院</a>
							<br>
							<a href="#" class="LINK21">·快速导航就业中心</a>
							<br>
							<a href="#" class="LINK21">·快速导航图书馆</a>
							<br>
							<a href="#" class="LINK21">·快速导航星火杯 </a>
							<br>
							<a href="#" class="LINK21">·快速导航海纳百川</a>
							<br>
							<a href="#" class="LINK21">·快速导航软院研究生论坛</a>
							<br>
							<a href="#" class="LINK21">·快速导航招生问答</a>
							<br>
							<a href="#" class="LINK21">·快速导航电子商务精品课程</a>
							<br />
							<a href="#" class="LINK21">·快速导航计算机学院</a>
							<br>
							<a href="#" class="LINK21">·快速导航就业中心</a>
							<br>
							<a href="#" class="LINK21">·快速导航图书馆</a>
						</ul>
					</div>
				</div>
				<div>
					<a class="LINK21"><img src="images/left03.gif" width="220"
							height="22" /> </a>
				</div>
				<!-- end of navigation -->
			</td>
			<!-- end of rightBody -->
			<!-- start of middleBody -->
			<td class="middleBody" style="background-color: #FFFff8;">
				<!-- start of news -->
				<div>
					<div style="height: 30px; width: 450px;" class="NewsTitle title1">
						<div style="float: left; padding-top: 5px">
							&nbsp;学&nbsp;院&nbsp;采&nbsp;风
						</div>
						<div style="" class="moreButton">
							<a href="#"><img src="images/more.gif" border="0" /> </a>
						</div>
					</div>
					<div style="height: 345px; width: 450px;">
						<div
							style="height: 345px; width: 445px; float: left; padding-left: 2px; padding-top: 0px;">
							<iframe src="PicNewsRoll.jsp" scrolling="no" width="445"
								height="345" frameborder="0" style="border-style: none;"></iframe>
						</div>
					</div>
				</div>
				<!-- end of news -->
				<div style="height: 173px;">
					<div style="height: 30px; width: 450px;" class="NewsTitle2 title1">
						<div style="float: left; padding-top: 4px; width: 116px">
							<span class="NewsKindSpan" id="NewsKindSpan1"
								onmouseover="javasrcipt:NewsKind(1)"
								style="background-image: url('./images/span01.gif');">&nbsp;学&nbsp;院&nbsp;新&nbsp;闻
							</span>
						</div>
						<div style="float: left; padding-top: 4px; width: 110px">
							<span class="NewsKindSpan" id="NewsKindSpan2"
								onmouseover="javasrcipt:NewsKind(2)">
								&nbsp;招&nbsp;聘&nbsp;信&nbsp;息 </span>
						</div>
						<div style="float: left; padding-top: 4px; width: 110px">
							<span class="NewsKindSpan" id="NewsKindSpan3"
								onmouseover="javasrcipt:NewsKind(3)">
								&nbsp;国&nbsp;内&nbsp;时&nbsp;事 </span>

						</div>
						<div style="" class="moreButton">
							<a href="#"><img src="images/more.gif" border="0" /> </a>
						</div>
					</div>
					<div style="padding-left: 1px; padding-right: 1px;">
						<div id="news_block1"
						style="padding-left: 19px; display: block;">
						<div class="NewsItem">
							<div style="width: 283px; float: left;">
								<a title="温家宝：不赞成中美两国集团提法 阐述三原因" href="ShowNews.aspx?newsid=462"
									class="LINK21"> ·温家宝：不赞成中美两国集团提法... </a>
							</div>
							<div style="width: 162px; float: left;" class="date">
								[2009-11-19]
							</div>
						</div>

						<div style="" class="NewsItem">
							<div style="width: 283px; float: left">
								<a title="钟南山质疑甲流死亡病例数目 称瞒报后果严重" class="LINK21"
									href="ShowNews.aspx?newsid=465">·近日天气突变可能使流感高峰提前来临... </a>
							</div>
							<div style="width: 162px; float: left" class="date">
								[2009-11-19]
							</div>
						</div>
						<div style="" class="NewsItem">
							<div style="width: 283px; float: left">
								<a title="中越签署陆地边界文件 同意启动海上问题磋商" href="ShowNews.aspx?newsid=464"
									class="LINK21"> ·中越陆地边界勘界文件签字...</a>
							</div>
							<div style="width: 162px; float: left" class="date">
								[2009-11-19]
							</div>
						</div>
						<div style="" class="NewsItem">
							<div style="width: 283px; float: left">
								<a class="LINK21" title="世界杯32强出线综述：黑马纵横 豪强无一缺席"
									href="ShowNews.aspx?newsid=425"> ·欧洲区出线名单（13队）...</a>
							</div>
							<div style="width: 162px; float: left" class="date">
								[2009-11-19]
							</div>
						</div>

						<div style="" class="NewsItem">
							<div style="width: 283px; float: left">
								<a class="LINK21" title="姚明：三周后脱掉脚部护套 新状态迎接下赛季"
									href="ShowNews.aspx?newsid=424"> ·姚明：三周后脱掉脚部护套...</a>
							</div>
							<div style="width: 162px; float: left" class="date">
								[2009-11-19]
							</div>
						</div>
						<div style="" class="NewsItem">
							<div style="width: 283px; float: left">
								<a class="LINK21" title=" 专访年维泗：再进世界杯要很长时间"
									href="ShowNews.aspx?newsid=421"> ·专访年维泗：再进世界杯要很长时间...</a>
							</div>
							<div style="width: 162px; float: left" class="date">
								[2009-11-19]
							</div>
						</div>
						<div style="" class="NewsItem">
							<div style="width: 283px; float: left">
								<a class="LINK21" title="受益经济回暖 央视2010年广告招标超百亿"
									href="ShowNews.aspx?newsid=382"> ·央视2010年广告招标总金额超百亿...</a>
							</div>
							<div style="width: 162px; float: left" class="date">
								[2009-11-19]
							</div>
						</div>
					</div>

					<div id="news_block2"
						style="padding-left: 19px; display: none;">
						<div class="NewsItem">
							<div style="width: 283px; float: left;">
								<a title="温家宝：不赞成中美两国集团提法 阐述三原因" href="ShowNews.aspx?newsid=462"
									class="LINK21"> ·招聘信息 温家宝：不赞成中美两国集团提法... </a>
							</div>
							<div style="width: 162px; float: left;" class="date">
								[2009-11-19]
							</div>
						</div>

						<div style="" class="NewsItem">
							<div style="width: 283px; float: left">
								<a title="钟南山质疑甲流死亡病例数目 称瞒报后果严重" class="LINK21"
									href="ShowNews.aspx?newsid=465">·招聘信息近日天气突变可能使流感高峰提前来临... </a>
							</div>
							<div style="width: 162px; float: left" class="date">
								[2009-11-19]
							</div>
						</div>
						<div style="" class="NewsItem">
							<div style="width: 283px; float: left">
								<a title="中越签署陆地边界文件 同意启动海上问题磋商" href="ShowNews.aspx?newsid=464"
									class="LINK21"> ·招聘信息中越陆地边界勘界文件签字...</a>
							</div>
							<div style="width: 162px; float: left" class="date">
								[2009-11-19]
							</div>
						</div>
						<div style="" class="NewsItem">
							<div style="width: 283px; float: left">
								<a class="LINK21" title="世界杯32强出线综述：黑马纵横 豪强无一缺席"
									href="ShowNews.aspx?newsid=425"> ·招聘信息欧洲区出线名单（13队）...</a>
							</div>
							<div style="width: 162px; float: left" class="date">
								[2009-11-19]
							</div>
						</div>

						<div style="" class="NewsItem">
							<div style="width: 283px; float: left">
								<a class="LINK21" title="姚明：三周后脱掉脚部护套 新状态迎接下赛季"
									href="ShowNews.aspx?newsid=424"> ·招聘信息姚明：三周后脱掉脚部护套...</a>
							</div>
							<div style="width: 162px; float: left" class="date">
								[2009-11-19]
							</div>
						</div>
						<div style="" class="NewsItem">
							<div style="width: 283px; float: left">
								<a class="LINK21" title=" 专访年维泗：再进世界杯要很长时间"
									href="ShowNews.aspx?newsid=421"> ·招聘信息专访年维泗：再进世界杯要很长时间...</a>
							</div>
							<div style="width: 162px; float: left" class="date">
								[2009-11-19]
							</div>
						</div>
						<div style="" class="NewsItem">
							<div style="width: 283px; float: left">
								<a class="LINK21" title="受益经济回暖 央视2010年广告招标超百亿"
									href="ShowNews.aspx?newsid=382"> ·招聘信息央视2010年广告招标总金额超百亿...</a>
							</div>
							<div style="width: 162px; float: left" class="date">
								[2009-11-19]
							</div>
						</div>
					</div>
					<div id="news_block3"
						style="padding-left: 19px; padding-top: 0px; display: none;">
						<div class="NewsItem">
							<div style="width: 283px; float: left;">
								<a title="温家宝：不赞成中美两国集团提法 阐述三原因" href="ShowNews.aspx?newsid=462"
									class="LINK21"> ·国内时事温家宝：不赞成中美两国集团提法... </a>
							</div>
							<div style="width: 162px; float: left;" class="date">
								[2009-11-19]
							</div>
						</div>

						<div style="" class="NewsItem">
							<div style="width: 283px; float: left">
								<a title="钟南山质疑甲流死亡病例数目 称瞒报后果严重" class="LINK21"
									href="ShowNews.aspx?newsid=465">·国内时事近日天气突变可能使流感高峰提前来临... </a>
							</div>
							<div style="width: 162px; float: left" class="date">
								[2009-11-19]
							</div>
						</div>
						<div style="" class="NewsItem">
							<div style="width: 283px; float: left">
								<a title="中越签署陆地边界文件 同意启动海上问题磋商" href="ShowNews.aspx?newsid=464"
									class="LINK21"> ·国内时事中越陆地边界勘界文件签字...</a>
							</div>
							<div style="width: 162px; float: left" class="date">
								[2009-11-19]
							</div>
						</div>
						<div style="" class="NewsItem">
							<div style="width: 283px; float: left">
								<a class="LINK21" title="世界杯32强出线综述：黑马纵横 豪强无一缺席"
									href="ShowNews.aspx?newsid=425"> ·国内时事欧洲区出线名单（13队）...</a>
							</div>
							<div style="width: 162px; float: left" class="date">
								[2009-11-19]
							</div>
						</div>

						<div style="" class="NewsItem">
							<div style="width: 283px; float: left">
								<a class="LINK21" title="姚明：三周后脱掉脚部护套 新状态迎接下赛季"
									href="ShowNews.aspx?newsid=424"> ·国内时事姚明：三周后脱掉脚部护套...</a>
							</div>
							<div style="width: 162px; float: left" class="date">
								[2009-11-19]
							</div>
						</div>
						<div style="" class="NewsItem">
							<div style="width: 283px; float: left">
								<a class="LINK21" title=" 专访年维泗：再进世界杯要很长时间"
									href="ShowNews.aspx?newsid=421"> ·专访年维泗：再进世界杯要很长时间...</a>
							</div>
							<div style="width: 162px; float: left" class="date">
								[2009-11-19]
							</div>
						</div>
						<div style="" class="NewsItem">
							<div style="width: 283px; float: left">
								<a class="LINK21" title="受益经济回暖 央视2010年广告招标超百亿"
									href="ShowNews.aspx?newsid=382"> ·国内时事央视2010年广告招标总金额超百亿...</a>
							</div>
							<div style="width: 162px; float: left" class="date">
								[2009-11-19]
							</div>
						</div>
					</div>
					</div>
				</div>
				<!-- start of friend-link -->
				<div style="height: 95px">
					<div style="height: 30px; width: 450px;" class="NewsTitle title1">
						<div style="float: left; padding-top: 5px">
							&nbsp;友&nbsp;情&nbsp;链&nbsp;接
						</div>
						<div style="" class="moreButton">
							<a href="#"><img src="images/more.gif" border="0" /> </a>
						</div>
					</div>
					<div>
						<div class="f_link">
							<a href="ShowNews.aspx?newsid=462" class="LINK21"> ·友情链接1</a>
						</div>
						<div class="f_link">
							<a href="ShowNews.aspx?newsid=462" class="LINK21"> ·友情链接2</a>
						</div>
						<div class="f_link">
							<a href="ShowNews.aspx?newsid=462" class="LINK21"> ·友情链接3</a>
						</div>
						<div class="f_link">
							<a href="ShowNews.aspx?newsid=462" class="LINK21"> ·友情链接4</a>
						</div>
					</div>
					<div style="padding-top:3px">
						<div class="f_link">
							<a href="ShowNews.aspx?newsid=462" class="LINK21"> ·友情链接5</a>
						</div>
						<div class="f_link">
							<a href="ShowNews.aspx?newsid=462" class="LINK21"> ·友情链接6</a>
						</div>
						<div class="f_link">
							<a href="ShowNews.aspx?newsid=462" class="LINK21"> ·友情链接7</a>
						</div>
						<div class="f_link">
							<a href="ShowNews.aspx?newsid=462" class="LINK21"> ·友情链接8</a>
						</div>
					</div>
					<form style="padding-left: 10px">
					</form>
					<!-- end of friend-link -->
				</div>
			</td>
			<!-- end of middleBody -->



		</table>

		<!-- start of bottom -->
		<table width="700" border="0" align="center" cellpadding="0"
			cellspacing="0">
			<tr>
				<td style="background-color: #666666;" height="32">
					<div align="right" class="text_write">
						|
						<a href="/index.jsp" class="a_write">首 页</a> |
						<a href="/index.jsp" class="a_write">办事指南</a> |
						<a href="/index.jsp" class="a_write">院长信箱</a> |
						<a href="/index.jsp" class="a_write">联系我们</a>
					</div>
				</td>
			</tr>
			<tr>
				<td height="20" bgcolor="#CCCCCC">
					<div align="center" style="color: #666666;">
						版权所有 西安电子科技大学软件学院 Copyright 2009 All Rights Reserved
					</div>
				</td>
			</tr>
		</table>
		<!-- end of bottom -->
	</body>
</html>
