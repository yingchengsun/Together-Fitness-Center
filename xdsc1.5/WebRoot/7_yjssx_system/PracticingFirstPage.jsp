<%@ page contentType="text/html; charset=UTF-8" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>研究生实习系统</title>
<link href="<%=basePath%>css.css" rel="stylesheet" type="text/css" />
<style type="text/css">
<!--
.STYLE29 {color: #0000CC}
.STYLE30 {color: #FFFFFF}
-->
</style>
</head>

<body>
<div align="left">
  <table border="0" cellpadding="1" cellspacing="0" width="801" align="center" style="border-collapse:collapse" >
    <tr>
      <td height="166" colspan="2">
        <embed src="<%=basePath%>7_yjssx_system/SubSystemImage/top.swf" width="799" height="164"></embed>
        <table width="800" height="25" border="0" background="<%=basePath%>7_yjssx_system/SubSystemImage/navigate.gif">
          <tr>
            <td height="21" align="left" valign="middle" width="794"
					background="<%=basePath%>7_yjssx_system/SubSystemImage/navigate.gif" class="text_write"> <div align="left"> &nbsp;&nbsp;&nbsp; <a href="<%=basePath%>" class="a_write STYLE30"><strong><font color="#ffffff">首 页</font></strong></a> 
					&nbsp;&nbsp;&nbsp; <a href="<%=basePath%>login.jsp" class="a_write STYLE30"><strong><font color="#ffffff">登 录</font></strong> 
					</a> 
              <!--顶部链接-->            
            </div></td>
          </tr>
      </table></td>
    <tr valign="top">
     <td width="210" valign="top" bordercolor="#02abfe"  style="width: 192px">
  <table>
  	<tr><td height="10px"></td></tr>
  </table>
  <img src="<%=basePath%>7_yjssx_system/SubSystemImage/shixixiangguan.GIF" width="210" height="27"/>
  <table width="210" height="189" border="0" background="<%=basePath%>7_yjssx_system/SubSystemImage/login_bg.gif">
  <tr>
    <td width="202" height="41">
        <div style="padding-left: 40px" ><img src="<%=basePath%>7_yjssx_system/SubSystemImage/gif-0498.gif" width="20" height="20" /><a href="<%=basePath %>yjssxCommon/YjssxFirstPage!showMoreInfo.action?type=5" class="a_blue STYLE29"> 实习相关政策 </a>            </div></td>
    </tr>
  <tr>
    <td height="39"><div style="padding-left: 40px" ><img src="<%=basePath%>7_yjssx_system/SubSystemImage/gif-0498.gif" width="20" height="20" /><a href="<%=basePath %>yjssxCommon/YjssxFirstPage!showMoreInfo.action?type=6" class="a_blue STYLE29"> 实习资料下载 </a>
      </div></td>
    </tr>
  <tr>
    <td height="42"><div style="padding-left: 40px" ><img src="<%=basePath%>7_yjssx_system/SubSystemImage/gif-0498.gif" width="20" height="20" /><a href="<%=basePath %>yjssxCommon/YjssxFirstPage!showMoreInfo.action?type=7" class="a_blue STYLE29"> 实习管理制度</a>

      </div></td>
    </tr>
  </table>
  <img src="<%=basePath%>7_yjssx_system/SubSystemImage/ZouJinQiYe.GIF" width="210" height="27" />
  <table width="210" height="167" border="0"  background="<%=basePath%>7_yjssx_system/SubSystemImage/login_bg.gif">
  <tr>
    <td width="201"><div style="padding-left: 40px"><img src="<%=basePath%>7_yjssx_system/SubSystemImage/gif-0469.gif" /><a href="<%=basePath %>yjssxCommon/YjssxFirstPage!showMoreInfo.action?type=5">企业生活</a></div></td>
  </tr>
  <tr>
    <td><div style="padding-left: 40px"><img src="<%=basePath%>7_yjssx_system/SubSystemImage/gif-0469.gif" /><a href="<%=basePath %>yjssxCommon/YjssxFirstPage!showMoreInfo.action?type=5">企业文化</a></div></td>
  </tr>
  <tr>
    <td><div style="padding-left: 40px"><img src="<%=basePath%>7_yjssx_system/SubSystemImage/gif-0469.gif" /><a  href="<%=basePath %>yjssxCommon/YjssxFirstPage!showMoreInfo.action?type=5">人才培养</a></div></td>
  </tr>
</table>

  
   <img src="<%=basePath%>7_yjssx_system/SubSystemImage/friendlyLink.GIF" width="208" height="27" />
   <table width="210" height="308" border="0"   background="<%=basePath%>7_yjssx_system/SubSystemImage/login_bg.gif">
    <tr>
      <td width="201" height="27"> <div style="padding-left: 40px" class="STYLE29"><img src="<%=basePath%>7_yjssx_system/SubSystemImage/gif-0453.gif" /><a href="http://www.xidian.edu.cn" class="a_blue"> 西安电子科技大学 </a>
        </div></td>
    </tr>
    <tr>
      <td height="28"> <div style="padding-left: 40px" class="STYLE29"><img src="<%=basePath%>7_yjssx_system/SubSystemImage/gif-0454.gif" /><a href="http://cs.xidian.edu.cn" class="a_blue"> 西电计算机学院 </a>
        </div></td>
    </tr>
    <tr>
      <td height="31"> <div style="padding-left: 40px"  class="STYLE29"><img src="<%=basePath%>7_yjssx_system/SubSystemImage/gif-0455.gif" width="10" height="12" /><a href="http://resource.xidian.edu.cn/" class="a_blue"> 西电睿思 </a>
        </div></td>
    </tr>
    <tr>
      <td height="28"> <div style="padding-left: 40px" class="STYLE29"><img src="<%=basePath%>7_yjssx_system/SubSystemImage/gif-0453.gif" /><a href="http://www.lib.xidian.edu.cn" class="a_blue"> 西电图书馆 </a>
        </div></td>
    </tr>
	    <tr>
      <td height="27"> <div style="padding-left: 40px"  class="STYLE29"><img src="<%=basePath%>7_yjssx_system/SubSystemImage/gif-0454.gif" /><a href="http://bbs.xdnice.com" class="a_blue"> 西电好网 </a>
        </div></td>
    </tr>
	    <tr>
      <td height="30"> <div style="padding-left: 40px"  class="STYLE29"><img src="<%=basePath%>7_yjssx_system/SubSystemImage/gif-0455.gif" width="10" height="12" /><a href="http://125.76.215.232/xdjwWeb/index2005.jsp" class="a_blue"> 西电教务处 </a>
        </div></td>
    </tr>
  </table>

  </td>
      <td width="587" height="683" align="left" valign="top">
	  <table cellpadding="0" cellspacing="0" class="rightKuang" width="589" height="708" background="SubSystemImage/bg.gif">
        <tr valign="top">
          <td width="587" height="706" valign="top">
            <table width="585" border="0" bordercolor="#0033CC" style="border-collapse: collapse;" height="787">
              <tr valign=top>
                <td width="579" valign=top>
                  <table>
  					<tr><td height="10px"></td></tr>
 				  </table>
                  <fieldset>
                    <legend><img src="<%=basePath%>7_yjssx_system/SubSystemImage/newsAndNotice.GIF" /></legend>
                        <table width="504" height="157">
                        <c:forEach items="${newsInfo}"  var="news">
	                          <tr  bgcolor="#FFFFFF">
	                            <td width=419>
		                            <div align="left"><img src="<%=basePath%>7_yjssx_system/SubSystemImage/gif-0609.gif" width="17" height="15" />&nbsp;&nbsp;<a href="<%=basePath %>yjssxCommon/YjssxFirstPage!showInfoDetail.action?infoId=${news.FInfoId }">${news.FInfoTitle }</a>
		                            	<s:if test="#t.count<=2">
		                            		<img src="<%=basePath%>7_yjssx_system/SubSystemImage/gif-0249.gif" width="28" height="14" />
		                            	</s:if>
		                            </div>
	                            </td>
	                            <td width=110><div align="left"><span id="DisplayInformation1_rbt1__ctl0_lblNewsDate1"><fmt:formatDate value="${news.FInfoStartTime}" type="date" dateStyle="medium"/></span> </div></td >
	                          </tr>
	  
	                        </c:forEach>
                          <tr>
                            <td colspan="2" ><div align="left"><a  href="<%=basePath %>yjssxCommon/YjssxFirstPage!showMoreInfo.action?type=1"><img src="<%=basePath%>7_yjssx_system/SubSystemImage/gif-0328.gif" border="0" width="57" height="15" /></a> </div></td>
                          </tr>
                      </table>
                      </fieldset>
                 </td>
                </tr>
              <tr>
                <td width="579" valign=top>
                  <fieldset>
                    <legend><img src="<%=basePath%>7_yjssx_system/SubSystemImage/AboutNotice.GIF" /></legend>
                        <table width="504" height="157">
                            <c:forEach items="${noticeInfo}"  var="news">
	                          <tr  bgcolor="#FFFFFF">
	                            <td width=419>
	                            	<div align="left"><img src="<%=basePath%>7_yjssx_system/SubSystemImage/sucaiwcom0566000jty.gif" width="15" height="15" />&nbsp;&nbsp;<a href="<%=basePath %>yjssxCommon/YjssxFirstPage!showInfoDetail.action?infoId=${news.FInfoId }">${news.FInfoTitle }</a>
			    	          	    	<s:if test="#t.count<=2">
		                            		<img src="<%=basePath%>7_yjssx_system/SubSystemImage/gif-0249.gif" width="28" height="14" />
		                            	</s:if>
			    	          	    </div>
			    	           </td>
	                            <td width=110><div align="left"><span id="DisplayInformation1_rbt1__ctl0_lblNewsDate1"><fmt:formatDate value="${news.FInfoStartTime}" type="date" dateStyle="medium"/></span> </div></td >
	                          </tr>
	                        </c:forEach>
                          <tr>
                            <td colspan="2" ><div align="left"><a  href="<%=basePath %>yjssxCommon/YjssxFirstPage!showMoreInfo.action?type=2"><img src="<%=basePath%>7_yjssx_system/SubSystemImage/gif-0328.gif" border="0" width="57" height="15" /></a> </div></td>
                          </tr>
                      </table>
              <tr>
                <td valign=top ><div id="DisplayInformation1_Panel3" class="dctNoBorder" style="font-size:16px;">
                  <fieldset>
                    <legend><img src="<%=basePath%>7_yjssx_system/SubSystemImage/CooperateCom.GIF" width="268" height="26" /></legend>
                        <table width="504" height="157">
                            <c:forEach items="${cooperateInfo}"  var="news">
	                          <tr  bgcolor="#FFFFFF">
	                            <td width=419>
	                            	<div align="left"><img src="<%=basePath%>7_yjssx_system/SubSystemImage/gif-0920.gif" width="13" height="13" />&nbsp;&nbsp;<a href="<%=basePath %>yjssxCommon/YjssxFirstPage!showInfoDetail.action?infoId=${news.FInfoId }">${news.FInfoTitle }</a>
	                            	</div>
	                            </td>
	                            <td width=110><div align="left"><span id="DisplayInformation1_rbt1__ctl0_lblNewsDate1"><fmt:formatDate value="${news.FInfoStartTime}" type="date" dateStyle="medium"/></span> </div></td >
	                          </tr>
	                        </c:forEach>
                          <tr>
                            <td colspan="2" ><div align="left"><a  href="<%=basePath %>yjssxCommon/YjssxFirstPage!showMoreInfo.action?type=3"><img src="<%=basePath%>7_yjssx_system/SubSystemImage/gif-0328.gif" border="0" width="57" height="15" /></a> </div></td>
                          </tr>
                      </table>
                      </fieldset>
                  </div></td>
                </tr>
              <tr>
                <td height="171" valign=top>
                  <fieldset>
                    <legend><img src="<%=basePath%>7_yjssx_system/SubSystemImage/zhaopinxinxi.GIF" /></legend>
                        <table width="504" height="157">
                        
                            <c:forEach items="${ZhaoPinInfo}"  var="news">
	                          <tr  bgcolor="#FFFFFF">
	                            <td width=419>
	                            	<div align="left"><img src="<%=basePath%>7_yjssx_system/SubSystemImage/gif-0600.gif" width="16" height="16" />&nbsp;&nbsp;<a href="<%=basePath %>yjssxCommon/YjssxFirstPage!showInfoDetail.action?infoId=${news.FInfoId }">${news.FInfoTitle }</a>
	                            		<s:if test="#t.count<=2">
		                            		<img src="<%=basePath%>7_yjssx_system/SubSystemImage/gif-0249.gif" width="28" height="14" />
		                            	</s:if>

	                            	</div>
	                            </td>
	                            <td width=110><div align="left"><span id="DisplayInformation1_rbt1__ctl0_lblNewsDate1"><fmt:formatDate value="${news.FInfoStartTime}" type="date" dateStyle="medium"/></span> </div></td >
	                          </tr>
	                       </c:forEach>
                          <tr>
                            <td colspan="2" ><div align="left"><a  href="<%=basePath %>yjssxCommon/YjssxFirstPage!showMoreInfo.action?type=4"><img src="<%=basePath%>7_yjssx_system/SubSystemImage/gif-0328.gif" border="0" width="57" height="15" /></a> </div></td>
                          </tr>
                      </table>              
            </table></td>
        </tr>
      </table>      </td>
    </tr>
  </table>
</div>
</body>
</html>

