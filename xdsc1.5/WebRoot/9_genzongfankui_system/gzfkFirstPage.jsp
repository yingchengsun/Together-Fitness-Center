<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<title>跟踪反馈系统</title>


<link href="<%=basePath%>/css.css" rel="stylesheet" type="text/css" />

  <!-- <script type="text/javascript">
   
   function redirect()
   {
   var name= =document.getElementById(Login1_txtUid);
   if(name.equles("1"))
   {
      location.href='yjssx_system_forStu.jsp';
   }
   location.href='yjssx_system_forStu.jsp'
   }
	
	</script>  --> 
</head>

<body>
<div align="left">
  <table border="0" cellpadding="1" cellspacing="0" width="801" align="center" style="border-collapse:collapse" >
    <tr>
      <td height="166" colspan="2"><object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,19,0" width="799" height="164">
        <param name="movie" value="SubSystemImage/top.swf" />
        <param name="quality" value="high" />
        <embed src="SubSystemImage/top.swf" quality="high" pluginspage="http://www.macromedia.com/go/getflashplayer" type="application/x-shockwave-flash" width="799" height="164"></embed>
      </object>
        <table width="800" height="25" border="0" style="background-image:url(SubSystemImage/navigate.gif)">
          <tr style="background-color: #0948F7">
            <td height="21" align="left" valign="middle" width="794"
					background="/images/mune02.gif" class="text_write"> <div align="left"> | <a href="../index.jsp" class="a_write STYLE30">首 页 </a> 
              <!--顶部链接-->            
            </div></td>
          </tr>
      </table></td>
    <tr valign="top">
      <td width="210" valign="top" bordercolor="#02abfe"  style="width: 192px">
<img src="SubSystemImage/left_bar1.gif" width="210" height="27"/>
  <form action="CommonLogin!login.action" method="post">
	 <table width="210" height="120" border="0" background="SubSystemImage/login_bg.gif" >
	    <tr>
	      <td width="50%" height="41"><div align="center">用户名： <br />
	      </div></td>
	      <td>
	          <div align="left">
	            <input type="text" name="name" size="10"/>
	            </div></td>
	    </tr>
	    <tr>
	      <td height="40"><div align="center">密码：</div></td>
	      <td>
	        <div align="left">
	          <input type="password" name="password" size="10"/>
	        </div></td>
	    </tr>
	    <tr>
	      <td height="41">
	      	<div align="center">
	      		<select name="type">
	      			<option value="">--请选择--</option>
	      			<option value="student">学生</option>
	      			<option value="tutor">辅导员</option>
	      			<option value="manager">管理员</option>
	      		</select>
	      	</div>
	      </td>
	      <td><div align="center"><input type="submit" value="登陆"/></div></td>
	    </tr>
	 </table>
  </form>
  <!-- 
   <img src="SubSystemImage/shixixiangguan.GIF" width="210" height="27"/>
  <table width="210" height="170" border="0" background="SubSystemImage/login_bg.gif">
  <tr>
    <td width="202" height="41">
        <div align="center"><img src="SubSystemImage/gif-0498.gif" width="20" height="20" /><a href="detail.php?id=2907" class="a_blue STYLE29"> 实习相关政策 </a>            </div></td>
    </tr>
  <tr>
    <td height="39"><div align="center"><img src="SubSystemImage/gif-0498.gif" width="20" height="20" /><a href="detail.php?id=2907" class="a_blue STYLE29"> 实习资料下载 </a>
      </div></td>
    </tr>
  <tr>
    <td height="42"><div align="center"><img src="SubSystemImage/gif-0498.gif" width="20" height="20" /><a href="detail.php?id=2907" class="a_blue STYLE29"> 实习管理制度</a>

      </div></td>
    </tr>
  </table>
  <img src="SubSystemImage/ZouJinQiYe.GIF" width="210" height="27" />
  <table width="210" height="125" border="0"  background="SubSystemImage/login_bg.gif">
  <tr>
    <td width="201"><div align="center"><img src="SubSystemImage/gif-0469.gif" /><a href="javascript:__doPostBack('DisplayInformation1$btnSeeMore3','')">企业生活</a></div></td>
  </tr>
  <tr>
    <td><div align="center"><img src="SubSystemImage/gif-0469.gif" /><a href="javascript:__doPostBack('DisplayInformation1$btnSeeMore3','')">企业文化</a></div></td>
  </tr>
  <tr>
    <td><div align="center"><img src="SubSystemImage/gif-0469.gif" /><a  href="DisplayDetails.aspx?id=581">人才培养</a></div></td>
  </tr>
</table>
-->

   <img src="SubSystemImage/friendlyLink.GIF" width="208" height="27" />
   <table width="210" height="241" border="0"  background="SubSystemImage/login_bg.gif">
    <tr>
      <td width="201" height="27"> <div align="center" class="STYLE29"><img src="SubSystemImage/gif-0453.gif" /><a href="detail.php?id=2907" class="a_blue"> 友情链接一 </a>
        </div></td>
    </tr>
    <tr>
      <td height="28"> <div align="center" class="STYLE29"><img src="SubSystemImage/gif-0454.gif" /><a href="detail.php?id=2907" class="a_blue"> 友情链接二 </a>
        </div></td>
    </tr>
    <tr>
      <td height="31"> <div align="center" class="STYLE29"><img src="SubSystemImage/gif-0455.gif" width="10" height="12" /><a href="detail.php?id=2907" class="a_blue"> 友情链接三 </a>
        </div></td>
    </tr>
    <tr>
      <td height="28"> <div align="center" class="STYLE29"><img src="SubSystemImage/gif-0453.gif" /><a href="detail.php?id=2907" class="a_blue"> 友情链接四 </a>
        </div></td>
    </tr>
	    <tr>
      <td height="27"> <div align="center" class="STYLE29"><img src="SubSystemImage/gif-0454.gif" /><a href="detail.php?id=2907" class="a_blue"> 友情链接五 </a>
        </div></td>
    </tr>
	    <tr>
      <td height="30"> <div align="center" class="STYLE29"><img src="SubSystemImage/gif-0455.gif" width="10" height="12" /><a href="detail.php?id=2907" class="a_blue"> 友情链接六 </a>
        </div></td>
    </tr>
  </table>

  </td>
      <td width="587" height="583" align="left" valign="top">
	  <table cellpadding="0" cellspacing="0" class="rightKuang" width="589" height="708" background="SubSystemImage/bg.gif">
        <tr valign="top">
          <td width="587" height="706" valign="top">
            <table width="585" border="0" bordercolor="#0033CC" style="border-collapse: collapse;" height="787">
              <tr valign=top>
                <td width="579" valign=top><div id="DisplayInformation1_Panel2" class="dctNoBorder" style="font-size:16px;">
                  <fieldset>
                    <legend bordercolor="#0033CC"><img src="SubSystemImage/newsAndNotice.GIF" /></legend>
                        <table width="504" height="157">
                          <tr  bgcolor="#FFFFFF">
                            <td width=419><div align="left"><img src="SubSystemImage/gif-0609.gif" width="17" height="15" /><a href="DisplayDetails.aspx?id=581">跟踪反馈</a> <img src="SubSystemImage/gif-0249.gif" width="28" height="14" /></div></td>
                            <td width=110><div align="left"><span id="DisplayInformation1_rbt1__ctl0_lblNewsDate1">2009-6-10</span> </div></td >
                          </tr>
                          <tr class="SubMenu">
                            <td width=419><div align="left"><img src="SubSystemImage/gif-0609.gif" width="17" height="15" /><a  href="DisplayDetails.aspx?id=561">跟踪反馈</a><img src="SubSystemImage/gif-0249.gif" width="28" height="14" /> </div></td>
                            <td width=110><div align="left"><span id="DisplayInformation1_rbt1__ctl1_lblNewsDate1">2009-6-8</span> </div></td >
                          </tr>
                          <tr bgcolor="#FFFFFF">
                            <td width=419><div align="left"><img src="SubSystemImage/gif-0609.gif" width="17" height="15" /><a  href="DisplayDetails.aspx?id=521">跟踪反馈</a> <img src="SubSystemImage/gif-0249.gif" width="28" height="14"/></div></td>
                            <td width=110><div align="left"><span id="DisplayInformation1_rbt1__ctl2_lblNewsDate1">2009-4-16</span> </div></td >
                          </tr>
                          <tr class="SubMenu">
                            <td width=419><div align="left"><img src="SubSystemImage/gif-0609.gif" width="17" height="15" /><a  href="DisplayDetails.aspx?id=462">跟踪反馈</a> </div></td>
                            <td width=110><div align="left"><span id="DisplayInformation1_rbt1__ctl3_lblNewsDate1">2009-3-19</span> </div></td >
                          </tr>
                          <tr bgcolor="#FFFFFF">
                            <td width=419><div align="left"><img src="SubSystemImage/gif-0609.gif" width="17" height="15" /><a href="DisplayDetails.aspx?id=401">跟踪反馈</a> </div></td>
                            <td width=110><div align="left"><span id="DisplayInformation1_rbt1__ctl4_lblNewsDate1">2008-12-3</span> </div></td >
                          </tr>
                          <tr>
                            <td colspan="2" ><div align="left"><img src="SubSystemImage/gif-0328.gif" width="57" height="15" /><a  href="javascript:__doPostBack('DisplayInformation1$btnSeeMore1','')"></a> </div></td>
                          </tr>
                      </table>
                      </fieldset>
                  </div></td>
                </tr>
                
               
               <tr>
                <td valign=top><div id="DisplayInformation1_Panel1" class="dctNoBorder" style="font-size:16px;">
                  <fieldset>
                    <legend><img src="SubSystemImage/zhaopinxinxi.GIF" /></legend>
                        <table width="503" height="148">
                          <tr  bgcolor="#FFFFFF">
                            <td width=496><div align="left"><img src="SubSystemImage/sucaiwcom0566000jty.gif" width="15" height="15" /><a  href="DisplayDetails.aspx?id=601">跟踪反馈</a> <img src="SubSystemImage/gif-0249.gif" width="28" height="14"/></div></td>
                            <td width=126><div align="left"><span id="DisplayInformation1_rbt2__ctl0_lblNewsDate2">2009-7-10</span> </div></td >
                          </tr>
                          <tr class="SubMenu">
                            <td width=496><div align="left"><img src="SubSystemImage/sucaiwcom0566000jty.gif" width="15" height="15" /><a  href="DisplayDetails.aspx?id=541">跟踪反馈</a> <img src="SubSystemImage/gif-0249.gif" width="28" height="14"/></div></td>
                            <td width=126><div align="left"><span id="DisplayInformation1_rbt2__ctl1_lblNewsDate2">2009-5-21</span> </div></td >
                          </tr>
                          <tr bgcolor="#FFFFFF">
                            <td width=496><div align="left"><img src="SubSystemImage/sucaiwcom0566000jty.gif" width="15" height="15" /><a href="DisplayDetails.aspx?id=461">跟踪反馈</a> </div></td>
                            <td width=126><div align="left"><span id="DisplayInformation1_rbt2__ctl2_lblNewsDate2">2009-3-19</span> </div></td >
                          </tr>
                          <tr class="SubMenu">
                            <td width=496><div align="left"><img src="SubSystemImage/sucaiwcom0566000jty.gif" width="15" height="15" /><a href="DisplayDetails.aspx?id=463">跟踪反馈</a> </div></td>
                            <td width=126><div align="left"><span id="DisplayInformation1_rbt2__ctl3_lblNewsDate2">2009-3-19</span> </div></td >
                          </tr>
                          <tr bgcolor="#FFFFFF">
                            <td width=496><div align="left"><img src="SubSystemImage/sucaiwcom0566000jty.gif" width="15" height="15" /><a href="DisplayDetails.aspx?id=441">跟踪反馈</a> </div></td>
                            <td width=126><div align="left"><span id="DisplayInformation1_rbt2__ctl4_lblNewsDate2">2009-3-11</span> </div></td >
                          </tr>
                          <tr class="SubMenu">
                            <td width=496><div align="left"><img src="SubSystemImage/gif-0328.gif" width="57" height="15" /><a  href="javascript:__doPostBack('DisplayInformation1$btnSeeMore1','')"></a><a  href="javascript:__doPostBack('DisplayInformation1$btnSeeMore1','')"></a></div></td>
                            <td width=126><br /></td >
                          </tr>
                      </table>
                      </fieldset>
                  </div></td>
                </tr>
                
             <!-- <tr>
                <td valign=top ><div id="DisplayInformation1_Panel3" class="dctNoBorder" style="font-size:16px;">
                  <fieldset>
                    <legend><img src="SubSystemImage/CooperateCom.GIF" width="268" height="26" longdesc="file:///C|/Documents and Settings/Administrator/桌面/设计/7Postgraduate_Practicing/WebRoot/images/CooperateCom.GIF" /></legend>
                        <table>
                          <tr  bgcolor="#FFFFFF">
                            <td width="497" colspan="2" ><div align="left"><img src="SubSystemImage/gif-0920.gif" width="13" height="13" /><a href="javascript:__doPostBack('DisplayInformation1$btnSeeMore3','')">西安中兴通讯有限公司</a> </div></td>
                          </tr>
                          <tr>
                            <td colspan="2" ><div align="left"><img src="SubSystemImage/gif-0920.gif" width="13" height="13" /><a href="javascript:__doPostBack('DisplayInformation1$btnSeeMore3','')">西安华为技术有限公司</a></div></td>
                          </tr>
                          <tr  bgcolor="#FFFFFF">
                            <td colspan="2" ><div align="left"><img src="SubSystemImage/gif-0920.gif" width="13" height="13" /><a  href="DisplayDetails.aspx?id=581">北京无限缘信息科技有限公司</a></div></td>
                          </tr>
                          <tr>
                            <td colspan="2" ><div align="left"><img src="SubSystemImage/gif-0920.gif" width="13" height="13" /><a href="javascript:__doPostBack('DisplayInformation1$btnSeeMore3','')">Platform</a></div></td>
                          </tr>
                          <tr  bgcolor="#FFFFFF">
                            <td colspan="2" ><div align="left"><img src="SubSystemImage/gif-0328.gif" width="57" height="15" /><a  href="javascript:__doPostBack('DisplayInformation1$btnSeeMore1','')"></a><a href="javascript:__doPostBack('DisplayInformation1$btnSeeMore3','')"></a></div></td>
                          </tr>
                      </table>
                      </fieldset>
                  </div></td>
                </tr>-->
              <!-- <tr>
                <td height="171" valign=top><div id="DisplayInformation1_Panel4" class="dctNoBorder" style="font-size:16px;">
                  <fieldset>
                    <legend><img src="SubSystemImage/zhaopinxinxi.GIF" /></legend>
                        <table width="505">
                          <tr  bgcolor="#FFFFFF">
                            <td  width=496><div align="left"><img src="SubSystemImage/gif-0600.gif" width="16" height="16" /><a href="StudentManage/YaXinCompanyZhaoPin.jsp">亚信集团股份有限公司</a><img src="SubSystemImage/gif-0249.gif" width="28" height="14" /></div></td>
                            <td width=126><div align="left"><span id="DisplayInformation1_rbt4__ctl0_lblNewsDate4">2009-10-13</span> </div></td>
                          </tr>
                          <tr class="SubMenu">
                            <td  width=496><div align="left"><img src="SubSystemImage/gif-0600.gif" width="16" height="16" /><a href="DisplayDetails.aspx?id=561">科派特信息技术有限公司招聘实习生</a><img src="SubSystemImage/gif-0249.gif" width="28" height="14"  /></div></td>
                            <td width=126><div align="left"><span id="DisplayInformation1_rbt4__ctl1_lblNewsDate4">2009-6-25</span> </div></td>
                          </tr>
                          <tr bgcolor="#FFFFFF">
                            <td  width=388><div align="left"><img src="SubSystemImage/gif-0600.gif" width="16" height="16" /><a href="DisplayDetails.aspx?id=581">北京无限缘信息科技有限公司招聘</a><img src="SubSystemImage/gif-0249.gif" width="28" height="14" /></div></td>
                            <td width=148><div align="left"><span id="DisplayInformation1_rbt4__ctl2_lblNewsDate4">2009-6-10</span> </div></td>
                          </tr>
                          <tr class="SubMenu">
                            <td  width=388><div align="left"><img src="SubSystemImage/gif-0600.gif" width="16" height="16" /><a href="DisplayDetails.aspx?id=462">Platform技术支持工程师岗位</a><img src="SubSystemImage/gif-0249.gif" width="28" height="14" /></div></td>
                            <td width=148><div align="left"><span id="DisplayInformation1_rbt4__ctl3_lblNewsDate4">2009-4-2</span> </div></td>
                          </tr>
                          <tr  bgcolor="#FFFFFF">
                            <td  width=388><div align="left"><img src="SubSystemImage/gif-0600.gif" width="16" height="16" /><a href="DisplayDetails.aspx?id=401">神州数码金程科技有限公司</a></div></td>
                            <td width=148><div align="left"><span id="DisplayInformation1_rbt4__ctl4_lblNewsDate4">2009-3-23</span> </div></td>
                          </tr>
                          <tr>
                            <td height="21" colspan="2" ><div align="left"><img src="SubSystemImage/gif-0328.gif" width="57" height="15" /><a  href="javascript:__doPostBack('DisplayInformation1$btnSeeMore1','')"></a><a href="javascript:__doPostBack('DisplayInformation1$btnSeeMore4','')"></a> </div></td>
                          </tr>
                      </table>
                      </fieldset>
                  </div></td>
                </tr>-->
            </table></td>
        </tr>
      </table>      </td>
    </tr>
  </table>
</div>
</body>
</html>

